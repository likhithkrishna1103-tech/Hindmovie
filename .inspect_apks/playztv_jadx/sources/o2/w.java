package o2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f9241h = new Object();
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f9242g;

    public w(p1.f1 f1Var, Object obj, Object obj2) {
        super(f1Var);
        this.f = obj;
        this.f9242g = obj2;
    }

    @Override // o2.s, p1.f1
    public final int b(Object obj) {
        Object obj2;
        if (f9241h.equals(obj) && (obj2 = this.f9242g) != null) {
            obj = obj2;
        }
        return this.f9206e.b(obj);
    }

    @Override // o2.s, p1.f1
    public final p1.c1 f(int i, p1.c1 c1Var, boolean z2) {
        this.f9206e.f(i, c1Var, z2);
        if (Objects.equals(c1Var.f9677b, this.f9242g) && z2) {
            c1Var.f9677b = f9241h;
        }
        return c1Var;
    }

    @Override // o2.s, p1.f1
    public final Object l(int i) {
        Object objL = this.f9206e.l(i);
        return Objects.equals(objL, this.f9242g) ? f9241h : objL;
    }

    @Override // o2.s, p1.f1
    public final p1.e1 m(int i, p1.e1 e1Var, long j5) {
        this.f9206e.m(i, e1Var, j5);
        if (Objects.equals(e1Var.f9713a, this.f)) {
            e1Var.f9713a = p1.e1.f9703q;
        }
        return e1Var;
    }
}
