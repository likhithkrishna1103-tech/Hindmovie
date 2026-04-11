package com.scottyab.rootbeer;

import ga.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class RootBeerNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3691a;

    static {
        try {
            System.loadLibrary("toolChecker");
            f3691a = true;
        } catch (UnsatisfiedLinkError e10) {
            b.k(e10);
        }
    }

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z2);
}
