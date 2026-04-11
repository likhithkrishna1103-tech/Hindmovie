package ea;

import android.window.OnBackInvokedCallback;
import androidx.media3.decoder.DecoderInputBuffer;
import h.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3858b;

    public /* synthetic */ c(int i, Object obj) {
        this.f3857a = i;
        this.f3858b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f3857a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((b) this.f3858b).a();
                break;
            case 1:
                ((a0) this.f3858b).G();
                break;
            case 2:
                ((Runnable) this.f3858b).run();
                break;
            default:
                ((o4.h) this.f3858b).a();
                break;
        }
    }
}
