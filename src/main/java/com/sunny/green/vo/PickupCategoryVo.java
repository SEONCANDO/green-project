package com.sunny.green.vo;


public class PickupCategoryVo {
    int pu_no;
    int category_no;
    int pu_category_count;

    public int getPu_no() {
        return pu_no;
    }

    public void setPu_no(int pu_no) {
        this.pu_no = pu_no;
    }

    public int getCategory_no() {
        return category_no;
    }

    public void setCategory_no(int category_no) {
        this.category_no = category_no;
    }

    public int getPu_category_count() {
        return pu_category_count;
    }

    public void setPu_category_count(int pu_category_count) {
        this.pu_category_count = pu_category_count;
    }

    public PickupCategoryVo(int pu_no, int category_no, int pu_category_count) {
        this.pu_no = pu_no;
        this.category_no = category_no;
        this.pu_category_count = pu_category_count;
    }

    public PickupCategoryVo() {
    }
}
