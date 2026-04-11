package com.google.android.gms.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import f9.r1;
import f9.w0;
import p6.c;
import r1.a;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f2750c;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f2750c == null) {
            this.f2750c = new c(12, this);
        }
        c cVar = this.f2750c;
        cVar.getClass();
        w0 w0Var = r1.m(context, null, null).A;
        r1.g(w0Var);
        if (intent == null) {
            w0Var.E.a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        w0Var.J.b(action, "Local receiver got");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                w0Var.E.a("Install Referrer Broadcasts are deprecated");
                return;
            }
            return;
        }
        Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        w0Var.J.a("Starting wakeful intent.");
        ((AppMeasurementReceiver) cVar.f10035w).getClass();
        SparseArray sparseArray = a.f10847a;
        synchronized (sparseArray) {
            try {
                int i = a.f10848b;
                int i10 = i + 1;
                a.f10848b = i10;
                if (i10 <= 0) {
                    a.f10848b = 1;
                }
                className.putExtra("androidx.contentpager.content.wakelockid", i);
                ComponentName componentNameStartService = context.startService(className);
                if (componentNameStartService == null) {
                    return;
                }
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + componentNameStartService.flattenToShortString());
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(60000L);
                sparseArray.put(i, wakeLockNewWakeLock);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
