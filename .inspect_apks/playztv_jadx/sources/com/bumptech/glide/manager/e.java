package com.bumptech.glide.manager;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f2836u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f2837v;

    public e(int i) {
        switch (i) {
            case 1:
                this.f2837v = new Object();
                break;
            default:
                this.f2837v = Collections.newSetFromMap(new WeakHashMap());
                break;
        }
    }

    @Override // com.bumptech.glide.manager.f
    public void l(h.j jVar) {
        if (!this.f2836u && ((Set) this.f2837v).add(jVar)) {
            View decorView = jVar.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new d(this, decorView));
        }
    }
}
