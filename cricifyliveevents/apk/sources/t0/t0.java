package t0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import f9.z1;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.a f11808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p1 f11809b;

    public t0(View view, a7.a aVar) {
        p1 p1VarB;
        this.f11808a = aVar;
        WeakHashMap weakHashMap = m0.f11777a;
        p1 p1VarA = e0.a(view);
        if (p1VarA != null) {
            int i = Build.VERSION.SDK_INT;
            p1VarB = (i >= 34 ? new e1(p1VarA) : i >= 30 ? new d1(p1VarA) : i >= 29 ? new c1(p1VarA) : new a1(p1VarA)).b();
        } else {
            p1VarB = null;
        }
        this.f11809b = p1VarB;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int[] iArr;
        boolean z10;
        if (!view.isLaidOut()) {
            this.f11809b = p1.h(view, windowInsets);
            return u0.j(view, windowInsets);
        }
        p1 p1VarH = p1.h(view, windowInsets);
        m1 m1Var = p1VarH.f11791a;
        if (this.f11809b == null) {
            WeakHashMap weakHashMap = m0.f11777a;
            this.f11809b = e0.a(view);
        }
        if (this.f11809b == null) {
            this.f11809b = p1VarH;
            return u0.j(view, windowInsets);
        }
        a7.a aVarK = u0.k(view);
        if (aVarK != null && Objects.equals((p1) aVarK.f307w, p1VarH)) {
            return u0.j(view, windowInsets);
        }
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        p1 p1Var = this.f11809b;
        int i = 1;
        while (i <= 512) {
            l0.c cVarF = m1Var.f(i);
            l0.c cVarF2 = p1Var.f11791a.f(i);
            int i10 = cVarF.f7602a;
            int i11 = cVarF.f7605d;
            int i12 = cVarF.f7604c;
            int i13 = cVarF.f7603b;
            int i14 = cVarF2.f7602a;
            int i15 = cVarF2.f7605d;
            int i16 = cVarF2.f7604c;
            int i17 = cVarF2.f7603b;
            if (i10 > i14 || i13 > i17 || i12 > i16 || i11 > i15) {
                iArr = iArr2;
                z10 = true;
            } else {
                iArr = iArr2;
                z10 = false;
            }
            if (z10 != (i10 < i14 || i13 < i17 || i12 < i16 || i11 < i15)) {
                if (z10) {
                    iArr[0] = iArr[0] | i;
                } else {
                    iArr3[0] = iArr3[0] | i;
                }
            }
            i <<= 1;
            iArr2 = iArr;
        }
        int i18 = iArr2[0];
        int i19 = iArr3[0];
        int i20 = i18 | i19;
        if (i20 == 0) {
            this.f11809b = p1VarH;
            return u0.j(view, windowInsets);
        }
        p1 p1Var2 = this.f11809b;
        z0 z0Var = new z0(i20, (i18 & 8) != 0 ? u0.f11811e : (i19 & 8) != 0 ? u0.f : (i18 & 519) != 0 ? u0.f11812g : (i19 & 519) != 0 ? u0.f11813h : null, (i20 & 8) != 0 ? 160L : 250L);
        z0Var.f11831a.e(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(z0Var.f11831a.b());
        l0.c cVarF3 = m1Var.f(i20);
        l0.c cVarF4 = p1Var2.f11791a.f(i20);
        int iMin = Math.min(cVarF3.f7602a, cVarF4.f7602a);
        int i21 = cVarF3.f7603b;
        int i22 = cVarF4.f7603b;
        int iMin2 = Math.min(i21, i22);
        int i23 = cVarF3.f7604c;
        int i24 = cVarF4.f7604c;
        int iMin3 = Math.min(i23, i24);
        int i25 = cVarF3.f7605d;
        int i26 = cVarF4.f7605d;
        nb.w wVar = new nb.w(19, l0.c.c(iMin, iMin2, iMin3, Math.min(i25, i26)), l0.c.c(Math.max(cVarF3.f7602a, cVarF4.f7602a), Math.max(i21, i22), Math.max(i23, i24), Math.max(i25, i26)));
        u0.g(view, z0Var, p1VarH, false);
        duration.addUpdateListener(new s0(z0Var, p1VarH, p1Var2, i20, view));
        duration.addListener(new fa.b(z0Var, view, 3));
        q.a(view, new z1(view, z0Var, wVar, duration, 10));
        this.f11809b = p1VarH;
        return u0.j(view, windowInsets);
    }
}
