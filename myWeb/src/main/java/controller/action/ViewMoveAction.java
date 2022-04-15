/*    */ package controller.action;
/*    */ import java.io.IOException;
/*    */ import java.util.List;

/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;

/*    */ 
/*    */ import com.oreilly.servlet.MultipartRequest;

/*    */ import dto.board.BoardDAO;
/*    */ import dto.board.BoardVo;
import dto.board.ComVo;
/*    */ import dto.member.MemberDAO;
/*    */ import dto.member.MemberVo;
/*    */ 
/*    */ public class ViewMoveAction
/*    */   implements Action
/*    */ {
/*    */   public void execute(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 25 */     String url = "view.jsp";
/* 26 */     String boardid = request.getParameter("boardid");
/*    */ 
/* 28 */     BoardDAO dao = BoardDAO.getInstance();
/* 29 */     BoardVo bVo = dao.getView(boardid);
/*    */ 
/* 31 */     dao.updateBoardViewCount(boardid);
/* 32 */     List<ComVo> list = dao.getComList(boardid);
/*    */ 
/*    */ 
/* 44 */     request.setAttribute("board", bVo);
/* 45 */     if (list.size() == 0)
/* 46 */       request.setAttribute("comment", null);
/*    */     else {
/* 48 */       request.setAttribute("comment", list);
/*    */     }
/*    */ 
/* 51 */     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
/* 52 */     dispatcher.forward(request, response);
/*    */   }
/*    */ 
/*    */   public void execute(MultipartRequest multpartRequest, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/*    */   }
/*    */ }
