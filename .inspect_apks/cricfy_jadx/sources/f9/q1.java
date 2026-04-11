package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4338v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.l0 f4339w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4340x;

    public /* synthetic */ q1(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.l0 l0Var, int i) {
        this.f4338v = i;
        this.f4339w = l0Var;
        this.f4340x = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4338v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t3 t3VarJ = this.f4340x.f2752d.j();
                com.google.android.gms.internal.measurement.l0 l0Var = this.f4339w;
                t3VarJ.m1();
                t3VarJ.n1();
                t3VarJ.A1(new v1((Object) t3VarJ, t3VarJ.C1(false), (Object) l0Var, 6));
                break;
            default:
                AppMeasurementDynamiteService appMeasurementDynamiteService = this.f4340x;
                u4 u4Var = appMeasurementDynamiteService.f2752d.D;
                r1.e(u4Var);
                r1 r1Var = appMeasurementDynamiteService.f2752d;
                u4Var.Z1(this.f4339w, r1Var.T != null && r1Var.T.booleanValue());
                break;
        }
    }
}
