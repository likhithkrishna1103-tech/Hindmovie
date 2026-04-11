package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.internal.measurement.k1;
import f9.q4;
import f9.v1;
import f9.w0;
import f9.w3;
import java.util.Objects;
import jb.b;
import o8.u;
import pc.c;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements w3 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f2749v;

    @Override // f9.w3
    public final boolean a(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // f9.w3
    public final void c(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public final c d() {
        if (this.f2749v == null) {
            this.f2749v = new c(this);
        }
        return this.f2749v;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.v("FA", ((Service) d().f10180v).getClass().getSimpleName().concat(" is starting up."));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.v("FA", ((Service) d().f10180v).getClass().getSimpleName().concat(" is shutting down."));
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        d();
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        JobParameters jobParameters2;
        c cVarD = d();
        Service service = (Service) cVarD.f10180v;
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            u.g(string);
            q4 q4VarX = q4.x(service);
            w0 w0VarC = q4VarX.C();
            b bVar = q4VarX.G.f4365x;
            w0VarC.J.b(string, "Local AppMeasurementJobService called. action");
            jobParameters2 = jobParameters;
            q4VarX.a0().v1(new s(cVarD, q4VarX, new v1(8, cVarD, w0VarC, jobParameters2, false)));
        } else {
            jobParameters2 = jobParameters;
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        u.g(string);
        k1 k1VarE = k1.e(service, null);
        s sVar = new s(17, cVarD, jobParameters2);
        k1VarE.getClass();
        k1VarE.c(new com.google.android.gms.internal.measurement.w0(k1VarE, sVar, 2));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        d();
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }

    @Override // f9.w3
    public final void b(Intent intent) {
    }
}
