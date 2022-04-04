package com.transfergo.currencyconverter.domain

import com.transfergo.currencyconverter.domain.usecases.RatesUseCase
import com.transfergo.currencyconverter.domain.usecases.RatesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Singleton
    @Binds
    internal abstract fun bindRatesUseCase(ratesUseCaseImpl: RatesUseCaseImpl): RatesUseCase
}
