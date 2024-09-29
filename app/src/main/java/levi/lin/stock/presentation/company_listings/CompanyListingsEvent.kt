package levi.lin.stock.presentation.company_listings

sealed class CompanyListingsEvent {
    data object Refresh: CompanyListingsEvent()
    data class OnSearchQueryChange(val query: String): CompanyListingsEvent()
}
