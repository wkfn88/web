/*    */ package dto.board;
/*    */ 
/*    */ public class ComVo
/*    */ {
/*    */   private String comnum;
/*    */   private int boardid;
/*    */   private int commentid;
/*    */   private String id;
/*    */   private String content;
/*    */   private String comdate;
/*    */   private String commentpwd;
/*    */ 
/*    */   public String getCommentpwd()
/*    */   {
/* 13 */     return this.commentpwd;
/*    */   }
/*    */   public void setCommentpwd(String commentpwd) {
/* 16 */     this.commentpwd = commentpwd;
/*    */   }
/*    */   public String getComnum() {
/* 19 */     return this.comnum;
/*    */   }
/*    */   public void setComnum(String comnum) {
/* 22 */     this.comnum = comnum;
/*    */   }
/*    */   public int getBoardid() {
/* 25 */     return this.boardid;
/*    */   }
/*    */   public void setBoardid(int boardid) {
/* 28 */     this.boardid = boardid;
/*    */   }
/*    */   public int getCommentid() {
/* 31 */     return this.commentid;
/*    */   }
/*    */   public void setCommentid(int commentid) {
/* 34 */     this.commentid = commentid;
/*    */   }
/*    */   public String getId() {
/* 37 */     return this.id;
/*    */   }
/*    */   public void setId(String id) {
/* 40 */     this.id = id;
/*    */   }
/*    */   public String getContent() {
/* 43 */     return this.content;
/*    */   }
/*    */   public void setContent(String content) {
/* 46 */     this.content = content;
/*    */   }
/*    */   public String getComdate() {
/* 49 */     return this.comdate;
/*    */   }
/*    */   public void setComdate(String comdate) {
/* 52 */     this.comdate = comdate;
/*    */   }
/*    */ }
