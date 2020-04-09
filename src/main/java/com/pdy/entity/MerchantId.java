package com.pdy.entity;

/**
 * @Auther: pdy
 * @Date: 2020/4/7 16:26
 * @Description:
 */

public class MerchantId {
    private Long id;
    private String Code;
    private int type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public MerchantId(String code, int type) {
        Code = code;
        this.type = type;
    }
    public MerchantId(){}
}
