package b9;

import android.graphics.Typeface;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.chip.Chip;
import j9.a0;
import j9.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends android.support.v4.media.session.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1944b;

    public /* synthetic */ a(int i, Object obj) {
        this.f1943a = i;
        this.f1944b = obj;
    }

    @Override // android.support.v4.media.session.b
    public final void I(int i) {
        switch (this.f1943a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                a0 a0Var = (a0) this.f1944b;
                a0Var.f6840e = true;
                z zVar = (z) a0Var.f.get();
                if (zVar != null) {
                    zVar.a();
                }
                break;
        }
    }

    @Override // android.support.v4.media.session.b
    public final void J(Typeface typeface, boolean z2) {
        switch (this.f1943a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Chip chip = (Chip) this.f1944b;
                e eVar = chip.f3378y;
                chip.setText(eVar.X0 ? eVar.Z : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z2) {
                    a0 a0Var = (a0) this.f1944b;
                    a0Var.f6840e = true;
                    z zVar = (z) a0Var.f.get();
                    if (zVar != null) {
                        zVar.a();
                    }
                    break;
                }
                break;
        }
    }

    private final void R(int i) {
    }
}
