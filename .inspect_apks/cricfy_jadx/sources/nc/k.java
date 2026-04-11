package nc;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.j4;
import com.google.firebase.messaging.FirebaseMessaging;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements j9.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9059v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f9060w;

    public /* synthetic */ k(FirebaseMessaging firebaseMessaging, int i) {
        this.f9059v = i;
        this.f9060w = firebaseMessaging;
    }

    @Override // j9.f
    public final void a(Object obj) {
        int i = this.f9059v;
        FirebaseMessaging firebaseMessaging = this.f9060w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = (u) obj;
                if (firebaseMessaging.f3042e.k()) {
                    uVar.h();
                }
                break;
            default:
                k8.a aVar = (k8.a) obj;
                l4.a aVar2 = FirebaseMessaging.f3035l;
                firebaseMessaging.getClass();
                if (aVar != null) {
                    j4.x(aVar.f7244v);
                    firebaseMessaging.e();
                }
                break;
        }
    }
}
