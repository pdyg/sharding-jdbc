package com.pdy;

import com.pdy.entity.*;
import com.pdy.mapper.MerchantIdMapper;
import com.pdy.mapper.PublicTestMapper;
import com.pdy.mapper.TOrderMapper;
import com.pdy.mapper.TOrderPayMapper;
import com.pdy.serivce.AddressServiceImpl;
import com.pdy.serivce.TOrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: pdy
 * @Date: 2020/4/7 09:35
 * @Description:
 */
@SpringBootTest
public class TestApp {
//    Logger log = LoggerFactory.getLogger(TestApp.class);
    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private MerchantIdMapper merchantIdMapper;
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private TOrderPayMapper tOrderPayMapper;
    @Autowired
    private TOrderServiceImpl tOrderServiceImpl;
    @Autowired
    private PublicTestMapper publicTestMapper;

    @Test
    public void testpage(){

        for (int i = 0; i <5 ; i++) {
            Address address=new Address();
            address.setCode("code"+i); ;
            address.setName("test"+i);
            address.setPid("1112344444"+i);
            address.setType(i%2);
            address.setLit(i);
            addressService.save(address);
        }

    }


    @Test
    public void testmastSlove(){
        List<MerchantId> merchantIdList=new ArrayList<>();
        MerchantId merchantId=null;
        for (int i = 0; i < 4; i++) {
            merchantId=new MerchantId("张"+i, i%2==0?1:2);
            merchantIdList.add(merchantId);


        }
        merchantIdMapper.saveList(merchantIdList);

        List<TOrder> tOrderList=new ArrayList<>();
        TOrder tOrder=null;
        for (MerchantId id : merchantIdList) {
            for (int j = 0; j < 5; j++) {
                tOrder=new TOrder("sdsd", j, id.getId(), 0.22);
                tOrderList.add(tOrder);
            }
        }

        tOrderMapper.saveList(tOrderList);

        List<TOrderPay> tOrderPayList=new ArrayList<>();
        TOrderPay  tOrderPay=null;
        for (MerchantId id : merchantIdList) {

            for (int i = 0; i < 5; i++) {

                for (TOrder order : tOrderList) {
                    tOrderPay=new TOrderPay(id.getId(), order.getId(), i, 2.00, 4.00);
                    tOrderPayMapper.save(tOrderPay);
                }
            }


        }




    }
    @Test
    public void testSaveList(){
        TOrder tOrder=null;
        List<TOrder> tOrderList=new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                tOrder=new TOrder("sdsd", j, 454346890390011908l, 0.22);
                tOrderList.add(tOrder);
            }
//        tOrderMapper.saveList(tOrderList);
        tOrderMapper.save(tOrder);
    }


    @Test
    public void testMechantId() {
        List<MerchantId> merchantIdList = new ArrayList<>();
        MerchantId merchantId = null;
        for (int i = 0; i < 4; i++) {
            merchantId = new MerchantId("张" + i, i % 2 == 0 ? 1 : 2);
            merchantIdList.add(merchantId);


        }
        merchantIdMapper.saveList(merchantIdList);
    }

    @Test
    public void testOrder() {
        List<MerchantId> merchantIdList = new ArrayList<>();
        MerchantId merchantId = null;
        for (int i = 0; i < 4; i++) {
            merchantId = new MerchantId("张" + i, i % 2 == 0 ? 1 : 2);
            merchantIdList.add(merchantId);


        }
        merchantIdMapper.saveList(merchantIdList);
    }

    @Test
    public void testOrderBind() {
        //联合查询，绑定关系表
        List<TOrder> oderList= tOrderMapper.getOrderInfo(454954440630206464l);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("----------------------------");

        for (TOrder tOrder : oderList) {
            System.out.println(tOrder.toString());
        }
    }
    //测试事物
    @Test
    public void Transactional(){
        tOrderServiceImpl.addOrderData().toString();
    }

    @Test
    public void TestDemo(){
        for (int i = 0; i <5 ; i++) {
            PublicTest test=new PublicTest();
            test.setCode("code"+i); ;
            test.setName("test"+i);
            test.setPid("1112344444"+i);
            test.setType(i%2);
            test.setLit(i);
            publicTestMapper.save(test);
        }

    }


}
