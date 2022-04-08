package com.swwan.research.design.pattern.behavioral.chainofresponsibility.concreate;

import cn.hutool.core.text.CharSequenceUtil;
import com.swwan.research.design.pattern.behavioral.chainofresponsibility.BaseApprover;
import com.swwan.research.design.pattern.behavioral.chainofresponsibility.Course;

/**
 * @author swwan
 * @date 2022/4/8 - 23:09
 */
public class ArticleApprover extends BaseApprover {
    @Override
    public void deploy(Course course) {
        if (CharSequenceUtil.isEmpty(course.getArticle())) {
            System.out.println(course.getName() + "不含博客，拒绝！");
            return;
        }

        System.out.println(course.getName() + "含博客，批准！");
        if (next != null) {
            next.deploy(course);
        }
    }
}
