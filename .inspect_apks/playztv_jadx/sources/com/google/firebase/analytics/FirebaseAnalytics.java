package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.i1;
import com.google.android.gms.internal.measurement.l1;
import ga.g;
import ja.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k8.s2;
import ob.c;
import ob.d;
import t7.v;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile FirebaseAnalytics f3560b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i1 f3561a;

    public FirebaseAnalytics(i1 i1Var) {
        v.h(i1Var);
        this.f3561a = i1Var;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f3560b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f3560b == null) {
                        f3560b = new FirebaseAnalytics(i1.b(context, null));
                    }
                } finally {
                }
            }
        }
        return f3560b;
    }

    @Keep
    public static s2 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        i1 i1VarB = i1.b(context, bundle);
        if (i1VarB == null) {
            return null;
        }
        return new a(i1VarB);
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            Object obj = c.f9485m;
            return (String) t1.e(((c) g.c().b(d.class)).d(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        } catch (ExecutionException e11) {
            throw new IllegalStateException(e11.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        i1 i1Var = this.f3561a;
        i1Var.getClass();
        i1Var.e(new l1(i1Var, activity, str, str2));
    }
}
