package com.swwan.research.design.pattern.behavioral.strategy.demo02;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 促销活动
 *
 * @author swwan
 * @date 2022/4/8 - 23:26
 */
@AllArgsConstructor
@RequiredArgsConstructor
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public void executePromotionStrategy() {
        promotionStrategy.doPromotion();
    }
}
