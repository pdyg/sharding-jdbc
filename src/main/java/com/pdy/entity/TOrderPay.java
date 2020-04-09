package com.pdy.entity;

/**
 * @Auther: pdy
 * @Date: 2020/4/7 16:34
 * @Description:
 */
public class TOrderPay {
    private Long id;
    private Long merchantId;
    private Long orderId;
    private Integer payType;

    private Double amount;
    private Double credits;
    private String create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public TOrderPay(Long merchantId, Long orderId, Integer payType, Double amount, Double credits) {
        this.merchantId = merchantId;
        this.orderId = orderId;
        this.payType = payType;
        this.amount = amount;
        this.credits = credits;
    }
    public TOrderPay(){}
}
