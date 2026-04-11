package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f2570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f2571b;

    static {
        Charset.forName("US-ASCII");
        f2570a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2571b = bArr;
        ByteBuffer.wrap(bArr);
    }
}
