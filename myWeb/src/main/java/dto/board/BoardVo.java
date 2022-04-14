/*    */ package dto.board;
/*    */ 
/*    */ public class BoardVo
/*    */ {
/*    */   private int boardid;
/*    */   private String id;
/*    */   private String boardpwd;
/*    */   private String title;
/*    */   private String content;
/*    */   private String boarddate;
/*    */   private int boardstatus;
/*    */   private int viewcount;
/*    */   private int commentsize;
/*    */ 
/*    */   public int getCommentsize()
/*    */   {
/* 15 */     return this.commentsize;
/*    */   }
/*    */   public void setCommentsize(int commentsize) {
/* 18 */     this.commentsize = commentsize;
/*    */   }
/*    */   public int getViewcount() {
/* 21 */     return this.viewcount;
/*    */   }
/*    */   public String getBoardpwd() {
/* 24 */     return this.boardpwd;
/*    */   }
/*    */   public void setBoardpwd(String boardpwd) {
/* 27 */     this.boardpwd = boardpwd;
/*    */   }
/*    */   public void setViewcount(int viewcount) {
/* 30 */     this.viewcount = viewcount;
/*    */   }
/*    */   public int getBoardid() {
/* 33 */     return this.boardid;
/*    */   }
/*    */   public void setBoardid(int boardid) {
/* 36 */     this.boardid = boardid;
/*    */   }
/*    */   public String getId() {
/* 39 */     return this.id;
/*    */   }
/*    */   public void setId(String id) {
/* 42 */     this.id = id;
/*    */   }
/*    */   public String getTitle() {
/* 45 */     return this.title;
/*    */   }
/*    */   public void setTitle(String title) {
/* 48 */     this.title = title;
/*    */   }
/*    */   public String getContent() {
/* 51 */     return this.content;
/*    */   }
/*    */   public void setContent(String content) {
/* 54 */     this.content = content;
/*    */   }
/*    */   public String getBoarddate() {
/* 57 */     return this.boarddate;
/*    */   }
/*    */   public void setBoarddate(String boarddate) {
/* 60 */     this.boarddate = boarddate;
/*    */   }
/*    */   public int getBoardstatus() {
/* 63 */     return this.boardstatus;
/*    */   }
/*    */   public void setBoardstatus(int boardstatus) {
/* 66 */     this.boardstatus = boardstatus;
/*    */   }
/*    */ }
