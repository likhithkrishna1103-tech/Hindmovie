package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import g.f;
import g.j;
import o.r2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public Drawable A;
    public final boolean B;
    public boolean C;
    public final int D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f525v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f526w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f527x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f528y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f529z;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new o.a(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.f528y = typedArrayObtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.f529z = typedArrayObtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == f.split_action_bar) {
            this.B = true;
            this.A = typedArrayObtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.B ? this.f528y != null || this.f529z != null : this.A != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f528y;
        if (drawable != null && drawable.isStateful()) {
            this.f528y.setState(getDrawableState());
        }
        Drawable drawable2 = this.f529z;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f529z.setState(getDrawableState());
        }
        Drawable drawable3 = this.A;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.A.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f528y;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f529z;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.A;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f526w = findViewById(f.action_bar);
        this.f527x = findViewById(f.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f525v || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        boolean z11 = true;
        if (this.B) {
            Drawable drawable = this.A;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z11 = false;
            }
        } else {
            if (this.f528y == null) {
                z11 = false;
            } else if (this.f526w.getVisibility() == 0) {
                this.f528y.setBounds(this.f526w.getLeft(), this.f526w.getTop(), this.f526w.getRight(), this.f526w.getBottom());
            } else {
                View view = this.f527x;
                if (view == null || view.getVisibility() != 0) {
                    this.f528y.setBounds(0, 0, 0, 0);
                } else {
                    this.f528y.setBounds(this.f527x.getLeft(), this.f527x.getTop(), this.f527x.getRight(), this.f527x.getBottom());
                }
            }
            this.C = false;
        }
        if (z11) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        int i11;
        if (this.f526w == null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE && (i11 = this.D) >= 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(i11, View.MeasureSpec.getSize(i10)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i10);
        if (this.f526w == null) {
            return;
        }
        View.MeasureSpec.getMode(i10);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f528y;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f528y);
        }
        this.f528y = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f526w;
            if (view != null) {
                this.f528y.setBounds(view.getLeft(), this.f526w.getTop(), this.f526w.getRight(), this.f526w.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.B ? !(this.f528y != null || this.f529z != null) : this.A == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.A;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.A);
        }
        this.A = drawable;
        boolean z10 = this.B;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z10 && (drawable2 = this.A) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z10 ? !(this.f528y != null || this.f529z != null) : this.A == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f529z;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f529z);
        }
        this.f529z = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.C && this.f529z != null) {
                throw null;
            }
        }
        boolean z10 = false;
        if (!this.B ? !(this.f528y != null || this.f529z != null) : this.A == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z10) {
        this.f525v = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.f528y;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f529z;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.A;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f528y;
        boolean z10 = this.B;
        if (drawable == drawable2 && !z10) {
            return true;
        }
        if (drawable == this.f529z && this.C) {
            return true;
        }
        return (drawable == this.A && z10) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    public void setTabContainer(r2 r2Var) {
    }
}
