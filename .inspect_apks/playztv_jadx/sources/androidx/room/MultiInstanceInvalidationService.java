package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.LinkedHashMap;
import r4.h;
import r4.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1685u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinkedHashMap f1686v = new LinkedHashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f1687w = new i(this);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h f1688x = new h(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        be.h.e(intent, "intent");
        return this.f1688x;
    }
}
