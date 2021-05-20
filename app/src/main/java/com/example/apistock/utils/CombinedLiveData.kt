package com.example.apistock.utils

import android.util.Pair.create
import androidx.core.util.Pair.create
import androidx.lifecycle.LiveData


import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.apistock.utils.MyPreference_Factory.create


/*class CombinedLiveData<A, B>(ld1: LiveData<A>?, ld2: LiveData<B>?) :
    MediatorLiveData<Pair<A, B>?>() {
    private val a: A? = null
    private val b: B? = null

    init {
        setValue(Pair.create(a, b))
        addSource(ld1, Observer { a: A? ->
            if (a != null) {
                this.a = a
            }
            setValue(Pair.create(a, b))
        })
        addSource(ld2, Observer { b: B? ->
            if (b != null) {
                this.b = b
            }
            setValue(Pair.create(a, b))
        })
    }
}*/