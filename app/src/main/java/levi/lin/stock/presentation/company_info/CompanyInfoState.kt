package levi.lin.stock.presentation.company_info

import levi.lin.stock.domain.model.CompanyInfo
import levi.lin.stock.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
