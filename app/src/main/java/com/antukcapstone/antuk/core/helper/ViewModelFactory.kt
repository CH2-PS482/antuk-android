package com.antukcapstone.antuk.core.helper

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antukcapstone.antuk.MainViewModel
import com.antukcapstone.antuk.core.data.AntukRepository
import com.antukcapstone.antuk.core.di.Injection
import java.lang.IllegalArgumentException
import com.antukcapstone.antuk.ui.screens.account.login.LoginViewModel
import com.antukcapstone.antuk.ui.screens.account.password.ResetPasswordViewModel
import com.antukcapstone.antuk.ui.screens.account.profile.EditProfileViewModel
import com.antukcapstone.antuk.ui.screens.account.profile.ProfileViewModel
import com.antukcapstone.antuk.ui.screens.account.register.RegisterViewModel


class ViewModelFactory (private val repository: AntukRepository) : ViewModelProvider.NewInstanceFactory() {
    
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }

            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }

            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(repository) as T
            }

            modelClass.isAssignableFrom(EditProfileViewModel::class.java) -> {
                EditProfileViewModel(repository) as T
            }

            modelClass.isAssignableFrom(ResetPasswordViewModel::class.java) -> {
                ResetPasswordViewModel(repository) as T
            }

            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if(instance == null) {
                synchronized(ViewModelFactory::class.java) {
                    instance = ViewModelFactory(Injection.provideAntukRepository(context))
                }
            }
            return instance as ViewModelFactory
        }
    }
}

