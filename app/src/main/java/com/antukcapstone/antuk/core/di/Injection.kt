package com.antukcapstone.antuk.core.di

import android.content.Context
import com.antukcapstone.antuk.core.data.AntukRepository
import com.antukcapstone.antuk.core.data.local.datastore.UserPreferences
import com.antukcapstone.antuk.core.data.local.datastore.dataStore
import com.antukcapstone.antuk.core.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

//private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

object Injection {
    fun provideAntukRepository(context: Context):AntukRepository {
        val preference = UserPreferences.getInstance(context.dataStore)
        val user = runBlocking { preference.getLoggedInUser().first() }

        val apiService = ApiConfig.getApiService(user.token)
        return AntukRepository.getInstance(apiService, preference)
    }

//    fun provideUserPreference(dataStore: DataStore<Preferences>): UserPreferences {
//        return UserPreferences.getInstance(
//            dataStore
//        )
//    }
}