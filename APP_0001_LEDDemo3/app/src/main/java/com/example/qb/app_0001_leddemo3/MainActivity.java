package com.example.qb.app_0001_leddemo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.qb.hardlibrary.*;

public class MainActivity extends AppCompatActivity {
    private boolean ledon = false;
    private Button button = null;
    private CheckBox checkBoxLed1 = null;
    private CheckBox checkBoxLed2 = null;
    private CheckBox checkBoxLed3 = null;
    private CheckBox checkBoxLed4 = null;

    class MyButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int i = 0;
            ledon = !ledon;
            if (ledon){
                button.setText("ALL OFF");
                checkBoxLed1.setChecked(true);
                checkBoxLed2.setChecked(true);
                checkBoxLed3.setChecked(true);
                checkBoxLed4.setChecked(true);
                for (i = 0; i < 4; i++){
                    HardControl.ledCtrl(i, 1);
                }

            }
            else {
                button.setText("ALL ON");
                checkBoxLed1.setChecked(false);
                checkBoxLed2.setChecked(false);
                checkBoxLed3.setChecked(false);
                checkBoxLed4.setChecked(false);
                for (i = 0; i < 4; i++){
                    HardControl.ledCtrl(i, 0);
                }
            }
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.LED1:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED1 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 1);
                }
            else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED1 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 0);
                }
                break;
            case R.id.LED2:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED2 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 1);
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED2 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
                }
                break;
            case R.id.LED3:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED3 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 1);
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED3 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 0);
                }
                break;
            case R.id.LED4:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED4 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 1);
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED4 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 0);
                }
                break;
            // TODO: Veggie sandwich
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HardControl.ledOpen();

        button = (Button)findViewById(R.id.BUTTON);
/*      //方式一
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Perform action on click
                ledon = !ledon;
                if (ledon)
                    button.setText("ALL OFF");
                else
                    button.setText("ALL ON");
            }
        });
        */
        //方式二
        button.setOnClickListener(new MyButtonListener());

        checkBoxLed1 = (CheckBox)findViewById(R.id.LED1);
        checkBoxLed2 = (CheckBox)findViewById(R.id.LED2);
        checkBoxLed3 = (CheckBox)findViewById(R.id.LED3);
        checkBoxLed4 = (CheckBox)findViewById(R.id.LED4);
    }
}
