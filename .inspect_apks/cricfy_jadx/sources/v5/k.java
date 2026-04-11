package v5;

import android.content.Context;
import android.widget.CompoundButton;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13435b;

    public /* synthetic */ k(int i, Object obj) {
        this.f13434a = i;
        this.f13435b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        switch (this.f13434a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((m) this.f13435b).C.f12221b.setVisibility(z10 ? 0 : 8);
                break;
            case 1:
                com.bumptech.glide.d.u((Context) this.f13435b).putBoolean("video_setting", z10).apply();
                break;
            default:
                Chip chip = (Chip) this.f13435b;
                da.g gVar = chip.E;
                if (gVar != null) {
                    da.a aVar = (da.a) ((pc.c) gVar).f10180v;
                    if (!z10 ? aVar.e(chip, aVar.f3563c) : aVar.a(chip)) {
                        aVar.d();
                    }
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.D;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
                }
                break;
        }
    }
}
