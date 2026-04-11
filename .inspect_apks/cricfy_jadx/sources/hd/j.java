package hd;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ boolean f5948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f5949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f5950y;

    public /* synthetic */ j(int i, Object obj, Object obj2, boolean z10) {
        this.f5947v = i;
        this.f5949x = obj;
        this.f5948w = z10;
        this.f5950y = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5947v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((cd.e) this.f5949x).f((dd.e) this.f5950y, this.f5948w);
                return;
            case 1:
                Context context = (Context) this.f5949x;
                j9.i iVar = (j9.i) this.f5950y;
                try {
                    if (Binder.getCallingUid() == context.getApplicationInfo().uid) {
                        SharedPreferences.Editor editorEdit = n5.a.p(context).edit();
                        editorEdit.putBoolean("proxy_notification_initialized", true);
                        editorEdit.apply();
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                        if (this.f5948w) {
                            notificationManager.setNotificationDelegate("com.google.android.gms");
                        } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                            notificationManager.setNotificationDelegate(null);
                        }
                    } else {
                        Log.e("FirebaseMessaging", "error configuring notification delegate for package " + context.getPackageName());
                    }
                    return;
                } finally {
                    iVar.c(null);
                }
            default:
                ((z5.k) this.f5949x).f((String) this.f5950y, this.f5948w);
                return;
        }
    }

    public /* synthetic */ j(cd.e eVar, dd.e eVar2, boolean z10) {
        this.f5947v = 0;
        this.f5949x = eVar;
        this.f5950y = eVar2;
        this.f5948w = z10;
    }
}
