package rc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Date f10939h = new Date(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f10940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f10941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Date f10942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONArray f10943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f10944e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONArray f10945g;

    public e(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j4, JSONArray jSONArray2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j4);
        jSONObject3.put("rollout_metadata_key", jSONArray2);
        this.f10941b = jSONObject;
        this.f10942c = date;
        this.f10943d = jSONArray;
        this.f10944e = jSONObject2;
        this.f = j4;
        this.f10945g = jSONArray2;
        this.f10940a = jSONObject3;
    }

    public static e a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rollout_metadata_key");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        return new e(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), jSONObject2, jSONObject.optLong("template_version_number_key"), jSONArrayOptJSONArray);
    }

    public static d c() {
        d dVar = new d();
        dVar.f10934a = new JSONObject();
        dVar.f10935b = f10939h;
        dVar.f10936c = new JSONArray();
        dVar.f10937d = new JSONObject();
        dVar.f10938e = 0L;
        dVar.f = new JSONArray();
        return dVar;
    }

    public final HashMap b() throws JSONException {
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            JSONArray jSONArray = this.f10945g;
            if (i >= jSONArray.length()) {
                return map;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("rolloutId");
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray2 = jSONObject.getJSONArray("affectedParameterKeys");
            for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                String string3 = jSONArray2.getString(i10);
                if (!map.containsKey(string3)) {
                    map.put(string3, new HashMap());
                }
                Map map2 = (Map) map.get(string3);
                if (map2 != null) {
                    map2.put(string, string2);
                }
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f10940a.toString().equals(((e) obj).f10940a.toString());
        }
        return false;
    }

    public final int hashCode() {
        return this.f10940a.hashCode();
    }

    public final String toString() {
        return this.f10940a.toString();
    }
}
