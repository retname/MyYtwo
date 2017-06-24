package entity;

/**
 * Created by zhangyu on 2017/6/19.
 */

public class Student implements java.io.Serializable {

    private int stuId;

    private String stuName;

    private int stuAge;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
}
