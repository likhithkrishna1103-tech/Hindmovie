package q4;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends androidx.emoji2.text.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10947d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(h0 h0Var, int i) {
        super(h0Var);
        this.f10947d = i;
    }

    @Override // androidx.emoji2.text.h
    public final int d(View view) {
        int right;
        int i;
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0 i0Var = (i0) view.getLayoutParams();
                ((h0) this.f1175b).getClass();
                right = view.getRight() + ((i0) view.getLayoutParams()).f10832b.right;
                i = ((ViewGroup.MarginLayoutParams) i0Var).rightMargin;
                break;
            default:
                i0 i0Var2 = (i0) view.getLayoutParams();
                ((h0) this.f1175b).getClass();
                right = view.getBottom() + ((i0) view.getLayoutParams()).f10832b.bottom;
                i = ((ViewGroup.MarginLayoutParams) i0Var2).bottomMargin;
                break;
        }
        return right + i;
    }

    @Override // androidx.emoji2.text.h
    public final int e(View view) {
        int iA;
        int i;
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0 i0Var = (i0) view.getLayoutParams();
                ((h0) this.f1175b).getClass();
                iA = h0.A(view) + ((ViewGroup.MarginLayoutParams) i0Var).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) i0Var).rightMargin;
                break;
            default:
                i0 i0Var2 = (i0) view.getLayoutParams();
                ((h0) this.f1175b).getClass();
                iA = h0.z(view) + ((ViewGroup.MarginLayoutParams) i0Var2).topMargin;
                i = ((ViewGroup.MarginLayoutParams) i0Var2).bottomMargin;
                break;
        }
        return iA + i;
    }

    @Override // androidx.emoji2.text.h
    public final int f(View view) {
        int iZ;
        int i;
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0 i0Var = (i0) view.getLayoutParams();
                ((h0) this.f1175b).getClass();
                iZ = h0.z(view) + ((ViewGroup.MarginLayoutParams) i0Var).topMargin;
                i = ((ViewGroup.MarginLayoutParams) i0Var).bottomMargin;
                break;
            default:
                i0 i0Var2 = (i0) view.getLayoutParams();
                ((h0) this.f1175b).getClass();
                iZ = h0.A(view) + ((ViewGroup.MarginLayoutParams) i0Var2).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) i0Var2).rightMargin;
                break;
        }
        return iZ + i;
    }

    @Override // androidx.emoji2.text.h
    public final int g(View view) {
        int left;
        int i;
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0 i0Var = (i0) view.getLayoutParams();
                ((h0) this.f1175b).getClass();
                left = view.getLeft() - ((i0) view.getLayoutParams()).f10832b.left;
                i = ((ViewGroup.MarginLayoutParams) i0Var).leftMargin;
                break;
            default:
                i0 i0Var2 = (i0) view.getLayoutParams();
                ((h0) this.f1175b).getClass();
                left = view.getTop() - ((i0) view.getLayoutParams()).f10832b.top;
                i = ((ViewGroup.MarginLayoutParams) i0Var2).topMargin;
                break;
        }
        return left - i;
    }

    @Override // androidx.emoji2.text.h
    public final int h() {
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f1175b).f10828n;
            default:
                return ((h0) this.f1175b).f10829o;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int i() {
        int i;
        int iE;
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0 h0Var = (h0) this.f1175b;
                i = h0Var.f10828n;
                iE = h0Var.E();
                break;
            default:
                h0 h0Var2 = (h0) this.f1175b;
                i = h0Var2.f10829o;
                iE = h0Var2.C();
                break;
        }
        return i - iE;
    }

    @Override // androidx.emoji2.text.h
    public final int j() {
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f1175b).E();
            default:
                return ((h0) this.f1175b).C();
        }
    }

    @Override // androidx.emoji2.text.h
    public final int k() {
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f1175b).f10826l;
            default:
                return ((h0) this.f1175b).f10827m;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int l() {
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f1175b).f10827m;
            default:
                return ((h0) this.f1175b).f10826l;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int m() {
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f1175b).D();
            default:
                return ((h0) this.f1175b).F();
        }
    }

    @Override // androidx.emoji2.text.h
    public final int n() {
        int iD;
        int iE;
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0 h0Var = (h0) this.f1175b;
                iD = h0Var.f10828n - h0Var.D();
                iE = h0Var.E();
                break;
            default:
                h0 h0Var2 = (h0) this.f1175b;
                iD = h0Var2.f10829o - h0Var2.F();
                iE = h0Var2.C();
                break;
        }
        return iD - iE;
    }

    @Override // androidx.emoji2.text.h
    public final int o(View view) {
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0 h0Var = (h0) this.f1175b;
                Rect rect = (Rect) this.f1176c;
                h0Var.J(rect, view);
                return rect.right;
            default:
                h0 h0Var2 = (h0) this.f1175b;
                Rect rect2 = (Rect) this.f1176c;
                h0Var2.J(rect2, view);
                return rect2.bottom;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int p(View view) {
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0 h0Var = (h0) this.f1175b;
                Rect rect = (Rect) this.f1176c;
                h0Var.J(rect, view);
                return rect.left;
            default:
                h0 h0Var2 = (h0) this.f1175b;
                Rect rect2 = (Rect) this.f1176c;
                h0Var2.J(rect2, view);
                return rect2.top;
        }
    }

    @Override // androidx.emoji2.text.h
    public final void q(int i) {
        switch (this.f10947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((h0) this.f1175b).O(i);
                break;
            default:
                ((h0) this.f1175b).P(i);
                break;
        }
    }
}
