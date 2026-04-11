package l6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f7980b = new m(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f7981c = new m(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f7982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f7983e;
    public static final m f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c6.h f7984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f7985h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7986a;

    static {
        m mVar = new m(1);
        f7982d = mVar;
        f7983e = new m(3);
        f = mVar;
        f7984g = c6.h.a(mVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f7985h = true;
    }

    public /* synthetic */ m(int i) {
        this.f7986a = i;
    }

    public final int a(int i, int i10, int i11, int i12) {
        switch (this.f7986a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (b(i, i10, i11, i12) != 1.0f) {
                    break;
                }
                break;
            case 2:
                if (f7985h) {
                }
                break;
        }
        return 2;
    }

    public final float b(int i, int i10, int i11, int i12) {
        switch (this.f7986a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Math.min(1.0f, f7980b.b(i, i10, i11, i12));
            case 1:
                return Math.max(i11 / i, i12 / i10);
            case 2:
                if (f7985h) {
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
