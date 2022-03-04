package com.swwan.research.demo.perf.demo02.perf02.simpleFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author swwan
 * @date 2022/3/4 - 23:38
 */
@Slf4j
public class TouTiaoAwardService extends AwardAbstract {
    @Override
    public Boolean award(String userId) {
        log.info("头条渠道用户{}奖励50元红包!", userId);
        return Boolean.TRUE;
    }
}
