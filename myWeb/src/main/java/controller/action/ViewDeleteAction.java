/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.board.BoardDAO;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class ViewDeleteAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 22 */     if ((request.getParameter("rnum") == null) || (!request.getParameter("rnum").equals(" "))) {
/* 23 */       response.setCharacterEncoding("utf-8");
/* 24 */       response.setContentType("text/html; charset=utf-8");
/* 25 */       PrintWriter out = response.getWriter();
/* 26 */       out.println("<script>");
/* 27 */       out.println("alert('잘못된 접근입니다.')");
/* 28 */       out.println("history.back();");
/* 29 */       out.println("</script>");
/* 30 */       return;
/*    */     }
/*    */ 
/* 33 */     String boardid = request.getParameter("boardid");
/* 34 */     String deleteKey = request.getParameter("deleteKey");
/*    */ 
/* 36 */     BoardDAO dao = BoardDAO.getInstance();
/*    */ 
/* 38 */     if (deleteKey == null) {
/* 39 */       dao.deleteBoard(boardid);
/* 40 */       request.setAttribute("boardResult", "success");
/*    */     } else {
/* 42 */       String boardpwd = dao.getBoardPwd(boardid);
/* 43 */       if (boardpwd.equals(deleteKey)) {
/* 44 */         dao.deleteBoard(boardid);
/* 45 */         request.setAttribute("boardResult", "success");
/*    */       } else {
/* 47 */         request.setAttribute("boardResult", "fail");
/*    */       }
/*    */     }
/*    */ 
/* 51 */     RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
/* 52 */     dispatcher.forward(request, response);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
