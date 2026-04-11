package b3;

import a3.c0;
import a3.i0;
import a3.o;
import a3.p;
import a3.q;
import a3.r;
import a3.z;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import ua.g0;
import ua.z0;
import v1.n0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f1734q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f1735r = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte[] f1736s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[] f1737t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f1739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1742e;
    public int f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1744h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f1745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i0 f1746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i0 f1747l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c0 f1748m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1749n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f1750o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1751p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1738a = new byte[1];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1743g = -1;

    static {
        int i = a0.f14551a;
        Charset charset = StandardCharsets.UTF_8;
        f1736s = "#!AMR\n".getBytes(charset);
        f1737t = "#!AMR-WB\n".getBytes(charset);
    }

    public a() {
        o oVar = new o();
        this.f1739b = oVar;
        this.f1747l = oVar;
    }

    public final int b(q qVar) throws n0 {
        boolean z10;
        qVar.k();
        byte[] bArr = this.f1738a;
        qVar.z(bArr, 0, 1);
        byte b8 = bArr[0];
        if ((b8 & 131) > 0) {
            throw n0.a(null, "Invalid padding bits for frame header " + ((int) b8));
        }
        int i = (b8 >> 3) & 15;
        if (i >= 0 && i <= 15 && (((z10 = this.f1740c) && (i < 10 || i > 13)) || (!z10 && (i < 12 || i > 14)))) {
            return z10 ? f1735r[i] : f1734q[i];
        }
        StringBuilder sb = new StringBuilder("Illegal AMR ");
        sb.append(this.f1740c ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i);
        throw n0.a(null, sb.toString());
    }

    @Override // a3.p
    public final void c(r rVar) {
        this.f1745j = rVar;
        i0 i0VarP = rVar.p(0, 1);
        this.f1746k = i0VarP;
        this.f1747l = i0VarP;
        rVar.e();
    }

    public final boolean d(q qVar) {
        qVar.k();
        byte[] bArr = f1736s;
        byte[] bArr2 = new byte[bArr.length];
        qVar.z(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.f1740c = false;
            qVar.n(bArr.length);
            return true;
        }
        qVar.k();
        byte[] bArr3 = f1737t;
        byte[] bArr4 = new byte[bArr3.length];
        qVar.z(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f1740c = true;
        qVar.n(bArr3.length);
        return true;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.f1741d = 0L;
        this.f1742e = 0;
        this.f = 0;
        this.f1750o = j7;
        c0 c0Var = this.f1748m;
        if (!(c0Var instanceof z)) {
            if (j4 == 0 || !(c0Var instanceof t3.a)) {
                this.i = 0L;
                return;
            } else {
                t3.a aVar = (t3.a) c0Var;
                this.i = (Math.max(0L, j4 - aVar.f11865b) * 8000000) / ((long) aVar.f11868e);
                return;
            }
        }
        z zVar = (z) c0Var;
        ag.o oVar = zVar.f259b;
        long jG = oVar.f454w == 0 ? -9223372036854775807L : oVar.g(a0.b(zVar.f258a, j4));
        this.i = jG;
        if (Math.abs(this.f1750o - jG) < 20000) {
            return;
        }
        this.f1749n = true;
        this.f1747l = this.f1739b;
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = ua.i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) {
        return d(qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00eb A[PHI: r4
      0x00eb: PHI (r4v1 a3.q) = (r4v0 a3.q), (r4v5 a3.q) binds: [B:53:0x00e9, B:56:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r18, a3.t r19) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.a.i(a3.q, a3.t):int");
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
