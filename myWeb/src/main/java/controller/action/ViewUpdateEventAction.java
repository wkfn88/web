/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.board.BoardDAO;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class ViewUpdateEventAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 21 */     String boardid = request.getParameter("boardid");
/* 22 */     String title = request.getParameter("title");
/* 23 */     String content = request.getParameter("content");
/*    */ 
/* 26 */     BoardDAO dao = BoardDAO.getInstance();
/* 27 */     dao.updateBoard(boardid, title, content);
/*    */ 
/* 29 */     new ViewMoveAction().execute(request, response);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
