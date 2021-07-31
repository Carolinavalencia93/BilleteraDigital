package com.example.billeteradigital

import com.google.gson.annotations.SerializedName

public class SigninRequest (@SerializedName("email") var email: String,
                     @SerializedName("password") var password: String)
