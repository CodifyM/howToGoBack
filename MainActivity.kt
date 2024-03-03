
package com.onlymoms01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Finding view by ID, which has to be deployed on the web browser
        myWebView = findViewById(R.id.web01)

        // Enabling JavaScript
        myWebView.settings.javaScriptEnabled = true

        // Loading URL
        // actual URL to implement is: https://sites.google.com/view/snacikifyy/home
        // the url which successfully renders with the emulator is: https://www.google.com
        myWebView.loadUrl("https://sites.google.com/view/snacikifyy/home")


        // Set a WebViewClient to handle page navigation
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url ?: "")
                return true
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event?.action == KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (myWebView.canGoBack()) {
                        myWebView.goBack() // Go back to the previous page
                    } else {
                        finish() // Close the app if no history
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}
