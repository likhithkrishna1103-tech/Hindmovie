package p7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import o8.o;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements o8.a, o8.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ d f10257v = new d(0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ d f10258w = new d(1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ d f10259x = new d(2);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10260u;

    public /* synthetic */ d(int i) {
        this.f10260u = i;
    }

    @Override // o8.a
    public Object b(o oVar) throws IOException {
        switch (this.f10260u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (oVar.j()) {
                    return (Bundle) oVar.h();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(oVar.g())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", oVar.g());
            default:
                Intent intent = (Intent) ((Bundle) oVar.h()).getParcelable("notification_data");
                if (intent != null) {
                    return new a(intent);
                }
                return null;
        }
    }

    @Override // o8.g
    public o r(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i = b.f10248h;
        return (bundle == null || !bundle.containsKey("google.messenger")) ? t1.k(bundle) : t1.k(null);
    }
}
