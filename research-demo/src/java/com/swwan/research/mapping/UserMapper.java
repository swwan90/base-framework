package com.swwan.research.mapping;

import com.swwan.research.vo.UserEntity;

import java.util.List;

/**
 * @author swwan
 * @date 2022/4/9 - 17:21
 */
public interface UserMapper {
    int insert(UserEntity entity);

    List<UserEntity> select();
}
