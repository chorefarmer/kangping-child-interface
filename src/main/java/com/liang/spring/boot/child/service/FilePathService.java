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
public interface FilePathService {

    ResultMsg Upload(@RequestParam("file") MultipartFile file);
}
