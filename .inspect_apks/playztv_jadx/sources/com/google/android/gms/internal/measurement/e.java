package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements i, n, Iterable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TreeMap f2941u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TreeMap f2942v;

    public e() {
        this.f2941u = new TreeMap();
        this.f2942v = new TreeMap();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean b() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final n d(String str) {
        n nVar;
        return "length".equals(str) ? new g(Double.valueOf(t())) : (!e(str) || (nVar = (n) this.f2942v.get(str)) == null) ? n.f3106a : nVar;
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final boolean e(String str) {
        return "length".equals(str) || this.f2942v.containsKey(str);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (t() != eVar.t()) {
            return false;
        }
        TreeMap treeMap = this.f2941u;
        if (treeMap.isEmpty()) {
            return eVar.f2941u.isEmpty();
        }
        for (int iIntValue = ((Integer) treeMap.firstKey()).intValue(); iIntValue <= ((Integer) treeMap.lastKey()).intValue(); iIntValue++) {
            if (!r(iIntValue).equals(eVar.r(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator f() {
        return new d(this.f2941u.keySet().iterator(), this.f2942v.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final void h(String str, n nVar) {
        TreeMap treeMap = this.f2942v;
        if (nVar == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, nVar);
        }
    }

    public final int hashCode() {
        return this.f2941u.hashCode() * 31;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return u(",");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new r(2, this);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        e eVar = new e();
        for (Map.Entry entry : this.f2941u.entrySet()) {
            boolean z2 = entry.getValue() instanceof i;
            TreeMap treeMap = eVar.f2941u;
            if (z2) {
                treeMap.put((Integer) entry.getKey(), (n) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((n) entry.getValue()).j());
            }
        }
        return eVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03a5, code lost:
    
        if (com.google.android.gms.internal.measurement.q0.a(r1, r28, (com.google.android.gms.internal.measurement.o) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).t() != r1.t()) goto L241;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:50:0x00e9. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0825  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0888  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016a  */
    @Override // com.google.android.gms.internal.measurement.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n l(java.lang.String r27, ub.o r28, java.util.ArrayList r29) {
        /*
            Method dump skipped, instruction units count: 2330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.e.l(java.lang.String, ub.o, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double n() {
        TreeMap treeMap = this.f2941u;
        return treeMap.size() == 1 ? r(0).n() : treeMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    public final n r(int i) {
        n nVar;
        if (i < t()) {
            return (!x(i) || (nVar = (n) this.f2941u.get(Integer.valueOf(i))) == null) ? n.f3106a : nVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public final void s(n nVar) {
        w(t(), nVar);
    }

    public final int t() {
        TreeMap treeMap = this.f2941u;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    public final String toString() {
        return u(",");
    }

    public final String u(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (!this.f2941u.isEmpty()) {
            for (int i = 0; i < t(); i++) {
                n nVarR = r(i);
                sb2.append(str);
                if (!(nVarR instanceof t) && !(nVarR instanceof l)) {
                    sb2.append(nVarR.i());
                }
            }
            sb2.delete(0, str.length());
        }
        return sb2.toString();
    }

    public final void v(int i) {
        TreeMap treeMap = this.f2941u;
        int iIntValue = ((Integer) treeMap.lastKey()).intValue();
        if (i > iIntValue || i < 0) {
            return;
        }
        treeMap.remove(Integer.valueOf(i));
        if (i == iIntValue) {
            int i10 = i - 1;
            if (treeMap.containsKey(Integer.valueOf(i10)) || i10 < 0) {
                return;
            }
            treeMap.put(Integer.valueOf(i10), n.f3106a);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) treeMap.lastKey()).intValue()) {
                return;
            }
            n nVar = (n) treeMap.get(Integer.valueOf(i));
            if (nVar != null) {
                treeMap.put(Integer.valueOf(i - 1), nVar);
                treeMap.remove(Integer.valueOf(i));
            }
        }
    }

    public final void w(int i, n nVar) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(e6.j.l("Out of bounds index: ", i));
        }
        TreeMap treeMap = this.f2941u;
        if (nVar == null) {
            treeMap.remove(Integer.valueOf(i));
        } else {
            treeMap.put(Integer.valueOf(i), nVar);
        }
    }

    public final boolean x(int i) {
        if (i >= 0) {
            TreeMap treeMap = this.f2941u;
            if (i <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i));
            }
        }
        throw new IndexOutOfBoundsException(e6.j.l("Out of bounds index: ", i));
    }

    public final Iterator y() {
        return this.f2941u.keySet().iterator();
    }

    public final ArrayList z() {
        ArrayList arrayList = new ArrayList(t());
        for (int i = 0; i < t(); i++) {
            arrayList.add(r(i));
        }
        return arrayList;
    }

    public e(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                w(i, (n) list.get(i));
            }
        }
    }

    public e(n... nVarArr) {
        this(Arrays.asList(nVarArr));
    }
}
