package com.example.springimport.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件校验工具类
 *
 * @author 杜飘
 * @date 2022/9/30
 */
public class FileCheckUtil {

    /**
     * 检查文件是否为空
     *
     * @param multipartFile MultipartFile
     * @return boolean
     */
    public static boolean checkEmpty(MultipartFile multipartFile) {
        return multipartFile.isEmpty();
    }

    /**
     * 检查文件大小
     * 单位包含KB(K)、MB(M)、GB(G)
     * empty 返回false
     * actualSize <= size true 实际大小 <= 限制大小 返回true
     * actualSize > size false 实际大小 > 限制大小 返回false
     *
     * @param multipartFile MultipartFile
     * @param size          文件大小
     * @param unit          单位
     * @return boolean
     */
    public static boolean checkSize(MultipartFile multipartFile, Double size, String unit) {
        if (checkEmpty(multipartFile)) {
            return false;
        }
        long fileSize = multipartFile.getSize();
        double actualSize;
        switch (unit) {
            case "k":
                actualSize = (double) fileSize / 1024;
                break;
            case "M":
                actualSize = (double) fileSize / 1048576;
                break;
            case "G":
                actualSize = (double) fileSize / 1073741824;
                break;
            default:
                actualSize = (double) fileSize;
        }
        return actualSize <= size;
    }

    /**
     * 检查文件后缀
     * suffixList中包含fileSuffix（文件后缀）返回true，否则返回false
     *
     * @param multipartFile MultipartFile
     * @param suffixList    suffixList 后缀List
     * @return boolean
     */
    public static boolean checkSuffix(MultipartFile multipartFile, List<String> suffixList) {
        String filename = multipartFile.getOriginalFilename();
        if (filename == null) {
            return false;
        }
        String fileSuffix = filename.substring(filename.lastIndexOf(".") + 1);
        for (String suffix : suffixList) {
            if (suffix.equals(fileSuffix)) {
                return true;
            }
        }
        return false;
    }

}
