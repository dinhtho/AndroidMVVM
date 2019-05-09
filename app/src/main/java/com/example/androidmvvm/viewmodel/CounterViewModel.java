package com.example.androidmvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.androidmvvm.model.Count;

/**
 * Created by tho nguyen on 2019-05-09.
 */
public class CounterViewModel extends ViewModel {

    private MutableLiveData<Count> counter = new MutableLiveData<>();
    private Count count = new Count();


    public void onButtonClick() {
        int value = count.getCount();
        count.setCount(++value);
        counter.setValue(count);
    }

    public MutableLiveData<Count> getCounter() {
        return counter;
    }

}
