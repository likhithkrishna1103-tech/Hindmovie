package com.google.android.gms.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import k8.k1;
import k8.p0;
import l1.a;
import wb.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f3297c;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f3297c == null) {
            this.f3297c = new c(21, this);
        }
        c cVar = this.f3297c;
        cVar.getClass();
        p0 p0Var = k1.c(context, null, null).C;
        k1.f(p0Var);
        if (intent == null) {
            p0Var.D.d("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        p0Var.I.c(action, "Local receiver got");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                p0Var.D.d("Install Referrer Broadcasts are deprecated");
                return;
            }
            return;
        }
        Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        p0Var.I.d("Starting wakeful intent.");
        ((AppMeasurementReceiver) cVar.f14088v).getClass();
        SparseArray sparseArray = a.f7804a;
        synchronized (sparseArray) {
            try {
                int i = a.f7805b;
                int i10 = i + 1;
                a.f7805b = i10;
                if (i10 <= 0) {
                    a.f7805b = 1;
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
