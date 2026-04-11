package m2;

import a2.d2;
import aa.c1;
import aa.h0;
import aa.j0;
import aa.l0;
import com.bumptech.glide.manager.s;
import f2.k;
import java.util.AbstractList;
import java.util.ArrayList;
import k8.c0;
import o2.a0;
import o2.b0;
import o2.d1;
import o2.e1;
import o2.n;
import o2.n1;
import p1.g1;
import p1.m0;
import p1.p;
import p1.q;
import p2.i;
import r2.r;
import s2.e;
import v1.e0;
import v1.g;
import v1.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements b0, d1 {
    public final l0 A;
    public final e B;
    public final n1 C;
    public final c0 D;
    public a0 E;
    public n2.c F;
    public i[] G;
    public n H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s f8296u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e0 f8297v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s2.n f8298w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f2.n f8299x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final k f8300y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final k8.a0 f8301z;

    public b(n2.c cVar, s sVar, e0 e0Var, c0 c0Var, f2.n nVar, k kVar, k8.a0 a0Var, l0 l0Var, s2.n nVar2, e eVar) {
        this.F = cVar;
        this.f8296u = sVar;
        this.f8297v = e0Var;
        this.f8298w = nVar2;
        this.f8299x = nVar;
        this.f8300y = kVar;
        this.f8301z = a0Var;
        this.A = l0Var;
        this.B = eVar;
        this.D = c0Var;
        g1[] g1VarArr = new g1[cVar.f.length];
        int i = 0;
        while (true) {
            n2.b[] bVarArr = cVar.f;
            if (i >= bVarArr.length) {
                this.C = new n1(g1VarArr);
                this.G = new i[0];
                c0Var.getClass();
                h0 h0Var = j0.f690v;
                c1 c1Var = c1.f650y;
                this.H = new n(c1Var, c1Var);
                return;
            }
            q[] qVarArr = bVarArr[i].f8648j;
            q[] qVarArr2 = new q[qVarArr.length];
            for (int i10 = 0; i10 < qVarArr.length; i10++) {
                q qVar = qVarArr[i10];
                p pVarA = qVar.a();
                pVarA.N = nVar.f(qVar);
                q qVar2 = new q(pVarA);
                if (sVar.f2862w && ((k8.b0) sVar.f2861v).d(qVar2)) {
                    p pVarA2 = qVar2.a();
                    pVarA2.f9967m = m0.p("application/x-media3-cues");
                    pVarA2.K = ((k8.b0) sVar.f2861v).e(qVar2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(qVar2.f10023n);
                    String str = qVar2.f10020k;
                    sb2.append(str != null ? " ".concat(str) : "");
                    pVarA2.f9964j = sb2.toString();
                    pVarA2.f9972r = Long.MAX_VALUE;
                    qVar2 = new q(pVarA2);
                }
                qVarArr2[i10] = qVar2;
            }
            g1VarArr[i] = new g1(Integer.toString(i), qVarArr2);
            i++;
        }
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        for (i iVar : this.G) {
            if (iVar.f10154u == 2) {
                return iVar.f10158y.a(j5, d2Var);
            }
        }
        return j5;
    }

    @Override // o2.e1
    public final boolean c() {
        return this.H.c();
    }

    @Override // o2.d1
    public final void d(e1 e1Var) {
        a0 a0Var = this.E;
        a0Var.getClass();
        a0Var.d(this);
    }

    @Override // o2.e1
    public final long g() {
        return this.H.g();
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
        for (i iVar : this.G) {
            iVar.h(z2, j5);
        }
    }

    @Override // o2.b0
    public final long i() {
        return -9223372036854775807L;
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        return this.H.l(c1Var);
    }

    @Override // o2.b0
    public final long n(r[] rVarArr, boolean[] zArr, o2.c1[] c1VarArr, boolean[] zArr2, long j5) {
        int i;
        r rVar;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < rVarArr.length) {
            o2.c1 c1Var = c1VarArr[i10];
            if (c1Var != null) {
                i iVar = (i) c1Var;
                r rVar2 = rVarArr[i10];
                if (rVar2 == null || !zArr[i10]) {
                    iVar.C(null);
                    c1VarArr[i10] = null;
                } else {
                    ((a) iVar.f10158y).f8293e = rVar2;
                    arrayList.add(iVar);
                }
            }
            if (c1VarArr[i10] != null || (rVar = rVarArr[i10]) == null) {
                i = i10;
            } else {
                int iB = this.C.b(rVar.k());
                n2.c cVar = this.F;
                s sVar = this.f8296u;
                h hVarG = ((g) sVar.f2863x).g();
                e0 e0Var = this.f8297v;
                if (e0Var != null) {
                    hVarG.g(e0Var);
                }
                i = i10;
                i iVar2 = new i(this.F.f[iB].f8641a, null, null, new a(this.f8298w, cVar, iB, rVar, hVarG, (k8.b0) sVar.f2861v, sVar.f2862w), this, this.B, j5, this.f8299x, this.f8300y, this.f8301z, this.A, false);
                arrayList.add(iVar2);
                c1VarArr[i] = iVar2;
                zArr2[i] = true;
            }
            i10 = i + 1;
        }
        i[] iVarArr = new i[arrayList.size()];
        this.G = iVarArr;
        arrayList.toArray(iVarArr);
        AbstractList abstractListV = aa.q.v(arrayList, new ia.b(3));
        this.D.getClass();
        this.H = new n(arrayList, abstractListV);
        return j5;
    }

    @Override // o2.b0
    public final void o(a0 a0Var, long j5) {
        this.E = a0Var;
        a0Var.m(this);
    }

    @Override // o2.b0
    public final n1 p() {
        return this.C;
    }

    @Override // o2.e1
    public final long r() {
        return this.H.r();
    }

    @Override // o2.b0
    public final void s() {
        this.f8298w.b();
    }

    @Override // o2.b0
    public final long t(long j5) {
        for (i iVar : this.G) {
            iVar.D(j5);
        }
        return j5;
    }

    @Override // o2.e1
    public final void v(long j5) {
        this.H.v(j5);
    }
}
