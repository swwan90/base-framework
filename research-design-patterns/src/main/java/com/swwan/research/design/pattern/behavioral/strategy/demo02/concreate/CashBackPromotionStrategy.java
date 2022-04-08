package com.swwan.research.design.pattern.behavioral.strategy.demo02.concreate;

import com.swwan.research.design.pattern.behavioral.strategy.demo02.PromotionStrategy;

/**
 * 返现促销
 *
 * @author swwan
 * @date 2022/4/8 - 23:24
 */
public class CashBackPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销,返回的金额放到 Learner 用户的余额中");
    }
}
