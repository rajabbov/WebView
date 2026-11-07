package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            webView.settings.javaScriptEnabled = true
            webView.loadUrl("https://google.com")
            webView.webViewClient = WebViewClient()

            webView.setOnClickListener {
                var url = webViewEdit.text.toString()
                if (!url.contains("https://"))
                    url = "https://$url"
                webView.settings.javaScriptEnabled = true
                webView.loadUrl(url)
                webView.webViewClient = WebViewClient()


            }

        }
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {

            super.onBackPressed()
        }

    }
}
