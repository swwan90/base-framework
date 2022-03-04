package com.swwan.research.demo.perf.demo02.perf03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 实现不同渠道的奖励业务
 *
 * @author swwan
 * @date 2022/3/4 - 23:52
 */
@Slf4j
@Service
public class WeChatAwardStrategyService extends BaseAwardTemplate implements AwardStrategy {
    @Override
    public Boolean awardStrategy(String userId) {
        return super.awardTemplate(userId);
    }

    @Override
    public String getSource() {
        return "wx";
    }

    @Override
    protected Boolean awardRecord(String userId) {
        log.info("微信渠道用户{}奖励100元红包!", userId);
        return Boolean.TRUE;
    }
}
