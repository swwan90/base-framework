package com.swwan.research.common.base;

/**
 * 响应视图分组
 *
 * @author swwan
 * @date 2021/12/18 - 23:02
 */
public abstract class ResponseJsonView {

    /**
     * 响应数据最外层的视图 也是所有响应视图的父类
     */
    public interface Base {
    }

    /**
     * 修改的响应视图
     * 继承自Base 也就是说指定为这个组的时候,在满足当前响应视图规则的同时，还得满足 base 接口
     */
    public interface Update extends Base {
    }

    /**
     * 增加的响应视图
     */
    public interface Insert extends Update {
    }

}
