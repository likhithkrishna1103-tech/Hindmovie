package e0;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends c3.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public IconCompat f4252w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public IconCompat f4253x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4254y;

    @Override // c3.e
    public final void Z0(ub.o oVar) {
        Bitmap bitmapA;
        Notification.Builder builder = (Notification.Builder) oVar.f12869w;
        Context context = (Context) oVar.f12868v;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(builder).setBigContentTitle(null);
        IconCompat iconCompat = this.f4252w;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                i.a(bigContentTitle, iconCompat.f(context));
            } else if (iconCompat.d() == 1) {
                IconCompat iconCompat2 = this.f4252w;
                int i = iconCompat2.f985a;
                if (i == -1) {
                    Object obj = iconCompat2.f986b;
                    bitmapA = obj instanceof Bitmap ? (Bitmap) obj : null;
                } else if (i == 1) {
                    bitmapA = (Bitmap) iconCompat2.f986b;
                } else {
                    if (i != 5) {
                        throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                    }
                    bitmapA = IconCompat.a((Bitmap) iconCompat2.f986b, true);
                }
                bigContentTitle = bigContentTitle.bigPicture(bitmapA);
            }
        }
        if (this.f4254y) {
            IconCompat iconCompat3 = this.f4253x;
            if (iconCompat3 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else {
                h.a(bigContentTitle, iconCompat3.f(context));
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            i.c(bigContentTitle, false);
            i.b(bigContentTitle, null);
        }
    }

    @Override // c3.e
    public final String a1() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }
}
