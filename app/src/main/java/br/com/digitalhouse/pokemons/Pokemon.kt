package br.com.digitalhouse.pokemons

class Pokemon(val id: Int, var nome: String, var img: Int, var cor: Int, var tipos: ArrayList<String>, var fraquezas: ArrayList<String>) {

    override fun toString(): String {
        return "Pokemon(id=$id, nome='$nome', img=$img, cor=$cor, tipos=$tipos, fraquezas=$fraquezas)"
    }
}