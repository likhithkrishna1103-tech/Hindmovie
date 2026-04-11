package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2589a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2590b;

    public s(int i) {
        this.f2590b = i;
    }

    public static m c(b6.f fVar, List list) {
        w wVar = w.f2697w;
        n5.a.T("FN", 2, list);
        n nVarC = ((t) fVar.f1801x).c(fVar, (n) list.get(0));
        n nVarC2 = ((t) fVar.f1801x).c(fVar, (n) list.get(1));
        if (!(nVarC2 instanceof d)) {
            throw new IllegalArgumentException(q4.a.n("FN requires an ArrayValue of parameter names found ", nVarC2.getClass().getCanonicalName()));
        }
        List listK = ((d) nVarC2).k();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new m(nVarC.i(), (ArrayList) listK, arrayList, fVar);
    }

    public static boolean d(n nVar, n nVar2) {
        if (nVar instanceof j) {
            nVar = new q(nVar.i());
        }
        if (nVar2 instanceof j) {
            nVar2 = new q(nVar2.i());
        }
        if ((nVar instanceof q) && (nVar2 instanceof q)) {
            return ((q) nVar).f2579v.compareTo(((q) nVar2).f2579v) < 0;
        }
        double dDoubleValue = nVar.d().doubleValue();
        double dDoubleValue2 = nVar2.d().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || ((dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    public static n e(v vVar, n nVar, n nVar2) {
        if (nVar instanceof Iterable) {
            return g(vVar, ((Iterable) nVar).iterator(), nVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    public static boolean f(n nVar, n nVar2) {
        if (nVar.getClass().equals(nVar2.getClass())) {
            if ((nVar instanceof r) || (nVar instanceof l)) {
                return true;
            }
            return nVar instanceof g ? (Double.isNaN(nVar.d().doubleValue()) || Double.isNaN(nVar2.d().doubleValue()) || nVar.d().doubleValue() != nVar2.d().doubleValue()) ? false : true : nVar instanceof q ? nVar.i().equals(nVar2.i()) : nVar instanceof e ? nVar.a().equals(nVar2.a()) : nVar == nVar2;
        }
        if (((nVar instanceof r) || (nVar instanceof l)) && ((nVar2 instanceof r) || (nVar2 instanceof l))) {
            return true;
        }
        boolean z10 = nVar instanceof g;
        if (z10 && (nVar2 instanceof q)) {
            return f(nVar, new g(nVar2.d()));
        }
        boolean z11 = nVar instanceof q;
        if (z11 && (nVar2 instanceof g)) {
            return f(new g(nVar.d()), nVar2);
        }
        if (nVar instanceof e) {
            return f(new g(nVar.d()), nVar2);
        }
        if (nVar2 instanceof e) {
            return f(nVar, new g(nVar2.d()));
        }
        if ((z11 || z10) && (nVar2 instanceof j)) {
            return f(nVar, new q(nVar2.i()));
        }
        if ((nVar instanceof j) && ((nVar2 instanceof q) || (nVar2 instanceof g))) {
            return f(new q(nVar.i()), nVar2);
        }
        return false;
    }

    public static n g(v vVar, Iterator it, n nVar) {
        b6.f fVarW;
        if (it != null) {
            while (it.hasNext()) {
                n nVar2 = (n) it.next();
                switch (vVar.f2655a) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        fVarW = vVar.f2656b.w();
                        String str = vVar.f2657c;
                        fVarW.z(str, nVar2);
                        ((HashMap) fVarW.f1803z).put(str, Boolean.TRUE);
                        break;
                    case 1:
                        fVarW = vVar.f2656b.w();
                        fVarW.z(vVar.f2657c, nVar2);
                        break;
                    default:
                        fVarW = vVar.f2656b;
                        fVarW.z(vVar.f2657c, nVar2);
                        break;
                }
                n nVarV = fVarW.v((d) nVar);
                if (nVarV instanceof f) {
                    f fVar = (f) nVarV;
                    String str2 = fVar.f2385w;
                    if ("break".equals(str2)) {
                        return n.f2536b;
                    }
                    if ("return".equals(str2)) {
                        return fVar;
                    }
                }
            }
        }
        return n.f2536b;
    }

    public static boolean h(n nVar, n nVar2) {
        if (nVar instanceof j) {
            nVar = new q(nVar.i());
        }
        if (nVar2 instanceof j) {
            nVar2 = new q(nVar2.i());
        }
        return (((nVar instanceof q) && (nVar2 instanceof q)) || !(Double.isNaN(nVar.d().doubleValue()) || Double.isNaN(nVar2.d().doubleValue()))) && !d(nVar2, nVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:504:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n a(java.lang.String r12, b6.f r13, java.util.ArrayList r14) {
        /*
            Method dump skipped, instruction units count: 3868
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.s.a(java.lang.String, b6.f, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    public final void b(String str) {
        if (!this.f2589a.contains(n5.a.W(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
    }
}
