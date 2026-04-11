package r;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f11206a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f, float f4, boolean z2) {
        if (!z2) {
            return f;
        }
        return (float) (((1.0d - f11206a) * ((double) f4)) + ((double) f));
    }

    public static float b(float f, float f4, boolean z2) {
        if (!z2) {
            return f * 1.5f;
        }
        return (float) (((1.0d - f11206a) * ((double) f4)) + ((double) (f * 1.5f)));
    }
}
