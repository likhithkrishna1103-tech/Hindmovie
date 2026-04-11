package o2;

import a2.d2;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j1 implements b0, s2.h {
    public final ArrayList A = new ArrayList();
    public final long B;
    public final s2.m C;
    public final p1.q D;
    public final boolean E;
    public boolean F;
    public byte[] G;
    public int H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final v1.m f9148u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v1.g f9149v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v1.e0 f9150w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k8.a0 f9151x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final aa.l0 f9152y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final n1 f9153z;

    public j1(v1.m mVar, v1.g gVar, v1.e0 e0Var, p1.q qVar, long j5, k8.a0 a0Var, aa.l0 l0Var, boolean z2, t2.a aVar) {
        this.f9148u = mVar;
        this.f9149v = gVar;
        this.f9150w = e0Var;
        this.D = qVar;
        this.B = j5;
        this.f9151x = a0Var;
        this.f9152y = l0Var;
        this.E = z2;
        this.f9153z = new n1(new p1.g1("", qVar));
        this.C = aVar != null ? new s2.m(aVar) : new s2.m("SingleSampleMediaPeriod");
    }

    @Override // o2.e1
    public final boolean c() {
        return this.C.d();
    }

    @Override // s2.h
    public final void d(s2.j jVar, long j5, long j8) {
        i1 i1Var = (i1) jVar;
        this.H = (int) i1Var.f9140v.f13127v;
        byte[] bArr = i1Var.f9141w;
        bArr.getClass();
        this.G = bArr;
        this.F = true;
        Uri uri = i1Var.f9140v.f13128w;
        u uVar = new u(j8);
        this.f9151x.getClass();
        this.f9152y.o(uVar, 1, -1, this.D, 0, null, 0L, this.B);
    }

    @Override // o2.e1
    public final long g() {
        return (this.F || this.C.d()) ? Long.MIN_VALUE : 0L;
    }

    @Override // o2.b0
    public final long i() {
        return -9223372036854775807L;
    }

    @Override // s2.h
    public final void k(s2.j jVar, long j5, long j8, int i) {
        u uVar;
        i1 i1Var = (i1) jVar;
        v1.c0 c0Var = i1Var.f9140v;
        if (i == 0) {
            uVar = new u(i1Var.f9139u);
        } else {
            Uri uri = c0Var.f13128w;
            uVar = new u(j8);
        }
        this.f9152y.t(uVar, 1, -1, this.D, 0, null, 0L, this.B, i);
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        if (this.F) {
            return false;
        }
        s2.m mVar = this.C;
        if (mVar.d() || mVar.c()) {
            return false;
        }
        v1.h hVarG = this.f9149v.g();
        v1.e0 e0Var = this.f9150w;
        if (e0Var != null) {
            hVarG.g(e0Var);
        }
        i1 i1Var = new i1(hVarG, this.f9148u);
        this.f9151x.getClass();
        mVar.f(i1Var, this, 3);
        return true;
    }

    @Override // s2.h
    public final e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        long jMin;
        e4.f fVar;
        Uri uri = ((i1) jVar).f9140v.f13128w;
        u uVar = new u(j8);
        int i10 = s1.b0.f11647a;
        this.f9151x.getClass();
        if ((iOException instanceof p1.n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof v1.u) || (iOException instanceof s2.l)) {
            jMin = -9223372036854775807L;
            break;
        }
        int i11 = v1.j.f13143v;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof v1.j) && ((v1.j) cause).f13144u == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        boolean z2 = jMin == -9223372036854775807L || i >= 3;
        if (this.E && z2) {
            s1.b.q("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.F = true;
            fVar = s2.m.f11765y;
        } else {
            fVar = jMin != -9223372036854775807L ? new e4.f(0, jMin, false) : s2.m.f11766z;
        }
        this.f9152y.q(uVar, 1, -1, this.D, 0, null, 0L, this.B, iOException, !fVar.a());
        return fVar;
    }

    @Override // o2.b0
    public final long n(r2.r[] rVarArr, boolean[] zArr, c1[] c1VarArr, boolean[] zArr2, long j5) {
        for (int i = 0; i < rVarArr.length; i++) {
            c1 c1Var = c1VarArr[i];
            ArrayList arrayList = this.A;
            if (c1Var != null && (rVarArr[i] == null || !zArr[i])) {
                arrayList.remove(c1Var);
                c1VarArr[i] = null;
            }
            if (c1VarArr[i] == null && rVarArr[i] != null) {
                h1 h1Var = new h1(this);
                arrayList.add(h1Var);
                c1VarArr[i] = h1Var;
                zArr2[i] = true;
            }
        }
        return j5;
    }

    @Override // o2.b0
    public final void o(a0 a0Var, long j5) {
        a0Var.m(this);
    }

    @Override // o2.b0
    public final n1 p() {
        return this.f9153z;
    }

    @Override // o2.e1
    public final long r() {
        return this.F ? Long.MIN_VALUE : 0L;
    }

    @Override // o2.b0
    public final long t(long j5) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.A;
            if (i >= arrayList.size()) {
                return j5;
            }
            h1 h1Var = (h1) arrayList.get(i);
            if (h1Var.f9131u == 2) {
                h1Var.f9131u = 1;
            }
            i++;
        }
    }

    @Override // s2.h
    public final void u(s2.j jVar, long j5, long j8, boolean z2) {
        Uri uri = ((i1) jVar).f9140v.f13128w;
        u uVar = new u(j8);
        this.f9151x.getClass();
        this.f9152y.m(uVar, 1, -1, null, 0, null, 0L, this.B);
    }

    @Override // o2.b0
    public final void s() {
    }

    @Override // o2.e1
    public final void v(long j5) {
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        return j5;
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
    }
}
