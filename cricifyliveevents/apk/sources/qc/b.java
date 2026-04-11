package qc;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import nb.w;
import nc.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rc.j;
import rc.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bb.c f10787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f10788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rc.c f10789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rc.c f10790e;
    public final rc.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rc.g f10791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final rc.h f10792h;
    public final l i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f10793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p f10794k;

    public b(Context context, bb.c cVar, Executor executor, rc.c cVar2, rc.c cVar3, rc.c cVar4, rc.g gVar, rc.h hVar, l lVar, w wVar, p pVar) {
        this.f10786a = context;
        this.f10787b = cVar;
        this.f10788c = executor;
        this.f10789d = cVar2;
        this.f10790e = cVar3;
        this.f = cVar4;
        this.f10791g = gVar;
        this.f10792h = hVar;
        this.i = lVar;
        this.f10793j = wVar;
        this.f10794k = pVar;
    }

    public static ArrayList b(JSONArray jSONArray) throws JSONException {
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

    public final void a(boolean z10) {
        w wVar = this.f10793j;
        synchronized (wVar) {
            ((j) wVar.f9017x).k(z10);
            if (!z10) {
                wVar.x();
            }
        }
    }
}
