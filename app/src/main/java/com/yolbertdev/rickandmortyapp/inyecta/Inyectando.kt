package com.yolbertdev.rickandmortyapp.inyecta

import javax.inject.Inject

class Inyectando @Inject constructor() {

    fun Greeting(): String{
        return "Hello word"
    }

}