package com.pdy.mapper;

import com.pdy.entity.MerchantId;
import com.pdy.entity.TOrder;
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
public interface TOrderMapper {
    public int save(TOrder tOrder);

    /**
     * 根据名称连表查询数据
     * @param merchantId
     * @return
     */
    public List<TOrder> getOrderInfo(Long  merchantId);



    int saveList(List<TOrder> list);

}
