package io.ymq.fm.web;

import io.ymq.fm.model.ResultModel;
import io.ymq.fm.service.UploadOSSCloud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;


/**
 * 描述: 上传功能首页
 *
 * @author yanpenglei
 * @create 2017-09-04 17:59
 **/
@RestController
@RequestMapping("ymq/cloud")
public class CloudController {

    private static final Logger LOG = LoggerFactory.getLogger(CloudController.class);


    //阿里云绑定的域名
    @Value("${oss.cloud.type}")
    private String ossCloudType;

    @Autowired
    private UploadOSSCloud uploadOSSCloud;

    @RequestMapping("/upload")
    public ResultModel upload(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("上传文件不能为空");
            }

            String url = uploadOSSCloud.upload(file.getBytes(), ossCloudType);

            LOG.info("url：{}", url);

            HashMap<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("url", url);
            resultMap.put("name", file.getOriginalFilename());

            return new ResultModel("000000", "上传文件成功", resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }


}
