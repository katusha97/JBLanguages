import kotlinx.html.html
import kotlinx.html.stream.appendHTML
import java.time.LocalDate

fun main() {
    /**
     * Modify FailedPaymentEmail so that it could accept a language to prepare a localized version of the markup.
     *
     * Support at least 3 languages - English, Russian and at least 1 language you want.
     * NB: We won't pay much attention on the correctness of the translations - you are free to use any translation service.
     */

    // You can provide any data as the parameter of FailedPaymentEmail to ensure the email was localized correctly
    val phrases = Phrases()
    phrases.fill()
    val personalEnglish = FailedPaymentEmail(provideFakedDataPersonalEnglish(), phrases)
    val personalRussian = FailedPaymentEmail(provideFakedDataPersonalRussian(), phrases)
    val personalItalian = FailedPaymentEmail(provideFakedDataPersonalItalian(), phrases)
    val organizationEnglish = FailedPaymentEmail(provideFakedDataOrganizationEnglish(), phrases)
    val organizationRussian= FailedPaymentEmail(provideFakedDataOrganizationRussian(), phrases)
    val organizationItalian = FailedPaymentEmail(provideFakedDataOrganizationItalian(), phrases)

    println(StringBuilder().appendHTML().html { personalEnglish.buildContent(this) })
    println(StringBuilder().appendHTML().html { personalRussian.buildContent(this) })
    println(StringBuilder().appendHTML().html { personalItalian.buildContent(this) })
    println("---------------------------------------------------------------------------------")
    println(StringBuilder().appendHTML().html { organizationEnglish.buildContent(this) })
    println(StringBuilder().appendHTML().html { organizationRussian.buildContent(this) })
    println(StringBuilder().appendHTML().html { organizationItalian.buildContent(this) })
}

private fun provideFakedDataPersonalEnglish() = FailedPaymentData(
    cardDetails = "VISA **** 1234",
    customer = Customer(Language.ENGLISH, CustomerType.PERSONAL),
    items = listOf(
        OrderItem(
            productCode = "ALL",
            productName = "All Product Pack",
            quantity = 1,
            description = "commercial annual subscription"
        )
    ),
    subscriptionPack = SubscriptionPack(
        subPackRef = "0011/ABCD",
        totalLicenses = 1,
        billingPeriod = BillingPeriod.ANNUAL
    ),
    cardProvider = CardProvider.PAY_PAL,
    paymentDeadline = LocalDate.now().plusDays(3)
)

private fun provideFakedDataPersonalRussian() = FailedPaymentData(
    cardDetails = "VISA **** 1234",
    customer = Customer(Language.RUSSIAN, CustomerType.PERSONAL),
    items = listOf(
        OrderItem(
            productCode = "ALL",
            productName = "Весь пакет продуктов",
            quantity = 1,
            description = "коммерческая годовая подписка"
        )
    ),
    subscriptionPack = SubscriptionPack(
        subPackRef = "0011/ABCD",
        totalLicenses = 1,
        billingPeriod = BillingPeriod.MONTHLY
    ),
    cardProvider = CardProvider.PAY_PAL,
    paymentDeadline = LocalDate.now().plusDays(3)
)

private fun provideFakedDataPersonalItalian() = FailedPaymentData(
    cardDetails = "VISA **** 1234",
    customer = Customer(Language.ITALIAN, CustomerType.PERSONAL),
    items = listOf(
        OrderItem(
            productCode = "ALL",
            productName = "Pacchetto di tutti i prodotti",
            quantity = 1,
            description = "abbonamento annuale commerciale"
        )
    ),
    subscriptionPack = SubscriptionPack(
        subPackRef = "0011/ABCD",
        totalLicenses = 1,
        billingPeriod = BillingPeriod.ANNUAL
    ),
    cardProvider = CardProvider.PAY_PAL,
    paymentDeadline = LocalDate.now().plusDays(3)
)

private fun provideFakedDataOrganizationEnglish() = FailedPaymentData(
    cardDetails = "VISA **** 1234",
    customer = Customer(Language.ENGLISH, CustomerType.ORGANIZATION),
    items = listOf(
        OrderItem(
            productCode = "ALL",
            productName = "All Product Pack",
            quantity = 3,
            description = "commercial monthly subscription"
        ),
        OrderItem(
            productCode = "AC",
            productName = "AppCode",
            quantity = 7,
            description = "commercial monthly subscription"
        )
    ),
    subscriptionPack = SubscriptionPack(
        subPackRef = "0011/ABCD",
        totalLicenses = 25,
        billingPeriod = BillingPeriod.MONTHLY
    ),
    cardProvider = CardProvider.OTHER,
    paymentDeadline = LocalDate.now().plusDays(3)
)

private fun provideFakedDataOrganizationRussian() = FailedPaymentData(
    cardDetails = "VISA **** 1234",
    customer = Customer(Language.RUSSIAN, CustomerType.ORGANIZATION),
    items = listOf(
        OrderItem(
            productCode = "ALL",
            productName = "Весь пакет продуктов",
            quantity = 3,
            description = "коммерческая месячная подписка"
        ),
        OrderItem(
            productCode = "AC",
            productName = "AppCode",
            quantity = 7,
            description = "коммерческая месячная подписка"
        )
    ),
    subscriptionPack = SubscriptionPack(
        subPackRef = "0011/ABCD",
        totalLicenses = 25,
        billingPeriod = BillingPeriod.MONTHLY
    ),
    cardProvider = CardProvider.OTHER,
    paymentDeadline = LocalDate.now().plusDays(3)
)

private fun provideFakedDataOrganizationItalian() = FailedPaymentData(
    cardDetails = "VISA **** 1234",
    customer = Customer(Language.ITALIAN, CustomerType.ORGANIZATION),
    items = listOf(
        OrderItem(
            productCode = "ALL",
            productName = "Pacchetto di tutti i prodotti",
            quantity = 3,
            description = "abbonamento annuale commerciale"
        ),
        OrderItem(
            productCode = "AC",
            productName = "AppCode",
            quantity = 7,
            description = "abbonamento mensile commerciale"
        )
    ),
    subscriptionPack = SubscriptionPack(
        subPackRef = "0011/ABCD",
        totalLicenses = 25,
        billingPeriod = BillingPeriod.MONTHLY
    ),
    cardProvider = CardProvider.OTHER,
    paymentDeadline = LocalDate.now().plusDays(3)
)