package f9;

import android.content.Context;
import p8.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f4815e;

    public a(Context context) {
        boolean z2 = z7.a.z(context, b.elevationOverlayEnabled, false);
        int iL = z7.a.l(context, b.elevationOverlayColor, 0);
        int iL2 = z7.a.l(context, b.elevationOverlayAccentColor, 0);
        int iL3 = z7.a.l(context, b.colorSurface, 0);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f4811a = z2;
        this.f4812b = iL;
        this.f4813c = iL2;
        this.f4814d = iL3;
        this.f4815e = f4;
    }
}
