package com.example.vohiep.onlineproductsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vohiep.onlineproductsapp.adapter.informationShopAdapter;
import com.example.vohiep.onlineproductsapp.adapter.informationsp;
import com.example.vohiep.onlineproductsapp.model.informationShop;
import com.example.vohiep.onlineproductsapp.model.informationevaluate;
import com.example.vohiep.onlineproductsapp.model.informationproduct;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class trangsp extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<informationevaluate> informationevaluateArrayList = new ArrayList<>();
    private ArrayList<informationproduct> informationproductArrayList = new ArrayList<>();
    private ArrayList<informationShop> informationShopArrayList = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ConstraintLayout constraintLayout;
    private ArrayAdapter arrayAdapter;
    private informationShopAdapter ifora;
    private informationsp a;
    private Intent intent;
    private String i = Login.tend;
    private String kkkk;
    private String mspp;
    private ArrayList<String> keysanpham = new ArrayList<>();
    private ArrayList<String> keydanhmuc = new ArrayList<>();
    private ArrayList<String> arrayList;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private List<String> danhmuc = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<Integer>();
    private List<String> danhmuc2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangsp);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("dangnhap");
        addControl();
        ax2();
        addEvent();
        //Toast.makeText(trangsp.this,String.valueOf(keydanhmuc.size()),Toast.LENGTH_SHORT).show();
        ax();
        sukienchohang();
    }
    private void addControl()
    {
        gridView = (GridView)findViewById(R.id.gsp);
        constraintLayout = (ConstraintLayout)findViewById(R.id.cs);
    }
    private void addEvent()
    {

    }
    private void ax()
    {
        try {
            list.add(R.drawable.prod3);
            list2.add(R.drawable.prod4);
            danhmuc.add("123");
            danhmuc2.add("Hiện tại bạn chưa có sản phẫm");
            //list bình luận của người dùng
            informationevaluateArrayList.add(new informationevaluate("1", "2", list, "3", 4, 5));
            //list sản phẩm

            informationproductArrayList.add(new informationproduct("Xin vui lòng đăng sản phẫm ", " ", " ", "  ", " ", "https://firebasestorage.googleapis.com/v0/b/tieuluanmonthayvinh.appspot.com/o/hinh1618339543031.JPG?alt=media&token=c4ecb03e-e8f5-48c5-aa89-73ce6803a72d",  " ", informationevaluateArrayList));
            //quán của hàng tùng shop*/
            if(informationproductArrayList.size() == 0)
            {
                Button btn = new Button(this);
                btn.setText("Hiện tại bạn chưa có sản phẫm Nhấn vào đây");
                btn.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        intent = new Intent(trangsp.this,dangsp.class);
                        startActivity(intent);
                    }
                });
                constraintLayout.addView(btn);
            }
            else
            {
                //informationShopArrayList.add(new informationShop("123", "hi", "quần áo", "Thời trang", "31/10", "300", "123", danhmuc, informationproductArrayList));
                a = new informationsp(trangsp.this,R.layout.ctsanpham,informationproductArrayList);
                gridView.setAdapter(a);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(trangsp.this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
    private class myEvent implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {

        }
    }
    private void sukienchohang()
    {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(trangsp.this,informationproductArrayList.get(position).getGiaban().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ax2() {
        try {
            databaseReference.child(i + "/k2/").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull final DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                        final String key1 = dataSnapshot.getKey().toString();
                        informationproductArrayList.clear();
                        databaseReference.child(i + "/k2/" + key1).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot)
                            {
                                for(DataSnapshot dataSnapshot1:snapshot.getChildren())
                                {
                                    final String key2 = dataSnapshot1.getKey().toString();
                                  databaseReference.child(i + "/k2/" + key1 + "/" + key2).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                      @Override
                                      public void onComplete(@NonNull Task<DataSnapshot> task)
                                      {
                                          String link = task.getResult().child("link").getValue().toString();
                                          String giaban = task.getResult().child("giaban").getValue().toString();
                                          String masp= task.getResult().child("masp").getValue().toString();
                                          String tensp = task.getResult().child("tensp").getValue().toString();
                                          String soluong = task.getResult().child("sl").getValue().toString();
                                          String mausac = task.getResult().child("mausac").getValue().toString();
                                          String tendm = key2;
                                          String magiahang = Login.tend;
                                          String kichthuoc = task.getResult().child("kichthuoc").getValue().toString();
                                         informationproductArrayList.add(new informationproduct(tensp + "\nSize : "+ " " + kichthuoc + "\nmàu sắc" + mausac, giaban + "\t\t\t\tSố lượng: " + soluong, tendm, masp, magiahang,link,  kichthuoc, informationevaluateArrayList));
                                         a.notifyDataSetChanged();
                                      }
                                  });
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error)
                            {

                            }
                        });

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });
        }
        catch (Exception e)
        {
            Toast.makeText(trangsp.this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

}