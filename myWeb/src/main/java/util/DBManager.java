/*    */ package util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.InitialContext;
/*    */ import javax.sql.DataSource;
/*    */ 
/*    */ public class DBManager
/*    */ {
/*    */   public static Connection getConnection()
/*    */   {
/* 13 */     Connection conn = null;
/*    */     try {
/* 15 */       Context initContext = new InitialContext();
/* 16 */       DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/MysqlDB");
/* 17 */       conn = ds.getConnection();
/* 18 */       System.out.println("커넥션 획득 완료");
/*    */     } catch (Exception e) {
/* 20 */       e.printStackTrace();
/*    */     }
/* 22 */     return conn;
/*    */   }
/*    */ 
/*    */   public static void close(Connection conn, Statement stmt) {
/*    */     try {
/* 27 */       conn.close();
/* 28 */       stmt.close();
/* 29 */       System.out.println("커넥션 반납 완료");
/*    */     }
/*    */     catch (Exception localException) {
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void close(Connection conn, Statement stmt, ResultSet rs) {
/*    */     try {
/* 37 */       conn.close();
/* 38 */       stmt.close();
/* 39 */       rs.close();
/* 40 */       System.out.println("커넥션 반납 완료");
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ }
