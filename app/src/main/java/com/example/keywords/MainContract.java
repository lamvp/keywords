package com.example.keywords;

import java.util.List;

interface MainContract {
    interface Presenter extends BasePresenter {
        void onViewCreated();
    }

    interface View extends BaseView<Presenter> {
        void populateKeywords(List<String> keywords);
    }
}