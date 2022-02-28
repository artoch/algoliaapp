package com.toch.algoliaapp.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.toch.algoliaapp.databinding.ActivityWebViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewActivity : AppCompatActivity() {

    companion object {
        const val URL = "URL"
    }

    private lateinit var binding : ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initView() {
        val url = intent.getStringExtra(URL)
        binding.apply {
            wbHit.apply {
                settings.javaScriptEnabled = true
                settings.useWideViewPort = true
                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                        view?.loadUrl(url)
                        return true
                    }
                }
                loadUrl(url!!)
            }
            toolbar.setNavigationOnClickListener {
                finish()
            }
        }
    }

}