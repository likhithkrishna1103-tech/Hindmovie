package b0;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f1619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f1622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1623e;

    public final void a(ArrayList arrayList) {
        int size = this.f1619a.size();
        if (this.f1623e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                n nVar = (n) arrayList.get(i);
                if (this.f1623e == nVar.f1620b) {
                    c(this.f1621c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(y.c cVar, int i) {
        int iN;
        int iN2;
        ArrayList arrayList = this.f1619a;
        if (arrayList.size() == 0) {
            return 0;
        }
        a0.e eVar = (a0.e) ((a0.d) arrayList.get(0)).T;
        cVar.t();
        eVar.b(cVar, false);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((a0.d) arrayList.get(i10)).b(cVar, false);
        }
        if (i == 0 && eVar.f74z0 > 0) {
            a0.j.a(eVar, cVar, arrayList, 0);
        }
        if (i == 1 && eVar.A0 > 0) {
            a0.j.a(eVar, cVar, arrayList, 1);
        }
        try {
            cVar.p();
        } catch (Exception e9) {
            System.err.println(e9.toString() + "\n" + Arrays.toString(e9.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.f1622d = new ArrayList();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            a0.d dVar = (a0.d) arrayList.get(i11);
            jb.b bVar = new jb.b(4);
            new WeakReference(dVar);
            y.c.n(dVar.I);
            y.c.n(dVar.J);
            y.c.n(dVar.K);
            y.c.n(dVar.L);
            y.c.n(dVar.M);
            this.f1622d.add(bVar);
        }
        if (i == 0) {
            iN = y.c.n(eVar.I);
            iN2 = y.c.n(eVar.K);
            cVar.t();
        } else {
            iN = y.c.n(eVar.J);
            iN2 = y.c.n(eVar.L);
            cVar.t();
        }
        return iN2 - iN;
    }

    public final void c(int i, n nVar) {
        int i10 = nVar.f1620b;
        ArrayList arrayList = this.f1619a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            a0.d dVar = (a0.d) obj;
            ArrayList arrayList2 = nVar.f1619a;
            if (!arrayList2.contains(dVar)) {
                arrayList2.add(dVar);
            }
            if (i == 0) {
                dVar.f51n0 = i10;
            } else {
                dVar.o0 = i10;
            }
        }
        this.f1623e = i10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.f1621c;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String strO = q4.a.o(sb, this.f1620b, "] <");
        ArrayList arrayList = this.f1619a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            strO = strO + " " + ((a0.d) obj).f40h0;
        }
        return l0.e.j(strO, " >");
    }
}
