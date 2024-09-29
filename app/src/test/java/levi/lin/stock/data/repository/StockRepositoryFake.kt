package levi.lin.stock.data.repository

import levi.lin.stock.domain.model.CompanyInfo
import levi.lin.stock.domain.model.CompanyListing
import levi.lin.stock.domain.model.IntradayInfo
import levi.lin.stock.domain.repository.StockRepository
import levi.lin.stock.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDateTime

class StockRepositoryFake: StockRepository {
    private var companyListingsToReturn = (1..10).map {
        CompanyListing(
            name = "name$it",
            symbol = "symbol$it",
            exchange = "exchange$it"
        )
    }
    var intradayInfosToReturn = (1..10).map {
        IntradayInfo(
            date = LocalDateTime.now(),
            close = it.toDouble()
        )
    }
    var companyInfoToReturn = CompanyInfo(
        symbol = "symbol",
        description = "description",
        name = "name",
        country = "country",
        industry = "industry"
    )

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Success(companyListingsToReturn))
        }
    }

    override suspend fun getIntradayInfo(symbol: String): Resource<List<IntradayInfo>> {
        return Resource.Success(intradayInfosToReturn)
    }

    override suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo> {
        return Resource.Success(companyInfoToReturn)
    }
}