package n;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends b0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f0 f8390e;
    public Drawable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f8391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f8392h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8393j;

    public g0(f0 f0Var) {
        super(f0Var);
        this.f8391g = null;
        this.f8392h = null;
        this.i = false;
        this.f8393j = false;
        this.f8390e = f0Var;
    }

    @Override // n.b0
    public final void b(AttributeSet attributeSet, int i) {
        super.b(attributeSet, i);
        f0 f0Var = this.f8390e;
        kc.b bVarD = kc.b.D(f0Var.getContext(), attributeSet, g.j.AppCompatSeekBar, i);
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        q0.o0.m(f0Var, f0Var.getContext(), g.j.AppCompatSeekBar, attributeSet, (TypedArray) bVarD.f7621w, i);
        Drawable drawableT = bVarD.t(g.j.AppCompatSeekBar_android_thumb);
        if (drawableT != null) {
            f0Var.setThumb(drawableT);
        }
        Drawable drawableS = bVarD.s(g.j.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f = drawableS;
        if (drawableS != null) {
            drawableS.setCallback(f0Var);
            drawableS.setLayoutDirection(f0Var.getLayoutDirection());
            if (drawableS.isStateful()) {
                drawableS.setState(f0Var.getDrawableState());
            }
            f();
        }
        f0Var.invalidate();
        if (typedArray.hasValue(g.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f8392h = n1.b(typedArray.getInt(g.j.AppCompatSeekBar_tickMarkTintMode, -1), this.f8392h);
            this.f8393j = true;
        }
        if (typedArray.hasValue(g.j.AppCompatSeekBar_tickMarkTint)) {
            this.f8391g = bVarD.q(g.j.AppCompatSeekBar_tickMarkTint);
            this.i = true;
        }
        bVarD.E();
        f();
    }

    public final void f() {
        Drawable drawable = this.f;
        if (drawable != null) {
            if (this.i || this.f8393j) {
                Drawable drawableMutate = drawable.mutate();
                this.f = drawableMutate;
                if (this.i) {
                    drawableMutate.setTintList(this.f8391g);
                }
                if (this.f8393j) {
                    this.f.setTintMode(this.f8392h);
                }
                if (this.f.isStateful()) {
                    this.f.setState(this.f8390e.getDrawableState());
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        if (this.f != null) {
            int max = this.f8390e.getMax();
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
