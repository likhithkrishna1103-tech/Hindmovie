package z6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements t7.b {
    public static final x3.e R = new x3.e();
    public final s A;
    public final c7.d B;
    public final c7.d C;
    public final c7.d D;
    public t F;
    public boolean G;
    public boolean H;
    public b0 I;
    public int J;
    public boolean K;
    public x L;
    public boolean M;
    public v N;
    public k O;
    public volatile boolean P;
    public boolean Q;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final u f15307x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s0.c f15308y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f15305v = new q(new ArrayList(2));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t7.e f15306w = new t7.e();
    public final AtomicInteger E = new AtomicInteger();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final x3.e f15309z = R;

    public r(c7.d dVar, c7.d dVar2, c7.d dVar3, c7.d dVar4, n nVar, n nVar2, l7.a aVar) {
        this.B = dVar;
        this.C = dVar2;
        this.D = dVar4;
        this.A = nVar;
        this.f15307x = nVar2;
        this.f15308y = aVar;
    }

    public final synchronized void a(o7.h hVar, Executor executor) {
        try {
            this.f15306w.a();
            this.f15305v.f15304v.add(new p(hVar, executor));
            if (this.K) {
                e(1);
                executor.execute(new o(this, hVar, 1));
            } else if (this.M) {
                e(1);
                executor.execute(new o(this, hVar, 0));
            } else {
                s7.f.a("Cannot add callbacks to a cancelled EngineJob", !this.P);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // t7.b
    public final t7.e b() {
        return this.f15306w;
    }

    public final void c() {
        if (f()) {
            return;
        }
        this.P = true;
        k kVar = this.O;
        kVar.X = true;
        g gVar = kVar.V;
        if (gVar != null) {
            gVar.cancel();
        }
        s sVar = this.A;
        t tVar = this.F;
        n nVar = (n) sVar;
        synchronized (nVar) {
            HashMap map = nVar.f15293a.f3511a;
            if (equals(map.get(tVar))) {
                map.remove(tVar);
            }
        }
    }

    public final void d() {
        v vVar;
        synchronized (this) {
            try {
                this.f15306w.a();
                s7.f.a("Not yet complete!", f());
                int iDecrementAndGet = this.E.decrementAndGet();
                s7.f.a("Can't decrement below 0", iDecrementAndGet >= 0);
                if (iDecrementAndGet == 0) {
                    vVar = this.N;
                    i();
                } else {
                    vVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (vVar != null) {
            vVar.b();
        }
    }

    public final synchronized void e(int i) {
        v vVar;
        s7.f.a("Not yet complete!", f());
        if (this.E.getAndAdd(i) == 0 && (vVar = this.N) != null) {
            vVar.a();
        }
    }

    public final boolean f() {
        return this.M || this.K || this.P;
    }

    public final void g() {
        synchronized (this) {
            try {
                this.f15306w.a();
                if (this.P) {
                    i();
                    return;
                }
                if (this.f15305v.f15304v.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.M) {
                    throw new IllegalStateException("Already failed once");
                }
                this.M = true;
                t tVar = this.F;
                q qVar = this.f15305v;
                qVar.getClass();
                ArrayList arrayList = new ArrayList(qVar.f15304v);
                e(arrayList.size() + 1);
                ((n) this.A).e(this, tVar, null);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    p pVar = (p) obj;
                    pVar.f15303b.execute(new o(this, pVar.f15302a, 0));
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
                this.f15306w.a();
                if (this.P) {
                    this.I.e();
                    i();
                    return;
                }
                if (this.f15305v.f15304v.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.K) {
                    throw new IllegalStateException("Already have resource");
                }
                x3.e eVar = this.f15309z;
                b0 b0Var = this.I;
                boolean z10 = this.G;
                t tVar = this.F;
                u uVar = this.f15307x;
                eVar.getClass();
                this.N = new v(b0Var, z10, true, tVar, uVar);
                this.K = true;
                q qVar = this.f15305v;
                qVar.getClass();
                ArrayList arrayList = new ArrayList(qVar.f15304v);
                e(arrayList.size() + 1);
                ((n) this.A).e(this, this.F, this.N);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    p pVar = (p) obj;
                    pVar.f15303b.execute(new o(this, pVar.f15302a, 1));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void i() {
        if (this.F == null) {
            throw new IllegalArgumentException();
        }
        this.f15305v.f15304v.clear();
        this.F = null;
        this.N = null;
        this.I = null;
        this.M = false;
        this.P = false;
        this.K = false;
        this.Q = false;
        this.O.m();
        this.O = null;
        this.L = null;
        this.J = 0;
        this.f15308y.b(this);
    }

    public final synchronized void j(o7.h hVar) {
        try {
            this.f15306w.a();
            this.f15305v.f15304v.remove(new p(hVar, s7.f.f11597b));
            if (this.f15305v.f15304v.isEmpty()) {
                c();
                if (this.K || this.M) {
                    if (this.E.get() == 0) {
                        i();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k(k kVar) {
        this.O = kVar;
        int iH = kVar.h(1);
        ((iH == 2 || iH == 3) ? this.B : this.H ? this.D : this.C).execute(kVar);
    }
}
