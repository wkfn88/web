/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.member.MemberDAO;
/*    */ import dto.member.MemberVo;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class JoinEventAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     response.setCharacterEncoding("UTF-8");
/* 21 */     response.setContentType("text/html; charset=UTF-8");
/* 22 */     PrintWriter out = response.getWriter();
/* 23 */     HttpSession session = request.getSession();
/*    */ 
/* 25 */     if (session.getAttribute("joinid") == null) {
/* 26 */       out.println("<script>");
/* 27 */       out.println("alert('아이디 중복체크를 해주십시오.')");
/* 28 */       out.println("history.back()");
/* 29 */       out.println("</script>");
/*    */     } else {
/* 31 */       String name = request.getParameter("name");
/* 32 */       String id = (String)session.getAttribute("joinid");
/* 33 */       String pwd = request.getParameter("pwd");
/* 34 */       String email = request.getParameter("email");
/*    */ 
/* 36 */       MemberDAO dao = MemberDAO.getInstance();
/* 37 */       MemberVo mVo = new MemberVo();
/*    */ 
/* 39 */       mVo.setName(name);
/* 40 */       mVo.setId(id);
/* 41 */       mVo.setPwd(pwd);
/* 42 */       mVo.setEmail(email);
/*    */ 
/* 44 */       int result = dao.insertMember(mVo);
/*    */ 
/* 46 */       if (result == 1) {
/* 47 */         session.removeAttribute("joinid");
/* 48 */         out.println("<script>");
/* 49 */         out.println("alert('회원가입을 축하합니다.')");
/* 50 */         out.println("location.href='mainServlet?command=main_move';");
/* 51 */         out.println("</script>");
/*    */       } else {
/* 53 */         session.removeAttribute("joinid");
/* 54 */         out.println("<script>");
/* 55 */         out.println("alert('데이터베이스 오류')");
/* 56 */         out.println("location.href='mainServlet?command=main_move';");
/* 57 */         out.println("</script>");
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }

