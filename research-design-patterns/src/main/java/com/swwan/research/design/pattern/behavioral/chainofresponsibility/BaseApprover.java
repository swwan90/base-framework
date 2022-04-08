package com.swwan.research.design.pattern.behavioral.chainofresponsibility;

/**
 * 审批人
 *
 * @author swwan
 * @date 2022/4/8 - 23:06
 */
public abstract class BaseApprover {

    protected BaseApprover next;

    public void setNext(BaseApprover next) {
        this.next = next;
    }

    /**
     * 发布
     *
     * @param course 课程
     */
    public abstract void deploy(Course course);
}
