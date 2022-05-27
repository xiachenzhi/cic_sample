###  CIC 测试Sample

------



### 接入方式

##### gradle 引入

```groovy
 implementation 'com.innovation.ai:breed-function-sdk-cic-test:1.4.0-bate'
```

##### 具体请见demo

。。。。。



### 使用方式

##### 初始化  Application 中

```java
SDK.init(Application application);
```

##### 理赔

```java
SDK.casesCallback(Context activity, CasesCallbackBean casesCallbackBean);
```

##### 承保

```java
SDK.insuredEntrance(CreatInsuredEntranceBean insuredEntranceBea, Context activit);
```

##### 入参字段详细见>>>

https://thoughts.aliyun.com/share/62748749df04d6001ae31331#title=%E4%B8%AD%E5%8D%8ESDK%E6%8E%A5%E5%8F%A3%E5%AF%B9%E6%8E%A5

##### 可使用的回调接口

```java
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

		/**
         * 商业回调
         */
      SDK.setBusinessListener(businessListener);

	//选取需要的回调即可
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



