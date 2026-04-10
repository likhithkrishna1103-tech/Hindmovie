package com.cncverse

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import android.content.Context

@CloudstreamPlugin
class RtallyPlugin: Plugin() {
    override fun load(context: Context) {
        RtallyProvider.context = context
        registerMainAPI(RtallyProvider())
    }
}