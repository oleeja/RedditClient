package reditclient.di

import com.oleeja.reditclient.data.source.data.RedditListParametersProvider
import org.koin.dsl.module

val commonModule = module {

}

val dataSourceModule = module {
    single { RedditListParametersProvider() }
}