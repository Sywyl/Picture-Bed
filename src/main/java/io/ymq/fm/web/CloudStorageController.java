package io.ymq.fm.web;

import com.alibaba.fastjson.JSONObject;
import io.ymq.fm.model.base.ResultModel;
import io.ymq.fm.model.enums.Constant;
import io.ymq.fm.model.po.CloudStorageConfigPo;
import io.ymq.fm.model.po.ImagesPo;
import io.ymq.fm.service.CloudStorageService;

import io.ymq.fm.service.SysConfigService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;


/**
 * 描述: 上传功能首页
 *
 * @author yanpenglei
 * @create 2017-09-04 17:59
 **/
@RestController
@RequestMapping("ymq/cloudStorage")
public class CloudStorageController {

    private static final Logger LOG = LoggerFactory.getLogger(CloudStorageController.class);

    @Autowired
    private CloudStorageService cloudStorageService;

    @Autowired
    private SysConfigService sysConfigService;

    private String params;

    /**
     * 上传图片
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload")
    public ResultModel upload(@RequestParam("file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new RuntimeException("上传文件不能为空");
        }
        return cloudStorageService.upload(file);
    }

    /**
     * 图片列表分页
     *
     * @param params
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/getImagesList")
    public HashMap<String, Object> upload(@RequestParam String params, String pageNum, String pageSize) throws Exception {
        return cloudStorageService.selectListAndCount(params, pageNum, pageSize);
    }

    /**
     * 更新图片
     *
     * @param params
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultModel<Integer> update(@RequestParam String params) throws Exception {

        if (StringUtils.isBlank(params)) {
            new ResultModel(Constant.MessageEnum.PARAMS_EXCEPTION.getKey(), Constant.MessageEnum.PARAMS_EXCEPTION.getValue(), null);
        }

        ImagesPo imagesPo = JSONObject.parseObject(params, ImagesPo.class);

        return cloudStorageService.update(imagesPo);
    }

    /**
     * 删除图片
     *
     * @param imagesId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteById")
    public ResultModel<Integer> deleteById(@RequestParam Integer imagesId) throws Exception {
        return cloudStorageService.deleteById(imagesId);
    }

    /**
     * 保存云存储配置
     *
     * @param params
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/saveCloudStorageConfig", method = RequestMethod.POST)
    public ResultModel<Integer> saveCloudStorageConfig(@RequestParam String params) throws Exception {

        if (StringUtils.isBlank(params)) {
            new ResultModel(Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getKey(), Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getValue(), null);
        }

        CloudStorageConfigPo CloudStorageConfigPo = JSONObject.parseObject(params, CloudStorageConfigPo.class);

        return cloudStorageService.saveCloudStorageConfig(CloudStorageConfigPo);

    }


    /**
     * 设置默认云存储类型
     *
     * @param storageType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/defaultCloudStorageType", method = RequestMethod.POST)
    public ResultModel<Integer> defaultCloudStorageType(@RequestParam String storageType) throws Exception {

        if (StringUtils.isBlank(params)) {
            new ResultModel(Constant.MessageEnum.PARAMS_EXCEPTION.getKey(), Constant.MessageEnum.PARAMS_EXCEPTION.getValue(), null);
        }

        return cloudStorageService.defaultCloudStorageType(storageType);
    }

    /**
     * 描述: 查询云存储配置
     * author: yanpenglei
     * Date: 2017/9/12 13:21
     */
    @RequestMapping("/selectCloudStorageConfig")
    public ResultModel<CloudStorageConfigPo> selectCloudStorageConfig() throws Exception {
        return sysConfigService.selectCloudStorageConfig();
    }


}
