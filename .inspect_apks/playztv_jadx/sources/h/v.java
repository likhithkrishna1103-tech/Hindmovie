package h;

import android.window.OnBackInvokedCallback;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5561b;

    public /* synthetic */ v(int i, Object obj) {
        this.f5560a = i;
        this.f5561b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f5560a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((b0) this.f5561b).G();
                break;
            case 1:
                ((j4.h) this.f5561b).a();
                break;
            case 2:
                ((k9.b) this.f5561b).a();
                break;
            default:
                ((Runnable) this.f5561b).run();
                break;
        }
    }
}
