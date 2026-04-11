package k1;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import g1.h;
import ka.w;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends v {
    public final /* synthetic */ int i;

    public /* synthetic */ d(int i) {
        this.i = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w4.v
    public final float j(w wVar) {
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((View) wVar).getAlpha();
            case 1:
                return ((View) wVar).getScaleX();
            case 2:
                return ((View) wVar).getScaleY();
            case 3:
                return ((View) wVar).getRotation();
            case h.LONG_FIELD_NUMBER /* 4 */:
                return ((View) wVar).getRotationX();
            default:
                return ((View) wVar).getRotationY();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w4.v
    public final void u(w wVar, float f) {
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((View) wVar).setAlpha(f);
                break;
            case 1:
                ((View) wVar).setScaleX(f);
                break;
            case 2:
                ((View) wVar).setScaleY(f);
                break;
            case 3:
                ((View) wVar).setRotation(f);
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
                ((View) wVar).setRotationX(f);
                break;
            default:
                ((View) wVar).setRotationY(f);
                break;
        }
    }
}
