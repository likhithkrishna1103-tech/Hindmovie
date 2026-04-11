package androidx.fragment.app;

import android.animation.Animator;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import app.cricfy.tv.activities.SplashActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import k4.o1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ua.n1;
import v1.k1;
import v1.l1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements p0.b, f8.b, e8.g, y1.n, y1.m, hc.a, k4.k0, y1.h, k4.c1, j9.d, j9.a, hb.e, z5.k, j9.h, a3.s {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f968v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f969w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f970x;

    public /* synthetic */ e(int i, Object obj, Object obj2) {
        this.f968v = i;
        this.f969w = obj;
        this.f970x = obj2;
    }

    private final Object k(j9.p pVar) {
        nc.h hVar = (nc.h) this.f969w;
        String str = (String) this.f970x;
        synchronized (hVar) {
            ((v.e) hVar.f9053b).remove(str);
        }
        return pVar;
    }

    private final Object l(j9.p pVar) {
        rc.g gVar = (rc.g) this.f969w;
        Date date = (Date) this.f970x;
        if (pVar.j()) {
            rc.l lVar = gVar.f10955g;
            synchronized (lVar.f10984b) {
                lVar.f10983a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
            }
            return pVar;
        }
        Exception excG = pVar.g();
        if (excG == null) {
            return pVar;
        }
        if (excG instanceof qc.e) {
            gVar.f10955g.i();
            return pVar;
        }
        gVar.f10955g.h();
        return pVar;
    }

    @Override // j9.d
    public void A(j9.p pVar) {
        String string;
        switch (this.f968v) {
            case 14:
                ((nc.g) this.f969w).a((Intent) this.f970x);
                return;
            default:
                SplashActivity splashActivity = (SplashActivity) this.f969w;
                qc.b bVar = (qc.b) this.f970x;
                int i = SplashActivity.f1541g0;
                if (pVar.j()) {
                    rc.h hVar = bVar.f10792h;
                    rc.e eVarC = hVar.f10959c.c();
                    String string2 = null;
                    if (eVarC != null) {
                        try {
                            string = eVarC.f10941b.getString("api_url");
                        } catch (JSONException unused) {
                            string = null;
                        }
                        break;
                    } else {
                        string = null;
                    }
                    if (string != null) {
                        rc.e eVarC2 = hVar.f10959c.c();
                        if (eVarC2 != null) {
                            synchronized (hVar.f10957a) {
                                try {
                                    Iterator it = hVar.f10957a.iterator();
                                    while (it.hasNext()) {
                                        hVar.f10958b.execute(new nc.i(3, (qc.g) it.next(), eVarC2));
                                    }
                                } finally {
                                }
                            }
                        }
                        break;
                    } else {
                        rc.e eVarC3 = hVar.f10960d.c();
                        if (eVarC3 != null) {
                            try {
                                string2 = eVarC3.f10941b.getString("api_url");
                                break;
                            } catch (JSONException unused2) {
                            }
                        }
                        if (string2 != null) {
                            string = string2;
                        } else {
                            Log.w("FirebaseRemoteConfig", "No value of type 'String' exists for parameter key 'api_url'.");
                            string = "";
                        }
                    }
                    com.bumptech.glide.d.t(splashActivity).edit().putString("api_host", string).apply();
                    splashActivity.w(string);
                    return;
                }
                return;
        }
    }

    @Override // j9.h
    public j9.p B(Object obj) {
        rc.c cVar = (rc.c) this.f969w;
        rc.e eVar = (rc.e) this.f970x;
        synchronized (cVar) {
            cVar.f10933c = vf.g.A(eVar);
        }
        return vf.g.A(eVar);
    }

    @Override // y1.m
    public void a(Object obj) {
        h2.a aVar = (h2.a) this.f969w;
        s2.y yVar = (s2.y) this.f970x;
        h2.k kVar = (h2.k) obj;
        kVar.getClass();
        s2.c0 c0Var = aVar.f5483d;
        if (c0Var == null) {
            return;
        }
        v1.p pVar = yVar.f11369c;
        pVar.getClass();
        int i = yVar.f11370d;
        h2.h hVar = kVar.f5514c;
        v1.f1 f1Var = aVar.f5481b;
        c0Var.getClass();
        f3.a aVar2 = new f3.a(pVar, i, hVar.d(f1Var, c0Var), 2);
        int i10 = yVar.f11368b;
        if (i10 != 0) {
            if (i10 == 1) {
                kVar.f5526q = aVar2;
                return;
            } else if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                kVar.f5527r = aVar2;
                return;
            }
        }
        kVar.f5525p = aVar2;
    }

    @Override // y1.h
    public void accept(Object obj) {
        switch (this.f968v) {
            case 10:
                k4.d1 d1Var = (k4.d1) this.f969w;
                l1 l1VarB = (l1) this.f970x;
                k4.h1 h1Var = (k4.h1) obj;
                d1Var.getClass();
                ua.k0 k0Var = l1VarB.D;
                if (!k0Var.isEmpty()) {
                    k1 k1VarC = l1VarB.a().c();
                    n1 it = k0Var.values().iterator();
                    while (it.hasNext()) {
                        v1.h1 h1Var2 = (v1.h1) it.next();
                        v1.g1 g1Var = (v1.g1) d1Var.f6945g.C.get(h1Var2.f12711a.f12703b);
                        if (g1Var == null || h1Var2.f12711a.f12702a != g1Var.f12702a) {
                            k1VarC.a(h1Var2);
                        } else {
                            k1VarC.a(new v1.h1(g1Var, h1Var2.f12712b));
                        }
                    }
                    l1VarB = k1VarC.b();
                }
                h1Var.e0(l1VarB);
                break;
            case 11:
                k4.d1 d1Var2 = (k4.d1) this.f969w;
                k4.s sVar = (k4.s) this.f970x;
                k4.b0 b0Var = (k4.b0) d1Var2.f6943d.get();
                if (b0Var != null && !b0Var.j()) {
                    b0Var.g(sVar, false);
                    break;
                }
                break;
            default:
                f3.a aVar = (f3.a) this.f969w;
                ((s2.i0) obj).J(aVar.f3935w, (s2.c0) aVar.f3936x, (s2.y) this.f970x);
                break;
        }
    }

    @Override // e8.g, ta.f
    public Object apply(Object obj) {
        e8.i iVar = (e8.i) this.f969w;
        x7.i iVar2 = (x7.i) this.f970x;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        e8.a aVar = iVar.f3844y;
        ArrayList arrayListS = iVar.s(sQLiteDatabase, iVar2, aVar.f3828b);
        for (u7.d dVar : u7.d.values()) {
            if (dVar != iVar2.f14436c) {
                int size = aVar.f3828b - arrayListS.size();
                if (size <= 0) {
                    break;
                }
                arrayListS.addAll(iVar.s(sQLiteDatabase, iVar2.b(dVar), size));
            }
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayListS.size(); i++) {
            sb.append(((e8.b) arrayListS.get(i)).f3832a);
            if (i < arrayListS.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j4 = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j4));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j4), hashSet);
                }
                hashSet.add(new e8.h(cursorQuery.getString(1), cursorQuery.getString(2)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayListS.listIterator();
        while (listIterator.hasNext()) {
            e8.b bVar = (e8.b) listIterator.next();
            long j7 = bVar.f3832a;
            if (map.containsKey(Long.valueOf(j7))) {
                u5.a aVarC = bVar.f3834c.c();
                for (e8.h hVar : (Set) map.get(Long.valueOf(j7))) {
                    aVarC.a(hVar.f3839a, hVar.f3840b);
                }
                listIterator.set(new e8.b(j7, bVar.f3833b, aVarC.b()));
            }
        }
        return arrayListS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:395:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v19, types: [f3.a] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v68 */
    @Override // y1.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.Object r25, v1.n r26) {
        /*
            Method dump skipped, instruction units count: 1654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.e.b(java.lang.Object, v1.n):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5 A[Catch: all -> 0x0055, TryCatch #3 {all -> 0x0055, blocks: (B:11:0x003c, B:14:0x0041, B:15:0x0042, B:23:0x005d, B:56:0x00d1, B:58:0x00d5, B:59:0x00d9), top: B:104:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #3 {all -> 0x0055, blocks: (B:11:0x003c, B:14:0x0041, B:15:0x0042, B:23:0x005d, B:56:0x00d1, B:58:0x00d5, B:59:0x00d9), top: B:104:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0121  */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v28, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v4, types: [j9.p] */
    /* JADX WARN: Type inference failed for: r0v40, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v3, types: [rc.j] */
    @Override // j9.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(j9.p r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.e.c(j9.p):java.lang.Object");
    }

    @Override // k4.k0
    public void d(k4.s sVar) {
        switch (this.f968v) {
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                k4.l0 l0Var = (k4.l0) this.f969w;
                Bundle bundle = (Bundle) this.f970x;
                k4.b0 b0Var = l0Var.f7060g;
                if (bundle == null) {
                    Bundle bundle2 = Bundle.EMPTY;
                }
                b0Var.n(sVar);
                break;
            default:
                k4.l0 l0Var2 = (k4.l0) this.f969w;
                l4.o oVar = (l4.o) this.f970x;
                l0Var2.getClass();
                String str = oVar.f7746v;
                if (TextUtils.isEmpty(str)) {
                    y1.b.p("MediaSessionLegacyStub", "onRemoveQueueItem(): Media ID shouldn't be null");
                } else {
                    k4.h1 h1Var = l0Var2.f7060g.f6924t;
                    if (h1Var.Z(17)) {
                        v1.f1 f1VarV0 = h1Var.v0();
                        v1.e1 e1Var = new v1.e1();
                        for (int i = 0; i < f1VarV0.o(); i++) {
                            if (TextUtils.equals(f1VarV0.m(i, e1Var, 0L).f12645c.f12696a, str)) {
                                h1Var.z0(i);
                            }
                        }
                    } else {
                        y1.b.p("MediaSessionLegacyStub", "Can't remove item by ID without COMMAND_GET_TIMELINE being available");
                    }
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    @Override // hb.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(dd.c r5) {
        /*
            r4 = this;
            int r0 = r4.f968v
            switch(r0) {
                case 16: goto L1f;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r4.f969w
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r4.f970x
            hb.b r1 = (hb.b) r1
            android.os.Trace.beginSection(r0)     // Catch: java.lang.Throwable -> L1a
            hb.e r0 = r1.f     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r5 = r0.e(r5)     // Catch: java.lang.Throwable -> L1a
            android.os.Trace.endSection()
            return r5
        L1a:
            r5 = move-exception
            android.os.Trace.endSection()
            throw r5
        L1f:
            java.lang.Object r0 = r4.f969w
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r4.f970x
            a3.m r1 = (a3.m) r1
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            java.lang.Object r5 = r5.b(r2)
            android.content.Context r5 = (android.content.Context) r5
            int r1 = r1.f219v
            switch(r1) {
                case 2: goto La1;
                case 3: goto L8c;
                case 4: goto L4a;
                default: goto L34;
            }
        L34:
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            java.lang.String r5 = r5.getPackageName()
            java.lang.String r5 = r1.getInstallerPackageName(r5)
            if (r5 == 0) goto L47
            java.lang.String r5 = com.google.firebase.FirebaseCommonRegistrar.a(r5)
            goto Lad
        L47:
            java.lang.String r5 = ""
            goto Lad
        L4a:
            int r1 = android.os.Build.VERSION.SDK_INT
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            java.lang.String r3 = "android.hardware.type.television"
            boolean r2 = r2.hasSystemFeature(r3)
            if (r2 == 0) goto L5b
            java.lang.String r5 = "tv"
            goto Lad
        L5b:
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            java.lang.String r3 = "android.hardware.type.watch"
            boolean r2 = r2.hasSystemFeature(r3)
            if (r2 == 0) goto L6a
            java.lang.String r5 = "watch"
            goto Lad
        L6a:
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            java.lang.String r3 = "android.hardware.type.automotive"
            boolean r2 = r2.hasSystemFeature(r3)
            if (r2 == 0) goto L79
            java.lang.String r5 = "auto"
            goto Lad
        L79:
            r2 = 26
            if (r1 < r2) goto L47
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            java.lang.String r1 = "android.hardware.type.embedded"
            boolean r5 = r5.hasSystemFeature(r1)
            if (r5 == 0) goto L47
            java.lang.String r5 = "embedded"
            goto Lad
        L8c:
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()
            if (r5 == 0) goto L47
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L47
            int r5 = i2.a0.a(r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto Lad
        La1:
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()
            if (r5 == 0) goto L47
            int r5 = r5.targetSdkVersion
            java.lang.String r5 = java.lang.String.valueOf(r5)
        Lad:
            pc.a r1 = new pc.a
            r1.<init>(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.e.e(dd.c):java.lang.Object");
    }

    @Override // z5.k
    public void f(String str, boolean z10) {
        String str2;
        int i = this.f968v;
        Object obj = this.f970x;
        Object obj2 = this.f969w;
        switch (i) {
            case 18:
                SplashActivity splashActivity = (SplashActivity) obj2;
                String str3 = (String) obj;
                int i10 = SplashActivity.f1541g0;
                if (z10) {
                    try {
                        JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
                        y5.a aVarK = com.bumptech.glide.e.k(splashActivity, splashActivity.W, jSONObject);
                        splashActivity.f1545d0 = aVarK;
                        splashActivity.W.I = aVarK.f14908z;
                        splashActivity.f1546e0 = jSONObject.optString("app_versions", "3");
                        splashActivity.B();
                    } catch (IndexOutOfBoundsException | JSONException e9) {
                        Log.e("Pro Pro Error", e9.getMessage());
                        splashActivity.A(str3);
                        return;
                    }
                } else if (!"cHJvX2lzX3Bybw==".equals(str)) {
                    splashActivity.A(str3);
                } else {
                    splashActivity.f1542a0 = false;
                    ((LinearLayout) splashActivity.X.f2035b).setVisibility(0);
                }
                break;
            case 25:
                String str4 = (String) obj2;
                z5.i iVar = (z5.i) obj;
                try {
                    JSONObject jSONObject2 = new JSONObject(ab.b.g(str));
                    String string = jSONObject2.getString("link");
                    HashMap map = new HashMap();
                    if (string.contains("|")) {
                        String[] strArrSplit = string.split("\\|");
                        String str5 = strArrSplit[0];
                        map = ab.b.m(strArrSplit[1]);
                        str2 = str5;
                    } else {
                        str2 = string;
                    }
                    String string2 = jSONObject2.getString("type");
                    kf.p pVarN = ab.b.n(map);
                    android.support.v4.media.session.b.J(null, str2, false, null, pVarN, new z5.f(str2, string2, str4, pVarN, iVar, 1));
                } catch (JSONException unused) {
                    iVar.j("error", null);
                    return;
                }
                break;
            default:
                String str6 = (String) obj2;
                z5.k kVar = (z5.k) obj;
                if (!z10) {
                    kVar.f("https://error.m3u8", false);
                } else {
                    new Thread(new androidx.emoji2.text.n(str, str6, kVar, 12)).start();
                }
                break;
        }
    }

    @Override // f8.b
    public Object g() {
        switch (this.f968v) {
            case 1:
                d8.j jVar = (d8.j) this.f969w;
                Iterable iterable = (Iterable) this.f970x;
                e8.i iVar = (e8.i) ((e8.d) jVar.f3553c);
                iVar.getClass();
                if (iterable.iterator().hasNext()) {
                    iVar.a().compileStatement("DELETE FROM events WHERE _id in " + e8.i.C(iterable)).execute();
                    break;
                }
                break;
            default:
                d8.j jVar2 = (d8.j) this.f969w;
                for (Map.Entry entry : ((HashMap) this.f970x).entrySet()) {
                    ((e8.i) ((e8.c) jVar2.i)).z(((Integer) entry.getValue()).intValue(), a8.c.B, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    @Override // a3.s
    public a3.p[] h(Uri uri, Map map) {
        s2.p pVar = (s2.p) this.f969w;
        v1.p pVar2 = (v1.p) this.f970x;
        return new a3.p[]{pVar.f11287c.e(pVar2) ? new x3.k(pVar.f11287c.c(pVar2), null) : new i3.a(pVar2)};
    }

    @Override // k4.c1
    public Object i(k4.b0 b0Var, k4.s sVar, int i) {
        switch (this.f968v) {
            case 12:
                return b0Var.j() ? w1.d.l(new o1(-100)) : y1.a0.a0((ya.w) ((k4.c1) this.f969w).i(b0Var, sVar, i), new c8.b(b0Var, sVar, (k4.r0) this.f970x, 6));
            default:
                return b0Var.j() ? w1.d.l(new o1(-100)) : y1.a0.a0((ya.w) ((k4.c1) this.f969w).i(b0Var, sVar, i), new c8.b(b0Var, sVar, (k4.b1) this.f970x, 7));
        }
    }

    @Override // hc.a
    public void j(hc.b bVar) {
        hc.a aVar = (hc.a) this.f969w;
        hc.a aVar2 = (hc.a) this.f970x;
        aVar.j(bVar);
        aVar2.j(bVar);
    }

    @Override // p0.b
    public void onCancel() {
        Animator animator = (Animator) this.f969w;
        e1 e1Var = (e1) this.f970x;
        ge.i.e(e1Var, "$operation");
        animator.end();
        if (r0.J(2)) {
            Log.v("FragmentManager", "Animator from operation " + e1Var + " has been canceled.");
        }
    }

    public /* synthetic */ e(k4.l0 l0Var, k4.k1 k1Var, Bundle bundle) {
        this.f968v = 8;
        this.f969w = l0Var;
        this.f970x = bundle;
    }
}
