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
/*    */ public class ViewEventAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 19 */     String url = "";
/* 20 */     HttpSession session = request.getSession();
/*    */ 
/* 22 */     String id = (String)session.getAttribute("userid");
/* 23 */     String boardid = request.getParameter("boardid");
/* 24 */     String content = request.getParameter("content");
/* 25 */     String commentPwd = request.getParameter("commentpwd");
/*    */ 
/* 27 */     url = "mainServlet?command=view_move&boardid=" + boardid;
/*    */ 
/* 29 */     BoardDAO dao = BoardDAO.getInstance();
/*    */ 
/* 31 */     if (session.getAttribute("userid") != null) {
/* 32 */       dao.insertComment(boardid, id, content, "0000");
/*    */     }
/*    */     else {
/* 35 */       dao.insertComment(boardid, id, content, commentPwd);
/*    */     }
/*    */ 
/* 40 */     response.sendRedirect(url);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }

