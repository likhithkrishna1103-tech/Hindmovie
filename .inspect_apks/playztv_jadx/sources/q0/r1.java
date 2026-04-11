package q0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r1 f10491b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1 f10492a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            f10491b = n1.f10474s;
        } else if (i >= 30) {
            f10491b = m1.f10469r;
        } else {
            f10491b = o1.f10480b;
        }
    }

    public r1(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.f10492a = new n1(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.f10492a = new m1(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.f10492a = new l1(this, windowInsets);
        } else if (i >= 28) {
            this.f10492a = new k1(this, windowInsets);
        } else {
            this.f10492a = new j1(this, windowInsets);
        }
    }

    public static i0.d e(i0.d dVar, int i, int i10, int i11, int i12) {
        int iMax = Math.max(0, dVar.f6161a - i);
        int iMax2 = Math.max(0, dVar.f6162b - i10);
        int iMax3 = Math.max(0, dVar.f6163c - i11);
        int iMax4 = Math.max(0, dVar.f6164d - i12);
        return (iMax == i && iMax2 == i10 && iMax3 == i11 && iMax4 == i12) ? dVar : i0.d.c(iMax, iMax2, iMax3, iMax4);
    }

    public static r1 h(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        r1 r1Var = new r1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = o0.f10475a;
            r1 r1VarA = g0.a(view);
            o1 o1Var = r1Var.f10492a;
            o1Var.q(r1VarA);
            o1Var.d(view.getRootView());
            o1Var.s(view.getWindowSystemUiVisibility());
        }
        return r1Var;
    }

    public final int a() {
        return this.f10492a.k().f6164d;
    }

    public final int b() {
        return this.f10492a.k().f6161a;
    }

    public final int c() {
        return this.f10492a.k().f6163c;
    }

    public final int d() {
        return this.f10492a.k().f6162b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r1) {
            return Objects.equals(this.f10492a, ((r1) obj).f10492a);
        }
        return false;
    }

    public final r1 f(int i, int i10, int i11, int i12) {
        int i13 = Build.VERSION.SDK_INT;
        h1 g1Var = i13 >= 34 ? new g1(this) : i13 >= 30 ? new f1(this) : i13 >= 29 ? new d1(this) : new c1(this);
        g1Var.g(i0.d.c(i, i10, i11, i12));
        return g1Var.b();
    }

    public final WindowInsets g() {
        o1 o1Var = this.f10492a;
        if (o1Var instanceof i1) {
            return ((i1) o1Var).f10454c;
        }
        return null;
    }

    public final int hashCode() {
        o1 o1Var = this.f10492a;
        if (o1Var == null) {
            return 0;
        }
        return o1Var.hashCode();
    }

    public r1() {
        this.f10492a = new o1(this);
    }
}
