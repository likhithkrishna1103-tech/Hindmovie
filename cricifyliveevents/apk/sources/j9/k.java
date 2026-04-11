package j9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements f, e, c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6691v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CountDownLatch f6692w;

    public k(int i) {
        this.f6691v = i;
        switch (i) {
            case 1:
                this.f6692w = new CountDownLatch(1);
                break;
            default:
                this.f6692w = new CountDownLatch(1);
                break;
        }
    }

    @Override // j9.f
    public final void a(Object obj) {
        switch (this.f6691v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6692w.countDown();
                break;
            default:
                this.f6692w.countDown();
                break;
        }
    }

    @Override // j9.c
    public final void b() {
        switch (this.f6691v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6692w.countDown();
                break;
            default:
                this.f6692w.countDown();
                break;
        }
    }

    @Override // j9.e
    public final void y(Exception exc) {
        switch (this.f6691v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6692w.countDown();
                break;
            default:
                this.f6692w.countDown();
                break;
        }
    }
}
