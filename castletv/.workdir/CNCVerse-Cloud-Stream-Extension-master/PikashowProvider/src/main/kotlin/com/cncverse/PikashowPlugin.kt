package com.cncverse

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import android.content.Context

@CloudstreamPlugin
class PikashowPlugin: Plugin() {
    override fun load(context: Context) {
        PikashowProvider.context = context
        registerMainAPI(PikashowProvider())
    }
}