package oa;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f9457u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e f9458v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Runnable f9459w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ long f9460x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ long f9461y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f9462z;

    public /* synthetic */ c(e eVar, Runnable runnable, long j5, long j8, TimeUnit timeUnit, int i) {
        this.f9457u = i;
        this.f9458v = eVar;
        this.f9459w = runnable;
        this.f9460x = j5;
        this.f9461y = j8;
        this.f9462z = timeUnit;
    }

    @Override // oa.f
    public final ScheduledFuture a(u5.d dVar) {
        switch (this.f9457u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = this.f9458v;
                return eVar.f9468v.scheduleAtFixedRate(new d(eVar, this.f9459w, dVar, 0), this.f9460x, this.f9461y, this.f9462z);
            default:
                e eVar2 = this.f9458v;
                return eVar2.f9468v.scheduleWithFixedDelay(new d(eVar2, this.f9459w, dVar, 2), this.f9460x, this.f9461y, this.f9462z);
        }
    }
}
