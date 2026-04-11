package l6;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f7976b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(c6.f.f2515a);

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f7976b);
    }

    @Override // l6.e
    public final Bitmap c(f6.a aVar, Bitmap bitmap, int i, int i10) {
        float width;
        float height;
        Paint paint = x.f8014a;
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
        Bitmap bitmapE = aVar.e(i, i10, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmapE.setHasAlpha(bitmap.hasAlpha());
        x.a(bitmap, bitmapE, matrix);
        return bitmapE;
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // c6.f
    public final int hashCode() {
        return -599754482;
    }
}
