package io.ymq.fm.service;

import io.ymq.fm.model.base.ResultModel;
import io.ymq.fm.model.po.CloudStorageConfigPo;
import io.ymq.fm.model.po.ImagesPo;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;

/**
 * 描述:文件上传接口
 *
 * @author yanpenglei
 * @create 2017-09-05 16:17
 **/
public interface CloudStorageService {


    /**
     * 文件上传
     *
     * @param file MultipartFile
     * @return 返回http地址
     * @throws Exception
     */
    ResultModel upload(MultipartFile file) throws Exception;

    /**
     * 图片列表分页
     *
     * @param params
     * @param pageNum
     * @param pageSize
     * @return
     */
    HashMap<String, Object> selectListAndCount(String params, String pageNum, String pageSize);

    /**
     * 更新图片
     * @param imagesPo
     * @return
     */
    ResultModel<Integer> update(ImagesPo imagesPo);

    /**
     * 删除图片
     *
     * @param imagesId
     * @return
     */
    ResultModel<Integer> deleteById(Integer imagesId);

    /**
     * 插入图片
     *
     * @param imagesPo
     * @return
     */
    ResultModel<Integer> insertImages(ImagesPo imagesPo);

    /**
     * 保存云存储配置
     * @param cloudStorageConfigPo
     * @return
     * @throws Exception
     */
    ResultModel<Integer> saveCloudStorageConfig(CloudStorageConfigPo cloudStorageConfigPo) throws Exception;


    /**
     * 设置默认云存储类型
     * @param storageType
     * @return
     * @throws Exception
     */
    ResultModel<Integer> defaultCloudStorageType(String storageType) throws Exception;



}
