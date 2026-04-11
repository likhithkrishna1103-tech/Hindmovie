package yb;

import android.content.SharedPreferences;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Date f14614e = new Date(-1);
    public static final Date f = new Date(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f14615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14616b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14617c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f14618d = new Object();

    public j(SharedPreferences sharedPreferences) {
        this.f14615a = sharedPreferences;
    }

    public final i a() {
        i iVar;
        synchronized (this.f14617c) {
            int i = this.f14615a.getInt("num_failed_fetches", 0);
            Date date = new Date(this.f14615a.getLong("backoff_end_time_in_millis", -1L));
            iVar = new i();
            iVar.f14612a = i;
            iVar.f14613b = date;
        }
        return iVar;
    }

    public final i b() {
        i iVar;
        synchronized (this.f14618d) {
            int i = this.f14615a.getInt("num_failed_realtime_streams", 0);
            Date date = new Date(this.f14615a.getLong("realtime_backoff_end_time_in_millis", -1L));
            iVar = new i();
            iVar.f14612a = i;
            iVar.f14613b = date;
        }
        return iVar;
    }

    public final void c(int i, Date date) {
        synchronized (this.f14617c) {
            this.f14615a.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public final void d(String str) {
        synchronized (this.f14616b) {
            this.f14615a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    public final void e(int i, Date date) {
        synchronized (this.f14618d) {
            this.f14615a.edit().putInt("num_failed_realtime_streams", i).putLong("realtime_backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public final void f() {
        synchronized (this.f14616b) {
            this.f14615a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    public final void g() {
        synchronized (this.f14616b) {
            this.f14615a.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}
