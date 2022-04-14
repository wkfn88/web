/*    */ package controller;
/*    */ 
/*    */ import controller.action.Action;
/*    */ import controller.action.ActionFactory;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ @WebServlet({"/mainServlet"})
/*    */ public class ConServlet extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 33 */     request.setCharacterEncoding("utf-8");
/*    */ 
/* 35 */     String command = request.getParameter("command");
/* 36 */     ActionFactory af = ActionFactory.getInstance();
/* 37 */     Action action = null;
/*    */ 
/* 39 */     if (command != null) {
/* 40 */       action = af.getAction(command);
/* 41 */       if (action != null) action.execute(request, response);
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 52 */     doGet(request, response);
/*    */   }
/*    */ }
