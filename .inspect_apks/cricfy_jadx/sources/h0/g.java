package h0;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f5439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f5440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5443e;
    public final CharSequence f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PendingIntent f5444g;

    public g(int i, String str, PendingIntent pendingIntent) {
        IconCompat iconCompatB = i == 0 ? null : IconCompat.b(i);
        Bundle bundle = new Bundle();
        this.f5442d = true;
        this.f5440b = iconCompatB;
        if (iconCompatB != null && iconCompatB.d() == 2) {
            this.f5443e = iconCompatB.c();
        }
        this.f = m.b(str);
        this.f5444g = pendingIntent;
        this.f5439a = bundle;
        this.f5441c = true;
        this.f5442d = true;
    }
}
