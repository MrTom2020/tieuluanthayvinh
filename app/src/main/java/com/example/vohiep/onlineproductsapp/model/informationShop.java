package com.example.vohiep.onlineproductsapp.model;

import java.util.List;

public class informationShop
{
    public String magianhang;
    public String tengianhang;
    public String tenchucuahang;
    public String linhvuckinhdoanh;
    public String ngaythamgia;
    public String luotdanhgia;
    public String luottheodoi;
    public List<String> danhmucsanpham;
    public List<informationproduct> list;

    public informationShop(String magianhang, String tengianhang, String tenchucuahang, String linhvuckinhdoanh, String ngaythamgia, String luotdanhgia, String luottheodoi, List<String> danhmucsanpham, List<informationproduct> list)
    {
        this.magianhang = magianhang;
        this.tengianhang = tengianhang;
        this.tenchucuahang = tenchucuahang;
        this.linhvuckinhdoanh = linhvuckinhdoanh;
        this.ngaythamgia = ngaythamgia;
        this.luotdanhgia = luotdanhgia;
        this.luottheodoi = luottheodoi;
        this.danhmucsanpham = danhmucsanpham;
        this.list = list;
    }

    public String getMagianhang() {
        return magianhang;
    }

    public void setMagianhang(String magianhang) {
        this.magianhang = magianhang;
    }

    public String getTengianhang() {
        return tengianhang;
    }

    public void setTengianhang(String tengianhang) {
        this.tengianhang = tengianhang;
    }

    public String getTenchucuahang() {
        return tenchucuahang;
    }

    public void setTenchucuahang(String tenchucuahang) {
        this.tenchucuahang = tenchucuahang;
    }

    public String getLinhvuckinhdoanh() {
        return linhvuckinhdoanh;
    }

    public void setLinhvuckinhdoanh(String linhvuckinhdoanh) {
        this.linhvuckinhdoanh = linhvuckinhdoanh;
    }

    public String getNgaythamgia() {
        return ngaythamgia;
    }

    public void setNgaythamgia(String ngaythamgia) {
        this.ngaythamgia = ngaythamgia;
    }

    public String getLuotdanhgia() {
        return luotdanhgia;
    }

    public void setLuotdanhgia(String luotdanhgia) {
        this.luotdanhgia = luotdanhgia;
    }

    public String getLuottheodoi() {
        return luottheodoi;
    }

    public void setLuottheodoi(String luottheodoi) {
        this.luottheodoi = luottheodoi;
    }

    public List<String> getDanhmucsanpham() {
        return danhmucsanpham;
    }

    public void setDanhmucsanpham(List<String> danhmucsanpham) {
        this.danhmucsanpham = danhmucsanpham;
    }

    public List<informationproduct> getList() {
        return list;
    }

    public void setList(List<informationproduct> list) {
        this.list = list;
    }
}
