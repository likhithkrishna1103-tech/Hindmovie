package e0;

import android.app.Notification;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends c3.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f4255w;

    @Override // c3.e
    public final void Z0(ub.o oVar) {
        new Notification.BigTextStyle((Notification.Builder) oVar.f12869w).setBigContentTitle(null).bigText(this.f4255w);
    }

    @Override // c3.e
    public final String a1() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
