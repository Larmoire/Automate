import automate.Automate
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AutomateTest {

    @Test
    fun testSmileyAutomate() {
        val smileyAutomate = Automate("smiley")
        assertTrue(smileyAutomate.accepte(":)"))
        assertTrue(smileyAutomate.accepte(":-)"))
        assertTrue(smileyAutomate.accepte(":("))
        assertTrue(smileyAutomate.accepte(";-)"))
        assertTrue(smileyAutomate.accepte(":=)"))
        assertTrue(smileyAutomate.accepte("]-)"))

        assertFalse(smileyAutomate.accepte(":-("))
        assertFalse(smileyAutomate.accepte("")) // test avec une chaîne vide
        assertFalse(smileyAutomate.accepte("abc")) // test avec une chaîne non valide
    }

    @Test
    fun testHeureAutomate() {
        val heureAutomate = Automate("heure")
        assertTrue(heureAutomate.accepte("23:59"))
        assertTrue(heureAutomate.accepte("00:00"))
        assertTrue(heureAutomate.accepte("12:00"))
        assertTrue(heureAutomate.accepte("01:00"))
        assertTrue(heureAutomate.accepte("13:00"))
        assertTrue(heureAutomate.accepte("23:00"))
        assertTrue(heureAutomate.accepte("00:59"))
        assertTrue(heureAutomate.accepte("00:01"))

        assertFalse(heureAutomate.accepte("24:01"))
        assertFalse(heureAutomate.accepte("24:00"))
        assertFalse(heureAutomate.accepte("25:00")) // test avec une heure non valide
        assertFalse(heureAutomate.accepte("23:60")) // test avec une minute non valide
        assertFalse(heureAutomate.accepte("23:")) // test avec une entrée non valide (manque la minute)
        assertFalse(heureAutomate.accepte(":59")) // test avec une entrée non valide (manque l'heure)
    }

    @Test
    fun testDateAutomate() {
        val dateAutomate = Automate("date")
        assertTrue(dateAutomate.accepte("31/12/2023"))
        assertTrue(dateAutomate.accepte("01/01/2023"))
        assertTrue(dateAutomate.accepte("28/02/2024"))
        assertTrue(dateAutomate.accepte("31/08/2024"))
        assertTrue(dateAutomate.accepte("30/04/2024"))

        assertFalse(dateAutomate.accepte("29/02/2024"))
        assertFalse(dateAutomate.accepte("32/12/2023"))
        assertFalse(dateAutomate.accepte("31/02/2023")) // test avec une date non valide (février avec 31 jours)
        assertFalse(dateAutomate.accepte("00/12/2023")) // test avec une date non valide (jour 00)
    }

    @Test
    fun testPolynomeAutomate() {
        val polynomeAutomate = Automate("polynome")
        assertTrue(polynomeAutomate.accepte("3X**2-6X-9"))
        assertFalse(polynomeAutomate.accepte("2X**2-3X+1"))
        assertFalse(polynomeAutomate.accepte("3X**2--6X-9")) // test avec une entrée non valide (deux signes moins consécutifs)
        assertFalse(polynomeAutomate.accepte("3X**2-6X-")) // test avec une entrée non valide (manque le dernier nombre)
    }
}