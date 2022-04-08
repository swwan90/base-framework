package com.swwan.research.design.pattern.behavioral.strategy.demo02.concreate;

import com.swwan.research.design.pattern.behavioral.strategy.demo02.PromotionStrategy;

/**
 * 立减促销
 *
 * @author swwan
 * @date 2022/4/8 - 23:24
 */
public class MinusPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("立减促销,资源的价格直接减去配置的价格");
    }
}
