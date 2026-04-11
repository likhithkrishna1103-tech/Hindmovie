package com.bumptech.glide.manager;

import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
final class LifecycleLifecycle implements g, androidx.lifecycle.r {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashSet f2258v = new HashSet();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final androidx.lifecycle.u f2259w;

    public LifecycleLifecycle(androidx.lifecycle.u uVar) {
        this.f2259w = uVar;
        uVar.a(this);
    }

    @Override // com.bumptech.glide.manager.g
    public final void b(h hVar) {
        this.f2258v.add(hVar);
        androidx.lifecycle.n nVar = this.f2259w.f1200c;
        if (nVar == androidx.lifecycle.n.f1179v) {
            hVar.m();
        } else if (nVar.compareTo(androidx.lifecycle.n.f1182y) >= 0) {
            hVar.l();
        } else {
            hVar.c();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void c(h hVar) {
        this.f2258v.remove(hVar);
    }

    @z(androidx.lifecycle.m.ON_DESTROY)
    public void onDestroy(androidx.lifecycle.s sVar) {
        ArrayList arrayListE = s7.m.e(this.f2258v);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((h) obj).m();
        }
        sVar.f().f(this);
    }

    @z(androidx.lifecycle.m.ON_START)
    public void onStart(androidx.lifecycle.s sVar) {
        ArrayList arrayListE = s7.m.e(this.f2258v);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((h) obj).l();
        }
    }

    @z(androidx.lifecycle.m.ON_STOP)
    public void onStop(androidx.lifecycle.s sVar) {
        ArrayList arrayListE = s7.m.e(this.f2258v);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((h) obj).c();
        }
    }
}
