package com.task.nutrition.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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