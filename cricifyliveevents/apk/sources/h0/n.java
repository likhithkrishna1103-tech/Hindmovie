package h0;

import android.app.Notification;
import android.app.NotificationManager;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static boolean a(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    public static void b(Notification.Action.Builder builder, boolean z10) {
        builder.setAllowGeneratedReplies(z10);
    }

    public static void c(Notification.Builder builder) {
        builder.setRemoteInputHistory(null);
    }
}
