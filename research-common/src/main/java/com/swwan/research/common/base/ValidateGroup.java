package com.swwan.research.common.base;

/**
 * 校验分组
 *
 * @author swwan
 * @date 2021/12/18 - 23:02
 */
public abstract class ValidateGroup {

    /**
     * 基础的校验接口，标识着所有操作都需要校验的字段
     */
    public interface Base {
    }

    /**
     * 修改的校验接口
     * 继承自Base 也就是说指定为这个组的时候,在满足当前校验规则的同时，还得满足 base 接口
     */
    public interface Update extends Base {
    }

    /**
     * 增加的校验接口
     */
    public interface Insert extends Update {
    }

}
