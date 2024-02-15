package automate

class Etat(val nom: String, var estFinal: Boolean = false) {
    private val transitions: HashMap<Char, Etat> = HashMap()
    fun ajouterTransition(action: Char, etatSuivant: Etat) {
        transitions[action] = etatSuivant
    }
    fun ajouterStringTransition(action: String, etatSuivant: Etat) {
        action.forEach { ajouterTransition(it, etatSuivant) }
    }
    fun getTransitions(): HashMap<Char, Etat> {
        return transitions
    }
}
