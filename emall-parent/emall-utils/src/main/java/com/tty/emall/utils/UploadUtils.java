package com.tty.emall.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author tty
 * @create 2020-09-03-10:00
 */
public class UploadUtils {

    public static void upload(MultipartFile multipartFile, String uploadName, String path, HttpServletRequest request) {
        try {
            multipartFile.transferTo(new File(uploadName));
            // 由于图片上传后需要重新部署才能加载到tomcat上，所以先在部署的目录下放一个临时的图片显示
            multipartFile.transferTo(new File(request.getSession().getServletContext().getRealPath("/") + "upload/"
                    + path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
