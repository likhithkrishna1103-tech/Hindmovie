package o;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d0 f9200e;
    public Drawable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f9201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f9202h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9203j;

    public e0(d0 d0Var) {
        super(d0Var);
        this.f9201g = null;
        this.f9202h = null;
        this.i = false;
        this.f9203j = false;
        this.f9200e = d0Var;
    }

    @Override // o.z
    public final void b(AttributeSet attributeSet, int i) {
        super.b(attributeSet, i);
        d0 d0Var = this.f9200e;
        l7.a aVarF = l7.a.F(d0Var.getContext(), attributeSet, g.j.AppCompatSeekBar, i);
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        t0.m0.m(d0Var, d0Var.getContext(), g.j.AppCompatSeekBar, attributeSet, (TypedArray) aVarF.f7867x, i);
        Drawable drawableV = aVarF.v(g.j.AppCompatSeekBar_android_thumb);
        if (drawableV != null) {
            d0Var.setThumb(drawableV);
        }
        Drawable drawableU = aVarF.u(g.j.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f = drawableU;
        if (drawableU != null) {
            drawableU.setCallback(d0Var);
            drawableU.setLayoutDirection(d0Var.getLayoutDirection());
            if (drawableU.isStateful()) {
                drawableU.setState(d0Var.getDrawableState());
            }
            f();
        }
        d0Var.invalidate();
        if (typedArray.hasValue(g.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f9202h = n1.c(typedArray.getInt(g.j.AppCompatSeekBar_tickMarkTintMode, -1), this.f9202h);
            this.f9203j = true;
        }
        if (typedArray.hasValue(g.j.AppCompatSeekBar_tickMarkTint)) {
            this.f9201g = aVarF.r(g.j.AppCompatSeekBar_tickMarkTint);
            this.i = true;
        }
        aVarF.G();
        f();
    }

    public final void f() {
        Drawable drawable = this.f;
        if (drawable != null) {
            if (this.i || this.f9203j) {
                Drawable drawableMutate = drawable.mutate();
                this.f = drawableMutate;
                if (this.i) {
                    drawableMutate.setTintList(this.f9201g);
                }
                if (this.f9203j) {
                    this.f.setTintMode(this.f9202h);
                }
                if (this.f.isStateful()) {
                    this.f.setState(this.f9200e.getDrawableState());
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        if (this.f != null) {
            int max = this.f9200e.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f.getIntrinsicWidth();
                int intrinsicHeight = this.f.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i10 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f.setBounds(-i, -i10, i, i10);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i11 = 0; i11 <= max; i11++) {
                    this.f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
