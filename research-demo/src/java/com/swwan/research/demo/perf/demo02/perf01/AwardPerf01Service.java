package com.swwan.research.demo.perf.demo02.perf01;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * @author swwan
 * @date 2022/3/4 - 23:15
 */
@Service
@Slf4j
public class AwardPerf01Service {

    private Map<String, BiFunction<String, String, Boolean>> sourceMap = Maps.newHashMap();

    @PostConstruct
    private void dispatcher() {
        sourceMap.put("wx", (userId, source) -> this.wxReward(userId));
        sourceMap.put("toutiao", (userId, source) -> this.wxReward(userId));
    }

    public Boolean toutiaoReward(String userId) {
        log.info("头条渠道用户{}奖励50元红包!", userId);
        return Boolean.TRUE;
    }

    public Boolean wxReward(String userId) {
        log.info("微信渠道用户{}奖励100元红包!", userId);
        return Boolean.TRUE;
    }

    public Boolean getRewardResult(String userId, String source) {
        BiFunction<String, String, Boolean> result = sourceMap.get(source);
        if (Objects.nonNull(result)) {
            return result.apply(userId, source);
        }
        return Boolean.FALSE;
    }
}
