package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dto.board.BoardDAO;

public class RecEventAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userid") == null) {
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.')");
			out.println("history.back();");
			out.println("</script>");
			return;
		}
		
		String id = request.getParameter("id");
		String boardid = request.getParameter("boardid");
		int status = Integer.parseInt(request.getParameter("status"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.recommend(id, boardid, status);
		
		if(result != -1 ) {
			String url = "mainServlet?command=view_move&boardid=" + boardid;
			response.sendRedirect(url);
		}else {
			out.println("<script>");
			out.println("alert('이미 추천/비추천을 하셨습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
		
	}

	@Override
	public void execute(MultipartRequest paramMultipartRequest, HttpServletResponse paramHttpServletResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
