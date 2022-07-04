package com.vanh.mylibrary.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {
    protected MutableLiveData<Result> resultMutableLiveData;

    public MutableLiveData<Result> getResultMutableLiveData() {
        if(resultMutableLiveData == null) resultMutableLiveData = new MutableLiveData<>();

        return resultMutableLiveData;
    }

    public static class Result {
        public int code;
        public boolean status;
        public Object data;

        public Result(boolean status, int resultCode) {
            this.status = status;
            this.code = resultCode;
        }

        public Result(boolean status, Object data, int resultCode) {
            this.status = status;
            this.data = data;
            this.code = resultCode;
        }

        @Override
        public String toString() {
            return code + ": " + status + ((data!=null)?data:"");
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
