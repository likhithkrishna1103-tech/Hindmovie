package l6;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f8000b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(c6.f.f2515a);

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f8000b);
    }

    @Override // l6.e
    public final Bitmap c(f6.a aVar, Bitmap bitmap, int i, int i10) {
        return x.b(aVar, bitmap, i, i10);
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        return obj instanceof t;
    }

    @Override // c6.f
    public final int hashCode() {
        return 1572326941;
    }
}
