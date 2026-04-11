package l6;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f7977b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(c6.f.f2515a);

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f7977b);
    }

    @Override // l6.e
    public final Bitmap c(f6.a aVar, Bitmap bitmap, int i, int i10) {
        Paint paint = x.f8014a;
        if (bitmap.getWidth() > i || bitmap.getHeight() > i10) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return x.b(aVar, bitmap, i, i10);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // c6.f
    public final int hashCode() {
        return -670243078;
    }
}
