package e6;

import android.os.Handler;
import android.os.Message;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements Handler.Callback {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4497u;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f4497u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (message.what != 1) {
                    return false;
                }
                ((b0) message.obj).d();
                return true;
            default:
                int i = message.what;
                if (i == 0) {
                    message.obj.getClass();
                    throw new ClassCastException();
                }
                if (i != 1) {
                    return false;
                }
                message.obj.getClass();
                throw new ClassCastException();
        }
    }
}
