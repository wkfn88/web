/*    */ package controller.action;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
/*    */ 
/*    */ public class IdCheckMoveAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 16 */     String url = "idcheck.jsp";
/*    */ 
/* 18 */     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
/* 19 */     dispatcher.forward(request, response);
/*    */   }
/*    */

@Override
public void execute(MultipartRequest paramMultipartRequest, HttpServletResponse paramHttpServletResponse)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	
} 

/*    */ }
