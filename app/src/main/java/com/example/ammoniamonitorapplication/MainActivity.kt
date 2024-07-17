package com.example.ammoniamonitorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var tilIp: TextInputLayout
    private lateinit var etIp: EditText
    private lateinit var button: Button
    private lateinit var description: TextView
    private lateinit var logo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        tilIp = findViewById(R.id.til_ip)
        etIp = findViewById(R.id.et_ip)
        button = findViewById(R.id.bt_insert)
        description = findViewById(R.id.description)
        logo = findViewById(R.id.logo)

        button.setOnClickListener {
            var newIp = etIp.text.toString()
            val url = "http://$newIp/IoT/FinalProject/index.php"
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()

            button.visibility = View.GONE
            tilIp.visibility = View.GONE
            description.visibility = View.GONE
            logo.visibility = View.GONE

            // Tampilkan WebView dan muat URL
            webView.visibility = View.VISIBLE
            webView.loadUrl(url)
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            button.visibility = View.VISIBLE
            tilIp.visibility = View.VISIBLE
            description.visibility = View.VISIBLE
            webView.visibility = View.GONE
            super.onBackPressed()
        }
    }
}
