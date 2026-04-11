package r2;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.List;
import p1.g1;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f11306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f11308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1.q[] f11309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f11310e;
    public int f;

    public c(g1 g1Var, int[] iArr) {
        int i = 0;
        s1.d.g(iArr.length > 0);
        g1Var.getClass();
        this.f11306a = g1Var;
        int length = iArr.length;
        this.f11307b = length;
        this.f11309d = new p1.q[length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            this.f11309d[i10] = g1Var.f9765d[iArr[i10]];
        }
        Arrays.sort(this.f11309d, new c4.d(9));
        this.f11308c = new int[this.f11307b];
        while (true) {
            int i11 = this.f11307b;
            if (i >= i11) {
                this.f11310e = new long[i11];
                return;
            } else {
                this.f11308c[i] = g1Var.a(this.f11309d[i]);
                i++;
            }
        }
    }

    @Override // r2.r
    public final boolean b(int i, long j5) {
        return this.f11310e[i] > j5;
    }

    @Override // r2.r
    public final p1.q c(int i) {
        return this.f11309d[i];
    }

    @Override // r2.r
    public final int e(int i) {
        return this.f11308c[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f11306a.equals(cVar.f11306a) && Arrays.equals(this.f11308c, cVar.f11308c)) {
                return true;
            }
        }
        return false;
    }

    @Override // r2.r
    public int f(long j5, List list) {
        return list.size();
    }

    @Override // r2.r
    public final int g(p1.q qVar) {
        for (int i = 0; i < this.f11307b; i++) {
            if (this.f11309d[i] == qVar) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.f == 0) {
            this.f = Arrays.hashCode(this.f11308c) + (System.identityHashCode(this.f11306a) * 31);
        }
        return this.f;
    }

    @Override // r2.r
    public final /* synthetic */ boolean i(long j5, p2.f fVar, List list) {
        return false;
    }

    @Override // r2.r
    public final int j() {
        return this.f11308c[n()];
    }

    @Override // r2.r
    public final g1 k() {
        return this.f11306a;
    }

    @Override // r2.r
    public final p1.q l() {
        return this.f11309d[n()];
    }

    @Override // r2.r
    public final int length() {
        return this.f11308c.length;
    }

    @Override // r2.r
    public final boolean o(int i, long j5) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zB = b(i, jElapsedRealtime);
        int i10 = 0;
        while (i10 < this.f11307b && !zB) {
            zB = (i10 == i || b(i10, jElapsedRealtime)) ? false : true;
            i10++;
        }
        if (!zB) {
            return false;
        }
        long[] jArr = this.f11310e;
        long j8 = jArr[i];
        int i11 = b0.f11647a;
        long j10 = jElapsedRealtime + j5;
        if (((j5 ^ j10) & (jElapsedRealtime ^ j10)) < 0) {
            j10 = Long.MAX_VALUE;
        }
        jArr[i] = Math.max(j8, j10);
        return true;
    }

    @Override // r2.r
    public final int u(int i) {
        for (int i10 = 0; i10 < this.f11307b; i10++) {
            if (this.f11308c[i10] == i) {
                return i10;
            }
        }
        return -1;
    }

    @Override // r2.r
    public void d() {
    }

    @Override // r2.r
    public void h() {
    }

    @Override // r2.r
    public final /* synthetic */ void r() {
    }

    @Override // r2.r
    public final /* synthetic */ void t() {
    }

    @Override // r2.r
    public final void a(boolean z2) {
    }

    @Override // r2.r
    public void p(float f) {
    }
}
