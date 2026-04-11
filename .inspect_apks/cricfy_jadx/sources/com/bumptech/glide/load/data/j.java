package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f2241v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AssetManager f2242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f2243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f2244y;

    public j(AssetManager assetManager, String str, int i) {
        this.f2244y = i;
        this.f2242w = assetManager;
        this.f2241v = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f2244y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return AssetFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        Object obj = this.f2243x;
        if (obj == null) {
            return;
        }
        try {
            switch (this.f2244y) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    ((AssetFileDescriptor) obj).close();
                    break;
                default:
                    ((InputStream) obj).close();
                    break;
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, c cVar) {
        Object objOpenFd;
        try {
            AssetManager assetManager = this.f2242w;
            String str = this.f2241v;
            switch (this.f2244y) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    objOpenFd = assetManager.openFd(str);
                    break;
                default:
                    objOpenFd = assetManager.open(str);
                    break;
            }
            this.f2243x = objOpenFd;
            cVar.d(objOpenFd);
        } catch (IOException e9) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e9);
            }
            cVar.c(e9);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }
}
