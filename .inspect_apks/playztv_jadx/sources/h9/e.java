package h9;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f5982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f5983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f5984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f5985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f5986e;
    public final /* synthetic */ float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ float f5987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Matrix f5988h;
    public final /* synthetic */ i i;

    public e(i iVar, float f, float f4, float f10, float f11, float f12, float f13, float f14, Matrix matrix) {
        this.i = iVar;
        this.f5982a = f;
        this.f5983b = f4;
        this.f5984c = f10;
        this.f5985d = f11;
        this.f5986e = f12;
        this.f = f13;
        this.f5987g = f14;
        this.f5988h = matrix;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        i iVar = this.i;
        iVar.f6011s.setAlpha(q8.a.b(this.f5982a, this.f5983b, 0.0f, 0.2f, fFloatValue));
        FloatingActionButton floatingActionButton = iVar.f6011s;
        float f = this.f5984c;
        float f4 = this.f5985d;
        floatingActionButton.setScaleX(q8.a.a(f, f4, fFloatValue));
        iVar.f6011s.setScaleY(q8.a.a(this.f5986e, f4, fFloatValue));
        float f10 = this.f;
        float f11 = this.f5987g;
        iVar.f6008p = q8.a.a(f10, f11, fFloatValue);
        float fA = q8.a.a(f10, f11, fFloatValue);
        Matrix matrix = this.f5988h;
        iVar.a(fA, matrix);
        iVar.f6011s.setImageMatrix(matrix);
    }
}
