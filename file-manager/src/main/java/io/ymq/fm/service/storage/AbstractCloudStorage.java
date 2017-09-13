package io.ymq.fm.service.storage;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-09-11 23:42
 **/
public abstract class AbstractCloudStorage {

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

    /**
     * 文件路径
     *
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 返回上传路径
     */
    public String getPath(String prefix, String suffix) throws Exception {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径
        String path = DateFormatUtils.format(new Date(), "yyyyMMdd") + "/" + uuid;

        if (StringUtils.isNotBlank(prefix)) {
            path = prefix + "/" + path + suffix;
        }

        return path;
    }

    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @param path 文件路径，包含文件名
     * @return 返回http地址
     */
    public abstract String upload(byte[] data, String path) throws Exception;

    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @return 返回http地址
     */
    public abstract String upload(byte[] data) throws Exception;

    /**
     * 文件上传
     *
     * @param data
     * @return 返回http地址
     * @throws Exception
     */
    public abstract String upload(MultipartFile data) throws Exception;


    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param path        文件路径，包含文件名
     * @return 返回http地址
     */
    public abstract String upload(InputStream inputStream, String path) throws Exception;

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @return 返回http地址
     */
    public abstract String upload(InputStream inputStream) throws Exception;

    /**
     * 删除单个文件:
     *
     * @param key
     * @return
     * @throws Exception
     */
    public abstract void deleteObject(String key) throws Exception;

}
