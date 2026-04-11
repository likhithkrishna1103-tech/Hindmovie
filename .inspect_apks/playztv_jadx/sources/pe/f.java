package pe;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ke.d0;
import ke.j1;
import ke.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends d0 implements td.d, rd.c {
    public static final /* synthetic */ AtomicReferenceFieldUpdater B = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    public final Object A;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ke.r f10376x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final td.c f10377y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f10378z;

    public f(ke.r rVar, td.c cVar) {
        super(-1);
        this.f10376x = rVar;
        this.f10377y = cVar;
        this.f10378z = a.f10366b;
        Object objD = cVar.f().d(0, a.f10369e);
        be.h.b(objD);
        this.A = objD;
    }

    @Override // td.d
    public final td.d c() {
        return this.f10377y;
    }

    @Override // rd.c
    public final rd.h f() {
        return this.f10377y.f();
    }

    @Override // rd.c
    public final void g(Object obj) {
        Throwable thA = nd.h.a(obj);
        Object oVar = thA == null ? obj : new ke.o(thA, false);
        td.c cVar = this.f10377y;
        rd.h hVarF = cVar.f();
        ke.r rVar = this.f10376x;
        if (rVar.i0(hVarF)) {
            this.f10378z = oVar;
            this.f7685w = 0;
            rVar.h0(cVar.f(), this);
            return;
        }
        o0 o0VarA = j1.a();
        if (o0VarA.f7719w >= 4294967296L) {
            this.f10378z = oVar;
            this.f7685w = 0;
            od.g gVar = o0VarA.f7721y;
            if (gVar == null) {
                gVar = new od.g();
                o0VarA.f7721y = gVar;
            }
            gVar.addLast(this);
            return;
        }
        o0VarA.m0(true);
        try {
            rd.h hVarF2 = cVar.f();
            Object objK = a.k(hVarF2, this.A);
            try {
                cVar.g(obj);
                while (o0VarA.o0()) {
                }
            } finally {
                a.g(hVarF2, objK);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // ke.d0
    public final Object m() {
        Object obj = this.f10378z;
        this.f10378z = a.f10366b;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f10376x + ", " + ke.x.n(this.f10377y) + ']';
    }

    @Override // ke.d0
    public final rd.c d() {
        return this;
    }
}
