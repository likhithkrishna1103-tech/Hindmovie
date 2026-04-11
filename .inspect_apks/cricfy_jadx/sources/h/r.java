package h;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import o.w3;
import o.x3;
import t0.p1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements t0.o, n.v {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ a0 f5401v;

    public /* synthetic */ r(a0 a0Var) {
        this.f5401v = a0Var;
    }

    @Override // n.v
    public void c(n.k kVar, boolean z10) {
        z zVar;
        n.k kVarK = kVar.k();
        int i = 0;
        boolean z11 = kVarK != kVar;
        if (z11) {
            kVar = kVarK;
        }
        a0 a0Var = this.f5401v;
        z[] zVarArr = a0Var.f5268g0;
        int length = zVarArr != null ? zVarArr.length : 0;
        while (true) {
            if (i < length) {
                zVar = zVarArr[i];
                if (zVar != null && zVar.f5417h == kVar) {
                    break;
                } else {
                    i++;
                }
            } else {
                zVar = null;
                break;
            }
        }
        if (zVar != null) {
            if (!z11) {
                a0Var.r(zVar, z10);
            } else {
                a0Var.p(zVar.f5411a, zVar, kVarK);
                a0Var.r(zVar, true);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // t0.o
    public p1 k(View view, p1 p1Var) {
        int i;
        int i10;
        int i11;
        int i12;
        int iD = p1Var.d();
        a0 a0Var = this.f5401v;
        Context context = a0Var.F;
        int iD2 = p1Var.d();
        ActionBarContextView actionBarContextView = a0Var.Q;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            i = 0;
            i10 = 0;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a0Var.Q.getLayoutParams();
            if (a0Var.Q.isShown()) {
                if (a0Var.f5284x0 == null) {
                    a0Var.f5284x0 = new Rect();
                    a0Var.f5285y0 = new Rect();
                }
                Rect rect = a0Var.f5284x0;
                Rect rect2 = a0Var.f5285y0;
                rect.set(p1Var.b(), p1Var.d(), p1Var.c(), p1Var.a());
                ViewGroup viewGroup = a0Var.V;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z10 = x3.f9407a;
                    w3.a(viewGroup, rect, rect2);
                    i11 = 0;
                } else {
                    if (x3.f9407a) {
                        i11 = 0;
                    } else {
                        x3.f9407a = true;
                        i11 = 0;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            x3.f9408b = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                x3.f9408b.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method = x3.f9408b;
                    if (method != null) {
                        try {
                            Object[] objArr = new Object[2];
                            objArr[i11] = rect;
                            objArr[1] = rect2;
                            method.invoke(viewGroup, objArr);
                        } catch (Exception e9) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e9);
                        }
                    }
                }
                int i13 = rect.top;
                int i14 = rect.left;
                int i15 = rect.right;
                ViewGroup viewGroup2 = a0Var.V;
                WeakHashMap weakHashMap = t0.m0.f11777a;
                p1 p1VarA = t0.e0.a(viewGroup2);
                int iB = p1VarA == null ? i11 : p1VarA.b();
                int iC = p1VarA == null ? i11 : p1VarA.c();
                if (marginLayoutParams.topMargin == i13 && marginLayoutParams.leftMargin == i14 && marginLayoutParams.rightMargin == i15) {
                    i12 = i11;
                } else {
                    marginLayoutParams.topMargin = i13;
                    marginLayoutParams.leftMargin = i14;
                    marginLayoutParams.rightMargin = i15;
                    i12 = 1;
                }
                if (i13 <= 0 || a0Var.X != null) {
                    View view2 = a0Var.X;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i16 = marginLayoutParams2.height;
                        int i17 = marginLayoutParams.topMargin;
                        if (i16 != i17 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = i17;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            a0Var.X.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    a0Var.X = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    a0Var.V.addView(a0Var.X, -1, layoutParams);
                }
                View view4 = a0Var.X;
                i = view4 == null ? i11 : 1;
                if (i != 0 && view4.getVisibility() != 0) {
                    View view5 = a0Var.X;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? context.getColor(g.c.abc_decor_view_status_guard_light) : context.getColor(g.c.abc_decor_view_status_guard));
                }
                if (!a0Var.f5264c0 && i != 0) {
                    iD2 = i11;
                }
                i10 = i;
                i = i11;
                i = i12;
            } else {
                i = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    i10 = 0;
                } else {
                    i10 = 0;
                    i = 0;
                }
            }
            if (i != 0) {
                a0Var.Q.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = a0Var.X;
        if (view6 != null) {
            view6.setVisibility(i10 != 0 ? i : 8);
        }
        return t0.m0.i(view, iD != iD2 ? p1Var.f(p1Var.b(), iD2, p1Var.c(), p1Var.a()) : p1Var);
    }

    @Override // n.v
    public boolean n(n.k kVar) {
        Window.Callback callback;
        if (kVar != kVar.k()) {
            return true;
        }
        a0 a0Var = this.f5401v;
        if (!a0Var.f5262a0 || (callback = a0Var.G.getCallback()) == null || a0Var.f5273l0) {
            return true;
        }
        callback.onMenuOpened(108, kVar);
        return true;
    }
}
