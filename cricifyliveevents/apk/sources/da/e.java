package da;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends ViewGroup {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3612v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3613w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3614x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3615y;

    public int getItemSpacing() {
        return this.f3613w;
    }

    public int getLineSpacing() {
        return this.f3612v;
    }

    public int getRowCount() {
        return this.f3615y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        int marginEnd;
        int marginStart;
        boolean z11;
        if (getChildCount() == 0) {
            this.f3615y = 0;
            return;
        }
        boolean z12 = true;
        this.f3615y = 1;
        boolean z13 = getLayoutDirection() == 1;
        int paddingRight = z13 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z13 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i13 = 0;
        int measuredWidth = paddingRight;
        int i14 = paddingTop;
        while (i13 < getChildCount()) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(k9.f.row_index_key, -1);
                z11 = z12;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = marginLayoutParams.getMarginStart();
                    marginEnd = marginLayoutParams.getMarginEnd();
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + measuredWidth + marginStart;
                int i15 = i11 - i;
                int i16 = i15 - paddingLeft;
                z11 = z12;
                if (!this.f3614x && measuredWidth2 > i16) {
                    measuredWidth2 = childAt.getMeasuredWidth() + paddingRight + marginStart;
                    i14 = paddingTop + this.f3612v;
                    this.f3615y++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(k9.f.row_index_key, Integer.valueOf(this.f3615y - 1));
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                if (z13) {
                    childAt.layout(i15 - measuredWidth2, i14, (i15 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(measuredWidth + marginStart, i14, measuredWidth2, measuredHeight);
                }
                measuredWidth += childAt.getMeasuredWidth() + marginStart + marginEnd + this.f3613w;
                paddingTop = measuredHeight;
            }
            i13++;
            z12 = z11;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        int i11;
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i10);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.leftMargin;
                    i12 = marginLayoutParams.rightMargin;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = i12;
                if (childAt.getMeasuredWidth() + paddingLeft + i13 > paddingRight && !((ChipGroup) this).f3614x) {
                    paddingLeft = getPaddingLeft();
                    i15 = paddingTop + this.f3612v;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i13;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i13 + i18 + this.f3613w + paddingLeft;
                if (i17 == getChildCount() - 1) {
                    i16 += i18;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i16;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i11 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i11 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i11) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i) {
        this.f3613w = i;
    }

    public void setLineSpacing(int i) {
        this.f3612v = i;
    }

    public void setSingleLine(boolean z10) {
        this.f3614x = z10;
    }
}
