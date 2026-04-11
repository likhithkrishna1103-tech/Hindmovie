package k8;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.x0 f7065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f7066b;

    public a(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.x0 x0Var) {
        this.f7066b = appMeasurementDynamiteService;
        this.f7065a = x0Var;
    }

    @Override // k8.d2
    public final void a(long j5, Bundle bundle, String str, String str2) {
        try {
            this.f7065a.v(j5, bundle, str, str2);
        } catch (RemoteException e10) {
            k1 k1Var = this.f7066b.f3299d;
            if (k1Var != null) {
                p0 p0Var = k1Var.C;
                k1.f(p0Var);
                p0Var.D.c(e10, "Event listener threw exception");
            }
        }
    }
}
