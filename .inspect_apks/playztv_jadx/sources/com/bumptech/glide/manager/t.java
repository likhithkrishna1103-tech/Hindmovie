package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Set f2864u = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.h
    public final void d() {
        ArrayList arrayListE = x6.m.e(this.f2864u);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((u6.d) obj).d();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
        ArrayList arrayListE = x6.m.e(this.f2864u);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((u6.d) obj).l();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
        ArrayList arrayListE = x6.m.e(this.f2864u);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((u6.d) obj).m();
        }
    }
}
