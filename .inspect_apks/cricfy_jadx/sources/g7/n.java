package g7;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f5196b = new n(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f5197c = new n(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f5198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f5199e;
    public static final n f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x6.g f5200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f5201h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5202a;

    static {
        n nVar = new n(1);
        f5198d = nVar;
        f5199e = new n(3);
        f = nVar;
        f5200g = x6.g.a(nVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f5201h = true;
    }

    public /* synthetic */ n(int i) {
        this.f5202a = i;
    }

    public final int a(int i, int i10, int i11, int i12) {
        switch (this.f5202a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (b(i, i10, i11, i12) != 1.0f) {
                    break;
                }
                break;
            case 2:
                if (f5201h) {
                }
                break;
        }
        return 2;
    }

    public final float b(int i, int i10, int i11, int i12) {
        switch (this.f5202a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Math.min(1.0f, f5196b.b(i, i10, i11, i12));
            case 1:
                return Math.max(i11 / i, i12 / i10);
            case 2:
                if (f5201h) {
                    return Math.min(i11 / i, i12 / i10);
                }
                if (Math.max(i10 / i12, i / i11) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            default:
                return 1.0f;
        }
    }
}
