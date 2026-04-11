package com.bumptech.glide.manager;

import androidx.lifecycle.u;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
final class LifecycleLifecycle implements g, androidx.lifecycle.r {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashSet f2830u = new HashSet();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final u f2831v;

    public LifecycleLifecycle(u uVar) {
        this.f2831v = uVar;
        uVar.a(this);
    }

    @Override // com.bumptech.glide.manager.g
    public final void b(h hVar) {
        this.f2830u.add(hVar);
        androidx.lifecycle.n nVar = this.f2831v.f1504c;
        if (nVar == androidx.lifecycle.n.f1482u) {
            hVar.m();
        } else if (nVar.compareTo(androidx.lifecycle.n.f1485x) >= 0) {
            hVar.l();
        } else {
            hVar.d();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void e(h hVar) {
        this.f2830u.remove(hVar);
    }

    @z(androidx.lifecycle.m.ON_DESTROY)
    public void onDestroy(androidx.lifecycle.s sVar) {
        ArrayList arrayListE = x6.m.e(this.f2830u);
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
        ArrayList arrayListE = x6.m.e(this.f2830u);
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
        ArrayList arrayListE = x6.m.e(this.f2830u);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((h) obj).d();
        }
    }
}
