package pa;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f10064e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(p pVar, int i) {
        super(pVar);
        this.f10064e = i;
    }

    @Override // pa.q
    public void q() {
        switch (this.f10064e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p pVar = this.f10095b;
                pVar.J = null;
                CheckableImageButton checkableImageButton = pVar.B;
                checkableImageButton.setOnLongClickListener(null);
                u8.a.B(checkableImageButton, null);
                break;
        }
    }
}
