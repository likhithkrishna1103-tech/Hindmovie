package fc;

import com.bumptech.glide.manager.m;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.n8;
import com.google.android.gms.internal.measurement.p8;
import f9.f0;
import f9.w;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements a3.h, b7.a, m, ec.a, w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4550v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ e f4546w = new e(11);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ e f4547x = new e(12);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ e f4548y = new e(13);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ e f4549z = new e(14);
    public static final /* synthetic */ e A = new e(15);
    public static final /* synthetic */ e B = new e(16);
    public static final /* synthetic */ e C = new e(17);
    public static final /* synthetic */ e D = new e(18);
    public static final /* synthetic */ e E = new e(19);
    public static final /* synthetic */ e F = new e(20);
    public static final /* synthetic */ e G = new e(21);
    public static final /* synthetic */ e H = new e(22);
    public static final /* synthetic */ e I = new e(23);
    public static final /* synthetic */ e J = new e(24);
    public static final /* synthetic */ e K = new e(25);
    public static final /* synthetic */ e L = new e(26);
    public static final /* synthetic */ e M = new e(27);
    public static final /* synthetic */ e N = new e(28);
    public static final /* synthetic */ e O = new e(29);

    public /* synthetic */ e(int i) {
        this.f4550v = i;
    }

    public static md.g b(String str) {
        ge.i.e(str, "jsonString");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        ge.i.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, jSONObject.getString(next));
        }
        return new md.g(linkedHashMap);
    }

    public static String c(md.g gVar) throws JSONException {
        ge.i.e(gVar, "extras");
        Map map = gVar.f8433v;
        if (map.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : s.C(map).entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        String string = jSONObject.toString();
        ge.i.b(string);
        return string;
    }

    public static LinkedHashMap e(String str) {
        ge.i.e(str, "jsonString");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        ge.i.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, jSONObject.getString(next));
        }
        return linkedHashMap;
    }

    public static String g(Map map) throws JSONException {
        ge.i.e(map, "headerMap");
        if (map.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        String string = jSONObject.toString();
        ge.i.b(string);
        return string;
    }

    public static cd.a i(int i) {
        return i != 1 ? i != 2 ? i != 3 ? cd.a.f2143x : cd.a.A : cd.a.f2145z : cd.a.f2144y;
    }

    public static cd.h j(int i) {
        if (i == -1) {
            return cd.h.f2175z;
        }
        cd.h hVar = cd.h.f2174y;
        return (i == 0 || i != 1) ? hVar : cd.h.f2173x;
    }

    @Override // f9.w
    public Object a() {
        switch (this.f4550v) {
            case 12:
                return new Boolean(((Boolean) l7.f2522b.b()).booleanValue());
            case 13:
                List list = f0.f4108a;
                d7.f2368w.get();
                Long l10 = (Long) f7.f2404b.b();
                l10.getClass();
                return l10;
            case 14:
                List list2 = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2410e.b();
            case 15:
                List list3 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.o0.b()).longValue());
            case 16:
                List list4 = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2440u0.b();
            case 17:
                List list5 = f0.f4108a;
                d7.f2368w.get();
                Long l11 = (Long) f7.T.b();
                l11.getClass();
                return l11;
            case 18:
                List list6 = f0.f4108a;
                d7.f2368w.get();
                Long l12 = (Long) f7.L.b();
                l12.getClass();
                return l12;
            case 19:
                List list7 = f0.f4108a;
                d7.f2368w.get();
                Long l13 = (Long) f7.S.b();
                l13.getClass();
                return l13;
            case 20:
                List list8 = f0.f4108a;
                d7.f2368w.get();
                Long l14 = (Long) f7.f.b();
                l14.getClass();
                return l14;
            case 21:
                List list9 = f0.f4108a;
                d7.f2368w.get();
                Long l15 = (Long) f7.E.b();
                l15.getClass();
                return l15;
            case 22:
                List list10 = f0.f4108a;
                d7.f2368w.get();
                Long l16 = (Long) f7.V.b();
                l16.getClass();
                return l16;
            case 23:
                List list11 = f0.f4108a;
                d7.f2368w.get();
                Long l17 = (Long) f7.f2438t0.b();
                l17.getClass();
                return l17;
            case 24:
                List list12 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2428o.b()).longValue());
            case 25:
                List list13 = f0.f4108a;
                n8.f2555w.get();
                Boolean bool = (Boolean) p8.f2574a.b();
                bool.getClass();
                return bool;
            case 26:
                List list14 = f0.f4108a;
                n8.f2555w.get();
                Long l18 = (Long) p8.f2575b.b();
                l18.getClass();
                return l18;
            case 27:
                List list15 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2439u.b()).longValue());
            case 28:
                List list16 = f0.f4108a;
                d7.f2368w.get();
                Long l19 = (Long) f7.f2411e0.b();
                l19.getClass();
                return l19;
            default:
                List list17 = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2407c0.b();
        }
    }

    @Override // b7.a
    public File f(x6.e eVar) {
        return null;
    }

    @Override // a3.h
    public long d(long j4) {
        return j4;
    }

    @Override // b7.a
    public void h(x6.e eVar, z6.e eVar2) {
    }
}
