/*    */ package controller.action;
/*    */ 
/*    */ import dto.board.BoardDAO;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
/*    */ 
/*    */ public class CommentDeleteAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     if ((request.getParameter("rnum") == null) || (!request.getParameter("rnum").equals(" "))) {
/* 21 */       response.setCharacterEncoding("utf-8");
/* 22 */       response.setContentType("text/html; charset=utf-8");
/* 23 */       PrintWriter out = response.getWriter();
/* 24 */       out.println("<script>");
/* 25 */       out.println("alert('잘못된 접근입니다.')");
/* 26 */       out.println("history.back();");
/* 27 */       out.println("</script>");
/* 28 */       return;
/*    */     }
/*    */ 
/* 31 */     String boardid = request.getParameter("boardid");
/* 32 */     String comnum = request.getParameter("comnum");
/* 33 */     String deleteKey = request.getParameter("deleteKey");
/*    */ 
/* 35 */     String url = "";
/* 36 */     System.out.println("compwd : " + comnum);
/* 37 */     BoardDAO dao = BoardDAO.getInstance();
/* 38 */     String comPwd = dao.getCommentPwd(comnum);
/*    */ 
/* 40 */     if (deleteKey == null) {
/* 41 */       dao.deleteComment(comnum);
/* 42 */       url = "mainServlet?command=view_move&boardid=" + boardid;
/*    */     }
/* 44 */     else if (comPwd.equals(deleteKey)) {
/* 45 */       dao.deleteComment(comnum);
/* 46 */       url = "mainServlet?command=view_move&boardid=" + boardid;
/*    */     } else {
/* 48 */       url = "result.jsp";
/* 49 */       request.setAttribute("commentResult", "fail");
/*    */     }
/*    */ 
/* 53 */     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
/* 54 */     dispatcher.forward(request, response);
/*    */   }
/*    */

@Override
public void execute(MultipartRequest paramMultipartRequest, HttpServletResponse paramHttpServletResponse)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	
} 

/*    */ }
