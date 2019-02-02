package com.learncode.testdatabinding.dataBinding;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.learncode.testdatabinding.adapter.RepoAdapter;
import com.learncode.testdatabinding.data.model.RepoModel;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityBinding {

    @BindingAdapter("app:showIfError")
    public static void showIfError(TextView textView, MutableLiveData<String> error){
        if(error==null || TextUtils.isEmpty(error.getValue())){
            textView.setVisibility(View.GONE);
        }else{
            textView.setVisibility(View.VISIBLE);
            textView.setText(error.getValue());
        }
    }
    @BindingAdapter("app:data")
    public static void setData(RecyclerView recyclerView, MutableLiveData<List<RepoModel>> repos){
        if(repos!=null&&repos.getValue()!=null){
            recyclerView.setAdapter(new RepoAdapter(repos.getValue()));
        }
    }
    @BindingAdapter("app:isLoading")
    public static void setProgress(ProgressBar progress, MutableLiveData<Boolean> isLoading){
        if(isLoading!=null && isLoading.getValue()){
            progress.setVisibility(View.VISIBLE);
        }else{
            progress.setVisibility(View.GONE);
        }
    }
//    @BindingAdapter("app:data")
//    public static void setData(RecyclerView recyclerView, MutableLiveData<List<String>> repos){
//        if(repos!=null&&repos.getValue()!=null){
//            recyclerView.setAdapter(new RepoAdapter(repos.getValue()));
////            for (String s :
////                    repos.getValue()) {
////                Log.e("BINDING111", s);
////            }
//        }
//    }
}
