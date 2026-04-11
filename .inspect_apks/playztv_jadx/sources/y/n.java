package y;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f14407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f14410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14411e;

    public final void a(ArrayList arrayList) {
        int size = this.f14407a.size();
        if (this.f14411e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                n nVar = (n) arrayList.get(i);
                if (this.f14411e == nVar.f14408b) {
                    c(this.f14409c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(v.c cVar, int i) {
        int iN;
        int iN2;
        ArrayList arrayList = this.f14407a;
        if (arrayList.size() == 0) {
            return 0;
        }
        x.f fVar = (x.f) ((x.e) arrayList.get(0)).T;
        cVar.t();
        fVar.b(cVar, false);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((x.e) arrayList.get(i10)).b(cVar, false);
        }
        if (i == 0 && fVar.f14169z0 > 0) {
            x.k.a(fVar, cVar, arrayList, 0);
        }
        if (i == 1 && fVar.A0 > 0) {
            x.k.a(fVar, cVar, arrayList, 1);
        }
        try {
            cVar.p();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f14410d = new ArrayList();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            x.e eVar = (x.e) arrayList.get(i11);
            w2.f fVar2 = new w2.f();
            new WeakReference(eVar);
            v.c.n(eVar.I);
            v.c.n(eVar.J);
            v.c.n(eVar.K);
            v.c.n(eVar.L);
            v.c.n(eVar.M);
            this.f14410d.add(fVar2);
        }
        if (i == 0) {
            iN = v.c.n(fVar.I);
            iN2 = v.c.n(fVar.K);
            cVar.t();
        } else {
            iN = v.c.n(fVar.J);
            iN2 = v.c.n(fVar.L);
            cVar.t();
        }
        return iN2 - iN;
    }

    public final void c(int i, n nVar) {
        int i10 = nVar.f14408b;
        ArrayList arrayList = this.f14407a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            x.e eVar = (x.e) obj;
            ArrayList arrayList2 = nVar.f14407a;
            if (!arrayList2.contains(eVar)) {
                arrayList2.add(eVar);
            }
            if (i == 0) {
                eVar.f14145n0 = i10;
            } else {
                eVar.f14147o0 = i10;
            }
        }
        this.f14411e = i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i = this.f14409c;
        sb2.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb2.append(" [");
        String strA = x.c.a(sb2, this.f14408b, "] <");
        ArrayList arrayList = this.f14407a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            strA = strA + " " + ((x.e) obj).f14135h0;
        }
        return e6.j.m(strA, " >");
    }
}
