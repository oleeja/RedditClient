package reditclient.top

import data.repository.TopRedditRepositoryImpl
import domain.interactor.TopRedditInteractor
import domain.repository.TopRedditRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val topRedditViewModule = module{
    scope(named<TopRedditFragment>()){
        viewModel { TopRedditViewModel(get()) }
    }
}

val topRedditInteractorModule = module {
    scope(named<TopRedditFragment>()){
        scoped { TopRedditInteractor(get()) }
    }
}

val topRedditRepositoryModule = module {
    scope(named<TopRedditFragment>()){
        scoped<TopRedditRepository> { TopRedditRepositoryImpl(get(), get()) }
    }
}