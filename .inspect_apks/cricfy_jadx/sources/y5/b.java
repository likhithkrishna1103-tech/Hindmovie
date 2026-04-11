package y5;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14912d;

    public static b a(JSONObject jSONObject) {
        String strReplaceFirst = jSONObject.getString("name").replaceFirst("psp_", "");
        b bVar = new b();
        bVar.f14909a = strReplaceFirst;
        bVar.f14910b = jSONObject.getString("logo");
        bVar.f14911c = jSONObject.getString("api");
        bVar.f14912d = jSONObject.getString("type");
        return bVar;
    }
}
