package dao.impl;

import dao.studentDao;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.sql.SQLException;


/**
 * Created by zhangyu on 2017/6/19.
 */
public class studentImpl implements studentDao
{


    @Test
    public  void Test() throws SQLException {

    }


    public int addStudent(Student stu)  throws SQLException{
        //String resource ="mybatis-config.xml";
       // Reader reader = null;
       // SqlSessionFactory factory = null;
       // SqlSession session = null;

        SqlSession session1 = MyBatisUtil.getSessionTwo();
        int resource=  session1.insert("addstu",stu);

        return resource;
    }

    public int deleStudent(Student stu) throws SQLException {
        SqlSession session = MyBatisUtil.getSessionTwo();
        int resoure = session.delete("deleStudent",stu);
        return resoure;
    }
}


