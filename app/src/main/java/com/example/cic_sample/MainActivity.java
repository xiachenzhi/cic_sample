package com.example.cic_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.innovation.animal.breedfunctionsdk.SDK;
import com.innovation.animal.breedfunctionsdk.bean.CreatInsuredEntranceBean;
import com.innovation.animal.breedfunctionsdk.bean.LengthWeightResultBean;
import com.innovation.animal.breedfunctionsdk.bean.PointsResultBean;
import com.innovation.animal.breedfunctionsdk.callback.BusinessListener;
import com.innovation.animal.breedfunctionsdk.callback.LoadingListener;
import com.innovation.animal.breedfunctionsdk.callback.MessageListener;
import com.innovation.animal.breedfunctionsdk.utils.DialogUtil;
import com.innovation.animal.breedfunctionsdk.utils.ToastUtils;
import com.innovation.animal.breedfunctionsdk.widget.LoadingView;

import java.util.ArrayList;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *
         * Tip:
         *
         * 1.当前的 insuranceId 都创建过了：都是有测试数据的
         *
         * 2.如果需要走完整的流程 ，可以直接 修改 insuranceId（修改的幅度大一些，防止服务器有该数据）， 可以调转到确认承保方式页面
         *
         * 3.CreatInsuredEntranceBean 的参数说明详细见：
         * TODO:https://thoughts.aliyun.com/share/62748749df04d6001ae31331#title=中华SDK接口对接
         *
         *
         */

        //猪承保
        findViewById(R.id.btn_pig_c).setOnClickListener(view -> {
            SDK.insuredEntrance(GsonUtils.fromJson(
                    "{" +
                            "\"deptCode\": \"3210606CIC/20220517ZBNXB\",\n" +
                            "\"deptName\": \"中华联合保险/总部农险部\",\n" +
                            "\"insuranceId\":\"1484363556864941021\"," +
                            "\"riskCode\":\"170203\"," +
                            "\"riskName\":\"中华育肥猪险\"," +
                            "\"clauseCode\":\"256314\"," +
                            "\"clauseName\":\"中华育肥猪测试默认条款\"," +
                            "\"animalType\":1," +
                            "\"livestockBreeds\":204," +//  203 育肥舍 204 能繁舍
                            "\"insuranceMethod\":\"1\"," +
                            "\"enId\":\"1476095381895411011\"," +
                            "\"enName\":\"温海洋测试兴企业1\"," +
                            "\"breedMethod\":\"1\"," +
                            "\"createUserId\":\"1483369549313626113\"," +
                            "\"createUserName\":\"温海洋\"," +
                            "\"longitude\": \"116.414777\"," +
                            "\"latitude\": \"40.03988\"," +
                            "\"address\": \"中国北京朝阳立水桥office\"," +
                            "\"province\": \"北京市\"," +
                            "\"city\": \"北京市\"," +
                            "\"county\": \"朝阳区\"," +
                            "\"town\": \"北苑路\"," +
                            "\"village\": \"立水桥\"" +
                            "}", CreatInsuredEntranceBean.class), this);

        });

        //牛承保
        findViewById(R.id.btn_cow_c).setOnClickListener(view -> {
            SDK.insuredEntrance(GsonUtils.fromJson(
                    "{" +
                            "\"deptCode\":\"3210606CIC/20220517ZBNXB\"," +
                            "\"deptName\":\"中华联合保险/总部农险部\"," +
                            "\"insuranceId\":\"1484363556864942095\"," +
                            "\"insuranceName\":\"xiat测试\"," +
                            "\"riskCode\":\"170103\"," +
                            "\"riskName\":\"中华肉牛保险\"," +
                            "\"clauseCode\":\"1941002\"," +
                            "\"clauseName\":\"中华财险河南省商业性农产品目标价格保险\"," +
                            "\"animalType\":2," +
                            "\"livestockBreeds\":203," +//  203 育肥舍 204 能繁舍
                            "\"insuranceMethod\":\"1\"," +
                            "\"enId\":\"1476095381895401474\"," +
                            "\"enName\":\"xiat测试企业1\"," +
                            "\"breedMethod\":\"1\"," +
                            "\"createUserId\":\"1483369549313626113\"," +
                            "\"createUserName\":\"xiat测试\"," +
                            "\"latitude\":40.039872," +
                            "\"longitude\":116.414758," +
                            "\"province\":\"山西省\"," +
                            "\"city\":\"临汾市\"," +
                            "\"county\":\"尧都区\"," +
                            "\"town\":\"山河街道\"," +
                            "\"village\":\"村\"," +
                            "\"address\":\".\"" +
                            "}", CreatInsuredEntranceBean.class), this);
        });

        findViewById(R.id.btn_pig_l).setOnClickListener(view -> {
            com.blankj.utilcode.util.ToastUtils.showLong("请等待");
        });
        findViewById(R.id.btn_cow_l).setOnClickListener(view -> {
            com.blankj.utilcode.util.ToastUtils.showLong("请等待");
        });


        /**
         *  Loading 回调状态 可自定义修改
         */

        SDK.setLoadingListener(new LoadingListener() {
            @Override
            public void showLoading() {
                DialogUtil.getInstance().show(MainActivity.this, new LoadingView(MainActivity.this));
            }

            @Override
            public void hideLoading() {
                DialogUtil.getInstance().dismiss();
            }
        });

        SDK.setBusinessListener(new BusinessListener() {

            @Override
            public void scanFaceResult(String animalId) {

            }

            @Override
            public void lengthWeightResult(LengthWeightResultBean bean) {
                Timber.d("lengthWeightResult: bean==" + bean.toString());
                com.innovation.animal.breedfunctionsdk.utils.ToastUtils.success(bean.toString());
            }

            @Override
            public void checkPositioningBarResult(String pointsVideoUrl, int pointNumber) {
                Timber.d("checkPositioningBarResult: " + "点数视频路径==" + pointsVideoUrl + "      猪头数==" + pointNumber);
                com.innovation.animal.breedfunctionsdk.utils.ToastUtils.success("点数视频路径==" + pointsVideoUrl + "      猪头数==" + pointNumber);
            }

            @Override
            public void checkNumberResult(ArrayList<PointsResultBean> mNumList) {
                Timber.d("checkNumberResult: ===" + mNumList.toString());
                com.innovation.animal.breedfunctionsdk.utils.ToastUtils.success("点数数据有" + mNumList.size() + "个");
            }

            @Override
            public void insuredEntrance(String msg) {
                ToastUtils.success(msg);
            }


        });


    }
}