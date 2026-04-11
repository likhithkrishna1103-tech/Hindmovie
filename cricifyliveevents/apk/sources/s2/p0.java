package s2;

import android.net.Uri;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 implements w2.k {
    public volatile boolean B;
    public long D;
    public b2.o E;
    public a3.i0 F;
    public boolean G;
    public final /* synthetic */ s0 H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Uri f11292v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b2.f0 f11293w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l7.a f11294x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s0 f11295y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final y1.g f11296z;
    public final a3.t A = new a3.t();
    public boolean C = true;

    public p0(s0 s0Var, Uri uri, b2.h hVar, l7.a aVar, s0 s0Var2, y1.g gVar) {
        this.H = s0Var;
        this.f11292v = uri;
        this.f11293w = new b2.f0(hVar);
        this.f11294x = aVar;
        this.f11295y = s0Var2;
        this.f11296z = gVar;
        t.f11325b.getAndIncrement();
        this.E = b(0L);
    }

    @Override // w2.k
    public final void a() {
        b2.h sVar;
        a3.p pVar;
        int i;
        int i10 = 0;
        while (i10 == 0 && !this.B) {
            try {
                long j4 = this.A.f227a;
                b2.o oVarB = b(j4);
                this.E = oVarB;
                long jB = this.f11293w.B(oVarB);
                if (this.B) {
                    if (i10 != 1 && this.f11294x.t() != -1) {
                        this.A.f227a = this.f11294x.t();
                    }
                    u8.a.g(this.f11293w);
                    return;
                }
                if (jB != -1) {
                    jB += j4;
                    s0 s0Var = this.H;
                    s0Var.M.post(new n0(s0Var, 0));
                }
                long j7 = jB;
                this.H.O = n3.b.d(this.f11293w.f1684v.j());
                b2.f0 f0Var = this.f11293w;
                n3.b bVar = this.H.O;
                if (bVar == null || (i = bVar.f) == -1) {
                    sVar = f0Var;
                } else {
                    sVar = new s(f0Var, i, this);
                    a3.i0 i0VarD = this.H.D(new r0(0, true));
                    this.F = i0VarD;
                    i0VarD.f(s0.f11308m0);
                }
                this.f11294x.C(sVar, this.f11292v, this.f11293w.f1684v.j(), j4, j7, this.f11295y);
                if (this.H.O != null && (pVar = (a3.p) this.f11294x.f7867x) != null) {
                    a3.p pVarA = pVar.a();
                    if (pVarA instanceof t3.d) {
                        ((t3.d) pVarA).f11892r = true;
                    }
                }
                if (this.C) {
                    l7.a aVar = this.f11294x;
                    long j10 = this.D;
                    a3.p pVar2 = (a3.p) aVar.f7867x;
                    pVar2.getClass();
                    pVar2.e(j4, j10);
                    this.C = false;
                }
                while (i10 == 0 && !this.B) {
                    try {
                        y1.g gVar = this.f11296z;
                        synchronized (gVar) {
                            while (!gVar.f14576b) {
                                gVar.f14575a.getClass();
                                gVar.wait();
                            }
                        }
                        l7.a aVar2 = this.f11294x;
                        a3.t tVar = this.A;
                        a3.p pVar3 = (a3.p) aVar2.f7867x;
                        pVar3.getClass();
                        a3.l lVar = (a3.l) aVar2.f7868y;
                        lVar.getClass();
                        i10 = pVar3.i(lVar, tVar);
                        long jT = this.f11294x.t();
                        if (jT > this.H.E + j4) {
                            this.f11296z.d();
                            s0 s0Var2 = this.H;
                            s0Var2.M.post(s0Var2.L);
                            j4 = jT;
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                if (i10 == 1) {
                    i10 = 0;
                } else if (this.f11294x.t() != -1) {
                    this.A.f227a = this.f11294x.t();
                }
                u8.a.g(this.f11293w);
            } catch (Throwable th) {
                if (i10 != 1 && this.f11294x.t() != -1) {
                    this.A.f227a = this.f11294x.t();
                }
                u8.a.g(this.f11293w);
                throw th;
            }
        }
    }

    public final b2.o b(long j4) {
        Map map = Collections.EMPTY_MAP;
        String str = this.H.D;
        Map map2 = s0.f11307l0;
        Uri uri = this.f11292v;
        y1.d.i(uri, "The uri must be set.");
        return new b2.o(uri, 0L, 1, null, map2, j4, -1L, str, 6);
    }

    @Override // w2.k
    public final void d() {
        this.B = true;
    }
}
