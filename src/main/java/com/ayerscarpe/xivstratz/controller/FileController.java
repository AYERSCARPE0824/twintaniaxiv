package com.ayerscarpe.xivstratz.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:9528")
@RestController
public class FileController {

    @ApiOperation("单张图片上传")
    @RequestMapping("/img_upload")
    @ResponseBody
    public String imgUpload(@RequestParam(value = "pic", required = false)MultipartFile pic, HttpServletRequest request){
        return null;
    }

    public List<String> upload(MultipartFile[] files, String categoryPath, HttpServletRequest request){

        // 判断非空
        if (files == null || files.length == 0){
            return new ArrayList<>();
        }

        // 专门存放文件的 java-web 工程，方便图片通过 http 访问。
        String fileProject = "blog_files";
        String fileBak = "E:/Files/Blogs";
        String ipPort = request.getScheme() + "://" + request.getServerName() + "://" + request.getServerPort() + "/";

        // Markdown编辑器的图片路径不允许含有"\"，故替换为"/"。
        String rootPath = request.getSession().getServletContext().getRealPath("").replaceAll("\\\\", "/");

        // 项目路径
        String contextPath = request.getContextPath();
        rootPath = rootPath.substring(0, rootPath.lastIndexOf(contextPath.replace("/", "")));

        StringBuilder fileRoot = new StringBuilder("");

        // 工程名称
        fileRoot.append(fileProject);
        fileRoot.append("/");
        // 类别目录
        fileRoot.append(categoryPath);
        fileRoot.append("/");
        // 文件目录 - 图片上传失败时使用
        String picRootPath =fileRoot.toString();
        // 日期目录
        String day = new SimpleDateFormat("yyyyMMdd").format(new Date());
        fileRoot.append(day);
        fileRoot.append("/");

        // 最终保存目录
        String fileDir = fileRoot.toString();

        List<String> list = new ArrayList<>();
        for (MultipartFile multipartFile : files){

            // 文件名称 - Markdown编辑器图片路径不允许为空
            String upFileName = multipartFile.getOriginalFilename().replaceAll("\\s+", "");
            String filename = new SimpleDateFormat("HHmmss").format(new Date()) + "_" + UUID.randomUUID().toString() + "_" + upFileName;

            String filePathName = rootPath + fileDir + filename;
            File destFile = new File(filePathName);

        }
        return new ArrayList<>();
    }
}
