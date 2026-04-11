package q0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;
import k8.l2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c3.e f10510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r1 f10511b;

    public w0(View view, c3.e eVar) {
        r1 r1VarB;
        this.f10510a = eVar;
        WeakHashMap weakHashMap = o0.f10475a;
        r1 r1VarA = g0.a(view);
        if (r1VarA != null) {
            int i = Build.VERSION.SDK_INT;
            r1VarB = (i >= 34 ? new g1(r1VarA) : i >= 30 ? new f1(r1VarA) : i >= 29 ? new d1(r1VarA) : new c1(r1VarA)).b();
        } else {
            r1VarB = null;
        }
        this.f10511b = r1VarB;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int[] iArr;
        boolean z2;
        if (!view.isLaidOut()) {
            this.f10511b = r1.h(view, windowInsets);
            return x0.j(view, windowInsets);
        }
        r1 r1VarH = r1.h(view, windowInsets);
        o1 o1Var = r1VarH.f10492a;
        if (this.f10511b == null) {
            WeakHashMap weakHashMap = o0.f10475a;
            this.f10511b = g0.a(view);
        }
        if (this.f10511b == null) {
            this.f10511b = r1VarH;
            return x0.j(view, windowInsets);
        }
        c3.e eVarK = x0.k(view);
        if (eVarK != null && Objects.equals((r1) eVarK.f2454v, r1VarH)) {
            return x0.j(view, windowInsets);
        }
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        r1 r1Var = this.f10511b;
        int i = 1;
        while (i <= 512) {
            i0.d dVarF = o1Var.f(i);
            i0.d dVarF2 = r1Var.f10492a.f(i);
            int i10 = dVarF.f6161a;
            int i11 = dVarF.f6164d;
            int i12 = dVarF.f6163c;
            int i13 = dVarF.f6162b;
            int i14 = dVarF2.f6161a;
            int i15 = dVarF2.f6164d;
            int i16 = dVarF2.f6163c;
            int i17 = dVarF2.f6162b;
            if (i10 > i14 || i13 > i17 || i12 > i16 || i11 > i15) {
                iArr = iArr2;
                z2 = true;
            } else {
                iArr = iArr2;
                z2 = false;
            }
            if (z2 != (i10 < i14 || i13 < i17 || i12 < i16 || i11 < i15)) {
                if (z2) {
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
            this.f10511b = r1VarH;
            return x0.j(view, windowInsets);
        }
        r1 r1Var2 = this.f10511b;
        b1 b1Var = new b1(i20, (i18 & 8) != 0 ? x0.f10512e : (i19 & 8) != 0 ? x0.f : (i18 & 519) != 0 ? x0.f10513g : (i19 & 519) != 0 ? x0.f10514h : null, (i20 & 8) != 0 ? 160L : 250L);
        b1Var.f10421a.e(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(b1Var.f10421a.b());
        i0.d dVarF3 = o1Var.f(i20);
        i0.d dVarF4 = r1Var2.f10492a.f(i20);
        int iMin = Math.min(dVarF3.f6161a, dVarF4.f6161a);
        int i21 = dVarF3.f6162b;
        int i22 = dVarF4.f6162b;
        int iMin2 = Math.min(i21, i22);
        int i23 = dVarF3.f6163c;
        int i24 = dVarF4.f6163c;
        int iMin3 = Math.min(i23, i24);
        int i25 = dVarF3.f6164d;
        int i26 = dVarF4.f6164d;
        pb.c cVar = new pb.c(i0.d.c(iMin, iMin2, iMin3, Math.min(i25, i26)), 1, i0.d.c(Math.max(dVarF3.f6161a, dVarF4.f6161a), Math.max(i21, i22), Math.max(i23, i24), Math.max(i25, i26)));
        x0.g(view, b1Var, r1VarH, false);
        duration.addUpdateListener(new v0(b1Var, r1VarH, r1Var2, i20, view));
        duration.addListener(new g5.k(b1Var, view, 3));
        r.a(view, new l2(view, b1Var, cVar, duration));
        this.f10511b = r1VarH;
        return x0.j(view, windowInsets);
    }
}
