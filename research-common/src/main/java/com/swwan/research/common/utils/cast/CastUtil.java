package com.swwan.research.common.utils.cast;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 类型转换工具类
 *
 * @author swwan
 * @date 2021/12/18 - 16:57
 */
@Slf4j
public class CastUtil {

    @SuppressWarnings("unchecked")
    public static <T> T castObject2Type(Object obj) {
        try {
            return (T) obj;
        } catch (ClassCastException e) {
            log.error("类型转换出错：source = [{}]", JSONUtil.toJsonStr(obj));
            log.error("完整堆栈信息：", e);
            return null;
        }
    }
}
