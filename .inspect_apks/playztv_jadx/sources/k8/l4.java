package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.j5;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l4 extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7310e;
    public j5 f;

    @Override // k8.c
    public final int m() {
        switch (this.f7310e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((com.google.android.gms.internal.measurement.w1) this.f).r();
            default:
                return ((com.google.android.gms.internal.measurement.c2) this.f).n();
        }
    }

    @Override // k8.c
    public final boolean q() {
        switch (this.f7310e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((com.google.android.gms.internal.measurement.w1) this.f).z();
            default:
                return false;
        }
    }

    @Override // k8.c
    public final boolean r() {
        switch (this.f7310e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return false;
            default:
                return true;
        }
    }
}
