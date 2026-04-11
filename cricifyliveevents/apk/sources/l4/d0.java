package l4;

import android.content.ContentResolver;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f7707c = h0.f7716b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentResolver f7709b;

    public final boolean a(g0 g0Var, String str) {
        Context context = this.f7708a;
        int i = g0Var.f7713b;
        return i < 0 ? context.getPackageManager().checkPermission(str, g0Var.f7712a) == 0 : context.checkPermission(str, i, g0Var.f7714c) == 0;
    }
}
