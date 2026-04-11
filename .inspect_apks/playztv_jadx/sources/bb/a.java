package bb;

import android.text.TextUtils;
import android.util.Log;
import e6.i;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1976a;

    public static void a(kc.b bVar, f fVar) {
        String str = fVar.f1987a;
        if (str != null) {
            bVar.x("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        }
        bVar.x("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        bVar.x("X-CRASHLYTICS-API-CLIENT-VERSION", "19.2.0");
        bVar.x("Accept", "application/json");
        String str2 = fVar.f1988b;
        if (str2 != null) {
            bVar.x("X-CRASHLYTICS-DEVICE-MODEL", str2);
        }
        String str3 = fVar.f1989c;
        if (str3 != null) {
            bVar.x("X-CRASHLYTICS-OS-BUILD-VERSION", str3);
        }
        String str4 = fVar.f1990d;
        if (str4 != null) {
            bVar.x("X-CRASHLYTICS-OS-DISPLAY-VERSION", str4);
        }
        String str5 = fVar.f1991e.c().f12351a;
        if (str5 != null) {
            bVar.x("X-CRASHLYTICS-INSTALLATION-ID", str5);
        }
    }

    public static HashMap b(f fVar) {
        HashMap map = new HashMap();
        map.put("build_version", fVar.f1993h);
        map.put("display_version", fVar.f1992g);
        map.put("source", Integer.toString(fVar.i));
        String str = fVar.f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject c(i iVar) {
        String str = this.f1976a;
        int i = iVar.f4522u;
        qa.c cVar = qa.c.f11167a;
        cVar.e("Settings response code was: " + i);
        if (i != 200 && i != 201 && i != 202 && i != 203) {
            String str2 = "Settings request failed; (status: " + i + ") from " + str;
            if (cVar.a(6)) {
                Log.e("FirebaseCrashlytics", str2, null);
            }
            return null;
        }
        String str3 = (String) iVar.f4523v;
        try {
            return new JSONObject(str3);
        } catch (Exception e10) {
            cVar.f("Failed to parse settings JSON from " + str, e10);
            cVar.f("Settings response " + str3, null);
            return null;
        }
    }
}
