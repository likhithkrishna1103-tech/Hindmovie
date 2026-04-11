package hb;

import android.os.Build;
import android.os.StrictMode;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements hc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5884a;

    public /* synthetic */ f(int i) {
        this.f5884a = i;
    }

    @Override // hc.b
    public final Object get() {
        switch (this.f5884a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                break;
            case 2:
                n nVar = ExecutorsRegistrar.f3024a;
                StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                int i = Build.VERSION.SDK_INT;
                builderDetectNetwork.detectResourceMismatches();
                if (i >= 26) {
                    builderDetectNetwork.detectUnbufferedIo();
                }
                break;
            case 3:
                n nVar2 = ExecutorsRegistrar.f3024a;
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                n nVar3 = ExecutorsRegistrar.f3024a;
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                n nVar4 = ExecutorsRegistrar.f3024a;
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                l4.a aVar = FirebaseMessaging.f3035l;
                break;
            default:
                Random random = qc.i.f10798j;
                break;
        }
        return null;
    }
}
