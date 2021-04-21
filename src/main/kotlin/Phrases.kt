import java.lang.RuntimeException

class Phrases {
    private val phrasesMap = HashMap<Pair<String, Language>, String>()

    fun get(key: String, language: Language): String {
        if (!phrasesMap.containsKey(Pair(key, language))) {
            throw RuntimeException("invalid key")
        }
        return phrasesMap[Pair(key, language)]!!
    }

    private fun addPhrase(key: String, language: Language, string: String) {
        phrasesMap[Pair(key, language)] = string
    }

    fun fill() {
        var language = Language.ENGLISH
        addPhrase("thanks", language, "Thank you for staying with JetBrains.")
        addPhrase(
            "personal, not able to charge", language, "Unfortunately, we were not able to charge " +
                    "{} for your {} subscription to {}."
        )
        addPhrase("Please make sure", language, "Please make sure that your PayPal account is not closed or deleted. ")
        addPhrase(
            "PayPal account should be active", language, "The credit card connected to your PayPal account " +
                    "should be active. "
        )
        addPhrase("paypal fail", language, "Common reasons for failed card payments include:")
        addPhrase("paypal, card is not confirmed", language, "- The card is not confirmed in your PayPal account;")
        addPhrase(
            "paypal, card details incorrectly", language, "- The card details " +
                    "(Number, Expiration date, CVC, Billing address) are incomplete or were entered incorrectly;"
        )
        addPhrase("paypal, card is expired", language, "- The card is expired; or")
        addPhrase("paypal, payment limit on the card", language, "- Insufficient funds or payment limit on the card.")
        addPhrase(
            "to ensure uninterrupted access", language, "To ensure uninterrupted access to your {}, " +
                    "please follow the link and renew your {} "
        )
        addPhrase("till", language, " till {}")
        addPhrase(
            "You can double-check and try",
            language,
            "You can double-check and try your existing payment card again, " +
                    "use another card, or choose a different payment method."
        )
        addPhrase("credit card fail", language, "Common reasons for failed credit card payments include:")
        addPhrase(
            "credit, card is expired",
            language,
            "- The card is expired, or the expiration date was entered incorrectly;"
        )
        addPhrase("credit, insufficient funds", language, "- Insufficient funds or payment limit on the card; or")
        addPhrase(
            "credit, card is not set up for international transactions", language, "- The card is not set up for " +
                    "international/overseas transactions, or the issuing bank has rejected the transaction."
        )
        addPhrase(
            "organization, not able to charge", language, "Unfortunately, we were not able to charge {} for your {} " +
                    "as part of Subscription Pack {} for the next {}: "
        )
        addPhrase("monthly", language, "monthly")
        addPhrase("annual", language, "annual")
        addPhrase("other", language, "")

        addPhrase("subscription, first", language, "subscription")
        addPhrase("subscriptions, first", language, "subscriptions")
        addPhrase("subscription, second", language, "subscription")
        addPhrase("subscriptions, second", language, "subscriptions")

        addPhrase("month", language, "month")
        addPhrase("year", language, "year")
        addPhrase("period", language, "period")

        language = Language.RUSSIAN
        addPhrase("thanks", language, "Спасибо, что остаетесь с JetBrains.")
        addPhrase(
            "personal, not able to charge",
            language,
            "К сожалению, мы не смогли снять плату с карты {} за {} подписку на {}."
        )
        addPhrase("Please make sure", language, "Убедитесь, что ваша учетная запись PayPal не закрыта и не удалена. ")
        addPhrase(
            "PayPal account should be active",
            language,
            "Кредитная карта, подключенная к вашей учетной записи PayPal, " +
                    "должна быть активной."
        )
        addPhrase("paypal fail", language, "Распространенные причины неудачных платежей по карте:")
        addPhrase("paypal, card is not confirmed", language, "- Карта не подтверждена в вашем аккаунте PayPal;")
        addPhrase(
            "paypal, card details incorrectly", language, "- Данные карты (номер, срок действия, CVC, платежный " +
                    "адрес) неполны или были введены неверно.;"
        )
        addPhrase("paypal, card is expired", language, "- Срок действия карты истек; или же")
        addPhrase(
            "paypal, payment limit on the card",
            language,
            "- Недостаточно средств или платежного лимита на карте."
        )
        addPhrase(
            "to ensure uninterrupted access",
            language,
            "Чтобы обеспечить непрерывный доступ к вашей {}, перейдите по ссылке " +
                    "и обновите {} "
        )
        addPhrase("till", language, " до {}")
        addPhrase(
            "You can double-check and try",
            language,
            "Вы можете перепроверить и попробовать свою существующую платежную карту еще раз, использовать другую карту или выбрать " +
                    "другой способ оплаты."
        )
        addPhrase("credit card fail", language, "Распространенные причины неудачных платежей по кредитной карте:")
        addPhrase(
            "credit, card is expired",
            language,
            "- Срок действия карты истек, либо срок годности введен неверно;"
        )
        addPhrase(
            "credit, insufficient funds",
            language,
            "- Недостаточно средств или платежного лимита на карте; или же"
        )
        addPhrase(
            "credit, card is not set up for international transactions", language, "- Карта не предназначена для " +
                    "международных / зарубежных транзакций, или банк-эмитент отклонил транзакцию."
        )
        addPhrase(
            "organization, not able to charge",
            language,
            "К сожалению, мы не смогли снять плату с карты {} за ваши {} " +
                    "в рамках пакета подписки {} на следующий {}: "
        )
        addPhrase("monthly", language, "ежемесячную")
        addPhrase("annual", language, "ежегодную")
        addPhrase("other", language, "")

        addPhrase("subscription, first", language, "подписке")
        addPhrase("subscriptions, first", language, "подпискам")
        addPhrase("subscription, second", language, "подписку")
        addPhrase("subscriptions, second", language, "подписки")

        addPhrase("month", language, "месяц")
        addPhrase("year", language, "год")
        addPhrase("period", language, "период")

        language = Language.ITALIAN
        addPhrase("thanks", language, "Grazie per essere rimasto con JetBrains.")
        addPhrase(
            "personal, not able to charge",
            language,
            "Purtroppo non siamo stati in grado di addebitare la carta {} per l'abbonamento {} {}."
        )
        addPhrase("Please make sure", language, "Assicurati che il tuo conto PayPal non sia chiuso o cancellato. ")
        addPhrase(
            "PayPal account should be active",
            language,
            "La carta di credito collegata al tuo conto PayPal deve essere attiva."
        )
        addPhrase("paypal fail", language, "Motivi comuni per pagamenti con carta non riusciti:")
        addPhrase("paypal, card is not confirmed", language, "- La carta non è verificata nel tuo conto PayPal;")
        addPhrase(
            "paypal, card details incorrectly", language, "- I dettagli della carta (numero, data di scadenza, CVC, " +
                    "indirizzo di fatturazione) sono incompleti o sono stati inseriti in modo errato.;"
        )
        addPhrase("paypal, card is expired", language, "- La carta è scaduta; o")
        addPhrase(
            "paypal, payment limit on the card",
            language,
            "- Fondi o limite di pagamento insufficienti sulla carta."
        )
        addPhrase(
            "to ensure uninterrupted access", language, "Per garantire un accesso ininterrotto al tuo {}, segui il " +
                    "collegamento e rinnova il tuo {} "
        )
        addPhrase("till", language, " fino al {}")
        addPhrase(
            "You can double-check and try",
            language,
            "Puoi ricontrollare e provare di nuovo la tua carta di pagamento esistente, utilizzare una carta diversa o " +
                    "scegliere un metodo di pagamento diverso."
        )
        addPhrase("credit card fail", language, "Cause comuni di pagamenti con carta di credito non riusciti:")
        addPhrase(
            "credit, card is expired",
            language,
            "- La carta è scaduta o la data di scadenza non è stata inserita correttamente;"
        )
        addPhrase("credit, insufficient funds", language, "- Fondi o limite di pagamento insufficienti sulla carta; o")
        addPhrase(
            "credit, card is not set up for international transactions", language, "- La carta non è destinata a " +
                    "transazioni internazionali / estere o la banca emittente ha rifiutato la transazione."
        )
        addPhrase(
            "organization, not able to charge", language, "Sfortunatamente, non siamo stati in grado di addebitare " +
                    "la carta {} per i tuoi abbonamenti all'interno del pacchetto di abbonamento {} per il {} successivo: {}"
        )
        addPhrase("monthly", language, "mensile")
        addPhrase("annual", language, "annuale")
        addPhrase("other", language, "")

        addPhrase("subscription, first", language, "sottoscrizione")
        addPhrase("subscriptions, first", language, "abbonamenti")
        addPhrase("subscription, second", language, "sottoscrizione")
        addPhrase("subscriptions, second", language, "abbonamenti")

        addPhrase("month", language, "mese")
        addPhrase("year", language, "anno")
        addPhrase("period", language, "periodo")
    }

    fun fillPattern(key: String, listWorld: List<String>, language: Language): String {
        val currStr = get(key, language)
        var ans = ""
        var listInd = 0
        var i = 0;
        while (i < currStr.length) {
            if (currStr[i] != '{') {
                ans += currStr[i]
                i++
                continue
            }
            if (listInd >= listWorld.size) {
                throw RuntimeException("Not enough arguments passed")
            }
            ans += listWorld[listInd]
            i += 2
            listInd++
        }
        if (listInd < listWorld.size) {
            throw RuntimeException("Too much arguments passed")
        }
        return ans
    }
}
