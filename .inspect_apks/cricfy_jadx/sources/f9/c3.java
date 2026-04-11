package f9;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.PersistableBundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c3 extends h0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public JobScheduler f4060y;

    @Override // f9.h0
    public final boolean p1() {
        return true;
    }

    public final void q1(long j4) {
        r1 r1Var = (r1) this.f307w;
        n1();
        m1();
        JobScheduler jobScheduler = this.f4060y;
        if (jobScheduler != null && jobScheduler.getPendingJob("measurement-client".concat(String.valueOf(r1Var.f4363v.getPackageName())).hashCode()) != null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.J.a("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        int iR1 = r1();
        if (iR1 != 2) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.J.b(q4.a.x(iR1), "[sgtm] Not eligible for Scion upload");
            return;
        }
        w0 w0Var3 = r1Var.A;
        r1.g(w0Var3);
        w0Var3.J.b(Long.valueOf(j4), "[sgtm] Scheduling Scion upload, millis");
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder("measurement-client".concat(String.valueOf(r1Var.f4363v.getPackageName())).hashCode(), new ComponentName(r1Var.f4363v, "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j4).setOverrideDeadline(j4 + j4).setExtras(persistableBundle).build();
        JobScheduler jobScheduler2 = this.f4060y;
        o8.u.g(jobScheduler2);
        int iSchedule = jobScheduler2.schedule(jobInfoBuild);
        w0 w0Var4 = r1Var.A;
        r1.g(w0Var4);
        w0Var4.J.b(iSchedule == 1 ? "SUCCESS" : "FAILURE", "[sgtm] Scion upload job scheduled with result");
    }

    public final int r1() {
        r1 r1Var = (r1) this.f307w;
        n1();
        m1();
        if (this.f4060y == null) {
            return 7;
        }
        Boolean boolY1 = r1Var.f4366y.y1("google_analytics_sgtm_upload_enabled");
        if (!(boolY1 == null ? false : boolY1.booleanValue())) {
            return 8;
        }
        if (r1Var.l().F < 119000) {
            return 6;
        }
        if (!u4.G1(r1Var.f4363v, "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return 3;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return !r1Var.j().t1() ? 5 : 2;
        }
        return 4;
    }
}
