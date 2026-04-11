package h0;

import android.app.Notification;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends a7.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f5448x;

    @Override // a7.a
    public final void Z0(b6.f fVar) {
        new Notification.BigTextStyle((Notification.Builder) fVar.f1801x).setBigContentTitle(null).bigText(this.f5448x);
    }

    @Override // a7.a
    public final String a1() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
