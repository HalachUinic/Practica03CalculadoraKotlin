package com.example.practica03calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

//  Variables
private lateinit var btnSumar: Button;
private lateinit var btnRestar: Button;
private lateinit var btnMultiplicar: Button;
private lateinit var btnDividir: Button;
private lateinit var btnLimpiar: Button;
private lateinit var btnRegresar: Button;
private lateinit var lblUsuario: TextView;
private lateinit var lblResultado: TextView;
private lateinit var txt1: EditText;
private lateinit var txt2: EditText;

// Se delcara el objero calculadora
private var calculadora = Calculadora(0, 0);

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        iniciarComponentes();

        // Obtener los datos del mainActivity
        var datos = intent.extras;
        var usuario = datos!!.getString("usuario");
        lblUsuario.text = usuario.toString();

        btnSumar.setOnClickListener { btnSumar() }
        btnRestar.setOnClickListener { btnRestar() }
        btnMultiplicar.setOnClickListener { btnMultiplicar() }
        btnDividir.setOnClickListener { btnDividir() }

        btnLimpiar.setOnClickListener { btnLimpiar() }
        btnRegresar.setOnClickListener { btnRegresar() }
    }

    private fun iniciarComponentes() {
        // Botones
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        // Etiquetas
        lblUsuario = findViewById(R.id.lblUsuario);
        lblResultado = findViewById(R.id.lblResultado);

        // Cajas de Texto
        txt1 = findViewById(R.id.txtNum1);
        txt2 = findViewById(R.id.txtNum2);
    }

    fun btnSumar() {
        calculadora.num1 = txt1.text.toString().toInt();
        calculadora.num2 = txt2.text.toString().toInt();
        var total = calculadora.suma();
        lblResultado.text = total.toString();
    }

    fun btnRestar() {
        calculadora.num1 = txt1.text.toString().toInt();
        calculadora.num2 = txt2.text.toString().toInt();
        var total = calculadora.resta();
        lblResultado.text = total.toString();
    }

    fun btnMultiplicar() {
        val num1Text = txt1.text.toString()
        val num2Text = txt2.text.toString()

        if (num1Text.isNotEmpty() && num2Text.isNotEmpty()) {
            calculadora.num1 = num1Text.toInt()
            calculadora.num2 = num2Text.toInt()
            val total = calculadora.multiplicacion()
            lblResultado.text = total.toString()
        } else {
            // Mostrar un mensaje de error o tomar alguna acción en caso de campos vacíos
            // Por ejemplo: mostrar un diálogo o deshabilitar el botón de multiplicar
        }
    }


    fun btnDividir() {
        calculadora.num1 = txt1.text.toString().toInt();
        calculadora.num2 = txt2.text.toString().toInt();
        var total = calculadora.division();
        lblResultado.text = total.toString();
    }

    fun btnLimpiar() {
        lblResultado.text = "";
        txt2.text.clear();
        txt1.text.clear();
    }

    fun btnRegresar() {
        var confirmar = AlertDialog.Builder(this);
        confirmar.setTitle("Calculadora");
        confirmar.setMessage("Regresar al MainActivity");
        confirmar.setPositiveButton("Confirmar"){dialogInterface,which->finish()}
        confirmar.setNegativeButton("Cancelar"){dialogInterface,which->}
        confirmar.show();
    }
}