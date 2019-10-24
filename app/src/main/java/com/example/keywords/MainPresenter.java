package com.example.keywords;

import android.content.Context;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, KeywordsRepositoryImp.Listener {

    private KeywordsRepository keywordsRepository;
    private MainContract.View view;

    MainPresenter(Context context, MainContract.View view, DependencyInjector dependencyInjector) {
        this.view = view;
        this.keywordsRepository = dependencyInjector.keywordsRepository(context, this);
    }

    @Override
    public void onViewCreated() {
        keywordsRepository.fetchKeywords();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void onComplete(List<String> keywords) {
        for (int i = 0; i < keywords.size(); i++) {
            String brokenKeyword = KeywordBuilder.breakKeywordsIntoTwoLines(keywords.get(i));
            keywords.set(i, brokenKeyword);
        }
        if (view != null) {
            view.populateKeywords(keywords);
        }
    }
}