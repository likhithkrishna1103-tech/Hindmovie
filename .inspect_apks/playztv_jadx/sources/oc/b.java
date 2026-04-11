package oc;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9514d;

    public static b a(JSONObject jSONObject) {
        String strReplaceFirst = jSONObject.getString("name").replaceFirst("psp_", "");
        b bVar = new b();
        bVar.f9511a = strReplaceFirst;
        bVar.f9512b = jSONObject.getString("logo");
        bVar.f9513c = jSONObject.getString("api");
        bVar.f9514d = jSONObject.getString("type");
        return bVar;
    }
}
