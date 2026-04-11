package k8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import j9.p;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements j9.a, j9.h {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ d f7254w = new d(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ d f7255x = new d(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ d f7256y = new d(2);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7257v;

    public /* synthetic */ d(int i) {
        this.f7257v = i;
    }

    @Override // j9.h
    public p B(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i = b.f7245h;
        return (bundle == null || !bundle.containsKey("google.messenger")) ? vf.g.A(bundle) : vf.g.A(null);
    }

    @Override // j9.a
    public Object c(p pVar) throws IOException {
        switch (this.f7257v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (pVar.j()) {
                    return (Bundle) pVar.h();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(pVar.g())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", pVar.g());
            default:
                Intent intent = (Intent) ((Bundle) pVar.h()).getParcelable("notification_data");
                if (intent != null) {
                    return new a(intent);
                }
                return null;
        }
    }
}
