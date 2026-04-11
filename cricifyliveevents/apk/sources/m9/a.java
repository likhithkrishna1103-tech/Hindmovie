package m9;

import android.app.NotificationChannel;
import android.app.PictureInPictureParams;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioFocusRequest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ boolean C(Drawable drawable) {
        return drawable instanceof AdaptiveIconDrawable;
    }

    public static /* synthetic */ NotificationChannel c(String str) {
        return new NotificationChannel("fcm_fallback_notification_channel", str, 3);
    }

    public static /* synthetic */ PictureInPictureParams.Builder d() {
        return new PictureInPictureParams.Builder();
    }

    public static /* synthetic */ AudioFocusRequest.Builder f(int i) {
        return new AudioFocusRequest.Builder(i);
    }

    public static /* synthetic */ void o() {
    }
}
