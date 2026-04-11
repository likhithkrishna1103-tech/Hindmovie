package v2;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import ua.f0;
import ua.i0;
import v1.g1;
import y1.a0;
import y1.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w2.d f13069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f13070h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f13071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f13072k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f13073l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f13074m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f13075n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i0 f13076o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final v f13077p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13078q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13079r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13080s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f13081t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public t2.k f13082u;

    public b(g1 g1Var, int[] iArr, w2.d dVar, long j4, long j7, long j10, i0 i0Var) {
        super(g1Var, iArr);
        if (j10 < j4) {
            y1.b.p("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j10 = j4;
        }
        this.f13069g = dVar;
        this.f13070h = j4 * 1000;
        this.i = j7 * 1000;
        this.f13071j = j10 * 1000;
        this.f13072k = 1279;
        this.f13073l = 719;
        this.f13074m = 0.7f;
        this.f13075n = 0.75f;
        this.f13076o = i0.k(i0Var);
        this.f13077p = v.f14615a;
        this.f13078q = 1.0f;
        this.f13080s = 0;
        this.f13081t = -9223372036854775807L;
    }

    public static void v(ArrayList arrayList, long[] jArr) {
        long j4 = 0;
        for (long j7 : jArr) {
            j4 += j7;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            f0 f0Var = (f0) arrayList.get(i);
            if (f0Var != null) {
                f0Var.a(new a(j4, jArr[i]));
            }
        }
    }

    public static long x(List list) {
        if (!list.isEmpty()) {
            t2.k kVar = (t2.k) ua.q.l(list);
            long j4 = kVar.B;
            if (j4 != -9223372036854775807L) {
                long j7 = kVar.C;
                if (j7 != -9223372036854775807L) {
                    return j7 - j4;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // v2.c, v2.q
    public final void d() {
        this.f13081t = -9223372036854775807L;
        this.f13082u = null;
    }

    @Override // v2.c, v2.q
    public final int f(long j4, List list) {
        int i;
        int i10;
        this.f13077p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j7 = this.f13081t;
        if (j7 != -9223372036854775807L && jElapsedRealtime - j7 < 1000 && (list.isEmpty() || ((t2.k) ua.q.l(list)).equals(this.f13082u))) {
            return list.size();
        }
        this.f13081t = jElapsedRealtime;
        this.f13082u = list.isEmpty() ? null : (t2.k) ua.q.l(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jB = a0.B(((t2.k) list.get(size - 1)).B - j4, this.f13078q);
        long j10 = this.f13071j;
        if (jB >= j10) {
            x(list);
            v1.p pVar = this.f13086d[w(jElapsedRealtime)];
            for (int i11 = 0; i11 < size; i11++) {
                t2.k kVar = (t2.k) list.get(i11);
                v1.p pVar2 = kVar.f11851y;
                if (a0.B(kVar.B - j4, this.f13078q) >= j10 && pVar2.f12942j < pVar.f12942j && (i = pVar2.f12954v) != -1 && i <= this.f13073l && (i10 = pVar2.f12953u) != -1 && i10 <= this.f13072k && i < pVar.f12954v) {
                    return i11;
                }
            }
        }
        return size;
    }

    @Override // v2.c, v2.q
    public final void g() {
        this.f13082u = null;
    }

    @Override // v2.q
    public final int k() {
        return this.f13080s;
    }

    @Override // v2.q
    public final int l() {
        return this.f13079r;
    }

    @Override // v2.c, v2.q
    public final void o(float f) {
        this.f13078q = f;
    }

    @Override // v2.q
    public final Object p() {
        return null;
    }

    @Override // v2.q
    public final void r(long j4, long j7, long j10, List list, t2.l[] lVarArr) {
        long jX;
        this.f13077p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.f13079r;
        if (i >= lVarArr.length || !lVarArr[i].next()) {
            int length = lVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    jX = x(list);
                    break;
                }
                t2.l lVar = lVarArr[i10];
                if (lVar.next()) {
                    jX = lVar.d() - lVar.j();
                    break;
                }
                i10++;
            }
        } else {
            t2.l lVar2 = lVarArr[this.f13079r];
            jX = lVar2.d() - lVar2.j();
        }
        int i11 = this.f13080s;
        if (i11 == 0) {
            this.f13080s = 1;
            this.f13079r = w(jElapsedRealtime);
            return;
        }
        int i12 = this.f13079r;
        int iN = list.isEmpty() ? -1 : n(((t2.k) ua.q.l(list)).f11851y);
        if (iN != -1) {
            i11 = ((t2.k) ua.q.l(list)).f11852z;
            i12 = iN;
        }
        int iW = w(jElapsedRealtime);
        if (iW != i12 && !b(i12, jElapsedRealtime)) {
            v1.p[] pVarArr = this.f13086d;
            v1.p pVar = pVarArr[i12];
            v1.p pVar2 = pVarArr[iW];
            long jMin = this.f13070h;
            if (j10 != -9223372036854775807L) {
                jMin = Math.min((long) ((jX != -9223372036854775807L ? j10 - jX : j10) * this.f13075n), jMin);
            }
            int i13 = pVar2.f12942j;
            int i14 = pVar.f12942j;
            if ((i13 > i14 && j7 < jMin) || (i13 < i14 && j7 >= this.i)) {
                iW = i12;
            }
        }
        if (iW != i12) {
            i11 = 3;
        }
        this.f13080s = i11;
        this.f13079r = iW;
    }

    public final int w(long j4) {
        long j7;
        w2.g gVar = (w2.g) this.f13069g;
        synchronized (gVar) {
            j7 = gVar.f13867l;
        }
        long j10 = (long) (j7 * this.f13074m);
        this.f13069g.getClass();
        long j11 = (long) (j10 / this.f13078q);
        if (!this.f13076o.isEmpty()) {
            int i = 1;
            while (i < this.f13076o.size() - 1 && ((a) this.f13076o.get(i)).f13067a < j11) {
                i++;
            }
            a aVar = (a) this.f13076o.get(i - 1);
            a aVar2 = (a) this.f13076o.get(i);
            long j12 = aVar.f13067a;
            long j13 = aVar.f13068b;
            j11 = j13 + ((long) (((j11 - j12) / (aVar2.f13067a - j12)) * (aVar2.f13068b - j13)));
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f13084b; i11++) {
            if (j4 == Long.MIN_VALUE || !b(i11, j4)) {
                if (this.f13086d[i11].f12942j <= j11) {
                    return i11;
                }
                i10 = i11;
            }
        }
        return i10;
    }
}
