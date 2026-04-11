package c3;

import a3.b0;
import a3.d0;
import a3.i0;
import java.math.RoundingMode;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f2079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f2082e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2084h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long[] f2088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f2089n;

    public e(int i, d dVar, i0 i0Var) {
        int i10 = dVar.f2076d;
        this.f2078a = dVar;
        int iB = dVar.b();
        boolean z10 = true;
        if (iB != 1 && iB != 2) {
            z10 = false;
        }
        y1.d.b(z10);
        int i11 = (((i % 10) + 48) << 8) | ((i / 10) + 48);
        this.f2080c = (iB == 2 ? 1667497984 : 1651965952) | i11;
        long j4 = ((long) dVar.f2074b) * 1000000;
        long j7 = dVar.f2075c;
        int i12 = a0.f14551a;
        this.f2082e = a0.W(i10, j4, j7, RoundingMode.DOWN);
        this.f2079b = i0Var;
        this.f2081d = iB == 2 ? i11 | 1650720768 : -1;
        this.f2087l = -1L;
        this.f2088m = new long[512];
        this.f2089n = new int[512];
        this.f = i10;
    }

    public final d0 a(int i) {
        return new d0(((this.f2082e * ((long) 1)) / ((long) this.f)) * ((long) this.f2089n[i]), this.f2088m[i]);
    }

    public final b0 b(long j4) {
        if (this.f2086k == 0) {
            d0 d0Var = new d0(0L, this.f2087l);
            return new b0(d0Var, d0Var);
        }
        int i = (int) (j4 / ((this.f2082e * ((long) 1)) / ((long) this.f)));
        int iD = a0.d(this.f2089n, i, true, true);
        if (this.f2089n[iD] == i) {
            d0 d0VarA = a(iD);
            return new b0(d0VarA, d0VarA);
        }
        d0 d0VarA2 = a(iD);
        int i10 = iD + 1;
        return i10 < this.f2088m.length ? new b0(d0VarA2, a(i10)) : new b0(d0VarA2, d0VarA2);
    }
}
