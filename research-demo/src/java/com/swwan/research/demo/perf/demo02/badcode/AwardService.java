package com.swwan.research.demo.perf.demo02.badcode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author swwan
 * @date 2022/3/4 - 23:15
 */
@Service
@Slf4j
public class AwardService {

    public Boolean toutiaoReward(String userId) {
        log.info("头条渠道用户{}奖励50元红包!", userId);
        return Boolean.TRUE;
    }

    public Boolean wxReward(String userId) {
        log.info("微信渠道用户{}奖励100元红包!", userId);
        return Boolean.TRUE;
    }
}
