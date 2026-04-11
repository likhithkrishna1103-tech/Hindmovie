package y2;

import android.view.Surface;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.Executor;
import v1.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f14636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f14637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f14638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f14639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v1.p f14640e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d0 f14641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Executor f14642h;
    public u i;

    public c(v vVar, y1.v vVar2) {
        this.f14636a = vVar;
        vVar.f14737l = vVar2;
        this.f14637b = new a0(new vb.b(8, this), vVar);
        this.f14638c = new ArrayDeque();
        this.f14640e = new v1.p(new v1.o());
        this.f = -9223372036854775807L;
        this.f14641g = d0.f14650u;
        this.f14642h = new p.a(2);
        this.i = new a();
    }

    @Override // y2.f0
    public final void a() {
        this.f14639d = null;
        this.f14636a.h(null);
    }

    @Override // y2.f0
    public final boolean b() {
        a0 a0Var = this.f14637b;
        long j4 = a0Var.i;
        return j4 != -9223372036854775807L && a0Var.f14629h == j4;
    }

    @Override // y2.f0
    public final Surface c() {
        Surface surface = this.f14639d;
        y1.d.h(surface);
        return surface;
    }

    @Override // y2.f0
    public final void d(v1.p pVar, long j4, int i, List list) {
        y1.d.g(list.isEmpty());
        int i10 = pVar.f12953u;
        int i11 = pVar.f12954v;
        v1.p pVar2 = this.f14640e;
        int i12 = pVar2.f12953u;
        a0 a0Var = this.f14637b;
        if (i10 != i12 || i11 != pVar2.f12954v) {
            pa.o oVar = a0Var.f14626d;
            long j7 = a0Var.f14628g;
            oVar.a(j7 == -9223372036854775807L ? 0L : j7 + 1, new r1(i10, i11));
        }
        float f = pVar.f12957y;
        if (f != this.f14640e.f12957y) {
            this.f14636a.g(f);
        }
        this.f14640e = pVar;
        if (j4 != this.f) {
            if (a0Var.f.f2877x == 0) {
                a0Var.f14624b.f(i);
                a0Var.f14631k = j4;
            } else {
                pa.o oVar2 = a0Var.f14627e;
                long j10 = a0Var.f14628g;
                oVar2.a(j10 == -9223372036854775807L ? -4611686018427387904L : j10 + 1, Long.valueOf(j4));
            }
            this.f = j4;
        }
    }

    @Override // y2.f0
    public final void e(float f) {
        this.f14636a.i(f);
    }

    @Override // y2.f0
    public final void f(boolean z10) {
        if (z10) {
            v vVar = this.f14636a;
            z zVar = vVar.f14729b;
            zVar.f14761m = 0L;
            zVar.f14764p = -1L;
            zVar.f14762n = -1L;
            vVar.f14734h = -9223372036854775807L;
            vVar.f = -9223372036854775807L;
            vVar.f14732e = Math.min(vVar.f14732e, 1);
            vVar.i = -9223372036854775807L;
        }
        a0 a0Var = this.f14637b;
        pa.o oVar = a0Var.f14626d;
        com.google.android.material.datepicker.o oVar2 = a0Var.f;
        oVar2.f2875v = 0;
        oVar2.f2876w = -1;
        oVar2.f2877x = 0;
        a0Var.f14628g = -9223372036854775807L;
        a0Var.f14629h = -9223372036854775807L;
        a0Var.i = -9223372036854775807L;
        pa.o oVar3 = a0Var.f14627e;
        if (oVar3.h() > 0) {
            y1.d.b(oVar3.h() > 0);
            while (oVar3.h() > 1) {
                oVar3.e();
            }
            Object objE = oVar3.e();
            objE.getClass();
            a0Var.f14631k = ((Long) objE).longValue();
        }
        if (oVar.h() > 0) {
            y1.d.b(oVar.h() > 0);
            while (oVar.h() > 1) {
                oVar.e();
            }
            Object objE2 = oVar.e();
            objE2.getClass();
            oVar.a(0L, (r1) objE2);
        }
        this.f14638c.clear();
    }

    @Override // y2.f0
    public final void g(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // y2.f0
    public final void h() {
        this.f14636a.e();
    }

    @Override // y2.f0
    public final void i(l4.a aVar) {
        this.f14641g = aVar;
        this.f14642h = ya.q.f15009v;
    }

    @Override // y2.f0
    public final void j(long j4, long j7) {
        try {
            this.f14637b.a(j4, j7);
        } catch (g2.n e9) {
            throw new e0(e9, this.f14640e);
        }
    }

    @Override // y2.f0
    public final void k(boolean z10) {
        this.f14636a.c(z10);
    }

    @Override // y2.f0
    public final boolean l(boolean z10) {
        return this.f14636a.b(z10);
    }

    @Override // y2.f0
    public final void m() {
        this.f14636a.d();
    }

    @Override // y2.f0
    public final void n(u uVar) {
        this.i = uVar;
    }

    @Override // y2.f0
    public final void o() {
        throw new UnsupportedOperationException();
    }

    @Override // y2.f0
    public final void p(Surface surface, y1.u uVar) {
        this.f14639d = surface;
        this.f14636a.h(surface);
    }

    @Override // y2.f0
    public final void q(long j4) {
        throw new UnsupportedOperationException();
    }

    @Override // y2.f0
    public final boolean r(long j4, g gVar) {
        this.f14638c.add(gVar);
        a0 a0Var = this.f14637b;
        com.google.android.material.datepicker.o oVar = a0Var.f;
        int i = oVar.f2877x;
        long[] jArr = (long[]) oVar.f2879z;
        if (i == jArr.length) {
            int length = jArr.length << 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
            long[] jArr2 = new long[length];
            int length2 = jArr.length;
            int i10 = oVar.f2875v;
            int i11 = length2 - i10;
            System.arraycopy(jArr, i10, jArr2, 0, i11);
            System.arraycopy((long[]) oVar.f2879z, 0, jArr2, i11, i10);
            oVar.f2875v = 0;
            oVar.f2876w = oVar.f2877x - 1;
            oVar.f2879z = jArr2;
            oVar.f2878y = length - 1;
        }
        int i12 = (oVar.f2876w + 1) & oVar.f2878y;
        oVar.f2876w = i12;
        ((long[]) oVar.f2879z)[i12] = j4;
        oVar.f2877x++;
        a0Var.f14628g = j4;
        a0Var.i = -9223372036854775807L;
        this.f14642h.execute(new pa.c(14, this));
        return true;
    }

    @Override // y2.f0
    public final void s() {
        a0 a0Var = this.f14637b;
        if (a0Var.f14628g == -9223372036854775807L) {
            a0Var.f14628g = Long.MIN_VALUE;
            a0Var.f14629h = Long.MIN_VALUE;
        }
        a0Var.i = a0Var.f14628g;
    }

    @Override // y2.f0
    public final boolean t(v1.p pVar) {
        return true;
    }

    @Override // y2.f0
    public final boolean u() {
        return true;
    }

    @Override // y2.f0
    public final void v() {
        v vVar = this.f14636a;
        if (vVar.f14732e == 0) {
            vVar.f14732e = 1;
        }
    }

    @Override // y2.f0
    public final void w(int i) {
        z zVar = this.f14636a.f14729b;
        if (zVar.f14758j == i) {
            return;
        }
        zVar.f14758j = i;
        zVar.d(true);
    }

    @Override // y2.f0
    public final void release() {
    }
}
