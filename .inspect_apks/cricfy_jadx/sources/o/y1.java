package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y1 extends ViewGroup {
    public int A;
    public float B;
    public boolean C;
    public int[] D;
    public int[] E;
    public Drawable F;
    public int G;
    public int H;
    public int I;
    public int J;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f9411v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9412w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9413x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9414y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9415z;

    public y1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9411v = true;
        this.f9412w = -1;
        this.f9413x = 0;
        this.f9415z = 8388659;
        l7.a aVarF = l7.a.F(context, attributeSet, g.j.LinearLayoutCompat, i);
        t0.m0.m(this, context, g.j.LinearLayoutCompat, attributeSet, (TypedArray) aVarF.f7867x, i);
        int i10 = g.j.LinearLayoutCompat_android_orientation;
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        int i11 = typedArray.getInt(i10, -1);
        if (i11 >= 0) {
            setOrientation(i11);
        }
        int i12 = typedArray.getInt(g.j.LinearLayoutCompat_android_gravity, -1);
        if (i12 >= 0) {
            setGravity(i12);
        }
        boolean z10 = typedArray.getBoolean(g.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!z10) {
            setBaselineAligned(z10);
        }
        this.B = typedArray.getFloat(g.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f9412w = typedArray.getInt(g.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.C = typedArray.getBoolean(g.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(aVarF.u(g.j.LinearLayoutCompat_divider));
        this.I = typedArray.getInt(g.j.LinearLayoutCompat_showDividers, 0);
        this.J = typedArray.getDimensionPixelSize(g.j.LinearLayoutCompat_dividerPadding, 0);
        aVarF.G();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof x1;
    }

    public final void d(Canvas canvas, int i) {
        this.F.setBounds(getPaddingLeft() + this.J, i, (getWidth() - getPaddingRight()) - this.J, this.H + i);
        this.F.draw(canvas);
    }

    public final void e(Canvas canvas, int i) {
        this.F.setBounds(i, getPaddingTop() + this.J, this.G + i, (getHeight() - getPaddingBottom()) - this.J);
        this.F.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public x1 generateDefaultLayoutParams() {
        int i = this.f9414y;
        if (i == 0) {
            return new x1(-2, -2);
        }
        if (i == 1) {
            return new x1(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public x1 generateLayoutParams(AttributeSet attributeSet) {
        return new x1(getContext(), attributeSet);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f9412w < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i10 = this.f9412w;
        if (childCount <= i10) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i10);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f9412w == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f9413x;
        if (this.f9414y == 1 && (i = this.f9415z & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.A) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.A;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((x1) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f9412w;
    }

    public Drawable getDividerDrawable() {
        return this.F;
    }

    public int getDividerPadding() {
        return this.J;
    }

    public int getDividerWidth() {
        return this.G;
    }

    public int getGravity() {
        return this.f9415z;
    }

    public int getOrientation() {
        return this.f9414y;
    }

    public int getShowDividers() {
        return this.I;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.B;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public x1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof x1 ? new x1((x1) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new x1((ViewGroup.MarginLayoutParams) layoutParams) : new x1(layoutParams);
    }

    public final boolean i(int i) {
        if (i == 0) {
            return (this.I & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.I & 4) != 0;
        }
        if ((this.I & 2) != 0) {
            for (int i10 = i - 1; i10 >= 0; i10--) {
                if (getChildAt(i10).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        if (this.F == null) {
            return;
        }
        int i10 = 0;
        if (this.f9414y == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i10 < virtualChildCount) {
                View childAt = getChildAt(i10);
                if (childAt != null && childAt.getVisibility() != 8 && i(i10)) {
                    d(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((x1) childAt.getLayoutParams())).topMargin) - this.H);
                }
                i10++;
            }
            if (i(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                d(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.H : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((x1) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z10 = x3.f9407a;
        boolean z11 = getLayoutDirection() == 1;
        while (i10 < virtualChildCount2) {
            View childAt3 = getChildAt(i10);
            if (childAt3 != null && childAt3.getVisibility() != 8 && i(i10)) {
                x1 x1Var = (x1) childAt3.getLayoutParams();
                e(canvas, z11 ? childAt3.getRight() + ((LinearLayout.LayoutParams) x1Var).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) x1Var).leftMargin) - this.G);
            }
            i10++;
        }
        if (i(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                x1 x1Var2 = (x1) childAt4.getLayoutParams();
                if (z11) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) x1Var2).leftMargin;
                    i = this.G;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) x1Var2).rightMargin;
                }
            } else if (z11) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.G;
                right = left - i;
            }
            e(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a9  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.y1.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:228:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 2150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.y1.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z10) {
        this.f9411v = z10;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f9412w = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.F) {
            return;
        }
        this.F = drawable;
        if (drawable != null) {
            this.G = drawable.getIntrinsicWidth();
            this.H = drawable.getIntrinsicHeight();
        } else {
            this.G = 0;
            this.H = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.J = i;
    }

    public void setGravity(int i) {
        if (this.f9415z != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f9415z = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i10 = i & 8388615;
        int i11 = this.f9415z;
        if ((8388615 & i11) != i10) {
            this.f9415z = i10 | ((-8388616) & i11);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.C = z10;
    }

    public void setOrientation(int i) {
        if (this.f9414y != i) {
            this.f9414y = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.I) {
            requestLayout();
        }
        this.I = i;
    }

    public void setVerticalGravity(int i) {
        int i10 = i & 112;
        int i11 = this.f9415z;
        if ((i11 & 112) != i10) {
            this.f9415z = i10 | (i11 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.B = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
