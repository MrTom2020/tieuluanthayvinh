package com.example.vohiep.onlineproductsapp.Servicee;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

import com.example.vohiep.onlineproductsapp.model.WifiApp;

public class ConnectionReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {

    }
    public static boolean isConnected()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) WifiApp.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return  networkInfo !=null && networkInfo.isConnectedOrConnecting();

    }
}
