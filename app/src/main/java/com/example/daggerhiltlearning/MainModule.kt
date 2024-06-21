package com.example.daggerhiltlearning

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun providePerson(personCondtion : PersonCondition) : Person{
        return Person(personCondtion)
    }

    @Provides
    fun providePersonCondition() : PersonCondition{
        return PersonCondition()
    }

}