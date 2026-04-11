package com.bumptech.glide.manager;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f2264v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f2265w;

    public e(int i) {
        switch (i) {
            case 1:
                this.f2265w = new Object();
                break;
            default:
                this.f2265w = Collections.newSetFromMap(new WeakHashMap());
                break;
        }
    }

    @Override // com.bumptech.glide.manager.f
    public void f(h.j jVar) {
        if (!this.f2264v && ((Set) this.f2265w).add(jVar)) {
            View decorView = jVar.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new d(this, decorView));
        }
    }
}
