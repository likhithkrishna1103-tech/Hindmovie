package b2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements ta.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1729v;

    @Override // ta.h
    public final boolean apply(Object obj) {
        switch (this.f1729v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (((Map.Entry) obj).getKey() != null) {
                }
                break;
            default:
                if (((String) obj) != null) {
                }
                break;
        }
        return false;
    }
}
