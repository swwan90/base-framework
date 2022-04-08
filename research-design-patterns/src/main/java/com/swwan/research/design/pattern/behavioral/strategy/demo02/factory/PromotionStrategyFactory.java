package com.swwan.research.design.pattern.behavioral.strategy.demo02.factory;

import com.google.common.collect.Maps;
import com.swwan.research.design.pattern.behavioral.strategy.demo02.PromotionStrategy;
import com.swwan.research.design.pattern.behavioral.strategy.demo02.concreate.CashBackPromotionStrategy;
import com.swwan.research.design.pattern.behavioral.strategy.demo02.concreate.EmptyPromotionStrategy;
import com.swwan.research.design.pattern.behavioral.strategy.demo02.concreate.FullOffPromotionStrategy;
import com.swwan.research.design.pattern.behavioral.strategy.demo02.concreate.MinusPromotionStrategy;

import java.util.Map;

/**
 * 策略工厂
 *
 * @author swwan
 * @date 2022/4/8 - 23:29
 */
public class PromotionStrategyFactory {

    private static final PromotionStrategy NON_PROMOTION = new EmptyPromotionStrategy();
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = Maps.newHashMap();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.LIJIAN, new MinusPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.FANXIAN, new FullOffPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.MANJIAN, new CashBackPromotionStrategy());
    }

    /**
     * 不希望外部调用
     */
    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }

    /**
     * 填充 map 中的 key
     */
    private interface PromotionKey {
        String LIJIAN = "LIJIAN";
        String FANXIAN = "FANXIAN";
        String MANJIAN = "MANJIAN";
    }
}
