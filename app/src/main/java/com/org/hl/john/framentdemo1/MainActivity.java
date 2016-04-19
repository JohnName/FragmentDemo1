package com.org.hl.john.framentdemo1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

/**
 * Created by John on 2016/4/19.
 */
public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button button1 = (Button) findViewById(R.id.btn_show_fragment1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //动态添加Fragment
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                Fragmet1 fragmet1 = new Fragmet1();
                ft.add(R.id.fragment_container,fragmet1);
                ft.commit();
            }
        });
        Button button2 = (Button) findViewById(R.id.btn_show_fragment2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                Fragmet2 fragmet2 = new Fragmet2();
                ft.add(R.id.fragment_container,fragmet2);
                ft.commit();
            }
        });
    }
}
