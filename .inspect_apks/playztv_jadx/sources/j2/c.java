package j2;

import android.os.HandlerThread;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements z9.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6670u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6671v;

    public /* synthetic */ c(int i, int i10) {
        this.f6670u = i10;
        this.f6671v = i;
    }

    @Override // z9.l
    public final Object get() {
        switch (this.f6670u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new HandlerThread(d.d("ExoPlayer:MediaCodecAsyncAdapter:", this.f6671v));
            default:
                return new HandlerThread(d.d("ExoPlayer:MediaCodecQueueingThread:", this.f6671v));
        }
    }
}
