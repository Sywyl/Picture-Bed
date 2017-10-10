package io.ymq.fm.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.ymq.fm.dao.base.YmqBaseDao;
import io.ymq.fm.model.base.ResultModel;

import io.ymq.fm.model.enums.Constant;
import io.ymq.fm.model.po.CloudStorageConfigPo;
import io.ymq.fm.model.po.SysConfigPo;
import io.ymq.fm.service.SysConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述: 系统配置
 *
 * @author yanpenglei
 * @create 2017-09-11 22:31
 **/
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private YmqBaseDao ymqBaseDao;



    @Override
    public ResultModel<CloudStorageConfigPo> selectCloudStorageConfig() {

        ResultModel resultModel = new ResultModel(Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getKey(), Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getValue(), null);

        SysConfigPo sysConfigPo = new SysConfigPo();

        sysConfigPo.setConfigKey(Constant.SysConfigEnum.CLOUD_STORAGE.getKey());

        try {

            SysConfigPo sysConfig = ymqBaseDao.selectOne(sysConfigPo);

            if (sysConfig == null || StringUtils.isBlank(sysConfig.getConfigValue())) return resultModel;

            CloudStorageConfigPo cloudStorageConfigPo = JSONObject.parseObject(sysConfig.getConfigValue(), CloudStorageConfigPo.class);

            return new ResultModel(Constant.MessageEnum.SUCCESS.getKey(), Constant.MessageEnum.SUCCESS.getValue(), cloudStorageConfigPo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultModel;

    }

}










