package io.ymq.fm.service;

import io.ymq.fm.model.base.ResultModel;
import io.ymq.fm.model.po.CloudStorageConfigPo;
import io.ymq.fm.model.po.SysConfigPo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述: 系统配置
 *
 * @author yanpenglei
 * @create 2017-09-11 22:27
 **/
public interface SysConfigService {


    /**
     * 描述: 查询云存储配置
     * author: yanpenglei
     * Date: 2017/9/12 13:21
     */
    ResultModel<CloudStorageConfigPo>  selectCloudStorageConfig();


}
