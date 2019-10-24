package com.example.keywords;

import android.content.Context;

interface DependencyInjector {
    KeywordsRepository keywordsRepository(Context context, KeywordsRepositoryImp.Listener listener);
}
