package com.cyberup.controller.mgr.home;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MailSender;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.home.Board;
import com.cyberup.model.home.FileUpload;
import com.cyberup.service.home.BoardService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.util.FileDeletor;

/*************************************************************
 * 
 * 기   능 : 게시판(CU_BOARD)관련 기능 구현 (원격대학협의회동정,연구/교육 자료,공지사항) 
 * 작성자 : 오성애 
 * 작성일 : 2011-10-10
 * 
 **************************************************************/
@Controller
@RequestMapping("/mgr/home")
public class BoardMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator boardUpdateValidator;
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private MailSender mailSender;

	@Autowired
	private FileUploadService fileUploadService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	protected Provider<SessionUploadConfigMap> sessionUploadConfigMap;
	

	@Resource(name = "boardUpdateValidator")
	public void setBoardUpdateValidator(MapValidator boardUpdateValidator) {
		this.boardUpdateValidator = boardUpdateValidator;
	}

	@RequestMapping("/board")
	public String board(ModelMap model,
						@RequestParam(required = true) String gID) {
		
		
		//원격대학협의회 동정 152, 연구/교육자료 153, 공지사항 154
		if(!(gID.equals("152") || gID.equals("153") || gID.equals("154"))) gID = "152";
		
		model.addAttribute("gID", gID);
		
		return null;
	}

	/************** 게시판 리스트 **************/
	@RequestMapping(value = "/board_list", method = RequestMethod.POST)
	public String list(Board boardParam, ModelMap modelMap,
			@RequestParam(required = true) String rdSearch1, String rdSearch2,
			String searchValue1, String searchValue2) {

		// 검색조건에 따라 내용/제목으로 검색할 수 있도록 변수를세팅한다.
		if ((StringUtils.hasLength(rdSearch1))
				&& (StringUtils.hasLength(searchValue1))) {
			if (rdSearch1.equals("T")) {
				boardParam.setTitle(searchValue1);
			} else {
				boardParam.setBoardContent(searchValue1);
			}
		}
		
		if ((StringUtils.hasLength(rdSearch2))
				&& (StringUtils.hasLength(searchValue2))) {
			if (rdSearch2.equals("N")) { //성명
				boardParam.setRegName(searchValue2);
			} else {
				boardParam.setRegID(searchValue2);
			}
		}
		

		List<Board> list = boardService.selectList(boardParam.getShowCnt(),
				boardParam.getCurrPage(), boardParam.getGubunID(),
				boardParam.getTitle(), boardParam.getBoardContent(),
				boardParam.getRegID(), boardParam.getRegName());
		modelMap.addAttribute("boardList", list);

		if (list.size() > 0)
			PagingModel.mappPages(modelMap, boardParam.getCurrPage(),
					boardParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, boardParam.getCurrPage(),
					boardParam.getShowCnt(), new PagingModel());
		
		/*Logger logger = Logger.getLogger(this.getClass());
		
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = 
			     new MimeMessageHelper(mimeMessage,true,"euc-kr");
			   msgHelper.setSubject("메일 첨부파일 테스트");
			   String htmlContent = 
			     "<h2 style='color:red;'>테스트입니다.</h3>";
			   msgHelper.setText(htmlContent, true);//true-->html
			   msgHelper.setFrom("chyungwo@naver.com","스미스");
			   msgHelper.setTo(new String[]{"chyungwon@nate.com"});
			   
			   logger.debug(mailSender);
			   logger.debug(mailSender.getJavaMailSender());

				mailSender.getJavaMailSender().send(mimeMessage);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}*/

		return null;
	}

	/************** 글 수정 초기 화면 **************/
	@RequestMapping(value = "/board_modify")
	public String modify(Board boardParm, ModelMap modelMap)
	{
		
		LoginUser login = loginInfoProvider.get().currentUser();		
		modelMap.addAttribute("login", login);
		
		//수정하고자 하는 글을 가져온다.
		Board board = boardService.selectInfo(boardParm.getBoardID());	
		modelMap.addAttribute("board",board);
		
		//파일 리스트를 가져온다.
		if(board.getUpfileGid() > 0)
		{
			modelMap.addAttribute("fileList", fileUploadService.selectList(board.getUpfileGid()));
		}
		
		putAttfileConfig();
	
		
		return null;
	}
	
	private void putAttfileConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("hwp,doc,docx,xls,xlsx,ppt,pptx,jpg,jpeg,gif,png,pdf,zip");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "Board" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
	}
	
	/************** 수정 처리 기능(db 저장) **************/
	@RequestMapping(value = "/board_update", method = RequestMethod.POST)
	public String update(HttpSession session, Board boardParam, ModelMap modelMap,
			SessionStatus sessionStatus) {

		boardUpdateValidator.validate(boardParam, modelMap);
		if (boardUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		boardParam.setModID(login.getUserId());

		if(boardParam.getUpfileSrc() != null && boardParam.getUpfileSrc().length > 0)
		{
			if(boardParam.getUpfileGid() == 0)
				boardParam.setUpfileGid(fileUploadService.selectGroupKey());
			
			for(int i = 0; i < boardParam.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(boardParam.getUpfileSrc()[i]);
				String original = (String)session.getAttribute(boardParam.getUpfileSrc()[i] + "OriginalFilename");
				
				FileUpload fileUpload = new FileUpload();
				fileUpload.setUpfileGid(boardParam.getUpfileGid());
				fileUpload.setUpfileFilename(original);
				fileUpload.setUpfilePath(path);
				fileUpload.setUpfileRegister(login.getUserId());
				fileUpload.setUpfileSize(new File(path).length());
				fileUpload.setUpfileSource(boardParam.getUpfileSrc()[i]);
				fileUploadService.insertInfo(fileUpload);
			}
		}

		// 게시판 정보 업데이트
		boardService.updateInfo(boardParam);

		sessionStatus.setComplete();
		return null;
	}

	/************** 글 쓰기 초기 화면 **************/
	@RequestMapping(value = "/board_write")
	public String write(ModelMap modelMap,
			@RequestParam(required = true) String gID) {

/*		LoginUser login = loginInfoProvider.get().currentUser();
		modelMap.addAttribute("login", login);*/
		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		modelMap.addAttribute("admin", admin);
	
		modelMap.addAttribute("gID", gID);
		
		putAttfileConfig();
		
		return null;
	}

	/************** 등록 처리 기능(db 저장) **************/
	@RequestMapping(value = "/board_save", method = RequestMethod.POST)
	public String save(HttpSession session, Board boardParam, ModelMap modelMap,
			SessionStatus sessionStatus) {
		
		boardUpdateValidator.validate(boardParam, modelMap);

		if (boardUpdateValidator.hasErrors())
			return null;
		
	

		LoginUser login = loginInfoProvider.get().currentUser();
		boardParam.setRegID(login.getUserId());

		if(boardParam.getUpfileSrc() != null && boardParam.getUpfileSrc().length > 0)
		{
			boardParam.setUpfileGid(fileUploadService.selectGroupKey());
			for(int i = 0; i < boardParam.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(boardParam.getUpfileSrc()[i]);
				String original = (String)session.getAttribute(boardParam.getUpfileSrc()[i] + "OriginalFilename");
				
				FileUpload fileUpload = new FileUpload();
				fileUpload.setUpfileGid(boardParam.getUpfileGid());
				fileUpload.setUpfileFilename(original);
				fileUpload.setUpfilePath(path);
				fileUpload.setUpfileRegister(login.getUserId());
				fileUpload.setUpfileSize(new File(path).length());
				fileUpload.setUpfileSource(boardParam.getUpfileSrc()[i]);
				fileUploadService.insertInfo(fileUpload);
			}
		}
		
		boardService.insertInfo(boardParam);

		sessionStatus.setComplete();

		return null;
	}

	/************** 게시물 삭제처리(db) **************/
	@RequestMapping(value = "/board_delete")
	public String delete(Board boardParam, ModelMap modelMap) {
		
		if(boardParam.getUpfileGid() > 0)
		{
			List<FileUpload> files = fileUploadService.selectList(boardParam.getUpfileGid());
			for(int i = 0; i < files.size(); i++)
			{
				new FileDeletor(new File(files.get(i).getUpfilePath())).start();
			}
			
			fileUploadService.deleteList(boardParam.getUpfileGid());
		}
		
		//글 삭제 
		boardService.deleteInfo(boardParam.getBoardID());
		
		return null;
	}
}
