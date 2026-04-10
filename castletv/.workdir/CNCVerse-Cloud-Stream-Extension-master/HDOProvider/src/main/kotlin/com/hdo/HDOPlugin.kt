package com.hdo

import android.content.Context
import android.util.Log
import com.lagradost.cloudstream3.plugins.Plugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class HDOProviderPlugin : Plugin() {
    override fun load(context: Context) {
        HDO.cont = context
        Log.d("HDOPlugin", "Plugin load() called")
        registerMainAPI(HDO())
        Log.d("HDOPlugin", "HDO provider registered")
    }
}
