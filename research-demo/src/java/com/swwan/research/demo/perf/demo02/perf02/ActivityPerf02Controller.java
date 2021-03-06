package com.swwan.research.demo.perf.demo02.perf02;

import com.swwan.research.demo.perf.demo02.perf02.simpleFactory.AwardAbstract;
import com.swwan.research.demo.perf.demo02.perf02.simpleFactory.AwardFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 业务场景描述：比如让你做一个简单的营销拉新活动，这个活动投放到不同的渠道，不同渠道过来的用户奖励不一样。
 * 现假设在头条、微信等渠道都投放了该活动
 * <p>
 * 工厂模式+抽象类
 *
 * @author swwan
 * @date 2022/3/4 - 23:14
 */
@RestController
@RequestMapping("/activity")
public class ActivityPerf02Controller {

    @PostMapping("/reward02")
    public void reward(String userId, String source) {
        AwardAbstract instance = AwardFactory.getAwardInstance(source);
        if (Objects.nonNull(instance)) {
            instance.award(userId);
        }
    }
}
