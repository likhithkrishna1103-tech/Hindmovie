package com.bumptech.glide;

import com.bumptech.glide.manager.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements com.bumptech.glide.manager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f2795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f2796b;

    public l(m mVar, s sVar) {
        this.f2796b = mVar;
        this.f2795a = sVar;
    }

    @Override // com.bumptech.glide.manager.a
    public final void a(boolean z2) {
        if (z2) {
            synchronized (this.f2796b) {
                s sVar = this.f2795a;
                ArrayList arrayListE = x6.m.e((Set) sVar.f2863x);
                int size = arrayListE.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayListE.get(i);
                    i++;
                    t6.c cVar = (t6.c) obj;
                    if (!cVar.k() && !cVar.c()) {
                        cVar.clear();
                        if (sVar.f2862w) {
                            ((HashSet) sVar.f2861v).add(cVar);
                        } else {
                            cVar.h();
                        }
                    }
                }
            }
        }
    }
}
