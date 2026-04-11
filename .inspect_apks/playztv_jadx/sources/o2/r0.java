package o2;

import android.net.Uri;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r0 implements s2.j {
    public volatile boolean A;
    public long C;
    public v1.m D;
    public w2.h0 E;
    public boolean F;
    public final /* synthetic */ u0 G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Uri f9200u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v1.c0 f9201v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final kc.b f9202w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final u0 f9203x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s1.g f9204y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final w2.s f9205z = new w2.s();
    public boolean B = true;

    public r0(u0 u0Var, Uri uri, v1.h hVar, kc.b bVar, u0 u0Var2, s1.g gVar) {
        this.G = u0Var;
        this.f9200u = uri;
        this.f9201v = new v1.c0(hVar);
        this.f9202w = bVar;
        this.f9203x = u0Var2;
        this.f9204y = gVar;
        u.f9216b.getAndIncrement();
        this.D = a(0L);
    }

    public final v1.m a(long j5) {
        Map map = Collections.EMPTY_MAP;
        String str = this.G.C;
        Map map2 = u0.f9218k0;
        Uri uri = this.f9200u;
        s1.d.i(uri, "The uri must be set.");
        return new v1.m(uri, 0L, 1, null, map2, j5, -1L, str, 6);
    }

    @Override // s2.j
    public final void b() {
        v1.h tVar;
        w2.o oVar;
        int i;
        int iL = 0;
        while (iL == 0 && !this.A) {
            try {
                long j5 = this.f9205z.f13664a;
                v1.m mVarA = a(j5);
                this.D = mVarA;
                long jH = this.f9201v.h(mVarA);
                if (this.A) {
                    if (iL != 1 && this.f9202w.r() != -1) {
                        this.f9205z.f13664a = this.f9202w.r();
                    }
                    com.bumptech.glide.c.f(this.f9201v);
                    return;
                }
                if (jH != -1) {
                    jH += j5;
                    u0 u0Var = this.G;
                    u0Var.L.post(new p0(u0Var, 0));
                }
                long j8 = jH;
                this.G.N = j3.b.d(this.f9201v.f13126u.k());
                v1.c0 c0Var = this.f9201v;
                j3.b bVar = this.G.N;
                if (bVar == null || (i = bVar.f) == -1) {
                    tVar = c0Var;
                } else {
                    tVar = new t(c0Var, i, this);
                    w2.h0 h0VarD = this.G.D(new t0(0, true));
                    this.E = h0VarD;
                    h0VarD.d(u0.l0);
                }
                this.f9202w.z(tVar, this.f9200u, this.f9201v.f13126u.k(), j5, j8, this.f9203x);
                if (this.G.N != null && (oVar = (w2.o) this.f9202w.f7621w) != null) {
                    w2.o oVarA = oVar.a();
                    if (oVarA instanceof p3.d) {
                        ((p3.d) oVarA).f10189r = true;
                    }
                }
                if (this.B) {
                    kc.b bVar2 = this.f9202w;
                    long j10 = this.C;
                    w2.o oVar2 = (w2.o) bVar2.f7621w;
                    oVar2.getClass();
                    oVar2.f(j5, j10);
                    this.B = false;
                }
                while (iL == 0 && !this.A) {
                    try {
                        s1.g gVar = this.f9204y;
                        synchronized (gVar) {
                            while (!gVar.f11670b) {
                                gVar.f11669a.getClass();
                                gVar.wait();
                            }
                        }
                        kc.b bVar3 = this.f9202w;
                        w2.s sVar = this.f9205z;
                        w2.o oVar3 = (w2.o) bVar3.f7621w;
                        oVar3.getClass();
                        w2.l lVar = (w2.l) bVar3.f7622x;
                        lVar.getClass();
                        iL = oVar3.l(lVar, sVar);
                        long jR = this.f9202w.r();
                        if (jR > this.G.D + j5) {
                            this.f9204y.d();
                            u0 u0Var2 = this.G;
                            u0Var2.L.post(u0Var2.K);
                            j5 = jR;
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                if (iL == 1) {
                    iL = 0;
                } else if (this.f9202w.r() != -1) {
                    this.f9205z.f13664a = this.f9202w.r();
                }
                com.bumptech.glide.c.f(this.f9201v);
            } catch (Throwable th) {
                if (iL != 1 && this.f9202w.r() != -1) {
                    this.f9205z.f13664a = this.f9202w.r();
                }
                com.bumptech.glide.c.f(this.f9201v);
                throw th;
            }
        }
    }

    @Override // s2.j
    public final void c() {
        this.A = true;
    }
}
