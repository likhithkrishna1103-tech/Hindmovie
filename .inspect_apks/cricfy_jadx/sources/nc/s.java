package nc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference f9081d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f9082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public dd.c f9083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f9084c;

    public s(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f9084c = scheduledThreadPoolExecutor;
        this.f9082a = sharedPreferences;
    }

    public final synchronized r a() {
        r rVar;
        String strQ = this.f9083b.q();
        Pattern pattern = r.f9077d;
        rVar = null;
        if (!TextUtils.isEmpty(strQ)) {
            String[] strArrSplit = strQ.split("!", -1);
            if (strArrSplit.length == 2) {
                rVar = new r(strArrSplit[0], strArrSplit[1]);
            }
        }
        return rVar;
    }

    public final synchronized void b() {
        this.f9083b = dd.c.m(this.f9082a, this.f9084c);
    }

    public final synchronized void c(r rVar) {
        this.f9083b.r(rVar.f9080c);
    }
}
