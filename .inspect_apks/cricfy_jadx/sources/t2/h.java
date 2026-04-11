package t2;

import a3.c0;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.o4;
import f9.a0;
import f9.r;
import f9.s0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l2.n;
import nb.w;
import s2.a1;
import s2.c1;
import s2.t;
import s2.z0;
import v1.p;
import w2.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements a1, c1, w2.i, w2.l {
    public final j2.b A;
    public final f3.a B;
    public final a0 C;
    public final o D = new o("ChunkSampleStream");
    public final o4 E = new o4();
    public final ArrayList F;
    public final List G;
    public final z0 H;
    public final z0[] I;
    public final w J;
    public e K;
    public p L;
    public g M;
    public long N;
    public long O;
    public int P;
    public a Q;
    public boolean R;
    public boolean S;
    public boolean T;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11858v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int[] f11859w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p[] f11860x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean[] f11861y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j2.k f11862z;

    public h(int i, int[] iArr, p[] pVarArr, j2.k kVar, j2.b bVar, w2.e eVar, long j4, n nVar, l2.k kVar2, a0 a0Var, f3.a aVar, boolean z10) {
        this.f11858v = i;
        this.f11859w = iArr;
        this.f11860x = pVarArr;
        this.f11862z = kVar;
        this.A = bVar;
        this.B = aVar;
        this.C = a0Var;
        this.R = z10;
        ArrayList arrayList = new ArrayList();
        this.F = arrayList;
        this.G = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.I = new z0[length];
        this.f11861y = new boolean[length];
        int i10 = length + 1;
        int[] iArr2 = new int[i10];
        z0[] z0VarArr = new z0[i10];
        nVar.getClass();
        z0 z0Var = new z0(eVar, nVar, kVar2);
        this.H = z0Var;
        int i11 = 0;
        iArr2[0] = i;
        z0VarArr[0] = z0Var;
        while (i11 < length) {
            z0 z0Var2 = new z0(eVar, null, null);
            this.I[i11] = z0Var2;
            int i12 = i11 + 1;
            z0VarArr[i12] = z0Var2;
            iArr2[i12] = this.f11859w[i11];
            i11 = i12;
        }
        this.J = new w(20, iArr2, z0VarArr);
        this.N = j4;
        this.O = j4;
    }

    public final int A(int i, int i10) {
        ArrayList arrayList;
        do {
            i10++;
            arrayList = this.F;
            if (i10 >= arrayList.size()) {
                return arrayList.size() - 1;
            }
        } while (((a) arrayList.get(i10)).e(0) <= i);
        return i10 - 1;
    }

    @Override // w2.i
    public final void B(w2.k kVar, long j4, long j7, int i) {
        t tVar;
        e eVar = (e) kVar;
        if (i == 0) {
            long j10 = eVar.f11848v;
            tVar = new t(eVar.f11849w);
        } else {
            long j11 = eVar.f11848v;
            Uri uri = eVar.D.f1686x;
            tVar = new t(j7);
        }
        t tVar2 = tVar;
        this.B.s(tVar2, eVar.f11850x, this.f11858v, eVar.f11851y, eVar.f11852z, eVar.A, eVar.B, eVar.C, i);
    }

    public final void C(j2.b bVar) {
        this.M = bVar;
        z0 z0Var = this.H;
        z0Var.k();
        l2.h hVar = z0Var.f11379h;
        if (hVar != null) {
            hVar.c(z0Var.f11377e);
            z0Var.f11379h = null;
            z0Var.f11378g = null;
        }
        for (z0 z0Var2 : this.I) {
            z0Var2.k();
            l2.h hVar2 = z0Var2.f11379h;
            if (hVar2 != null) {
                hVar2.c(z0Var2.f11377e);
                z0Var2.f11379h = null;
                z0Var2.f11378g = null;
            }
        }
        this.D.e(this);
    }

    @Override // s2.c1
    public final boolean a() {
        return this.D.d();
    }

    @Override // s2.a1
    public final boolean b() {
        return !y() && this.H.x(this.T);
    }

    @Override // s2.a1
    public final void c() throws IOException {
        o oVar = this.D;
        oVar.c();
        this.H.z();
        if (oVar.d()) {
            return;
        }
        j2.k kVar = this.f11862z;
        s2.b bVar = kVar.f6568m;
        if (bVar != null) {
            throw bVar;
        }
        kVar.f6558a.c();
    }

    @Override // s2.a1
    public final int e(long j4) {
        if (y()) {
            return 0;
        }
        boolean z10 = this.T;
        z0 z0Var = this.H;
        int iV = z0Var.v(z10, j4);
        a aVar = this.Q;
        if (aVar != null) {
            iV = Math.min(iV, aVar.e(0) - z0Var.t());
        }
        z0Var.H(iV);
        z();
        return iV;
    }

    @Override // w2.l
    public final void f() {
        z0 z0Var = this.H;
        z0Var.D(true);
        l2.h hVar = z0Var.f11379h;
        if (hVar != null) {
            hVar.c(z0Var.f11377e);
            z0Var.f11379h = null;
            z0Var.f11378g = null;
        }
        for (z0 z0Var2 : this.I) {
            z0Var2.D(true);
            l2.h hVar2 = z0Var2.f11379h;
            if (hVar2 != null) {
                hVar2.c(z0Var2.f11377e);
                z0Var2.f11379h = null;
                z0Var2.f11378g = null;
            }
        }
        for (r rVar : this.f11862z.i) {
            d dVar = (d) rVar.f4361y;
            if (dVar != null) {
                dVar.f11843v.release();
            }
        }
        g gVar = this.M;
        if (gVar != null) {
            j2.b bVar = (j2.b) gVar;
            synchronized (bVar) {
                j2.n nVar = (j2.n) bVar.I.remove(this);
                if (nVar != null) {
                    z0 z0Var3 = nVar.f6577a;
                    z0Var3.D(true);
                    l2.h hVar3 = z0Var3.f11379h;
                    if (hVar3 != null) {
                        hVar3.c(z0Var3.f11377e);
                        z0Var3.f11379h = null;
                        z0Var3.f11378g = null;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x022d  */
    @Override // w2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i4.e g(w2.k r23, long r24, long r26, java.io.IOException r28, int r29) {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.h.g(w2.k, long, long, java.io.IOException, int):i4.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:177:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x040d  */
    @Override // s2.c1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(g2.s0 r59) {
        /*
            Method dump skipped, instruction units count: 1170
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.h.i(g2.s0):boolean");
    }

    @Override // s2.c1
    public final long j() {
        if (y()) {
            return this.N;
        }
        if (this.T) {
            return Long.MIN_VALUE;
        }
        return w().C;
    }

    @Override // w2.i
    public final void k(w2.k kVar, long j4, long j7) {
        e eVar = (e) kVar;
        this.K = null;
        j2.k kVar2 = this.f11862z;
        r[] rVarArr = kVar2.i;
        if (eVar instanceof j) {
            int iN = kVar2.f6565j.n(((j) eVar).f11851y);
            r rVar = rVarArr[iN];
            if (((j2.i) rVar.B) == null) {
                d dVar = (d) rVar.f4361y;
                y1.d.h(dVar);
                c0 c0Var = dVar.C;
                a3.k kVar3 = c0Var instanceof a3.k ? (a3.k) c0Var : null;
                if (kVar3 != null) {
                    k2.m mVar = (k2.m) rVar.f4362z;
                    rVarArr[iN] = new r(rVar.f4359w, mVar, (k2.b) rVar.A, (d) rVar.f4361y, rVar.f4360x, new s0(kVar3, mVar.f6874x, 5));
                }
            }
        }
        j2.n nVar = kVar2.f6564h;
        if (nVar != null) {
            long j10 = nVar.f6580d;
            if (j10 == -9223372036854775807L || eVar.C > j10) {
                nVar.f6580d = eVar.C;
            }
            nVar.f6581e.B = true;
        }
        long j11 = eVar.f11848v;
        Uri uri = eVar.D.f1686x;
        t tVar = new t(j7);
        this.C.getClass();
        this.B.o(tVar, eVar.f11850x, this.f11858v, eVar.f11851y, eVar.f11852z, eVar.A, eVar.B, eVar.C);
        this.A.f(this);
    }

    @Override // w2.i
    public final void n(w2.k kVar, long j4, long j7, boolean z10) {
        e eVar = (e) kVar;
        this.K = null;
        this.Q = null;
        long j10 = eVar.f11848v;
        Uri uri = eVar.D.f1686x;
        t tVar = new t(j7);
        this.C.getClass();
        this.B.n(tVar, eVar.f11850x, this.f11858v, eVar.f11851y, eVar.f11852z, eVar.A, eVar.B, eVar.C);
        if (z10) {
            return;
        }
        if (y()) {
            this.H.D(false);
            for (z0 z0Var : this.I) {
                z0Var.D(false);
            }
        } else if (eVar instanceof a) {
            ArrayList arrayList = this.F;
            s(arrayList.size() - 1);
            if (arrayList.isEmpty()) {
                this.N = this.O;
            }
        }
        this.A.f(this);
    }

    @Override // s2.a1
    public final int p(l4.c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (y()) {
            return -3;
        }
        a aVar = this.Q;
        z0 z0Var = this.H;
        if (aVar != null && aVar.e(0) <= z0Var.t()) {
            return -3;
        }
        z();
        return z0Var.C(c0Var, decoderInputBuffer, i, this.T);
    }

    @Override // s2.c1
    public final long q() {
        if (this.T) {
            return Long.MIN_VALUE;
        }
        if (y()) {
            return this.N;
        }
        long jMax = this.O;
        a aVarW = w();
        if (!aVarW.c()) {
            ArrayList arrayList = this.F;
            aVarW = arrayList.size() > 1 ? (a) arrayList.get(arrayList.size() - 2) : null;
        }
        if (aVarW != null) {
            jMax = Math.max(jMax, aVarW.C);
        }
        return Math.max(jMax, this.H.q());
    }

    public final a s(int i) {
        ArrayList arrayList = this.F;
        a aVar = (a) arrayList.get(i);
        y1.a0.T(arrayList, i, arrayList.size());
        this.P = Math.max(this.P, arrayList.size());
        int i10 = 0;
        this.H.n(aVar.e(0));
        while (true) {
            z0[] z0VarArr = this.I;
            if (i10 >= z0VarArr.length) {
                return aVar;
            }
            z0 z0Var = z0VarArr[i10];
            i10++;
            z0Var.n(aVar.e(i10));
        }
    }

    @Override // s2.c1
    public final void u(long j4) {
        o oVar = this.D;
        if (oVar.b() || y()) {
            return;
        }
        boolean zD = oVar.d();
        List list = this.G;
        j2.k kVar = this.f11862z;
        ArrayList arrayList = this.F;
        if (zD) {
            e eVar = this.K;
            eVar.getClass();
            boolean z10 = eVar instanceof a;
            if (z10 && x(arrayList.size() - 1)) {
                return;
            }
            if (kVar.f6568m == null ? kVar.f6565j.t(j4, eVar, list) : false) {
                oVar.a();
                if (z10) {
                    this.Q = (a) eVar;
                    return;
                }
                return;
            }
            return;
        }
        int size = (kVar.f6568m != null || kVar.f6565j.length() < 2) ? list.size() : kVar.f6565j.f(j4, list);
        if (size < arrayList.size()) {
            y1.d.g(!oVar.d());
            int size2 = arrayList.size();
            while (true) {
                if (size >= size2) {
                    size = -1;
                    break;
                } else if (!x(size)) {
                    break;
                } else {
                    size++;
                }
            }
            if (size == -1) {
                return;
            }
            long j7 = w().C;
            a aVarS = s(size);
            if (arrayList.isEmpty()) {
                this.N = this.O;
            }
            this.T = false;
            this.B.z(this.f11858v, aVarS.B, j7);
        }
    }

    public final a w() {
        return (a) this.F.get(r0.size() - 1);
    }

    public final boolean x(int i) {
        int iT;
        a aVar = (a) this.F.get(i);
        if (this.H.t() > aVar.e(0)) {
            return true;
        }
        int i10 = 0;
        do {
            z0[] z0VarArr = this.I;
            if (i10 >= z0VarArr.length) {
                return false;
            }
            iT = z0VarArr[i10].t();
            i10++;
        } while (iT <= aVar.e(i10));
        return true;
    }

    public final boolean y() {
        return this.N != -9223372036854775807L;
    }

    public final void z() {
        int iA = A(this.H.t(), this.P - 1);
        while (true) {
            int i = this.P;
            if (i > iA) {
                return;
            }
            this.P = i + 1;
            a aVar = (a) this.F.get(i);
            p pVar = aVar.f11851y;
            if (!pVar.equals(this.L)) {
                this.B.f(this.f11858v, pVar, aVar.f11852z, aVar.A, aVar.B);
            }
            this.L = pVar;
        }
    }
}
