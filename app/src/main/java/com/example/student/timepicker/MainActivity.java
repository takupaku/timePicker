package com.example.student.timepicker;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvResult);
    }

    public void Click(View view) {

        TimePicker timePicker = new TimePicker(this);
        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
        setCurrentTime();


    }

    private void setCurrentTime() {

//        final StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("time: ");

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                int hour = i,minute=i1;
                String am_pm;
                if(hour<12){
                    am_pm="am";
                    if(hour == 0)
                    {
                        hour = 12 ;
                    }

                }
                else
                {
                    am_pm= "pm";
                    //if(hour <12) hour -=12;

                    if(hour == 12){
                        hour = 12;
                    }
                    else {
                        hour-= 12;
                    }
                }
                textView.setText("Time: " + hour + ": " +minute+" "+ am_pm);

            }
        }, hour, minute, true);

        timePickerDialog.show();

    }


}
