package com.example.billeteradigital.Controller

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.billeteradigital.R

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.billeteradigital.api.ApiService
import com.example.billeteradigital.SigninRequest
import com.example.billeteradigital.SigninResponse

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail: EditText = findViewById(R.id.edtEmail);
        val edtPassword: EditText = findViewById(R.id.edtPassword);

        val login: Button = findViewById(R.id.login);
        login.setOnClickListener {



            val email = edtEmail.text.toString().trim();
            val pasword = edtPassword.text.toString().trim();

            edtEmail.setText("prueba.dev@moviired.com");
            edtPassword.setText("Abcd123*");

            if (email.isEmpty()){
                edtEmail.error ="Email error"
                edtEmail.requestFocus();
                return@setOnClickListener
            }else{
                if(email.length < 8){
                    edtEmail.error ="La contraseña debe ser de mínimo 8 caracteres"
                    edtEmail.requestFocus();
                    return@setOnClickListener
                }else{
                    if (pasword.isEmpty()){
                        edtPassword.error ="edtPassword error"
                        edtPassword.requestFocus();
                        return@setOnClickListener
                    }else{
                        post(email, pasword);
                    }
                }
            }
        }

        val moreInfo: Button = findViewById(R.id.moreInfo);
        moreInfo.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, MoreMovii::class.java)
            startActivity(intent)
        })

    }




    private fun post(email: String, pasword: String) {
        ApiService.loginApiCall().doLogin(
            SigninRequest(
                email,pasword
            )
        ).enqueue(object : Callback<SigninResponse> {
            override fun onResponse(
                call: Call<SigninResponse>,
                response: Response<SigninResponse>) {

                Log.d("Response::::", response.body().toString())
                Log.d("Response::::", response.body()!!.message)

                if (response.body()!!.statusCode == 200){

                    val i = Intent(this@Login, Home::class.java)
                    startActivity(i)


                }else{

                    val builder = AlertDialog.Builder(this@Login)
                    builder.setMessage(response.body()!!.message)
                        .setPositiveButton(R.string.aceptar,
                            DialogInterface.OnClickListener { dialog, id ->
                                // FIRE ZE MISSILES!
                            })

                    // Create the AlertDialog object and return it
                    builder.create()

                    Toast.makeText(applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<SigninResponse>, t: Throwable) {
            }

        })
    }
}

