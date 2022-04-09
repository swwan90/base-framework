package com.swwan.research.demo.perf.demo02.perf03;

/**
 * @author swwan
 * @date 2022/3/4 - 23:47
 */
public interface AwardStrategy {

    /**
     * 奖励发放接口
     */
    Boolean awardStrategy(String userId);

    /**
     * 获取策略标识，即不同渠道的来源标识
     */
    default String getSource() {
        return "default";
    }
}
