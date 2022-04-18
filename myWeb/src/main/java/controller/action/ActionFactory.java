/*    */ package controller.action;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class ActionFactory
/*    */ {
/*  4 */   private static ActionFactory instance = new ActionFactory();
/*    */ 
/*    */   public static ActionFactory getInstance()
/*    */   {
/*  9 */     return instance;
/*    */   }
/*    */ 
/*    */   public Action getAction(String command) {
/* 13 */     Action action = null;
/* 14 */     System.out.println("ActionFactory : " + command);
/* 15 */     if (command.equals("login_move"))
/* 16 */       action = new LoginMoveAction();
/* 17 */     else if (command.equals("main_move"))
/* 18 */       action = new MainMoveAction();
/* 19 */     else if (command.equals("board_move"))
/* 20 */       action = new BoardMoveAction();
/* 21 */     else if (command.equals("login_event_action"))
/* 22 */       action = new LoginEventAction();
/* 23 */     else if (command.equals("write_move"))
/* 24 */       action = new WriteMoveAction();
/* 25 */     else if (command.equals("write_event"))
/* 26 */       action = new WriteEventAction();
/* 27 */     else if (command.equals("join_move"))
/* 28 */       action = new JoinMoveAction();
/* 29 */     else if (command.equals("view_move"))
/* 30 */       action = new ViewMoveAction();
/* 31 */     else if (command.equals("view_event_action"))
/* 32 */       action = new ViewEventAction();
/* 33 */     else if (command.equals("comment_delete"))
/* 34 */       action = new CommentDeleteAction();
/* 35 */     else if (command.equals("view_delete"))
/* 36 */       action = new ViewDeleteAction();
/* 37 */     else if (command.equals("view_update"))
/* 38 */       action = new ViewUpdateMoveAction();
/* 39 */     else if (command.equals("view_update_event"))
/* 40 */       action = new ViewUpdateEventAction();
/* 41 */     else if (command.equals("logout_action"))
/* 42 */       action = new LogoutAction();
/* 43 */     else if (command.equals("search_id"))
/* 44 */       action = new SearchIdAction();
/* 45 */     else if (command.equals("join_event"))
/* 46 */       action = new JoinEventAction();
/* 47 */     else if (command.equals("id_check_pass"))
/* 48 */       action = new IdCheckMoveAction();
/* 49 */     else if (command.equals("modification_move"))
/* 50 */       action = new ModMoveAction();
/* 51 */     else if (command.equals("modification_event")) {
/* 52 */       action = new ModEventAction();
/*    */     }else if(command.equals("rec_event")) {
				action = new RecEventAction();
			 }
/* 54 */     return action;
/*    */   }
/*    */ }

