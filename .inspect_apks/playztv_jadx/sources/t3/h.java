package t3;

import aa.c1;
import aa.j0;
import java.util.ArrayList;
import java.util.List;
import p1.m0;
import p1.p;
import p1.q;
import s1.b0;
import s1.u;
import w2.h0;
import w2.o;
import w2.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f12081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f12082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f12083c;
    public h0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12087h;
    public long[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f12088j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f12085e = b0.f11649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f12084d = new u();

    public h(m mVar, q qVar) {
        q qVar2;
        this.f12081a = mVar;
        if (qVar != null) {
            p pVarA = qVar.a();
            pVarA.f9967m = m0.p("application/x-media3-cues");
            pVarA.f9964j = qVar.f10023n;
            pVarA.K = mVar.m();
            qVar2 = new q(pVarA);
        } else {
            qVar2 = null;
        }
        this.f12082b = qVar2;
        this.f12083c = new ArrayList();
        this.f12087h = 0;
        this.i = b0.f11650d;
        this.f12088j = -9223372036854775807L;
    }

    public final void b(g gVar) {
        s1.d.h(this.f);
        byte[] bArr = gVar.f12080v;
        int length = bArr.length;
        u uVar = this.f12084d;
        uVar.getClass();
        uVar.H(bArr.length, bArr);
        this.f.f(length, uVar);
        this.f.a(gVar.f12079u, 1, length, 0, null);
    }

    @Override // w2.o
    public final void c(w2.q qVar) {
        s1.d.g(this.f12087h == 0);
        h0 h0VarQ = qVar.q(0, 3);
        this.f = h0VarQ;
        q qVar2 = this.f12082b;
        if (qVar2 != null) {
            h0VarQ.d(qVar2);
            qVar.e();
            qVar.j(new y(-9223372036854775807L, new long[]{0}, new long[]{0}));
        }
        this.f12087h = 1;
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) {
        return true;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        int i = this.f12087h;
        s1.d.g((i == 0 || i == 5) ? false : true);
        this.f12088j = j8;
        if (this.f12087h == 2) {
            this.f12087h = 1;
        }
        if (this.f12087h == 4) {
            this.f12087h = 3;
        }
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x007e A[EXC_TOP_SPLITTER, PHI: r22
      0x007e: PHI (r22v4 int) = (r22v5 int), (r22v6 int) binds: [B:32:0x007c, B:29:0x0077] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r21, w2.s r22) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.h.l(w2.p, w2.s):int");
    }

    @Override // w2.o
    public final void release() {
        if (this.f12087h == 5) {
            return;
        }
        this.f12081a.reset();
        this.f12087h = 5;
    }

    @Override // w2.o
    public final o a() {
        return this;
    }
}
