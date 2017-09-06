package io.ymq.fm.service.storage;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;

import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * 七牛云存储
 */
@Service("qiniuCloudStorageService")
public class QiniuCloudStorageService {

    //七牛绑定的域名
    @Value("${oss.cloud.qiniuDomain}")
    private String qiniuDomain;
    //七牛路径前缀.
    @Value("${oss.cloud.qiniuPrefix}")
    private String qiniuPrefix;

    //七牛ACCESS_KEY
    @Value("${oss.cloud.qiniuAccessKey}")
    private String qiniuAccessKey;

    //七牛SECRET_KEY
    @Value("${oss.cloud.qiniuSecretKey}")
    private String qiniuSecretKey;

    //七牛存储空间名
    @Value("${oss.cloud.qiniuBucketName}")
    private String qiniuBucketName;

    private UploadManager uploadManager;

    private String token;


    public String upload(byte[] data, String path) throws Exception {
        try {

            uploadManager = new UploadManager(new Configuration(Zone.autoZone()));

            token = Auth.create(qiniuAccessKey, qiniuSecretKey).uploadToken(qiniuBucketName);

            Response res = uploadManager.put(data, path, token);

            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败，请核对七牛配置信息", e);
        }

        return qiniuDomain + "/" + path;
    }


    public String upload(InputStream inputStream, String path) throws Exception {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new RuntimeException("上传文件失败", e);
        }
    }


    public String upload(byte[] data) throws Exception {
        return upload(data, getPath(qiniuPrefix));
    }


    public String upload(InputStream inputStream) throws Exception {
        return upload(inputStream, getPath(qiniuPrefix));
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
