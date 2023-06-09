package com.example.practica03calculadorakotlin

class Calculadora {
    var num1: Int=0;
    var num2: Int=0;

    constructor(num1:Int, num2:Int) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Función
    fun suma():Int {
        return num1 + num2;
    }

    fun resta():Int {
        return num1 - num2;
    }

    fun multiplicacion():Int {
        return num1 * num2;
    }

    fun division():Int {
        var Total = 0;
        if(num2 != 0) {
            Total = num1 / num2;
        }
        return Total;
    }
}