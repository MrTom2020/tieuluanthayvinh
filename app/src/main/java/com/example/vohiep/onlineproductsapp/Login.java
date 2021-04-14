package com.example.vohiep.onlineproductsapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.vohiep.onlineproductsapp.Servicee.ConnectionReceiver;
import com.example.vohiep.onlineproductsapp.sql.dulieusqllite;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends Activity {

    private   EditText edtten,edtmk;
    private Button btndn,btndk;
    private TextView txt;
    private FirebaseAuth firebaseAuth;
    private Intent intent;
    static  int c = 12345;
    static String id = "";
    static String tend,ten1;
    private Cursor cursor;
    private dulieusqllite dl;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dangkynut();
        check();
        dangkysukien();

    }
    private void check()
    {
        boolean ret = ConnectionReceiver.isConnected();
        String ms;
        if (ret == true)
        {
            ms = "Hiện tại bạn đang online";
            ten1 = "ok";
        }
        else
        {
            ms = "Hiện tại bạn đang offline";
            ten1 = "ko";
            btndk.setEnabled (false);
        }
        Toast.makeText(Login.this,ms,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event)
    {
        Log.i("key pressed", String.valueOf(event.getKeyCode()));
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onStart()
    {
        check();
        super.onStart();
    }
    private void dangkynut()
    {
        edtten = (EditText)findViewById(R.id.use);
        edtmk = (EditText)findViewById(R.id.pass);
        btndn = (Button)findViewById(R.id.btngiohang);
        btndk = (Button)findViewById(R.id.btndangkytk);
//        edtten.setOnKeyListener(new View.OnKeyListener()
//        {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event)
//            {
//                if(event.getAction() == KeyEvent.ACTION_UP)
//                {
//                    if(edtten.getText().toString().trim().length() < 1)
//                    {
//                        btndn.setEnabled(false);
//                        edtten.setBackgroundColor(0xffffffff);
//                    }
//                    else
//                    {
//                        edtten.setBackgroundColor(0xfffff000);
//                    }
//                }
//                return false;
//            }
//        });
//        edtmk.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event)
//            {
//                if(event.getAction() == KeyEvent.ACTION_UP)
//                {
//                    if(edtmk.getText().toString().trim().length() < 1)
//                    {
//                        btndn.setEnabled(false);
//                        edtmk.setBackgroundColor(0xffffffff);
//                    }
//                    else
//                    {
//                        edtmk.setBackgroundColor(0xfffff000);
//                        btndn.setEnabled(true);
//                    }
//                }
//                return false;
//            }
//        });
        edtmk.setText("123456789");
        edtten.setText("tomhumchinvvvn@gmail.com");

    }
    private void dangkysukien()
    {
        btndn.setOnClickListener(new sukiencuatoi());
        btndk.setOnClickListener(new sukiencuatoi());
    }

    private class sukiencuatoi implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if(view.equals(btndn))
            {
                if(ten1.equals("ok"))
                {
                    dangnhap();
                }
            }
            if(view.equals(btndk))
            {
                Intent intent = new Intent(Login.this,trangdangky.class);
                startActivity(intent);
            }
        }

    }

    private void dangnhap()
    {
        try {

            progressDialog = new ProgressDialog(Login.this);
            progressDialog.setMessage("Xin vui lòng chờ trong giây lát");
            progressDialog.show();
            final String ten = edtten.getText().toString();
            String mk = edtmk.getText().toString();
            firebaseAuth = FirebaseAuth.getInstance();
            firebaseAuth.signInWithEmailAndPassword(ten.trim(), mk.trim()).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        intent = new Intent(Login.this, MainActivity.class);
                        tend = firebaseAuth.getCurrentUser().getUid().toString();
                        id = ten;
                        startActivity(intent);
                    } else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();

                    }
                    progressDialog.dismiss();
                }

            });
        }
        catch (Exception e)
        {
            progressDialog.dismiss();
            Toast.makeText(Login.this,"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
        }
    }
}