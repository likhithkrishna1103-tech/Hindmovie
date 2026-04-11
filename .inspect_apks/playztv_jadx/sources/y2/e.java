package y2;

import java.math.RoundingMode;
import s1.b0;
import w2.a0;
import w2.c0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f14500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f14501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f14504e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14506h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14507j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14508k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f14509l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long[] f14510m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f14511n;

    public e(int i, d dVar, h0 h0Var) {
        int i10 = dVar.f14498d;
        this.f14500a = dVar;
        int iB = dVar.b();
        boolean z2 = true;
        if (iB != 1 && iB != 2) {
            z2 = false;
        }
        s1.d.b(z2);
        int i11 = (((i % 10) + 48) << 8) | ((i / 10) + 48);
        this.f14502c = (iB == 2 ? 1667497984 : 1651965952) | i11;
        long j5 = ((long) dVar.f14496b) * 1000000;
        long j8 = dVar.f14497c;
        int i12 = b0.f11647a;
        this.f14504e = b0.W(i10, j5, j8, RoundingMode.DOWN);
        this.f14501b = h0Var;
        this.f14503d = iB == 2 ? i11 | 1650720768 : -1;
        this.f14509l = -1L;
        this.f14510m = new long[512];
        this.f14511n = new int[512];
        this.f = i10;
    }

    public final c0 a(int i) {
        return new c0(((this.f14504e * ((long) 1)) / ((long) this.f)) * ((long) this.f14511n[i]), this.f14510m[i]);
    }

    public final a0 b(long j5) {
        if (this.f14508k == 0) {
            c0 c0Var = new c0(0L, this.f14509l);
            return new a0(c0Var, c0Var);
        }
        int i = (int) (j5 / ((this.f14504e * ((long) 1)) / ((long) this.f)));
        int iD = b0.d(this.f14511n, i, true, true);
        if (this.f14511n[iD] == i) {
            c0 c0VarA = a(iD);
            return new a0(c0VarA, c0VarA);
        }
        c0 c0VarA2 = a(iD);
        int i10 = iD + 1;
        return i10 < this.f14510m.length ? new a0(c0VarA2, a(i10)) : new a0(c0VarA2, c0VarA2);
    }
}
