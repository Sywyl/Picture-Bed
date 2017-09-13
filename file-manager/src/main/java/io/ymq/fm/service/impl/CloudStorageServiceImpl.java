package io.ymq.fm.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.ymq.fm.dao.base.BaseUtils;
import io.ymq.fm.dao.base.YmqBaseDao;
import io.ymq.fm.model.base.QueryResult;
import io.ymq.fm.model.base.ResultModel;
import io.ymq.fm.model.dto.ImagesDTO;
import io.ymq.fm.model.enums.Constant;
import io.ymq.fm.model.po.CloudStorageConfigPo;
import io.ymq.fm.model.po.ImagesPo;
import io.ymq.fm.model.po.SysConfigPo;
import io.ymq.fm.service.CloudStorageService;

import io.ymq.fm.service.SysConfigService;
import io.ymq.fm.service.storage.CloudStorageFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-09-05 16:26
 **/

@Service("cloudStorageService")
public class CloudStorageServiceImpl implements CloudStorageService {

    private final Logger LOGGER = LoggerFactory.getLogger(CloudStorageServiceImpl.class);

    @Autowired
    private YmqBaseDao ymqBaseDao;

    @Autowired
    private SysConfigService sysConfigService;

    public ResultModel upload(MultipartFile file) throws Exception {

        ResultModel resultModel = new ResultModel(Constant.MessageEnum.UPLOAD_FAILURE.getKey(), Constant.MessageEnum.SUCCESS.getValue(), null);

        try {

            String url = "";

            ResultModel<CloudStorageConfigPo> cloudStorageConfig = sysConfigService.selectCloudStorageConfig();

            if (!cloudStorageConfig.getRetCode().equals(Constant.MessageEnum.SUCCESS.getKey())) {
                return new ResultModel(cloudStorageConfig.getRetCode(), cloudStorageConfig.getRetMsg(), null);
            }

            url = CloudStorageFactory.build(cloudStorageConfig.getResult()).upload(file);

            HashMap<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("url", url);
            resultMap.put("name", file.getOriginalFilename());

            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());

            ImagesPo ImagesPo = new ImagesPo();

            ImagesPo.setName(file.getOriginalFilename());
            ImagesPo.setUrl(url);
            ImagesPo.setWidth(bufferedImage.getWidth());
            ImagesPo.setHeight(bufferedImage.getHeight());

            ResultModel<Integer> count = this.insertImages(ImagesPo);

            LOGGER.info("上传图片入库：" + JSONObject.toJSONString(ImagesPo));

            resultModel = new ResultModel(StringUtils.isNotBlank(url) == true ? Constant.MessageEnum.SUCCESS.getKey() : Constant.MessageEnum.UPLOAD_FAILURE.getKey(), StringUtils.isNotBlank(url) == true ? Constant.MessageEnum.SUCCESS.getValue() : Constant.MessageEnum.UPLOAD_FAILURE.getValue(), resultMap);

            LOGGER.info(JSONObject.toJSONString(resultModel));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultModel;
    }


    @Override
    public HashMap<String, Object> selectListAndCount(String params, String pageNum, String pageSize) {

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", Constant.MessageEnum.QUERY_FAILURE.getKey());
        resultMap.put("msg", Constant.MessageEnum.QUERY_FAILURE.getValue());

        ImagesPo imagesPo = null;

        try {

            int pNum = StringUtils.isBlank(pageNum) ? 0 : Integer.parseInt(pageNum);// 第几条页
            int pSize = StringUtils.isBlank(pageSize) ? 10 : Integer.parseInt(pageSize);// 每页显示行数

            pNum = ((pNum * pSize) / pSize);

            if (StringUtils.isNotBlank(params)) {
                imagesPo = JSONObject.parseObject(params, ImagesPo.class);
            }

            QueryResult<ImagesDTO> queryResult = ymqBaseDao.selectListAndCount(BaseUtils.makeClazzPath(ImagesPo.class, "selectImagesList"), imagesPo, pNum, pSize, "supdate_time desc");

            resultMap.put("data", queryResult.getlist());
            resultMap.put("count", queryResult.getTotal());
            resultMap.put("code", Constant.MessageEnum.SUCCESS.getKey());
            resultMap.put("msg", Constant.MessageEnum.SUCCESS.getValue());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    @Override
    public ResultModel<Integer> update(ImagesPo imagesPo) {

        ResultModel resultModel = new ResultModel(Constant.MessageEnum.UPDATE_FAILURE.getKey(), Constant.MessageEnum.UPDATE_FAILURE.getValue(), null);

        try {

            Integer count = ymqBaseDao.update(BaseUtils.makeClazzPath(ImagesPo.class, "updateImages"), imagesPo);

            resultModel = new ResultModel(count > 0 ? Constant.MessageEnum.SUCCESS.getKey() : Constant.MessageEnum.UPDATE_FAILURE.getKey(), count > 0 ? Constant.MessageEnum.SUCCESS.getValue() : Constant.MessageEnum.UPDATE_FAILURE.getValue(), count);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultModel;
    }

    @Override
    public ResultModel<Integer> deleteById(Integer imagesId) {

        ResultModel resultModel = new ResultModel(Constant.MessageEnum.DELETE_FAILURE.getKey(), Constant.MessageEnum.DELETE_FAILURE.getValue(), null);

        try {
            ImagesPo imagesPo = new ImagesPo();
            imagesPo.setImagesId(imagesId);

         /*   ResultModel<CloudStorageConfigPo> cloudStorageConfig = sysConfigService.selectCloudStorageConfig();

            if (!cloudStorageConfig.getRetCode().equals(Constant.MessageEnum.SUCCESS.getKey())) {
                return new ResultModel(cloudStorageConfig.getRetCode(), cloudStorageConfig.getRetMsg(), null);
            }

            ImagesPo  images = ymqBaseDao.selectOne(imagesPo);

            CloudStorageFactory.build(cloudStorageConfig.getResult()).deleteObject(images.getUrl());*/

            Integer count = ymqBaseDao.delete(imagesPo);

            resultModel = new ResultModel(count > 0 ? Constant.MessageEnum.SUCCESS.getKey() : Constant.MessageEnum.DELETE_FAILURE.getKey(), count > 0 ? Constant.MessageEnum.SUCCESS.getValue() : Constant.MessageEnum.DELETE_FAILURE.getValue(), count);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultModel;
    }

    @Override
    public ResultModel<Integer> insertImages(ImagesPo imagesPo) {

        ResultModel resultModel = new ResultModel(Constant.MessageEnum.ADD_FAILURE.getKey(), Constant.MessageEnum.ADD_FAILURE.getValue(), null);

        try {

            imagesPo.setStatus(0);
            imagesPo.setCreateUser(0);
            imagesPo.setUpdateUser(0);
            imagesPo.setScreateTime(new Date());
            imagesPo.setSupdateTime(new Date());

            Integer count = ymqBaseDao.insert(imagesPo);

            return new ResultModel(count > 0 ? Constant.MessageEnum.SUCCESS.getKey() : Constant.MessageEnum.ADD_FAILURE.getKey(), count > 0 ? Constant.MessageEnum.SUCCESS.getValue() : Constant.MessageEnum.ADD_FAILURE.getValue(), count);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultModel;
    }

    @Override
    public ResultModel<Integer> saveCloudStorageConfig(CloudStorageConfigPo cloudStorageConfigPo) throws Exception {

        ResultModel resultModel = new ResultModel(Constant.MessageEnum.ADD_FAILURE.getKey(), Constant.MessageEnum.ADD_FAILURE.getValue(), null);

        try {
            SysConfigPo sysConfigPo = new SysConfigPo();

            sysConfigPo.setConfigKey(Constant.SysConfigEnum.CLOUD_STORAGE.getKey());
            sysConfigPo.setConfigValue(JSONObject.toJSONString(cloudStorageConfigPo));
            sysConfigPo.setCreateUser(0);
            sysConfigPo.setUpdateUser(0);


            SysConfigPo sysConfigPoParams = new SysConfigPo();

            sysConfigPoParams.setConfigKey(Constant.SysConfigEnum.CLOUD_STORAGE.getKey());

            SysConfigPo config = ymqBaseDao.selectOne(sysConfigPoParams);

            if (config != null) {

                config.setConfigValue(JSONObject.toJSONString(cloudStorageConfigPo));

                Integer count = ymqBaseDao.update(config);

                return new ResultModel(count > 0 ? Constant.MessageEnum.SUCCESS.getKey() : Constant.MessageEnum.ADD_FAILURE.getKey(), count > 0 ? Constant.MessageEnum.SUCCESS.getValue() : Constant.MessageEnum.ADD_FAILURE.getValue(), count);
            }

            Integer count = ymqBaseDao.insert(sysConfigPo);

            resultModel = new ResultModel(count > 0 ? Constant.MessageEnum.SUCCESS.getKey() : Constant.MessageEnum.ADD_FAILURE.getKey(), count > 0 ? Constant.MessageEnum.SUCCESS.getValue() : Constant.MessageEnum.ADD_FAILURE.getValue(), count);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultModel;
    }

    @Override
    public ResultModel<Integer> defaultCloudStorageType(String storageType) throws Exception {

        ResultModel resultModel = new ResultModel(Constant.MessageEnum.UPDATE_FAILURE.getKey(), Constant.MessageEnum.UPDATE_FAILURE.getValue(), null);

        try {

            SysConfigPo sysConfigPoParams = new SysConfigPo();
            CloudStorageConfigPo cloudStorageConfigPo = null;
            sysConfigPoParams.setConfigKey(Constant.SysConfigEnum.CLOUD_STORAGE.getKey());

            SysConfigPo config = ymqBaseDao.selectOne(sysConfigPoParams);

            if (config == null) {
                return new ResultModel(Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getKey(), Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getValue(), null);
            }

            if (StringUtils.isNotBlank(config.getConfigValue())) {
                cloudStorageConfigPo = JSONObject.parseObject(config.getConfigValue(), CloudStorageConfigPo.class);
            }
            if (cloudStorageConfigPo != null) {
                cloudStorageConfigPo.setStorageType(storageType);
            } else {
                cloudStorageConfigPo = new CloudStorageConfigPo();
                cloudStorageConfigPo.setStorageType(storageType);
            }
            config.setConfigValue(JSONObject.toJSONString(cloudStorageConfigPo));

            Integer count = ymqBaseDao.update(config);

            return new ResultModel(count > 0 ? Constant.MessageEnum.SUCCESS.getKey() : Constant.MessageEnum.UPDATE_FAILURE.getKey(), count > 0 ? Constant.MessageEnum.SUCCESS.getValue() : Constant.MessageEnum.UPDATE_FAILURE.getValue(), count);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultModel;

    }

}
