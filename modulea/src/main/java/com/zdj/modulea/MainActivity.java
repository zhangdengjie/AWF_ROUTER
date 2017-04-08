package com.zdj.modulea;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zdj.router.RouterManager;
import com.zdj.router.interfaces.IntentService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_modulea);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * note that : modulea 跳转到 moduleb 是不符合逻辑的,如果有共用的界面,则应封装在共用的module中 <br/>
                 * 作者 ：zdj <br/>
                 * created at 17-4-8 上午9:20
                 */
                /*RouterManager routerManager = new RouterManager.Builder().build();
                // 获取的是一个代理类
                IntentService intentService = routerManager.create(IntentService.class, MainActivity.this);
                intentService.toModuleBActivity("com.zdj.modulea.MainActivity"  , 2017);*/

                RouterManager routerManager = new RouterManager.Builder().build();

                routerManager.create(IntentService.class, MainActivity.this)
                        .toCommonActivity("com.zdj.modulea.MainActivity", 2017);
            }
        });

    }
}
