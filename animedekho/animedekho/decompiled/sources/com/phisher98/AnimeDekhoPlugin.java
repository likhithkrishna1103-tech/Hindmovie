package com.phisher98;

import com.lagradost.cloudstream3.extractors.FileMoon;
import com.lagradost.cloudstream3.extractors.FilemoonV2;
import com.lagradost.cloudstream3.extractors.Krakenfiles;
import com.lagradost.cloudstream3.extractors.StreamTape;
import com.lagradost.cloudstream3.extractors.Voe;
import com.lagradost.cloudstream3.plugins.BasePlugin;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimeDekhoPlugin.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\u0007¨\u0006\u0006"}, d2 = {"Lcom/phisher98/AnimeDekhoPlugin;", "Lcom/lagradost/cloudstream3/plugins/BasePlugin;", "<init>", "()V", "load", "", "AnimeDekhoProvider", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AnimeDekhoPlugin extends BasePlugin {
    public void load() {
        registerMainAPI(new AnimeDekhoProvider());
        registerMainAPI(new HindiSubAnime());
        registerExtractorAPI(new StreamRuby());
        registerExtractorAPI((ExtractorApi) new Vidmolynet());
        registerExtractorAPI(new GDMirrorbot());
        registerExtractorAPI(new Techinmind());
        registerExtractorAPI((ExtractorApi) new Cdnwish());
        registerExtractorAPI((ExtractorApi) new Multimovies());
        registerExtractorAPI((ExtractorApi) new FileMoon());
        registerExtractorAPI((ExtractorApi) new FileMoonNL());
        registerExtractorAPI((ExtractorApi) new Krakenfiles());
        registerExtractorAPI((ExtractorApi) new Voe());
        registerExtractorAPI((ExtractorApi) new StreamTape());
        registerExtractorAPI((ExtractorApi) new FilemoonV2());
        registerExtractorAPI((ExtractorApi) new Animezia());
        registerExtractorAPI((ExtractorApi) new Cloudy());
        registerExtractorAPI((ExtractorApi) new vidcloudupns());
        registerExtractorAPI(new Animedekhoco());
        registerExtractorAPI(new Blakiteapi());
        registerExtractorAPI(new ascdn21());
        registerExtractorAPI(new Abyass());
    }
}
