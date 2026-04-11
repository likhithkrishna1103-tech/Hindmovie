package f9;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f4237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.t0 f4239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4240e;
    public final Long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4241g;

    public j2(Context context, com.google.android.gms.internal.measurement.t0 t0Var, Long l10) {
        this.f4240e = true;
        o8.u.g(context);
        Context applicationContext = context.getApplicationContext();
        o8.u.g(applicationContext);
        this.f4236a = applicationContext;
        this.f = l10;
        if (t0Var != null) {
            this.f4239d = t0Var;
            this.f4240e = t0Var.f2633x;
            this.f4238c = t0Var.f2632w;
            this.f4241g = t0Var.f2635z;
            Bundle bundle = t0Var.f2634y;
            if (bundle != null) {
                this.f4237b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
