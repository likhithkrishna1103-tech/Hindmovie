package k4;

import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.firebase.PushService;
import app.cricfy.tv.room.db.AppDatabase;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6935v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f6936w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f6937x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Serializable f6938y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Serializable f6939z;

    public /* synthetic */ d(PushService pushService, String str, String str2, String str3, String str4) {
        this.f6936w = pushService;
        this.f6937x = str;
        this.f6938y = str2;
        this.f6939z = str3;
        this.A = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6935v;
        Object obj = this.A;
        Serializable serializable = this.f6939z;
        Serializable serializable2 = this.f6938y;
        Object obj2 = this.f6937x;
        Object obj3 = this.f6936w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) obj2).run().h(new c8.a((b6.f) obj3, (AtomicBoolean) serializable2, (f) obj, (AtomicBoolean) serializable, 3), ya.q.f15009v);
                break;
            default:
                ExecutorService executorService = PushService.C;
                b6.f fVarQ = AppDatabase.r((PushService) obj3).q();
                ab.b.s((w4.t) fVarQ.f1800w, false, true, new b6.c(1, fVarQ, new b6.h((String) obj2, (String) serializable2, (String) serializable, (String) obj, false, System.currentTimeMillis())));
                break;
        }
    }

    public /* synthetic */ d(b6.f fVar, e eVar, AtomicBoolean atomicBoolean, f fVar2, AtomicBoolean atomicBoolean2) {
        this.f6936w = fVar;
        this.f6937x = eVar;
        this.f6938y = atomicBoolean;
        this.A = fVar2;
        this.f6939z = atomicBoolean2;
    }
}
