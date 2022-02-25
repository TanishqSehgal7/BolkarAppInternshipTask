package com.example.bolkarappinternshiptask.modelClass

import com.google.gson.annotations.SerializedName

data class Person (
    @SerializedName("_id")
    val _id: String,
    @SerializedName("au")
    val au: Int,
    @SerializedName("mic")
    val mic: Boolean,
    @SerializedName("mod")
    val mod: Boolean,
    @SerializedName("n")
    val n: String,
    @SerializedName("socketid")
    val socketid: String,
    @SerializedName("u")
    val u: String,
    @SerializedName("visible")
    val visible: Boolean
)