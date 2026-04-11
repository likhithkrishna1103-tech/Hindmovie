package x3;

import a3.h0;
import a3.i0;
import java.io.EOFException;
import v1.m0;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f14317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f14318b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f14322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v1.p f14323h;
    public boolean i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14320d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14321e = 0;
    public byte[] f = a0.f14553c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f14319c = new t();

    public q(i0 i0Var, n nVar) {
        this.f14317a = i0Var;
        this.f14318b = nVar;
    }

    @Override // a3.i0
    public final /* synthetic */ void a(int i, t tVar) {
        q4.a.a(this, tVar, i);
    }

    @Override // a3.i0
    public final int b(v1.h hVar, int i, boolean z10) {
        return d(hVar, i, z10);
    }

    @Override // a3.i0
    public final void c(t tVar, int i, int i10) {
        if (this.f14322g == null) {
            this.f14317a.c(tVar, i, i10);
            return;
        }
        g(i);
        tVar.h(this.f, this.f14321e, i);
        this.f14321e += i;
    }

    @Override // a3.i0
    public final int d(v1.h hVar, int i, boolean z10) throws EOFException {
        if (this.f14322g == null) {
            return this.f14317a.d(hVar, i, z10);
        }
        g(i);
        int i10 = hVar.read(this.f, this.f14321e, i);
        if (i10 != -1) {
            this.f14321e += i10;
            return i10;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // a3.i0
    public final void e(long j4, int i, int i10, int i11, h0 h0Var) {
        if (this.f14322g == null) {
            this.f14317a.e(j4, i, i10, i11, h0Var);
            return;
        }
        y1.d.a("DRM on subtitles is not supported", h0Var == null);
        int i12 = (this.f14321e - i11) - i10;
        try {
            this.f14322g.C(this.f, i12, i10, o.f14314c, new h2.c(this, j4, i));
        } catch (RuntimeException e9) {
            if (!this.i) {
                throw e9;
            }
            y1.b.q("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e9);
        }
        int i13 = i12 + i10;
        this.f14320d = i13;
        if (i13 == this.f14321e) {
            this.f14320d = 0;
            this.f14321e = 0;
        }
    }

    @Override // a3.i0
    public final void f(v1.p pVar) {
        pVar.f12946n.getClass();
        String str = pVar.f12946n;
        y1.d.b(m0.i(str) == 3);
        boolean zEquals = pVar.equals(this.f14323h);
        n nVar = this.f14318b;
        if (!zEquals) {
            this.f14323h = pVar;
            this.f14322g = nVar.e(pVar) ? nVar.c(pVar) : null;
        }
        p pVar2 = this.f14322g;
        i0 i0Var = this.f14317a;
        if (pVar2 == null) {
            i0Var.f(pVar);
            return;
        }
        v1.o oVarA = pVar.a();
        oVarA.f12893m = m0.p("application/x-media3-cues");
        oVarA.f12890j = str;
        oVarA.f12898r = Long.MAX_VALUE;
        oVarA.K = nVar.b(pVar);
        l0.e.s(oVarA, i0Var);
    }

    public final void g(int i) {
        int length = this.f.length;
        int i10 = this.f14321e;
        if (length - i10 >= i) {
            return;
        }
        int i11 = i10 - this.f14320d;
        int iMax = Math.max(i11 * 2, i + i11);
        byte[] bArr = this.f;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.f14320d, bArr2, 0, i11);
        this.f14320d = 0;
        this.f14321e = i11;
        this.f = bArr2;
    }
}
