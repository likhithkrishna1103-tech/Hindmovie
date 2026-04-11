package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import a2.g0;
import a7.b;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import b7.s;
import c7.j;
import c7.t;
import dd.l;
import java.util.concurrent.Executor;
import m7.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f2866u = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i10 = jobParameters.getExtras().getInt("attemptNumber");
        t.b(getApplicationContext());
        b bVarA = j.a();
        bVarA.E(string);
        bVarA.f619w = a.b(i);
        if (string2 != null) {
            bVarA.f618v = Base64.decode(string2, 0);
        }
        s sVar = t.a().f2585d;
        ((Executor) sVar.f1902e).execute(new l(sVar, bVarA.k(), i10, new g0(this, 24, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
