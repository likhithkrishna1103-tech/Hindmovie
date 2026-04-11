package h0;

import android.app.Notification;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static Notification.Builder a(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static void b(Notification.Builder builder) {
        builder.setBadgeIconType(0);
    }

    public static void c(Notification.Builder builder) {
        builder.setGroupAlertBehavior(0);
    }

    public static void d(Notification.Builder builder) {
        builder.setSettingsText(null);
    }

    public static void e(Notification.Builder builder) {
        builder.setShortcutId(null);
    }

    public static void f(Notification.Builder builder) {
        builder.setTimeoutAfter(0L);
    }
}
