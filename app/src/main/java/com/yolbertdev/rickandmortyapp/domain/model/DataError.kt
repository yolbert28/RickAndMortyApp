package com.yolbertdev.rickandmortyapp.domain.model

sealed interface DataError : Error {

    enum class Network : DataError {
        NO_INTERNET,
        BAD_REQUEST,
        NOT_FOUND,
        SERVER_ERROR,
        UNKNOWN
    }

}