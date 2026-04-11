package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends h {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f2525x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f2526y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b6.f f2527z;

    public m(m mVar) {
        super(mVar.f2466v);
        ArrayList arrayList = new ArrayList(mVar.f2525x.size());
        this.f2525x = arrayList;
        arrayList.addAll(mVar.f2525x);
        ArrayList arrayList2 = new ArrayList(mVar.f2526y.size());
        this.f2526y = arrayList2;
        arrayList2.addAll(mVar.f2526y);
        this.f2527z = mVar.f2527z;
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n e(b6.f fVar, List list) {
        r rVar;
        b6.f fVarW = this.f2527z.w();
        t tVar = (t) fVarW.f1801x;
        int i = 0;
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2525x;
            int size = arrayList.size();
            rVar = n.f2536b;
            if (i10 >= size) {
                break;
            }
            if (i10 < list.size()) {
                fVarW.z((String) arrayList.get(i10), ((t) fVar.f1801x).c(fVar, (n) list.get(i10)));
            } else {
                fVarW.z((String) arrayList.get(i10), rVar);
            }
            i10++;
        }
        ArrayList arrayList2 = this.f2526y;
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj = arrayList2.get(i);
            i++;
            n nVar = (n) obj;
            n nVarC = tVar.c(fVarW, nVar);
            if (nVarC instanceof o) {
                nVarC = tVar.c(fVarW, nVar);
            }
            if (nVarC instanceof f) {
                return ((f) nVarC).f2384v;
            }
        }
        return rVar;
    }

    @Override // com.google.android.gms.internal.measurement.h, com.google.android.gms.internal.measurement.n
    public final n j() {
        return new m(this);
    }

    public m(String str, ArrayList arrayList, List list, b6.f fVar) {
        super(str);
        this.f2525x = new ArrayList();
        this.f2527z = fVar;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                this.f2525x.add(((n) obj).i());
            }
        }
        this.f2526y = new ArrayList(list);
    }
}
