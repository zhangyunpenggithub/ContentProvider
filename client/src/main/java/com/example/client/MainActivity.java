package com.example.client;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textview).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /**
                         * 对user表进行操作
                         */

                        // 设置URI
                        Uri uri_user = Uri.parse("content://com.example.client/user");

                        // 插入表中数据
                        ContentValues values = new ContentValues();
                        values.put("_id", 3);
                        values.put("name", "Iverson");


                        // 获取ContentResolver
                        ContentResolver resolver = getContentResolver();
                        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
                        resolver.insert(uri_user, values);

                        /**
                         * 对job表进行操作
                         */
                        // 和上述类似,只是URI需要更改,从而匹配不同的URI CODE,从而找到不同的数据资源
                        Uri uri_job = Uri.parse("content://com.example.client/job");

                        // 插入表中数据
                        ContentValues values2 = new ContentValues();
                        values2.put("_id", 3);
                        values2.put("job", "NBA Player");

                        resolver.insert(uri_job, values2);
                    }
                });

    }
}
