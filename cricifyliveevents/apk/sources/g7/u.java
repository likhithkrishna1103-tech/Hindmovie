package g7;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f5217b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(x6.e.f14397a);

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f5217b);
    }

    @Override // g7.e
    public final Bitmap c(a7.b bVar, Bitmap bitmap, int i, int i10) {
        return z.b(bVar, bitmap, i, i10);
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // x6.e
    public final int hashCode() {
        return 1572326941;
    }
}
