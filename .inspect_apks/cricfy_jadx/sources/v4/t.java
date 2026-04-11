package v4;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends androidx.emoji2.text.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f13360d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(h0 h0Var, int i) {
        super(h0Var);
        this.f13360d = i;
    }

    @Override // androidx.emoji2.text.h
    public final int d(View view) {
        int right;
        int i;
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0 i0Var = (i0) view.getLayoutParams();
                ((h0) this.f857b).getClass();
                right = view.getRight() + ((i0) view.getLayoutParams()).f13262b.right;
                i = ((ViewGroup.MarginLayoutParams) i0Var).rightMargin;
                break;
            default:
                i0 i0Var2 = (i0) view.getLayoutParams();
                ((h0) this.f857b).getClass();
                right = view.getBottom() + ((i0) view.getLayoutParams()).f13262b.bottom;
                i = ((ViewGroup.MarginLayoutParams) i0Var2).bottomMargin;
                break;
        }
        return right + i;
    }

    @Override // androidx.emoji2.text.h
    public final int e(View view) {
        int iA;
        int i;
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0 i0Var = (i0) view.getLayoutParams();
                ((h0) this.f857b).getClass();
                iA = h0.A(view) + ((ViewGroup.MarginLayoutParams) i0Var).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) i0Var).rightMargin;
                break;
            default:
                i0 i0Var2 = (i0) view.getLayoutParams();
                ((h0) this.f857b).getClass();
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
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0 i0Var = (i0) view.getLayoutParams();
                ((h0) this.f857b).getClass();
                iZ = h0.z(view) + ((ViewGroup.MarginLayoutParams) i0Var).topMargin;
                i = ((ViewGroup.MarginLayoutParams) i0Var).bottomMargin;
                break;
            default:
                i0 i0Var2 = (i0) view.getLayoutParams();
                ((h0) this.f857b).getClass();
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
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0 i0Var = (i0) view.getLayoutParams();
                ((h0) this.f857b).getClass();
                left = view.getLeft() - ((i0) view.getLayoutParams()).f13262b.left;
                i = ((ViewGroup.MarginLayoutParams) i0Var).leftMargin;
                break;
            default:
                i0 i0Var2 = (i0) view.getLayoutParams();
                ((h0) this.f857b).getClass();
                left = view.getTop() - ((i0) view.getLayoutParams()).f13262b.top;
                i = ((ViewGroup.MarginLayoutParams) i0Var2).topMargin;
                break;
        }
        return left - i;
    }

    @Override // androidx.emoji2.text.h
    public final int h() {
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f857b).f13258n;
            default:
                return ((h0) this.f857b).f13259o;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int i() {
        int i;
        int iE;
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0 h0Var = (h0) this.f857b;
                i = h0Var.f13258n;
                iE = h0Var.E();
                break;
            default:
                h0 h0Var2 = (h0) this.f857b;
                i = h0Var2.f13259o;
                iE = h0Var2.C();
                break;
        }
        return i - iE;
    }

    @Override // androidx.emoji2.text.h
    public final int j() {
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f857b).E();
            default:
                return ((h0) this.f857b).C();
        }
    }

    @Override // androidx.emoji2.text.h
    public final int k() {
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f857b).f13256l;
            default:
                return ((h0) this.f857b).f13257m;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int l() {
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f857b).f13257m;
            default:
                return ((h0) this.f857b).f13256l;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int m() {
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((h0) this.f857b).D();
            default:
                return ((h0) this.f857b).F();
        }
    }

    @Override // androidx.emoji2.text.h
    public final int n() {
        int iD;
        int iE;
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0 h0Var = (h0) this.f857b;
                iD = h0Var.f13258n - h0Var.D();
                iE = h0Var.E();
                break;
            default:
                h0 h0Var2 = (h0) this.f857b;
                iD = h0Var2.f13259o - h0Var2.F();
                iE = h0Var2.C();
                break;
        }
        return iD - iE;
    }

    @Override // androidx.emoji2.text.h
    public final int o(View view) {
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0 h0Var = (h0) this.f857b;
                Rect rect = (Rect) this.f858c;
                h0Var.J(rect, view);
                return rect.right;
            default:
                h0 h0Var2 = (h0) this.f857b;
                Rect rect2 = (Rect) this.f858c;
                h0Var2.J(rect2, view);
                return rect2.bottom;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int p(View view) {
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0 h0Var = (h0) this.f857b;
                Rect rect = (Rect) this.f858c;
                h0Var.J(rect, view);
                return rect.left;
            default:
                h0 h0Var2 = (h0) this.f857b;
                Rect rect2 = (Rect) this.f858c;
                h0Var2.J(rect2, view);
                return rect2.top;
        }
    }

    @Override // androidx.emoji2.text.h
    public final void q(int i) {
        switch (this.f13360d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((h0) this.f857b).O(i);
                break;
            default:
                ((h0) this.f857b).P(i);
                break;
        }
    }
}
