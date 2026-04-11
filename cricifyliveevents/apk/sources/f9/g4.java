package f9;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g4 extends l4 {
    public z3 A;
    public Integer B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AlarmManager f4196z;

    public g4(q4 q4Var) {
        super(q4Var);
        this.f4196z = (AlarmManager) ((r1) this.f307w).f4363v.getSystemService("alarm");
    }

    @Override // f9.l4
    public final void p1() {
        AlarmManager alarmManager = this.f4196z;
        if (alarmManager != null) {
            alarmManager.cancel(u1());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            s1();
        }
    }

    public final void q1() {
        n1();
        w0 w0Var = ((r1) this.f307w).A;
        r1.g(w0Var);
        w0Var.J.a("Unscheduling upload");
        AlarmManager alarmManager = this.f4196z;
        if (alarmManager != null) {
            alarmManager.cancel(u1());
        }
        r1().c();
        if (Build.VERSION.SDK_INT >= 24) {
            s1();
        }
    }

    public final o r1() {
        if (this.A == null) {
            this.A = new z3(this, this.f4215x.G, 1);
        }
        return this.A;
    }

    public final void s1() {
        JobScheduler jobScheduler = (JobScheduler) ((r1) this.f307w).f4363v.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(t1());
        }
    }

    public final int t1() {
        if (this.B == null) {
            this.B = Integer.valueOf("measurement".concat(String.valueOf(((r1) this.f307w).f4363v.getPackageName())).hashCode());
        }
        return this.B.intValue();
    }

    public final PendingIntent u1() {
        Context context = ((r1) this.f307w).f4363v;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.e0.f2372a);
    }
}
