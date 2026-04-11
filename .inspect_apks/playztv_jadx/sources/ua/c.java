package ua;

import be.h;
import id.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import od.t;
import org.json.JSONException;
import org.json.JSONObject;
import w2.b0;
import w2.h0;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements q, y6.c {
    public static g a(String str) {
        h.e(str, "jsonString");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        h.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, jSONObject.getString(next));
        }
        return new g(linkedHashMap);
    }

    public static String c(g gVar) throws JSONException {
        h.e(gVar, "extras");
        Map map = gVar.f6577u;
        if (map.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : t.J(map).entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        String string = jSONObject.toString();
        h.b(string);
        return string;
    }

    public static LinkedHashMap d(String str) {
        h.e(str, "jsonString");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        h.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, jSONObject.getString(next));
        }
        return linkedHashMap;
    }

    public static String f(Map map) throws JSONException {
        h.e(map, "headerMap");
        if (map.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        String string = jSONObject.toString();
        h.b(string);
        return string;
    }

    @Override // y6.c
    public void b(Object obj) {
        ((List) obj).clear();
    }

    @Override // w2.q
    public void e() {
        throw new UnsupportedOperationException();
    }

    @Override // w2.q
    public void j(b0 b0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // w2.q
    public h0 q(int i, int i10) {
        throw new UnsupportedOperationException();
    }
}
