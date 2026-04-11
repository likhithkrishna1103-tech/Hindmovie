package da;

import android.graphics.Typeface;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends com.bumptech.glide.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3651b;

    public /* synthetic */ z(int i, Object obj) {
        this.f3650a = i;
        this.f3651b = obj;
    }

    @Override // com.bumptech.glide.d
    public final void w(int i) {
        switch (this.f3650a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = (b0) this.f3651b;
                b0Var.f3571e = true;
                a0 a0Var = (a0) b0Var.f.get();
                if (a0Var != null) {
                    a0Var.a();
                }
                break;
        }
    }

    @Override // com.bumptech.glide.d
    public final void x(Typeface typeface, boolean z10) {
        switch (this.f3650a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!z10) {
                    b0 b0Var = (b0) this.f3651b;
                    b0Var.f3571e = true;
                    a0 a0Var = (a0) b0Var.f.get();
                    if (a0Var != null) {
                        a0Var.a();
                    }
                    break;
                }
                break;
            default:
                Chip chip = (Chip) this.f3651b;
                v9.c cVar = chip.f2837z;
                chip.setText(cVar.f13523h1 ? cVar.f13526j0 : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
        }
    }

    private final void H(int i) {
    }
}
