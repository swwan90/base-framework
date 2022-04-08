package com.swwan.research.design.pattern.behavioral.strategy.demo02.concreate;

import com.swwan.research.design.pattern.behavioral.strategy.demo02.PromotionStrategy;

/**
 * 代替 null，防止空指针异常
 *
 * @author swwan
 * @date 2022/4/8 - 23:24
 */
public class EmptyPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销");
    }
}
