package io.ymq.fm.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 描述:文件上传接口
 *
 * @author yanpenglei
 * @create 2017-09-05 16:17
 **/
public interface UploadOSSCloud {


    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @param type 上传服务商类型
     * @return 返回http地址
     */
    public abstract String upload(byte[] data, String type) throws Exception;

}
