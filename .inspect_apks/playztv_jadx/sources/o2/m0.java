package o2;

import a2.d2;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements b0, a0 {
    public a0 A;
    public n1 B;
    public b0[] C;
    public n D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b0[] f9163u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean[] f9164v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final IdentityHashMap f9165w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k8.c0 f9166x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f9167y = new ArrayList();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap f9168z = new HashMap();

    public m0(k8.c0 c0Var, long[] jArr, b0... b0VarArr) {
        this.f9166x = c0Var;
        this.f9163u = b0VarArr;
        c0Var.getClass();
        aa.h0 h0Var = aa.j0.f690v;
        aa.c1 c1Var = aa.c1.f650y;
        this.D = new n(c1Var, c1Var);
        this.f9165w = new IdentityHashMap();
        this.C = new b0[0];
        this.f9164v = new boolean[b0VarArr.length];
        for (int i = 0; i < b0VarArr.length; i++) {
            long j5 = jArr[i];
            if (j5 != 0) {
                this.f9164v[i] = true;
                this.f9163u[i] = new m1(b0VarArr[i], j5);
            }
        }
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        b0[] b0VarArr = this.C;
        return (b0VarArr.length > 0 ? b0VarArr[0] : this.f9163u[0]).a(j5, d2Var);
    }

    @Override // o2.e1
    public final boolean c() {
        return this.D.c();
    }

    @Override // o2.d1
    public final void d(e1 e1Var) {
        a0 a0Var = this.A;
        a0Var.getClass();
        a0Var.d(this);
    }

    @Override // o2.e1
    public final long g() {
        return this.D.g();
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
        for (b0 b0Var : this.C) {
            b0Var.h(z2, j5);
        }
    }

    @Override // o2.b0
    public final long i() {
        long j5 = -9223372036854775807L;
        for (b0 b0Var : this.C) {
            long jI = b0Var.i();
            if (jI == -9223372036854775807L) {
                if (j5 != -9223372036854775807L && b0Var.t(j5) != j5) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j5 == -9223372036854775807L) {
                for (b0 b0Var2 : this.C) {
                    if (b0Var2 == b0Var) {
                        break;
                    }
                    if (b0Var2.t(jI) != jI) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j5 = jI;
            } else if (jI != j5) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j5;
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        ArrayList arrayList = this.f9167y;
        if (arrayList.isEmpty()) {
            return this.D.l(c1Var);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((b0) arrayList.get(i)).l(c1Var);
        }
        return false;
    }

    @Override // o2.a0
    public final void m(b0 b0Var) {
        ArrayList arrayList = this.f9167y;
        arrayList.remove(b0Var);
        if (arrayList.isEmpty()) {
            b0[] b0VarArr = this.f9163u;
            int i = 0;
            for (b0 b0Var2 : b0VarArr) {
                i += b0Var2.p().f9178a;
            }
            p1.g1[] g1VarArr = new p1.g1[i];
            int i10 = 0;
            for (int i11 = 0; i11 < b0VarArr.length; i11++) {
                n1 n1VarP = b0VarArr[i11].p();
                int i12 = n1VarP.f9178a;
                int i13 = 0;
                while (i13 < i12) {
                    p1.g1 g1VarA = n1VarP.a(i13);
                    int i14 = g1VarA.f9762a;
                    p1.q[] qVarArr = new p1.q[i14];
                    for (int i15 = 0; i15 < i14; i15++) {
                        p1.q qVar = g1VarA.f9765d[i15];
                        p1.p pVarA = qVar.a();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i11);
                        sb2.append(":");
                        String str = qVar.f10012a;
                        if (str == null) {
                            str = "";
                        }
                        sb2.append(str);
                        pVarA.f9957a = sb2.toString();
                        qVarArr[i15] = new p1.q(pVarA);
                    }
                    p1.g1 g1Var = new p1.g1(i11 + ":" + g1VarA.f9763b, qVarArr);
                    this.f9168z.put(g1Var, g1VarA);
                    g1VarArr[i10] = g1Var;
                    i13++;
                    i10++;
                }
            }
            this.B = new n1(g1VarArr);
            a0 a0Var = this.A;
            a0Var.getClass();
            a0Var.m(this);
        }
    }

    @Override // o2.b0
    public final long n(r2.r[] rVarArr, boolean[] zArr, c1[] c1VarArr, boolean[] zArr2, long j5) {
        IdentityHashMap identityHashMap;
        int[] iArr;
        int[] iArr2 = new int[rVarArr.length];
        int[] iArr3 = new int[rVarArr.length];
        int i = 0;
        int i10 = 0;
        while (true) {
            int length = rVarArr.length;
            identityHashMap = this.f9165w;
            if (i10 >= length) {
                break;
            }
            c1 c1Var = c1VarArr[i10];
            Integer num = c1Var == null ? null : (Integer) identityHashMap.get(c1Var);
            iArr2[i10] = num == null ? -1 : num.intValue();
            r2.r rVar = rVarArr[i10];
            if (rVar != null) {
                String str = rVar.k().f9763b;
                iArr3[i10] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr3[i10] = -1;
            }
            i10++;
        }
        identityHashMap.clear();
        int length2 = rVarArr.length;
        c1[] c1VarArr2 = new c1[length2];
        c1[] c1VarArr3 = new c1[rVarArr.length];
        r2.r[] rVarArr2 = new r2.r[rVarArr.length];
        b0[] b0VarArr = this.f9163u;
        ArrayList arrayList = new ArrayList(b0VarArr.length);
        long j8 = j5;
        int i11 = 0;
        while (i11 < b0VarArr.length) {
            int i12 = i;
            while (i12 < rVarArr.length) {
                c1VarArr3[i12] = iArr2[i12] == i11 ? c1VarArr[i12] : null;
                if (iArr3[i12] == i11) {
                    r2.r rVar2 = rVarArr[i12];
                    rVar2.getClass();
                    iArr = iArr2;
                    p1.g1 g1Var = (p1.g1) this.f9168z.get(rVar2.k());
                    g1Var.getClass();
                    rVarArr2[i12] = new l0(rVar2, g1Var);
                } else {
                    iArr = iArr2;
                    rVarArr2[i12] = null;
                }
                i12++;
                iArr2 = iArr;
            }
            int[] iArr4 = iArr2;
            b0[] b0VarArr2 = b0VarArr;
            int i13 = i11;
            long jN = b0VarArr2[i11].n(rVarArr2, zArr, c1VarArr3, zArr2, j8);
            if (i13 == 0) {
                j8 = jN;
            } else if (jN != j8) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i14 = 0; i14 < rVarArr.length; i14++) {
                if (iArr3[i14] == i13) {
                    c1 c1Var2 = c1VarArr3[i14];
                    c1Var2.getClass();
                    c1VarArr2[i14] = c1VarArr3[i14];
                    identityHashMap.put(c1Var2, Integer.valueOf(i13));
                    z2 = true;
                } else if (iArr4[i14] == i13) {
                    s1.d.g(c1VarArr3[i14] == null);
                }
            }
            if (z2) {
                arrayList.add(b0VarArr2[i13]);
            }
            i11 = i13 + 1;
            b0VarArr = b0VarArr2;
            iArr2 = iArr4;
            i = 0;
        }
        int i15 = i;
        System.arraycopy(c1VarArr2, i15, c1VarArr, i15, length2);
        this.C = (b0[]) arrayList.toArray(new b0[i15]);
        AbstractList abstractListV = aa.q.v(arrayList, new ia.b(6));
        this.f9166x.getClass();
        this.D = new n(arrayList, abstractListV);
        return j8;
    }

    @Override // o2.b0
    public final void o(a0 a0Var, long j5) {
        this.A = a0Var;
        ArrayList arrayList = this.f9167y;
        b0[] b0VarArr = this.f9163u;
        Collections.addAll(arrayList, b0VarArr);
        for (b0 b0Var : b0VarArr) {
            b0Var.o(this, j5);
        }
    }

    @Override // o2.b0
    public final n1 p() {
        n1 n1Var = this.B;
        n1Var.getClass();
        return n1Var;
    }

    @Override // o2.e1
    public final long r() {
        return this.D.r();
    }

    @Override // o2.b0
    public final void s() {
        for (b0 b0Var : this.f9163u) {
            b0Var.s();
        }
    }

    @Override // o2.b0
    public final long t(long j5) {
        long jT = this.C[0].t(j5);
        int i = 1;
        while (true) {
            b0[] b0VarArr = this.C;
            if (i >= b0VarArr.length) {
                return jT;
            }
            if (b0VarArr[i].t(jT) != jT) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // o2.e1
    public final void v(long j5) {
        this.D.v(j5);
    }
}
