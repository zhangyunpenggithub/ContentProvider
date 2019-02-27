package com.example.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
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
                        Uri uri_user = Uri.parse("content://com.example.contentprovider/user");

                        // 插入表中数据
                        ContentValues values = new ContentValues();
                        values.put("_id", 3);
                        values.put("name", "Iverson");


                        // 获取ContentResolver
                        ContentResolver resolver = getContentResolver();
                        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
                        resolver.insert(uri_user, values);

                        // 通过ContentResolver 向ContentProvider中查询数据
                        Cursor cursor = resolver.query(uri_user, new String[]{"_id", "name"}, null, null, null);
                        while (cursor.moveToNext()) {
                            System.out.println("query book:" + cursor.getInt(0) + " " + cursor.getString(1));
                            // 将表中数据全部输出
                        }
                        cursor.close();
                        // 关闭游标

                        /**
                         * 对job表进行操作
                         */
                        // 和上述类似,只是URI需要更改,从而匹配不同的URI CODE,从而找到不同的数据资源
                        Uri uri_job = Uri.parse("content://com.example.contentprovider/job");

                        // 插入表中数据
                        ContentValues values2 = new ContentValues();
                        values2.put("_id", 3);
                        values2.put("job", "NBA Player");

                        // 获取ContentResolver
                        ContentResolver resolver2 = getContentResolver();
                        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
                        resolver2.insert(uri_job, values2);

                        // 通过ContentResolver 向ContentProvider中查询数据
                        Cursor cursor2 = resolver2.query(uri_job, new String[]{"_id", "job"}, null, null, null);
                        while (cursor2.moveToNext()) {
                            System.out.println("query job:" + cursor2.getInt(0) + " " + cursor2.getString(1));
                            // 将表中数据全部输出
                        }
                        cursor2.close();
                        // 关闭游标
                    }
                });

    }
}