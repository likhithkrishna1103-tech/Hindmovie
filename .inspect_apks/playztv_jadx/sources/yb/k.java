package yb;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import o8.o;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f14619u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f14620v;

    public /* synthetic */ k(int i, Object obj) {
        this.f14619u = i;
        this.f14620v = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f14619u;
        Object obj = this.f14620v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = (m) obj;
                ScheduledExecutorService scheduledExecutorService = mVar.f;
                if (mVar.a()) {
                    i iVarB = mVar.f14636o.b();
                    mVar.f14635n.getClass();
                    if (!new Date(System.currentTimeMillis()).before(iVarB.f14613b)) {
                        ob.c cVar = (ob.c) mVar.i;
                        o oVarE = cVar.e();
                        o oVarD = cVar.d();
                        o oVarF = t1.y(oVarE, oVarD).f(scheduledExecutorService, new dd.e(mVar, oVarE, oVarD, 13));
                        t1.y(oVarF).e(scheduledExecutorService, new b2.b(mVar, 27, oVarF));
                    } else {
                        mVar.h();
                    }
                    break;
                }
                break;
            default:
                ((y0.d) obj).p(0);
                break;
        }
    }
}
