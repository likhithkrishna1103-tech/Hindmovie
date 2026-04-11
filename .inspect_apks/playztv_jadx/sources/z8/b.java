package z8;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.carousel.CarouselLayoutManager;
import t1.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f14902d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CarouselLayoutManager carouselLayoutManager, int i) {
        super(1, 2);
        this.f14901c = i;
        switch (i) {
            case 1:
                this.f14902d = carouselLayoutManager;
                super(0, 2);
                break;
            default:
                this.f14902d = carouselLayoutManager;
                break;
        }
    }

    @Override // t1.e
    public final int c() {
        switch (this.f14901c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f14902d.f10829o;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f14902d;
                return carouselLayoutManager.f10829o - carouselLayoutManager.C();
        }
    }

    @Override // t1.e
    public final int d() {
        switch (this.f14901c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f14902d.D();
            default:
                return 0;
        }
    }

    @Override // t1.e
    public final int e() {
        switch (this.f14901c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                CarouselLayoutManager carouselLayoutManager = this.f14902d;
                return carouselLayoutManager.f10828n - carouselLayoutManager.E();
            default:
                return this.f14902d.f10828n;
        }
    }

    @Override // t1.e
    public final int f() {
        switch (this.f14901c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 0;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f14902d;
                if (carouselLayoutManager.F0()) {
                    return carouselLayoutManager.f10828n;
                }
                return 0;
        }
    }

    @Override // t1.e
    public final int g() {
        switch (this.f14901c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 0;
            default:
                return this.f14902d.F();
        }
    }
}
