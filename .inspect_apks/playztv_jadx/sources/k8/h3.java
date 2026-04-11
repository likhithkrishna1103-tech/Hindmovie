package k8;

import android.content.ComponentName;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h3 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7230u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g3 f7231v;

    public /* synthetic */ h3(g3 g3Var, int i) {
        this.f7230u = i;
        this.f7231v = g3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7230u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z2 z2Var = this.f7231v.f7217w;
                z2Var.f7573y = null;
                z2Var.G1();
                break;
            default:
                z2 z2Var2 = this.f7231v.f7217w;
                ComponentName componentName = new ComponentName(((k1) z2Var2.f2454v).f7282u, "com.google.android.gms.measurement.AppMeasurementService");
                z2Var2.p1();
                if (z2Var2.f7573y != null) {
                    z2Var2.f7573y = null;
                    z2Var2.g().I.c(componentName, "Disconnected from device MeasurementService");
                    z2Var2.p1();
                    z2Var2.B1();
                }
                break;
        }
    }
}
