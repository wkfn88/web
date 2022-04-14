/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.member.MemberDAO;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class SearchIdAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 19 */     response.setCharacterEncoding("UTF-8");
/* 20 */     response.setContentType("text/html; charset=UTF-8");
/* 21 */     PrintWriter out = response.getWriter();
/* 22 */     MemberDAO dao = MemberDAO.getInstance();
/* 23 */     String id = request.getParameter("id");
/* 24 */     int result = dao.searchId(id);
/*    */ 
/* 26 */     if (result == 1) {
/* 27 */       out.println("<script>");
/* 28 */       out.println("alert('사용중인 아이디입니다.')");
/* 29 */       out.println("history.back()");
/* 30 */       out.println("</script>");
/*    */     } else {
/* 32 */       HttpSession session = request.getSession();
/* 33 */       session.setAttribute("joinid", id);
/* 34 */       out.println("<script>");
/* 35 */       out.println("alert('사용가능한 아이디입니다.')");
/* 36 */       out.println("history.back()");
/* 37 */       out.println("</script>");
/*    */     }
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }

