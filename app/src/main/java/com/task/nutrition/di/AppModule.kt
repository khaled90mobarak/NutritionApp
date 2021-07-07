package com.task.nutrition.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @ApplicationSCope
//    @Provides
//    @Singleton
//    fun provideApplicationSCope() = CoroutineScope(SupervisorJob())
}


//@Retention(AnnotationRetention.RUNTIME)
//@Qualifier
//annotation class ApplicationSCope