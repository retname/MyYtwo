package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhangyu on 2017/6/20.
 */
public class MyBatisUtil {
    private static final String RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory = null;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private MyBatisUtil(){
    }




             public static void closeSession(){
                     SqlSession session = (SqlSession) threadLocal.get(); // 2
                     threadLocal.set(null);
                     if (session !=null){
                             session.close();
                         }
                 }

                 public  static SqlSession getSessionTwo(){
                 //读取配置文件
                     try {

                         InputStream stream = Resources.getResourceAsStream(RESOURCE);
                         sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

                         return sqlSessionFactory.openSession();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

                     return  null;
                 }


}
