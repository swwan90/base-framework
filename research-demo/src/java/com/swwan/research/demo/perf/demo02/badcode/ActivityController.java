package com.swwan.research.demo.perf.demo02.badcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 业务场景描述：比如让你做一个简单的营销拉新活动，这个活动投放到不同的渠道，不同渠道过来的用户奖励不一样。
 * 现假设在头条、微信等渠道都投放了该活动
 *
 * @author swwan
 * @date 2022/3/4 - 23:14
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private AwardService awardService;

    @PostMapping("/reward")
    public void reward(String userId, String source) {
        if ("toutiao".equals(source)) {
            awardService.toutiaoReward(userId);
        } else if ("wx".equals(source)) {
            awardService.wxReward(userId);
        }
    }
}
