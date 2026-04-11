package com.bumptech.glide.load;

import c6.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
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


    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f2797u;

    ImageHeaderParser$ImageType(int i) {
        this.f2797u = z;
    }

    public boolean hasAlpha() {
        return this.f2797u;
    }

    public boolean isWebp() {
        int i = d.f2514a[ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
