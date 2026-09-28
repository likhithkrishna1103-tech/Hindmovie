package com.phisher98;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/phisher98/Techinmind;", "Lcom/phisher98/GDMirrorbot;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "setRequiresReferer", "(Z)V", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Techinmind extends GDMirrorbot {

    @NotNull
    private String name = "Techinmind Cloud AIO";

    @NotNull
    private String mainUrl = "https://stream.techinmind.space";
    private boolean requiresReferer = true;

    @Override // com.phisher98.GDMirrorbot
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.phisher98.GDMirrorbot
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.phisher98.GDMirrorbot
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.phisher98.GDMirrorbot
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.phisher98.GDMirrorbot
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    public void setRequiresReferer(boolean z) {
        this.requiresReferer = z;
    }
}
