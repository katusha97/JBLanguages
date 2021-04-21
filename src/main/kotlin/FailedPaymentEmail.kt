import kotlinx.html.*
import java.time.format.DateTimeFormatter
import java.util.*

class FailedPaymentEmail(
    private val data: FailedPaymentData, private val phrases: Phrases
) {

    fun buildContent(body: HTML) = with(body) {
        val language = data.customer.language
        body {
            p {
                +phrases.get("thanks", language)
            }
            p {
                if (data.customer.customerType == CustomerType.PERSONAL) {
                    +personMessage(phrases, language)
                } else {
                    +organizationMessage(phrases, language)
                    br()
                    data.items.forEach {
                        +"- ${it.quantity} x ${it.description}";br()
                    }
                }
            }

            if (data.cardProvider == CardProvider.PAY_PAL)
                paypalFailedPaymentReasons(phrases, language)
            else
                creditCardFailedPaymentReasons(phrases, language)

            p {
                +phrases.fillPattern(
                    "to ensure uninterrupted access", listOf(
                        phrases.get(
                            pluralize(
                                "subscription, first",
                                data.subscriptionPack.totalLicenses
                            ), language
                        ),
                        phrases.get(
                            pluralize(
                                "subscription, second",
                                data.subscriptionPack.totalLicenses
                            ), language
                        ),
                    ), language
                )
                a(href = "https://foo.bar/ex") {
                    +"manually"
                }
                +phrases.fillPattern(
                    "till",
                    listOf(DateTimeFormatter.ofPattern("MMM dd, YYYY", Locale.US).format(data.paymentDeadline)),
                    language
                )
                p {
                    +phrases.get("You can double-check and try", language)
                }
            }
        }
    }

    private fun personMessage(phrases: Phrases, language: Language): String {
        return phrases.fillPattern(
            "personal, not able to charge", listOf(data.cardDetails ?: "your card",
                phrases.get(data.subscriptionPack.billingPeriod.name.toLowerCase(), language),
                data.items.joinToString(
                    ", "
                ) { it.productName }), language
        )
    }

    private fun organizationMessage(phrases: Phrases, language: Language): String {
        return phrases.fillPattern(
            "organization, not able to charge", listOf(
                data.cardDetails ?: "your card",
                phrases.get(pluralize("subscription, second", data.items.sumBy { it.quantity }), language),
                data.subscriptionPack.subPackRef?.let { "#$it" }.orEmpty(),
                when (data.subscriptionPack.billingPeriod) {
                    BillingPeriod.MONTHLY -> phrases.get("month", language)
                    BillingPeriod.ANNUAL -> phrases.get("year", language)
                    else -> phrases.get("period", language)
                }
            ), language
        )
    }

    private fun FlowContent.creditCardFailedPaymentReasons(
        phrases: Phrases,
        language: Language
    ) {
        p {
            +phrases.get("credit card fail", language); br()
            +phrases.get("credit, card is expired", language); br()
            +phrases.get("credit, insufficient funds", language); br()
            +phrases.get("credit, card is not set up for international transactions", language); br()
        }
    }

    private fun FlowContent.paypalFailedPaymentReasons(
        phrases: Phrases,
        language: Language
    ) {
        p {
            +phrases.get("Please make sure", language)
            +phrases.get("PayPal account should be active", language)
            +phrases.get("paypal fail", language); br()
            +phrases.get("paypal, card is not confirmed", language); br()
            +phrases.get("paypal, card details incorrectly", language); br()
            +phrases.get("paypal, card is expired", language); br()
            +phrases.get("paypal, payment limit on the card", language)
        }
    }

    private fun pluralize(title: String, amount: Int): String {
        return when (amount) {
            1 -> title
            else -> title.replaceFirst("subscription", "subscriptions")
        }
    }
}