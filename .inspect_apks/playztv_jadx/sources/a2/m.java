package a2;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements d1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f316u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f317v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f318w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f319x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f320y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f321z;

    public m(x0 x0Var, s1.w wVar) {
        this.f319x = x0Var;
        this.f318w = new e2(wVar);
        this.f316u = true;
    }

    public void a(g gVar) {
        d1 d1Var;
        d1 d1VarF = gVar.f();
        if (d1VarF == null || d1VarF == (d1Var = (d1) this.f321z)) {
            return;
        }
        if (d1Var != null) {
            throw new q(2, new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.f321z = d1VarF;
        this.f320y = gVar;
        d1VarF.e((p1.q0) ((e2) this.f318w).f211y);
    }

    @Override // a2.d1
    public void e(p1.q0 q0Var) {
        d1 d1Var = (d1) this.f321z;
        if (d1Var != null) {
            d1Var.e(q0Var);
            q0Var = ((d1) this.f321z).h();
        }
        ((e2) this.f318w).e(q0Var);
    }

    @Override // a2.d1
    public p1.q0 h() {
        d1 d1Var = (d1) this.f321z;
        return d1Var != null ? d1Var.h() : (p1.q0) ((e2) this.f318w).f211y;
    }

    @Override // a2.d1
    public boolean i() {
        if (this.f316u) {
            ((e2) this.f318w).getClass();
            return false;
        }
        d1 d1Var = (d1) this.f321z;
        d1Var.getClass();
        return d1Var.i();
    }

    @Override // a2.d1
    public long j() {
        if (this.f316u) {
            return ((e2) this.f318w).j();
        }
        d1 d1Var = (d1) this.f321z;
        d1Var.getClass();
        return d1Var.j();
    }

    public m(Context context, u2.v vVar) {
        this.f318w = context.getApplicationContext();
        this.f319x = vVar;
        this.f321z = s1.w.f11715a;
    }
}
