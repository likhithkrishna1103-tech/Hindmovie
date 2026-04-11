package com.bumptech.glide.manager;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ View f2262v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e f2263w;

    public d(e eVar, View view) {
        this.f2263w = eVar;
        this.f2262v = view;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        s7.m.f().post(new ya.s(2, this, this, false));
    }
}
