package e4;

import java.math.RoundingMode;
import p1.m0;
import p1.n0;
import p1.p;
import s1.b0;
import w2.h0;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f4402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f4403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1.q f4404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4405e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4407h;

    public c(q qVar, h0 h0Var, e eVar, String str, int i) throws n0 {
        this.f4401a = qVar;
        this.f4402b = h0Var;
        this.f4403c = eVar;
        int i10 = eVar.f4414u;
        int i11 = eVar.f4415v;
        int i12 = (eVar.f4417x * i10) / 8;
        int i13 = eVar.f4416w;
        if (i13 != i12) {
            throw n0.a(null, "Expected block size: " + i12 + "; got: " + i13);
        }
        int i14 = i11 * i12;
        int i15 = i14 * 8;
        int iMax = Math.max(i12, i14 / 10);
        this.f4405e = iMax;
        p pVar = new p();
        pVar.f9966l = m0.p("audio/wav");
        pVar.f9967m = m0.p(str);
        pVar.f9963h = i15;
        pVar.i = i15;
        pVar.f9968n = iMax;
        pVar.E = i10;
        pVar.F = i11;
        pVar.G = i;
        this.f4404d = new p1.q(pVar);
    }

    @Override // e4.b
    public final void a(int i, long j5) {
        this.f4401a.j(new h(this.f4403c, 1, i, j5));
        this.f4402b.d(this.f4404d);
    }

    @Override // e4.b
    public final void b(long j5) {
        this.f = j5;
        this.f4406g = 0;
        this.f4407h = 0L;
    }

    @Override // e4.b
    public final boolean c(w2.p pVar, long j5) {
        int i;
        int i10;
        long j8 = j5;
        while (j8 > 0 && (i = this.f4406g) < (i10 = this.f4405e)) {
            int iC = this.f4402b.c(pVar, (int) Math.min(i10 - i, j8), true);
            if (iC == -1) {
                j8 = 0;
            } else {
                this.f4406g += iC;
                j8 -= (long) iC;
            }
        }
        e eVar = this.f4403c;
        int i11 = eVar.f4416w;
        int i12 = this.f4406g / i11;
        if (i12 > 0) {
            long j10 = this.f;
            long j11 = this.f4407h;
            long j12 = eVar.f4415v;
            int i13 = b0.f11647a;
            long jW = j10 + b0.W(j11, 1000000L, j12, RoundingMode.DOWN);
            int i14 = i12 * i11;
            int i15 = this.f4406g - i14;
            this.f4402b.a(jW, 1, i14, i15, null);
            this.f4407h += (long) i12;
            this.f4406g = i15;
        }
        return j8 <= 0;
    }
}
