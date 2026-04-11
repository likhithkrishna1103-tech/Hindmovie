package k8;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s3 extends t3 {
    public Integer A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AlarmManager f7422y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p3 f7423z;

    public s3(x3 x3Var) {
        super(x3Var);
        this.f7422y = (AlarmManager) ((k1) this.f2454v).f7282u.getSystemService("alarm");
    }

    @Override // k8.t3
    public final boolean v1() {
        JobScheduler jobScheduler;
        AlarmManager alarmManager = this.f7422y;
        if (alarmManager != null) {
            alarmManager.cancel(y1());
        }
        if (Build.VERSION.SDK_INT < 24 || (jobScheduler = (JobScheduler) ((k1) this.f2454v).f7282u.getSystemService("jobscheduler")) == null) {
            return false;
        }
        jobScheduler.cancel(x1());
        return false;
    }

    public final void w1() {
        JobScheduler jobScheduler;
        t1();
        g().I.d("Unscheduling upload");
        AlarmManager alarmManager = this.f7422y;
        if (alarmManager != null) {
            alarmManager.cancel(y1());
        }
        z1().a();
        if (Build.VERSION.SDK_INT < 24 || (jobScheduler = (JobScheduler) ((k1) this.f2454v).f7282u.getSystemService("jobscheduler")) == null) {
            return;
        }
        jobScheduler.cancel(x1());
    }

    public final int x1() {
        if (this.A == null) {
            this.A = Integer.valueOf(("measurement" + ((k1) this.f2454v).f7282u.getPackageName()).hashCode());
        }
        return this.A.intValue();
    }

    public final PendingIntent y1() {
        Context context = ((k1) this.f2454v).f7282u;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.p0.f3146a);
    }

    public final n z1() {
        if (this.f7423z == null) {
            this.f7423z = new p3(this, this.f7443w.F, 1);
        }
        return this.f7423z;
    }
}
