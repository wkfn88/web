/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class JoinMoveAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 16 */     String url = "join.jsp";
/*    */ 
/* 18 */     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
/* 19 */     dispatcher.forward(request, response);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
