package com.kk.hiltsample.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataPref @Inject constructor(@ApplicationContext context: Context) {
    private val  appCon = context.applicationContext
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "hiltMvvm")

    suspend fun saveVal(key: String, value: String){
        val dataStoreKey =  stringPreferencesKey(key)
        appCon.dataStore.edit {
            preferences->  preferences[dataStoreKey] = value
        }
    }

    suspend fun readVal(key: String): Flow<String> {
        val dataStoreKey =  stringPreferencesKey(key)

        val readValue: Flow<String> =  appCon.dataStore.data
            .catch { if(this is Exception){
                emit(emptyPreferences())
            } }.map {
                    preferences->  preferences[dataStoreKey]?:""
            }
        return readValue
    }


}