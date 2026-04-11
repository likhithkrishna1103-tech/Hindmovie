package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Comparator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ j f3242u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ub.o f3243v;

    public y(j jVar, ub.o oVar) {
        this.f3242u = jVar;
        this.f3243v = oVar;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        if (nVar instanceof t) {
            return !(nVar2 instanceof t) ? 1 : 0;
        }
        if (nVar2 instanceof t) {
            return -1;
        }
        j jVar = this.f3242u;
        return jVar == null ? nVar.i().compareTo(nVar2.i()) : (int) c4.a(jVar.a(this.f3243v, Arrays.asList(nVar, nVar2)).n().doubleValue());
    }
}
