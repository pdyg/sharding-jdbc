package com.pdy.mapper;

import com.pdy.entity.TOrder;
import com.pdy.entity.TOrderPay;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: pdy
 * @Date: 2020/4/7 16:31
 * @Description:
 */
@Repository
@Mapper
public interface TOrderPayMapper {
    public int save(TOrderPay tOrderPay);



}
