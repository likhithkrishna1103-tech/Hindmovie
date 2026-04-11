package z9;

import android.content.Context;
import android.support.v4.media.session.b;
import com.bumptech.glide.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f15340e;

    public a(Context context) {
        boolean zH = b.H(context, k9.b.elevationOverlayEnabled, false);
        int iM = f.m(context, k9.b.elevationOverlayColor, 0);
        int iM2 = f.m(context, k9.b.elevationOverlayAccentColor, 0);
        int iM3 = f.m(context, k9.b.colorSurface, 0);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f15336a = zH;
        this.f15337b = iM;
        this.f15338c = iM2;
        this.f15339d = iM3;
        this.f15340e = f10;
    }
}
