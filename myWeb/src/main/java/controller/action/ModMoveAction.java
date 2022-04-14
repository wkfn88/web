/*    */ package controller.action;
/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;
/*    */ import dto.member.MemberDAO;
/*    */ import dto.member.MemberVo;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class ModMoveAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     String url = "updateRes.jsp";
/* 21 */     HttpSession session = request.getSession();
/* 22 */     String id = (String)session.getAttribute("userid");
/*    */ 
/* 24 */     MemberVo mVo = MemberDAO.getInstance().getMember(id);
/* 25 */     request.setAttribute("member", mVo);
/*    */ 
/* 27 */     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
/* 28 */     dispatcher.forward(request, response);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }

