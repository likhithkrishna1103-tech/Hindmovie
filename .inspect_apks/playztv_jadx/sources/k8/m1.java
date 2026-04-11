package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7313u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.w0 f7314v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f7315w;

    public /* synthetic */ m1(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.w0 w0Var, int i) {
        this.f7313u = i;
        this.f7314v = w0Var;
        this.f7315w = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7313u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z2 z2VarP = this.f7315w.f3299d.p();
                com.google.android.gms.internal.measurement.w0 w0Var = this.f7314v;
                z2VarP.p1();
                z2VarP.t1();
                z2VarP.w1(new ab.c(z2VarP, z2VarP.I1(false), w0Var, 7));
                break;
            default:
                AppMeasurementDynamiteService appMeasurementDynamiteService = this.f7315w;
                h4 h4Var = appMeasurementDynamiteService.f3299d.F;
                k1.d(h4Var);
                com.google.android.gms.internal.measurement.w0 w0Var2 = this.f7314v;
                k1 k1Var = appMeasurementDynamiteService.f3299d;
                h4Var.N1(w0Var2, k1Var.U != null && k1Var.U.booleanValue());
                break;
        }
    }
}
