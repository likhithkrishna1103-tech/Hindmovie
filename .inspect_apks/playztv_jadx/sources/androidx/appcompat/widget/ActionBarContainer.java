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
import n.q2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public final boolean A;
    public boolean B;
    public final int C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f866u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f867v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f868w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f869x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f870y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f871z;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new n.a(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.f869x = typedArrayObtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.f870y = typedArrayObtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        boolean z2 = true;
        if (getId() == f.split_action_bar) {
            this.A = true;
            this.f871z = typedArrayObtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.A ? this.f869x != null || this.f870y != null : this.f871z != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f869x;
        if (drawable != null && drawable.isStateful()) {
            this.f869x.setState(getDrawableState());
        }
        Drawable drawable2 = this.f870y;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f870y.setState(getDrawableState());
        }
        Drawable drawable3 = this.f871z;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f871z.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f869x;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f870y;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f871z;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f867v = findViewById(f.action_bar);
        this.f868w = findViewById(f.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f866u || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        boolean z10 = true;
        if (this.A) {
            Drawable drawable = this.f871z;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z10 = false;
            }
        } else {
            if (this.f869x == null) {
                z10 = false;
            } else if (this.f867v.getVisibility() == 0) {
                this.f869x.setBounds(this.f867v.getLeft(), this.f867v.getTop(), this.f867v.getRight(), this.f867v.getBottom());
            } else {
                View view = this.f868w;
                if (view == null || view.getVisibility() != 0) {
                    this.f869x.setBounds(0, 0, 0, 0);
                } else {
                    this.f869x.setBounds(this.f868w.getLeft(), this.f868w.getTop(), this.f868w.getRight(), this.f868w.getBottom());
                }
            }
            this.B = false;
        }
        if (z10) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        int i11;
        if (this.f867v == null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE && (i11 = this.C) >= 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(i11, View.MeasureSpec.getSize(i10)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i10);
        if (this.f867v == null) {
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
        Drawable drawable2 = this.f869x;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f869x);
        }
        this.f869x = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f867v;
            if (view != null) {
                this.f869x.setBounds(view.getLeft(), this.f867v.getTop(), this.f867v.getRight(), this.f867v.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.A ? !(this.f869x != null || this.f870y != null) : this.f871z == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f871z;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f871z);
        }
        this.f871z = drawable;
        boolean z2 = this.A;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z2 && (drawable2 = this.f871z) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z2 ? !(this.f869x != null || this.f870y != null) : this.f871z == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f870y;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f870y);
        }
        this.f870y = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.B && this.f870y != null) {
                throw null;
            }
        }
        boolean z2 = false;
        if (!this.A ? !(this.f869x != null || this.f870y != null) : this.f871z == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z2) {
        this.f866u = z2;
        setDescendantFocusability(z2 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z2 = i == 0;
        Drawable drawable = this.f869x;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f870y;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f871z;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f869x;
        boolean z2 = this.A;
        if (drawable == drawable2 && !z2) {
            return true;
        }
        if (drawable == this.f870y && this.B) {
            return true;
        }
        return (drawable == this.f871z && z2) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    public void setTabContainer(q2 q2Var) {
    }
}
