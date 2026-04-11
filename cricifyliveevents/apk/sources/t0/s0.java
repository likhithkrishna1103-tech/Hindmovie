package t0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z0 f11799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p1 f11800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p1 f11801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f11803e;

    public s0(z0 z0Var, p1 p1Var, p1 p1Var2, int i, View view) {
        this.f11799a = z0Var;
        this.f11800b = p1Var;
        this.f11801c = p1Var2;
        this.f11802d = i;
        this.f11803e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        z0 z0Var = this.f11799a;
        y0 y0Var = z0Var.f11831a;
        y0Var.e(animatedFraction);
        p1 p1Var = this.f11800b;
        m1 m1Var = p1Var.f11791a;
        float fC = y0Var.c();
        PathInterpolator pathInterpolator = u0.f11811e;
        int i = Build.VERSION.SDK_INT;
        f1 e1Var = i >= 34 ? new e1(p1Var) : i >= 30 ? new d1(p1Var) : i >= 29 ? new c1(p1Var) : new a1(p1Var);
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((this.f11802d & i10) == 0) {
                e1Var.c(i10, m1Var.f(i10));
            } else {
                l0.c cVarF = m1Var.f(i10);
                l0.c cVarF2 = this.f11801c.f11791a.f(i10);
                float f = 1.0f - fC;
                e1Var.c(i10, p1.e(cVarF, (int) (((double) ((cVarF.f7602a - cVarF2.f7602a) * f)) + 0.5d), (int) (((double) ((cVarF.f7603b - cVarF2.f7603b) * f)) + 0.5d), (int) (((double) ((cVarF.f7604c - cVarF2.f7604c) * f)) + 0.5d), (int) (((double) ((cVarF.f7605d - cVarF2.f7605d) * f)) + 0.5d)));
            }
        }
        u0.h(this.f11803e, e1Var.b(), Collections.singletonList(z0Var));
    }
}
