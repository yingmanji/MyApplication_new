package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Activity_checkbox extends Activity implements CompoundButton.OnCheckedChangeListener{
    private CheckBox cbk_test;
    private ToggleButton tb_test;
    private RadioGroup rg_test;
    private RadioButton rb_male;
    private RadioButton rb_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        cbk_test=(CheckBox)findViewById(R.id.cbk_test);

        cbk_test.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //cbk_test.setText("选中");
                    cbk_test.setText(R.string.cbk_checked);
                }
                else
                {
                    //cbk_test.setText("未选中");
                    cbk_test.setText(R.string.cbk_unchecked);
                }
            }
        });

        tb_test=(ToggleButton)findViewById(R.id.tb_test);
        tb_test.setOnCheckedChangeListener(this);

        rg_test=(RadioGroup)findViewById(R.id.rg_test);
        rg_test.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //第一个参数被点击的RadioButton所在的RadioGroup,第二个参数被点击的Radiobutton的id
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb_check=(RadioButton)group.findViewById(checkedId);
                if(rb_check.isChecked()){
                    Toast.makeText(Activity_checkbox.this,rb_check.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            Toast.makeText(Activity_checkbox.this,"On",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(Activity_checkbox.this,"off",Toast.LENGTH_SHORT).show();
        }
    }
}
