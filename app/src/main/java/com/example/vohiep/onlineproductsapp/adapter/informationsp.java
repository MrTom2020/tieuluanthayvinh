package com.example.vohiep.onlineproductsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.vohiep.onlineproductsapp.R;
import com.example.vohiep.onlineproductsapp.model.informationShop;
import com.example.vohiep.onlineproductsapp.model.informationproduct;
import com.squareup.picasso.Picasso;

import java.util.List;

public class informationsp extends BaseAdapter
{
    public Context context;
    public int Layout;
    public List<informationproduct> informationShopList;
    @Override
    public int getCount()
    {
        return informationShopList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
    public class ViewHoler
    {
        ImageView img;
        TextView txttsp;
        TextView txtgiaban;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHoler viewHoler;
        if(convertView == null)
        {
            viewHoler = new ViewHoler();
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(Layout,null);
            viewHoler.img = (ImageView)convertView.findViewById(R.id.imgctsp);
            viewHoler.txttsp = (TextView)convertView.findViewById(R.id.txttenctsp);
            viewHoler.txtgiaban = (TextView)convertView.findViewById(R.id.txtgban);
            convertView.setTag(viewHoler);
        }
        else
        {
            viewHoler = (ViewHoler)convertView.getTag();
        }
        informationproduct shop = informationShopList.get(position);
        Picasso.get().load(shop.getListimageproduct().toString()).into(viewHoler.img);
        viewHoler.txtgiaban.setText(shop.getGiaban().toString());
        viewHoler.txttsp.setText(shop.getTensp().toString());
        return convertView;
    }


    public informationsp(Context context, int layout, List<informationproduct> informationShopList) {
        this.context = context;
        Layout = layout;
        this.informationShopList = informationShopList;
    }
}
