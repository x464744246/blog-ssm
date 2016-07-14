package rocks.chendidi.ssm.controller;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.json.JSONObject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.*;
import rocks.chendidi.ssm.service.ArticleService;
import rocks.chendidi.ssm.util.PublicValue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by lenov0 on 2016/7/7.
 */
@Controller
@RequestMapping("/article")
@Configuration
@ComponentScan("rocks.chendidi.ssm.service")
public class ArticleController {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "Z8wombdh9buqzFIPyiEcfws79BOyQurVDpbltkJg";
    String SECRET_KEY = "HokbRUvvDkBxxA08yMqJcwX6RHsQXQ0TPIEFtVit";
    //要上传的空间
    String bucketname = "blog";
    //上传到七牛后保存的文件名
    //  String key = "my-java.png";
    //上传文件的路径
    String FilePath = "D:\\photo\\photo.jpg";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager = new UploadManager();
    //简单上传，使用默认策略，只需要设置上传的空间名就可以了

    @Autowired
    ArticleService articleService;

    public String getUpToken(){
        return this.auth.uploadToken(bucketname);
    }

    @RequestMapping(value = "/page", produces = "text/plain;charset=UTF-8")
    public String page(HttpServletResponse response, int page) throws IOException {
        System.out.println(page);

        List<Article> list = articleService.getByPage(page, PublicValue.PAGESIZE);
        Page p = articleService.getPage(page);
//        System.out.println(list.get(0).getArticleid());
        boolean flag = false;
        if (list.size() > 0) {
            flag = true;
        }
        //将数据转换成json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        map.put("article", list);
        map.put("page", p);
        String json = JSONObject.valueToString(map).toString();
        //将数据返回
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
        return null;
    }

    @RequestMapping(value = "/article", produces = "text/plain;charset=UTF-8")
    public String page() {
        return "article";
    }
    @RequestMapping(value = "/edit", produces = "text/plain;charset=UTF-8")
    public String edit(HttpSession httpSession) {
        UUID uuid = UUID.randomUUID();
        httpSession.setAttribute("uuid",uuid);
        return "edit";
    }

    @RequestMapping(value = "/delete", produces = "text/plain;charset=UTF-8")
    public String delete(HttpSession httpSession, HttpServletResponse response, Article article) throws IOException {

        int row = articleService.deleteArticle(article);

        boolean flag = false;
        if (row > 0) {
            flag = true;
        }


        //将数据转换成json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        String json = JSONObject.valueToString(map).toString();
        //将数据返回
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
        return null;
    }

    @RequestMapping(value = "/add", produces = "text/plain;charset=UTF-8")
    public String add(HttpSession httpSession, HttpServletResponse response,Article article) throws IOException {
        String articleid = httpSession.getAttribute("uuid").toString();
        article.setArticleid(articleid);
        article.setTitle(java.net.URLDecoder.decode(article.getTitle(), "utf-8"));
        article.setArticle(java.net.URLDecoder.decode(article.getArticle(),"utf-8"));
        System.out.println(article.getArticle()+"          " +article.getTitle());
        User user = (User) httpSession.getAttribute("u");
        article.setUserid(user.getUserid());
        article.setUsername(user.getUsername());
        int row = articleService.addArticle(article);

        boolean flag = false;
        if (row > 0) {
            flag = true;
        }


        //将数据转换成json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        String json = JSONObject.valueToString(map).toString();
        //将数据返回
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
        return null;
    }


    @RequestMapping(value = "/photo",  method = RequestMethod.POST)
    @ResponseBody
    public Message photot(HttpSession httpSession,MultipartFile file) throws IOException {

        String articleid = httpSession.getAttribute("uuid").toString();

        if (!file.isEmpty()) {
            InputStream in = null;
            OutputStream out = null;
            File serverFile = new File(FilePath);
            in = file.getInputStream();
            out = new FileOutputStream(serverFile);
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = in.read(b)) > 0) {
                out.write(b, 0, len);
            }
            out.close();
            in.close();
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            String key = df.format(new Date()).toString();
            Photo photo = new Photo();
            photo.setArticleid(articleid);
            photo.setPhotoid(key);
            articleService.addPhoto(photo);
            System.out.println(articleid);
            System.out.println(key);
            try {
                //调用put方法上传
                Response res = uploadManager.put(FilePath, key, getUpToken());
                //打印返回的信息
                System.out.println(res.bodyString());
            } catch (QiniuException e) {
                Response r = e.response;
                // 请求失败时打印的异常的信息
                System.out.println(r.toString());
                try {
                    //响应的文本信息
                    System.out.println(r.bodyString());
                } catch (QiniuException e1) {
                    //ignore
                }
            }
            Message msg = new Message();
            msg.setStatus(Status.SUCCESS);
            msg.setStatusMsg("File upload success");
            return msg;
        } else {

            Message msg = new Message();
            msg.setStatus(Status.ERROR);
            msg.setError("File upload fail");
            return msg;
        }
    }

    @RequestMapping(value = "/photos",  method = RequestMethod.POST)
    @ResponseBody
    public Message photots(@RequestParam("files") MultipartFile file,HttpSession httpSession) throws IOException {

       // SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String key = UUID.randomUUID().toString();
        String articleid = httpSession.getAttribute("uuid").toString();
        System.out.println("filesize:"+file.getOriginalFilename());
        //上传文件的路径
        String FilePath = "D:\\photo\\"+file.getOriginalFilename();
      //  for(int i =0 ; i<files.size();i++) {

            if (!file.isEmpty()) {
                InputStream in = null;
                OutputStream out = null;
                File serverFile = new File(FilePath);
                in = file.getInputStream();
                out = new FileOutputStream(serverFile);
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = in.read(b)) > 0) {
                    out.write(b, 0, len);
                }
                out.close();
                in.close();


                Photo photo = new Photo();
                photo.setArticleid(articleid);
                photo.setPhotoid(key);

                System.out.println(key);
                articleService.addPhoto(photo);

                try {
                    //调用put方法上传
                    Response res = uploadManager.put(FilePath, key, getUpToken());
                    //打印返回的信息
                    System.out.println(res.bodyString());
                } catch (QiniuException e) {
                    Response r = e.response;
                    // 请求失败时打印的异常的信息
                    System.out.println(r.toString());
                    try {
                        //响应的文本信息
                        System.out.println(r.bodyString());
                    } catch (QiniuException e1) {
                        //ignore
                    }
                }
                Message msg = new Message();
                msg.setStatus(Status.SUCCESS);
                msg.setStatusMsg("File upload success");
                serverFile.delete();
                return msg;
            } else {

                Message msg = new Message();
                msg.setStatus(Status.ERROR);
                msg.setError("File upload fail");
                return msg;
            }
       // }

    }

}
