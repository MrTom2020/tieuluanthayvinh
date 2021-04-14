package com.example.vohiep.onlineproductsapp.model;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.List;

public class informationproduct
{
    public String tensp;
    public String giaban;
    public String thuocdanhmuc;
    public String masp;
    public String magianhang;
    public String listimageproduct;
    public String size;
    public List<informationevaluate> list;

    public informationproduct(String tensp, String giaban, String thuocdanhmuc, String masp, String magianhang, String listimageproduct, String size, List<informationevaluate> list) {
        this.tensp = tensp;
        this.giaban = giaban;
        this.thuocdanhmuc = thuocdanhmuc;
        this.masp = masp;
        this.magianhang = magianhang;
        this.listimageproduct = listimageproduct;
        this.size = size;
        this.list = list;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public String getThuocdanhmuc() {
        return thuocdanhmuc;
    }

    public void setThuocdanhmuc(String thuocdanhmuc) {
        this.thuocdanhmuc = thuocdanhmuc;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getMagianhang() {
        return magianhang;
    }

    public void setMagianhang(String magianhang) {
        this.magianhang = magianhang;
    }

    public String getListimageproduct() {
        return listimageproduct;
    }

    public void setListimageproduct(String listimageproduct) {
        this.listimageproduct = listimageproduct;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<informationevaluate> getList() {
        return list;
    }

    public void setList(List<informationevaluate> list) {
        this.list = list;
    }
}
