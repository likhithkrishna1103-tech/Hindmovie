package x2;

import aa.c1;
import aa.j0;
import e6.i;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import p1.n0;
import w2.b0;
import w2.h0;
import w2.n;
import w2.o;
import w2.p;
import w2.q;
import w2.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements o {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f14208q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f14209r = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte[] f14210s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[] f14211t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f14213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14216e;
    public int f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14218h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f14219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h0 f14220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h0 f14221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b0 f14222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f14224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14225p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14212a = new byte[1];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14217g = -1;

    static {
        int i = s1.b0.f11647a;
        Charset charset = StandardCharsets.UTF_8;
        f14210s = "#!AMR\n".getBytes(charset);
        f14211t = "#!AMR-WB\n".getBytes(charset);
    }

    public a() {
        n nVar = new n();
        this.f14213b = nVar;
        this.f14221l = nVar;
    }

    public final int b(p pVar) throws n0 {
        boolean z2;
        pVar.l();
        byte[] bArr = this.f14212a;
        pVar.w(bArr, 0, 1);
        byte b10 = bArr[0];
        if ((b10 & 131) > 0) {
            throw n0.a(null, "Invalid padding bits for frame header " + ((int) b10));
        }
        int i = (b10 >> 3) & 15;
        if (i >= 0 && i <= 15 && (((z2 = this.f14214c) && (i < 10 || i > 13)) || (!z2 && (i < 12 || i > 14)))) {
            return z2 ? f14209r[i] : f14208q[i];
        }
        StringBuilder sb2 = new StringBuilder("Illegal AMR ");
        sb2.append(this.f14214c ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i);
        throw n0.a(null, sb2.toString());
    }

    @Override // w2.o
    public final void c(q qVar) {
        this.f14219j = qVar;
        h0 h0VarQ = qVar.q(0, 1);
        this.f14220k = h0VarQ;
        this.f14221l = h0VarQ;
        qVar.e();
    }

    public final boolean d(p pVar) {
        pVar.l();
        byte[] bArr = f14210s;
        byte[] bArr2 = new byte[bArr.length];
        pVar.w(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.f14214c = false;
            pVar.m(bArr.length);
            return true;
        }
        pVar.l();
        byte[] bArr3 = f14211t;
        byte[] bArr4 = new byte[bArr3.length];
        pVar.w(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f14214c = true;
        pVar.m(bArr3.length);
        return true;
    }

    @Override // w2.o
    public final boolean e(p pVar) {
        return d(pVar);
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.f14215d = 0L;
        this.f14216e = 0;
        this.f = 0;
        this.f14224o = j8;
        b0 b0Var = this.f14222m;
        if (!(b0Var instanceof y)) {
            if (j5 == 0 || !(b0Var instanceof p3.a)) {
                this.i = 0L;
                return;
            } else {
                p3.a aVar = (p3.a) b0Var;
                this.i = (Math.max(0L, j5 - aVar.f10162b) * 8000000) / ((long) aVar.f10165e);
                return;
            }
        }
        y yVar = (y) b0Var;
        i iVar = yVar.f13696b;
        long jD = iVar.f4522u == 0 ? -9223372036854775807L : iVar.d(s1.b0.b(yVar.f13695a, j5));
        this.i = jD;
        if (Math.abs(this.f14224o - jD) < 20000) {
            return;
        }
        this.f14223n = true;
        this.f14221l = this.f14213b;
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00eb A[PHI: r4
      0x00eb: PHI (r4v1 w2.p) = (r4v0 w2.p), (r4v5 w2.p) binds: [B:53:0x00e9, B:56:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r18, w2.s r19) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.a.l(w2.p, w2.s):int");
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
