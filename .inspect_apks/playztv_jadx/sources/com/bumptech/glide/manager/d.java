package com.bumptech.glide.manager;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ View f2834u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e f2835v;

    public d(e eVar, View view) {
        this.f2835v = eVar;
        this.f2834u = view;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        x6.m.f().post(new ea.t(2, this, this, false));
    }
}
