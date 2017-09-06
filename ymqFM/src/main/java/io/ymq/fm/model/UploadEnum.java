package io.ymq.fm.model;

/**
 * 描述: 上传服务商类型
 *
 * @author yanpenglei
 * @create 2017-09-05 16:42
 **/
public enum UploadEnum {

    ALIYUN("1", "阿里云"),

    QINIUYUN("2", "七牛云"),

    TENGXUN("3", "腾讯云");

    private final String key;

    private final String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    UploadEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getUploadEnumEnumValue(String key) {
        UploadEnum[] enums = UploadEnum.values();
        for (int i = 0; key != "" && key != null && i < enums.length; i++) {
            if (enums[i].getKey().trim().equals(key.trim())) {
                return enums[i].getValue();
            }
        }
        return "";
    }


}
