package t3;

import java.io.EOFException;
import p1.m0;
import p1.p;
import p1.q;
import s1.b0;
import s1.u;
import w2.g0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f12096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f12097b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f12101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f12102h;
    public boolean i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12099d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12100e = 0;
    public byte[] f = b0.f11649c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f12098c = new u();

    public n(h0 h0Var, k kVar) {
        this.f12096a = h0Var;
        this.f12097b = kVar;
    }

    @Override // w2.h0
    public final void a(long j5, int i, int i10, int i11, g0 g0Var) {
        if (this.f12101g == null) {
            this.f12096a.a(j5, i, i10, i11, g0Var);
            return;
        }
        s1.d.a("DRM on subtitles is not supported", g0Var == null);
        int i12 = (this.f12100e - i11) - i10;
        try {
            this.f12101g.n(this.f, i12, i10, l.f12093c, new b2.c(this, j5, i));
        } catch (RuntimeException e10) {
            if (!this.i) {
                throw e10;
            }
            s1.b.q("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e10);
        }
        int i13 = i12 + i10;
        this.f12099d = i13;
        if (i13 == this.f12100e) {
            this.f12099d = 0;
            this.f12100e = 0;
        }
    }

    @Override // w2.h0
    public final void b(u uVar, int i, int i10) {
        if (this.f12101g == null) {
            this.f12096a.b(uVar, i, i10);
            return;
        }
        g(i);
        uVar.h(this.f, this.f12100e, i);
        this.f12100e += i;
    }

    @Override // w2.h0
    public final int c(p1.i iVar, int i, boolean z2) {
        return e(iVar, i, z2);
    }

    @Override // w2.h0
    public final void d(q qVar) {
        qVar.f10023n.getClass();
        String str = qVar.f10023n;
        s1.d.b(m0.i(str) == 3);
        boolean zEquals = qVar.equals(this.f12102h);
        k kVar = this.f12097b;
        if (!zEquals) {
            this.f12102h = qVar;
            this.f12101g = kVar.d(qVar) ? kVar.f(qVar) : null;
        }
        m mVar = this.f12101g;
        h0 h0Var = this.f12096a;
        if (mVar == null) {
            h0Var.d(qVar);
            return;
        }
        p pVarA = qVar.a();
        pVarA.f9967m = m0.p("application/x-media3-cues");
        pVarA.f9964j = str;
        pVarA.f9972r = Long.MAX_VALUE;
        pVarA.K = kVar.e(qVar);
        e6.j.s(pVarA, h0Var);
    }

    @Override // w2.h0
    public final int e(p1.i iVar, int i, boolean z2) throws EOFException {
        if (this.f12101g == null) {
            return this.f12096a.e(iVar, i, z2);
        }
        g(i);
        int i10 = iVar.read(this.f, this.f12100e, i);
        if (i10 != -1) {
            this.f12100e += i10;
            return i10;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // w2.h0
    public final /* synthetic */ void f(int i, u uVar) {
        e6.j.b(this, uVar, i);
    }

    public final void g(int i) {
        int length = this.f.length;
        int i10 = this.f12100e;
        if (length - i10 >= i) {
            return;
        }
        int i11 = i10 - this.f12099d;
        int iMax = Math.max(i11 * 2, i + i11);
        byte[] bArr = this.f;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.f12099d, bArr2, 0, i11);
        this.f12099d = 0;
        this.f12100e = i11;
        this.f = bArr2;
    }
}
