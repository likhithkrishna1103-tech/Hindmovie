package s2;

import android.net.Uri;
import g2.r1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements a0, w2.i {
    public final l1 A;
    public final ArrayList B = new ArrayList();
    public final long C;
    public final w2.o D;
    public final v1.p E;
    public final boolean F;
    public boolean G;
    public byte[] H;
    public int I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b2.o f11222v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b2.g f11223w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b2.h0 f11224x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f9.a0 f11225y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f3.a f11226z;

    public h1(b2.o oVar, b2.g gVar, b2.h0 h0Var, v1.p pVar, long j4, f9.a0 a0Var, f3.a aVar, boolean z10, x2.a aVar2) {
        this.f11222v = oVar;
        this.f11223w = gVar;
        this.f11224x = h0Var;
        this.E = pVar;
        this.C = j4;
        this.f11225y = a0Var;
        this.f11226z = aVar;
        this.F = z10;
        this.A = new l1(new v1.g1("", pVar));
        this.D = aVar2 != null ? new w2.o(aVar2) : new w2.o("SingleSampleMediaPeriod");
    }

    @Override // w2.i
    public final void B(w2.k kVar, long j4, long j7, int i) {
        t tVar;
        g1 g1Var = (g1) kVar;
        b2.f0 f0Var = g1Var.f11206w;
        if (i == 0) {
            tVar = new t(g1Var.f11205v);
        } else {
            Uri uri = f0Var.f1686x;
            tVar = new t(j7);
        }
        this.f11226z.s(tVar, 1, -1, this.E, 0, null, 0L, this.C, i);
    }

    @Override // s2.c1
    public final boolean a() {
        return this.D.d();
    }

    @Override // s2.a0
    public final void d(z zVar, long j4) {
        zVar.k(this);
    }

    @Override // w2.i
    public final i4.e g(w2.k kVar, long j4, long j7, IOException iOException, int i) {
        long jMin;
        i4.e eVar;
        Uri uri = ((g1) kVar).f11206w.f1686x;
        t tVar = new t(j7);
        int i10 = y1.a0.f14551a;
        this.f11225y.getClass();
        if ((iOException instanceof v1.n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof b2.x) || (iOException instanceof w2.n)) {
            jMin = -9223372036854775807L;
            break;
        }
        int i11 = b2.l.f1700w;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof b2.l) && ((b2.l) cause).f1701v == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        boolean z10 = jMin == -9223372036854775807L || i >= 3;
        if (this.F && z10) {
            y1.b.q("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.G = true;
            eVar = w2.o.f13883e;
        } else {
            eVar = jMin != -9223372036854775807L ? new i4.e(0, jMin, false) : w2.o.f;
        }
        this.f11226z.p(tVar, 1, -1, this.E, 0, null, 0L, this.C, iOException, !eVar.a());
        return eVar;
    }

    @Override // s2.c1
    public final boolean i(g2.s0 s0Var) {
        if (this.G) {
            return false;
        }
        w2.o oVar = this.D;
        if (oVar.d() || oVar.b()) {
            return false;
        }
        b2.h hVarH = this.f11223w.h();
        b2.h0 h0Var = this.f11224x;
        if (h0Var != null) {
            hVarH.d(h0Var);
        }
        g1 g1Var = new g1(hVarH, this.f11222v);
        this.f11225y.getClass();
        oVar.f(g1Var, this, 3);
        return true;
    }

    @Override // s2.c1
    public final long j() {
        return (this.G || this.D.d()) ? Long.MIN_VALUE : 0L;
    }

    @Override // w2.i
    public final void k(w2.k kVar, long j4, long j7) {
        g1 g1Var = (g1) kVar;
        this.I = (int) g1Var.f11206w.f1685w;
        byte[] bArr = g1Var.f11207x;
        bArr.getClass();
        this.H = bArr;
        this.G = true;
        Uri uri = g1Var.f11206w.f1686x;
        t tVar = new t(j7);
        this.f11225y.getClass();
        this.f11226z.o(tVar, 1, -1, this.E, 0, null, 0L, this.C);
    }

    @Override // s2.a0
    public final long m() {
        return -9223372036854775807L;
    }

    @Override // w2.i
    public final void n(w2.k kVar, long j4, long j7, boolean z10) {
        Uri uri = ((g1) kVar).f11206w.f1686x;
        t tVar = new t(j7);
        this.f11225y.getClass();
        this.f11226z.n(tVar, 1, -1, null, 0, null, 0L, this.C);
    }

    @Override // s2.a0
    public final l1 o() {
        return this.A;
    }

    @Override // s2.c1
    public final long q() {
        return this.G ? Long.MIN_VALUE : 0L;
    }

    @Override // s2.a0
    public final long t(long j4) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.B;
            if (i >= arrayList.size()) {
                return j4;
            }
            f1 f1Var = (f1) arrayList.get(i);
            if (f1Var.f11197v == 2) {
                f1Var.f11197v = 1;
            }
            i++;
        }
    }

    @Override // s2.a0
    public final long v(v2.q[] qVarArr, boolean[] zArr, a1[] a1VarArr, boolean[] zArr2, long j4) {
        for (int i = 0; i < qVarArr.length; i++) {
            a1 a1Var = a1VarArr[i];
            ArrayList arrayList = this.B;
            if (a1Var != null && (qVarArr[i] == null || !zArr[i])) {
                arrayList.remove(a1Var);
                a1VarArr[i] = null;
            }
            if (a1VarArr[i] == null && qVarArr[i] != null) {
                f1 f1Var = new f1(this);
                arrayList.add(f1Var);
                a1VarArr[i] = f1Var;
                zArr2[i] = true;
            }
        }
        return j4;
    }

    @Override // s2.a0
    public final void r() {
    }

    @Override // s2.c1
    public final void u(long j4) {
    }

    @Override // s2.a0
    public final long h(long j4, r1 r1Var) {
        return j4;
    }

    @Override // s2.a0
    public final void l(boolean z10, long j4) {
    }
}
