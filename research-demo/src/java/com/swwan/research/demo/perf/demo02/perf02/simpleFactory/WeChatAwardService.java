package com.swwan.research.demo.perf.demo02.perf02.simpleFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author swwan
 * @date 2022/3/4 - 23:39
 */
@Slf4j
public class WeChatAwardService extends AwardAbstract {
    @Override
    public Boolean award(String userId) {
        log.info("微信渠道用户{}奖励100元红包!", userId);
        return Boolean.TRUE;
    }
}
