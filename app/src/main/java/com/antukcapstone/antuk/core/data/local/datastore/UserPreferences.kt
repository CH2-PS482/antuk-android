package com.antukcapstone.antuk.core.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

class UserPreferences private constructor(private val dataStore: DataStore<Preferences>) {

    fun getLoggedInUser(): Flow<UserModel> {
        return dataStore.data.map { preferences ->
            UserModel(
                preferences[IDUSER_KEY] ?: "",
                preferences[FULLNAME_KEY] ?: "",
                preferences[PHONENUMBER_KEY] ?: "",
                preferences[TOKEN_KEY] ?: "",
                preferences[IS_LOGGEDIN_KEY] ?: false
            )
        }
    }

    suspend fun saveLoggedInUser(user: UserModel) {
        dataStore.edit {preferences ->
            preferences[IDUSER_KEY] = user.idUser
            preferences[FULLNAME_KEY] = user.fullName
            preferences[PHONENUMBER_KEY]= user.phoneNumber
            preferences[TOKEN_KEY] = user.token
            preferences[IS_LOGGEDIN_KEY] = true
        }
    }

    suspend fun signOut() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreferences ?= null

        private val IDUSER_KEY = stringPreferencesKey("idUser")
        private val FULLNAME_KEY = stringPreferencesKey("fullName")
        private val PHONENUMBER_KEY = stringPreferencesKey("phoneNumber")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val IS_LOGGEDIN_KEY = booleanPreferencesKey("isLoggedIn")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreferences(dataStore)
                INSTANCE= instance
                instance
            }
        }
    }
}
