package lb;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;
import java.util.concurrent.Executor;
import na.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements na.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8072u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ r f8073v;

    public /* synthetic */ b(r rVar, int i) {
        this.f8072u = i;
        this.f8073v = rVar;
    }

    @Override // na.e
    public final Object e(zc.c cVar) {
        switch (this.f8072u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new d((Context) cVar.b(Context.class), ((ga.g) cVar.b(ga.g.class)).d(), cVar.u(e.class), cVar.e(wb.b.class), (Executor) cVar.d(this.f8073v));
            case 1:
                return FirebaseMessagingRegistrar.lambda$getComponents$0(this.f8073v, cVar);
            default:
                return RemoteConfigRegistrar.lambda$getComponents$0(this.f8073v, cVar);
        }
    }
}
