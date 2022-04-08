package com.swwan.research.design.pattern.behavioral.chainofresponsibility;

import com.swwan.research.design.pattern.behavioral.chainofresponsibility.concreate.ArticleApprover;
import com.swwan.research.design.pattern.behavioral.chainofresponsibility.concreate.VideoApprover;

/**
 * @author swwan
 * @date 2022/4/8 - 23:13
 */
public class ApproverTest {

    public static void main(String[] args) {
        BaseApprover articleApprover = new ArticleApprover();
        BaseApprover videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("公众号-Learner");
        course.setArticle("JavaEdge的博客");
        course.setVideo("JavaEdge的小视频");

        articleApprover.setNext(videoApprover);
        articleApprover.deploy(course);
    }
}
