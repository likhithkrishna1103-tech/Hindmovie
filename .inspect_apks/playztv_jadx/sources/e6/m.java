package e6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f4535b = new m(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f4536c = new m(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f4537d = new m(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4538a;

    public /* synthetic */ m(int i) {
        this.f4538a = i;
    }

    public final boolean a(int i) {
        switch (this.f4538a) {
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
