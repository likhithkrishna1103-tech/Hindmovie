package na;

import android.os.Build;
import android.os.StrictMode;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements nb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8887a;

    public /* synthetic */ f(int i) {
        this.f8887a = i;
    }

    @Override // nb.b
    public final Object get() {
        switch (this.f8887a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                break;
            case 2:
                n nVar = ExecutorsRegistrar.f3562a;
                StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                int i = Build.VERSION.SDK_INT;
                builderDetectNetwork.detectResourceMismatches();
                if (i >= 26) {
                    builderDetectNetwork.detectUnbufferedIo();
                }
                break;
            case 3:
                n nVar2 = ExecutorsRegistrar.f3562a;
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                n nVar3 = ExecutorsRegistrar.f3562a;
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                n nVar4 = ExecutorsRegistrar.f3562a;
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                o4.c cVar = FirebaseMessaging.f3572l;
                break;
            default:
                Random random = xb.i.f14347j;
                break;
        }
        return null;
    }
}
