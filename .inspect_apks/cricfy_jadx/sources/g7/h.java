package g7;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f5190b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(x6.e.f14397a);

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f5190b);
    }

    @Override // g7.e
    public final Bitmap c(a7.b bVar, Bitmap bitmap, int i, int i10) {
        float width;
        float height;
        Paint paint = z.f5231a;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i10) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i10 > bitmap.getHeight() * i) {
            width = i10 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i10 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapC = bVar.c(i, i10, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmapC.setHasAlpha(bitmap.hasAlpha());
        z.a(bitmap, bitmapC, matrix);
        return bitmapC;
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // x6.e
    public final int hashCode() {
        return -599754482;
    }
}
