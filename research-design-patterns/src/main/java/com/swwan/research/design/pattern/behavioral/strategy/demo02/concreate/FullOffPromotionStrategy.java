package com.swwan.research.design.pattern.behavioral.strategy.demo02.concreate;

import com.swwan.research.design.pattern.behavioral.strategy.demo02.PromotionStrategy;

/**
 * 满减促销
 *
 * @author swwan
 * @date 2022/4/8 - 23:24
 */
public class FullOffPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销,满200减20元");
    }
}
