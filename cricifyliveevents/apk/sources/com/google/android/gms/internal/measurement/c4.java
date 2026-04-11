package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.os.UserManager;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static UserManager f2340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f2341b = !a();

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
