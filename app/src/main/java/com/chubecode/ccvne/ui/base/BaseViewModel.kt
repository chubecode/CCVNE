package com.chubecode.ccvne.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chubecode.ccvne.data.model.AppColor

abstract class BaseViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>().apply { value = false }

    val errorMessage = MutableLiveData<String>()

    val color = MutableLiveData<AppColor>()


    open fun onLoadFail(throwable: Throwable) {
        try {
            //do error case

        } catch (e: Exception) {
            errorMessage.value = throwable.message
        }
        isLoading.value = false
    }

    open fun showError(e: Throwable) {
        errorMessage.value = e.message
    }

    fun onActivityDestroyed() {
        //destroy anything
    }

    open fun setAppColor(appColor: AppColor){
        color.value = appColor
    }
}