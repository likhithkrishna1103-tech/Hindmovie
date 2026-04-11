package j;

import android.graphics.drawable.Animatable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends com.bumptech.glide.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Animatable f6618e;

    public /* synthetic */ a(Animatable animatable, int i) {
        this.f6617d = i;
        this.f6618e = animatable;
    }

    @Override // com.bumptech.glide.c
    public final void v() {
        switch (this.f6617d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6618e.start();
                break;
            default:
                ((h5.f) this.f6618e).start();
                break;
        }
    }

    @Override // com.bumptech.glide.c
    public final void w() {
        switch (this.f6617d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6618e.stop();
                break;
            default:
                ((h5.f) this.f6618e).stop();
                break;
        }
    }
}
