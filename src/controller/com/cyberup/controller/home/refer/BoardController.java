package com.cyberup.controller.home.refer;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.home.Board;
import com.cyberup.service.home.BoardService;
import com.cyberup.service.home.FileUploadService;

/*************************************************************
 * 
 * 기   능 : 게시판(CU_BOARD)관련 기능 구현 (원격대학협의회동정,연구/교육 자료,공지사항) 
 * 작성자 : 오성애 
 * 작성일 : 2011-10-10
 * 
 **************************************************************/
@Controller
@RequestMapping("/home/refer")
public class BoardController {

	@Autowired
	private BoardService boardService;	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/board")
	public String board(Board boardParam, ModelMap model, String cbSearch, String searchValue1, String gID) {
		
		boardParam.setGubunID(gID);
		
		//원격대학협의회 동정 152, 연구/교육자료 153, 공지사항 154
		if(!(gID.equals("152") || gID.equals("153") || gID.equals("154"))) gID = "152";
		
		model.addAttribute("gID", gID);
		
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
		
		List<Board> list = boardService.selectList(boardParam.getShowCnt(),
				boardParam.getCurrPage(), boardParam.getGubunID(),
				boardParam.getTitle(), boardParam.getBoardContent(),
				boardParam.getRegID(), boardParam.getRegName());		
		model.addAttribute("boardList", list);
		model.addAttribute("gID",boardParam.getGubunID());
		
		if (list.size() > 0)
			PagingModel.mappPages(model, boardParam.getCurrPage(),
					boardParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, boardParam.getCurrPage(),
					boardParam.getShowCnt(), new PagingModel());

		return null;
		
	}
	
	/************** 게시판 리스트 **************/
	@RequestMapping(value = "/board_list", method = RequestMethod.POST)
	public String list(Board boardParam, ModelMap modelMap,
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
		
		List<Board> list = boardService.selectList(boardParam.getShowCnt(),
				boardParam.getCurrPage(), boardParam.getGubunID(),
				boardParam.getTitle(), boardParam.getBoardContent(),
				boardParam.getRegID(), boardParam.getRegName());		
		modelMap.addAttribute("boardList", list);
		modelMap.addAttribute("gID",boardParam.getGubunID());
		
		if (list.size() > 0)
			PagingModel.mappPages(modelMap, boardParam.getCurrPage(),
					boardParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, boardParam.getCurrPage(),
					boardParam.getShowCnt(), new PagingModel());

		return null;
	}

	/************** 글 보기 화면 **************/
	@RequestMapping(value = "/board_view")
	public String view(Board boardParm, ModelMap modelMap)
	{
		//카운트 증가
		boardService.updateHitsCount(boardParm);
		
		//수정하고자 하는 글을 가져온다.
		Board board = boardService.selectInfo(boardParm.getBoardID());	
		modelMap.addAttribute("board",board);
		
		//파일 리스트를 가져온다.
		if(board.getUpfileGid() > 0)
		{
			modelMap.addAttribute("fileList", fileUploadService.selectList(board.getUpfileGid()));
		}
		modelMap.addAttribute("upFileGid",board.getUpfileGid());
		return null;
	}
	
	/************** 글 보기 화면 **************/
	@RequestMapping(value = "/board_view_header")
	public String view_header(Board boardParm, ModelMap modelMap)
	{
		try {
			modelMap.addAttribute("searchText",URLDecoder.decode(boardParm.getSearchText(),"UTF-8"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//수정하고자 하는 글을 가져온다.
		Board board = boardService.selectInfo(boardParm.getBoardID());	
		modelMap.addAttribute("board",board);
		
		if(board.getUpfileGid() > 0)
		{
			modelMap.addAttribute("fileList", fileUploadService.selectList(board.getUpfileGid()));
		}
		modelMap.addAttribute("upFileGid",board.getUpfileGid());
		
		
		//카운트 증가
		boardService.updateHitsCount(board);
		
		
		return "/home/refer/board_header.vm";
	}

}
