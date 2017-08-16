package jp.techacademy.noriko.seri.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);

    }

    @Override
    public void onClick(View v) {

        String answer = "";
        try {

            BigDecimal calc1 = new BigDecimal(mEditText1.getText().toString());
            BigDecimal calc2 = new BigDecimal(mEditText2.getText().toString());


            if (v.getId() == R.id.button1) {

                answer = calc1.add(calc2).stripTrailingZeros().toString();

            } else if (v.getId() == R.id.button2) {

                answer = calc1.subtract(calc2).stripTrailingZeros().toString();


            } else if (v.getId() == R.id.button3) {

                answer = calc1.multiply(calc2).stripTrailingZeros().toString();


            } else if (v.getId() == R.id.button4) {

                answer = calc1.divide(calc2,7,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();

            }

        } catch( Exception e) {
            answer = "計算できませんでした。";
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("answer", answer);
        startActivity(intent);

    }



}
