package com.example.android_num5_timeexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.Display);
        button.setOnClickListener(the_Time);
    }
    private View.OnClickListener the_Time = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //字串格式化
            DecimalFormat time = new DecimalFormat("0");
            EditText Year = (EditText)findViewById(R.id.inputYear);
            EditText Month = (EditText)findViewById(R.id.inputMonth);
            EditText day = (EditText)findViewById(R.id.inputDay);
            EditText hour = (EditText)findViewById(R.id.inputHour);
            EditText minute = (EditText)findViewById(R.id.inputMinute);
            EditText second = (EditText)findViewById(R.id.inputSecond);
            //定義時間資料格式
            int DefineYear = Integer.parseInt(Year.getText().toString());
            int DefineMonth = Integer.parseInt(Month.getText().toString());
            int DefineDay = Integer.parseInt(day.getText().toString());
            int DefineHour = Integer.parseInt(hour.getText().toString());
            int DefineMinute = Integer.parseInt(minute.getText().toString());
            int DefineSecond = Integer.parseInt(second.getText().toString());

            //格式化輸出年/月/日
            TextView ymd = (TextView)findViewById(R.id.set_year_month_day);
            ymd.setText(time.format(DefineYear) + "/" + time.format(DefineMonth) + "/" + time.format(DefineDay));
            //格式化輸出時/分/秒
            TextView hms = (TextView)findViewById(R.id.set_hour_minute_second);
            hms.setText(time.format(DefineHour) + ":" + time.format(DefineMinute) + ":" + time.format(DefineSecond));
            TextView leap = (TextView)findViewById(R.id.set_leapYear);
            //判定閏年
            if (DefineYear % 4 == 0)
                leap.setText("Yes");
            else if (DefineYear% 100 == 0)
                leap.setText("Yes");
            else if (DefineYear % 400 == 0)
                leap.setText("Yes");
            else
                leap.setText("No");
        }
    };
}