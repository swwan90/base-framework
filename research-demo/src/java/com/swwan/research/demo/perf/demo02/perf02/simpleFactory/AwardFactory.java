package com.swwan.research.demo.perf.demo02.perf02.simpleFactory;

/**
 * @author swwan
 * @date 2022/3/4 - 23:39
 */
public class AwardFactory {

    public static AwardAbstract getAwardInstance(String source) {
        if ("toutiao".equals(source)) {
            return new TouTiaoAwardService();
        } else if ("wx".equals(source)) {
            return new WeChatAwardService();
        }
        return null;
    }
}
