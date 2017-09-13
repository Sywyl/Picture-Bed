package io.ymq.fm.service.storage;

import io.ymq.fm.model.enums.Constant;
import io.ymq.fm.model.po.CloudStorageConfigPo;


/**
 * 文件上传Factory
 */
public final class CloudStorageFactory {

    public static AbstractCloudStorage build(CloudStorageConfigPo cloudStorageConfigPo) {

        if (cloudStorageConfigPo.getStorageType().equals(Constant.CloudStorageEnum.QINIUYUN.getKey())) {

            return new QiniuCloudStorageService(cloudStorageConfigPo);

        } else if (cloudStorageConfigPo.getStorageType().equals(Constant.CloudStorageEnum.ALIYUN.getKey())) {

            return new AliyunCloudStorageService(cloudStorageConfigPo);
        }

        return null;
    }

}
