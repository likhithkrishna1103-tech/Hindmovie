package v2;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.List;
import v1.g1;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f13083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f13085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v1.p[] f13086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f13087e;
    public int f;

    public c(g1 g1Var, int[] iArr) {
        int i = 0;
        y1.d.g(iArr.length > 0);
        g1Var.getClass();
        this.f13083a = g1Var;
        int length = iArr.length;
        this.f13084b = length;
        this.f13086d = new v1.p[length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            this.f13086d[i10] = g1Var.f12705d[iArr[i10]];
        }
        Arrays.sort(this.f13086d, new g4.d(11));
        this.f13085c = new int[this.f13084b];
        while (true) {
            int i11 = this.f13084b;
            if (i >= i11) {
                this.f13087e = new long[i11];
                return;
            } else {
                this.f13085c[i] = g1Var.a(this.f13086d[i]);
                i++;
            }
        }
    }

    @Override // v2.q
    public final boolean b(int i, long j4) {
        return this.f13087e[i] > j4;
    }

    @Override // v2.q
    public final v1.p c(int i) {
        return this.f13086d[i];
    }

    @Override // v2.q
    public final int e(int i) {
        return this.f13085c[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f13083a.equals(cVar.f13083a) && Arrays.equals(this.f13085c, cVar.f13085c)) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.q
    public int f(long j4, List list) {
        return list.size();
    }

    @Override // v2.q
    public final int h() {
        return this.f13085c[l()];
    }

    public final int hashCode() {
        if (this.f == 0) {
            this.f = Arrays.hashCode(this.f13085c) + (System.identityHashCode(this.f13083a) * 31);
        }
        return this.f;
    }

    @Override // v2.q
    public final g1 i() {
        return this.f13083a;
    }

    @Override // v2.q
    public final v1.p j() {
        return this.f13086d[l()];
    }

    @Override // v2.q
    public final int length() {
        return this.f13085c.length;
    }

    @Override // v2.q
    public final boolean m(int i, long j4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zB = b(i, jElapsedRealtime);
        int i10 = 0;
        while (i10 < this.f13084b && !zB) {
            zB = (i10 == i || b(i10, jElapsedRealtime)) ? false : true;
            i10++;
        }
        if (!zB) {
            return false;
        }
        long[] jArr = this.f13087e;
        long j7 = jArr[i];
        int i11 = a0.f14551a;
        long j10 = jElapsedRealtime + j4;
        if (((j4 ^ j10) & (jElapsedRealtime ^ j10)) < 0) {
            j10 = Long.MAX_VALUE;
        }
        jArr[i] = Math.max(j7, j10);
        return true;
    }

    @Override // v2.q
    public final int n(v1.p pVar) {
        for (int i = 0; i < this.f13084b; i++) {
            if (this.f13086d[i] == pVar) {
                return i;
            }
        }
        return -1;
    }

    @Override // v2.q
    public final /* synthetic */ boolean t(long j4, t2.e eVar, List list) {
        return false;
    }

    @Override // v2.q
    public final int u(int i) {
        for (int i10 = 0; i10 < this.f13084b; i10++) {
            if (this.f13085c[i10] == i) {
                return i10;
            }
        }
        return -1;
    }

    @Override // v2.q
    public void d() {
    }

    @Override // v2.q
    public void g() {
    }

    @Override // v2.q
    public final /* synthetic */ void q() {
    }

    @Override // v2.q
    public final /* synthetic */ void s() {
    }

    @Override // v2.q
    public final void a(boolean z10) {
    }

    @Override // v2.q
    public void o(float f) {
    }
}
