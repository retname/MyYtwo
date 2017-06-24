package cn.zy.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zhangyu on 2017/6/23.
 */
public class FilterTest implements Filter {
    private String encode=null;
    private boolean filterName;
    public FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //System.out.print( config.getInitParameter(""));
        // String logonStrings = config.getInitParameter("loginServlet");        // 登录登陆页面
       // System.out.print(logonStrings);
        req.setCharacterEncoding(encode);
        resp.setCharacterEncoding(encode);
        System.out.print("进入filter《《《《《《");
        System.out.print( req.getParameter ("name"));
        System.out.print( req.getAttribute("name"));
        chain.doFilter(req, resp);
        ////////////////////////地方撒发达
    }

    public void init(FilterConfig config) throws ServletException {

        encode="utf-8";

    }



}
