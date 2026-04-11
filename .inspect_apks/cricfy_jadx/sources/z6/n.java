package z6;

import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.measurement.o4;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements s, u {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f15292h = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d7.w f15293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x2.b f15294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.f f15295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final tb.c f15296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o4 f15297e;
    public final f3.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l7.a f15298g;

    public n(b7.f fVar, p6.c cVar, c7.d dVar, c7.d dVar2, c7.d dVar3, c7.d dVar4) throws Throwable {
        this.f15295c = fVar;
        l8.i iVar = new l8.i(cVar);
        l7.a aVar = new l7.a(29);
        this.f15298g = aVar;
        synchronized (this) {
            try {
                try {
                    synchronized (aVar) {
                        try {
                            aVar.f7868y = this;
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
                    this.f15294b = new x2.b();
                    this.f15293a = new d7.w(1);
                    this.f15296d = new tb.c(dVar, dVar2, dVar3, dVar4, this, this);
                    this.f = new f3.a(iVar);
                    this.f15297e = new o4(9);
                    fVar.f1831d = this;
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

    public static void d(String str, long j4, t tVar) {
        Log.v("Engine", str + " in " + s7.h.a(j4) + "ms, key: " + tVar);
    }

    public static void g(b0 b0Var) {
        if (!(b0Var instanceof v)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((v) b0Var).b();
    }

    public final e a(com.bumptech.glide.g gVar, Object obj, x6.e eVar, int i, int i10, Class cls, Class cls2, com.bumptech.glide.h hVar, m mVar, s7.c cVar, boolean z10, boolean z11, x6.h hVar2, boolean z12, boolean z13, o7.h hVar3, Executor executor) {
        long jElapsedRealtimeNanos;
        if (f15292h) {
            int i11 = s7.h.f11599b;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        this.f15294b.getClass();
        t tVar = new t(obj, eVar, i, i10, cVar, cls, cls2, hVar2);
        synchronized (this) {
            try {
                v vVarC = c(tVar, z12, jElapsedRealtimeNanos);
                if (vVarC == null) {
                    return h(gVar, obj, eVar, i, i10, cls, cls2, hVar, mVar, cVar, z10, z11, hVar2, z12, z13, hVar3, executor, tVar, jElapsedRealtimeNanos);
                }
                hVar3.k(vVarC, 5, false);
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
        b7.f fVar = this.f15295c;
        synchronized (fVar) {
            try {
                s7.i iVar = (s7.i) ((LinkedHashMap) fVar.f5984c).remove(tVar);
                vVar = null;
                if (iVar == null) {
                    obj = null;
                } else {
                    fVar.f5983b -= (long) iVar.f11601b;
                    obj = iVar.f11600a;
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
            nVar.f15298g.j(tVar2, vVar);
        }
        return vVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final v c(t tVar, boolean z10, long j4) throws Throwable {
        v vVar;
        if (z10) {
            l7.a aVar = this.f15298g;
            synchronized (aVar) {
                a aVar2 = (a) ((HashMap) aVar.f7866w).get(tVar);
                if (aVar2 == null) {
                    vVar = null;
                } else {
                    vVar = (v) aVar2.get();
                    if (vVar == null) {
                        aVar.n(aVar2);
                    }
                }
            }
            if (vVar != null) {
                vVar.a();
            }
            if (vVar != null) {
                if (f15292h) {
                    d("Loaded resource from active resources", j4, tVar);
                }
                return vVar;
            }
            v vVarB = b(tVar);
            if (vVarB != null) {
                if (f15292h) {
                    d("Loaded resource from cache", j4, tVar);
                }
                return vVarB;
            }
        }
        return null;
    }

    public final synchronized void e(r rVar, t tVar, v vVar) {
        if (vVar != null) {
            try {
                if (vVar.f15317v) {
                    this.f15298g.j(tVar, vVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        HashMap map = this.f15293a.f3511a;
        if (rVar.equals(map.get(tVar))) {
            map.remove(tVar);
        }
    }

    public final void f(x6.e eVar, v vVar) {
        l7.a aVar = this.f15298g;
        synchronized (aVar) {
            a aVar2 = (a) ((HashMap) aVar.f7866w).remove(eVar);
            if (aVar2 != null) {
                aVar2.f15226c = null;
                aVar2.clear();
            }
        }
        if (vVar.f15317v) {
        } else {
            this.f15297e.j(vVar, false);
        }
    }

    public final e h(com.bumptech.glide.g gVar, Object obj, x6.e eVar, int i, int i10, Class cls, Class cls2, com.bumptech.glide.h hVar, m mVar, Map map, boolean z10, boolean z11, x6.h hVar2, boolean z12, boolean z13, o7.h hVar3, Executor executor, t tVar, long j4) {
        r rVar = (r) this.f15293a.f3511a.get(tVar);
        if (rVar != null) {
            rVar.a(hVar3, executor);
            if (f15292h) {
                d("Added to existing load", j4, tVar);
            }
            return new e(this, hVar3, rVar);
        }
        r rVar2 = (r) ((l7.a) this.f15296d.B).i();
        synchronized (rVar2) {
            rVar2.F = tVar;
            rVar2.G = z12;
            rVar2.H = z13;
        }
        f3.a aVar = this.f;
        k kVar = (k) ((l7.a) aVar.f3937y).i();
        int i11 = aVar.f3935w;
        aVar.f3935w = i11 + 1;
        h hVar4 = kVar.f15278v;
        l8.i iVar = kVar.f15281y;
        hVar4.f15261c = gVar;
        hVar4.f15262d = obj;
        hVar4.f15270n = eVar;
        hVar4.f15263e = i;
        hVar4.f = i10;
        hVar4.f15272p = mVar;
        hVar4.f15264g = cls;
        hVar4.f15265h = iVar;
        hVar4.f15267k = cls2;
        hVar4.f15271o = hVar;
        hVar4.i = hVar2;
        hVar4.f15266j = map;
        hVar4.f15273q = z10;
        hVar4.f15274r = z11;
        kVar.C = gVar;
        kVar.D = eVar;
        kVar.E = hVar;
        kVar.F = tVar;
        kVar.G = i;
        kVar.H = i10;
        kVar.I = mVar;
        kVar.J = hVar2;
        kVar.K = rVar2;
        kVar.L = i11;
        kVar.f15276a0 = 1;
        kVar.N = obj;
        kVar.O = gVar.f2207h;
        kVar.P = i.a(hVar2.c(k.f15275c0));
        d7.w wVar = this.f15293a;
        wVar.getClass();
        wVar.f3511a.put(tVar, rVar2);
        rVar2.a(hVar3, executor);
        rVar2.k(kVar);
        if (f15292h) {
            d("Started new load", j4, tVar);
        }
        return new e(this, hVar3, rVar2);
    }
}
