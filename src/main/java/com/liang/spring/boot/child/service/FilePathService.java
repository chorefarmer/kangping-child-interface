package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.FilePath;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.FilePathRepository;
import com.liang.spring.boot.child.untils.FileUtil;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 文件上传业务层
 * Created by: elvis(李亮)
 * 2019-04-18 10:18
 * Version: 1.0
 */

@Service
public class FilePathService {


    @Autowired
    private FilePathRepository filePathRepository;

    public ResultMsg Upload(@RequestParam("file") MultipartFile file) {


        FilePath biaopath = null;
        if(!file.isEmpty()) {
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();

            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";


            try {
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //获取当前服务器的ip地址
            try {
                InetAddress address=InetAddress.getLocalHost();
                String localhost=address.getHostAddress();
                // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
                biaopath = new FilePath();
                biaopath.setPath("http://"+localhost+":8082/"+fileName);
                filePathRepository.save(biaopath);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            }


        }
        return ResultUtil.success(biaopath);

    }
}
