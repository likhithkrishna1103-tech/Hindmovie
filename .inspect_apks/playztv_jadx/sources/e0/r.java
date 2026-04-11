package e0;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationManager f4274a;

    static {
        new HashSet();
    }

    public r(Context context) {
        this.f4274a = (NotificationManager) context.getSystemService("notification");
    }
}
