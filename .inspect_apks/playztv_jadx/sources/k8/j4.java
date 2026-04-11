package k8;

import com.google.android.gms.internal.measurement.v7;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.q3 f7265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitSet f7266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitSet f7267e;
    public final s.e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s.e f7268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i4 f7269h;

    public j4(i4 i4Var, String str) {
        this.f7269h = i4Var;
        this.f7263a = str;
        this.f7264b = true;
        this.f7266d = new BitSet();
        this.f7267e = new BitSet();
        this.f = new s.e(0);
        this.f7268g = new s.e(0);
    }

    public final void a(c cVar) {
        k1 k1Var = (k1) this.f7269h.f2454v;
        int iM = cVar.m();
        Boolean bool = (Boolean) cVar.f7102a;
        if (bool != null) {
            this.f7267e.set(iM, bool.booleanValue());
        }
        Boolean bool2 = (Boolean) cVar.f7103b;
        if (bool2 != null) {
            this.f7266d.set(iM, bool2.booleanValue());
        }
        if (((Long) cVar.f7104c) != null) {
            Integer numValueOf = Integer.valueOf(iM);
            s.e eVar = this.f;
            Long l10 = (Long) eVar.get(numValueOf);
            long jLongValue = ((Long) cVar.f7104c).longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                eVar.put(Integer.valueOf(iM), Long.valueOf(jLongValue));
            }
        }
        if (((Long) cVar.f7105d) != null) {
            Integer numValueOf2 = Integer.valueOf(iM);
            s.e eVar2 = this.f7268g;
            List arrayList = (List) eVar2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                eVar2.put(Integer.valueOf(iM), arrayList);
            }
            if (cVar.r()) {
                arrayList.clear();
            }
            v7.a();
            e eVar3 = k1Var.A;
            f0 f0Var = w.f7502p0;
            String str = this.f7263a;
            if (eVar3.A1(str, f0Var) && cVar.q()) {
                arrayList.clear();
            }
            v7.a();
            if (!k1Var.A.A1(str, f0Var)) {
                arrayList.add(Long.valueOf(((Long) cVar.f7105d).longValue() / 1000));
                return;
            }
            long jLongValue2 = ((Long) cVar.f7105d).longValue() / 1000;
            if (arrayList.contains(Long.valueOf(jLongValue2))) {
                return;
            }
            arrayList.add(Long.valueOf(jLongValue2));
        }
    }

    public j4(i4 i4Var, String str, com.google.android.gms.internal.measurement.q3 q3Var, BitSet bitSet, BitSet bitSet2, s.e eVar, s.e eVar2) {
        this.f7269h = i4Var;
        this.f7263a = str;
        this.f7266d = bitSet;
        this.f7267e = bitSet2;
        this.f = eVar;
        this.f7268g = new s.e(0);
        for (Integer num : (s.b) eVar2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) eVar2.get(num));
            this.f7268g.put(num, arrayList);
        }
        this.f7264b = false;
        this.f7265c = q3Var;
    }
}
