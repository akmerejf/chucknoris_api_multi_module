package com.akmere.desafioguiabolso.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


fun Disposable.addToCompositeDisposable(compositeDisposable: CompositeDisposable){
    compositeDisposable.add(this)
}