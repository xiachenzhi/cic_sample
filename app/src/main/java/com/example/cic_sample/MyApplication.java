package com.example.cic_sample;

import android.app.Application;

import com.innovation.animal.breedfunctionsdk.SDK;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();



        /**
         *
         *
         * 本demo  通过私服 下载 'com.innovation.ai:breed-function-sdk-cic-test:1.4.0-bate
         *
         * 请到 settings.gradle 配置，该账号密码找 xckj 申请
         *
         * username '*******'
         * password '*****'
         *
         *
         *
         * @param savedInstanceState
         */

        //初始化 SDK，请确认 sdk 导报正确（com.innovation.animal.breedfunctionsdk.SDK;）
        SDK.init(this);
    }
}
