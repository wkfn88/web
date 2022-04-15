package controller.action;

import com.oreilly.servlet.MultipartRequest;
import dto.board.BoardDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WriteEventAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String url = "mainServlet?command=board_move&pageNumber=1";
		String id = null;
		int boardStatus = 0;
		
		if (session.getAttribute("userid") != null) {
			id = (String) session.getAttribute("userid");
			boardStatus = 1;
		} else if ((request.getParameter("id") == null) || (request.getParameter("id").equals(""))) {
			id = "익명 사용자";
			boardStatus = 0;
		}else {
			id = request.getParameter("id");
			boardStatus = 0;
		}

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String boardpwd = request.getParameter("boardpwd");
		request.setAttribute("pageNumber", Integer.valueOf(1));

		BoardDAO dao = BoardDAO.getInstance();
		
		dao.writeBoard(id, title, boardpwd, content, boardStatus);

		response.sendRedirect(url);
	}

	public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
