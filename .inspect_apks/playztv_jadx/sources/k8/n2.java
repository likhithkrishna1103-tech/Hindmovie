package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7331u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f7332v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g2 f7333w;

    public /* synthetic */ n2(g2 g2Var, long j5, int i) {
        this.f7331u = i;
        this.f7332v = j5;
        this.f7333w = g2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7331u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g2 g2Var = this.f7333w;
                a2.e2 e2Var = g2Var.n1().G;
                long j5 = this.f7332v;
                e2Var.d(j5);
                g2Var.g().H.c(Long.valueOf(j5), "Session timeout duration set");
                break;
            default:
                long j8 = this.f7332v;
                g2 g2Var2 = this.f7333w;
                g2Var2.J1(true, j8);
                ((k1) g2Var2.f2454v).p().x1(new AtomicReference());
                break;
        }
    }
}
