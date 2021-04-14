package com.example.vohiep.onlineproductsapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vohiep.onlineproductsapp.sql.dulieusqllite;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class trangcanhan extends AppCompatActivity
{
    private EditText edtten,edtmk,edtdc,edtns;
    private Button btndy,btnluu;
    private Intent intent;
    private Bundle bundle;
    private  int kk = 0;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<InformationUser> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangcanhan);
        dangkynut();
        dangkysukien();
        ax();

    }
    private void dangkynut()
    {
        edtten = (EditText)findViewById(R.id.edttencanhan);
        edtmk = (EditText)findViewById(R.id.edtmkcanhan);
        edtdc = (EditText)findViewById(R.id.edtdiachicanhan);
        edtns = (EditText)findViewById(R.id.edtngaysinhcanhan);
        btndy = (Button)findViewById(R.id.btndycn);
        btnluu = (Button)findViewById(R.id.btnluucanhan);
    }
    private void dangkysukien()
    {
        btnluu.setOnClickListener(new sukiencuatoi());
        btndy.setOnClickListener(new sukiencuatoi());
    }
    private void sukiendong()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(trangcanhan.this);
        builder.setTitle ("THÔNG BÁO");
        builder.setMessage ("Bạn có muốn thoát");
        builder.setPositiveButton ("Có", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialog, int which)
            {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialog, int which)
            {
                dialog.dismiss ();
            }
        });
        Dialog dialog1 = builder.create();
        dialog1.show();
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }




    private void DoDuLieu()
    {
        try {
            for (int i = 0; i < arrayList.size(); ++i) {
                edtten.setText(arrayList.get(i).getHoten().toString());
                edtmk.setText(arrayList.get(i).getMatkhau().toString());
                edtns.setText(arrayList.get(i).getNgaysinh().toString());
                edtdc.setText(arrayList.get(i).getDiachi().toString());
            }
        }
        catch (Exception e)
        {
            Toast.makeText(trangcanhan.this,"Lỗi! Đã xảy ra lỗi. Vui lòng thử lại sau",Toast.LENGTH_SHORT).show();
            intent = new Intent(trangcanhan.this,Login.class);
            startActivity(intent);
        }
    }

    private void ax()
    {
        try {

            arrayList = new ArrayList<>();
            String id = Login.tend.toString();
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("dangnhap");
            databaseReference.child(id+"/k1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String Ma = snapshot.getKey().toString();
                    String Ten = snapshot.child("Name").getValue().toString();
                    String Mk = snapshot.child("Password").getValue().toString();
                    String diachi = snapshot.child("Address").getValue().toString();
                    String ngaysinh = snapshot.child("Date of Birth").getValue().toString();
                    arrayList.add(new InformationUser(Ten, Mk, ngaysinh, diachi));
                   for (int i = 0; i < arrayList.size(); ++i)
                    {
                        edtten.setText(arrayList.get(i).getHoten().toString());
                        edtmk.setText(arrayList.get(i).getMatkhau().toString());
                        edtns.setText(arrayList.get(i).getNgaysinh().toString());
                        edtdc.setText(arrayList.get(i).getDiachi().toString());
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error)
                {
                    Toast.makeText(trangcanhan.this,"Vui lòng kiểm tra tốc độ internet",Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(trangcanhan.this,"Dữ liệu bị xung đột, vui lòng đăng nhập lại",Toast.LENGTH_SHORT).show();
            intent = new Intent(trangcanhan.this,Login.class);
            startActivity(intent);
        }
    }

    private class sukiencuatoi implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if(view.equals(btndy))
            {
                sukiendong();
            }
            if(view.equals(btnluu))
            {

            }
        }
    }
}