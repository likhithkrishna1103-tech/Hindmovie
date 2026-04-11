package k8;

import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import i2.q;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.i f7274b = new j9.i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f7276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7277e;

    public l(int i, int i10, Bundle bundle, int i11) {
        this.f7277e = i11;
        this.f7273a = i;
        this.f7275c = i10;
        this.f7276d = bundle;
    }

    public final boolean a() {
        switch (this.f7277e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return true;
            default:
                return false;
        }
    }

    public final void b(q qVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + qVar.toString());
        }
        this.f7274b.f6688a.n(qVar);
    }

    public final void c(Bundle bundle) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(bundle));
        }
        this.f7274b.a(bundle);
    }

    public final String toString() {
        return "Request { what=" + this.f7275c + " id=" + this.f7273a + " oneWay=" + a() + "}";
    }
}
