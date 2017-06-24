package cn.zy.servlet;

import cn.zy.dao.impl.empDaoImpl;
import cn.zy.empty.page;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;



/**
 * Created by zhangyu on 2017/6/16.
 */
public class empServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        empDaoImpl emp = new empDaoImpl();
        try {
            request.setAttribute("branch", emp.getAllBranch());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //动态查询的内容
        String name= request.getParameter("name");   //输入要查找的姓名
        System.out.print(name);
        String blanid = request.getParameter("selected");
        request.setAttribute("name",name);
        request.setAttribute("blanid",blanid);

        int id=0;
        if(blanid!=null) {
            Integer blanchId = Integer.parseInt(request.getParameter("selected"));
            id = blanchId.intValue();
        }
        System.out.print(name+blanid);
            int pageIndex=0;
            if(request.getParameter("pageIndex")==null){

            }else{
                Integer s=Integer.parseInt(request.getParameter("pageIndex"));
                pageIndex = s.intValue();

            }

            page page = new page();
            try {
                int count = 0;    //总数据量
                if(name==null&&id==0){
                       count=emp.getCount();
                }else{
                       count = emp.getPageCount(name,id);
                }
                page.setAllCount(count);   //总数据数
                page.setPageIndex(pageIndex);       //当前页数
                page.setPageSize(3);                //每页数据量
                page.setPageAll(page.getAllCount()%page.getPageSize()==0?page.getAllCount()/page.getPageSize():page.getAllCount()/page.getPageSize()+1);//总页数
                page.setGetAll(emp.getAllEmpleByPage(name,id,page.getPageIndex(),page.getPageSize()));
                request.setAttribute("empleall",page);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          doPost(request,response);

    }
}
