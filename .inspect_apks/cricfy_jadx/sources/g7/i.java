package g7;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f5191b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(x6.e.f14397a);

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f5191b);
    }

    @Override // g7.e
    public final Bitmap c(a7.b bVar, Bitmap bitmap, int i, int i10) {
        Paint paint = z.f5231a;
        if (bitmap.getWidth() > i || bitmap.getHeight() > i10) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return z.b(bVar, bitmap, i, i10);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // x6.e
    public final int hashCode() {
        return -670243078;
    }
}
