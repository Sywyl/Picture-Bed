package io.ymq.fm.service.storage;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;

import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import io.ymq.fm.model.po.CloudStorageConfigPo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;

/**
 * 七牛云存储
 */
public class QiniuCloudStorageService extends AbstractCloudStorage {

    private CloudStorageConfigPo cloudStorageConfigPo;

    public QiniuCloudStorageService(CloudStorageConfigPo cloudStorageConfigPo) {
        this.cloudStorageConfigPo = cloudStorageConfigPo;
    }

    private UploadManager uploadManager;

    private String token;


    public String upload(byte[] data, String path) throws Exception {
        try {

            uploadManager = new UploadManager(new Configuration(Zone.autoZone()));

            token = Auth.create(cloudStorageConfigPo.getQiniuAccessKey(), cloudStorageConfigPo.getQiniuSecretKey()).uploadToken(cloudStorageConfigPo.getQiniuBucketName());

            Response res = uploadManager.put(data, path, token);

            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败，请核对七牛配置信息", e);
        }

        return cloudStorageConfigPo.getQiniuDomain() + "/" + path;
    }

    public String upload(MultipartFile data)throws Exception{
        String filename = data.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        return upload(data.getBytes(),getPath(cloudStorageConfigPo.getAliyunPrefix(),suffix));
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
        return upload(data, getPath(cloudStorageConfigPo.getQiniuPrefix()));
    }


    public String upload(InputStream inputStream) throws Exception {
        return upload(inputStream, getPath(cloudStorageConfigPo.getQiniuPrefix()));
    }

    @Override
    public void deleteObject(String key) throws Exception {

    }

}
