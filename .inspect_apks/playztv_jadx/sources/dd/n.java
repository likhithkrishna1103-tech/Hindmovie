package dd;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4178u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ boolean f4179v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4180w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4181x;

    public /* synthetic */ n(int i, Object obj, Object obj2, boolean z2) {
        this.f4178u = i;
        this.f4180w = obj;
        this.f4179v = z2;
        this.f4181x = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4178u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p) this.f4180w).h((zc.e) this.f4181x, this.f4179v);
                return;
            case 1:
                ((pc.l) this.f4180w).f((String) this.f4181x, this.f4179v);
                return;
            default:
                Context context = (Context) this.f4180w;
                o8.h hVar = (o8.h) this.f4181x;
                try {
                    if (Binder.getCallingUid() == context.getApplicationInfo().uid) {
                        SharedPreferences.Editor editorEdit = b8.h.p(context).edit();
                        editorEdit.putBoolean("proxy_notification_initialized", true);
                        editorEdit.apply();
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                        if (this.f4179v) {
                            notificationManager.setNotificationDelegate("com.google.android.gms");
                        } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                            notificationManager.setNotificationDelegate(null);
                        }
                    } else {
                        Log.e("FirebaseMessaging", "error configuring notification delegate for package " + context.getPackageName());
                    }
                    return;
                } finally {
                    hVar.c(null);
                }
        }
    }

    public /* synthetic */ n(p pVar, zc.e eVar, boolean z2) {
        this.f4178u = 0;
        this.f4180w = pVar;
        this.f4181x = eVar;
        this.f4179v = z2;
    }
}
