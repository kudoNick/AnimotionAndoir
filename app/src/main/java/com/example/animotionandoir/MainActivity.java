package com.example.animotionandoir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnNext;
    Button btnMove,btnDone;
    LinearLayout linearLayout;
    boolean clicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.line1);
        btnDone = findViewById(R.id.btnDone);

        btnNext = findViewById(R.id.btNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        btnMove = findViewById(R.id.btMove);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!clicked){
                btnMove.animate().translationY(-700).translationX(400);
                btnNext.setVisibility(View.GONE);
                btnMove.setText("Xong");
                btnDone.setVisibility(View.VISIBLE);
                clicked = true;

                    btnDone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this,"Thành công",Toast.LENGTH_SHORT).show();
                            btnDone.setVisibility(View.GONE);
                            clicked=false;
                            btnMove.animate().translationY(0).translationX(0);
                            btnMove.setText("Di chuyển");
                            btnNext.setVisibility(View.VISIBLE);
                        }
                    });
                }else {
                    btnMove.animate().translationY(0).translationX(0);
                    btnMove.setText("Di chuyển");
                    btnNext.setVisibility(View.VISIBLE);
                    btnDone.setVisibility(View.GONE);
                    clicked = false;
                }
            }
        });



    }
}
