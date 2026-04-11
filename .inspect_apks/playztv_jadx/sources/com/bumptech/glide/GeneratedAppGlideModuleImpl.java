package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.playz.tv.app.IGlideModule;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IGlideModule f2758d = new IGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.playz.tv.app.IGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }

    @Override // com.bumptech.glide.c
    public final void a() {
        this.f2758d.getClass();
    }

    @Override // com.bumptech.glide.c
    public final boolean n() {
        this.f2758d.getClass();
        return false;
    }

    @Override // com.bumptech.glide.c
    public final void s(Context context, b bVar, i iVar) {
        iVar.l(new b6.b(0));
        this.f2758d.s(context, bVar, iVar);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final Set y() {
        return Collections.EMPTY_SET;
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final q9.e z() {
        return new q9.e(6);
    }
}
