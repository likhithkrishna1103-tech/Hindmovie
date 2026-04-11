package ib;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements f {
    public final /* synthetic */ TimeUnit A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6391v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e f6392w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Runnable f6393x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ long f6394y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ long f6395z;

    public /* synthetic */ c(e eVar, Runnable runnable, long j4, long j7, TimeUnit timeUnit, int i) {
        this.f6391v = i;
        this.f6392w = eVar;
        this.f6393x = runnable;
        this.f6394y = j4;
        this.f6395z = j7;
        this.A = timeUnit;
    }

    @Override // ib.f
    public final ScheduledFuture a(p6.c cVar) {
        switch (this.f6391v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = this.f6392w;
                return eVar.f6401w.scheduleAtFixedRate(new d(eVar, this.f6393x, cVar, 0), this.f6394y, this.f6395z, this.A);
            default:
                e eVar2 = this.f6392w;
                return eVar2.f6401w.scheduleWithFixedDelay(new d(eVar2, this.f6393x, cVar, 2), this.f6394y, this.f6395z, this.A);
        }
    }
}
