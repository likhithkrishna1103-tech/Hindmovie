package u;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f12042a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f, float f10, boolean z10) {
        if (!z10) {
            return f;
        }
        return (float) (((1.0d - f12042a) * ((double) f10)) + ((double) f));
    }

    public static float b(float f, float f10, boolean z10) {
        if (!z10) {
            return f * 1.5f;
        }
        return (float) (((1.0d - f12042a) * ((double) f10)) + ((double) (f * 1.5f)));
    }
}
