package com.itute.tranphieu.colormatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

//import static com.itute.tranphieu.colormath.MainActivity.main_intent;

public class ResultActivity extends AppCompatActivity {

    Button btnOk;
    TextView txtScore, txtVoT,txtRatio;
    String score;
    int countCheck,score_int;
    public static Intent main_intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        AnhXa();
        main_intent = new  Intent(ResultActivity.this,MainActivity.class);
        getData();
        setData();
        setButtonClick();
    }

    private void setButtonClick() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(main_intent);
            }
        });
    }

    private void setData() {
        txtScore.setText(score);
        score_int = Integer.parseInt(score);
        score_int=score_int/10;
        txtVoT.setText(score_int+" of "+countCheck);
        if(score_int ==0 && countCheck==0)
        {
            txtRatio.setText("0%");
        }
        else {
            double ratio = 1.0 * score_int / countCheck * 100;
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            decimalFormat.format(ratio);
            txtRatio.setText(ratio + "%");
        }
    }

    private void getData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE");
        score = bundle.getString("SCORE");
        countCheck = bundle.getInt("COUNTCHECK");
    }

    private void AnhXa() {
        btnOk = (Button) findViewById(R.id.ButtonOk);
        txtScore = (TextView) findViewById(R.id.TextViewScore);
        txtVoT = (TextView) findViewById(R.id.TextViewValidOnTotal);
        txtRatio = (TextView) findViewById(R.id.TextViewRatio);
    }
}
