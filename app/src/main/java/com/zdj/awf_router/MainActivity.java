package com.zdj.awf_router;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zdj.router.RouterManager;
import com.zdj.router.interfaces.IntentService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager routerManager = new RouterManager.Builder().build();
                // 获取的是一个代理类
                IntentService intentService = routerManager.create(IntentService.class, MainActivity.this);
                intentService.toModuleAActivity("com.zdj.awf_router.MainActivity", 2017);
            }
        });

    }
}
