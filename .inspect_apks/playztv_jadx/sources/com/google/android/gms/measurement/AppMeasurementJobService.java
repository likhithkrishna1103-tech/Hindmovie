package com.google.android.gms.measurement;

import ab.c;
import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import ea.t;
import k8.k1;
import k8.l3;
import k8.p0;
import k8.x3;
import rc.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements l3 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f3296u;

    @Override // k8.l3
    public final void b(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // k8.l3
    public final boolean c(int i) {
        throw new UnsupportedOperationException();
    }

    public final b d() {
        if (this.f3296u == null) {
            this.f3296u = new b(19, this);
        }
        return this.f3296u;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        p0 p0Var = k1.c((Service) d().f11562v, null, null).C;
        k1.f(p0Var);
        p0Var.I.d("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        p0 p0Var = k1.c((Service) d().f11562v, null, null).C;
        k1.f(p0Var);
        p0Var.I.d("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        b bVarD = d();
        if (intent == null) {
            bVarD.N().A.d("onRebind called with null intent");
            return;
        }
        bVarD.getClass();
        bVarD.N().I.c(intent.getAction(), "onRebind called. action");
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        b bVarD = d();
        p0 p0Var = k1.c((Service) bVarD.f11562v, null, null).C;
        k1.f(p0Var);
        String string = jobParameters.getExtras().getString("action");
        p0Var.I.c(string, "Local AppMeasurementJobService called. action");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        c cVar = new c(9);
        cVar.f780v = bVarD;
        cVar.f781w = p0Var;
        cVar.f782x = jobParameters;
        x3 x3VarK = x3.k((Service) bVarD.f11562v);
        x3VarK.x().y1(new t(x3VarK, 19, cVar));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        b bVarD = d();
        if (intent == null) {
            bVarD.N().A.d("onUnbind called with null intent");
            return true;
        }
        bVarD.getClass();
        bVarD.N().I.c(intent.getAction(), "onUnbind called for intent. action");
        return true;
    }

    @Override // k8.l3
    public final void a(Intent intent) {
    }
}
