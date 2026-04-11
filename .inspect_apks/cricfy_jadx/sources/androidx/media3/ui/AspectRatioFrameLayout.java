package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bumptech.glide.manager.p;
import m4.a;
import m4.l0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f1282y = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p f1283v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f1284w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1285x;

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1285x = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, l0.AspectRatioFrameLayout, 0, 0);
            try {
                this.f1285x = typedArrayObtainStyledAttributes.getInt(l0.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f1283v = new p(this);
    }

    public int getResizeMode() {
        return this.f1285x;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        float f;
        float f10;
        super.onMeasure(i, i10);
        if (this.f1284w <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f11 = measuredWidth;
        float f12 = measuredHeight;
        float f13 = (this.f1284w / (f11 / f12)) - 1.0f;
        float fAbs = Math.abs(f13);
        p pVar = this.f1283v;
        if (fAbs <= 0.01f) {
            if (pVar.f2275w) {
                return;
            }
            pVar.f2275w = true;
            ((AspectRatioFrameLayout) pVar.f2276x).post(pVar);
            return;
        }
        int i11 = this.f1285x;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    f = this.f1284w;
                } else if (i11 == 4) {
                    if (f13 > 0.0f) {
                        f = this.f1284w;
                    } else {
                        f10 = this.f1284w;
                    }
                }
                measuredWidth = (int) (f12 * f);
            } else {
                f10 = this.f1284w;
            }
            measuredHeight = (int) (f11 / f10);
        } else if (f13 > 0.0f) {
            f10 = this.f1284w;
            measuredHeight = (int) (f11 / f10);
        } else {
            f = this.f1284w;
            measuredWidth = (int) (f12 * f);
        }
        if (!pVar.f2275w) {
            pVar.f2275w = true;
            ((AspectRatioFrameLayout) pVar.f2276x).post(pVar);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f) {
        if (this.f1284w != f) {
            this.f1284w = f;
            requestLayout();
        }
    }

    public void setResizeMode(int i) {
        if (this.f1285x != i) {
            this.f1285x = i;
            requestLayout();
        }
    }

    public void setAspectRatioListener(a aVar) {
    }
}
