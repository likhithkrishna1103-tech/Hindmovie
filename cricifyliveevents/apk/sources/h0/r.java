package h0;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationManager f5467a;

    static {
        new HashSet();
    }

    public r(Context context) {
        this.f5467a = (NotificationManager) context.getSystemService("notification");
    }
}
