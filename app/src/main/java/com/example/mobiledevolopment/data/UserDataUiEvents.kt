package com.example.mobiledevolopment.data

sealed class UserDataUiEvents{
    data class UserNameEntered(val name:String) : UserDataUiEvents()
    data class CardSelected(val cardValue:String) : UserDataUiEvents()

    //name

    //password
}