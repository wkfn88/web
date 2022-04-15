/*     */ package dto.board;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import util.DBManager;
/*     */ 
/*     */ public class BoardDAO
/*     */ {
/*  12 */   private static BoardDAO instance = new BoardDAO();
/*     */ 
/*     */   public static BoardDAO getInstance()
/*     */   {
/*  17 */     return instance;
/*     */   }
/*     */ 
/*     */   public int getNext() {
/*  21 */     String sql = "SELECT boardid FROM board ORDER BY boardid desc";
/*  22 */     Connection conn = null;
/*  23 */     PreparedStatement pstmt = null;
/*  24 */     ResultSet rs = null;
/*     */     try {
/*  26 */       conn = DBManager.getConnection();
/*  27 */       pstmt = conn.prepareStatement(sql);
/*  28 */       rs = pstmt.executeQuery();
/*  29 */       if (rs.next()) {
/*  30 */         return rs.getInt(1) + 1;
/*     */       }
/*  32 */       return 1;
/*     */     } catch (Exception e) {
/*  34 */       e.printStackTrace();
/*     */     } finally {
/*  36 */       DBManager.close(conn, pstmt);
/*     */     }
/*  38 */     return -1;
/*     */   }
/*     */ 
/*     */   public boolean nextPage(int pageNumber) {
/*  42 */     String sql = "SELECT * FROM board WHERE boardid < ?";
/*  43 */     Connection conn = null;
/*  44 */     PreparedStatement pstmt = null;
/*  45 */     ResultSet rs = null;
/*     */     try
/*     */     {
/*  48 */       conn = DBManager.getConnection();
/*  49 */       pstmt = conn.prepareStatement(sql);
/*  50 */       pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
/*  51 */       rs = pstmt.executeQuery();
/*     */ 
/*  53 */       if (rs.next())
/*  54 */         return true;
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       e.printStackTrace();
/*     */     } finally {
/*  59 */       DBManager.close(conn, pstmt, rs); } DBManager.close(conn, pstmt, rs);
/*     */ 
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int insertComment(String boardid, String id, String content, String commentPwd) {
/*  65 */     String sql = "INSERT INTO comment VALUES(?, ?, ?, ?, ?, ?, default)";
/*  66 */     Connection conn = null;
/*  67 */     PreparedStatement pstmt = null;
/*     */ 
/*  69 */     String comnum = boardid + getCommentNext(boardid);
/*     */     try {
/*  71 */       conn = DBManager.getConnection();
/*  72 */       pstmt = conn.prepareStatement(sql);
/*  73 */       pstmt.setString(1, comnum);
/*  74 */       pstmt.setString(2, boardid);
/*  75 */       pstmt.setInt(3, getCommentNext(boardid));
/*  76 */       pstmt.setString(4, id);
/*  77 */       pstmt.setString(5, content);
/*  78 */       pstmt.setString(6, commentPwd);
/*     */ 
/*  80 */       return pstmt.executeUpdate();
/*     */     } catch (Exception e) {
/*  82 */       e.printStackTrace();
/*     */     } finally {
/*  84 */       DBManager.close(conn, pstmt);
/*     */     }
/*     */ 
/*  87 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getCommentNext(String boardid) {
/*  91 */     String sql = "SELECT commentid FROM comment WHERE boardid=? ORDER BY commentid desc";
/*  92 */     Connection conn = null;
/*  93 */     PreparedStatement pstmt = null;
/*  94 */     ResultSet rs = null;
/*     */     try {
/*  96 */       conn = DBManager.getConnection();
/*  97 */       pstmt = conn.prepareStatement(sql);
/*  98 */       pstmt.setString(1, boardid);
/*  99 */       rs = pstmt.executeQuery();
/*     */ 
/* 101 */       if (rs.next()) {
/* 102 */         return rs.getInt(1) + 1;
/*     */       }
/*     */ 
/* 105 */       return 1;
/*     */     } catch (Exception e) {
/* 107 */       e.printStackTrace();
/*     */     } finally {
/* 109 */       DBManager.close(conn, pstmt);
/*     */     }
/* 111 */     return -1;
/*     */   }
/*     */ 
/*     */   public int deleteComment(String comnum) {
/* 115 */     String sql = "DELETE FROM comment WHERE comnum=?";
/* 116 */     Connection conn = null;
/* 117 */     PreparedStatement pstmt = null;
/*     */     try {
/* 119 */       conn = DBManager.getConnection();
/* 120 */       pstmt = conn.prepareStatement(sql);
/* 121 */       pstmt.setString(1, comnum);
/* 122 */       return pstmt.executeUpdate();
/*     */     } catch (Exception e) {
/* 124 */       e.printStackTrace();
/*     */     } finally {
/* 126 */       DBManager.close(conn, pstmt);
/*     */     }
/* 128 */     return -1;
/*     */   }
/*     */ 
/*     */   public int deleteBoard(String boardid) {
/* 132 */     String sql1 = "DELETE FROM comment WHERE boardid=?";
/* 133 */     String sql2 = "DELETE FROM board WHERE boardid=?";
/* 134 */     Connection conn = null;
/* 135 */     PreparedStatement pstmt = null;
/*     */     try {
/* 137 */       conn = DBManager.getConnection();
/* 138 */       pstmt = conn.prepareStatement(sql1);
/* 139 */       pstmt.setString(1, boardid);
/* 140 */       pstmt.executeUpdate();
/* 141 */       pstmt.close();
/*     */ 
/* 143 */       pstmt = conn.prepareStatement(sql2);
/* 144 */       pstmt.setString(1, boardid);
/* 145 */       return pstmt.executeUpdate();
/*     */     } catch (Exception e) {
/* 147 */       e.printStackTrace();
/*     */     } finally {
/* 149 */       DBManager.close(conn, pstmt);
/*     */     }
/* 151 */     return -1;
/*     */   }
/*     */ 
/*     */   public int updateBoard(String boardid, String title, String content) {
/* 155 */     String sql = "UPDATE board SET title=?, content=? WHERE boardid=?";
/* 156 */     Connection conn = null;
/* 157 */     PreparedStatement pstmt = null;
/*     */     try {
/* 159 */       conn = DBManager.getConnection();
/* 160 */       pstmt = conn.prepareStatement(sql);
/* 161 */       pstmt.setString(1, title);
/* 162 */       pstmt.setString(2, content);
/* 163 */       pstmt.setString(3, boardid);
/* 164 */       return pstmt.executeUpdate();
/*     */     } catch (Exception e) {
/* 166 */       e.printStackTrace();
/*     */     } finally {
/* 168 */       DBManager.close(conn, pstmt);
/*     */     }
/* 170 */     return -1;
/*     */   }
/*     */ 
/*     */   public int updateBoardViewCount(String boardid) {
/* 174 */     String sql = "UPDATE board SET viewcount = viewcount + 1 WHERE boardid=?";
/* 175 */     Connection conn = null;
/* 176 */     PreparedStatement pstmt = null;
/*     */     try {
/* 178 */       conn = DBManager.getConnection();
/* 179 */       pstmt = conn.prepareStatement(sql);
/* 180 */       pstmt.setString(1, boardid);
/* 181 */       return pstmt.executeUpdate();
/*     */     } catch (Exception e) {
/* 183 */       e.printStackTrace();
/*     */     } finally {
/* 185 */       DBManager.close(conn, pstmt);
/*     */     }
/* 187 */     return -1;
/*     */   }
/*     */ 
/*     */   public List<BoardVo> getList(int pageNumber) {
/* 191 */     String sql = "SELECT * FROM board WHERE boardid < ? ORDER BY boardid desc LIMIT 10";
/* 192 */     Connection conn = null;
/* 193 */     PreparedStatement pstmt = null;
/* 194 */     ResultSet rs = null;
/* 195 */     List<BoardVo> list = new ArrayList<BoardVo>();
/*     */     try {
/* 197 */       conn = DBManager.getConnection();
/* 198 */       pstmt = conn.prepareStatement(sql);
/* 199 */       pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
/* 200 */       rs = pstmt.executeQuery();
/*     */ 
/* 202 */       while (rs.next()) {
/* 203 */         BoardVo bVo = new BoardVo();
/* 204 */         bVo.setBoardid(rs.getInt("boardid"));
/* 205 */         bVo.setId(rs.getString("id"));
/* 206 */         bVo.setTitle(rs.getString("title"));
/* 207 */         bVo.setContent(rs.getString("content"));
/* 208 */         bVo.setBoarddate(rs.getString("boarddate"));
/* 209 */         bVo.setBoardstatus(rs.getInt("boardstatus"));
/* 210 */         bVo.setViewcount(rs.getInt("viewcount"));
/* 211 */         bVo.setBoardpwd(rs.getString("boardpwd"));
/* 212 */         int comCount = getComListSize(rs.getInt("boardid"));
/* 213 */         bVo.setCommentsize(comCount);
/*     */ 
/* 215 */         list.add(bVo);
/*     */       }
/*     */     } catch (Exception e) {
/* 218 */       e.printStackTrace();
/*     */     } finally {
/* 220 */       DBManager.close(conn, pstmt);
/*     */     }
/*     */ 
/* 223 */     return list;
/*     */   }
/*     */ 
/*     */   public int getListSize() {
/* 227 */     String sql = "select count(*) from board";
/* 228 */     Connection conn = null;
/* 229 */     PreparedStatement pstmt = null;
/* 230 */     ResultSet rs = null;
			  int count = 0;
/*     */     try {
/* 232 */       conn = DBManager.getConnection();
/* 233 */       pstmt = conn.prepareStatement(sql);
/* 234 */       rs = pstmt.executeQuery();
/*     */ 
				if( rs.next() ) {
					count = rs.getInt(1);
				}
/*     */ 
/* 241 */       return count;
/*     */     } catch (Exception e) {
/* 243 */       e.printStackTrace();
/*     */     } finally {
/* 245 */       DBManager.close(conn, pstmt);
/*     */     }
/*     */ 
/* 248 */     return count;
/*     */   }
/*     */ 
/*     */   public List<ComVo> getComList(String boardid) {
/* 252 */     String sql = "SELECT * FROM comment WHERE boardid=? order by commentid";
/* 253 */     Connection conn = null;
/* 254 */     PreparedStatement pstmt = null;
/* 255 */     ResultSet rs = null;
/* 256 */     List list = new ArrayList();
/*     */     try {
/* 258 */       conn = DBManager.getConnection();
/* 259 */       pstmt = conn.prepareStatement(sql);
/* 260 */       pstmt.setString(1, boardid);
/* 261 */       rs = pstmt.executeQuery();
/*     */ 
/* 263 */       while (rs.next()) {
/* 264 */         ComVo cVo = new ComVo();
/* 265 */         cVo.setComnum(rs.getString("comnum"));
/* 266 */         cVo.setBoardid(rs.getInt("boardid"));
/* 267 */         cVo.setCommentid(rs.getInt("commentid"));
/* 268 */         cVo.setId(rs.getString("id"));
/* 269 */         cVo.setContent(rs.getString("content"));
/* 270 */         cVo.setComdate(rs.getString("comdate"));
/* 271 */         cVo.setCommentpwd(rs.getString("commentpwd"));
/*     */ 
/* 273 */         list.add(cVo);
/*     */       }
/*     */     } catch (Exception e) {
/* 276 */       e.printStackTrace();
/*     */     } finally {
/* 278 */       DBManager.close(conn, pstmt);
/*     */     }
/*     */ 
/* 281 */     return list;
/*     */   }
/*     */ 
/*     */   public int getComListSize(int boardid) {
/* 285 */     String sql = "select count(*) from comment where boardid = ?";
/* 286 */     Connection conn = null;
/* 287 */     PreparedStatement pstmt = null;
/* 288 */     ResultSet rs = null;
		      int count = 0;
/*     */     try {
/* 290 */       conn = DBManager.getConnection();
/* 291 */       pstmt = conn.prepareStatement(sql);
/* 292 */       pstmt.setInt(1, boardid);
/* 293 */       rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
				
/* 300 */       return count;
/*     */     } catch (Exception e) {
/* 302 */       e.printStackTrace();
/*     */     } finally {
/* 304 */       DBManager.close(conn, pstmt);
/*     */     }
/*     */ 
/* 307 */     return count;
/*     */   }
/*     */ 
/*     */   public int writeBoard(String id, String title, String boardpwd, String content, int boardStatus) {
/* 311 */     String sql = "INSERT INTO board VALUES (?, ?, ?, ?, ?, default, ?, default)";
/* 312 */     Connection conn = null;
/* 313 */     PreparedStatement pstmt = null;
/*     */     try
/*     */     {
/* 316 */       conn = DBManager.getConnection();
/* 317 */       pstmt = conn.prepareStatement(sql);
/*     */ 
/* 319 */       pstmt.setInt(1, getNext());
/* 320 */       pstmt.setString(2, id);
/* 321 */       pstmt.setString(3, boardpwd);
/* 322 */       pstmt.setString(4, title);
/* 323 */       pstmt.setString(5, content);
				pstmt.setInt(6, boardStatus);
/* 324 */       return pstmt.executeUpdate();
/*     */     } catch (Exception e) {
/* 326 */       e.printStackTrace();
/*     */     } finally {
/* 328 */       DBManager.close(conn, pstmt);
/*     */     }
/* 330 */     return -1;
/*     */   }
/*     */ 
/*     */   public BoardVo getView(String boardid)
/*     */   {
/* 336 */     String sql = "SELECT * FROM board WHERE boardid=?";
/* 337 */     Connection conn = null;
/* 338 */     PreparedStatement pstmt = null;
/* 339 */     ResultSet rs = null;
/*     */     try {
/* 341 */       conn = DBManager.getConnection();
/* 342 */       pstmt = conn.prepareStatement(sql);
/* 343 */       pstmt.setString(1, boardid);
/* 344 */       rs = pstmt.executeQuery();
/* 345 */       if (rs.next()) {
/* 346 */         BoardVo bVo = new BoardVo();
/* 347 */         bVo.setBoardid(rs.getInt("boardid"));
/* 348 */         bVo.setId(rs.getString("id"));
/* 349 */         bVo.setTitle(rs.getString("title"));
/* 350 */         bVo.setContent(rs.getString("content"));
/* 351 */         bVo.setBoarddate(rs.getString("boarddate"));
/* 352 */         bVo.setViewcount(rs.getInt("viewcount"));
/* 353 */         bVo.setBoardpwd(rs.getString("boardpwd"));
				  bVo.setBoardstatus(rs.getInt("boardstatus"));
/* 354 */         return bVo;
/*     */       }
/* 356 */       return null;
/*     */     } catch (Exception e) {
/* 358 */       e.printStackTrace();
/*     */     } finally {
/* 360 */       DBManager.close(conn, pstmt);
/*     */     }
/* 362 */     return null;
/*     */   }
/*     */ 
/*     */   public String getBoardPwd(String boardid)
/*     */   {
/* 367 */     String sql = "SELECT boardpwd FROM board WHERE boardid=?";
/* 368 */     Connection conn = null;
/* 369 */     PreparedStatement pstmt = null;
/* 370 */     ResultSet rs = null;
/* 371 */     String pwd = null;
/*     */     try {
/* 373 */       conn = DBManager.getConnection();
/* 374 */       pstmt = conn.prepareStatement(sql);
/*     */ 
/* 376 */       pstmt.setString(1, boardid);
/* 377 */       rs = pstmt.executeQuery();
/*     */ 
/* 379 */       if (rs.next()) {
/* 380 */         pwd = rs.getString(1);
/*     */ 
/* 382 */         return pwd;
/*     */       }
/* 384 */       return null;
/*     */     } catch (Exception e) {
/* 386 */       e.printStackTrace();
/*     */     } finally {
/* 388 */       DBManager.close(conn, pstmt);
/*     */     }
/* 390 */     return pwd;
/*     */   }
/*     */ 
/*     */   public String getCommentPwd(String comnum) {
/* 394 */     String sql = "SELECT commentpwd FROM comment WHERE comnum=?";
/* 395 */     Connection conn = null;
/* 396 */     PreparedStatement pstmt = null;
/* 397 */     ResultSet rs = null;
/* 398 */     String pwd = null;
/*     */     try
/*     */     {
/* 401 */       conn = DBManager.getConnection();
/* 402 */       pstmt = conn.prepareStatement(sql);
/*     */ 
/* 404 */       pstmt.setString(1, comnum);
/* 405 */       rs = pstmt.executeQuery();
/*     */ 
/* 407 */       if (rs.next()) {
/* 408 */         pwd = rs.getString(1);
/*     */ 
/* 410 */         return pwd;
/*     */       }
/* 412 */       return null;
/*     */     } catch (Exception e) {
/* 414 */       e.printStackTrace();
/*     */     } finally {
/* 416 */       DBManager.close(conn, pstmt);
/*     */     }
/* 418 */     return pwd;
/*     */   }
/*     */ }
