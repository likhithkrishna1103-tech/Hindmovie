package com.bumptech.glide.load;

import x6.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(0),
    JPEG(1),
    RAW(2),
    PNG_A(3),
    PNG(4),
    WEBP_A(5),
    WEBP(6),
    ANIMATED_WEBP(7),
    AVIF(8),
    ANIMATED_AVIF(9),
    UNKNOWN(10);


    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f2226v;

    ImageHeaderParser$ImageType(int i) {
        this.f2226v = z;
    }

    public boolean hasAlpha() {
        return this.f2226v;
    }

    public boolean isWebp() {
        int i = c.f14396a[ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
