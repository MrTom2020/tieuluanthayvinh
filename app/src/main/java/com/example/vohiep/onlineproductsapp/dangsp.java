package com.example.vohiep.onlineproductsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class dangsp extends AppCompatActivity {

    private EditText edtten,edttesp,edtgb,edtsl,edtmau,edtkt;
    private ImageView imageView;
    private Spinner spdmsp;
    private Button btndy,btnthoat;
    private ArrayList<String> arrayList;
    private ArrayAdapter arrayAdapter;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageReference = storage.getReferenceFromUrl("gs://tieuluanmonthayvinh.appspot.com");
    private DatabaseReference databaseReference,databaseReference1;
    private FirebaseDatabase firebaseDatabase;
    private Picasso picasso;
    private String k = Login.tend;
    private String kk = Login.id;
    private ProgressDialog progressDialog;
    private String dm = "";

    static final int keyy = 123;
    private String id = Login.tend;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangsp);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("dangnhap");
        addControl();
        addEvent();
        ax();

//        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/tieuluanmonthayvinh.appspot.com/o/hinh1618337131357.JPG?alt=media&token=d31264c7-e838-4333-bd1a-ed3f4aef9726").into(imageView);
//        databaseReference.child(id  + "/k2/link").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                byte[]h = Base64.decode(snapshot.getValue().toString(),Base64.DEFAULT);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(h,0,h.length);
//
//                imageView.setImageBitmap(bitmap);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        StorageReference storageReference1 = storage.getReference();
//        storageReference1.child("hinh1618337131357.JPG").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri)
//            {
//                Toast.makeText(dangsp.this,uri.toString(),Toast.LENGTH_SHORT).show();
//                Log.d("AAAAAAAAAAAAAAAAAAAAAA",uri.toString());
//            }
//        });

    }
    private void addControl()
    {
        spdmsp = (Spinner)findViewById(R.id.danhmucsp);
        imageView = (ImageView)findViewById(R.id.imageView);
        edtgb = (EditText)findViewById(R.id.edtgb);
        edtten = (EditText)findViewById(R.id.edttenchu);
        edtkt = (EditText)findViewById(R.id.edtkt);
        edttesp = (EditText)findViewById(R.id.edttensp);
        btndy = (Button)findViewById(R.id.btndy);
        edtsl = (EditText)findViewById(R.id.edtslg);
        edtmau = (EditText)findViewById(R.id.edtmau);
        btnthoat = (Button)findViewById(R.id.btneexit);
        edtten.setEnabled(false);
        edtten.setText(kk);

    }
    private void addEvent()
    {
        imageView.setOnClickListener(new myEvent());
        btnthoat.setOnClickListener(new myEvent());
        btndy.setOnClickListener(new myEvent());
    }
    private class myEvent implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if(view.equals(imageView))
            {
                ActivityCompat.requestPermissions(dangsp.this,new String[]{Manifest.permission.CAMERA},keyy);
            }
            if(view.equals(btndy))
            {
                dang();
            }
            if(view.equals(btnthoat))
            {
                hoi();
            }
        }
    }
    private void hoi()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(dangsp.this);
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
    private void ax()
    {
        arrayList = new ArrayList<>();
        arrayList.add("Áo");
        arrayList.add("Giày dép");
        arrayList.add("Quần");
        arrayList.add("Phụ kiện");
        arrayList.add("Combo văn phòng");
        arrayList.add("Combo đường phố");
        arrayList.add("Đồ đôi");
        arrayAdapter = new ArrayAdapter(dangsp.this, android.R.layout.simple_spinner_item,arrayList);
        spdmsp.setAdapter(arrayAdapter);
       spdmsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
           {
               dm = arrayList.get(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
    }
    private void dang()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Xin vui lòng chờ hệ thống đang tiến hành lưu");
        progressDialog.setIcon(R.drawable.panda);
        progressDialog.show();
        final Calendar calendar = Calendar.getInstance();
        final StorageReference ms;
        databaseReference1 = databaseReference.child(k + "/k2/" + dm + "/" + String.valueOf(calendar.getTimeInMillis()));
        ms = storageReference.child("hinh" + calendar.getTimeInMillis() + ".JPG");
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayInputStream);
        final byte[] data = byteArrayInputStream.toByteArray();
        final String[] dmm = new String[2];
        final UploadTask uploadTask = ms.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception)
            {
                Toast.makeText(dangsp.this,"Lưu thất bại",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                finish();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
            {
                try {
                    String tensp = edttesp.getText().toString();
                    String giaban = edtgb.getText().toString();
                    String sl = edtsl.getText().toString();
                    String chu = kk;
                    String mau = edtmau.getText().toString();
                    String kt = edtkt.getText().toString();
                    String c = Base64.encodeToString(data, Base64.DEFAULT);
                    ms.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri)
                        {
                            databaseReference1.child("link").setValue(uri.toString());
                        }
                    });
                    databaseReference1.child("giaban").setValue(giaban);
                    databaseReference1.child("sl").setValue(sl);
                    databaseReference1.child("mausac").setValue(mau);
                    databaseReference1.child("kichthuoc").setValue(kt);
                    databaseReference1.child("tensp").setValue(tensp);
                    databaseReference1.child("masp").setValue(String.valueOf(calendar.getTimeInMillis()));
                    databaseReference1.child("chu").setValue(chu);
                    progressDialog.dismiss();
                    finish();
                }
                catch (Exception e)
                {
                    Toast.makeText(dangsp.this,e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(data != null && requestCode == keyy && resultCode == RESULT_OK)
        {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if(requestCode == keyy && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,keyy);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}