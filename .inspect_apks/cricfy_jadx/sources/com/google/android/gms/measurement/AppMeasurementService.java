package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import f9.a2;
import f9.a3;
import f9.q4;
import f9.r1;
import f9.w0;
import f9.w3;
import pc.c;
import r1.a;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements w3 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f2751v;

    @Override // f9.w3
    public final boolean a(int i) {
        return stopSelfResult(i);
    }

    @Override // f9.w3
    public final void b(Intent intent) {
        SparseArray sparseArray = a.f10847a;
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return;
        }
        SparseArray sparseArray2 = a.f10847a;
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

    @Override // f9.w3
    public final void c(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    public final c d() {
        if (this.f2751v == null) {
            this.f2751v = new c(this);
        }
        return this.f2751v;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        c cVarD = d();
        cVarD.getClass();
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new a2(q4.x((Service) cVarD.f10180v));
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
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

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i10) {
        c cVarD = d();
        if (intent == null) {
            cVarD.getClass();
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Service service = (Service) cVarD.f10180v;
        w0 w0Var = r1.m(service, null, null).A;
        r1.g(w0Var);
        String action = intent.getAction();
        w0Var.J.c(Integer.valueOf(i10), action, "Local AppMeasurementService called. startId, action");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        a3 a3Var = new a3(cVarD, i10, w0Var, intent);
        q4 q4VarX = q4.x(service);
        q4VarX.a0().v1(new s(cVarD, q4VarX, a3Var));
        return 2;
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
}
