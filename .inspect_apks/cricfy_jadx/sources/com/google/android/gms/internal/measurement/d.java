package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterable, n, j {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TreeMap f2356v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TreeMap f2357w;

    public d() {
        this.f2356v = new TreeMap();
        this.f2357w = new TreeMap();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean a() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n b(String str) {
        n nVar;
        return "length".equals(str) ? new g(Double.valueOf(m())) : (!c(str) || (nVar = (n) this.f2357w.get(str)) == null) ? n.f2536b : nVar;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final boolean c(String str) {
        return "length".equals(str) || this.f2357w.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double d() {
        TreeMap treeMap = this.f2356v;
        return treeMap.size() == 1 ? n(0).d() : treeMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (m() != dVar.m()) {
            return false;
        }
        TreeMap treeMap = this.f2356v;
        if (treeMap.isEmpty()) {
            return dVar.f2356v.isEmpty();
        }
        for (int iIntValue = ((Integer) treeMap.firstKey()).intValue(); iIntValue <= ((Integer) treeMap.lastKey()).intValue(); iIntValue++) {
            if (!n(iIntValue).equals(dVar.n(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final void f(String str, n nVar) {
        TreeMap treeMap = this.f2357w;
        if (nVar == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, nVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator g() {
        return new c(this, this.f2356v.keySet().iterator(), this.f2357w.keySet().iterator());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02e5, code lost:
    
        if (com.google.android.gms.internal.measurement.j4.L(r7, r2, (com.google.android.gms.internal.measurement.m) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).m() == r7.m()) goto L168;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0749  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x07c0  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x083f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0203  */
    @Override // com.google.android.gms.internal.measurement.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n h(java.lang.String r38, b6.f r39, java.util.ArrayList r40) {
        /*
            Method dump skipped, instruction units count: 2202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.d.h(java.lang.String, b6.f, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    public final int hashCode() {
        return this.f2356v.hashCode() * 31;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return r(",");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p(2, this);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        d dVar = new d();
        for (Map.Entry entry : this.f2356v.entrySet()) {
            boolean z10 = entry.getValue() instanceof j;
            TreeMap treeMap = dVar.f2356v;
            if (z10) {
                treeMap.put((Integer) entry.getKey(), (n) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((n) entry.getValue()).j());
            }
        }
        return dVar;
    }

    public final List k() {
        ArrayList arrayList = new ArrayList(m());
        for (int i = 0; i < m(); i++) {
            arrayList.add(n(i));
        }
        return arrayList;
    }

    public final Iterator l() {
        return this.f2356v.keySet().iterator();
    }

    public final int m() {
        TreeMap treeMap = this.f2356v;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    public final n n(int i) {
        n nVar;
        if (i < m()) {
            return (!p(i) || (nVar = (n) this.f2356v.get(Integer.valueOf(i))) == null) ? n.f2536b : nVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public final void o(int i, n nVar) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        TreeMap treeMap = this.f2356v;
        if (nVar == null) {
            treeMap.remove(Integer.valueOf(i));
        } else {
            treeMap.put(Integer.valueOf(i), nVar);
        }
    }

    public final boolean p(int i) {
        if (i >= 0) {
            TreeMap treeMap = this.f2356v;
            if (i <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void q(int i) {
        TreeMap treeMap = this.f2356v;
        int iIntValue = ((Integer) treeMap.lastKey()).intValue();
        if (i > iIntValue || i < 0) {
            return;
        }
        treeMap.remove(Integer.valueOf(i));
        if (i == iIntValue) {
            int i10 = i - 1;
            Integer numValueOf = Integer.valueOf(i10);
            if (treeMap.containsKey(numValueOf) || i10 < 0) {
                return;
            }
            treeMap.put(numValueOf, n.f2536b);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) treeMap.lastKey()).intValue()) {
                return;
            }
            Integer numValueOf2 = Integer.valueOf(i);
            n nVar = (n) treeMap.get(numValueOf2);
            if (nVar != null) {
                treeMap.put(Integer.valueOf(i - 1), nVar);
                treeMap.remove(numValueOf2);
            }
        }
    }

    public final String r(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.f2356v.isEmpty()) {
            int i = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i >= m()) {
                    break;
                }
                n nVarN = n(i);
                sb.append(str2);
                if (!(nVarN instanceof r) && !(nVarN instanceof l)) {
                    sb.append(nVarN.i());
                }
                i++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public final String toString() {
        return r(",");
    }

    public d(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                o(i, (n) list.get(i));
            }
        }
    }
}
