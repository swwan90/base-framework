package com.swwan.research.enums.annotation.serialize.concreate;

import com.swwan.research.enums.annotation.serialize.CustomSerializationEnum;
import com.swwan.research.enums.annotation.serialize.EnumSerialize;
import com.swwan.research.enums.annotation.serialize.EnumSerializeAdapter;
import javafx.util.Pair;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * @author swwan
 * @date 2022/4/9 - 10:07
 */
public class CustomSerializationEnumTypeHandler<T extends Enum<T> & EnumSerialize<T>> extends BaseTypeHandler<T> {
    private final CustomSerializationEnum.Type type;
    private final Class<T> clazz;

    public CustomSerializationEnumTypeHandler(Pair<Class<Enum<?>>, Set<EnumSerialize<T>>> enumSerialize) {
        //noinspection unchecked,rawtypes
        clazz = (Class) enumSerialize.getKey();
        CustomSerializationEnum annotation = EnumSerialize.getAnnotation(clazz);
        type = annotation == null ? CustomSerializationEnum.Type.NAME : annotation.myBatis();
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        Object serializedValue;
        //noinspection ConstantConditions
        if (parameter instanceof EnumSerialize) {
            serializedValue = type.getSerializedValue(parameter);
        } else {
            //noinspection ConstantConditions
            serializedValue = type.getSerializedValue(new EnumSerializeAdapter(parameter));
        }
        if (serializedValue instanceof String) {
            ps.setString(i, (String) serializedValue);
        } else if (serializedValue instanceof Integer) {
            ps.setInt(i, (Integer) serializedValue);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return type.getDeserializeObj(clazz, rs.getObject(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return type.getDeserializeObj(clazz, rs.getObject(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return type.getDeserializeObj(clazz, cs.getObject(columnIndex));
    }
}
