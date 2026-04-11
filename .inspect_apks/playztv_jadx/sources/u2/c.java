package u2;

import android.view.Surface;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.Executor;
import n.a1;
import p1.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f12557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f12558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f12559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f12560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p1.q f12561e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d0 f12562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Executor f12563h;
    public u i;

    public c(v vVar, s1.w wVar) {
        this.f12557a = vVar;
        vVar.f12661l = wVar;
        this.f12558b = new a0(new p2.c(18, this), vVar);
        this.f12559c = new ArrayDeque();
        this.f12561e = new p1.q(new p1.p());
        this.f = -9223372036854775807L;
        this.f12562g = d0.f12571s;
        this.f12563h = new n4.b(2);
        this.i = new a();
    }

    @Override // u2.f0
    public final void a() {
        this.f12560d = null;
        this.f12557a.h(null);
    }

    @Override // u2.f0
    public final boolean b() {
        a0 a0Var = this.f12558b;
        long j5 = a0Var.i;
        return j5 != -9223372036854775807L && a0Var.f12550h == j5;
    }

    @Override // u2.f0
    public final Surface c() {
        Surface surface = this.f12560d;
        s1.d.h(surface);
        return surface;
    }

    @Override // u2.f0
    public final boolean d(long j5, g gVar) {
        this.f12559c.add(gVar);
        a0 a0Var = this.f12558b;
        e4.e eVar = a0Var.f;
        int i = eVar.f4416w;
        long[] jArr = (long[]) eVar.f4418y;
        if (i == jArr.length) {
            int length = jArr.length << 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
            long[] jArr2 = new long[length];
            int length2 = jArr.length;
            int i10 = eVar.f4414u;
            int i11 = length2 - i10;
            System.arraycopy(jArr, i10, jArr2, 0, i11);
            System.arraycopy((long[]) eVar.f4418y, 0, jArr2, i11, i10);
            eVar.f4414u = 0;
            eVar.f4415v = eVar.f4416w - 1;
            eVar.f4418y = jArr2;
            eVar.f4417x = length - 1;
        }
        int i12 = (eVar.f4415v + 1) & eVar.f4417x;
        eVar.f4415v = i12;
        ((long[]) eVar.f4418y)[i12] = j5;
        eVar.f4416w++;
        a0Var.f12549g = j5;
        a0Var.i = -9223372036854775807L;
        this.f12563h.execute(new nc.b(6, this));
        return true;
    }

    @Override // u2.f0
    public final void e(boolean z2) {
        if (z2) {
            v vVar = this.f12557a;
            z zVar = vVar.f12653b;
            zVar.f12685m = 0L;
            zVar.f12688p = -1L;
            zVar.f12686n = -1L;
            vVar.f12658h = -9223372036854775807L;
            vVar.f = -9223372036854775807L;
            vVar.f12656e = Math.min(vVar.f12656e, 1);
            vVar.i = -9223372036854775807L;
        }
        a0 a0Var = this.f12558b;
        q3.d dVar = a0Var.f12547d;
        e4.e eVar = a0Var.f;
        eVar.f4414u = 0;
        eVar.f4415v = -1;
        eVar.f4416w = 0;
        a0Var.f12549g = -9223372036854775807L;
        a0Var.f12550h = -9223372036854775807L;
        a0Var.i = -9223372036854775807L;
        q3.d dVar2 = a0Var.f12548e;
        if (dVar2.h() > 0) {
            s1.d.b(dVar2.h() > 0);
            while (dVar2.h() > 1) {
                dVar2.e();
            }
            Object objE = dVar2.e();
            objE.getClass();
            a0Var.f12552k = ((Long) objE).longValue();
        }
        if (dVar.h() > 0) {
            s1.d.b(dVar.h() > 0);
            while (dVar.h() > 1) {
                dVar.e();
            }
            Object objE2 = dVar.e();
            objE2.getClass();
            dVar.a(0L, (r1) objE2);
        }
        this.f12559c.clear();
    }

    @Override // u2.f0
    public final void f(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // u2.f0
    public final void g() {
        this.f12557a.e();
    }

    @Override // u2.f0
    public final void h(u uVar) {
        this.i = uVar;
    }

    @Override // u2.f0
    public final void i(float f) {
        this.f12557a.i(f);
    }

    @Override // u2.f0
    public final void j(long j5, long j8) throws e0 {
        try {
            this.f12558b.a(j5, j8);
        } catch (a2.q e10) {
            throw new e0(e10, this.f12561e);
        }
    }

    @Override // u2.f0
    public final void k(Surface surface, s1.v vVar) {
        this.f12560d = surface;
        this.f12557a.h(surface);
    }

    @Override // u2.f0
    public final void l(boolean z2) {
        this.f12557a.c(z2);
    }

    @Override // u2.f0
    public final boolean m(boolean z2) {
        return this.f12557a.b(z2);
    }

    @Override // u2.f0
    public final void n() {
        this.f12557a.d();
    }

    @Override // u2.f0
    public final void o() {
        throw new UnsupportedOperationException();
    }

    @Override // u2.f0
    public final void p(a1 a1Var) {
        this.f12562g = a1Var;
        this.f12563h = ea.r.f4628u;
    }

    @Override // u2.f0
    public final void q(p1.q qVar, long j5, int i, List list) {
        s1.d.g(list.isEmpty());
        int i10 = qVar.f10030u;
        int i11 = qVar.f10031v;
        p1.q qVar2 = this.f12561e;
        int i12 = qVar2.f10030u;
        a0 a0Var = this.f12558b;
        if (i10 != i12 || i11 != qVar2.f10031v) {
            q3.d dVar = a0Var.f12547d;
            long j8 = a0Var.f12549g;
            dVar.a(j8 == -9223372036854775807L ? 0L : j8 + 1, new r1(i10, i11));
        }
        float f = qVar.f10034y;
        if (f != this.f12561e.f10034y) {
            this.f12557a.g(f);
        }
        this.f12561e = qVar;
        if (j5 != this.f) {
            if (a0Var.f.f4416w == 0) {
                a0Var.f12545b.f(i);
                a0Var.f12552k = j5;
            } else {
                q3.d dVar2 = a0Var.f12548e;
                long j10 = a0Var.f12549g;
                dVar2.a(j10 == -9223372036854775807L ? -4611686018427387904L : j10 + 1, Long.valueOf(j5));
            }
            this.f = j5;
        }
    }

    @Override // u2.f0
    public final void r(long j5) {
        throw new UnsupportedOperationException();
    }

    @Override // u2.f0
    public final void s() {
        a0 a0Var = this.f12558b;
        if (a0Var.f12549g == -9223372036854775807L) {
            a0Var.f12549g = Long.MIN_VALUE;
            a0Var.f12550h = Long.MIN_VALUE;
        }
        a0Var.i = a0Var.f12549g;
    }

    @Override // u2.f0
    public final boolean t() {
        return true;
    }

    @Override // u2.f0
    public final void u() {
        v vVar = this.f12557a;
        if (vVar.f12656e == 0) {
            vVar.f12656e = 1;
        }
    }

    @Override // u2.f0
    public final boolean v(p1.q qVar) {
        return true;
    }

    @Override // u2.f0
    public final void w(int i) {
        z zVar = this.f12557a.f12653b;
        if (zVar.f12682j == i) {
            return;
        }
        zVar.f12682j = i;
        zVar.d(true);
    }

    @Override // u2.f0
    public final void release() {
    }
}
