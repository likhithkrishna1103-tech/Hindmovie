package com.bumptech.glide.manager;

import java.util.HashMap;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ androidx.lifecycle.u f2266v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ c0 f2267w;

    public i(c0 c0Var, androidx.lifecycle.u uVar) {
        this.f2267w = c0Var;
        this.f2266v = uVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
        ((HashMap) this.f2267w.f7705w).remove(this.f2266v);
    }

    @Override // com.bumptech.glide.manager.h
    public final void c() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
    }
}
