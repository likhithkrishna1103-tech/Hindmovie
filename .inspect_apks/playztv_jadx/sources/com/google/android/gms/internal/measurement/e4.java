package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.os.UserManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static UserManager f2953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f2954b = !a();

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
