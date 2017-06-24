package cn.zy.dao;

/**
 * Created by zhangyu on 2017/6/16.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BaseDao {



        public static final String driver="com.mysql.jdbc.Driver";
        public static final String url="jdbc:mysql://localhost:3306/emple?useUnicode=true&charaterEncoding=UTF-8";
        public static final String username="root";
        public static final String password="0217";
        public  Connection conn;
        public ResultSet rs;
        public PreparedStatement ps;
        static{

            try {
                Class.forName(driver);  //加载驱动
            } catch (ClassNotFoundException e) {
             //大师傅大师傅但是
                e.printStackTrace();
            }

        }


        /**
         *   获得数据库连接
         * @return
         * @throws SQLException
         */
        public Connection getConnection() throws SQLException{

            if (conn==null||conn.isClosed()) {
                conn=DriverManager.getConnection(url, username, password);
            }


            return conn;

        }

        /**
         * 关闭数据连接
         * @throws SQLException
         */
        public void closeAll() throws SQLException{

            ps.close();
            rs.close();

            conn.close();
        }
        /**
         *  查询
         * @param sql
         * @param objs
         * @return
         * @throws SQLException
         */
        public ResultSet executeQuery(String sql,Object...objs) throws SQLException{
            getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1, objs[i]);
            }
            rs= ps.executeQuery();
            return rs;

        }

        /**
         * 增删改方法
         * @param sql
         * @param objs
         * @return
         * @throws SQLException
         */
        public int executeUpdate(String sql,Object...objs) throws SQLException{
            getConnection();
            ps= conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1, objs[i]);
            }
            int count = ps.executeUpdate();
            return count;

        }





}
