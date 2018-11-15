package base.springmvc.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Package: base.springmvc.upload
 * Author: houzm
 * Date: Created in 2018/9/7 8:39
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：上传
 */
@RestController
@RequestMapping(value = "api/file")
@Api(value = "api/file")
public class FileDemoController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "/upload", notes = "上传文件接口", httpMethod = "POST")
    public Boolean upload(MultipartFile multipartFile) {
        Boolean flagOfResult = false;
        try {
            FileUtils.writeByteArrayToFile(new File("E:/"+multipartFile.getOriginalFilename()), multipartFile.getBytes());
            flagOfResult = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flagOfResult;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ApiOperation(value = "/download", notes = "下载文件接口", httpMethod = "GET")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        try {
            IOUtils.write(FileUtils.readFileToByteArray(new File("E:/xiazai.jpg")), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
