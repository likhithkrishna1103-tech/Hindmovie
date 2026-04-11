package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m implements d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f2251v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Uri f2252w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ContentResolver f2253x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f2254y;

    public m(ContentResolver contentResolver, Uri uri, boolean z10) {
        this.f2253x = contentResolver;
        this.f2252w = uri;
        this.f2251v = z10;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        Object obj = this.f2254y;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void c(Object obj);

    public abstract Object d(ContentResolver contentResolver, Uri uri);

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, c cVar) {
        try {
            Object objD = d(this.f2253x, this.f2252w);
            this.f2254y = objD;
            cVar.d(objD);
        } catch (FileNotFoundException e9) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e9);
            }
            cVar.c(e9);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }
}
