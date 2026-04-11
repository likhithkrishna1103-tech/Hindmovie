package com.bumptech.glide.manager;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f2832u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bumptech.glide.l f2833v;

    public c(Context context, com.bumptech.glide.l lVar) {
        this.f2832u = context.getApplicationContext();
        this.f2833v = lVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void d() {
        s sVarD = s.d(this.f2832u);
        com.bumptech.glide.l lVar = this.f2833v;
        synchronized (sVarD) {
            ((HashSet) sVarD.f2861v).remove(lVar);
            if (sVarD.f2862w && ((HashSet) sVarD.f2861v).isEmpty()) {
                ((n) sVarD.f2863x).a();
                sVarD.f2862w = false;
            }
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
        s sVarD = s.d(this.f2832u);
        com.bumptech.glide.l lVar = this.f2833v;
        synchronized (sVarD) {
            ((HashSet) sVarD.f2861v).add(lVar);
            if (!sVarD.f2862w && !((HashSet) sVarD.f2861v).isEmpty()) {
                sVarD.f2862w = ((n) sVarD.f2863x).b();
            }
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
    }
}
