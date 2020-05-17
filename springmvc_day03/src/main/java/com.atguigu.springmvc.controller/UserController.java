package com.atguigu.springmvc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author ouyangjie
 * @createTime 2020-03-02 18:15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //跨服务器上传
    @RequestMapping("/fileUpload2")
    public String fileUpload2( MultipartFile upload) throws Exception{
        System.out.println("跨服务器上传上传");
       String path="http://localhost:9090/fileuploadserver/uploads/";

        String fileName=upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
        fileName=uuid+"_"+fileName;
        //1.创建客户端对象
        Client client= Client.create();
        //2.和图片服务器连接
        WebResource webResource = client.resource(path+fileName);
        //视频需要在编译好的fileuploadserver下面的target文件夹手动加uploads文件夹
        System.out.println(path+fileName);
        webResource.put(upload.getBytes());

        return "success";
    }

    /*springmvc上传,不用解析文件只要配置，不用删零时缓存文件，拿到对象操作进行*/
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request, MultipartFile upload) throws Exception{
        System.out.println("springmvc上传");
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String fileName=upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName=uuid+"_"+fileName;
        upload.transferTo(new File(path,fileName));
        return "success";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception{
        //传统文件上传
        System.out.println("文件上传。。");
        //使用fileupload组件完成文件上传
      String path=request.getSession().getServletContext().getRealPath("/uploads/");
      File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        List<FileItem> fileItems  = upload.parseRequest(request);
        for(FileItem item:fileItems) {
            if (item.isFormField()) {
                //普通表单向
            } else {
               // 上传文件
            String fileName=item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName=uuid+"_"+fileName;
                item.write(new File(path,fileName));
            item.delete();
            }
        }
        return "success";
    }
}
