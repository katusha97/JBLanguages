import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PhrasesTest {

    private val phrases = Phrases()

    @Test
    fun get() {
        phrases.fill()
        assertEquals("Спасибо, что остаетесь с JetBrains.", phrases.get("thanks", Language.RUSSIAN))
        assertEquals("Unfortunately, we were not able to charge {} for your {} subscription to {}.",
            phrases.get("personal, not able to charge", Language.ENGLISH))
        assertEquals("- Fondi o limite di pagamento insufficienti sulla carta; o",
            phrases.get("credit, insufficient funds", Language.ITALIAN))
        assertThrows(java.lang.RuntimeException::class.java, {phrases.get("ololo", Language.RUSSIAN)})
    }

    @Test
    fun fillPattern() {
        phrases.fill()
        val list = listOf<String>("first", "second", "the third", "fourth")
        assertEquals("Sfortunatamente, non siamo stati in grado di addebitare " +
            "la carta first per i tuoi abbonamenti all'interno del pacchetto di abbonamento second per il the third successivo: fourth",
            phrases.fillPattern("organization, not able to charge", list, Language.ITALIAN)
        )
    }

    @Test
    fun fillPatternNotEnough() {
        phrases.fill()
        val list = listOf<String>("first", "second", "the third")
        assertThrows(RuntimeException::class.java) {
            phrases.fillPattern(
                "organization, not able to charge",
                list,
                Language.ITALIAN
            )
        }
    }


    @Test
    fun fillPatternTooMuch() {
        phrases.fill()
        val list = listOf<String>("first", "second", "the third", "fourth", "fifth", "...")
        assertThrows(RuntimeException::class.java) {
            phrases.fillPattern(
                "organization, not able to charge",
                list,
                Language.ITALIAN
            )
        }
    }


    @Test
    fun fillPatternNull() {
        phrases.fill()
        val list = listOf<String>("first", "second", "the third", "fourth", "fifth", "...")
        assertThrows(RuntimeException::class.java) {
            phrases.fillPattern(
                "organization, not able to charge",
                list,
                Language.ITALIAN
            )
        }
    }
}