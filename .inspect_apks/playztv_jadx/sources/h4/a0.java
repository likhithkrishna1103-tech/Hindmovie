package h4;

import android.content.ContentResolver;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f5789c = e0.f5797b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentResolver f5791b;

    public final boolean a(d0 d0Var, String str) {
        Context context = this.f5790a;
        int i = d0Var.f5794b;
        return i < 0 ? context.getPackageManager().checkPermission(str, d0Var.f5793a) == 0 : context.checkPermission(str, i, d0Var.f5795c) == 0;
    }
}
