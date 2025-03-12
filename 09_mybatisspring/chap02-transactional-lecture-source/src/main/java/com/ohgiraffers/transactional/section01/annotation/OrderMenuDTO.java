package com.ohgiraffers.transactional.section01.annotation;

public class OrderMenuDTO {
    private int menuCode;           // 고른 메뉴 번호
    private int orderAmounr;        // 고른 메뉴 개수

    public OrderMenuDTO() {
    }

    public OrderMenuDTO(int menuCode, int orderAmounr) {
        this.menuCode = menuCode;
        this.orderAmounr = orderAmounr;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getOrderAmounr() {
        return orderAmounr;
    }

    public void setOrderAmounr(int orderAmounr) {
        this.orderAmounr = orderAmounr;
    }

    @Override
    public String toString() {
        return "OrderMenuDTO{" +
                "menuCode=" + menuCode +
                ", orderAmounr=" + orderAmounr +
                '}';
    }
}
