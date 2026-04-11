package h0;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends a7.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public IconCompat f5445x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public IconCompat f5446y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5447z;

    @Override // a7.a
    public final void Z0(b6.f fVar) {
        Bitmap bitmapA;
        Notification.Builder builder = (Notification.Builder) fVar.f1801x;
        Context context = (Context) fVar.f1800w;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(builder).setBigContentTitle(null);
        IconCompat iconCompat = this.f5445x;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                i.a(bigContentTitle, iconCompat.f(context));
            } else if (iconCompat.d() == 1) {
                IconCompat iconCompat2 = this.f5445x;
                int i = iconCompat2.f659a;
                if (i == -1) {
                    Object obj = iconCompat2.f660b;
                    bitmapA = obj instanceof Bitmap ? (Bitmap) obj : null;
                } else if (i == 1) {
                    bitmapA = (Bitmap) iconCompat2.f660b;
                } else {
                    if (i != 5) {
                        throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                    }
                    bitmapA = IconCompat.a((Bitmap) iconCompat2.f660b, true);
                }
                bigContentTitle = bigContentTitle.bigPicture(bitmapA);
            }
        }
        if (this.f5447z) {
            IconCompat iconCompat3 = this.f5446y;
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

    @Override // a7.a
    public final String a1() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }
}
