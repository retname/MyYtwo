package happy;

import dao.impl.studentImpl;
import entity.Student;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by zhangyu on 2017/6/20.
 */
public class FirstTest {

    @Test
    public  void Test(){
       // SqlSession sessionTwo = MyBatisUtil.getSessionTwo();
       // sessionTwo.commit();
      //  sessionTwo.rollback();

       // studentDao mapper = MyBatisUtil.getSessionTwo().getMapper(studentDao.class);
        Student student = new Student();
        student.setStuName("张雨");
        student.setStuAge(18);

        studentImpl impl = new studentImpl();
        try {
           // System.out.print(impl.addStudent(student));
            System.out.print(impl.deleStudent(student));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
