package p7;

import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import c2.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o8.h f10278b = new o8.h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f10280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f10281e;

    public l(int i, int i10, Bundle bundle, int i11) {
        this.f10281e = i11;
        this.f10277a = i;
        this.f10279c = i10;
        this.f10280d = bundle;
    }

    public final boolean a() {
        switch (this.f10281e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return true;
            default:
                return false;
        }
    }

    public final void b(o oVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + oVar.toString());
        }
        this.f10278b.f9421a.l(oVar);
    }

    public final void c(Bundle bundle) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(bundle));
        }
        this.f10278b.a(bundle);
    }

    public final String toString() {
        return "Request { what=" + this.f10279c + " id=" + this.f10277a + " oneWay=" + a() + "}";
    }
}
