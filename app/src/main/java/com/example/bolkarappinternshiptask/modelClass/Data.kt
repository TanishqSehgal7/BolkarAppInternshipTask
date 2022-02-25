package com.example.bolkarappinternshiptask.modelClass

data class Data(
    val __v: Int,
    val _id: String,
    val appId: String,
    val blocks: List<Any>,
    val host: Person,
    val members: List<Person>,
    val modHistory: List<String>,
    val moderators: List<Person>,
    val raiseAllow: Boolean,
    val requests: List<Any>,
    val roomid: String,
    val speakers: List<Person>,
    val start_time: String,
    val token: String,
    val topic: String,
    val total_members: Int,
    val type: Int,
    val version: Int,
    val volume: Int
)