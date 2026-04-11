package la;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.bumptech.glide.f;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SideSheetBehavior f7940b;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i) {
        this.f7939a = i;
        this.f7940b = sideSheetBehavior;
    }

    @Override // com.bumptech.glide.f
    public final boolean A(float f, float f10) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (Math.abs(f) <= Math.abs(f10) || Math.abs(f) <= 500) {
                }
                break;
            default:
                if (Math.abs(f) <= Math.abs(f10) || Math.abs(f) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.f
    public final boolean F(View view, float f) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.f7940b;
                float fAbs = Math.abs((f * sideSheetBehavior.F) + left);
                sideSheetBehavior.getClass();
                if (fAbs > 0.5f) {
                }
                break;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.f7940b;
                float fAbs2 = Math.abs((f * sideSheetBehavior2.F) + right);
                sideSheetBehavior2.getClass();
                if (fAbs2 > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.f
    public final void J(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                marginLayoutParams.leftMargin = i;
                break;
            default:
                marginLayoutParams.rightMargin = i;
                break;
        }
    }

    @Override // com.bumptech.glide.f
    public final void K(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i10) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i <= this.f7940b.H) {
                    marginLayoutParams.leftMargin = i10;
                }
                break;
            default:
                int i11 = this.f7940b.H;
                if (i <= i11) {
                    marginLayoutParams.rightMargin = i11 - i;
                }
                break;
        }
    }

    @Override // com.bumptech.glide.f
    public final int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // com.bumptech.glide.f
    public final float c(int i) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                float fR = r();
                return (i - fR) / (q() - fR);
            default:
                float f = this.f7940b.H;
                return (f - i) / (f - q());
        }
    }

    @Override // com.bumptech.glide.f
    public final int o(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // com.bumptech.glide.f
    public final int q() {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = this.f7940b;
                return Math.max(0, sideSheetBehavior.I + sideSheetBehavior.J);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f7940b;
                return Math.max(0, (sideSheetBehavior2.H - sideSheetBehavior2.G) - sideSheetBehavior2.J);
        }
    }

    @Override // com.bumptech.glide.f
    public final int r() {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = this.f7940b;
                return (-sideSheetBehavior.G) - sideSheetBehavior.J;
            default:
                return this.f7940b.H;
        }
    }

    @Override // com.bumptech.glide.f
    public final int s() {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f7940b.J;
            default:
                return this.f7940b.H;
        }
    }

    @Override // com.bumptech.glide.f
    public final int t() {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return -this.f7940b.G;
            default:
                return q();
        }
    }

    @Override // com.bumptech.glide.f
    public final int u(View view) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return view.getRight() + this.f7940b.J;
            default:
                return view.getLeft() - this.f7940b.J;
        }
    }

    @Override // com.bumptech.glide.f
    public final int v(CoordinatorLayout coordinatorLayout) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // com.bumptech.glide.f
    public final int w() {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bumptech.glide.f
    public final boolean y(float f) {
        switch (this.f7939a) {
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

    @Override // com.bumptech.glide.f
    public final boolean z(View view) {
        switch (this.f7939a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (view.getRight() < (q() - r()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (q() + this.f7940b.H) / 2) {
                }
                break;
        }
        return false;
    }
}
