package com.woojins.firstvill.main.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.user.UserApiClient

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    fun loginWithKakao(onResult: (Boolean, String?) -> Unit) {
        val context = getApplication<Application>().applicationContext

        KakaoSdk.init(getApplication(), "")

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                handleLoginResult(token, error, onResult)
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                handleLoginResult(token, error, onResult)
            }
        }
    }

    private fun handleLoginResult(token: OAuthToken?, error: Throwable?, onResult: (Boolean, String?) -> Unit) {
        if (error != null) {
            Log.e("KakaoLogin", "로그인 실패", error)
            onResult(false, error.localizedMessage)
        } else if (token != null) {
            Log.i("KakaoLogin", "로그인 성공 ${token.accessToken}")
            onResult(true, token.accessToken)
        }
    }

    fun logout(onResult: (Boolean) -> Unit) {
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Log.e("KakaoLogout", "로그아웃 실패", error)
                onResult(false)
            } else {
                Log.i("KakaoLogout", "로그아웃 성공")
                onResult(true)
            }
        }
    }
}