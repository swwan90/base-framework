package com.swwan.research.common.base.model;

import com.swwan.research.common.base.enums.BaseEnum;
import com.swwan.research.common.base.enums.CodeEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * @author swwan
 * @date 2022/12/7 - 20:31
 */
@NoArgsConstructor
@Data
public final class JsonObject<E> {

    @Setter(AccessLevel.PRIVATE)
    private Integer code;

    @Setter(AccessLevel.PRIVATE)
    private String msg;

    @Setter(AccessLevel.PRIVATE)
    private E result;

    public static <E> JsonObject<E> success(E e) {
        JsonObject<E> object = new JsonObject();
        object.setCode(CodeEnum.Success.getCode());
        object.setMsg(CodeEnum.Success.getDescription());
        object.setResult(e);
        return object;
    }

    public static <E> JsonObject<E> success(E t, String msg) {
        JsonObject<E> obj = success(t);
        obj.setMsg(msg);
        return obj;
    }

    public static JsonObject fail(BaseEnum codeEnum) {
        JsonObject object = new JsonObject();
        object.setMsg(codeEnum.getDescription());
        object.setCode(codeEnum.getCode());
        return object;
    }

    public static JsonObject fail(String msg) {
        JsonObject object = new JsonObject();
        object.setMsg(msg);
        object.setCode(CodeEnum.Fail.getCode());
        return object;
    }

    public static <E> JsonObject<E> fail(E e, String msg) {
        JsonObject<E> object = new JsonObject();
        object.setCode(CodeEnum.Fail.getCode());
        object.setMsg(msg);
        object.setResult(e);
        return object;
    }

    public static <E> JsonObject<E> res(BaseEnum codeEnum, E e) {
        JsonObject<E> object = new JsonObject();
        object.setMsg(codeEnum.getDescription());
        object.setCode(codeEnum.getCode());
        object.setResult(e);
        return object;
    }

    /**
     * 是否成功
     *
     * @return boolean
     */
    public boolean isSuccess() {
        return Objects.equals(CodeEnum.Success.getCode(), this.getCode());
    }


}
