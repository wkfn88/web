/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class LogoutAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 17 */     String url = "main.jsp";
/*    */ 
/* 19 */     HttpSession session = request.getSession();
/* 20 */     session.invalidate();
/*    */ 
/* 22 */     response.sendRedirect(url);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
