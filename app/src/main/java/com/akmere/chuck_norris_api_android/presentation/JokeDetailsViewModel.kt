package com.akmere.chuck_norris_api_android.presentation

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akmere.chuck_norris_api_android.common.BaseSchedulerProvider
import com.akmere.chuck_norris_api_android.common.BaseViewModel
import com.akmere.chuck_norris_api_android.data.model.ChuckNorrisJoke
import com.akmere.chuck_norris_api_android.domain.usecase.GetChuckNorrisRandomJoke
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.IOException
import javax.inject.Inject

class JokeDetailsViewModel @Inject constructor(
    private val picasso: Picasso,
    private val getChuckNorrisRandomJoke: GetChuckNorrisRandomJoke,
    private val schedulerProvider: BaseSchedulerProvider
) : BaseViewModel() {

    private val mDetailsSuccessStatus = MutableLiveData<ChuckNorrisJoke>()
    val detailsSuccessStatus: LiveData<ChuckNorrisJoke>
        get() = mDetailsSuccessStatus

    private val mDetailsErrorStatus = MutableLiveData<String>()
    val detailsErrorStatus: LiveData<String>
        get() = mDetailsErrorStatus


    private val mJokeImageStatus = MutableLiveData<Bitmap>()
    val jokeImageStatus: LiveData<Bitmap>
        get() = mJokeImageStatus

    @SuppressLint("CheckResult")
    fun showDetails(category: String) {
        getChuckNorrisRandomJoke(category)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                try {
                    mDetailsSuccessStatus.value = it.getOrThrow()
                } catch (i: IOException) {
                    mDetailsErrorStatus.value =
                        "Chuck Norris derrubou sua conexão, tente conectar novamente"
                } catch (t: Throwable) {
                    mDetailsErrorStatus.value = t.message
                }

            }, {
                mDetailsErrorStatus.value = it.message
            })
    }

    fun showJokeImage(url: String) {
        try {
            picasso.load(url)
                .resize(300, 300)
                .centerCrop()
                .into(object : Target {
                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}

                    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                        mDetailsErrorStatus.value = "Imagem falhou em carregar Chuck Norris"
                    }

                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        mJokeImageStatus.value = bitmap
                    }
                })
        } catch (e: IOException) {
            mDetailsErrorStatus.value =
                "Chuck Norris derrubou sua conexão, tente conectar novamente"
        }
    }

}