package com.dayo.map.selectime;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity implements View.OnClickListener{
    private CustomDatePicker customDatePicker;
    private String now;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        findViewById(R.id.bt).setOnClickListener(this);
        DatePicker();
    }
    /**
     * 显示时间
     */
    private void DatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        //获取当前时间
        now = sdf.format(new Date());
        //tvElectricalTime.setText(now.split(" ")[0]);
        customDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                Log.d("yyyyy", time);
                tv.setText(time.split(" ")[0]);

            }
        }, "1990-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker.showSpecificTime(false); // 不显示时和分
        customDatePicker.setIsLoop(false); // 不允许循环滚动
    }

    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(tv.getText().toString().trim()))
            customDatePicker.show(now);
        else  // 日期格式为yyyy-MM-dd
            customDatePicker.show(tv.getText().toString());

    }
}
