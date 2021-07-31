package com.example.billeteradigital.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.billeteradigital.R

class MoreMovii : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_movii)
        val webView: WebView = findViewById(R.id.webView);

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.movii.com.co")
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
    }
}