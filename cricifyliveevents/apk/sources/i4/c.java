package i4;

import a3.i0;
import a3.q;
import a3.r;
import com.google.android.material.datepicker.o;
import java.math.RoundingMode;
import v1.m0;
import v1.n0;
import v1.p;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f6193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f6194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f6195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f6196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6197e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6199h;

    public c(r rVar, i0 i0Var, o oVar, String str, int i) throws n0 {
        this.f6193a = rVar;
        this.f6194b = i0Var;
        this.f6195c = oVar;
        int i10 = oVar.f2875v;
        int i11 = oVar.f2876w;
        int i12 = (oVar.f2878y * i10) / 8;
        int i13 = oVar.f2877x;
        if (i13 != i12) {
            throw n0.a(null, "Expected block size: " + i12 + "; got: " + i13);
        }
        int i14 = i11 * i12;
        int i15 = i14 * 8;
        int iMax = Math.max(i12, i14 / 10);
        this.f6197e = iMax;
        v1.o oVar2 = new v1.o();
        oVar2.f12892l = m0.p("audio/wav");
        oVar2.f12893m = m0.p(str);
        oVar2.f12889h = i15;
        oVar2.i = i15;
        oVar2.f12894n = iMax;
        oVar2.E = i10;
        oVar2.F = i11;
        oVar2.G = i;
        this.f6196d = new p(oVar2);
    }

    @Override // i4.b
    public final void a(int i, long j4) {
        this.f6193a.s(new g(this.f6195c, 1, i, j4));
        this.f6194b.f(this.f6196d);
    }

    @Override // i4.b
    public final void b(long j4) {
        this.f = j4;
        this.f6198g = 0;
        this.f6199h = 0L;
    }

    @Override // i4.b
    public final boolean c(q qVar, long j4) {
        int i;
        int i10;
        long j7 = j4;
        while (j7 > 0 && (i = this.f6198g) < (i10 = this.f6197e)) {
            int iB = this.f6194b.b(qVar, (int) Math.min(i10 - i, j7), true);
            if (iB == -1) {
                j7 = 0;
            } else {
                this.f6198g += iB;
                j7 -= (long) iB;
            }
        }
        o oVar = this.f6195c;
        int i11 = oVar.f2877x;
        int i12 = this.f6198g / i11;
        if (i12 > 0) {
            long j10 = this.f;
            long j11 = this.f6199h;
            long j12 = oVar.f2876w;
            int i13 = a0.f14551a;
            long jW = j10 + a0.W(j11, 1000000L, j12, RoundingMode.DOWN);
            int i14 = i12 * i11;
            int i15 = this.f6198g - i14;
            this.f6194b.e(jW, 1, i14, i15, null);
            this.f6199h += (long) i12;
            this.f6198g = i15;
        }
        return j7 <= 0;
    }
}
