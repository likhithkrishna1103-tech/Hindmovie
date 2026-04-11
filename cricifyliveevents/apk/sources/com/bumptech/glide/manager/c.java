package com.bumptech.glide.manager;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f2260v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bumptech.glide.o f2261w;

    public c(Context context, com.bumptech.glide.o oVar) {
        this.f2260v = context.getApplicationContext();
        this.f2261w = oVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void c() {
        u uVarC = u.c(this.f2260v);
        com.bumptech.glide.o oVar = this.f2261w;
        synchronized (uVarC) {
            ((HashSet) uVarC.f2291x).remove(oVar);
            if (uVarC.f2289v && ((HashSet) uVarC.f2291x).isEmpty()) {
                ((o) uVarC.f2290w).a();
                uVarC.f2289v = false;
            }
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
        u uVarC = u.c(this.f2260v);
        com.bumptech.glide.o oVar = this.f2261w;
        synchronized (uVarC) {
            ((HashSet) uVarC.f2291x).add(oVar);
            if (!uVarC.f2289v && !((HashSet) uVarC.f2291x).isEmpty()) {
                uVarC.f2289v = ((o) uVarC.f2290w).b();
            }
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
    }
}
