package com.swwan.research.demo.perf.demo02.perf03;

import lombok.extern.slf4j.Slf4j;

/**
 * 奖励发放模板流程
 *
 * @author swwan
 * @date 2022/3/4 - 23:48
 */
@Slf4j
public abstract class BaseAwardTemplate {

    /**
     * 奖励发放模板方法
     */
    public Boolean awardTemplate(String userId) {
        this.authentication(userId);
        this.risk(userId);
        return this.awardRecord(userId);
    }

    /**
     * 执行奖励发放
     */
    protected abstract Boolean awardRecord(String userId);

    /**
     * 风控
     */
    protected void risk(String userId) {
        log.info("{} 执行风控校验!", userId);
    }

    /**
     * 身份验证
     */
    protected void authentication(String userId) {
        log.info("{} 执行身份验证!", userId);
    }
}
