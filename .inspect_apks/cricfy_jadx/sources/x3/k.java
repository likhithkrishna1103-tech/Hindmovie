package x3;

import a3.i0;
import a3.r;
import a3.z;
import java.util.ArrayList;
import java.util.List;
import ua.g0;
import ua.z0;
import v1.m0;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements a3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f14302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1.p f14303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f14304c;
    public i0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14308h;
    public long[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f14309j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f14306e = a0.f14553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f14305d = new t();

    public k(p pVar, v1.p pVar2) {
        v1.p pVar3;
        this.f14302a = pVar;
        if (pVar2 != null) {
            v1.o oVarA = pVar2.a();
            oVarA.f12893m = m0.p("application/x-media3-cues");
            oVarA.f12890j = pVar2.f12946n;
            oVarA.K = pVar.D();
            pVar3 = new v1.p(oVarA);
        } else {
            pVar3 = null;
        }
        this.f14303b = pVar3;
        this.f14304c = new ArrayList();
        this.f14308h = 0;
        this.i = a0.f14554d;
        this.f14309j = -9223372036854775807L;
    }

    public final void b(j jVar) {
        y1.d.h(this.f);
        byte[] bArr = jVar.f14301w;
        int length = bArr.length;
        t tVar = this.f14305d;
        tVar.getClass();
        tVar.H(bArr.length, bArr);
        this.f.a(length, tVar);
        this.f.e(jVar.f14300v, 1, length, 0, null);
    }

    @Override // a3.p
    public final void c(r rVar) {
        y1.d.g(this.f14308h == 0);
        i0 i0VarP = rVar.p(0, 3);
        this.f = i0VarP;
        v1.p pVar = this.f14303b;
        if (pVar != null) {
            i0VarP.f(pVar);
            rVar.e();
            rVar.s(new z(-9223372036854775807L, new long[]{0}, new long[]{0}));
        }
        this.f14308h = 1;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        int i = this.f14308h;
        y1.d.g((i == 0 || i == 5) ? false : true);
        this.f14309j = j7;
        if (this.f14308h == 2) {
            this.f14308h = 1;
        }
        if (this.f14308h == 4) {
            this.f14308h = 3;
        }
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = ua.i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(a3.q qVar) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x007e A[EXC_TOP_SPLITTER, PHI: r22
      0x007e: PHI (r22v4 int) = (r22v5 int), (r22v6 int) binds: [B:32:0x007c, B:29:0x0077] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r21, a3.t r22) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.k.i(a3.q, a3.t):int");
    }

    @Override // a3.p
    public final void release() {
        if (this.f14308h == 5) {
            return;
        }
        this.f14302a.reset();
        this.f14308h = 5;
    }

    @Override // a3.p
    public final a3.p a() {
        return this;
    }
}
