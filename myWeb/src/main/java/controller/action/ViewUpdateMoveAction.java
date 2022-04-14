/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.board.BoardDAO;
/*    */ import dto.board.BoardVo;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class ViewUpdateMoveAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 23 */     if ((request.getParameter("rnum") == null) || (!request.getParameter("rnum").equals(" "))) {
/* 24 */       response.setCharacterEncoding("utf-8");
/* 25 */       response.setContentType("text/html; charset=utf-8");
/* 26 */       PrintWriter out = response.getWriter();
/* 27 */       out.println("<script>");
/* 28 */       out.println("alert('잘못된 접근입니다.')");
/* 29 */       out.println("history.back();");
/* 30 */       out.println("</script>");
/* 31 */       return;
/*    */     }
/*    */ 
/* 34 */     String url = "";
/* 35 */     String boardid = request.getParameter("boardid");
/* 36 */     String deleteKey = request.getParameter("deleteKey");
/*    */ 
/* 38 */     BoardDAO dao = BoardDAO.getInstance();
/*    */ 
/* 40 */     if (deleteKey == null) {
/* 41 */       dao = BoardDAO.getInstance();
/* 42 */       BoardVo bVo = dao.getView(boardid);
/* 43 */       request.setAttribute("board", bVo);
/* 44 */       url = "update.jsp";
/*    */     } else {
/* 46 */       String boardpwd = dao.getBoardPwd(boardid);
/* 47 */       if (boardpwd.equals(deleteKey)) {
/* 48 */         dao = BoardDAO.getInstance();
/* 49 */         BoardVo bVo = dao.getView(boardid);
/* 50 */         request.setAttribute("board", bVo);
/* 51 */         url = "update.jsp";
/*    */       } else {
/* 53 */         request.setAttribute("updateResult", "fail");
/* 54 */         url = "result.jsp";
/*    */       }
/*    */     }
/*    */ 
/* 58 */     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
/* 59 */     dispatcher.forward(request, response);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
