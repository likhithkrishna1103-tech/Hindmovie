package e6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements y6.b {
    public static final q9.e Q = new q9.e(9);
    public final h6.d A;
    public final h6.d B;
    public final h6.d C;
    public t E;
    public boolean F;
    public boolean G;
    public b0 H;
    public int I;
    public boolean J;
    public x K;
    public boolean L;
    public v M;
    public k N;
    public volatile boolean O;
    public boolean P;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u f4554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p0.c f4555x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final s f4557z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final q f4552u = new q(new ArrayList(2));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final y6.e f4553v = new y6.e();
    public final AtomicInteger D = new AtomicInteger();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final q9.e f4556y = Q;

    public r(h6.d dVar, h6.d dVar2, h6.d dVar3, h6.d dVar4, n nVar, n nVar2, kc.b bVar) {
        this.A = dVar;
        this.B = dVar2;
        this.C = dVar4;
        this.f4557z = nVar;
        this.f4554w = nVar2;
        this.f4555x = bVar;
    }

    @Override // y6.b
    public final y6.e a() {
        return this.f4553v;
    }

    public final synchronized void b(t6.h hVar, Executor executor) {
        try {
            this.f4553v.a();
            this.f4552u.f4551u.add(new p(hVar, executor));
            if (this.J) {
                e(1);
                executor.execute(new o(this, hVar, 1));
            } else if (this.L) {
                e(1);
                executor.execute(new o(this, hVar, 0));
            } else {
                x6.f.a("Cannot add callbacks to a cancelled EngineJob", !this.O);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c() {
        if (f()) {
            return;
        }
        this.O = true;
        k kVar = this.N;
        kVar.U = true;
        g gVar = kVar.S;
        if (gVar != null) {
            gVar.cancel();
        }
        s sVar = this.f4557z;
        t tVar = this.E;
        n nVar = (n) sVar;
        synchronized (nVar) {
            HashMap map = (HashMap) nVar.f4540a.f12782v;
            if (equals(map.get(tVar))) {
                map.remove(tVar);
            }
        }
    }

    public final void d() {
        v vVar;
        synchronized (this) {
            try {
                this.f4553v.a();
                x6.f.a("Not yet complete!", f());
                int iDecrementAndGet = this.D.decrementAndGet();
                x6.f.a("Can't decrement below 0", iDecrementAndGet >= 0);
                if (iDecrementAndGet == 0) {
                    vVar = this.M;
                    i();
                } else {
                    vVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (vVar != null) {
            vVar.e();
        }
    }

    public final synchronized void e(int i) {
        v vVar;
        x6.f.a("Not yet complete!", f());
        if (this.D.getAndAdd(i) == 0 && (vVar = this.M) != null) {
            vVar.a();
        }
    }

    public final boolean f() {
        return this.L || this.J || this.O;
    }

    public final void g() {
        synchronized (this) {
            try {
                this.f4553v.a();
                if (this.O) {
                    i();
                    return;
                }
                if (this.f4552u.f4551u.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.L) {
                    throw new IllegalStateException("Already failed once");
                }
                this.L = true;
                t tVar = this.E;
                q qVar = this.f4552u;
                qVar.getClass();
                ArrayList arrayList = new ArrayList(qVar.f4551u);
                e(arrayList.size() + 1);
                ((n) this.f4557z).e(this, tVar, null);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    p pVar = (p) obj;
                    pVar.f4550b.execute(new o(this, pVar.f4549a, 0));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this) {
            try {
                this.f4553v.a();
                if (this.O) {
                    this.H.d();
                    i();
                    return;
                }
                if (this.f4552u.f4551u.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.J) {
                    throw new IllegalStateException("Already have resource");
                }
                q9.e eVar = this.f4556y;
                b0 b0Var = this.H;
                boolean z2 = this.F;
                t tVar = this.E;
                u uVar = this.f4554w;
                eVar.getClass();
                this.M = new v(b0Var, z2, true, tVar, uVar);
                this.J = true;
                q qVar = this.f4552u;
                qVar.getClass();
                ArrayList arrayList = new ArrayList(qVar.f4551u);
                e(arrayList.size() + 1);
                ((n) this.f4557z).e(this, this.E, this.M);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    p pVar = (p) obj;
                    pVar.f4550b.execute(new o(this, pVar.f4549a, 1));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void i() {
        if (this.E == null) {
            throw new IllegalArgumentException();
        }
        this.f4552u.f4551u.clear();
        this.E = null;
        this.M = null;
        this.H = null;
        this.L = false;
        this.O = false;
        this.J = false;
        this.P = false;
        this.N.m();
        this.N = null;
        this.K = null;
        this.I = 0;
        this.f4555x.b(this);
    }

    public final synchronized void j(t6.h hVar) {
        try {
            this.f4553v.a();
            this.f4552u.f4551u.remove(new p(hVar, x6.f.f14281b));
            if (this.f4552u.f4551u.isEmpty()) {
                c();
                if (this.J || this.L) {
                    if (this.D.get() == 0) {
                        i();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k(k kVar) {
        this.N = kVar;
        int iH = kVar.h(1);
        ((iH == 2 || iH == 3) ? this.A : this.G ? this.C : this.B).execute(kVar);
    }
}
