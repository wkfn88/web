/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.member.MemberDAO;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class LoginEventAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 19 */     String id = request.getParameter("userid");
/* 20 */     String pw = request.getParameter("userpw");
/*    */ 
/* 22 */     MemberDAO dao = MemberDAO.getInstance();
/* 23 */     String result = dao.loginMember(id);
/* 24 */     System.out.println(result);
/* 25 */     if (result == null) {
/* 26 */       request.setAttribute("loginError", "계정이 존재하지 않습니다.");
/* 27 */       new LoginMoveAction().execute(request, response);
/* 28 */     } else if (pw.equals(result)) {
/* 29 */       HttpSession session = request.getSession();
/* 30 */       session.setAttribute("userid", id);
/* 31 */       new MainMoveAction().execute(request, response);
/*    */     } else {
/* 33 */       request.setAttribute("loginError", "비밀번호가 틀립니다.");
/* 34 */       new LoginMoveAction().execute(request, response);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
