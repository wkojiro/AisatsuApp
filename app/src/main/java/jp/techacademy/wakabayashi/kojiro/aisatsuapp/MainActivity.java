package jp.techacademy.wakabayashi.kojiro.aisatsuapp;

/*

画面内にTimePickerDialogとButtonとTextViewを配置してください。
ButtonをタッチするとTimePickerDialogで設定した時刻に応じてTextViewに表示されるあいさつを変化させてください。
2:00 ~ 9:59 では「おはよう」
10:00 ~ 17:59 では「こんにちは」
18:00 ~ 1:59 では「こんばんは」



TimePickerDialogのインスタンスのhourOfDayとminuteから時刻と分を取得できます。

・EditTextは今回はいらなそう
・Buttonを１つだけ用意して、クリックするとTimePickerが表示され、表示を閉じると、メッセージが変わっているという仕組みを目指す。

 */



import android.app.TimePickerDialog;
//import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.TimePicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView mTextView;

    //EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
       // mEditText = (EditText) findViewById(R.id.editText);

    }

   // 2:00 ~ 9:59 では「おはよう」
   // 10:00 ~ 17:59 では「こんにちは」
   // 18:00 ~ 1:59 では「こんばんは」

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {

            showTimePickerDialog();

        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        if(hourOfDay >= 10 && hourOfDay < 18 ) {
                            mTextView.setText("こんにちは");
                        } else if (hourOfDay >= 18 && hourOfDay < 23 ) {
                            mTextView.setText("こんばんは");
                        } else if (hourOfDay >= 0 && hourOfDay < 2 ) {
                            mTextView.setText("こんばんは");
                        } else {
                            mTextView.setText("おはよう");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();


    }
}
