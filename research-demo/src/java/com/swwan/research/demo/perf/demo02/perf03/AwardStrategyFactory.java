package com.swwan.research.demo.perf.demo02.perf03;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * 工厂方法，对外统一暴露业务调用入口
 *
 * @author swwan
 * @date 2022/3/4 - 23:56
 */
@Component
public class AwardStrategyFactory implements ApplicationContextAware {

    private final static Map<String, AwardStrategy> AWARD_STRATEGY_MAP = Maps.newConcurrentMap();

    public static AwardStrategyFactory getInstance() {
        return CreateFactorySingleton.factory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, AwardStrategy> beanTypeMap = applicationContext.getBeansOfType(AwardStrategy.class);
        beanTypeMap.values().forEach(item -> AWARD_STRATEGY_MAP.put(item.getSource(), item));
    }

    /**
     * 对外统一暴露的工厂方法
     */
    public Boolean getAwardResult(String userId, String source) {
        AwardStrategy strategy = AWARD_STRATEGY_MAP.get(source);
        if (Objects.isNull(strategy)) {
            throw new RuntimeException("渠道异常！");
        }
        return strategy.awardStrategy(userId);
    }

    /**
     * 静态内部类创建单例工厂对象
     */
    private static class CreateFactorySingleton {
        private static AwardStrategyFactory factory = new AwardStrategyFactory();
    }

}
