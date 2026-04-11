package nc;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f9073d = TimeUnit.DAYS.toMillis(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9076c;

    public q(long j4, String str, String str2) {
        this.f9074a = str;
        this.f9075b = str2;
        this.f9076c = j4;
    }

    public static String a(long j4, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j4);
            return jSONObject.toString();
        } catch (JSONException e9) {
            Log.w("FirebaseMessaging", "Failed to encode token: " + e9);
            return null;
        }
    }

    public static q b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new q(0L, str, null);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new q(jSONObject.getLong("timestamp"), jSONObject.getString("token"), jSONObject.getString("appVersion"));
        } catch (JSONException e9) {
            Log.w("FirebaseMessaging", "Failed to parse token: " + e9);
            return null;
        }
    }
}
