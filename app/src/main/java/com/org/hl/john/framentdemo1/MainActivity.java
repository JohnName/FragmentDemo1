package com.org.hl.john.framentdemo1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

/**
 * Created by John on 2016/4/19.
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button button1 = (Button) findViewById(R.id.btn_show_fragment1);
        Button button2 = (Button) findViewById(R.id.btn_show_fragment2);
        Button button3 = (Button) findViewById(R.id.btn_remove_fragment2);
        Button button4 = (Button) findViewById(R.id.btn_replace_fragment1);
        Button button5 = (Button) findViewById(R.id.btn_back_fragment1);
        Button button6 = (Button) findViewById(R.id.btn_back_fragment1_1);
        Button button7 = (Button) findViewById(R.id.btn_backsigle_fragment);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
    }
    //动态添加Fragment
    private void addFragment(Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }
    //移除fragment
    private void removeFragment(String fragmentStr){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(fragmentStr);
        if (fragment != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
    }
    //替换fragment
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }
    //单层依次回退
    private void popBackStack(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }
    //通过  popBackStack("fragment1",0)  直接回退到fragment1
    private void back0Fragment1(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack("fragment1",0);
    }
    //通过  popBackStack("fragment2",FragmentManager.POP_BACK_STACK_INCLUSIVE);  直接回退到fragment2的上一级
    private void backFagmentManager(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack("fragment2",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_show_fragment1:
                //动态添加Fragment
                Fragmet1 fragmet1 = new Fragmet1();
                addFragment(fragmet1,"fragment1");
            break;
            case R.id.btn_show_fragment2:
                Fragmet2 fragmet2 = new Fragmet2();
                addFragment(fragmet2,"fragment2");
                break;
            case R.id.btn_remove_fragment2:
                removeFragment("fragment2");
                break;
            case R.id.btn_replace_fragment1:
                Fragmet2 frgment2 = new Fragmet2();
                replaceFragment(frgment2);
                break;
            case R.id.btn_back_fragment1:
                back0Fragment1();
                break;
            case R.id.btn_back_fragment1_1:
                backFagmentManager();
                break;
            case R.id.btn_backsigle_fragment:
                popBackStack();
                break;
        }
    }
}
