package pe;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10230b;

    public /* synthetic */ e(int i, Object obj) {
        this.f10229a = i;
        this.f10230b = obj;
    }

    public final String toString() {
        switch (this.f10229a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f10230b) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((fe.l) this.f10230b).getClass().getSimpleName() + '@' + x.g(this) + ']';
            default:
                return "DisposeOnCancel[" + ((h0) this.f10230b) + ']';
        }
    }
}
