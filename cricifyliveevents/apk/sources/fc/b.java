package fc;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;
import hb.r;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements hb.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4537v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ r f4538w;

    public /* synthetic */ b(r rVar, int i) {
        this.f4537v = i;
        this.f4538w = rVar;
    }

    @Override // hb.e
    public final Object e(dd.c cVar) {
        switch (this.f4537v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new d((Context) cVar.b(Context.class), ((ab.g) cVar.b(ab.g.class)).d(), cVar.t(e.class), cVar.g(pc.b.class), (Executor) cVar.f(this.f4538w));
            case 1:
                return FirebaseMessagingRegistrar.lambda$getComponents$0(this.f4538w, cVar);
            default:
                return RemoteConfigRegistrar.lambda$getComponents$0(this.f4538w, cVar);
        }
    }
}
