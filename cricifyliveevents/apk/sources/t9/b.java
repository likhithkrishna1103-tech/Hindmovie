package t9;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends d5.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f11954d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CarouselLayoutManager carouselLayoutManager, int i) {
        super(1, 1);
        this.f11953c = i;
        switch (i) {
            case 1:
                this.f11954d = carouselLayoutManager;
                super(0, 1);
                break;
            default:
                this.f11954d = carouselLayoutManager;
                break;
        }
    }

    @Override // d5.c
    public final int c() {
        switch (this.f11953c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f11954d.f13259o;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f11954d;
                return carouselLayoutManager.f13259o - carouselLayoutManager.C();
        }
    }

    @Override // d5.c
    public final int d() {
        switch (this.f11953c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f11954d.D();
            default:
                return 0;
        }
    }

    @Override // d5.c
    public final int e() {
        switch (this.f11953c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                CarouselLayoutManager carouselLayoutManager = this.f11954d;
                return carouselLayoutManager.f13258n - carouselLayoutManager.E();
            default:
                return this.f11954d.f13258n;
        }
    }

    @Override // d5.c
    public final int f() {
        switch (this.f11953c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 0;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f11954d;
                if (carouselLayoutManager.G0()) {
                    return carouselLayoutManager.f13258n;
                }
                return 0;
        }
    }

    @Override // d5.c
    public final int g() {
        switch (this.f11953c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 0;
            default:
                return this.f11954d.F();
        }
    }
}
