package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f3132w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f3133x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ub.o f3134y;

    public o(o oVar) {
        super(oVar.f3060u);
        ArrayList arrayList = new ArrayList(oVar.f3132w.size());
        this.f3132w = arrayList;
        arrayList.addAll(oVar.f3132w);
        ArrayList arrayList2 = new ArrayList(oVar.f3133x.size());
        this.f3133x = arrayList2;
        arrayList2.addAll(oVar.f3133x);
        this.f3134y = oVar.f3134y;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n a(ub.o oVar, List list) {
        t tVar;
        ub.o oVarB0 = this.f3134y.b0();
        h4.z zVar = (h4.z) oVarB0.f12869w;
        int i = 0;
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f3132w;
            int size = arrayList.size();
            tVar = n.f3106a;
            if (i10 >= size) {
                break;
            }
            if (i10 < list.size()) {
                oVarB0.d0((String) arrayList.get(i10), ((h4.z) oVar.f12869w).l0(oVar, (n) list.get(i10)));
            } else {
                oVarB0.d0((String) arrayList.get(i10), tVar);
            }
            i10++;
        }
        ArrayList arrayList2 = this.f3133x;
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj = arrayList2.get(i);
            i++;
            n nVar = (n) obj;
            n nVarL0 = zVar.l0(oVarB0, nVar);
            if (nVarL0 instanceof q) {
                nVarL0 = zVar.l0(oVarB0, nVar);
            }
            if (nVarL0 instanceof h) {
                return ((h) nVarL0).f3031u;
            }
        }
        return tVar;
    }

    @Override // com.google.android.gms.internal.measurement.j, com.google.android.gms.internal.measurement.n
    public final n j() {
        return new o(this);
    }

    public o(String str, ArrayList arrayList, List list, ub.o oVar) {
        super(str);
        this.f3132w = new ArrayList();
        this.f3134y = oVar;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                this.f3132w.add(((n) obj).i());
            }
        }
        this.f3133x = new ArrayList(list);
    }
}
