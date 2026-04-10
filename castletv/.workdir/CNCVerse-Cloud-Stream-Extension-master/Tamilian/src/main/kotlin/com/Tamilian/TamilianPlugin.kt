package com.Tamilian

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import android.content.Context

@CloudstreamPlugin
class HiAnimeProviderPlugin : Plugin() {
    override fun load(context: Context) {
        Tamilian.context = context
        registerMainAPI(Tamilian())
    }
}
