package com.swwan.research.design.complex.autoward;

/**
 * @author swwan
 * @date 2022/4/1 - 22:03
 */
public enum SettingTypeEnum {

    RECTANGLE("1", "rectangle", "矩形"),
    CIRCLE("2", "circle", "圆形"),
    ;

    public String code;
    /**
     * 接口的实现类名
     */
    public String implement;
    /**
     * 备注
     */
    public String desc;

    SettingTypeEnum(String code, String implement, String desc) {
        this.code = code;
        this.implement = implement;
        this.desc = desc;
    }
}
