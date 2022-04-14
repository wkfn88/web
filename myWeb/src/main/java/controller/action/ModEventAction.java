/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.member.MemberDAO;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class ModEventAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 19 */     HttpSession session = request.getSession();
/* 20 */     String id = (String)session.getAttribute("userid");
/* 21 */     String name = request.getParameter("name");
/* 22 */     String pwd = request.getParameter("pwd");
/* 23 */     String email = request.getParameter("eamil");
/*    */ 
/* 25 */     MemberDAO dao = MemberDAO.getInstance();
/* 26 */     int result = dao.updateMember(name, pwd, email, id);
/*    */ 
/* 28 */     RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
/*    */ 
/* 30 */     if (result == 1)
/* 31 */       request.setAttribute("modResult", "success");
/*    */     else {
/* 33 */       request.setAttribute("modResult", "fail");
/*    */     }
/*    */ 
/* 36 */     dispatcher.forward(request, response);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
