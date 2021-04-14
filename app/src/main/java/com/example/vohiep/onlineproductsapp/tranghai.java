package com.example.vohiep.onlineproductsapp;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.example.vohiep.onlineproductsapp.Servicee.ConnectionReceiver;

public class tranghai extends TabActivity {

    private TabHost tabHost;
    private TabSpec tabSpec;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranghai);
        dangkynut();
        ax();
    }
    private void dangkynut()
    {
        tabHost = (TabHost)findViewById(android.R.id.tabhost);
    }
    private void dangkysk()
    {

    }
    private void check()
    {
        boolean ret = ConnectionReceiver.isConnected();
        String ms;
        if(ret == true)
        {
            ms = "Hiện tại bạn đang online";
        }
        else
        {
            ms = "Hiện tại bạn đang offline";
        }
        Toast.makeText(this,ms, Toast.LENGTH_SHORT).show();
    }

    private void ax()
    {
        tabSpec = tabHost.newTabSpec ("Info");
        tabSpec = tabHost.newTabSpec ("Account");
        tabSpec.setIndicator ("Account");
        intent = new Intent(this, trangcanhan.class);
        tabSpec.setContent (intent);
        tabHost.addTab (tabSpec);

       tabHost.setCurrentTab(1);

    }

    @Override
    protected void onStart()
    {
        check();
        super.onStart();
    }

    private class sukiencuatoi implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {

        }
    }
}