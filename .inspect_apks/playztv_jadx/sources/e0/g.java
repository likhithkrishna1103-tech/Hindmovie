package e0;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f4246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f4247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4250e;
    public final CharSequence f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PendingIntent f4251g;

    public g(int i, String str, PendingIntent pendingIntent) {
        IconCompat iconCompatB = i == 0 ? null : IconCompat.b(i);
        Bundle bundle = new Bundle();
        this.f4249d = true;
        this.f4247b = iconCompatB;
        if (iconCompatB != null && iconCompatB.d() == 2) {
            this.f4250e = iconCompatB.c();
        }
        this.f = m.b(str);
        this.f4251g = pendingIntent;
        this.f4246a = bundle;
        this.f4248c = true;
        this.f4249d = true;
    }
}
