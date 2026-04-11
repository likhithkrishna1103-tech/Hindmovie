package g7;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements x6.l {
    @Override // x6.l
    public final z6.b0 b(Context context, z6.b0 b0Var, int i, int i10) {
        if (!s7.m.i(i, i10)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i10 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        a7.b bVar = com.bumptech.glide.b.a(context).f2193v;
        Bitmap bitmap = (Bitmap) b0Var.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(bVar, bitmap, i, i10);
        return bitmap.equals(bitmapC) ? b0Var : d.b(bVar, bitmapC);
    }

    public abstract Bitmap c(a7.b bVar, Bitmap bitmap, int i, int i10);
}
