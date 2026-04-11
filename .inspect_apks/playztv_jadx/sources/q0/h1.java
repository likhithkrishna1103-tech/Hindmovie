package q0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1 f10448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0.d[] f10449b;

    public h1() {
        this(new r1());
    }

    public final void a() {
        i0.d[] dVarArr = this.f10449b;
        if (dVarArr != null) {
            i0.d dVarF = dVarArr[0];
            i0.d dVarF2 = dVarArr[1];
            r1 r1Var = this.f10448a;
            if (dVarF2 == null) {
                dVarF2 = r1Var.f10492a.f(2);
            }
            if (dVarF == null) {
                dVarF = r1Var.f10492a.f(1);
            }
            g(i0.d.a(dVarF, dVarF2));
            i0.d dVar = this.f10449b[android.support.v4.media.session.b.C(16)];
            if (dVar != null) {
                f(dVar);
            }
            i0.d dVar2 = this.f10449b[android.support.v4.media.session.b.C(32)];
            if (dVar2 != null) {
                d(dVar2);
            }
            i0.d dVar3 = this.f10449b[android.support.v4.media.session.b.C(64)];
            if (dVar3 != null) {
                h(dVar3);
            }
        }
    }

    public abstract r1 b();

    public void c(int i, i0.d dVar) {
        if (this.f10449b == null) {
            this.f10449b = new i0.d[10];
        }
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((i & i10) != 0) {
                this.f10449b[android.support.v4.media.session.b.C(i10)] = dVar;
            }
        }
    }

    public abstract void e(i0.d dVar);

    public abstract void g(i0.d dVar);

    public h1(r1 r1Var) {
        this.f10448a = r1Var;
    }

    public void d(i0.d dVar) {
    }

    public void f(i0.d dVar) {
    }

    public void h(i0.d dVar) {
    }
}
