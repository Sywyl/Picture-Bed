package io.ymq.fm.service.impl;

import io.ymq.fm.model.UploadEnum;
import io.ymq.fm.service.UploadOSSCloud;
import io.ymq.fm.service.storage.AliyunCloudStorageService;
import io.ymq.fm.service.storage.QiniuCloudStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-09-05 16:26
 **/

@Service("uploadOSSCloud")
public class UploadOSSCloudImpl implements UploadOSSCloud {

    @Autowired
    private AliyunCloudStorageService aliyunCloudStorageService;

    @Autowired
    private QiniuCloudStorageService qiniuCloudStorageService;

    public String upload(byte[] data, String type) throws  Exception {

        if (UploadEnum.ALIYUN.getKey().equals(type)) {

            return "http://"+aliyunCloudStorageService.upload(data);

        } else if (UploadEnum.QINIUYUN.getKey().equals(type)) {

            return qiniuCloudStorageService.upload(data);
        }

        return "";
    }


}
