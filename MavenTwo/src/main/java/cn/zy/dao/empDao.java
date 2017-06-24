package cn.zy.dao;
import cn.zy.empty.emple;
import cn.zy.empty.branch;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangyu on 2017/6/16.
 */
public interface empDao {
    /**
     *  拿到所有的部门
     * @return
     */
    public List<branch> getAllBranch() throws SQLException;


    /**
     * 分页查询员工
     * @return
     * @throws SQLException
     */
    public  List<emple> getAllEmpleByPage(String name,int branchId,int pageIndex,int pageSize) throws  SQLException;


    /**
     * 默认获得所有的员工
     * @return
     * @throws SQLException
     */
    public  List<emple> getAllEmpleBy(int pageIndex,int pageSize) throws  SQLException;


    /**
     * 拿到总数量
     * @return
     * @throws SQLException
     */
    public  int getCount() throws  SQLException;


    /**
     * 拿到查询后的总数据量
     * @return
     * @throws SQLException
     */
    public  int getPageCount(String name,int branchId) throws  SQLException;

 public List<Object[]>list () throws SQLException;


}
