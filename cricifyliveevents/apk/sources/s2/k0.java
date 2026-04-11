package s2;

import g2.r1;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements a0, z {
    public z B;
    public l1 C;
    public a0[] D;
    public n E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a0[] f11248v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean[] f11249w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final IdentityHashMap f11250x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f9.z f11251y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f11252z = new ArrayList();
    public final HashMap A = new HashMap();

    public k0(f9.z zVar, long[] jArr, a0... a0VarArr) {
        this.f11251y = zVar;
        this.f11248v = a0VarArr;
        zVar.getClass();
        ua.g0 g0Var = ua.i0.f12341w;
        ua.z0 z0Var = ua.z0.f12413z;
        this.E = new n(z0Var, z0Var);
        this.f11250x = new IdentityHashMap();
        this.D = new a0[0];
        this.f11249w = new boolean[a0VarArr.length];
        for (int i = 0; i < a0VarArr.length; i++) {
            long j4 = jArr[i];
            if (j4 != 0) {
                this.f11249w[i] = true;
                this.f11248v[i] = new k1(a0VarArr[i], j4);
            }
        }
    }

    @Override // s2.c1
    public final boolean a() {
        return this.E.a();
    }

    @Override // s2.a0
    public final void d(z zVar, long j4) {
        this.B = zVar;
        ArrayList arrayList = this.f11252z;
        a0[] a0VarArr = this.f11248v;
        Collections.addAll(arrayList, a0VarArr);
        for (a0 a0Var : a0VarArr) {
            a0Var.d(this, j4);
        }
    }

    @Override // s2.b1
    public final void f(c1 c1Var) {
        z zVar = this.B;
        zVar.getClass();
        zVar.f(this);
    }

    @Override // s2.a0
    public final long h(long j4, r1 r1Var) {
        a0[] a0VarArr = this.D;
        return (a0VarArr.length > 0 ? a0VarArr[0] : this.f11248v[0]).h(j4, r1Var);
    }

    @Override // s2.c1
    public final boolean i(g2.s0 s0Var) {
        ArrayList arrayList = this.f11252z;
        if (arrayList.isEmpty()) {
            return this.E.i(s0Var);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((a0) arrayList.get(i)).i(s0Var);
        }
        return false;
    }

    @Override // s2.c1
    public final long j() {
        return this.E.j();
    }

    @Override // s2.z
    public final void k(a0 a0Var) {
        ArrayList arrayList = this.f11252z;
        arrayList.remove(a0Var);
        if (arrayList.isEmpty()) {
            a0[] a0VarArr = this.f11248v;
            int i = 0;
            for (a0 a0Var2 : a0VarArr) {
                i += a0Var2.o().f11262a;
            }
            v1.g1[] g1VarArr = new v1.g1[i];
            int i10 = 0;
            for (int i11 = 0; i11 < a0VarArr.length; i11++) {
                l1 l1VarO = a0VarArr[i11].o();
                int i12 = l1VarO.f11262a;
                int i13 = 0;
                while (i13 < i12) {
                    v1.g1 g1VarA = l1VarO.a(i13);
                    int i14 = g1VarA.f12702a;
                    v1.p[] pVarArr = new v1.p[i14];
                    for (int i15 = 0; i15 < i14; i15++) {
                        v1.p pVar = g1VarA.f12705d[i15];
                        v1.o oVarA = pVar.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append(i11);
                        sb.append(":");
                        String str = pVar.f12935a;
                        if (str == null) {
                            str = "";
                        }
                        sb.append(str);
                        oVarA.f12883a = sb.toString();
                        pVarArr[i15] = new v1.p(oVarA);
                    }
                    v1.g1 g1Var = new v1.g1(i11 + ":" + g1VarA.f12703b, pVarArr);
                    this.A.put(g1Var, g1VarA);
                    g1VarArr[i10] = g1Var;
                    i13++;
                    i10++;
                }
            }
            this.C = new l1(g1VarArr);
            z zVar = this.B;
            zVar.getClass();
            zVar.k(this);
        }
    }

    @Override // s2.a0
    public final void l(boolean z10, long j4) {
        for (a0 a0Var : this.D) {
            a0Var.l(z10, j4);
        }
    }

    @Override // s2.a0
    public final long m() {
        long j4 = -9223372036854775807L;
        for (a0 a0Var : this.D) {
            long jM = a0Var.m();
            if (jM == -9223372036854775807L) {
                if (j4 != -9223372036854775807L && a0Var.t(j4) != j4) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j4 == -9223372036854775807L) {
                for (a0 a0Var2 : this.D) {
                    if (a0Var2 == a0Var) {
                        break;
                    }
                    if (a0Var2.t(jM) != jM) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j4 = jM;
            } else if (jM != j4) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j4;
    }

    @Override // s2.a0
    public final l1 o() {
        l1 l1Var = this.C;
        l1Var.getClass();
        return l1Var;
    }

    @Override // s2.c1
    public final long q() {
        return this.E.q();
    }

    @Override // s2.a0
    public final void r() {
        for (a0 a0Var : this.f11248v) {
            a0Var.r();
        }
    }

    @Override // s2.a0
    public final long t(long j4) {
        long jT = this.D[0].t(j4);
        int i = 1;
        while (true) {
            a0[] a0VarArr = this.D;
            if (i >= a0VarArr.length) {
                return jT;
            }
            if (a0VarArr[i].t(jT) != jT) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // s2.c1
    public final void u(long j4) {
        this.E.u(j4);
    }

    @Override // s2.a0
    public final long v(v2.q[] qVarArr, boolean[] zArr, a1[] a1VarArr, boolean[] zArr2, long j4) {
        IdentityHashMap identityHashMap;
        int[] iArr;
        int[] iArr2 = new int[qVarArr.length];
        int[] iArr3 = new int[qVarArr.length];
        int i = 0;
        int i10 = 0;
        while (true) {
            int length = qVarArr.length;
            identityHashMap = this.f11250x;
            if (i10 >= length) {
                break;
            }
            a1 a1Var = a1VarArr[i10];
            Integer num = a1Var == null ? null : (Integer) identityHashMap.get(a1Var);
            iArr2[i10] = num == null ? -1 : num.intValue();
            v2.q qVar = qVarArr[i10];
            if (qVar != null) {
                String str = qVar.i().f12703b;
                iArr3[i10] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr3[i10] = -1;
            }
            i10++;
        }
        identityHashMap.clear();
        int length2 = qVarArr.length;
        a1[] a1VarArr2 = new a1[length2];
        a1[] a1VarArr3 = new a1[qVarArr.length];
        v2.q[] qVarArr2 = new v2.q[qVarArr.length];
        a0[] a0VarArr = this.f11248v;
        ArrayList arrayList = new ArrayList(a0VarArr.length);
        long j7 = j4;
        int i11 = 0;
        while (i11 < a0VarArr.length) {
            int i12 = i;
            while (i12 < qVarArr.length) {
                a1VarArr3[i12] = iArr2[i12] == i11 ? a1VarArr[i12] : null;
                if (iArr3[i12] == i11) {
                    v2.q qVar2 = qVarArr[i12];
                    qVar2.getClass();
                    iArr = iArr2;
                    v1.g1 g1Var = (v1.g1) this.A.get(qVar2.i());
                    g1Var.getClass();
                    qVarArr2[i12] = new j0(qVar2, g1Var);
                } else {
                    iArr = iArr2;
                    qVarArr2[i12] = null;
                }
                i12++;
                iArr2 = iArr;
            }
            int[] iArr4 = iArr2;
            a0[] a0VarArr2 = a0VarArr;
            int i13 = i11;
            long jV = a0VarArr2[i11].v(qVarArr2, zArr, a1VarArr3, zArr2, j7);
            if (i13 == 0) {
                j7 = jV;
            } else if (jV != j7) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z10 = false;
            for (int i14 = 0; i14 < qVarArr.length; i14++) {
                if (iArr3[i14] == i13) {
                    a1 a1Var2 = a1VarArr3[i14];
                    a1Var2.getClass();
                    a1VarArr2[i14] = a1VarArr3[i14];
                    identityHashMap.put(a1Var2, Integer.valueOf(i13));
                    z10 = true;
                } else if (iArr4[i14] == i13) {
                    y1.d.g(a1VarArr3[i14] == null);
                }
            }
            if (z10) {
                arrayList.add(a0VarArr2[i13]);
            }
            i11 = i13 + 1;
            a0VarArr = a0VarArr2;
            iArr2 = iArr4;
            i = 0;
        }
        int i15 = i;
        System.arraycopy(a1VarArr2, i15, a1VarArr, i15, length2);
        this.D = (a0[]) arrayList.toArray(new a0[i15]);
        AbstractList abstractListW = ua.q.w(arrayList, new nc.l(19));
        this.f11251y.getClass();
        this.E = new n(arrayList, abstractListW);
        return j7;
    }
}
