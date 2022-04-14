/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.board.BoardDAO;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class BoardMoveAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     String url = "board.jsp";
/* 21 */     BoardDAO dao = BoardDAO.getInstance();
/* 22 */     int pageCount = dao.getListSize() / 10 + 1;
/*    */ 
/* 24 */     int pageNumber = 1;
/*    */ 
/* 26 */     if (request.getParameter("pageNumber") != null) {
/* 27 */       pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
/*    */     }
/*    */ 
/* 30 */     List list = dao.getList(pageNumber);
/* 31 */     boolean nextPage = dao.nextPage(pageNumber + 1);
/*    */ 
/* 33 */     if (nextPage) {
/* 34 */       request.setAttribute("next", Integer.valueOf(pageNumber + 1));
/*    */     }
/*    */ 
/* 37 */     if (list.size() == 0)
/* 38 */       request.setAttribute("boardList", null);
/*    */     else {
/* 40 */       request.setAttribute("boardList", list);
/*    */     }
/*    */ 
/* 43 */     request.setAttribute("pageCount", Integer.valueOf(pageCount));
/* 44 */     request.setAttribute("pageNumber", Integer.valueOf(pageNumber));
/* 45 */     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
/* 46 */     dispatcher.forward(request, response);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
