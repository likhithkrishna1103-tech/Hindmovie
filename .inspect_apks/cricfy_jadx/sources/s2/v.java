package s2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f11337h = new Object();
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f11338g;

    public v(v1.f1 f1Var, Object obj, Object obj2) {
        super(f1Var);
        this.f = obj;
        this.f11338g = obj2;
    }

    @Override // s2.r, v1.f1
    public final int b(Object obj) {
        Object obj2;
        if (f11337h.equals(obj) && (obj2 = this.f11338g) != null) {
            obj = obj2;
        }
        return this.f11299e.b(obj);
    }

    @Override // s2.r, v1.f1
    public final v1.c1 f(int i, v1.c1 c1Var, boolean z10) {
        this.f11299e.f(i, c1Var, z10);
        if (Objects.equals(c1Var.f12617b, this.f11338g) && z10) {
            c1Var.f12617b = f11337h;
        }
        return c1Var;
    }

    @Override // s2.r, v1.f1
    public final Object l(int i) {
        Object objL = this.f11299e.l(i);
        return Objects.equals(objL, this.f11338g) ? f11337h : objL;
    }

    @Override // s2.r, v1.f1
    public final v1.e1 m(int i, v1.e1 e1Var, long j4) {
        this.f11299e.m(i, e1Var, j4);
        if (Objects.equals(e1Var.f12643a, this.f)) {
            e1Var.f12643a = v1.e1.f12633q;
        }
        return e1Var;
    }
}
