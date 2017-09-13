package io.ymq.fm.model.dto;

import java.util.Date;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-09-09 16:31
 **/
public class ImagesDTO {

    /**
     * 图像ID       db_column: images_id
     */
    private Integer imagesId;
    /**
     * 名称       db_column: name
     */
    private String name;
    /**
     * 宽       db_column: width
     */
    private Integer width;
    /**
     * 高       db_column: height
     */
    private Integer height;
    /**
     * 路径       db_column: url
     */
    private String url;
    /**
     * 备注       db_column: remark
     */
    private String remark;
    /**
     * 创建时间       db_column: screate_time
     */
    private java.util.Date screateTime;
    /**
     * 更新时间       db_column: supdate_time
     */
    private java.util.Date supdateTime;

    public Integer getImagesId() {
        return imagesId;
    }

    public void setImagesId(Integer imagesId) {
        this.imagesId = imagesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getScreateTime() {
        return screateTime;
    }

    public void setScreateTime(Date screateTime) {
        this.screateTime = screateTime;
    }

    public Date getSupdateTime() {
        return supdateTime;
    }

    public void setSupdateTime(Date supdateTime) {
        this.supdateTime = supdateTime;
    }
}