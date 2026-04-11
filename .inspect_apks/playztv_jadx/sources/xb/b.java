package xb;

import a2.g1;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yb.j;
import yb.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ha.c f14336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f14337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yb.c f14338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final yb.c f14339e;
    public final yb.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yb.g f14340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final yb.h f14341h;
    public final j i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p2.c f14342j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z0.i f14343k;

    public b(Context context, ha.c cVar, Executor executor, yb.c cVar2, yb.c cVar3, yb.c cVar4, yb.g gVar, yb.h hVar, j jVar, p2.c cVar5, z0.i iVar) {
        this.f14335a = context;
        this.f14336b = cVar;
        this.f14337c = executor;
        this.f14338d = cVar2;
        this.f14339e = cVar3;
        this.f = cVar4;
        this.f14340g = gVar;
        this.f14341h = hVar;
        this.i = jVar;
        this.f14342j = cVar5;
        this.f14343k = iVar;
    }

    public static ArrayList c(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap map = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    public final String a(String str) {
        String string;
        yb.h hVar = this.f14341h;
        yb.e eVarC = hVar.f14610c.c();
        String string2 = null;
        if (eVarC == null) {
            string = null;
        } else {
            try {
                string = eVarC.f14592b.getString(str);
            } catch (JSONException unused) {
                string = null;
            }
        }
        if (string == null) {
            yb.e eVarC2 = hVar.f14611d.c();
            if (eVarC2 != null) {
                try {
                    string2 = eVarC2.f14592b.getString(str);
                } catch (JSONException unused2) {
                }
            }
            if (string2 != null) {
                return string2;
            }
            Log.w("FirebaseRemoteConfig", "No value of type 'String' exists for parameter key '" + str + "'.");
            return "";
        }
        yb.e eVarC3 = hVar.f14610c.c();
        if (eVarC3 != null) {
            synchronized (hVar.f14608a) {
                try {
                    Iterator it = hVar.f14608a.iterator();
                    while (it.hasNext()) {
                        hVar.f14609b.execute(new g1((g) it.next(), str, eVarC3, 12));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return string;
    }

    public final void b(boolean z2) {
        p2.c cVar = this.f14342j;
        synchronized (cVar) {
            ((m) cVar.f10131w).f14628e = z2;
            if (!z2) {
                cVar.e();
            }
        }
    }
}
