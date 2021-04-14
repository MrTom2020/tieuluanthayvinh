package com.example.vohiep.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class yourShop extends TabActivity
{

    private TabHost tabHost;
    private TextView txttenshop;
    private TabHost.TabSpec tabSpec,tabSpec2,tabSpec3;
    private Intent intent;
    private ImageView imageViewshop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_shop);
        addControl();
        addEvent();
        ax();
    }
    private void addControl()
    {
        tabHost = (TabHost)findViewById(android.R.id.tabhost);
        txttenshop = (TextView)findViewById(R.id.txttenshop);
        txttenshop.setText(MainActivity.ten);
        imageViewshop = (ImageView)findViewById(R.id.imgviewshop);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/tieuluanmonthayvinh.appspot.com/o/163261371_1692051890994877_4367804827634152334_n.jpg?alt=media&token=53a44da8-dcb2-4d26-abb3-bc69c971efb5").into(imageViewshop);
    }
    private void ax()
    {
        tabSpec = tabHost.newTabSpec("Sản phẫm");
        tabSpec.setIndicator("Sản phẫm");
        intent = new Intent(this,trangsp.class);
        tabSpec.setContent(intent);
        tabSpec2 = tabHost.newTabSpec("Sản phẫm mới");
        tabSpec2.setIndicator("Sản phẫm mới");
        intent = new Intent(this,trangsp.class);
        tabSpec2.setContent(intent);
        tabSpec3 = tabHost.newTabSpec("Bài review");
        tabSpec3.setIndicator("Bài review");
        intent = new Intent(this,trangsp.class);
        tabSpec3.setContent(intent);
        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
        tabHost.setCurrentTab(1);
    }
    private void addEvent()
    {

    }
    private class myEvent implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {

        }
    }
}