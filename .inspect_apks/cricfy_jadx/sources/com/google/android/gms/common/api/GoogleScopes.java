package com.google.android.gms.common.api;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleScopes {
    static {
        System.loadLibrary("native-lib");
    }

    public static native byte[] Ninty(Context context, String str);
}
