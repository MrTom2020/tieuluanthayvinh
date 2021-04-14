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
import com.squareup.picasso.Picasso;

import java.util.List;

public class informationShopAdapter extends BaseAdapter
{
    public Context context;
    public int Layout;
    public List<informationShop> informationShopList;
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
        informationShop shop = informationShopList.get(position);
       Picasso.get().load(shop.getList().get(position).toString()).into(viewHoler.img);
        viewHoler.txtgiaban.setText(shop.getList().get(position).getGiaban().toString());
        viewHoler.txttsp.setText(shop.getList().get(position).getTensp().toString());
        return convertView;
    }


    public informationShopAdapter(Context context, int layout, List<informationShop> informationShopList)
    {
        this.context = context;
        Layout = layout;
        this.informationShopList = informationShopList;
    }
}
