package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import ea.t;
import k8.k1;
import k8.l3;
import k8.o1;
import k8.p0;
import k8.u2;
import k8.x3;
import l1.a;
import rc.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements l3 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f3298u;

    @Override // k8.l3
    public final void a(Intent intent) {
        SparseArray sparseArray = a.f7804a;
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return;
        }
        SparseArray sparseArray2 = a.f7804a;
        synchronized (sparseArray2) {
            try {
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) sparseArray2.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    sparseArray2.remove(intExtra);
                } else {
                    Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k8.l3
    public final void b(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    @Override // k8.l3
    public final boolean c(int i) {
        return stopSelfResult(i);
    }

    public final b d() {
        if (this.f3298u == null) {
            this.f3298u = new b(19, this);
        }
        return this.f3298u;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        b bVarD = d();
        if (intent == null) {
            bVarD.N().A.d("onBind called with null intent");
            return null;
        }
        bVarD.getClass();
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new o1(x3.k((Service) bVarD.f11562v));
        }
        bVarD.N().D.c(action, "onBind received unknown action");
        return null;
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

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i10) {
        b bVarD = d();
        p0 p0Var = k1.c((Service) bVarD.f11562v, null, null).C;
        k1.f(p0Var);
        if (intent == null) {
            p0Var.D.d("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        p0Var.I.b(Integer.valueOf(i10), action, "Local AppMeasurementService called. startId, action");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        u2 u2Var = new u2(1);
        u2Var.f7440w = bVarD;
        u2Var.f7439v = i10;
        u2Var.f7441x = p0Var;
        u2Var.f7442y = intent;
        x3 x3VarK = x3.k((Service) bVarD.f11562v);
        x3VarK.x().y1(new t(x3VarK, 19, u2Var));
        return 2;
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
}
