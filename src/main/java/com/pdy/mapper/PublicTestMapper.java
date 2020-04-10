package com.pdy.mapper;

import com.pdy.entity.PublicTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: pdy
 * @Date: 2020/4/9 11:27
 * @Description:
 */
@Mapper
@Repository
public interface PublicTestMapper {
    int save(PublicTest test);
    PublicTest get(Long id);
}
