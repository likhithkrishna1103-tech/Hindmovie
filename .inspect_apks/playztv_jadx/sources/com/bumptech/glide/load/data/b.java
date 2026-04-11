package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2800u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f2801v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Comparable f2802w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f2803x;

    public /* synthetic */ b(int i, Comparable comparable, Object obj) {
        this.f2800u = i;
        this.f2803x = obj;
        this.f2802w = comparable;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f2800u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Object obj = this.f2801v;
                if (obj != null) {
                    try {
                        g(obj);
                    } catch (IOException unused) {
                        return;
                    }
                    break;
                }
                break;
            default:
                Object obj2 = this.f2801v;
                if (obj2 != null) {
                    try {
                        g(obj2);
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        switch (this.f2800u) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i = this.f2800u;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(com.bumptech.glide.f fVar, d dVar) {
        switch (this.f2800u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    Object objH = h((AssetManager) this.f2803x, (String) this.f2802w);
                    this.f2801v = objH;
                    dVar.r(objH);
                } catch (IOException e10) {
                    if (Log.isLoggable("AssetPathFetcher", 3)) {
                        Log.d("AssetPathFetcher", "Failed to load data from asset manager", e10);
                    }
                    dVar.l(e10);
                    return;
                }
                break;
            default:
                try {
                    Object objI = i((Uri) this.f2802w, (ContentResolver) this.f2803x);
                    this.f2801v = objI;
                    dVar.r(objI);
                } catch (FileNotFoundException e11) {
                    if (Log.isLoggable("LocalUriFetcher", 3)) {
                        Log.d("LocalUriFetcher", "Failed to open Uri", e11);
                    }
                    dVar.l(e11);
                }
                break;
        }
    }

    public abstract void g(Object obj);

    public abstract Object h(AssetManager assetManager, String str);

    public abstract Object i(Uri uri, ContentResolver contentResolver);

    private final void d() {
    }

    private final void f() {
    }
}
