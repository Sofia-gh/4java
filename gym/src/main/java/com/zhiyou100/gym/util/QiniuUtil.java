package com.zhiyou100.gym.util;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

/**
 * ClassName: QiniuUtil
 * Description:
 *
 */
@Component
//使用log.info打印日志数据
@Slf4j
//ConfigurationProperties这个注解一般和@Value注解来比较
//之前我们获取配置文件中的数据使用@Value注解
//该注解有一个prefix属性，前缀，前缀都是qiniu，会将值存储到属性名和配置文件名一样的变量中
@ConfigurationProperties(prefix = "qiniu")
@Data
public class QiniuUtil {

//    @Value("${qiniu.accessKey}")
    private String accessKey;//存储AK
//    @Value("${qiniu.secretKey}")
    private String secretKey;//存储SK
//    @Value("${qiniu.bucket}")
    private String bucket;//存储空间名
//    @Value("${qiniu.path}")
    private String path;//存储域名

    /**
     * 将图片上传到七牛云
     *
     * @param file
     * @param name 保存在空间中的名字，如果为空会使用文件的hash值为文件名
     * @return
     */
    public String uploadImg(FileInputStream file, String name) {
        System.out.println("file====>"+file);
        UploadManager uploadManager = getUploadManager();
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                System.out.println("uploadManager===>"+uploadManager);
                //通过uploadManager.put方法进行文件上传，返回Response对象
                Response response = uploadManager.put(file, name, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                String return_path = path + "/" + putRet.key;
                log.info("保存地址={}", return_path);
                return return_path;
            } catch (QiniuException ex) {
                System.out.println("ex===>");
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println("body===>"+r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
     * @param file
     * @param newName:新文件的名字
     * @param oldName:旧文件的名字
     * @return java.lang.String
     */
    public String overrideUploadImg(FileInputStream file, String newName, String oldName) {
        UploadManager uploadManager = getUploadManager();
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket,oldName);
            try {
                Response response = uploadManager.put(file, newName, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
//                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//                System.out.println(putRet.key);
//                System.out.println(putRet.hash);
                String return_path = path + "/" + putRet.key;
                log.info("保存地址={}", return_path);
                return return_path;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 创建一个UploadManager对象，就是一个上传管理器
     * @return
     */
    public UploadManager getUploadManager() {
        // 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
        Region region = Region.autoRegion();
        Configuration cfg = new Configuration(region);
        UploadManager uploadManager = new UploadManager(cfg);
        return uploadManager;
    }


}
