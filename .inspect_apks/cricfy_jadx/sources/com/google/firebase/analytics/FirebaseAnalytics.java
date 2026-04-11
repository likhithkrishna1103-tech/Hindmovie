package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.v0;
import com.google.android.gms.internal.measurement.y0;
import db.a;
import f9.y2;
import ic.c;
import ic.d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import o8.u;
import vf.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile FirebaseAnalytics f3022b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f3023a;

    public FirebaseAnalytics(k1 k1Var) {
        u.g(k1Var);
        this.f3023a = k1Var;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f3022b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f3022b == null) {
                        f3022b = new FirebaseAnalytics(k1.e(context, null));
                    }
                } finally {
                }
            }
        }
        return f3022b;
    }

    @Keep
    public static y2 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        k1 k1VarE = k1.e(context, bundle);
        if (k1VarE == null) {
            return null;
        }
        return new a(k1VarE);
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            Object obj = c.f6419m;
            return (String) g.c(((c) ab.g.c().b(d.class)).d(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e9) {
            throw new IllegalStateException(e9);
        } catch (ExecutionException e10) {
            throw new IllegalStateException(e10.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        v0 v0VarA = v0.a(activity);
        k1 k1Var = this.f3023a;
        k1Var.getClass();
        k1Var.c(new y0(k1Var, v0VarA, str, str2));
    }
}
