package io.ymq.fm.model.enums;

/**
 * 描述: 不变枚举
 *
 * @author yanpenglei
 * @create 2017-09-11 22:57
 **/
public class Constant {


    /**
     * 描述:系统配置枚举
     * author: yanpenglei
     * Date: 2017/9/12 0:03
     */
    public enum SysConfigEnum {

        CLOUD_STORAGE("CLOUD_STORAGE", "云存储枚举");

        private final String key;

        private final String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        SysConfigEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public static String getSysConfigEnumValue(String key) {
            SysConfigEnum[] enums = SysConfigEnum.values();
            for (int i = 0; key != "" && key != null && i < enums.length; i++) {
                if (enums[i].getKey().trim().equals(key.trim())) {
                    return enums[i].getValue();
                }
            }
            return "";
        }

    }


    /**
     * 描述: 消息枚举
     * author: yanpenglei
     * Date: 2017/9/8 21:34
     */
    public enum MessageEnum {

        /**
         * 请求已成功处理
         */
        SUCCESS("000000", "请求已成功处理"),

        /**
         * 请求参数异常
         */
        PARAMS_EXCEPTION("200000", "请求参数异常"),

        /**
         * 查询失败
         */
        QUERY_FAILURE("300000", "查询失败"),
        /**
         * 添加失败
         */
        ADD_FAILURE("310000", "添加失败"),

        /**
         * 更新失败
         */
        UPDATE_FAILURE("320000", "更新失败"),

        /**
         * 删除失败
         */
        DELETE_FAILURE("330000", "删除失败"),

        /**
         * 上传失败
         */
        UPLOAD_FAILURE("400000", "上传失败"),

        /**
         * 请先配置云存储
         */
        CLOUD_STORAGE_IS_EMPTY("400001", "请先配置云存储"),
        /**
         * 上传文件不能为空
         */
        UPLOAD_IS_EMPTY("410000", "上传文件不能为空");

        private final String key;

        private final String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        MessageEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public static String getMessageEnumValue(String key) {
            MessageEnum[] enums = MessageEnum.values();
            for (int i = 0; key != "" && key != null && i < enums.length; i++) {
                if (enums[i].getKey().trim().equals(key.trim())) {
                    return enums[i].getValue();
                }
            }
            return "";
        }

    }


    /**
     * 描述: 上传服务商枚举类型
     *
     * @author yanpenglei
     * @create 2017-09-05 16:42
     **/
    public enum CloudStorageEnum {

        ALIYUN("ALIYUN", "阿里云"),

        QINIUYUN("QINIUYUN", "七牛云"),

        TENGXUN("TENGXUN", "腾讯云");

        private final String key;

        private final String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        CloudStorageEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public static String getCloudStorageEnumValue(String key) {
            CloudStorageEnum[] enums = CloudStorageEnum.values();
            for (int i = 0; key != "" && key != null && i < enums.length; i++) {
                if (enums[i].getKey().trim().equals(key.trim())) {
                    return enums[i].getValue();
                }
            }
            return "";
        }

    }

}
