package com.pdy.entity;

/**
 * @Auther: pdy
 * @Date: 2020/4/7 16:34
 * @Description:
 */
public class TOrder {
    private Long id;
    private String name;
    private Integer orderType;
    private Long merchantId;
    private Double orderAmount;
    private String create_time;
    private Double credits;

    //订单支付字段
    private Integer payType;
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TOrder(String name, Integer orderType, Long merchantId, Double orderAmount) {
        this.name = name;
        this.orderType = orderType;
        this.merchantId = merchantId;
        this.orderAmount = orderAmount;

    }
    public TOrder(){}

    @Override
    public String toString() {
        return "TOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderType=" + orderType +
                ", merchantId=" + merchantId +
                ", orderAmount=" + orderAmount +
                ", create_time='" + create_time + '\'' +
                ", credits=" + credits +
                ", payType=" + payType +
                ", amount=" + amount +
                '}';
    }
}
