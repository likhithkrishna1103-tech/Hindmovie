package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import a7.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import b7.s;
import c7.j;
import c7.t;
import dd.c;
import dd.l;
import java.util.concurrent.Executor;
import m7.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2865a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        t.b(context);
        b bVarA = j.a();
        bVarA.E(queryParameter);
        bVarA.f619w = a.b(iIntValue);
        if (queryParameter2 != null) {
            bVarA.f618v = Base64.decode(queryParameter2, 0);
        }
        s sVar = t.a().f2585d;
        ((Executor) sVar.f1902e).execute(new l(sVar, bVarA.k(), i, new c()));
    }
}
