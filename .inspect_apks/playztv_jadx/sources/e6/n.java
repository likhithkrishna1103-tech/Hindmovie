package e6;

import aa.l0;
import android.os.SystemClock;
import android.util.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements s, u {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f4539h = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u5.c f4540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t7.j f4541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g6.d f4542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final za.c f4543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f0 f4544e;
    public final l0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a7.b f4545g;

    public n(g6.d dVar, u5.c cVar, h6.d dVar2, h6.d dVar3, h6.d dVar4, h6.d dVar5) throws Throwable {
        this.f4542c = dVar;
        q7.h hVar = new q7.h(cVar);
        a7.b bVar = new a7.b(13);
        this.f4545g = bVar;
        synchronized (this) {
            try {
                try {
                    synchronized (bVar) {
                        try {
                            bVar.f620x = this;
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    }
                    this.f4541b = new t7.j(9);
                    this.f4540a = new u5.c(11);
                    this.f4543d = new za.c(dVar2, dVar3, dVar4, dVar5, this, this);
                    this.f = new l0(hVar);
                    this.f4544e = new f0(0);
                    dVar.f5322d = this;
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        }
    }

    public static void d(String str, long j5, t tVar) {
        Log.v("Engine", str + " in " + x6.h.a(j5) + "ms, key: " + tVar);
    }

    public static void g(b0 b0Var) {
        if (!(b0Var instanceof v)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((v) b0Var).e();
    }

    public final a7.b a(com.bumptech.glide.e eVar, Object obj, c6.f fVar, int i, int i10, Class cls, Class cls2, com.bumptech.glide.f fVar2, m mVar, x6.c cVar, boolean z2, boolean z10, c6.i iVar, boolean z11, boolean z12, t6.h hVar, Executor executor) {
        long jElapsedRealtimeNanos;
        if (f4539h) {
            int i11 = x6.h.f14283b;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        this.f4541b.getClass();
        t tVar = new t(obj, fVar, i, i10, cVar, cls, cls2, iVar);
        synchronized (this) {
            try {
                v vVarC = c(tVar, z11, jElapsedRealtimeNanos);
                if (vVarC == null) {
                    return h(eVar, obj, fVar, i, i10, cls, cls2, fVar2, mVar, cVar, z2, z10, iVar, z11, z12, hVar, executor, tVar, jElapsedRealtimeNanos);
                }
                hVar.j(vVarC, 5, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public final v b(t tVar) throws Throwable {
        v vVar;
        Object obj;
        n nVar;
        t tVar2;
        g6.d dVar = this.f4542c;
        synchronized (dVar) {
            try {
                x6.i iVar = (x6.i) ((LinkedHashMap) dVar.f2250c).remove(tVar);
                vVar = null;
                if (iVar == null) {
                    obj = null;
                } else {
                    dVar.f2249b -= (long) iVar.f14285b;
                    obj = iVar.f14284a;
                }
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        b0 b0Var = (b0) obj;
        if (b0Var == null) {
            nVar = this;
            tVar2 = tVar;
        } else if (b0Var instanceof v) {
            vVar = (v) b0Var;
            nVar = this;
            tVar2 = tVar;
        } else {
            nVar = this;
            tVar2 = tVar;
            vVar = new v(b0Var, true, true, tVar2, nVar);
        }
        if (vVar != null) {
            vVar.a();
            nVar.f4545g.g(tVar2, vVar);
        }
        return vVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final v c(t tVar, boolean z2, long j5) throws Throwable {
        v vVar;
        if (z2) {
            a7.b bVar = this.f4545g;
            synchronized (bVar) {
                b bVar2 = (b) ((HashMap) bVar.f618v).get(tVar);
                if (bVar2 == null) {
                    vVar = null;
                } else {
                    vVar = (v) bVar2.get();
                    if (vVar == null) {
                        bVar.n(bVar2);
                    }
                }
            }
            if (vVar != null) {
                vVar.a();
            }
            if (vVar != null) {
                if (f4539h) {
                    d("Loaded resource from active resources", j5, tVar);
                }
                return vVar;
            }
            v vVarB = b(tVar);
            if (vVarB != null) {
                if (f4539h) {
                    d("Loaded resource from cache", j5, tVar);
                }
                return vVarB;
            }
        }
        return null;
    }

    public final synchronized void e(r rVar, t tVar, v vVar) {
        if (vVar != null) {
            try {
                if (vVar.f4565u) {
                    this.f4545g.g(tVar, vVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        HashMap map = (HashMap) this.f4540a.f12782v;
        if (rVar.equals(map.get(tVar))) {
            map.remove(tVar);
        }
    }

    public final void f(c6.f fVar, v vVar) {
        a7.b bVar = this.f4545g;
        synchronized (bVar) {
            b bVar2 = (b) ((HashMap) bVar.f618v).remove(fVar);
            if (bVar2 != null) {
                bVar2.f4475c = null;
                bVar2.clear();
            }
        }
        if (vVar.f4565u) {
        } else {
            this.f4544e.i(vVar, false);
        }
    }

    public final a7.b h(com.bumptech.glide.e eVar, Object obj, c6.f fVar, int i, int i10, Class cls, Class cls2, com.bumptech.glide.f fVar2, m mVar, Map map, boolean z2, boolean z10, c6.i iVar, boolean z11, boolean z12, t6.h hVar, Executor executor, t tVar, long j5) {
        r rVar = (r) ((HashMap) this.f4540a.f12782v).get(tVar);
        if (rVar != null) {
            rVar.b(hVar, executor);
            if (f4539h) {
                d("Added to existing load", j5, tVar);
            }
            return new a7.b(this, hVar, rVar);
        }
        r rVar2 = (r) ((kc.b) this.f4543d.f14939g).i();
        synchronized (rVar2) {
            rVar2.E = tVar;
            rVar2.F = z11;
            rVar2.G = z12;
        }
        l0 l0Var = this.f;
        k kVar = (k) ((kc.b) l0Var.f707x).i();
        int i11 = l0Var.f705v;
        l0Var.f705v = i11 + 1;
        h hVar2 = kVar.f4524u;
        q7.h hVar3 = kVar.f4527x;
        hVar2.f4508c = eVar;
        hVar2.f4509d = obj;
        hVar2.f4517n = fVar;
        hVar2.f4510e = i;
        hVar2.f = i10;
        hVar2.f4519p = mVar;
        hVar2.f4511g = cls;
        hVar2.f4512h = hVar3;
        hVar2.f4514k = cls2;
        hVar2.f4518o = fVar2;
        hVar2.i = iVar;
        hVar2.f4513j = map;
        hVar2.f4520q = z2;
        hVar2.f4521r = z10;
        kVar.B = eVar;
        kVar.C = fVar;
        kVar.D = fVar2;
        kVar.E = tVar;
        kVar.F = i;
        kVar.G = i10;
        kVar.H = mVar;
        kVar.I = iVar;
        kVar.J = rVar2;
        kVar.K = i11;
        kVar.X = 1;
        kVar.M = obj;
        u5.c cVar = this.f4540a;
        cVar.getClass();
        ((HashMap) cVar.f12782v).put(tVar, rVar2);
        rVar2.b(hVar, executor);
        rVar2.k(kVar);
        if (f4539h) {
            d("Started new load", j5, tVar);
        }
        return new a7.b(this, hVar, rVar2);
    }
}
