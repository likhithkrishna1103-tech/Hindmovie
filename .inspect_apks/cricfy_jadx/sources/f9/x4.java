package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.v7;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.m3 f4486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitSet f4487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitSet f4488e;
    public final v.e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v.e f4489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f4490h;

    public x4(c cVar, String str, com.google.android.gms.internal.measurement.m3 m3Var, BitSet bitSet, BitSet bitSet2, v.e eVar, v.e eVar2) {
        this.f4490h = cVar;
        this.f4484a = str;
        this.f4487d = bitSet;
        this.f4488e = bitSet2;
        this.f = eVar;
        this.f4489g = new v.e(0);
        for (Integer num : (v.b) eVar2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) eVar2.get(num));
            this.f4489g.put(num, arrayList);
        }
        this.f4485b = false;
        this.f4486c = m3Var;
    }

    public final void a(b bVar) {
        int iQ;
        boolean z10;
        boolean zV;
        switch (bVar.f4017g) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                iQ = ((com.google.android.gms.internal.measurement.o1) bVar.i).q();
                break;
            default:
                iQ = ((com.google.android.gms.internal.measurement.v1) bVar.i).q();
                break;
        }
        if (bVar.f4014c != null) {
            this.f4488e.set(iQ, true);
        }
        Boolean bool = bVar.f4015d;
        if (bool != null) {
            this.f4487d.set(iQ, bool.booleanValue());
        }
        if (bVar.f4016e != null) {
            Integer numValueOf = Integer.valueOf(iQ);
            v.e eVar = this.f;
            Long l10 = (Long) eVar.get(numValueOf);
            long jLongValue = bVar.f4016e.longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                eVar.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (bVar.f != null) {
            Integer numValueOf2 = Integer.valueOf(iQ);
            v.e eVar2 = this.f4489g;
            List arrayList = (List) eVar2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                eVar2.put(numValueOf2, arrayList);
            }
            switch (bVar.f4017g) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    z10 = false;
                    break;
                default:
                    z10 = true;
                    break;
            }
            if (z10) {
                arrayList.clear();
            }
            v7.a();
            r1 r1Var = (r1) this.f4490h.f307w;
            g gVar = r1Var.f4366y;
            e0 e0Var = f0.G0;
            String str = this.f4484a;
            if (gVar.w1(str, e0Var)) {
                switch (bVar.f4017g) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        zV = ((com.google.android.gms.internal.measurement.o1) bVar.i).v();
                        break;
                    default:
                        zV = false;
                        break;
                }
                if (zV) {
                    arrayList.clear();
                }
            }
            v7.a();
            if (!r1Var.f4366y.w1(str, e0Var)) {
                arrayList.add(Long.valueOf(bVar.f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(bVar.f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public final com.google.android.gms.internal.measurement.t2 b(int i) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.s2 s2VarW = com.google.android.gms.internal.measurement.t2.w();
        s2VarW.b();
        ((com.google.android.gms.internal.measurement.t2) s2VarW.f2470w).x(i);
        s2VarW.b();
        ((com.google.android.gms.internal.measurement.t2) s2VarW.f2470w).A(this.f4485b);
        com.google.android.gms.internal.measurement.m3 m3Var = this.f4486c;
        if (m3Var != null) {
            s2VarW.b();
            ((com.google.android.gms.internal.measurement.t2) s2VarW.f2470w).z(m3Var);
        }
        com.google.android.gms.internal.measurement.l3 l3VarX = com.google.android.gms.internal.measurement.m3.x();
        ArrayList arrayListU1 = a1.U1(this.f4487d);
        l3VarX.b();
        ((com.google.android.gms.internal.measurement.m3) l3VarX.f2470w).B(arrayListU1);
        ArrayList arrayListU12 = a1.U1(this.f4488e);
        l3VarX.b();
        ((com.google.android.gms.internal.measurement.m3) l3VarX.f2470w).z(arrayListU12);
        v.e eVar = this.f;
        if (eVar == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(eVar.f12542x);
            for (Integer num : (v.b) eVar.keySet()) {
                int iIntValue = num.intValue();
                Long l10 = (Long) eVar.get(num);
                if (l10 != null) {
                    com.google.android.gms.internal.measurement.y2 y2VarT = com.google.android.gms.internal.measurement.z2.t();
                    y2VarT.b();
                    ((com.google.android.gms.internal.measurement.z2) y2VarT.f2470w).u(iIntValue);
                    long jLongValue = l10.longValue();
                    y2VarT.b();
                    ((com.google.android.gms.internal.measurement.z2) y2VarT.f2470w).v(jLongValue);
                    arrayList2.add((com.google.android.gms.internal.measurement.z2) y2VarT.e());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            l3VarX.b();
            ((com.google.android.gms.internal.measurement.m3) l3VarX.f2470w).D(arrayList);
        }
        v.e eVar2 = this.f4489g;
        if (eVar2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(eVar2.f12542x);
            for (Integer num2 : (v.b) eVar2.keySet()) {
                com.google.android.gms.internal.measurement.n3 n3VarU = com.google.android.gms.internal.measurement.o3.u();
                int iIntValue2 = num2.intValue();
                n3VarU.b();
                ((com.google.android.gms.internal.measurement.o3) n3VarU.f2470w).v(iIntValue2);
                List list2 = (List) eVar2.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    n3VarU.b();
                    ((com.google.android.gms.internal.measurement.o3) n3VarU.f2470w).w(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.o3) n3VarU.e());
            }
            list = arrayList3;
        }
        l3VarX.b();
        ((com.google.android.gms.internal.measurement.m3) l3VarX.f2470w).F(list);
        s2VarW.b();
        ((com.google.android.gms.internal.measurement.t2) s2VarW.f2470w).y((com.google.android.gms.internal.measurement.m3) l3VarX.e());
        return (com.google.android.gms.internal.measurement.t2) s2VarW.e();
    }

    public x4(c cVar, String str) {
        this.f4490h = cVar;
        this.f4484a = str;
        this.f4485b = true;
        this.f4487d = new BitSet();
        this.f4488e = new BitSet();
        this.f = new v.e(0);
        this.f4489g = new v.e(0);
    }
}
