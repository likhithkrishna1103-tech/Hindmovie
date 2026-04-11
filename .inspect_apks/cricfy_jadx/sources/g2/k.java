package g2;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements t0 {
    public Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4779v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4780w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f4781x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f4782y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f4783z;

    public k(o0 o0Var, y1.v vVar) {
        this.f4782y = o0Var;
        this.f4781x = new f9.e1(vVar);
        this.f4779v = true;
    }

    public void a(e eVar) {
        t0 t0Var;
        t0 t0VarI = eVar.i();
        if (t0VarI == null || t0VarI == (t0Var = (t0) this.A)) {
            return;
        }
        if (t0Var != null) {
            throw new n(2, new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.A = t0VarI;
        this.f4783z = eVar;
        t0VarI.f((v1.q0) ((f9.e1) this.f4781x).f4097z);
    }

    @Override // g2.t0
    public v1.q0 d() {
        t0 t0Var = (t0) this.A;
        return t0Var != null ? t0Var.d() : (v1.q0) ((f9.e1) this.f4781x).f4097z;
    }

    @Override // g2.t0
    public void f(v1.q0 q0Var) {
        t0 t0Var = (t0) this.A;
        if (t0Var != null) {
            t0Var.f(q0Var);
            q0Var = ((t0) this.A).d();
        }
        ((f9.e1) this.f4781x).f(q0Var);
    }

    @Override // g2.t0
    public boolean g() {
        if (this.f4779v) {
            ((f9.e1) this.f4781x).getClass();
            return false;
        }
        t0 t0Var = (t0) this.A;
        t0Var.getClass();
        return t0Var.g();
    }

    @Override // g2.t0
    public long h() {
        if (this.f4779v) {
            return ((f9.e1) this.f4781x).h();
        }
        t0 t0Var = (t0) this.A;
        t0Var.getClass();
        return t0Var.h();
    }

    public k(Context context, y2.v vVar) {
        this.f4781x = context.getApplicationContext();
        this.f4782y = vVar;
        this.A = y1.v.f14615a;
    }
}
