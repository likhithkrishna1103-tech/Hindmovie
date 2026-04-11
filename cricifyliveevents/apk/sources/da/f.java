package da;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import o.y1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f extends y1 {
    public Drawable K;
    public final Rect L;
    public final Rect M;
    public int N;
    public final boolean O;
    public boolean P;

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.L = new Rect();
        this.M = new Rect();
        this.N = 119;
        this.O = true;
        this.P = false;
        int[] iArr = k9.l.ForegroundLinearLayout;
        d0.a(context, attributeSet, 0, 0);
        d0.b(context, attributeSet, iArr, 0, 0, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        this.N = typedArrayObtainStyledAttributes.getInt(k9.l.ForegroundLinearLayout_android_foregroundGravity, this.N);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(k9.l.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.O = typedArrayObtainStyledAttributes.getBoolean(k9.l.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.K;
        if (drawable != null) {
            if (this.P) {
                this.P = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z10 = this.O;
                Rect rect = this.L;
                if (z10) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i = this.N;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.M;
                Gravity.apply(i, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f, float f10) {
        super.drawableHotspotChanged(f, f10);
        Drawable drawable = this.K;
        if (drawable != null) {
            drawable.setHotspot(f, f10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.K;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.K.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.K;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.N;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.K;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // o.y1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        this.P = z10 | this.P;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        this.P = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.K;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.K);
            }
            this.K = drawable;
            this.P = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.N == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.N != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.N = i;
            if (i == 119 && this.K != null) {
                this.K.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.K;
    }
}
