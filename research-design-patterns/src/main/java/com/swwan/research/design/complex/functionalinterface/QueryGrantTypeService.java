package com.swwan.research.design.complex.functionalinterface;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.function.Function;

/**
 * Map+函数式接口通过Map.get(key)来代替 if-else的业务分派，
 * 能够避免策略模式带来的类增多、难以俯视整个业务逻辑的问题。
 *
 * @author swwan
 * @date 2022/4/1 - 22:24
 */
@Service
public class QueryGrantTypeService {

    @Autowired
    private GrantTypeService grantTypeService;
    private Map<String, Function<String, String>> grantTypeMap = Maps.newHashMap();

    /**
     * 初始化业务分派逻辑，替代 if-else
     * <p>
     * key：优惠券类型
     * value：lambda 表达式，最终会获得该优惠券的发放方式
     */
    @PostConstruct
    public void dispatcherInit() {
        grantTypeMap.put("红包", resourceId -> grantTypeService.redPaper(resourceId));
        grantTypeMap.put("购物券", resourceId -> grantTypeService.shopping(resourceId));
        grantTypeMap.put("qq会员", resourceId -> grantTypeService.QQVip(resourceId));
    }

    public String getResult(String resourceType, String resourceId) {
        // controller 根据优惠券类型 resourceType、编码 resourceId 去查询发放方式 grantType
        Function<String, String> result = grantTypeMap.get(resourceType);
        if (result != null) {
            // 传入 resourceId 执行这段表达式获得String 型的 grantType
            return result.apply(resourceId);
        }
        return "查询不到该优惠券的发放方式";
    }
}
