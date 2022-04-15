package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import dto.board.BoardDAO;
import dto.board.BoardVo;

public class BoardMoveAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board.jsp";

		BoardDAO dao = BoardDAO.getInstance();
		int pageCount = dao.getListSize() / 10;
		if( pageCount == 0 ) {
			pageCount = 1;
		}
		int pageNumber = 1;

		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		List<BoardVo> list = dao.getList(pageNumber);
		boolean nextPage = dao.nextPage(pageNumber + 1);

		if (nextPage) {
			request.setAttribute("next", nextPage);
		}
		
		if (dao.getListSize() % 10 == 0) {
			request.setAttribute("pageCount", pageCount);
		} else {
			request.setAttribute("pageCount", pageCount + 1);
		}

		if (list.size() == 0)
			request.setAttribute("boardList", null);
		else {
			request.setAttribute("boardList", list);
		}

		request.setAttribute("pageNumber", Integer.valueOf(pageNumber));
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	@Override
	public void execute(MultipartRequest paramMultipartRequest, HttpServletResponse paramHttpServletResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
