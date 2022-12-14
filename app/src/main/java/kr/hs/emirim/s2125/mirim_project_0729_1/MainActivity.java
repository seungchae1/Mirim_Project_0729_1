package kr.hs.emirim.s2125.mirim_project_0729_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    RadioGroup rg;
    Character a; // 어떤 계산인지 결정
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        rg= findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.plus:
                        a='+';
                        break;
                    case R.id.minus:
                        a='-';
                        break;
                    case R.id.multi:
                        a='*';
                        break;
                    case R.id.divi:
                        a='/';
                        break;
                }
            }
        });

        Button btnPlus = findViewById(R.id.btn);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("num1", Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edit2.getText().toString()));
                intent.putExtra("a",a);
                startActivityForResult(intent,0);
            }
        });
    }

    //SecondActivity에게 값을 받아오기 위한 메서드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int sum = data.getIntExtra("result",0);
            Toast.makeText(getApplicationContext(), "계산결과 : "+sum, Toast.LENGTH_LONG).show();
        }
    }
}