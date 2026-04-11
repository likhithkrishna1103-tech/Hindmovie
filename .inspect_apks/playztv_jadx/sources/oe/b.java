package oe;

import nd.k;
import ne.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public p[] f9574u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9575v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9576w;

    public abstract p a();

    public abstract p[] b();

    public final void c(p pVar) {
        int i;
        rd.c[] cVarArr;
        synchronized (this) {
            try {
                int i10 = this.f9575v - 1;
                this.f9575v = i10;
                if (i10 == 0) {
                    this.f9576w = 0;
                }
                be.h.c(pVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                pVar.getClass();
                pVar.f9024a.set(null);
                cVarArr = c.f9577a;
            } catch (Throwable th) {
                throw th;
            }
        }
        for (rd.c cVar : cVarArr) {
            if (cVar != null) {
                cVar.g(k.f8990a);
            }
        }
    }
}
