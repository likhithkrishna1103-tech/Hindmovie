package z6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f15288b = new m(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f15289c = new m(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f15290d = new m(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15291a;

    public /* synthetic */ m(int i) {
        this.f15291a = i;
    }

    public final boolean a(int i) {
        switch (this.f15291a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                if (i == 3 || i == 5) {
                }
                break;
            default:
                if (i == 2) {
                }
                break;
        }
        return false;
    }
}
