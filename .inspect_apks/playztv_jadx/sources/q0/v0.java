package q0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f10504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r1 f10505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r1 f10506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f10508e;

    public v0(b1 b1Var, r1 r1Var, r1 r1Var2, int i, View view) {
        this.f10504a = b1Var;
        this.f10505b = r1Var;
        this.f10506c = r1Var2;
        this.f10507d = i;
        this.f10508e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        b1 b1Var = this.f10504a;
        a1 a1Var = b1Var.f10421a;
        a1Var.e(animatedFraction);
        r1 r1Var = this.f10505b;
        o1 o1Var = r1Var.f10492a;
        float fC = a1Var.c();
        PathInterpolator pathInterpolator = x0.f10512e;
        int i = Build.VERSION.SDK_INT;
        h1 g1Var = i >= 34 ? new g1(r1Var) : i >= 30 ? new f1(r1Var) : i >= 29 ? new d1(r1Var) : new c1(r1Var);
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((this.f10507d & i10) == 0) {
                g1Var.c(i10, o1Var.f(i10));
            } else {
                i0.d dVarF = o1Var.f(i10);
                i0.d dVarF2 = this.f10506c.f10492a.f(i10);
                float f = 1.0f - fC;
                g1Var.c(i10, r1.e(dVarF, (int) (((double) ((dVarF.f6161a - dVarF2.f6161a) * f)) + 0.5d), (int) (((double) ((dVarF.f6162b - dVarF2.f6162b) * f)) + 0.5d), (int) (((double) ((dVarF.f6163c - dVarF2.f6163c) * f)) + 0.5d), (int) (((double) ((dVarF.f6164d - dVarF2.f6164d) * f)) + 0.5d)));
            }
        }
        x0.h(this.f10508e, g1Var.b(), Collections.singletonList(b1Var));
    }
}
