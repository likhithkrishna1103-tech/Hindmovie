package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k5 f3159a = new k5(5);

    public static e a(e eVar, ub.o oVar, o oVar2, Boolean bool, Boolean bool2) {
        e eVar2 = new e();
        Iterator itY = eVar.y();
        while (itY.hasNext()) {
            int iIntValue = ((Integer) itY.next()).intValue();
            if (eVar.x(iIntValue)) {
                n nVarA = oVar2.a(oVar, Arrays.asList(eVar.r(iIntValue), new g(Double.valueOf(iIntValue)), eVar));
                if (nVarA.b().equals(bool)) {
                    break;
                }
                if (bool2 == null || nVarA.b().equals(bool2)) {
                    eVar2.w(iIntValue, nVarA);
                }
            }
        }
        return eVar2;
    }

    public static n b(e eVar, ub.o oVar, ArrayList arrayList, boolean z2) {
        n nVarA;
        c4.o("reduce", 1, arrayList);
        c4.q("reduce", 2, arrayList);
        n nVarL0 = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0));
        if (!(nVarL0 instanceof j)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (arrayList.size() == 2) {
            nVarA = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(1));
            if (nVarA instanceof h) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (eVar.t() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            nVarA = null;
        }
        j jVar = (j) nVarL0;
        int iT = eVar.t();
        int i = z2 ? 0 : iT - 1;
        int i10 = z2 ? iT - 1 : 0;
        int i11 = z2 ? 1 : -1;
        if (nVarA == null) {
            nVarA = eVar.r(i);
            i += i11;
        }
        while ((i10 - i) * i11 >= 0) {
            if (eVar.x(i)) {
                nVarA = jVar.a(oVar, Arrays.asList(nVarA, eVar.r(i), new g(Double.valueOf(i)), eVar));
                if (nVarA instanceof h) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i11;
            } else {
                i += i11;
            }
        }
        return nVarA;
    }

    public static String c(a5 a5Var) {
        StringBuilder sb2 = new StringBuilder(a5Var.h());
        for (int i = 0; i < a5Var.h(); i++) {
            byte b10 = a5Var.b(i);
            if (b10 == 34) {
                sb2.append("\\\"");
            } else if (b10 == 39) {
                sb2.append("\\'");
            } else if (b10 != 92) {
                switch (b10) {
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (b10 < 32 || b10 > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((b10 >>> 6) & 3) + 48));
                            sb2.append((char) (((b10 >>> 3) & 7) + 48));
                            sb2.append((char) ((b10 & 7) + 48));
                        } else {
                            sb2.append((char) b10);
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }
}
