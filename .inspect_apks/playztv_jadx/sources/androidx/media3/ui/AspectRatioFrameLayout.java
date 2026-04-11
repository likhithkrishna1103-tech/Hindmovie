package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bumptech.glide.manager.o;
import i4.a;
import i4.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f1589x = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final o f1590u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f1591v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1592w;

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1592w = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, n0.AspectRatioFrameLayout, 0, 0);
            try {
                this.f1592w = typedArrayObtainStyledAttributes.getInt(n0.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f1590u = new o(this);
    }

    public int getResizeMode() {
        return this.f1592w;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        float f;
        float f4;
        super.onMeasure(i, i10);
        if (this.f1591v <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f10 = measuredWidth;
        float f11 = measuredHeight;
        float f12 = (this.f1591v / (f10 / f11)) - 1.0f;
        float fAbs = Math.abs(f12);
        o oVar = this.f1590u;
        if (fAbs <= 0.01f) {
            if (oVar.f2847v) {
                return;
            }
            oVar.f2847v = true;
            ((AspectRatioFrameLayout) oVar.f2848w).post(oVar);
            return;
        }
        int i11 = this.f1592w;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    f = this.f1591v;
                } else if (i11 == 4) {
                    if (f12 > 0.0f) {
                        f = this.f1591v;
                    } else {
                        f4 = this.f1591v;
                    }
                }
                measuredWidth = (int) (f11 * f);
            } else {
                f4 = this.f1591v;
            }
            measuredHeight = (int) (f10 / f4);
        } else if (f12 > 0.0f) {
            f4 = this.f1591v;
            measuredHeight = (int) (f10 / f4);
        } else {
            f = this.f1591v;
            measuredWidth = (int) (f11 * f);
        }
        if (!oVar.f2847v) {
            oVar.f2847v = true;
            ((AspectRatioFrameLayout) oVar.f2848w).post(oVar);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f) {
        if (this.f1591v != f) {
            this.f1591v = f;
            requestLayout();
        }
    }

    public void setResizeMode(int i) {
        if (this.f1592w != i) {
            this.f1592w = i;
            requestLayout();
        }
    }

    public void setAspectRatioListener(a aVar) {
    }
}
