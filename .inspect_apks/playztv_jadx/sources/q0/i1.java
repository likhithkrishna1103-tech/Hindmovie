package q0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i1 extends o1 {
    public static boolean i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Method f10450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Class f10451k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Field f10452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Field f10453m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowInsets f10454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0.d[] f10455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i0.d f10456e;
    public r1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i0.d f10457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10458h;

    public i1(r1 r1Var, WindowInsets windowInsets) {
        super(r1Var);
        this.f10456e = null;
        this.f10454c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private i0.d t(int i10, boolean z2) {
        i0.d dVarA = i0.d.f6160e;
        for (int i11 = 1; i11 <= 512; i11 <<= 1) {
            if ((i10 & i11) != 0) {
                dVarA = i0.d.a(dVarA, u(i11, z2));
            }
        }
        return dVarA;
    }

    private i0.d v() {
        r1 r1Var = this.f;
        return r1Var != null ? r1Var.f10492a.i() : i0.d.f6160e;
    }

    private i0.d w(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!i) {
            x();
        }
        Method method = f10450j;
        if (method != null && f10451k != null && f10452l != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f10452l.get(f10453m.get(objInvoke));
                if (rect != null) {
                    return i0.d.c(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void x() {
        try {
            f10450j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f10451k = cls;
            f10452l = cls.getDeclaredField("mVisibleInsets");
            f10453m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f10452l.setAccessible(true);
            f10453m.setAccessible(true);
        } catch (ReflectiveOperationException e10) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
        }
        i = true;
    }

    public static boolean z(int i10, int i11) {
        return (i10 & 6) == (i11 & 6);
    }

    @Override // q0.o1
    public void d(View view) {
        i0.d dVarW = w(view);
        if (dVarW == null) {
            dVarW = i0.d.f6160e;
        }
        y(dVarW);
    }

    @Override // q0.o1
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return Objects.equals(this.f10457g, i1Var.f10457g) && z(this.f10458h, i1Var.f10458h);
    }

    @Override // q0.o1
    public i0.d f(int i10) {
        return t(i10, false);
    }

    @Override // q0.o1
    public i0.d g(int i10) {
        return t(i10, true);
    }

    @Override // q0.o1
    public final i0.d k() {
        if (this.f10456e == null) {
            WindowInsets windowInsets = this.f10454c;
            this.f10456e = i0.d.c(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f10456e;
    }

    @Override // q0.o1
    public r1 m(int i10, int i11, int i12, int i13) {
        r1 r1VarH = r1.h(null, this.f10454c);
        int i14 = Build.VERSION.SDK_INT;
        h1 g1Var = i14 >= 34 ? new g1(r1VarH) : i14 >= 30 ? new f1(r1VarH) : i14 >= 29 ? new d1(r1VarH) : new c1(r1VarH);
        g1Var.g(r1.e(k(), i10, i11, i12, i13));
        g1Var.e(r1.e(i(), i10, i11, i12, i13));
        return g1Var.b();
    }

    @Override // q0.o1
    public boolean o() {
        return this.f10454c.isRound();
    }

    @Override // q0.o1
    public void p(i0.d[] dVarArr) {
        this.f10455d = dVarArr;
    }

    @Override // q0.o1
    public void q(r1 r1Var) {
        this.f = r1Var;
    }

    @Override // q0.o1
    public void s(int i10) {
        this.f10458h = i10;
    }

    public i0.d u(int i10, boolean z2) {
        i0.d dVarI;
        int i11;
        i0.d dVar = i0.d.f6160e;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 8) {
                    i0.d[] dVarArr = this.f10455d;
                    dVarI = dVarArr != null ? dVarArr[android.support.v4.media.session.b.C(8)] : null;
                    if (dVarI != null) {
                        return dVarI;
                    }
                    i0.d dVarK = k();
                    i0.d dVarV = v();
                    int i12 = dVarK.f6164d;
                    if (i12 > dVarV.f6164d) {
                        return i0.d.c(0, 0, 0, i12);
                    }
                    i0.d dVar2 = this.f10457g;
                    if (dVar2 != null && !dVar2.equals(dVar) && (i11 = this.f10457g.f6164d) > dVarV.f6164d) {
                        return i0.d.c(0, 0, 0, i11);
                    }
                } else {
                    if (i10 == 16) {
                        return j();
                    }
                    if (i10 == 32) {
                        return h();
                    }
                    if (i10 == 64) {
                        return l();
                    }
                    if (i10 == 128) {
                        r1 r1Var = this.f;
                        j jVarE = r1Var != null ? r1Var.f10492a.e() : e();
                        if (jVarE != null) {
                            int i13 = Build.VERSION.SDK_INT;
                            return i0.d.c(i13 >= 28 ? g0.a.f(jVarE.f10459a) : 0, i13 >= 28 ? g0.a.h(jVarE.f10459a) : 0, i13 >= 28 ? g0.a.g(jVarE.f10459a) : 0, i13 >= 28 ? g0.a.e(jVarE.f10459a) : 0);
                        }
                    }
                }
            } else {
                if (z2) {
                    i0.d dVarV2 = v();
                    i0.d dVarI2 = i();
                    return i0.d.c(Math.max(dVarV2.f6161a, dVarI2.f6161a), 0, Math.max(dVarV2.f6163c, dVarI2.f6163c), Math.max(dVarV2.f6164d, dVarI2.f6164d));
                }
                if ((this.f10458h & 2) == 0) {
                    i0.d dVarK2 = k();
                    r1 r1Var2 = this.f;
                    dVarI = r1Var2 != null ? r1Var2.f10492a.i() : null;
                    int iMin = dVarK2.f6164d;
                    if (dVarI != null) {
                        iMin = Math.min(iMin, dVarI.f6164d);
                    }
                    return i0.d.c(dVarK2.f6161a, 0, dVarK2.f6163c, iMin);
                }
            }
        } else {
            if (z2) {
                return i0.d.c(0, Math.max(v().f6162b, k().f6162b), 0, 0);
            }
            if ((this.f10458h & 4) == 0) {
                return i0.d.c(0, k().f6162b, 0, 0);
            }
        }
        return dVar;
    }

    public void y(i0.d dVar) {
        this.f10457g = dVar;
    }
}
