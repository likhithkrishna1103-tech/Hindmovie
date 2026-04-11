package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import d8.e;
import d8.j;
import java.util.concurrent.Executor;
import l7.a;
import x7.i;
import x7.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2300a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        p.b(context);
        a aVarA = i.a();
        aVarA.J(queryParameter);
        aVarA.f7868y = h8.a.b(iIntValue);
        if (queryParameter2 != null) {
            aVarA.f7867x = Base64.decode(queryParameter2, 0);
        }
        j jVar = p.a().f14453d;
        ((Executor) jVar.f3555e).execute(new e(jVar, aVarA.m(), i, new d8.a()));
    }
}
