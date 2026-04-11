package k8;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f7153e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.d1 f7154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7155h;
    public final Long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f7156j;

    public e2(Context context, com.google.android.gms.internal.measurement.d1 d1Var, Long l10) {
        this.f7155h = true;
        t7.v.h(context);
        Context applicationContext = context.getApplicationContext();
        t7.v.h(applicationContext);
        this.f7149a = applicationContext;
        this.i = l10;
        if (d1Var != null) {
            this.f7154g = d1Var;
            this.f7150b = d1Var.f2932z;
            this.f7151c = d1Var.f2931y;
            this.f7152d = d1Var.f2930x;
            this.f7155h = d1Var.f2929w;
            this.f = d1Var.f2928v;
            this.f7156j = d1Var.B;
            Bundle bundle = d1Var.A;
            if (bundle != null) {
                this.f7153e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
