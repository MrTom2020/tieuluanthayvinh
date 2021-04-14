package com.example.vohiep.onlineproductsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        listData();
        setProductRecycler(productCategoryList);
        setProdItemRecycler(productsList);
        ax();
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
                    Toast.makeText(MainActivity.this,"Vui lòng kiểm tra tốc độ internet",Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"Dữ liệu bị xung đột, vui lòng đăng nhập lại",Toast.LENGTH_SHORT).show();
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
        productCategoryList.add(new ProductCategory(1, "Tất cả"));
        productCategoryList.add(new ProductCategory(2, "Thịnh hành"));
        productCategoryList.add(new ProductCategory(3, "Phổ biến"));
        productCategoryList.add(new ProductCategory(4, "Đồ đôi"));
        productCategoryList.add(new ProductCategory(5, "Sự kiện"));
        productCategoryList.add(new ProductCategory(6, "Văn phòng"));
        productCategoryList.add(new ProductCategory(7, "Đường phố"));
        productsList.add(new Products(1, "Dép thời trang", "36", "$ 17.00", R.drawable.prod3));
        productsList.add(new Products(2, "Giày nam thể thao", "40", "$ 25.00", R.drawable.prod4));
        productsList.add(new Products(1, "Giày nữ nhẹ nhàng", "38", "$ 17.00", R.drawable.prod5));
        productsList.add(new Products(2, "Giày nữ cá tính", "39", "$ 25.00", R.drawable.prod6));
        productsList.add(new Products(1, "Dép nam nữ", "36", "$ 17.00", R.drawable.prod3));
        productsList.add(new Products(2, "Giày đường phố", "40", "$ 25.00", R.drawable.prod4));
        productsList.add(new Products(2, "Giày đường phố", "40", "$ 25.00", R.drawable.prod4));
        productsList.add(new Products(2, "Giày đường phố", "40", "$ 25.00", R.drawable.prod4));
        productsList.add(new Products(2, "Giày đường phố", "40", "$ 25.00", R.drawable.prod4));

          databaseReference2 = FirebaseDatabase.getInstance().getReference();
        databaseReference2.child("dangnhap").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                for(final DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    final String key1 = dataSnapshot.getKey().toString();
                    databaseReference2.child("dangnhap/" + key1 + "/k2").addValueEventListener(new ValueEventListener()
                    {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot)
                        {
                            for(DataSnapshot dataSnapshot1:snapshot.getChildren())
                            {
                               final String key2 = dataSnapshot1.getKey().toString();
                               databaseReference2.child("dangnhap/" + key1 + "/k2/"+key2 ).addValueEventListener(new ValueEventListener()
                               {
                                   @Override
                                   public void onDataChange(@NonNull DataSnapshot snapshot)
                                   {
                                       for(DataSnapshot dataSnapshot2:snapshot.getChildren())
                                       {
                                          String key3 = dataSnapshot2.getKey().toString();
                                          String kkk = snapshot.child(key3 + "/giaban").getValue().toString();
                                          Toast.makeText(MainActivity.this,kkk,Toast.LENGTH_SHORT).show();
                                           productsList.add(new Products(1, "Dép thời trang", "36", kkk, R.drawable.prod3));
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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        txtsl.setText(String.valueOf(k.length));
        /*Test cho layout gian hàng
        list.add(R.drawable.prod3);
        list.add(R.drawable.prod4);
        list.add(R.drawable.prod5);
        list.add(R.drawable.prod6);
        danhmuc.add("123");
        danhmuc.add("123");
        danhmuc.add("123");
        danhmuc.add("123");
        informationevaluateArrayList.add(new informationevaluate("1","2", Collections.singletonList(list.get(1)),"3",4,5));
        informationproductArrayList.add(new informationproduct("Quần","100","Quần kiểu","123","456",Collections.singletonList(list.get(2)),"123","36",informationevaluateArrayList));
        informationShopArrayList.add(new informationShop("123","hi","quần áo","Thời trang","31/10","300","123",danhmuc,informationproductArrayList));
        for(int i = 0; i < informationShopArrayList.size();i++)
        {
            imguser.setImageDrawable(getDrawable(informationShopArrayList.get(i).getList().get(i).getList().get(i).getImages().get(i)));
            Toast.makeText(MainActivity.this,informationShopArrayList.get(i).getList().get(i).getList().get(i).getUsername().toString(),Toast.LENGTH_SHORT).show();
        }*/
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
