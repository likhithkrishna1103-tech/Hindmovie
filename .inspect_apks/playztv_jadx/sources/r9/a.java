package r9;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i5.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f11551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SideSheetBehavior f11552k;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i) {
        this.f11551j = i;
        this.f11552k = sideSheetBehavior;
    }

    @Override // i5.a
    public final boolean B(float f) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (f > 0.0f) {
                }
                break;
            default:
                if (f < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // i5.a
    public final boolean D(View view) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (view.getRight() < (s() - u()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (s() + this.f11552k.G) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // i5.a
    public final boolean E(float f, float f4) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (Math.abs(f) <= Math.abs(f4) || Math.abs(f) <= 500) {
                }
                break;
            default:
                if (Math.abs(f) <= Math.abs(f4) || Math.abs(f) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // i5.a
    public final boolean P(View view, float f) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.f11552k;
                float fAbs = Math.abs((f * sideSheetBehavior.E) + left);
                sideSheetBehavior.getClass();
                if (fAbs > 0.5f) {
                }
                break;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.f11552k;
                float fAbs2 = Math.abs((f * sideSheetBehavior2.E) + right);
                sideSheetBehavior2.getClass();
                if (fAbs2 > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // i5.a
    public final void R(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                marginLayoutParams.leftMargin = i;
                break;
            default:
                marginLayoutParams.rightMargin = i;
                break;
        }
    }

    @Override // i5.a
    public final void S(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i10) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i <= this.f11552k.G) {
                    marginLayoutParams.leftMargin = i10;
                }
                break;
            default:
                int i11 = this.f11552k.G;
                if (i <= i11) {
                    marginLayoutParams.rightMargin = i11 - i;
                }
                break;
        }
    }

    @Override // i5.a
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // i5.a
    public final float d(int i) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                float fU = u();
                return (i - fU) / (s() - fU);
            default:
                float f = this.f11552k.G;
                return (f - i) / (f - s());
        }
    }

    @Override // i5.a
    public final int r(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // i5.a
    public final int s() {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = this.f11552k;
                return Math.max(0, sideSheetBehavior.H + sideSheetBehavior.I);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f11552k;
                return Math.max(0, (sideSheetBehavior2.G - sideSheetBehavior2.F) - sideSheetBehavior2.I);
        }
    }

    @Override // i5.a
    public final int u() {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = this.f11552k;
                return (-sideSheetBehavior.F) - sideSheetBehavior.I;
            default:
                return this.f11552k.G;
        }
    }

    @Override // i5.a
    public final int v() {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f11552k.I;
            default:
                return this.f11552k.G;
        }
    }

    @Override // i5.a
    public final int w() {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return -this.f11552k.F;
            default:
                return s();
        }
    }

    @Override // i5.a
    public final int x(View view) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return view.getRight() + this.f11552k.I;
            default:
                return view.getLeft() - this.f11552k.I;
        }
    }

    @Override // i5.a
    public final int y(CoordinatorLayout coordinatorLayout) {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // i5.a
    public final int z() {
        switch (this.f11551j) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 1;
            default:
                return 0;
        }
    }
}
