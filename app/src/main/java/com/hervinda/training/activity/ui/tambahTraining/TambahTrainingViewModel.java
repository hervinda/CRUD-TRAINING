package com.hervinda.training.activity.ui.tambahTraining;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TambahTrainingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TambahTrainingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tambahTraining fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}