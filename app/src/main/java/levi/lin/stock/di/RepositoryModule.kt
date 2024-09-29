package levi.lin.stock.di

import levi.lin.stock.data.csv.CSVParser
import levi.lin.stock.data.csv.CompanyListingsParser
import levi.lin.stock.data.csv.IntradayInfoParser
import levi.lin.stock.data.repository.StockRepositoryImpl
import levi.lin.stock.domain.model.CompanyListing
import levi.lin.stock.domain.model.IntradayInfo
import levi.lin.stock.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}