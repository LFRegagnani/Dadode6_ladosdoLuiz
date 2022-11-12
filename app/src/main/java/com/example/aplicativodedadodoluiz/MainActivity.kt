package com.example.aplicativodedadodoluiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.aplicativodedadodoluiz.luiz.Luiz

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //primeira coisa foi criar uma variavel para vincular o botão
        val rolarDado: Button = findViewById(R.id.botaoJogar)

        //depois deu o comando para o click no botão ativasse a função "rolar"
        rolarDado.setOnClickListener { rolar(); rolar2() }

    }



    //a função rolar é responsável por definir varias coisas
    private fun rolar() {
        //aqui vai o numero maximo de lados do dado
        val dado = Dado(6)
        //aqui é só a definição de uma variavel que vai armazenar o ato de pedir para o dado rolar
        val diceRoll = dado.roll()
        //aqui em baixo ele manda o resultado do dado para o local do resultado
        val resultTextView: TextView = findViewById(R.id.localResultado)
        //aqui ele transforma o resultado do dado que seria Int em String antes de mandar pro botão
        resultTextView.text = "O resultado do 1ª dado é $diceRoll"
    }

    private fun rolar2() {
        val dado2 = Dado(20)
        val diceRoll2 = dado2.roll()
        val resultTextView2: TextView = findViewById(R.id.localResultado2)
        //AQUI ANTES TINHA UM RECURSO CHAMADO diceRoll2.toString PARA TRANSFORMAR O RESULTADO DA FUNÇÃO EM STRING.
        //POR QUE O SISTEMA ME OFERECEU SUBSTITUILO POR UM SIMPLES SINAL DE DOLAR NO MEIO DE OUTRA STRING????
        resultTextView2.text = diceRoll2.toString()

    }
}

//essa classe representa o dado em sí mas exige que um numero seja declarado para ser o numSides
class Dado(private val numSides: Int) {
    //essa função representa o dado rolando, o Int significa que o resultado vem em forma de número
    fun roll(): Int {
//aqui é onde a magica acontece. A função pega o numSides e seleciona o numero aleatorio de 1 até ele.
        return (1..numSides).random()
    }

}

