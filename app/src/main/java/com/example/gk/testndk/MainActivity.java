package com.example.gk.testndk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

/**
 * http://blog.csdn.net/kevindgk/article/details/52813258
 * 修改c文件之后要重新生成so文件.然后拷贝到lib目录下 才能生效
 */
public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("jni-test");
    }

    private Button btn_get;
    private Button btn_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_post = (Button) findViewById(R.id.btn_post);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                btn_get.setText(getStringFromJni());
                break;
            case R.id.btn_post:
                postStringToJni("当前时间:" + Calendar.getInstance().getTime());
                break;
            default:
                break;
        }
    }

    /**
     * 从Jni拿到一个字符串
     *
     * @return 返回的字符串
     */
    public native String getStringFromJni();

    /**
     * 从java向Jni传递数据
     */
    public native void postStringToJni(String str);

}
