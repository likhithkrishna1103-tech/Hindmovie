package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements Comparator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h f2645v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b6.f f2646w;

    public u(h hVar, b6.f fVar) {
        this.f2645v = hVar;
        this.f2646w = fVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        if (nVar instanceof r) {
            return !(nVar2 instanceof r) ? 1 : 0;
        }
        if (nVar2 instanceof r) {
            return -1;
        }
        h hVar = this.f2645v;
        return hVar == null ? nVar.i().compareTo(nVar2.i()) : (int) n5.a.Z(hVar.e(this.f2646w, Arrays.asList(nVar, nVar2)).d().doubleValue());
    }
}
