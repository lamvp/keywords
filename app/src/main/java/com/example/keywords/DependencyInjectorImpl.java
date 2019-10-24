package com.example.keywords;

import android.content.Context;

import com.example.keywords.KeywordsRepositoryImp.Listener;

class DependencyInjectorImpl implements DependencyInjector{

    @Override
    public KeywordsRepository keywordsRepository(Context context, Listener listener) {
        return new KeywordsRepositoryImp(context, listener);
    }
}

