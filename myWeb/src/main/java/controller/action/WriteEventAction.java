/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.board.BoardDAO;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class WriteEventAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 18 */     HttpSession session = request.getSession();
/*    */ 
/* 20 */     String url = "mainServlet?command=board_move&pageNumber=1";
/* 21 */     String id = null;
/* 22 */     if (session.getAttribute("userid") != null) {
/* 23 */       id = (String)session.getAttribute("userid");
/*    */     }
/* 25 */     else if ((request.getParameter("id") == null) || (request.getParameter("id").equals("")))
/* 26 */       id = "익명 사용자";
/*    */     else {
/* 28 */       id = request.getParameter("id");
/*    */     }
/*    */ 
/* 31 */     String title = request.getParameter("title");
/* 32 */     String content = request.getParameter("content");
/* 33 */     String boardpwd = request.getParameter("boardpwd");
/* 34 */     request.setAttribute("pageNumber", Integer.valueOf(1));
/*    */ 
/* 36 */     BoardDAO dao = BoardDAO.getInstance();
/* 37 */     dao.writeBoard(id, title, boardpwd, content);
/*    */ 
/* 39 */     response.sendRedirect(url);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
