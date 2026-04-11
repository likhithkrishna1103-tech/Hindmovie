package ta;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements pc.i, o8.e, o8.d, o8.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f12372u;

    public /* synthetic */ j(Object obj) {
        this.f12372u = obj;
    }

    public static boolean g(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static String k(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean a(String str) {
        String strF = f(str);
        return "1".equals(strF) || Boolean.parseBoolean(strF);
    }

    public Integer b(String str) {
        String strF = f(str);
        if (TextUtils.isEmpty(strF)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strF));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + k(str) + "(" + strF + ") into an int");
            return null;
        }
    }

    @Override // o8.e
    public void c(Object obj) {
        ((CountDownLatch) this.f12372u).countDown();
    }

    public JSONArray d(String str) {
        String strF = f(str);
        if (TextUtils.isEmpty(strF)) {
            return null;
        }
        try {
            return new JSONArray(strF);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + k(str) + ": " + strF + ", falling back to default");
            return null;
        }
    }

    public String e(Resources resources, String str, String str2) {
        String[] strArr;
        String strF = f(str2);
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        String strF2 = f(str2.concat("_loc_key"));
        if (TextUtils.isEmpty(strF2)) {
            return null;
        }
        int identifier = resources.getIdentifier(strF2, "string", str);
        if (identifier == 0) {
            Log.w("NotificationParams", k(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        JSONArray jSONArrayD = d(str2.concat("_loc_args"));
        if (jSONArrayD == null) {
            strArr = null;
        } else {
            int length = jSONArrayD.length();
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArrayD.optString(i);
            }
        }
        if (strArr == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, strArr);
        } catch (MissingFormatArgumentException e10) {
            Log.w("NotificationParams", "Missing format argument for " + k(str2) + ": " + Arrays.toString(strArr) + " Default value will be used.", e10);
            return null;
        }
    }

    public String f(String str) {
        Bundle bundle = (Bundle) this.f12372u;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String strReplace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (bundle.containsKey(strReplace)) {
                str = strReplace;
            }
        }
        return bundle.getString(str);
    }

    @Override // o8.b
    public void h() {
        ((CountDownLatch) this.f12372u).countDown();
    }

    public void i(b7.s sVar, Thread thread, Throwable th) {
        m mVar = (m) this.f12372u;
        synchronized (mVar) {
            String str = "Handling uncaught exception \"" + th + "\" from thread " + thread.getName();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str, null);
            }
            try {
                x.a(mVar.f12385e.f12823a.b(new k(mVar, System.currentTimeMillis(), th, thread, sVar)));
            } catch (TimeoutException unused) {
                Log.e("FirebaseCrashlytics", "Cannot send reports. Timed out while fetching settings.", null);
            } catch (Exception e10) {
                Log.e("FirebaseCrashlytics", "Error handling uncaught exception", e10);
            }
        }
    }

    public Bundle j() {
        Bundle bundle = (Bundle) this.f12372u;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals("from")) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }

    @Override // pc.i
    public void l(String str, Map map) {
        tc.g gVar = (tc.g) this.f12372u;
        gVar.f(str, gVar.f12471k, null, gVar.f12473m, map);
    }

    @Override // o8.d
    public void t(Exception exc) {
        ((CountDownLatch) this.f12372u).countDown();
    }

    public j(Bundle bundle) {
        this.f12372u = new Bundle(bundle);
    }

    public j() {
        this.f12372u = new CountDownLatch(1);
    }
}
