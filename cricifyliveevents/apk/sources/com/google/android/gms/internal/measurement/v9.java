package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v9 extends h {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final w5 f2674x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap f2675y;

    public v9(w5 w5Var) {
        super("require");
        this.f2675y = new HashMap();
        this.f2674x = w5Var;
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n e(b6.f fVar, List list) {
        n nVar;
        n5.a.R("require", 1, list);
        String strI = ((t) fVar.f1801x).c(fVar, (n) list.get(0)).i();
        HashMap map = this.f2675y;
        if (map.containsKey(strI)) {
            return (n) map.get(strI);
        }
        HashMap map2 = (HashMap) this.f2674x.f2709a;
        if (map2.containsKey(strI)) {
            try {
                nVar = (n) ((Callable) map2.get(strI)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(strI)));
            }
        } else {
            nVar = n.f2536b;
        }
        if (nVar instanceof h) {
            map.put(strI, (h) nVar);
        }
        return nVar;
    }
}
