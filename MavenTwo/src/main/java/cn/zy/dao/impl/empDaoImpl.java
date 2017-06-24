package cn.zy.dao.impl;

import cn.zy.dao.*;
import cn.zy.empty.branch;
import cn.zy.empty.emple;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.junit.Test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhangyu on 2017/6/16.
 */
public class empDaoImpl extends BaseDao implements empDao  {

      QueryRunner qr=new QueryRunner();   //增删改所有的方法
      DbUtils db=new DbUtils();
      ArrayListHandler al=new ArrayListHandler();
    @Test  //查询
    public void Test() throws  SQLException{
        List<Object[]>list=list();

        for (Object[] item: list) {
           for(int i=0;i<item.length;i++){
               System.out.println(item[1]);
           }
        }
    }

    public List<branch> getAllBranch()throws SQLException {
        List<branch> list = new ArrayList<branch>();

        String sql ="select * from branch";

        rs = executeQuery(sql);

        while (rs.next()){

            branch branch = new branch();
            branch.setBranchId(rs.getInt("branchId"));
            branch.setBranchName(rs.getString("branchName"));
            list.add(branch);
        }
        return list;
    }

    public List<emple> getAllEmpleByPage(String name, int branchId, int pageIndex, int pageSize) throws SQLException {
        List<emple> list = new ArrayList<emple>();
        StringBuilder sb = new StringBuilder("select empId,empName,empBmId,branchName FROM emp,branch where 1=1 AND emp.empBmId=branch.branchId");
        if(name!=null){
            sb.append( " and empName like '%"+name+"%'");
        }
        if(branchId!=0){
            sb.append(" and empBmId ="+branchId+"");
        }
        sb.append(" limit ?,?");
        Object[] objs  = {pageIndex,pageSize};
        rs=executeQuery(sb.toString(),objs);
        while (rs.next()){
            emple emple = new emple();
            emple.setEmpId(rs.getInt("empId"));
            emple.setEmpName(rs.getString("empName"));
            emple.setEmpBmId(rs.getInt("empBmId"));
            emple.setBranchName(rs.getString("branchName"));

            System.out.print(emple.getCount());
            list.add(emple);
        }
        return list;
    }

    public List<emple> getAllEmpleBy(int pageIndex,int pageSize) throws SQLException {
        List<emple> list = new ArrayList<emple>();

        String sql ="SELECT empId,empName,empBmId,branchName FROM emp,branch WHERE branch.branchId=emp.empBmId limit ?,?";
        Object[] objs = {pageIndex,pageSize};
        rs = executeQuery(sql,objs);
        while (rs.next()){
            emple emple = new emple();
            emple.setEmpId(rs.getInt("empId"));
            emple.setEmpName(rs.getString("empName"));
            emple.setEmpBmId(rs.getInt("empBmId"));
            emple.setBranchName(rs.getString("branchName"));
            list.add(emple);
        }
        return list;
    }

    public int getCount() throws SQLException {
        int result = 0;
        String sql = "select count(*) as num from emp";
         rs = executeQuery(sql);
        if (rs != null) {
            if (rs.next()) {
                result = rs.getInt("num");
            }
        }
        return result;
    }

    public int getPageCount(String name,int branchId) throws SQLException {

        StringBuilder sb = new StringBuilder("select count(*) as mycount from emp where 1=1 ");
        if(name!=null){
            sb.append( " and empName like '%"+name+"%'");
        }
        if(branchId!=0){
            sb.append(" and empBmId ="+branchId+"");
        }
        rs = executeQuery(sb.toString());
        int count = 0;
        if(rs.next()){
            count = rs.getInt("mycount");
        }
        return count;
    }

    //查询
    public List<Object[]> list() throws SQLException {
        String sql="select * FROM emp";
         List<Object[]>list= qr.query(getConnection(),sql,al);
         db.closeQuietly(conn, ps, rs);   //关闭连接
         return list;
    }
    //增删改
    public boolean  update(int id,String name) throws SQLException {
              String sql="update emp set name=? where id=?";
              Object[] objects={name,id};
              int num=qr.update(getConnection(),sql,objects);
              boolean flag=false;
              if(num>0){
                flag=true;
              }
         db.closeQuietly(conn, ps, rs);   //关闭连接
         return flag;
    }

}
