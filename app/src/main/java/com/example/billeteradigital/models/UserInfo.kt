package com.example.billeteradigital.models

import com.google.gson.annotations.SerializedName

data class UserInfo (val name:String, val lastnames:String, val balance:Int,
                     val lastLogin:String, val documentType:String, val documentNumber:String)


