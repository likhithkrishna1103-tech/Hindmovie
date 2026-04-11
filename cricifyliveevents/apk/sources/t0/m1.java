package t0;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p1 f11782b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p1 f11783a;

    static {
        int i = Build.VERSION.SDK_INT;
        f11782b = (i >= 34 ? new e1() : i >= 30 ? new d1() : i >= 29 ? new c1() : new a1()).b().f11791a.a().f11791a.b().f11791a.c();
    }

    public m1(p1 p1Var) {
        this.f11783a = p1Var;
    }

    public p1 a() {
        return this.f11783a;
    }

    public p1 b() {
        return this.f11783a;
    }

    public p1 c() {
        return this.f11783a;
    }

    public i e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return o() == m1Var.o() && n() == m1Var.n() && Objects.equals(k(), m1Var.k()) && Objects.equals(i(), m1Var.i()) && Objects.equals(e(), m1Var.e());
    }

    public l0.c f(int i) {
        return l0.c.f7601e;
    }

    public l0.c g(int i) {
        if ((i & 8) == 0) {
            return l0.c.f7601e;
        }
        throw new IllegalArgumentException("Unable to query the maximum insets for IME");
    }

    public l0.c h() {
        return k();
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), e());
    }

    public l0.c i() {
        return l0.c.f7601e;
    }

    public l0.c j() {
        return k();
    }

    public l0.c k() {
        return l0.c.f7601e;
    }

    public l0.c l() {
        return k();
    }

    public p1 m(int i, int i10, int i11, int i12) {
        return f11782b;
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    public void d(View view) {
    }

    public void p(l0.c[] cVarArr) {
    }

    public void q(p1 p1Var) {
    }

    public void r(l0.c cVar) {
    }

    public void s(int i) {
    }
}
