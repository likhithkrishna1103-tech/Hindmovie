package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.fragment.app.d;
import d8.e;
import d8.j;
import java.util.concurrent.Executor;
import l7.a;
import x7.i;
import x7.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f2301v = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i10 = jobParameters.getExtras().getInt("attemptNumber");
        p.b(getApplicationContext());
        a aVarA = i.a();
        aVarA.J(string);
        aVarA.f7868y = h8.a.b(i);
        if (string2 != null) {
            aVarA.f7867x = Base64.decode(string2, 0);
        }
        j jVar = p.a().f14453d;
        ((Executor) jVar.f3555e).execute(new e(jVar, aVarA.m(), i10, new d(2, this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
