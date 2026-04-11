package ub;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference f12880d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f12881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zc.c f12882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f12883c;

    public r(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f12883c = scheduledThreadPoolExecutor;
        this.f12881a = sharedPreferences;
    }

    public final synchronized q a() {
        q qVar;
        String strR = this.f12882b.r();
        Pattern pattern = q.f12876d;
        qVar = null;
        if (!TextUtils.isEmpty(strR)) {
            String[] strArrSplit = strR.split("!", -1);
            if (strArrSplit.length == 2) {
                qVar = new q(strArrSplit[0], strArrSplit[1]);
            }
        }
        return qVar;
    }

    public final synchronized void b() {
        this.f12882b = zc.c.n(this.f12881a, this.f12883c);
    }

    public final synchronized void c(q qVar) {
        this.f12882b.s(qVar.f12879c);
    }
}
