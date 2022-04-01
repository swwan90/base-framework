package com.swwan.research.design.complex.functionalinterface;

import org.springframework.stereotype.Service;

/**
 * 如果单个 if 语句块的业务逻辑有很多行的话，
 * 可以把这些 业务操作抽出来，写成一个单独的Service
 *
 * @author swwan
 * @date 2022/4/1 - 22:33
 */
@Service
public class GrantTypeService {

    public String redPaper(String resourceId) {
        // 红发的发放方式
        return "每周末9点";
    }

    public String shopping(String resourceId) {
        // 购物券的发放方式
        return "每周三10点";
    }

    public String QQVip(String resourceId) {
        // qq会员的发放方式
        return "每周一0点";
    }
}
