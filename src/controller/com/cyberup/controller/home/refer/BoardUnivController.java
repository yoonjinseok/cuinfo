package com.cyberup.controller.home.refer;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.home.BoardUniv;
import com.cyberup.service.home.BoardUnivService;
import com.cyberup.service.home.FileUploadService;

/*************************************************************
 * 
 * 기   능 : 게시판(CU_BOARD_UNIV)관련 기능 구현 (대학행사안내)
 * 작성자 : 오성애
 * 작성일 : 2011-10-10
 * 
 **************************************************************/
@Controller
@RequestMapping("/home/refer")
public class BoardUnivController {
	@Autowired
	private BoardUnivService boardUnivService;
	@Autowired
	private FileUploadService fileUploadService;

	private MapValidator boardUnivUpdateValidator;

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
			@RequestParam(required = true) String cbSearch, String searchValue1) {

		// 검색조건에 따라 제목,내용, 등록자명 으로 검색할 수 있도록 변수를세팅한다.
		if ((StringUtils.hasLength(cbSearch))
				&& (StringUtils.hasLength(searchValue1))) {
			if (cbSearch.equals("T")) {
				boardParam.setTitle(searchValue1);
			}else if(cbSearch.equals("C")){
				boardParam.setBoardContent(searchValue1);
			}else{
				boardParam.setRegName(searchValue1);
			}
		}
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n*************************\n\n");
		System.out.println("event : " + boardParam.getEventState());
		System.out.println("\n\n*************************\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		/*
		//이벤트 아이디가 넘어오지 않을 경우 1로 기본 세팅해준다.
		if(boardParam.getEventState() !=1 || boardParam.getEventState() !=2){
			boardParam.setEventState(1);			
		}*/
		
		
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

	
	/************** 글 보기 화면 **************/
	@RequestMapping(value = "/boardUniv_view")
	public String view(BoardUniv boardParm, ModelMap modelMap)
	{
		//수정하고자 하는 글을 가져온다.
		BoardUniv board = boardUnivService.selectInfo(boardParm.getBoardID());	
		modelMap.addAttribute("board",board);
		
		//파일 리스트를 가져온다.
		if(board.getUpfileGid() > 0)
		{
			modelMap.addAttribute("fileList", fileUploadService.selectList(board.getUpfileGid()));
		}
		modelMap.addAttribute("upFileGid",board.getUpfileGid());
		
		//카운트 증가
		boardUnivService.updateHitsCount(board);
	
		
		return null;
	}
	
	/************** 글 보기 화면 **************/
	@RequestMapping(value = "/boardUniv_view_header")
	public String view_header(BoardUniv boardParm, ModelMap modelMap)
	{
		System.out.println("-----------------------");
		System.out.println(boardParm.getSearchText());
		System.out.println(boardParm.getSearchText());
		System.out.println(boardParm.getSearchText());
		System.out.println(boardParm.getSearchText());
		System.out.println("-----------------------");
		
		try {
			modelMap.addAttribute("searchText", URLDecoder.decode(boardParm.getSearchText(),"UTF-8"));		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//수정하고자 하는 글을 가져온다.
		BoardUniv board = boardUnivService.selectInfo(boardParm.getBoardID());	
		modelMap.addAttribute("board",board);
		
		//파일 리스트를 가져온다.
		if(board.getUpfileGid() > 0)
		{
			modelMap.addAttribute("fileList", fileUploadService.selectList(board.getUpfileGid()));
		}
		modelMap.addAttribute("upFileGid",board.getUpfileGid());
		
		//카운트 증가
		boardUnivService.updateHitsCount(board);
		
		
		return "/home/refer/boardUniv_header.vm";
	}

}
