package f9;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v4 implements i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.q0 f4452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4453b;

    public v4(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.q0 q0Var) {
        this.f4453b = appMeasurementDynamiteService;
        this.f4452a = q0Var;
    }

    @Override // f9.i2
    public final void a(long j4, Bundle bundle, String str, String str2) {
        try {
            this.f4452a.x(j4, bundle, str, str2);
        } catch (RemoteException e9) {
            r1 r1Var = this.f4453b.f2752d;
            if (r1Var != null) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.E.b(e9, "Event listener threw exception");
            }
        }
    }
}
