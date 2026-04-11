package t0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p1 f11790b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m1 f11791a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            f11790b = l1.f11776s;
        } else if (i >= 30) {
            f11790b = k1.f11766r;
        } else {
            f11790b = m1.f11782b;
        }
    }

    public p1(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.f11791a = new l1(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.f11791a = new k1(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.f11791a = new j1(this, windowInsets);
        } else if (i >= 28) {
            this.f11791a = new i1(this, windowInsets);
        } else {
            this.f11791a = new h1(this, windowInsets);
        }
    }

    public static l0.c e(l0.c cVar, int i, int i10, int i11, int i12) {
        int iMax = Math.max(0, cVar.f7602a - i);
        int iMax2 = Math.max(0, cVar.f7603b - i10);
        int iMax3 = Math.max(0, cVar.f7604c - i11);
        int iMax4 = Math.max(0, cVar.f7605d - i12);
        return (iMax == i && iMax2 == i10 && iMax3 == i11 && iMax4 == i12) ? cVar : l0.c.c(iMax, iMax2, iMax3, iMax4);
    }

    public static p1 h(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        p1 p1Var = new p1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = m0.f11777a;
            p1 p1VarA = e0.a(view);
            m1 m1Var = p1Var.f11791a;
            m1Var.q(p1VarA);
            m1Var.d(view.getRootView());
            m1Var.s(view.getWindowSystemUiVisibility());
        }
        return p1Var;
    }

    public final int a() {
        return this.f11791a.k().f7605d;
    }

    public final int b() {
        return this.f11791a.k().f7602a;
    }

    public final int c() {
        return this.f11791a.k().f7604c;
    }

    public final int d() {
        return this.f11791a.k().f7603b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p1) {
            return Objects.equals(this.f11791a, ((p1) obj).f11791a);
        }
        return false;
    }

    public final p1 f(int i, int i10, int i11, int i12) {
        int i13 = Build.VERSION.SDK_INT;
        f1 e1Var = i13 >= 34 ? new e1(this) : i13 >= 30 ? new d1(this) : i13 >= 29 ? new c1(this) : new a1(this);
        e1Var.g(l0.c.c(i, i10, i11, i12));
        return e1Var.b();
    }

    public final WindowInsets g() {
        m1 m1Var = this.f11791a;
        if (m1Var instanceof g1) {
            return ((g1) m1Var).f11756c;
        }
        return null;
    }

    public final int hashCode() {
        m1 m1Var = this.f11791a;
        if (m1Var == null) {
            return 0;
        }
        return m1Var.hashCode();
    }

    public p1() {
        this.f11791a = new m1(this);
    }
}
