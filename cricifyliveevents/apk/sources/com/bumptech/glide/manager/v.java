package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Set f2292v = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.h
    public final void c() {
        ArrayList arrayListE = s7.m.e(this.f2292v);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((p7.d) obj).c();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
        ArrayList arrayListE = s7.m.e(this.f2292v);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((p7.d) obj).l();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
        ArrayList arrayListE = s7.m.e(this.f2292v);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((p7.d) obj).m();
        }
    }
}
