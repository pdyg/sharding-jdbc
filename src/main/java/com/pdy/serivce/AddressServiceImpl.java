package com.pdy.serivce;

import com.pdy.entity.Address;
import com.pdy.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *   注意：关于修改数据的（更新和删除）。如果只是分表或分库，根据分片字段修改即可。如果是分表分库的，需要根据分表的分片字段修改。
 * @Auther: pdy
 * @Date: 2020/4/2 11:42
 * @Description:
 */
@Service
public class AddressServiceImpl  implements AddressService{
    @Autowired
    private AddressMapper addressMapper;
    /**
     * 保存
     */
    public void save(Address address){
        addressMapper.save(address);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    public Address get(Long id){
        return addressMapper.get(id);
    }
}
