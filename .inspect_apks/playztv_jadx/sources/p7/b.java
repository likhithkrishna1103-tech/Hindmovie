package p7;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f10248h;
    public static PendingIntent i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f10249j = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s.i f10250a = new s.i(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0.g f10252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f10253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Messenger f10254e;
    public Messenger f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f10255g;

    public b(Context context) {
        this.f10251b = context;
        a0.g gVar = new a0.g();
        gVar.f60v = 0;
        gVar.f61w = context;
        this.f10252c = gVar;
        this.f10254e = new Messenger(new e(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f10253d = scheduledThreadPoolExecutor;
    }

    public static synchronized String b() {
        int i10;
        i10 = f10248h;
        f10248h = i10 + 1;
        return Integer.toString(i10);
    }

    public static synchronized void c(Context context, Intent intent) {
        try {
            if (i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                i = PendingIntent.getBroadcast(context, 0, intent2, e8.a.f4587a);
            }
            intent.putExtra("app", i);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o8.o a(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.b.a(android.os.Bundle):o8.o");
    }

    public final void d(String str, Bundle bundle) {
        synchronized (this.f10250a) {
            try {
                o8.h hVar = (o8.h) this.f10250a.remove(str);
                if (hVar != null) {
                    hVar.a(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
