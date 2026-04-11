package l6;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements c6.m {
    @Override // c6.m
    public final e6.b0 a(Context context, e6.b0 b0Var, int i, int i10) {
        if (!x6.m.i(i, i10)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i10 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        f6.a aVar = com.bumptech.glide.b.a(context).f2760u;
        Bitmap bitmap = (Bitmap) b0Var.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(aVar, bitmap, i, i10);
        return bitmap.equals(bitmapC) ? b0Var : d.e(bitmapC, aVar);
    }

    public abstract Bitmap c(f6.a aVar, Bitmap bitmap, int i, int i10);
}
