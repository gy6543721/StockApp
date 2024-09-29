package levi.lin.stock.domain.repository

import levi.lin.stock.domain.model.CompanyInfo
import levi.lin.stock.domain.model.CompanyListing
import levi.lin.stock.domain.model.IntradayInfo
import levi.lin.stock.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}