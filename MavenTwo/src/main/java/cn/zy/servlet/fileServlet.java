package cn.zy.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhangyu on 2017/6/19.
 */
public class fileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        System.out.print("2222222222");

        //上传文件存储目录
        String UPLOAD_DIRECTORY ="lib";
        //上传配置
         int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
         int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
         int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
        //检测是否为多媒体上传
        if(!ServletFileUpload.isMultipartContent(request)){
            //如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("错误：表单必须包含enctype = multipart / form-data");
            writer.flush();
            //返回;
        }

        //配置上传参数  工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置内存临界值 - 超过后将产生临时文件并存于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        //设定临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        //设置最大请求值（包含文件和表单数据）
        upload.setSizeMax(MAX_REQUEST_SIZE);
        //构造临时路径来存储上传的文件
        //这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("./")+ File.separator + UPLOAD_DIRECTORY;
        //如果目录不存在则创建
        try {
            List<FileItem> formItems =  upload.parseRequest(request);
            if(formItems!= null && formItems.size()> 0){
                //迭代表单数据
                for(FileItem item:formItems){
                    //处理不在表单中的字段
                    if(!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        //在控制台中输出文件的上传路径
                        try {
                            item.write(storeFile);
                            System.out.print("ok!!!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }


}
