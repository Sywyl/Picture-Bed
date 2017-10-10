package io.ymq.fm.service.storage;

import com.aliyun.oss.OSSClient;

import io.ymq.fm.model.po.CloudStorageConfigPo;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 描述: 阿里云存储配置
 * author: yanpenglei
 * Date: 2017/9/5 17:15
 */

public class AliyunCloudStorageService extends AbstractCloudStorage {

    private CloudStorageConfigPo cloudStorageConfigPo;

    public AliyunCloudStorageService(CloudStorageConfigPo cloudStorageConfigPo) {
        this.cloudStorageConfigPo = cloudStorageConfigPo;
    }


    public String upload(byte[] data, String path) throws Exception {
        return upload(new ByteArrayInputStream(data), path);
    }


    public String upload(InputStream inputStream, String path) throws Exception {
        try {
            OSSClient client = new OSSClient(cloudStorageConfigPo.getAliyunEndPoint(), cloudStorageConfigPo.getAliyunAccessKeyId(), cloudStorageConfigPo.getAliyunAccessKeySecret());

            client.putObject(cloudStorageConfigPo.getAliyunBucketName(), path, inputStream);
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败，请检查配置信息", e);
        }

        return "http://"+cloudStorageConfigPo.getAliyunDomain() + "/" + path;
    }


    public String upload(byte[] data) throws Exception {
        return upload(data, getPath(cloudStorageConfigPo.getAliyunPrefix()));
    }

    public String upload(MultipartFile data)throws Exception{
        String filename = data.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        return upload(data.getBytes(),getPath(cloudStorageConfigPo.getAliyunPrefix(),suffix));
    }


    public String upload(InputStream inputStream) throws Exception {
        return upload(inputStream, getPath(cloudStorageConfigPo.getAliyunPrefix()));
    }

    @Override
    public void deleteObject(String key) throws Exception {

        try {
            OSSClient client = new OSSClient(cloudStorageConfigPo.getAliyunEndPoint(), cloudStorageConfigPo.getAliyunAccessKeyId(), cloudStorageConfigPo.getAliyunAccessKeySecret());

            client.deleteObject(cloudStorageConfigPo.getAliyunBucketName(),key);
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败，请检查配置信息", e);
        }

    }


}
