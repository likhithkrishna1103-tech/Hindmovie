package r2;

import aa.g0;
import aa.j0;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import p1.g1;
import s1.b0;
import s1.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s2.d f11292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f11293h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f11294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f11295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f11296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f11297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f11298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j0 f11299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final w f11300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f11301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f11302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f11304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public p2.m f11305u;

    public b(g1 g1Var, int[] iArr, s2.d dVar, long j5, long j8, long j10, j0 j0Var) {
        super(g1Var, iArr);
        if (j10 < j5) {
            s1.b.p("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j10 = j5;
        }
        this.f11292g = dVar;
        this.f11293h = j5 * 1000;
        this.i = j8 * 1000;
        this.f11294j = j10 * 1000;
        this.f11295k = 1279;
        this.f11296l = 719;
        this.f11297m = 0.7f;
        this.f11298n = 0.75f;
        this.f11299o = j0.r(j0Var);
        this.f11300p = w.f11715a;
        this.f11301q = 1.0f;
        this.f11303s = 0;
        this.f11304t = -9223372036854775807L;
    }

    public static void v(ArrayList arrayList, long[] jArr) {
        long j5 = 0;
        for (long j8 : jArr) {
            j5 += j8;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            g0 g0Var = (g0) arrayList.get(i);
            if (g0Var != null) {
                g0Var.a(new a(j5, jArr[i]));
            }
        }
    }

    public static long x(List list) {
        if (!list.isEmpty()) {
            p2.m mVar = (p2.m) aa.q.k(list);
            long j5 = mVar.A;
            if (j5 != -9223372036854775807L) {
                long j8 = mVar.B;
                if (j8 != -9223372036854775807L) {
                    return j8 - j5;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // r2.c, r2.r
    public final void d() {
        this.f11304t = -9223372036854775807L;
        this.f11305u = null;
    }

    @Override // r2.c, r2.r
    public final int f(long j5, List list) {
        int i;
        int i10;
        this.f11300p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j8 = this.f11304t;
        if (j8 != -9223372036854775807L && jElapsedRealtime - j8 < 1000 && (list.isEmpty() || ((p2.m) aa.q.k(list)).equals(this.f11305u))) {
            return list.size();
        }
        this.f11304t = jElapsedRealtime;
        this.f11305u = list.isEmpty() ? null : (p2.m) aa.q.k(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jB = b0.B(((p2.m) list.get(size - 1)).A - j5, this.f11301q);
        long j10 = this.f11294j;
        if (jB >= j10) {
            x(list);
            p1.q qVar = this.f11309d[w(jElapsedRealtime)];
            for (int i11 = 0; i11 < size; i11++) {
                p2.m mVar = (p2.m) list.get(i11);
                p1.q qVar2 = mVar.f10146x;
                if (b0.B(mVar.A - j5, this.f11301q) >= j10 && qVar2.f10019j < qVar.f10019j && (i = qVar2.f10031v) != -1 && i <= this.f11296l && (i10 = qVar2.f10030u) != -1 && i10 <= this.f11295k && i < qVar.f10031v) {
                    return i11;
                }
            }
        }
        return size;
    }

    @Override // r2.c, r2.r
    public final void h() {
        this.f11305u = null;
    }

    @Override // r2.r
    public final int m() {
        return this.f11303s;
    }

    @Override // r2.r
    public final int n() {
        return this.f11302r;
    }

    @Override // r2.c, r2.r
    public final void p(float f) {
        this.f11301q = f;
    }

    @Override // r2.r
    public final Object q() {
        return null;
    }

    @Override // r2.r
    public final void s(long j5, long j8, long j10, List list, p2.n[] nVarArr) {
        long jX;
        this.f11300p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.f11302r;
        if (i >= nVarArr.length || !nVarArr[i].next()) {
            int length = nVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    jX = x(list);
                    break;
                }
                p2.n nVar = nVarArr[i10];
                if (nVar.next()) {
                    jX = nVar.b() - nVar.e();
                    break;
                }
                i10++;
            }
        } else {
            p2.n nVar2 = nVarArr[this.f11302r];
            jX = nVar2.b() - nVar2.e();
        }
        int i11 = this.f11303s;
        if (i11 == 0) {
            this.f11303s = 1;
            this.f11302r = w(jElapsedRealtime);
            return;
        }
        int i12 = this.f11302r;
        int iG = list.isEmpty() ? -1 : g(((p2.m) aa.q.k(list)).f10146x);
        if (iG != -1) {
            i11 = ((p2.m) aa.q.k(list)).f10147y;
            i12 = iG;
        }
        int iW = w(jElapsedRealtime);
        if (iW != i12 && !b(i12, jElapsedRealtime)) {
            p1.q[] qVarArr = this.f11309d;
            p1.q qVar = qVarArr[i12];
            p1.q qVar2 = qVarArr[iW];
            long jMin = this.f11293h;
            if (j10 != -9223372036854775807L) {
                jMin = Math.min((long) ((jX != -9223372036854775807L ? j10 - jX : j10) * this.f11298n), jMin);
            }
            int i13 = qVar2.f10019j;
            int i14 = qVar.f10019j;
            if ((i13 > i14 && j8 < jMin) || (i13 < i14 && j8 >= this.i)) {
                iW = i12;
            }
        }
        if (iW != i12) {
            i11 = 3;
        }
        this.f11303s = i11;
        this.f11302r = iW;
    }

    public final int w(long j5) {
        long j8;
        s2.g gVar = (s2.g) this.f11292g;
        synchronized (gVar) {
            j8 = gVar.f11754l;
        }
        long j10 = (long) (j8 * this.f11297m);
        this.f11292g.getClass();
        long j11 = (long) (j10 / this.f11301q);
        if (!this.f11299o.isEmpty()) {
            int i = 1;
            while (i < this.f11299o.size() - 1 && ((a) this.f11299o.get(i)).f11290a < j11) {
                i++;
            }
            a aVar = (a) this.f11299o.get(i - 1);
            a aVar2 = (a) this.f11299o.get(i);
            long j12 = aVar.f11290a;
            long j13 = aVar.f11291b;
            j11 = j13 + ((long) (((j11 - j12) / (aVar2.f11290a - j12)) * (aVar2.f11291b - j13)));
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f11307b; i11++) {
            if (j5 == Long.MIN_VALUE || !b(i11, j5)) {
                if (this.f11309d[i11].f10019j <= j11) {
                    return i11;
                }
                i10 = i11;
            }
        }
        return i10;
    }
}
