package br.com.digitalhouse.pokemons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.SCROLL_STATE_DRAGGING
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var listPokemon: ArrayList<Pokemon>
    lateinit var adapter: PokemonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listPokemon = getPokemons()
        adapter = PokemonAdapter(this, getPokemons())

        vpPokemon.adapter = adapter

        vpPokemon.setPadding(0, 100, 0, 100)

        lateinit var toast: Toast
        vpPokemon.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                toast = Toast.makeText(this@MainActivity, formatPokemon(listPokemon[position]), Toast.LENGTH_SHORT)
                toast.show()
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
                if(state == SCROLL_STATE_DRAGGING)
                    toast.cancel()
            }

        })
    }

    private fun formatPokemon(pokemon: Pokemon): String {
        lateinit var tipos: String
        lateinit var fraquezas: String

        val stringBuilder = StringBuilder()
        var cont: Int = pokemon.tipos.size

        for(num in 0 until cont){
            stringBuilder.append(pokemon.tipos[num])
            when(num+1 != cont){
                true -> stringBuilder.append(", ")
            }
        }
        tipos = stringBuilder.toString()

        stringBuilder.clear()

        cont = pokemon.fraquezas.size
        for(num in 0 until cont){
            stringBuilder.append(pokemon.fraquezas[num])
            when(num+1 != cont){
                true -> stringBuilder.append(", ")
            }
        }

        fraquezas = stringBuilder.toString()

        stringBuilder.clear()
        return "Tipos: $tipos\nFraquezas: $fraquezas"
    }

    private fun getPokemons(): ArrayList<Pokemon> {
        return arrayListOf(
            Pokemon(0, "Charmander", R.drawable.charmander, R.color.fogo, arrayListOf("Fogo"), arrayListOf("Água", "Terra", "Rocha")),
            Pokemon(1, "Squirtle", R.drawable.squirtle, R.color.voador, arrayListOf("Água"), arrayListOf("Grama", "Elétrico")),
            Pokemon(2, "Butterfree", R.drawable.butterfree, R.color.voador, arrayListOf("Inseto", "Voador"), arrayListOf("Fogo", "Elétrico", "Rocha", "Gelo")),
            Pokemon(3, "Pidgey", R.drawable.pidgey, R.color.voador, arrayListOf("Normal", "Voador"), arrayListOf("Elétrico", "Rocha", "Gelo")),
            Pokemon(4, "Bulbasaur", R.drawable.bulbasaur, R.color.planta, arrayListOf("Planta", "Venenoso"), arrayListOf("Fogo", "Psíquico", "Gelo"))
        )
    }
}