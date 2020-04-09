package com.pdy.mapper;

import com.pdy.entity.MerchantId;
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
public interface MerchantIdMapper {
    public int save(MerchantId merchantId);


    public List<MerchantId> get(long id);

    int saveList(List<MerchantId> list);

}
