package br.com.digitalhouse.pokemons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.card_pokemon.view.*
import java.lang.StringBuilder

class PokemonAdapter(private val context: Context, private val listPokemons: ArrayList<Pokemon>): PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.card_pokemon, container, false)
        val pokemon = listPokemons[position]

        view.llPokemon.setBackgroundResource(pokemon.cor)
        view.ivImgPokemon.setImageResource(pokemon.img)
        view.tvNomePokemon.text = pokemon.nome

        container.addView(view)


        //Toast.makeText(context, "Tipo: $tipos\nFraquezas: $fraquezas", Toast.LENGTH_LONG).show()

        return view
    }

    override fun getCount() = listPokemons.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}