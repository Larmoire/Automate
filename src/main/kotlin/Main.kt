package automate
fun main() {

    while (true) {
        println("1. Smiley")
        println("2. HH:MM")
        println("3. JJ/MM/AAAA")
        println("4. Polynômes")
        println("99. Quitter")

        print("Votre choix (1-99) ? ")
        val choix = readlnOrNull()?.toIntOrNull()

        val automate: Automate? = when (choix) {
            1 -> Automate("smiley")
            2 -> Automate("heure")
            3 -> Automate("date")
            4-> Automate("polynome")
            99 -> break
            else -> null
        }

        if (automate != null) {
            print("Entrez une chaîne à analyser : ")
            val chaine = readlnOrNull() ?: ""

            assert(chaine.all { automate.getAlpha().contains(it) }) { "La chaîne contient des caractères non reconnus." }
            val resultat = automate.accepte(chaine)

            if (resultat) {
                println("La chaîne est acceptée par l'automate.")
            } else {
                println("La chaîne est rejetée par l'automate.")
            }
        } else {
            println("Choix invalide d'automate.")
        }
    }
}