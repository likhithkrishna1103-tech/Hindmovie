package com.cncverse

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import android.content.Context

@CloudstreamPlugin
class GoldenAudiobookPlugin : Plugin() {
    override fun load(context: Context) {
        GoldenAudiobook.context = context
        registerMainAPI(GoldenAudiobook())
    }
}
