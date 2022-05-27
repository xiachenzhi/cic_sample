# cic_sample
### 翔创科技 CIC 测试Demo



##### 接入方式

```groovy
 implementation 'com.innovation.ai:breed-function-sdk-cic-test:1.4.0-bate'
```



##### 初始化  Application 中

```java
SDK.init(Application application);
```

##### 理赔

```java
SDK.casesCallback(Context activity, CasesCallbackBean casesCallbackBean);
```

##### 承保

```
SDK.insuredEntrance(@NotNull CreatInsuredEntranceBean insuredEntranceBea, @NotNull Context activit);
```

##### 可监听的数据回调

```java
		 /**
         *  Loading 回调状态 可自定义修改
         */

        SDK.setLoadingListener(new LoadingListener() {
            @Override
            public void showLoading() {
                DialogUtil.getInstance().show(MainActivity.this, new LoadingView(MainActivity.this));
                //可自定义加载动画
            }

            @Override
            public void hideLoading() {
                DialogUtil.getInstance().dismiss();
            }
        });

		/**
         * 商业回调
         */
        SDK.setBusinessListener(businessListener);

      BusinessListener  businessListener =new BusinessListener(){
        /**
         * 圈养和育肥点数结果
         *
         * @param mNumList
         */
        @Override
        public void onCheckNumberResult(ArrayList<PointsResultBean> mNumList) {
            super.onCheckNumberResult(mNumList);
        }
        /**
         * 承保推送成功回调
         *
         * @param insureId 保单id
         * @param enId     农户id
         */
        @Override
        public void onSendInsureResult(String insureId, String enId) {
            super.onSendInsureResult(insureId, enId);
        }
        /**
         * 理赔推送成功回调
         *
         * @param caseId
         */
        @Override
        public void onSendCasesResult(String caseId) {
            super.onSendCasesResult(caseId);
        }
        /**
         * 定位栏点数结果
         *
         * @param pointsVideoUrl 视频路径
         * @param pointNumber    点数
         */
        @Override
        public void onCheckPositioningBarResult(String pointsVideoUrl, int pointNumber) {
            super.onCheckPositioningBarResult(pointsVideoUrl, pointNumber);
        }
        /**
         * 测长估重返回结果
         */
        @Override
        public void onLengthWeightResult(LengthWeightResultBean bean) {
            super.onLengthWeightResult(bean);
        }

        /**
         * 创建投保单
         */

        @Override
        public void onInsuredEntrance(String msg) {
            super.onInsuredEntrance(msg);
        }
        /**
         * 承保扫脸回调
         */
        @Override
        public void onInsuredEntranceResult(String animalId, String earLabNo) {
            super.onInsuredEntranceResult(animalId, earLabNo);
        }
        /**
         * 扫脸 回调
         */
        @Override
        public void onScanFaceResult(String animalId) {
            super.onScanFaceResult(animalId);
        }
        /**
         * 根据耳标嗯号删除投保牲畜 回调
         */
        @Override
        public void onDeleteAnimalResult(String mes) {
            super.onDeleteAnimalResult(mes);
        }
        /**
         * 异常信息回调
         * 针对ActivityManager不能获取栈顶activity
         *
         * @param error
         */
        @Override
        public void onErrorResult(String error) {
            super.onErrorResult(error);
        }
    };


```





