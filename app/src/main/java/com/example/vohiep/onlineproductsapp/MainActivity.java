package com.example.vohiep.onlineproductsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vohiep.onlineproductsapp.adapter.ProductAdapter;
import com.example.vohiep.onlineproductsapp.adapter.ProductCategoryAdapter;
import com.example.vohiep.onlineproductsapp.model.ProductCategory;
import com.example.vohiep.onlineproductsapp.model.Products;
import com.example.vohiep.onlineproductsapp.model.informationShop;
import com.example.vohiep.onlineproductsapp.model.informationevaluate;
import com.example.vohiep.onlineproductsapp.model.informationproduct;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     private ProductCategoryAdapter productCategoryAdapter;
     private RecyclerView productCatRecycler, prodItemRecycler;
     private ProductAdapter productAdapter;
     private List<ProductCategory> productCategoryList = new ArrayList<>();
     private List<Products> productsList = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference,databaseReference2;
     private TextView txtten,txtbanner,txtsl;
     static String ten;
     /* ArrayList<informationevaluate> informationevaluateArrayList = new ArrayList<>();
     private ArrayList<informationproduct> informationproductArrayList = new ArrayList<>();
     private ArrayList<informationShop> informationShopArrayList = new ArrayList<>();
     private ArrayList<Integer> list = new ArrayList<Integer>();
     private List<String> danhmuc = new ArrayList<>();*/
     private Button btngh;
     private ImageView imguser;
     private Intent intent;
     private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
        setProductRecycler(productCategoryList);
        setProdItemRecycler(productsList);
        ax();
        listData();
        ax3();
        registerForContextMenu(imguser);
    }
    private void ax()
    {
        try {

            String id = Login.tend.toString();
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("dangnhap");
            databaseReference.child(id+"/k1").addValueEventListener(new ValueEventListener()
            {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String Ma = snapshot.getKey().toString();
                    String Ten = snapshot.child("Name").getValue().toString();
                    ten = Ten;
                    txtten.setText(Ten);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error)
                {
                    Toast.makeText(MainActivity.this,"Vui l??ng ki???m tra t???c ????? internet",Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"D??? li???u b??? xung ?????t, vui l??ng ????ng nh???p l???i",Toast.LENGTH_SHORT).show();
            intent = new Intent(MainActivity.this,Login.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.ttcn:
                intent = new Intent(MainActivity.this,trangcanhan.class);
                startActivity(intent);
                break;
            case R.id.shopp:
                intent = new Intent(MainActivity.this,yourShop.class);
                startActivity(intent);
                break;
            case R.id.dban:
                intent = new Intent(MainActivity.this,dangsp.class);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void setProductRecycler(List<ProductCategory> productCategoryList)
    {
        layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);
    }

    private void setProdItemRecycler(List<Products> productsList)
    {
        layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }
    private void listData()
    {
        final int[] k = {0};
        productCategoryList.add(new ProductCategory(1, "T???t c???"));
        productCategoryList.add(new ProductCategory(2, "Th???nh h??nh"));
        productCategoryList.add(new ProductCategory(3, "Ph??? bi???n"));
        productCategoryList.add(new ProductCategory(4, "????? ????i"));
        productCategoryList.add(new ProductCategory(5, "S??? ki???n"));
        productCategoryList.add(new ProductCategory(6, "V??n ph??ng"));
        productCategoryList.add(new ProductCategory(7, "???????ng ph???"));
        productsList.add(new Products("1", "D??p th???i trang", "36", "$ 17.00", "https://firebasestorage.googleapis.com/v0/b/tieuluanmonthayvinh.appspot.com/o/hinh1618389635673.JPG?alt=media&token=6854e33c-8564-4adc-80c6-84b70182d7f8","","",""));

        txtsl.setText(String.valueOf(k.length));
        /*Test cho layout gian h??ng
        list.add(R.drawable.prod3);
        list.add(R.drawable.prod4);
        list.add(R.drawable.prod5);
        list.add(R.drawable.prod6);
        danhmuc.add("123");
        danhmuc.add("123");
        danhmuc.add("123");
        danhmuc.add("123");
        informationevaluateArrayList.add(new informationevaluate("1","2", Collections.singletonList(list.get(1)),"3",4,5));
        informationproductArrayList.add(new informationproduct("Qu???n","100","Qu???n ki???u","123","456",Collections.singletonList(list.get(2)),"123","36",informationevaluateArrayList));
        informationShopArrayList.add(new informationShop("123","hi","qu???n ??o","Th???i trang","31/10","300","123",danhmuc,informationproductArrayList));
        for(int i = 0; i < informationShopArrayList.size();i++)
        {
            imguser.setImageDrawable(getDrawable(informationShopArrayList.get(i).getList().get(i).getList().get(i).getImages().get(i)));
            Toast.makeText(MainActivity.this,informationShopArrayList.get(i).getList().get(i).getList().get(i).getUsername().toString(),Toast.LENGTH_SHORT).show();
        }*/
    }
    private void ax3()
    {
        try {
            databaseReference2 = FirebaseDatabase.getInstance().getReference();
            databaseReference2.child("dangnhap").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (final DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        final String key1 = dataSnapshot.getKey().toString();
                        databaseReference2.child("dangnhap/" + key1 + "/k2").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot1 : snapshot.getChildren()) {
                                    final String key2 = dataSnapshot1.getKey().toString();
                                    productsList.clear();
                                    databaseReference2.child("dangnhap/" + key1 + "/k2/" + key2).addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            for (DataSnapshot dataSnapshot2 : snapshot.getChildren()) {
                                                String key3 = dataSnapshot2.getKey().toString();
                                                String kkk = snapshot.child(key3 + "/giaban").getValue().toString();
                                                String link = snapshot.child(key3 + "/link").getValue().toString();
                                                String tensp = snapshot.child(key3 + "/tensp").getValue().toString();
                                                String size = snapshot.child(key3 + "/kichthuoc").getValue().toString();
                                                String masp = snapshot.child(key3 + "/masp").getValue().toString();
                                                String mau = snapshot.child(key3 + "/mausac").getValue().toString();
                                                String sl = snapshot.child(key3 + "/sl").getValue().toString();
                                                String chu = snapshot.child(key3 + "/chu").getValue().toString();
                                                productsList.add(new Products( masp, tensp, sl, kkk, link,mau,size,chu));
                                                productAdapter.notifyDataSetChanged();
//                                          databaseReference2.child("dangnhap/" + key1 + "/k2/" + key2 + "/" + key3).addValueEventListener(new ValueEventListener() {
//                                              @Override
//                                              public void onDataChange(@NonNull DataSnapshot snapshot)
//                                              {
//
//                                              }
//
//                                              @Override
//                                              public void onCancelled(@NonNull DatabaseError error)
//                                              {
//
//                                              }
//                                          });
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

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
            Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
    private void addControl()
    {
        productCatRecycler = findViewById(R.id.cat_recycler);
        prodItemRecycler = findViewById(R.id.product_recycler);
        btngh = (Button)findViewById(R.id.btngiohang);
        txtbanner = (TextView)findViewById(R.id.txtbaner);
        txtten = (TextView)findViewById(R.id.txtuser);
        imguser = (ImageView)findViewById(R.id.imguser);
        txtsl = (TextView)findViewById(R.id.textView22);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        getMenuInflater().inflate(R.menu.menucon,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void addEvent()
    {
        imguser.setOnClickListener(new myEvent());
    }
    private class myEvent implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
        }
    }
}
