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

    private static final Map<String, BiFunction<String, String, Boolean>> SOURCE_MAP = Maps.newHashMap();
//    private static final Map<String, BiPredicate<String, String>> SOURCE_MAP1 = Maps.newHashMap();

    @PostConstruct
    private void dispatcher() {
        SOURCE_MAP.put("wx", (userId, source) -> this.wxReward(userId));
        SOURCE_MAP.put("toutiao", (userId, source) -> this.wxReward(userId));
//        SOURCE_MAP1.put("toutiao", (userId, source) -> this.wxReward(userId));
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
        BiFunction<String, String, Boolean> result = SOURCE_MAP.get(source);
        if (Objects.nonNull(result)) {
            return result.apply(userId, source);
        }
        return Boolean.FALSE;
    }

    /**
     * 使用 BiPredicate 类型函数式接口代替 BiFunction
     */
//    public Boolean getRewardResult1(String userId, String source) {
//        BiPredicate<String, String> biPredicate = SOURCE_MAP1.get(source);
//        if (Objects.nonNull(biPredicate)) {
//            return biPredicate.test(userId, source);
//        }
//        return Boolean.FALSE;
//    }
}
