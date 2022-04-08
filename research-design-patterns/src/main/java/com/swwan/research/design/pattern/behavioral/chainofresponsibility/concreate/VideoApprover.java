package com.swwan.research.design.pattern.behavioral.chainofresponsibility.concreate;

import cn.hutool.core.text.CharSequenceUtil;
import com.swwan.research.design.pattern.behavioral.chainofresponsibility.BaseApprover;
import com.swwan.research.design.pattern.behavioral.chainofresponsibility.Course;

/**
 * @author swwan
 * @date 2022/4/8 - 23:09
 */
public class VideoApprover extends BaseApprover {
    @Override
    public void deploy(Course course) {
        if (CharSequenceUtil.isEmpty(course.getArticle())) {
            System.out.println(course.getName() + "不含视频，拒绝！");
            return;
        }

        System.out.println(course.getName() + "含视频，批准！");
        if (next != null) {
            next.deploy(course);
        }
    }
}
