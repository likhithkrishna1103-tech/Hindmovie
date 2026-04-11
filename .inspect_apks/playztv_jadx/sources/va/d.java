package va;

import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f13438a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13439b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13440c;

    public d(int i) {
        this.f13440c = i;
    }

    public final synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.f13438a));
    }

    public final synchronized boolean b(String str) {
        synchronized (this) {
            int i = this.f13440c;
            String strSubstring = 36 > i ? "com.crashlytics.version-control-info".substring(0, i) : "com.crashlytics.version-control-info";
            if (this.f13438a.size() >= this.f13439b && !this.f13438a.containsKey(strSubstring)) {
                Log.w("FirebaseCrashlytics", "Ignored entry \"com.crashlytics.version-control-info\" when adding custom keys. Maximum allowable: " + this.f13439b, null);
                return false;
            }
            int i10 = this.f13440c;
            String strTrim = str.trim();
            if (strTrim.length() > i10) {
                strTrim = strTrim.substring(0, i10);
            }
            String str2 = (String) this.f13438a.get(strSubstring);
            if (str2 == null ? strTrim == null : str2.equals(strTrim)) {
                return false;
            }
            this.f13438a.put(strSubstring, strTrim);
            return true;
        }
    }

    public final synchronized void c(Map map) {
        String strTrim;
        try {
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                int i10 = this.f13440c;
                String strTrim2 = str.trim();
                if (strTrim2.length() > i10) {
                    strTrim2 = strTrim2.substring(0, i10);
                }
                if (this.f13438a.size() < this.f13439b || this.f13438a.containsKey(strTrim2)) {
                    String str2 = (String) entry.getValue();
                    HashMap map2 = this.f13438a;
                    if (str2 == null) {
                        strTrim = "";
                    } else {
                        int i11 = this.f13440c;
                        strTrim = str2.trim();
                        if (strTrim.length() > i11) {
                            strTrim = strTrim.substring(0, i11);
                        }
                    }
                    map2.put(strTrim2, strTrim);
                } else {
                    i++;
                }
            }
            if (i > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + i + " entries when adding custom keys. Maximum allowable: " + this.f13439b, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
