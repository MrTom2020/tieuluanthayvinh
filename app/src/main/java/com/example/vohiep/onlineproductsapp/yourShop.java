package com.example.vohiep.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class yourShop extends TabActivity
{

    private TabHost tabHost;
    private TextView txttenshop;
    private TabHost.TabSpec tabSpec,tabSpec2,tabSpec3;
    private Intent intent;
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