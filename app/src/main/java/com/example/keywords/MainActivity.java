package com.example.keywords;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView keywordsRecycleView;
    private RecyclerViewAdapter keywordsAdapter;
    private MainContract.Presenter presenter;
    private List<String> keywords = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keywordsRecycleView = findViewById(R.id.keywordsRecyclerView);
        keywordsAdapter = new RecyclerViewAdapter(keywords);
        keywordsRecycleView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
        keywordsRecycleView.setAdapter(keywordsAdapter);

        setPresenter(new MainPresenter(this, this, new DependencyInjectorImpl()));
        presenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void populateKeywords(List<String> keywords) {
       this.keywordsAdapter.setKeywords(keywords);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
