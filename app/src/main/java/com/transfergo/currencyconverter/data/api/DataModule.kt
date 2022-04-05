package com.transfergo.currencyconverter.data.api

import com.transfergo.currencyconverter.data.api.repositories.RatesRepositoryImpl
import com.transfergo.currencyconverter.domain.RatesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    internal abstract fun bindRatesRepository(ratesRepositoryImpl: RatesRepositoryImpl): RatesRepository
}
