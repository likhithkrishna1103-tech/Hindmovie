package e0;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4256a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f4260e;
    public CharSequence f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PendingIntent f4261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IconCompat f4262h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4263j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c3.e f4265l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bundle f4267n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f4270q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f4271r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Notification f4272s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f4273t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4257b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f4258c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f4259d = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4264k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4266m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4268o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4269p = 0;

    public m(Context context, String str) {
        Notification notification = new Notification();
        this.f4272s = notification;
        this.f4256a = context;
        this.f4270q = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f4263j = 0;
        this.f4273t = new ArrayList();
        this.f4271r = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Notification notificationBuild;
        Bundle bundle;
        ub.o oVar = new ub.o(this);
        m mVar = (m) oVar.f12870x;
        c3.e eVar = mVar.f4265l;
        if (eVar != null) {
            eVar.Z0(oVar);
        }
        Notification.Builder builder = (Notification.Builder) oVar.f12869w;
        int i = Build.VERSION.SDK_INT;
        if (i < 26 && i < 24) {
            builder.setExtras((Bundle) oVar.f12871y);
            notificationBuild = builder.build();
        } else {
            notificationBuild = builder.build();
        }
        if (eVar != null) {
            mVar.f4265l.getClass();
        }
        if (eVar != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", eVar.a1());
        }
        return notificationBuild;
    }

    public final void c(int i, boolean z2) {
        Notification notification = this.f4272s;
        if (z2) {
            notification.flags = i | notification.flags;
        } else {
            notification.flags = (~i) & notification.flags;
        }
    }

    public final void d(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f4256a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(d0.b.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(d0.b.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.f984k;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.f986b = bitmap;
            iconCompat = iconCompat2;
        }
        this.f4262h = iconCompat;
    }

    public final void e(c3.e eVar) {
        if (this.f4265l != eVar) {
            this.f4265l = eVar;
            if (((m) eVar.f2454v) != this) {
                eVar.f2454v = this;
                e(eVar);
            }
        }
    }
}
