import java.time.LocalDate

enum class CustomerType {
    PERSONAL, ORGANIZATION
}

enum class BillingPeriod {
    MONTHLY, ANNUAL, OTHER
}

enum class CardProvider {
    PAY_PAL, OTHER
}
enum class Language {
    RUSSIAN, ENGLISH, ITALIAN
}

data class Customer(
    val language: Language,
    val customerType: CustomerType,
)

data class FailedPaymentData(
    val cardDetails: String?,
    val customer: Customer,
    val items: List<OrderItem>,
    val subscriptionPack: SubscriptionPack,
    val paymentDeadline: LocalDate,
    val cardProvider: CardProvider
)

data class SubscriptionPack(
    val subPackRef: String?,
    val totalLicenses: Int,
    val billingPeriod: BillingPeriod
)

data class OrderItem(
    val productCode: String,
    val productName: String,
    val quantity: Int,
    val description: String
)
