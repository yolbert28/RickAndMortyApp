package com.yolbertdev.rickandmortyapp.ui

import javax.inject.Inject

class Inyectable2 @Inject constructor() {

    fun greeting(): String {
        return "hello word"
    }
}