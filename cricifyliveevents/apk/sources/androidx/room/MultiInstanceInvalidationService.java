package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.LinkedHashMap;
import w4.h;
import w4.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1468v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LinkedHashMap f1469w = new LinkedHashMap();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i f1470x = new i(this);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h f1471y = new h(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        ge.i.e(intent, "intent");
        return this.f1471y;
    }
}
