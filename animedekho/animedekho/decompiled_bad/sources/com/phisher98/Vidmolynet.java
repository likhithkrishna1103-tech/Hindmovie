package com.phisher98;

import com.lagradost.cloudstream3.extractors.Vidmoly;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/phisher98/Vidmolynet;", "Lcom/lagradost/cloudstream3/extractors/Vidmoly;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Vidmolynet extends Vidmoly {

    @NotNull
    private final String mainUrl = "https://vidmoly.net";

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }
}
