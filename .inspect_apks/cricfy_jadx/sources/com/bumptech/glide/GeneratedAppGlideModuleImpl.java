package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import app.cricfy.tv.app.IGlideModule;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    public final IGlideModule i = new IGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: app.cricfy.tv.app.IGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final com.bumptech.glide.manager.k A() {
        return new ka.f(7);
    }

    @Override // w4.v
    public final void d() {
        this.i.getClass();
    }

    @Override // w4.v
    public final boolean m() {
        this.i.getClass();
        return false;
    }

    @Override // w4.v
    public final void p(Context context, b bVar, k kVar) {
        kVar.l(new w6.b(0));
        this.i.p(context, bVar, kVar);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final Set z() {
        return Collections.EMPTY_SET;
    }
}
