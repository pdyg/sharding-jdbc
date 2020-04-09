package com.pdy.serivce;

import com.pdy.entity.MerchantId;
import com.pdy.entity.TOrder;
import com.pdy.entity.TOrderPay;
import com.pdy.mapper.MerchantIdMapper;
import com.pdy.mapper.TOrderMapper;
import com.pdy.mapper.TOrderPayMapper;
import io.shardingsphere.core.constant.transaction.TransactionType;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 弱XA通过去掉XA的Prepare阶段，以达到减少资源锁定范围而提升并发性能的效果。典型的实现为在一个业务线程中，遍历所有的数据库连接，依次做commit或者rollback。弱XA同本地事务相比，性能损耗低，但在事务提交的执行过程中，若出现网络故障、数据库宕机等预期之外的异常，将会造成数据不一致，且无法进行回滚。基于弱XA的事务无需额外的实现成本，因此Sharding-Sphere默认支持。
 * @Auther: pdy
 * @Date: 2020/4/9 15:55
 * @Description:
 */
@Service
public class TOrderServiceImpl {
    @Autowired
    private MerchantIdMapper merchantIdMapper;
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private TOrderPayMapper tOrderPayMapper;

    Logger log = LoggerFactory.getLogger(TOrderServiceImpl.class);

    // 本地事务
    //@ShardingTransactionType(TransactionType.LOCAL)
    // 两阶段事务（支持夸库事务）
    @ShardingTransactionType(TransactionType.XA)
    @Transactional
    public Map<String, Object> addOrderData() {
        Map<String, Object> resultMaps = new HashMap<>();
        resultMaps.put("msg", "成功");
        resultMaps.put("success", true);
        try {
            List<MerchantId> merchantIdList = new ArrayList<>();
            MerchantId merchantId = null;
            for (int i = 0; i < 4; i++) {
                merchantId = new MerchantId("张" + i, i % 2 == 0 ? 1 : 2);
                merchantIdList.add(merchantId);


            }
            merchantIdMapper.saveList(merchantIdList);




            List<TOrder> tOrderList = new ArrayList<>();
            TOrder tOrder = null;
            for (MerchantId id : merchantIdList) {
                for (int j = 0; j < 5; j++) {
                    tOrder = new TOrder("sdsd", j, id.getId(), 0.22);
                    tOrderList.add(tOrder);
                }
            }

            tOrderMapper.saveList(tOrderList);

            List<TOrderPay> tOrderPayList = new ArrayList<>();
            TOrderPay tOrderPay = null;
            for (MerchantId id : merchantIdList) {

                for (int i = 0; i < 5; i++) {

                    for (TOrder order : tOrderList) {
                        tOrderPay = new TOrderPay(id.getId(), order.getId(), i, 2.00, 4.00);
                        tOrderPayMapper.save(tOrderPay);
                    }
                }


            }
            int testint=10/0 ;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("错误了", e);
            resultMaps.put("msg", "错误");
            resultMaps.put("success", false);
            return resultMaps;
        }


        return resultMaps;
    }

}
