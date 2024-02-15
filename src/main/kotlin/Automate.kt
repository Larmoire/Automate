package automate

class Automate(type: String) {
    // Déclaration des variables d'état, d'alphabets, d'état initial, d'états finaux et de la fonction de transition
    private lateinit var s: MutableList<Etat>
    private lateinit var a: MutableList<Char>
    private lateinit var s0: Etat
    private lateinit var sf: MutableList<Etat>
    private lateinit var delta: HashMap<Pair<Etat, Char>, Etat>

    init {
        when (type) {
            "smiley" -> {

                // Définition des états pour l'automate "smiley"
                val e1 = Etat("1", false)
                val e2 = Etat("2", false)
                val e3 = Etat("3", false)
                val e4 = Etat("4", true)
                val e5 = Etat("5", false)

                // Définition des transitions pour l'automate "smiley"
                e1.ajouterTransition(';', e2) // Si on voit un ';' à partir de l'état initial, on passe à l'état 2
                e1.ajouterTransition(']', e2) // Si on voit un ']' à partir de l'état initial, on passe à l'état 2
                e1.ajouterTransition(':', e5) // Si on voit un ':' à partir de l'état initial, on passe à l'état 5
                e2.ajouterTransition('-', e3) // Si on voit un '-' à partir de l'état 2, on passe à l'état 3
                e3.ajouterTransition(')', e4) // Si on voit un ')' à partir de l'état 3, on passe à l'état 4 (final)
                e5.ajouterTransition('-', e3) // Si on voit un '-' à partir de l'état 5, on passe à l'état 3
                e5.ajouterTransition('=', e3) // Si on voit un '=' à partir de l'état 5, on passe à l'état 3
                e5.ajouterTransition(')', e4) // Si on voit un ')' à partir de l'état 5, on passe à l'état 4 (final)
                e5.ajouterTransition('(', e4) // Si on voit un '(' à partir de l'état 5, on passe à l'état 4 (final)

                // Définition de l'ensemble des états, de l'alphabet, de l'état initial, des états finaux et de la fonction de transition pour l'automate "smiley"
                s = mutableListOf(e1, e2, e3, e4, e5)
                a = mutableListOf(';', ']', ':', '-', '=', '(', ')')
                s0 = e1
                sf = mutableListOf(e4)
                delta = setDelta()
            }

            "heure" -> {
                // Définition des états pour l'automate "heure"
                val etat7 = Etat("E7", true)
                val etat6 = Etat("E6")
                val etat5 = Etat("E5")
                val etat4 = Etat("E4")
                val etat3 = Etat("E3")
                val etat2 = Etat("E2")
                val etat1 = Etat("E1")

                // Définition des transitions pour l'automate "heure"
                etat1.ajouterStringTransition("01", etat3) // Le cas le plus simple
                etat1.ajouterTransition('2', etat2) // On verifie qu'il n'est pas plus de 24h

                etat2.ajouterStringTransition("0123", etat4) // Il n'est pas plus de 24h on passe aux minutes

                etat3.ajouterStringTransition("0123456789", etat4) // Le cas le plus simple

                etat4.ajouterTransition(':', etat5) // La transition vers les minutes

                etat5.ajouterStringTransition("012345", etat6) // On verifie qu'il n'y est pas plus de 60minutes

                etat6.ajouterStringTransition("0123456789", etat7) // Il n'y a pas plus de 60minutes

                // Définition de l'ensemble des états, de l'alphabet, de l'état initial, des états finaux et de la fonction de transition pour l'automate "heure"
                s = mutableListOf(etat1, etat2, etat3, etat4, etat5, etat6, etat7)
                a = "1234567890:".toCharArray().toMutableList()
                s0 = etat1
                sf = mutableListOf(etat7)
                delta = setDelta()
            }

            "date" -> {
                // Définition des états pour l'automate "date"
                val etat29 = Etat("E29", true)
                val etat28 = Etat("E28")
                val etat27 = Etat("E27")
                val etat26 = Etat("E26")
                val etat25 = Etat("E25")
                val etat24 = Etat("E24")
                val etat21 = Etat("E21")
                val etat23 = Etat("E23")
                val etat22 = Etat("E22")
                val etat20 = Etat("E20")
                val etat19 = Etat("E19")
                val etat18 = Etat("E18")
                val etat17 = Etat("E17")
                val etat16 = Etat("E16")
                val etat15 = Etat("E15")
                val etat14 = Etat("E14")
                val etat13 = Etat("E13")
                val etat12 = Etat("E12")
                val etat11 = Etat("E11")
                val etat10 = Etat("E10")
                val etat9 = Etat("E9")
                val etat8 = Etat("E8")
                val etat7 = Etat("E7")
                val etat6 = Etat("E6")
                val etat5 = Etat("E5")
                val etat4 = Etat("E4")
                val etat3 = Etat("E3")
                val etat2 = Etat("E2")
                val etat1 = Etat("E1") // Etat defaut

                // Définition des transitions pour l'automate "date"
                etat1.ajouterTransition('0', etat2) // Ici il faut faire attention au jour 00 qui n'existe pas
                etat1.ajouterTransition('1', etat3) // Ici c'est le cas parfait (le plus rapide à vérifier)
                etat1.ajouterTransition('2', etat4) // Ici on doit juste faire attention au mois de février
                etat1.ajouterTransition('3', etat5) // Ici on doit verifier si le jour existe en fonction du mois

                etat2.ajouterStringTransition("123456789", etat6) // On exclue le jour 00

                etat3.ajouterStringTransition(
                    "0123456789",
                    etat6
                ) // Cas parfait on verifie juste que ce soit bien un chiffre

                etat4.ajouterStringTransition(
                    "012345678",
                    etat6
                ) // Le jour est bon meme si on est en fevrier on peut continuer
                etat4.ajouterTransition('9', etat7) // On exclue le mois de fevrier

                etat5.ajouterTransition('0', etat8) // On est le jour 30 il faut verifier le mois
                etat5.ajouterTransition('1', etat9) // On est le jour 31 il faut verifier le mois

                etat6.ajouterTransition('/', etat10) // Transition pour aller aux mois
                etat7.ajouterTransition('/', etat11) // Transition pour aller aux mois
                etat8.ajouterTransition('/', etat12) // Transition pour aller aux mois
                etat9.ajouterTransition('/', etat13) // Transition pour aller aux mois

                etat10.ajouterTransition('0', etat14) // Il faut verifier qu'on ne soit pas le mois 00 qui n'existe pas
                etat10.ajouterTransition('1', etat15) // Il faut verifier que le mois ne soit pas > à 12

                etat11.ajouterTransition(
                    '0',
                    etat16
                ) // On verifie juste qu'on ne soit pas le mois 00 ou en fevrier (02)
                etat11.ajouterTransition('1', etat15) // On est pas en fevrier on peut rejoindre l'etat15

                etat12.ajouterTransition('0', etat17) // On verifie qu'on est en 04, 06, 09
                etat12.ajouterTransition('1', etat18) // On verifie qu'on est en 11

                etat13.ajouterTransition('0', etat19) // On verifie qu'on est en 01, 03, 05, 07, 08
                etat13.ajouterTransition('1', etat20) // On verifie qu'on est en 10 ou en 12

                etat14.ajouterStringTransition("123456789", etat21) // Il faut juste verifier l'année maintenant
                etat15.ajouterStringTransition("012", etat21) // Il faut juste verifier l'année maintenant
                etat16.ajouterStringTransition("13456789", etat21) // Il faut juste verifier l'année maintenant
                etat17.ajouterStringTransition("469", etat21) // Il faut juste verifier l'année maintenant
                etat18.ajouterTransition('1', etat21) // Il faut juste verifier l'année maintenant
                etat19.ajouterStringTransition("13578", etat21) // Il faut juste verifier l'année maintenant
                etat20.ajouterStringTransition("02", etat21) // Il faut juste verifier l'année maintenant

                etat21.ajouterTransition('/', etat22) // Transition pour aller aux années

                etat22.ajouterStringTransition("123456789", etat23) // On a vérifié le millénaire
                etat22.ajouterTransition('0', etat24) // On fait attention a l'année 0000

                etat23.ajouterStringTransition("0123456879", etat25) // On a vérifié le siècle

                etat24.ajouterStringTransition("123456879", etat25) // On a vérifié le siècle et on est pas en 0000
                etat24.ajouterTransition('0', etat26) // On a vérifié le siècle mais on est peut être en 0000

                etat25.ajouterStringTransition("0123456789", etat27)// On a vérifié la décenie

                etat26.ajouterStringTransition("123456789", etat27) // On a vérifié la décenie et on est pas en 0000
                etat26.ajouterTransition('0', etat28) // On a vérifié la décenie et on est peut être en 0000

                etat27.ajouterStringTransition("0123456789", etat29) // On a vérifié l'année
                etat28.ajouterStringTransition("123456789", etat29) // On a vérifié l'année

                // Définition de l'ensemble des états, de l'alphabet, de l'état initial, des états finaux et de la fonction de transition pour l'automate "date"
                s = mutableListOf(
                    etat1,
                    etat2,
                    etat3,
                    etat4,
                    etat5,
                    etat6,
                    etat7,
                    etat8,
                    etat9,
                    etat10,
                    etat11,
                    etat12,
                    etat13,
                    etat14,
                    etat15,
                    etat16,
                    etat17,
                    etat18,
                    etat19,
                    etat20,
                    etat21,
                    etat22,
                    etat23,
                    etat24,
                    etat25,
                    etat26,
                    etat27,
                    etat28,
                    etat29
                )
                a = "0123456789/".toCharArray().toMutableList()
                s0 = etat1
                sf = mutableListOf(etat29)
                delta = setDelta()
            }


            "polynome" -> {
                // Définition des états pour l'automate "polynome"
                val etat19 = Etat("E19", true)
                val etat18 = Etat("E18")
                val etat17 = Etat("E17")
                val etat16 = Etat("E16")
                val etat15 = Etat("E15")
                val etat14 = Etat("E14")
                val etat13 = Etat("E13")
                val etat12 = Etat("E12")
                val etat11 = Etat("E11")
                val etat10 = Etat("E10")
                val etat9 = Etat("E9")
                val etat8 = Etat("E8")
                val etat7 = Etat("E7")
                val etat6 = Etat("E6")
                val etat5 = Etat("E5")
                val etat4 = Etat("E4")
                val etat3 = Etat("E3")
                val etat2 = Etat("E2")
                val etat1 = Etat("E1") // Etat defaut


                // Définition des transitions pour l'automate "polynome"
                etat1.ajouterTransition('0', etat1) // Un nombre peut commencer avec une infinité de 0 devant
                etat1.ajouterTransition('1', etat2) // Le cas de la dizaine et du 1
                etat1.ajouterTransition('2', etat3) // Le cas de la dizaine entre 19 et 25 et de 2
                etat1.ajouterStringTransition("345679", etat4) // Si le nombre est inférieur à 10

                etat2.ajouterStringTransition("0123456789", etat4) // On rajoute une unité
                etat2.ajouterTransition('X', etat5) // Ou on passe directement a la puissance

                etat3.ajouterStringTransition("012345", etat4) // On rajoute une unité (entre 19 et 25)
                etat3.ajouterTransition('X', etat5) // Ou on passe directement a la puissance

                etat4.ajouterTransition('X', etat5) // On passe a la puissance

                etat5.ajouterTransition('*', etat6) // le *
                etat6.ajouterTransition('*', etat7) // le **

                etat7.ajouterTransition('2', etat8) // le 2

                etat8.ajouterStringTransition("+-", etat9) // L'operateur

                // Encore le choix d'un numéro entre 1 et 25
                etat9.ajouterTransition('0', etat10)
                etat9.ajouterTransition('1', etat11)
                etat9.ajouterTransition('2', etat12)
                etat9.ajouterStringTransition("3456789", etat13)

                etat10.ajouterTransition('0', etat10)
                etat10.ajouterTransition('1', etat11)
                etat10.ajouterTransition('2', etat12)
                etat10.ajouterStringTransition("3456789", etat13)

                etat11.ajouterTransition('X', etat14) // On passe directement a la puissance
                etat11.ajouterStringTransition("0123456789", etat13) // Ou on rajoute une unité

                etat12.ajouterTransition('X', etat14) // On passe directement a la puissance
                etat12.ajouterStringTransition("012345", etat13) // Ou on rajoute une unité (entre 19 et 25)

                etat13.ajouterTransition('X', etat14) // On passe directement a la puissance

                etat14.ajouterStringTransition("+-", etat15) // L'operateur

                // Encore le choix d'un numéro entre 1 et 25
                etat15.ajouterTransition('0', etat16)
                etat15.ajouterTransition('1', etat17)
                etat15.ajouterTransition('2', etat18)
                etat15.ajouterStringTransition("3456789", etat19)

                etat16.ajouterTransition('0', etat16)
                etat16.ajouterTransition('1', etat17)
                etat16.ajouterTransition('2', etat18)
                etat16.ajouterStringTransition("3456789", etat19)

                etat17.ajouterStringTransition("0123456789", etat19) // Ou on rajoute une unité

                etat17.ajouterStringTransition("012345", etat19) // Ou on rajoute une unité (entre 19 et 25)

                s = mutableListOf(
                    etat1,
                    etat2,
                    etat3,
                    etat4,
                    etat5,
                    etat6,
                    etat7,
                    etat8,
                    etat9,
                    etat10,
                    etat11,
                    etat12,
                    etat13,
                    etat14,
                    etat15,
                    etat16,
                    etat17,
                    etat18,
                    etat19,
                )
                // On rajoute la possibilité de mettre des espaces
                for (etat in s) {
                    etat.ajouterTransition(' ', etat)
                }

                // Définition de l'ensemble des états, de l'alphabet, de l'état initial, des états finaux et de la fonction de transition pour l'automate "polynome"
                a = "0123456789 X*+-".toCharArray().toMutableList()
                s0 = etat1
                sf = mutableListOf(etat19)
                delta = setDelta()
            }
        }
    }

    // Méthode pour définir la fonction de transition
    private fun setDelta(): HashMap<Pair<Etat, Char>, Etat> {
        val sortie = hashMapOf<Pair<Etat, Char>, Etat>()
        for (etat in s) {
            for (transitions in etat.getTransitions()) {
                sortie[Pair(etat, transitions.key)] = transitions.value
            }
        }
        return sortie
    }

    // Méthode pour obtenir l'alphabet de l'automate
    fun getAlpha() = a

    // Méthode pour vérifier si une chaîne est acceptée par l'automate
    fun accepte(chaine: String): Boolean {
        var etatCourant = s0
        var index = 0
        val etatErreur = Etat("erreur", false)
        while (index < chaine.length && etatCourant != etatErreur && !etatCourant.estFinal) {
            val caractere = chaine[index]
//            if(etatCourant.getTransitions()[caractere]==null){
//                println(etatCourant.nom)
//            }
            etatCourant = etatCourant.getTransitions()[caractere] ?: etatErreur

            index++
        }
//        if(etatCourant==etatErreur){
//            println("Erreur")
//        }
        return etatCourant.estFinal
    }
}