/*     */ package dto.member;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import util.DBManager;
/*     */ 
/*     */ public class MemberDAO
/*     */ {
/*  10 */   private static MemberDAO instance = new MemberDAO();
/*     */ 
/*     */   public static MemberDAO getInstance()
/*     */   {
/*  15 */     return instance;
/*     */   }
/*     */ 
/*     */   public MemberVo getMemberVo(String id) {
/*  19 */     String sql = "SELECT * FROM members WHERE id=?";
/*     */ 
/*  21 */     Connection conn = null;
/*  22 */     PreparedStatement pstmt = null;
/*  23 */     ResultSet rs = null;
/*     */     try
/*     */     {
/*  26 */       conn = DBManager.getConnection();
/*  27 */       pstmt = conn.prepareStatement(sql);
/*  28 */       pstmt.setString(1, id);
/*  29 */       rs = pstmt.executeQuery();
/*     */ 
/*  31 */       if (rs.next()) {
/*  32 */         MemberVo mVo = new MemberVo();
/*  33 */         mVo.setId(rs.getString("id"));
/*  34 */         mVo.setPwd(rs.getString("pwd"));
/*  35 */         mVo.setName(rs.getString("name"));
/*  36 */         mVo.setEmail(rs.getString("email"));
/*  37 */         mVo.setGrade(rs.getInt("grade"));
/*  38 */         return mVo;
/*     */       }
/*     */     } catch (Exception e) {
/*  41 */       e.printStackTrace();
/*     */     } finally {
/*  43 */       DBManager.close(conn, pstmt, rs); } DBManager.close(conn, pstmt, rs);
/*     */ 
/*  45 */     return null;
/*     */   }
/*     */ 
/*     */   public int insertMember(MemberVo mVo) {
/*  49 */     String sql = "INSERT INTO members VALUES(?, ?, ?, ?, default)";
/*     */ 
/*  51 */     Connection conn = null;
/*  52 */     PreparedStatement pstmt = null;
/*     */     try
/*     */     {
/*  55 */       conn = DBManager.getConnection();
/*  56 */       pstmt = conn.prepareStatement(sql);
/*  57 */       pstmt.setString(1, mVo.getName());
/*  58 */       pstmt.setString(2, mVo.getId());
/*  59 */       pstmt.setString(3, mVo.getPwd());
/*  60 */       pstmt.setString(4, mVo.getEmail());
/*     */ 
/*  62 */       return pstmt.executeUpdate();
/*     */     } catch (Exception e) {
/*  64 */       e.printStackTrace();
/*     */     } finally {
/*  66 */       DBManager.close(conn, pstmt);
/*     */     }
/*  68 */     return -1;
/*     */   }
/*     */ 
/*     */   public int updateMember(String name, String pwd, String email, String id) {
/*  72 */     String sql = "UPDATE members SET name=?, pwd=?, email=? WHERE id=?";
/*     */ 
/*  74 */     Connection conn = null;
/*  75 */     PreparedStatement pstmt = null;
/*     */     try
/*     */     {
/*  78 */       conn = DBManager.getConnection();
/*  79 */       pstmt = conn.prepareStatement(sql);
/*  80 */       pstmt.setString(1, name);
/*  81 */       pstmt.setString(2, pwd);
/*  82 */       pstmt.setString(3, email);
/*  83 */       pstmt.setString(4, id);
/*     */ 
/*  85 */       return pstmt.executeUpdate();
/*     */     } catch (Exception e) {
/*  87 */       e.printStackTrace();
/*     */     } finally {
/*  89 */       DBManager.close(conn, pstmt);
/*     */     }
/*  91 */     return -1;
/*     */   }
/*     */ 
/*     */   public String loginMember(String id) {
/*  95 */     String sql = "SELECT pwd FROM members WHERE id=?";
/*     */ 
/*  97 */     Connection conn = null;
/*  98 */     PreparedStatement pstmt = null;
/*  99 */     ResultSet rs = null;
/*     */     try
/*     */     {
/* 102 */       conn = DBManager.getConnection();
/* 103 */       pstmt = conn.prepareStatement(sql);
/* 104 */       pstmt.setString(1, id);
/* 105 */       rs = pstmt.executeQuery();
/* 106 */       if (rs.next()) {
/* 107 */         return rs.getString("pwd");
/*     */       }
/*     */ 
/* 110 */       return null;
/*     */     } catch (Exception e) {
/* 112 */       e.printStackTrace();
/*     */     } finally {
/* 114 */       DBManager.close(conn, pstmt);
/*     */     }
/* 116 */     return null;
/*     */   }
/*     */ 
/*     */   public int searchId(String id) {
/* 120 */     String sql = "SELECT id FROM members WHERE id=?";
/*     */ 
/* 122 */     Connection conn = null;
/* 123 */     PreparedStatement pstmt = null;
/* 124 */     ResultSet rs = null;
/*     */     try
/*     */     {
/* 127 */       conn = DBManager.getConnection();
/* 128 */       pstmt = conn.prepareStatement(sql);
/* 129 */       pstmt.setString(1, id);
/* 130 */       rs = pstmt.executeQuery();
/*     */ 
/* 132 */       if (rs.next()) {
/* 133 */         return 1;
/*     */       }
/* 135 */       return 0;
/*     */     } catch (Exception e) {
/* 137 */       e.printStackTrace();
/*     */     } finally {
/* 139 */       DBManager.close(conn, pstmt, rs);
/*     */     }
/* 141 */     return -1;
/*     */   }
/*     */ 
/*     */   public MemberVo getMember(String id) {
/* 145 */     String sql = "SELECT * FROM members WHERE id=?";
/*     */ 
/* 147 */     Connection conn = null;
/* 148 */     PreparedStatement pstmt = null;
/* 149 */     ResultSet rs = null;
/* 150 */     MemberVo mVo = null;
/*     */     try
/*     */     {
/* 153 */       conn = DBManager.getConnection();
/* 154 */       pstmt = conn.prepareStatement(sql);
/* 155 */       pstmt.setString(1, id);
/* 156 */       rs = pstmt.executeQuery();
/*     */ 
/* 158 */       if (rs.next()) {
/* 159 */         mVo = new MemberVo();
/*     */ 
/* 161 */         mVo.setName(rs.getString("name"));
/* 162 */         mVo.setId(rs.getString("id"));
/* 163 */         mVo.setPwd(rs.getString("pwd"));
/* 164 */         mVo.setEmail(rs.getString("email"));
/* 165 */         mVo.setGrade(rs.getInt("grade"));
/*     */       }
/*     */     } catch (Exception e) {
/* 168 */       e.printStackTrace();
/*     */     } finally {
/* 170 */       DBManager.close(conn, pstmt, rs);
/*     */     }
/* 172 */     return mVo;
/*     */   }
/*     */ }
