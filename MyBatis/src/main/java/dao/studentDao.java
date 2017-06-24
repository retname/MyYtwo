package dao;

import entity.Student;

import java.sql.SQLException;

/**
 * Created by zhangyu on 2017/6/19.
 */
public interface studentDao {


    public int addStudent(Student stu) throws SQLException;

    public int deleStudent(Student stu) throws  SQLException;
}
