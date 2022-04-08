package com.swwan.research.design.pattern.behavioral.strategy.demo02;

import com.swwan.research.design.pattern.behavioral.strategy.demo02.factory.PromotionStrategyFactory;

/**
 * @author swwan
 * @date 2022/4/8 - 23:27
 */
public class PromotionStrategyTest {

    public static void main(String[] args) {
        String promotionKey = "LIJIAN";
        PromotionActivity promotionActivity = new PromotionActivity(
                PromotionStrategyFactory.getPromotionStrategy(promotionKey)
        );

        promotionActivity.executePromotionStrategy();
    }
}
