package com.example.contentprovider;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

/**
 * +----------------------------------------------------------------------
 * | 59197696@qq.com
 * +----------------------------------------------------------------------
 * | 功能描述:
 * +----------------------------------------------------------------------
 * | 时　　间: 2019/2/27.
 * +----------------------------------------------------------------------
 * | 代码创建: 张云鹏
 * +----------------------------------------------------------------------
 * | 版本信息: V1.0.0
 * +----------------------------------------------------------------------
 **/
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.text2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.example.client", "com.example.client.MainActivity"));
                startActivity(intent);
            }
        });

        Uri uri = Uri.parse("content://com.example.client");
        ContentObserver observer = new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                Log.e("zhangyunpeng", "change le");
            }
        };
        getContentResolver().registerContentObserver(uri, true, observer);

    }
}
