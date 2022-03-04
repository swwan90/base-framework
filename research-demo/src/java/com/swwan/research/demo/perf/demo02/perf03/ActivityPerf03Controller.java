package com.swwan.research.demo.perf.demo02.perf03;

import com.swwan.research.demo.perf.demo02.badcode.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 业务场景描述：比如让你做一个简单的营销拉新活动，这个活动投放到不同的渠道，不同渠道过来的用户奖励不一样。
 * 现假设在头条、微信等渠道都投放了该活动，
 * 另外这个业务流程再增加一些复杂度，比如发放奖励之前要进行身份验证、风控验证等一些列的校验;
 * <p>
 * 策略模式+模板方法+工厂模式+单例模式
 *
 * @author swwan
 * @date 2022/3/4 - 23:14
 */
@RestController
@RequestMapping("/activity")
public class ActivityPerf03Controller {

    @Autowired
    private AwardService awardService;

    @PostMapping("/reward")
    public void reward(String userId, String source) {
        AwardStrategyFactory.getInstance().getAwardResult(userId, source);
    }
}
