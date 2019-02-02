package com.learncode.testdatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.learncode.testdatabinding.adapter.RepoAdapter;
import com.learncode.testdatabinding.databinding.ActivityMainBinding;
import com.learncode.testdatabinding.viewmodel.SearchRepoViewModel;
import com.learncode.testdatabinding.viewmodel.SearchRepoViewModelFactory;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public SearchRepoViewModelFactory viewmodelFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((MainApplication)getApplicationContext()).getApiComponent().inject(this);
        SearchRepoViewModel viewModel = ViewModelProviders.of(this, viewmodelFactory ).get(SearchRepoViewModel.class);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);
    }
}
