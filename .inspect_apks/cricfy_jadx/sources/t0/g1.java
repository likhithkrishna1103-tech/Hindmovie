package t0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g1 extends m1 {
    public static boolean i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Method f11752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Class f11753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Field f11754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Field f11755m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowInsets f11756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0.c[] f11757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l0.c f11758e;
    public p1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l0.c f11759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11760h;

    public g1(p1 p1Var, WindowInsets windowInsets) {
        super(p1Var);
        this.f11758e = null;
        this.f11756c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private l0.c t(int i10, boolean z10) {
        l0.c cVarA = l0.c.f7601e;
        for (int i11 = 1; i11 <= 512; i11 <<= 1) {
            if ((i10 & i11) != 0) {
                cVarA = l0.c.a(cVarA, u(i11, z10));
            }
        }
        return cVarA;
    }

    private l0.c v() {
        p1 p1Var = this.f;
        return p1Var != null ? p1Var.f11791a.i() : l0.c.f7601e;
    }

    private l0.c w(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!i) {
            x();
        }
        Method method = f11752j;
        if (method != null && f11753k != null && f11754l != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f11754l.get(f11755m.get(objInvoke));
                if (rect != null) {
                    return l0.c.c(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e9) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e9.getMessage(), e9);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void x() {
        try {
            f11752j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f11753k = cls;
            f11754l = cls.getDeclaredField("mVisibleInsets");
            f11755m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f11754l.setAccessible(true);
            f11755m.setAccessible(true);
        } catch (ReflectiveOperationException e9) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e9.getMessage(), e9);
        }
        i = true;
    }

    public static boolean z(int i10, int i11) {
        return (i10 & 6) == (i11 & 6);
    }

    @Override // t0.m1
    public void d(View view) {
        l0.c cVarW = w(view);
        if (cVarW == null) {
            cVarW = l0.c.f7601e;
        }
        y(cVarW);
    }

    @Override // t0.m1
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return Objects.equals(this.f11759g, g1Var.f11759g) && z(this.f11760h, g1Var.f11760h);
    }

    @Override // t0.m1
    public l0.c f(int i10) {
        return t(i10, false);
    }

    @Override // t0.m1
    public l0.c g(int i10) {
        return t(i10, true);
    }

    @Override // t0.m1
    public final l0.c k() {
        if (this.f11758e == null) {
            WindowInsets windowInsets = this.f11756c;
            this.f11758e = l0.c.c(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f11758e;
    }

    @Override // t0.m1
    public p1 m(int i10, int i11, int i12, int i13) {
        p1 p1VarH = p1.h(null, this.f11756c);
        int i14 = Build.VERSION.SDK_INT;
        f1 e1Var = i14 >= 34 ? new e1(p1VarH) : i14 >= 30 ? new d1(p1VarH) : i14 >= 29 ? new c1(p1VarH) : new a1(p1VarH);
        e1Var.g(p1.e(k(), i10, i11, i12, i13));
        e1Var.e(p1.e(i(), i10, i11, i12, i13));
        return e1Var.b();
    }

    @Override // t0.m1
    public boolean o() {
        return this.f11756c.isRound();
    }

    @Override // t0.m1
    public void p(l0.c[] cVarArr) {
        this.f11757d = cVarArr;
    }

    @Override // t0.m1
    public void q(p1 p1Var) {
        this.f = p1Var;
    }

    @Override // t0.m1
    public void s(int i10) {
        this.f11760h = i10;
    }

    public l0.c u(int i10, boolean z10) {
        l0.c cVarI;
        int i11;
        l0.c cVar = l0.c.f7601e;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 8) {
                    l0.c[] cVarArr = this.f11757d;
                    cVarI = cVarArr != null ? cVarArr[a.a.e(8)] : null;
                    if (cVarI != null) {
                        return cVarI;
                    }
                    l0.c cVarK = k();
                    l0.c cVarV = v();
                    int i12 = cVarK.f7605d;
                    if (i12 > cVarV.f7605d) {
                        return l0.c.c(0, 0, 0, i12);
                    }
                    l0.c cVar2 = this.f11759g;
                    if (cVar2 != null && !cVar2.equals(cVar) && (i11 = this.f11759g.f7605d) > cVarV.f7605d) {
                        return l0.c.c(0, 0, 0, i11);
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
                        p1 p1Var = this.f;
                        i iVarE = p1Var != null ? p1Var.f11791a.e() : e();
                        if (iVarE != null) {
                            int i13 = Build.VERSION.SDK_INT;
                            return l0.c.c(i13 >= 28 ? j0.a.f(iVarE.f11762a) : 0, i13 >= 28 ? j0.a.h(iVarE.f11762a) : 0, i13 >= 28 ? j0.a.g(iVarE.f11762a) : 0, i13 >= 28 ? j0.a.e(iVarE.f11762a) : 0);
                        }
                    }
                }
            } else {
                if (z10) {
                    l0.c cVarV2 = v();
                    l0.c cVarI2 = i();
                    return l0.c.c(Math.max(cVarV2.f7602a, cVarI2.f7602a), 0, Math.max(cVarV2.f7604c, cVarI2.f7604c), Math.max(cVarV2.f7605d, cVarI2.f7605d));
                }
                if ((this.f11760h & 2) == 0) {
                    l0.c cVarK2 = k();
                    p1 p1Var2 = this.f;
                    cVarI = p1Var2 != null ? p1Var2.f11791a.i() : null;
                    int iMin = cVarK2.f7605d;
                    if (cVarI != null) {
                        iMin = Math.min(iMin, cVarI.f7605d);
                    }
                    return l0.c.c(cVarK2.f7602a, 0, cVarK2.f7604c, iMin);
                }
            }
        } else {
            if (z10) {
                return l0.c.c(0, Math.max(v().f7603b, k().f7603b), 0, 0);
            }
            if ((this.f11760h & 4) == 0) {
                return l0.c.c(0, k().f7603b, 0, 0);
            }
        }
        return cVar;
    }

    public void y(l0.c cVar) {
        this.f11759g = cVar;
    }
}
