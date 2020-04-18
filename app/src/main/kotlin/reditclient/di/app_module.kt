package reditclient.di

import com.oleeja.reditclient.data.source.storage.RedditDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataSourceModule = module {
    single { RedditDatabase.getInstance(androidContext()).redditTopDao() }
}