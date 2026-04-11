package t0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p1 f11743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l0.c[] f11744b;

    public f1() {
        this(new p1());
    }

    public final void a() {
        l0.c[] cVarArr = this.f11744b;
        if (cVarArr != null) {
            l0.c cVarF = cVarArr[0];
            l0.c cVarF2 = cVarArr[1];
            p1 p1Var = this.f11743a;
            if (cVarF2 == null) {
                cVarF2 = p1Var.f11791a.f(2);
            }
            if (cVarF == null) {
                cVarF = p1Var.f11791a.f(1);
            }
            g(l0.c.a(cVarF, cVarF2));
            l0.c cVar = this.f11744b[a.a.e(16)];
            if (cVar != null) {
                f(cVar);
            }
            l0.c cVar2 = this.f11744b[a.a.e(32)];
            if (cVar2 != null) {
                d(cVar2);
            }
            l0.c cVar3 = this.f11744b[a.a.e(64)];
            if (cVar3 != null) {
                h(cVar3);
            }
        }
    }

    public abstract p1 b();

    public void c(int i, l0.c cVar) {
        if (this.f11744b == null) {
            this.f11744b = new l0.c[10];
        }
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((i & i10) != 0) {
                this.f11744b[a.a.e(i10)] = cVar;
            }
        }
    }

    public abstract void e(l0.c cVar);

    public abstract void g(l0.c cVar);

    public f1(p1 p1Var) {
        this.f11743a = p1Var;
    }

    public void d(l0.c cVar) {
    }

    public void f(l0.c cVar) {
    }

    public void h(l0.c cVar) {
    }
}
