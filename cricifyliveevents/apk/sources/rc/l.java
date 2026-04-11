package rc;

import android.content.SharedPreferences;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Date f10982e = new Date(-1);
    public static final Date f = new Date(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f10983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10984b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10985c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f10986d = new Object();

    public l(SharedPreferences sharedPreferences) {
        this.f10983a = sharedPreferences;
    }

    public final k a() {
        k kVar;
        synchronized (this.f10985c) {
            int i = this.f10983a.getInt("num_failed_fetches", 0);
            Date date = new Date(this.f10983a.getLong("backoff_end_time_in_millis", -1L));
            kVar = new k();
            kVar.f10980a = i;
            kVar.f10981b = date;
        }
        return kVar;
    }

    public final HashMap b() {
        try {
            JSONObject jSONObject = new JSONObject(this.f10983a.getString("customSignals", "{}"));
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public final k c() {
        k kVar;
        synchronized (this.f10986d) {
            int i = this.f10983a.getInt("num_failed_realtime_streams", 0);
            Date date = new Date(this.f10983a.getLong("realtime_backoff_end_time_in_millis", -1L));
            kVar = new k();
            kVar.f10980a = i;
            kVar.f10981b = date;
        }
        return kVar;
    }

    public final void d(int i, Date date) {
        synchronized (this.f10985c) {
            this.f10983a.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public final void e(String str) {
        synchronized (this.f10984b) {
            this.f10983a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    public final void f(Date date) {
        synchronized (this.f10986d) {
            this.f10983a.edit().putLong("realtime_backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public final void g(int i, Date date) {
        synchronized (this.f10986d) {
            this.f10983a.edit().putInt("num_failed_realtime_streams", i).putLong("realtime_backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public final void h() {
        synchronized (this.f10984b) {
            this.f10983a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    public final void i() {
        synchronized (this.f10984b) {
            this.f10983a.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}
