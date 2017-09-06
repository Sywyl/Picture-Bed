package io.ymq.fm.service.storage;

import com.aliyun.oss.OSSClient;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * 描述: 阿里云存储配置
 * author: yanpenglei
 * Date: 2017/9/5 17:15
 */

@Service("aliyunCloudStorageService")
public class AliyunCloudStorageService {

    //阿里云绑定的域名
    @Value("${oss.cloud.aliyunDomain}")
    private String aliyunDomain;

    //阿里云路径前缀
    @Value("${oss.cloud.aliyunPrefix}")
    private String aliyunPrefix;

    //阿里云EndPoint
    @Value("${oss.cloud.aliyunEndPoint}")
    private String aliyunEndPoint;

    //阿里云AccessKeyId
    @Value("${oss.cloud.aliyunAccessKeyId}")
    private String aliyunAccessKeyId;

    //阿里云AccessKeySecret
    @Value("${oss.cloud.aliyunAccessKeySecret}")
    private String aliyunAccessKeySecret;

    //阿里云BucketName
    @Value("${oss.cloud.aliyunBucketName}")
    private String aliyunBucketName;


    public String upload(byte[] data, String path) throws Exception {
        return upload(new ByteArrayInputStream(data), path);
    }


    public String upload(InputStream inputStream, String path) throws Exception {
        try {
            OSSClient client = new OSSClient(aliyunEndPoint, aliyunAccessKeyId, aliyunAccessKeySecret);

            client.putObject(aliyunBucketName, path, inputStream);
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败，请检查配置信息", e);
        }

        return aliyunDomain + "/" + path;
    }


    public String upload(byte[] data) throws Exception {
        return upload(data, getPath(aliyunPrefix));
    }


    public String upload(InputStream inputStream) throws Exception {
        return upload(inputStream, getPath(aliyunPrefix));
    }

    /**
     * 文件路径
     *
     * @param prefix 前缀
     * @return 返回上传路径
     */
    public String getPath(String prefix) throws Exception {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径

        String path = DateFormatUtils.format(new Date(), "yyyyMMdd") + "/" + uuid;

        if (StringUtils.isNotBlank(prefix)) {
            path = prefix + "/" + path;
        }

        return path;
    }


}
