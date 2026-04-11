package com.bumptech.glide.manager;

import androidx.lifecycle.u;
import h4.z;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ u f2838u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ z f2839v;

    public i(z zVar, u uVar) {
        this.f2839v = zVar;
        this.f2838u = uVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
        ((HashMap) this.f2839v.f5867v).remove(this.f2838u);
    }

    @Override // com.bumptech.glide.manager.h
    public final void d() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
    }
}
