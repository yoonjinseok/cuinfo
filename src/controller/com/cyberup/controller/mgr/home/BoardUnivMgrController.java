package com.cyberup.controller.mgr.home;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.home.BoardUniv;
import com.cyberup.model.home.FileUpload;
import com.cyberup.service.home.BoardUnivService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.util.FileDeletor;

/*************************************************************
 * 
 * 기   능 : 게시판(CU_BOARD_UNIV)관련 기능 구현 (대학행사안내)
 * 작성자 : 오성애
 * 작성일 : 2011-10-10
 * 
 **************************************************************/
@Controller
@RequestMapping("/mgr/home")
public class BoardUnivMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private BoardUnivService boardUnivService;	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;	

	private MapValidator boardUnivUpdateValidator;
	@Inject
	protected Provider<SessionUploadConfigMap> sessionUploadConfigMap;

	@Resource(name = "boardUnivUpdateValidator")
	public void setBoardUpdateValidator(MapValidator boardUnivUpdateValidator) {
		this.boardUnivUpdateValidator = boardUnivUpdateValidator;
	}

	@RequestMapping("/boardUniv")
	public String boardUniv(ModelMap model) {		
		return null;
	}

	/************** 게시판 리스트 **************/
	@RequestMapping(value = "/boardUniv_list", method = RequestMethod.POST)
	public String list(BoardUniv boardParam, ModelMap modelMap,
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

		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();	
	
		if ((admin.getUniversityId() !=0 ) || (admin.getUniversityId() != null)){
			boardParam.setUnivID(admin.getUniversityId().toString());
		}
		
		/*System.out.println("\n\n\n\n\n\n**************************************\n");
		System.out.println("getUnivID : "+ boardParam.getUnivID());
		System.out.println("\n**************************************\n\n\n\n\n\n");
		*/
		
		List<BoardUniv> list = boardUnivService.selectList(boardParam.getShowCnt(),
				boardParam.getCurrPage(), boardParam.getSectionID(),
				boardParam.getTitle(), boardParam.getBoardContent(),
				boardParam.getRegID(), boardParam.getRegName(),
				boardParam.getUnivID(),boardParam.getEventState());
		
		modelMap.addAttribute("boardList", list);

		if (list.size() > 0)
			PagingModel.mappPages(modelMap, boardParam.getCurrPage(),
					boardParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, boardParam.getCurrPage(),
					boardParam.getShowCnt(), new PagingModel());

		return null;
	}
	
	private void putAttfileConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("hwp,doc,docx,xls,xlsx,ppt,pptx,jpg,jpeg,gif,png,pdf");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "BoardUniv" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
	}

	/************** 글 수정 초기 화면 **************/
	@RequestMapping(value = "/boardUniv_modify")
	public String modify(BoardUniv boardParm, ModelMap modelMap)
	{
		//수정하고자 하는 글을 가져온다.
		BoardUniv board = boardUnivService.selectInfo(boardParm.getBoardID());	
		modelMap.addAttribute("board",board);
		

		//파일 리스트를 가져온다.
		if(board.getUpfileGid() > 0)
		{
			modelMap.addAttribute("fileList", fileUploadService.selectList(board.getUpfileGid()));
		}
		
		putAttfileConfig();
		
		modelMap.addAttribute("upFileGid",board.getUpfileGid());
	
		
		return null;
	}
	/************** 수정 처리 기능(db 저장) **************/
	@RequestMapping(value = "/boardUniv_update", method = RequestMethod.POST)
	public String update(HttpSession session, BoardUniv boardParam, ModelMap modelMap,
			SessionStatus sessionStatus) {

		boardUnivUpdateValidator.validate(boardParam, modelMap);
		if (boardUnivUpdateValidator.hasErrors())
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
		boardUnivService.updateInfo(boardParam);

		sessionStatus.setComplete();
		return null;
	}

	/************** 글 쓰기 초기 화면 **************/
	@RequestMapping(value = "/boardUniv_write")
	public String write(ModelMap modelMap,
			@RequestParam(required = true) String gID) {

		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		modelMap.addAttribute("admin", admin);
		modelMap.addAttribute("gID", gID);
		
		putAttfileConfig();
		
		return null;
	}

	/************** 등록 처리 기능(db 저장) **************/
	@RequestMapping(value = "/boardUniv_save", method = RequestMethod.POST)
	public String save(HttpSession session, BoardUniv boardParam, ModelMap modelMap,
			SessionStatus sessionStatus) {

		boardUnivUpdateValidator.validate(boardParam, modelMap);

		if (boardUnivUpdateValidator.hasErrors())
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
		
		boardUnivService.insertInfo(boardParam);

		sessionStatus.setComplete();

		return null;
	}

	/************** 게시물 삭제처리(db) **************/
	@RequestMapping(value = "/boardUniv_delete")
	public String delete(BoardUniv boardParam, ModelMap modelMap) {
		
			
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
		boardUnivService.deleteInfo(boardParam.getBoardID());
		return null;
	}

}
