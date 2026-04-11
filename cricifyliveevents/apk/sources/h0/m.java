package h0;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5449a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f5453e;
    public CharSequence f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PendingIntent f5454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IconCompat f5455h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5456j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a7.a f5458l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bundle f5460n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f5463q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f5464r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Notification f5465s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f5466t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5450b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5451c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5452d = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5457k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5459m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5461o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5462p = 0;

    public m(Context context, String str) {
        Notification notification = new Notification();
        this.f5465s = notification;
        this.f5449a = context;
        this.f5463q = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f5456j = 0;
        this.f5466t = new ArrayList();
        this.f5464r = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Notification notificationBuild;
        Bundle bundle;
        b6.f fVar = new b6.f(this);
        m mVar = (m) fVar.f1802y;
        a7.a aVar = mVar.f5458l;
        if (aVar != null) {
            aVar.Z0(fVar);
        }
        Notification.Builder builder = (Notification.Builder) fVar.f1801x;
        int i = Build.VERSION.SDK_INT;
        if (i < 26 && i < 24) {
            builder.setExtras((Bundle) fVar.f1803z);
            notificationBuild = builder.build();
        } else {
            notificationBuild = builder.build();
        }
        if (aVar != null) {
            mVar.f5458l.getClass();
        }
        if (aVar != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", aVar.a1());
        }
        return notificationBuild;
    }

    public final void c(int i, boolean z10) {
        Notification notification = this.f5465s;
        if (z10) {
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
                Resources resources = this.f5449a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(g0.b.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(g0.b.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.f658k;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.f660b = bitmap;
            iconCompat = iconCompat2;
        }
        this.f5455h = iconCompat;
    }

    public final void e(a7.a aVar) {
        if (this.f5458l != aVar) {
            this.f5458l = aVar;
            if (((m) aVar.f307w) != this) {
                aVar.f307w = this;
                e(aVar);
            }
        }
    }
}
