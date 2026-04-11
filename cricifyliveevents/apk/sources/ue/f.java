package ue;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.d0;
import pe.i1;
import pe.o0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends d0 implements xd.d, vd.c {
    public static final /* synthetic */ AtomicReferenceFieldUpdater C = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    public Object A;
    public final Object B;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final pe.s f12464y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final xd.c f12465z;

    public f(pe.s sVar, xd.c cVar) {
        super(-1);
        this.f12464y = sVar;
        this.f12465z = cVar;
        this.A = a.f12454b;
        this.B = a.k(cVar.h());
    }

    @Override // xd.d
    public final xd.d d() {
        return this.f12465z;
    }

    @Override // vd.c
    public final vd.h h() {
        return this.f12465z.h();
    }

    @Override // vd.c
    public final void i(Object obj) {
        Throwable thA = rd.h.a(obj);
        Object pVar = thA == null ? obj : new pe.p(thA, false);
        xd.c cVar = this.f12465z;
        vd.h hVarH = cVar.h();
        pe.s sVar = this.f12464y;
        if (sVar.i0(hVarH)) {
            this.A = pVar;
            this.f10228x = 0;
            sVar.h0(cVar.h(), this);
            return;
        }
        o0 o0VarA = i1.a();
        if (o0VarA.f10259x >= 4294967296L) {
            this.A = pVar;
            this.f10228x = 0;
            sd.h hVar = o0VarA.f10261z;
            if (hVar == null) {
                hVar = new sd.h();
                o0VarA.f10261z = hVar;
            }
            hVar.addLast(this);
            return;
        }
        o0VarA.m0(true);
        try {
            vd.h hVarH2 = cVar.h();
            Object objL = a.l(hVarH2, this.B);
            try {
                cVar.i(obj);
                while (o0VarA.o0()) {
                }
            } finally {
                a.g(hVarH2, objL);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // pe.d0
    public final Object m() {
        Object obj = this.A;
        this.A = a.f12454b;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f12464y + ", " + pe.x.p(this.f12465z) + ']';
    }

    @Override // pe.d0
    public final vd.c e() {
        return this;
    }
}
