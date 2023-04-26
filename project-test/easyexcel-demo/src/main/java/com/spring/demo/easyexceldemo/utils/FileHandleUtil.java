package com.spring.demo.easyexceldemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author lijin
 * @date 2022/2/23 19:44
 */
@Slf4j
public class FileHandleUtil {

    //直接以流的方式下载模板文件 path="templates/员工信息模板.xlsx";
    public static void download(HttpServletResponse response ,String path){
        log.info("进入:FileHandleUtil--->数据模板下载download:开始");
        ClassPathResource classPathResource = new ClassPathResource(path);
        String[] split = path.split("/");
        InputStream in=null;
        OutputStream toClient = null;
        byte[] buffer;
        try {
            // 获取导出文件的字节数组
            in = classPathResource.getInputStream();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer1)) != -1) {
                outStream.write(buffer1, 0, len);
            }
            in.close();
            buffer = outStream.toByteArray();

            // 导出Excel
            if (buffer.length > 0) {
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("ContentDisposition",
                        URLEncoder.encode(split[1], "UTF-8"));
                response.addHeader("Content-Length", "" + buffer.length);
                toClient = response.getOutputStream();
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                toClient.flush();
            }
            log.info("退出:FileHandleUtil--->数据模板下载download:结束");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(toClient != null){
                try {
                    toClient.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(in != null){
                try {
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    //file 转换
    public static File multipartFileToFile(MultipartFile file){
        log.info("进入:FileHandleUtil--->file转换multipartFileToFile:开始");
        String fileName = file.getOriginalFilename();
        File date = new File(fileName);
        OutputStream out = null;
        try{
            //获取文件流，以文件流的方式输出到新文件
//    InputStream in = multipartFile.getInputStream();
            out = new FileOutputStream(date);
            byte[] ss = file.getBytes();
            for(int i = 0; i < ss.length; i++){
                out.write(ss[i]);
            }
            log.info("退出:FileHandleUtil--->file转换multipartFileToFile:结束");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return date;
        }
    }

    /**
     * 公司格式 //传入根据模板写入数据的文件对象
     * @param response
     * @param file
     */
    public static void download(HttpServletResponse response ,File file){
        log.info("进入:FileHandleUtil--->数据模板下载download:开始");
        InputStream in=null;
        OutputStream toClient = null;
        byte[] buffer;
        try {
            // 获取导出文件的字节数组
            in = new FileInputStream(file);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer1)) != -1) {
                outStream.write(buffer1, 0, len);
            }
            in.close();
            buffer = outStream.toByteArray();

            // 导出Excel
            if (null != buffer && buffer.length > 0) {
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("ContentDisposition",
                        URLEncoder.encode(file.getName(), "UTF-8"));
                response.addHeader("Content-Length", "" + buffer.length);
                toClient = response.getOutputStream();
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                toClient.flush();
            }
            log.info("退出:FileHandleUtil--->数据模板下载download:结束");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(toClient != null){
                try {
                    toClient.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(in != null){
                try {
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 公司格式 //传入根据模板写入数据的文件对象
     * @param response
     * @param fileObj
     * @param fileName
     */
    public static void download(HttpServletResponse response ,File fileObj,String fileName){
        log.info("进入:FileHandleUtil--->数据模板下载download:开始");
        InputStream in=null;
        OutputStream toClient = null;
        byte[] buffer;
        try {
            // 获取导出文件的字节数组
            in = new FileInputStream(fileObj);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer1)) != -1) {
                outStream.write(buffer1, 0, len);
            }
            in.close();
            buffer = outStream.toByteArray();
            // 导出Excel
            if (null != buffer && buffer.length > 0) {
                // 清空response
                response.reset();
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setCharacterEncoding("utf-8");
                // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
                fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
                response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

                toClient = response.getOutputStream();
                toClient.write(buffer);
                toClient.flush();
            }
            log.info("退出:FileHandleUtil--->数据模板下载download:结束");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(toClient != null){
                try {
                    toClient.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(in != null){
                try {
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
