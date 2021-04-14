package com.example.vohiep.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Productdetails extends AppCompatActivity
{
    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        addControl();
        addEvent();
    }
    private void addControl()
    {
        imgback = (ImageView)findViewById(R.id.imgback);
    }
    private void addEvent()
    {
        imgback.setOnClickListener(new MyEvent());
    }
    private class MyEvent implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if(view.equals(imgback))
            {
                finish();
            }
        }
    }
}
