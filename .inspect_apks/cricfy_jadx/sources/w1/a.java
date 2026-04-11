package w1;

import android.app.NotificationChannel;
import android.media.AudioFocusRequest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ NotificationChannel b(String str, String str2) {
        return new NotificationChannel(str, str2, 4);
    }

    public static /* bridge */ /* synthetic */ AudioFocusRequest e(Object obj) {
        return (AudioFocusRequest) obj;
    }

    public static /* synthetic */ void g() {
    }
}
