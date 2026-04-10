package com.cncverse

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import android.content.Context

@CloudstreamPlugin
class Watch32Plugin: Plugin() {
    override fun load(context: Context) {
        Watch32Provider.context = context
        registerMainAPI(Watch32Provider())
        registerExtractorAPI(Videostr())
    }
}