package com.scottyab.rootbeer;

import w1.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class RootBeerNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3055a;

    static {
        try {
            System.loadLibrary("toolChecker");
            f3055a = true;
        } catch (UnsatisfiedLinkError e9) {
            d.f(e9);
        }
    }

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z10);
}
