package com.tje.loginserver;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tje.loginserver.databinding.ActivityMain2Binding;
import com.tje.loginserver.utils.ConnectServer;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends BaseActivity {

    ActivityMain2Binding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//        로그인에 성공한 사람의 토큰을 받아오자.

        String token = getIntent().getStringExtra("userToken");

        Log.d("사용자토큰값", token);

//        받아온 토큰을 가지고 /v2/me_info API 호출. 사용자 데이터 표시

        ConnectServer.getRequestMyInfo(mContext, token, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            int code = json.getInt("code");

                            if (code == 200) {
//                                정상적으로 데이터 수신

                                JSONObject data = json.getJSONObject("data");

                            }
                            else {
//                                비정상 상태
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main2);

    }
}
