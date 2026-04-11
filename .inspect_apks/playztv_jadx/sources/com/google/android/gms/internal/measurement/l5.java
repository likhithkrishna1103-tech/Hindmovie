package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f3086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f3087b;

    static {
        Charset.forName("US-ASCII");
        f3086a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f3087b = bArr;
        ByteBuffer.wrap(bArr);
        int length = bArr.length;
        try {
            if (length < 0) {
                throw r5.b();
            }
            int i = (0 - 0) + length;
            if (i < 0) {
                throw r5.c();
            }
            if (i > Integer.MAX_VALUE) {
                throw r5.d();
            }
        } catch (r5 e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static int a(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }
}
