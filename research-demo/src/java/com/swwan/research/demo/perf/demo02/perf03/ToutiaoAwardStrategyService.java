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
public class ToutiaoAwardStrategyService extends BaseAwardTemplate implements AwardStrategy {
    @Override
    public Boolean awardStrategy(String userId) {
        return super.awardTemplate(userId);
    }

    @Override
    public String getSource() {
        return "toutiao";
    }

    @Override
    protected Boolean awardRecord(String userId) {
        log.info("头条渠道用户{}奖励50元红包!", userId);
        return Boolean.TRUE;
    }
}
