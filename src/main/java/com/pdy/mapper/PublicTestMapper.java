package com.pdy.mapper;

import com.pdy.entity.PublicTest;

/**
 * @Auther: pdy
 * @Date: 2020/4/9 11:27
 * @Description:
 */
public interface PublicTestMapper {
    int save(PublicTest test);
    PublicTest get(Long id);
}
