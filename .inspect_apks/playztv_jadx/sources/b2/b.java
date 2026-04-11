package b2;

import a2.w;
import aa.q1;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import com.playz.tv.activities.LandscapeActivity;
import com.playz.tv.activities.SplashActivity;
import ea.y;
import g4.b0;
import g4.d1;
import g4.e1;
import g4.j1;
import g4.l0;
import g4.m0;
import g4.m1;
import g4.s;
import g4.s0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import o2.d0;
import o2.k0;
import o2.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p1.f1;
import p1.g1;
import p1.h1;
import p1.k1;
import p1.l1;
import p1.q;
import p1.w0;
import w2.r;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements s1.n, s1.m, na.e, l0, s1.h, e1, pc.l, o8.c, k7.b, j7.e, nb.a, r, o8.a, o8.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1727u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f1728v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f1729w;

    public /* synthetic */ b(m0 m0Var, m1 m1Var, Bundle bundle) {
        this.f1727u = 3;
        this.f1728v = m0Var;
        this.f1729w = bundle;
    }

    private final Object k(o8.o oVar) {
        ub.i iVar = (ub.i) this.f1728v;
        String str = (String) this.f1729w;
        synchronized (iVar) {
            ((s.e) iVar.f12855b).remove(str);
        }
        return oVar;
    }

    private final Object l(o8.o oVar) {
        yb.g gVar = (yb.g) this.f1728v;
        Date date = (Date) this.f1729w;
        if (oVar.j()) {
            yb.j jVar = gVar.f14606g;
            synchronized (jVar.f14616b) {
                jVar.f14615a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
            }
            return oVar;
        }
        Exception excG = oVar.g();
        if (excG == null) {
            return oVar;
        }
        if (excG instanceof xb.e) {
            gVar.f14606g.g();
            return oVar;
        }
        gVar.f14606g.f();
        return oVar;
    }

    @Override // o8.c
    public void A(o8.o oVar) {
        int i = this.f1727u;
        Object obj = this.f1729w;
        Object obj2 = this.f1728v;
        switch (i) {
            case 10:
                SplashActivity splashActivity = (SplashActivity) obj2;
                xb.b bVar = (xb.b) obj;
                int i10 = SplashActivity.f3647g0;
                if (oVar.j()) {
                    String strA = bVar.a("api_url");
                    splashActivity.f3650c0.f9505u = bVar.a("telegram_url");
                    splashActivity.f3650c0.f9507w = bVar.a("web_url");
                    uc.b.f(splashActivity).edit().putString("api_host", strA).apply();
                    splashActivity.w(strA);
                }
                break;
            default:
                ((ub.h) obj2).a((Intent) obj);
                break;
        }
    }

    @Override // s1.m
    public void a(Object obj) {
        a aVar = (a) this.f1728v;
        z zVar = (z) this.f1729w;
        n nVar = (n) obj;
        nVar.getClass();
        d0 d0Var = aVar.f1722d;
        if (d0Var == null) {
            return;
        }
        q qVar = zVar.f9257c;
        qVar.getClass();
        int i = zVar.f9258d;
        j jVar = nVar.f1765c;
        f1 f1Var = aVar.f1720b;
        d0Var.getClass();
        aa.l0 l0Var = new aa.l0(qVar, i, jVar.d(f1Var, d0Var), 1);
        int i10 = zVar.f9256b;
        if (i10 != 0) {
            if (i10 == 1) {
                nVar.f1777q = l0Var;
                return;
            } else if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                nVar.f1778r = l0Var;
                return;
            }
        }
        nVar.f1776p = l0Var;
    }

    @Override // s1.h
    public void accept(Object obj) {
        switch (this.f1727u) {
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                g4.f1 f1Var = (g4.f1) this.f1728v;
                l1 l1VarB = (l1) this.f1729w;
                j1 j1Var = (j1) obj;
                f1Var.getClass();
                aa.m0 m0Var = l1VarB.D;
                if (!m0Var.isEmpty()) {
                    k1 k1VarC = l1VarB.a().c();
                    q1 it = m0Var.values().iterator();
                    while (it.hasNext()) {
                        h1 h1Var = (h1) it.next();
                        g1 g1Var = (g1) f1Var.f5007g.B.get(h1Var.f9783a.f9763b);
                        if (g1Var == null || h1Var.f9783a.f9762a != g1Var.f9762a) {
                            k1VarC.a(h1Var);
                        } else {
                            k1VarC.a(new h1(g1Var, h1Var.f9784b));
                        }
                    }
                    l1VarB = k1VarC.b();
                }
                j1Var.b0(l1VarB);
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                g4.f1 f1Var2 = (g4.f1) this.f1728v;
                s sVar = (s) this.f1729w;
                b0 b0Var = (b0) f1Var2.f5005d.get();
                if (b0Var != null && !b0Var.j()) {
                    b0Var.g(sVar, false);
                    break;
                }
                break;
            default:
                aa.l0 l0Var = (aa.l0) this.f1728v;
                ((k0) obj).l(l0Var.f705v, (d0) l0Var.f706w, (z) this.f1729w);
                break;
        }
    }

    @Override // j7.e
    public Object apply(Object obj) {
        j7.g gVar = (j7.g) this.f1728v;
        c7.j jVar = (c7.j) this.f1729w;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        j7.a aVar = gVar.f6823x;
        ArrayList arrayListX = gVar.x(sQLiteDatabase, jVar, aVar.f6810b);
        for (z6.d dVar : z6.d.values()) {
            if (dVar != jVar.f2562c) {
                int size = aVar.f6810b - arrayListX.size();
                if (size <= 0) {
                    break;
                }
                arrayListX.addAll(gVar.x(sQLiteDatabase, jVar.b(dVar), size));
            }
        }
        HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayListX.size(); i++) {
            sb2.append(((j7.b) arrayListX.get(i)).f6814a);
            if (i < arrayListX.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j5 = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j5));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j5), hashSet);
                }
                hashSet.add(new j7.f(cursorQuery.getString(1), cursorQuery.getString(2)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayListX.listIterator();
        while (listIterator.hasNext()) {
            j7.b bVar = (j7.b) listIterator.next();
            long j8 = bVar.f6814a;
            if (map.containsKey(Long.valueOf(j8))) {
                c7.h hVarC = bVar.f6816c.c();
                for (j7.f fVar : (Set) map.get(Long.valueOf(j8))) {
                    hVarC.a(fVar.f6817a, fVar.f6818b);
                }
                listIterator.set(new j7.b(j8, bVar.f6815b, hVarC.c()));
            }
        }
        return arrayListX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v4, types: [o8.o] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r13v3, types: [yb.m] */
    @Override // o8.a
    public Object b(o8.o oVar) throws Throwable {
        Integer num;
        Throwable th;
        Integer numValueOf;
        int responseCode;
        boolean zD;
        switch (this.f1727u) {
            case 21:
                k(oVar);
                return oVar;
            case 25:
                return ((yb.g) this.f1728v).b(oVar, 0L, (HashMap) this.f1729w);
            case 26:
                l(oVar);
                return oVar;
            default:
                ?? r13 = (yb.m) this.f1728v;
                ?? r02 = (o8.o) this.f1729w;
                try {
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e10) {
                    e = e10;
                    r02 = 0;
                    numValueOf = null;
                } catch (Throwable th3) {
                    num = null;
                    th = th3;
                    r02 = 0;
                }
                if (!r02.j()) {
                    throw new IOException(r02.g());
                }
                r13.i(true);
                r02 = (HttpURLConnection) r02.h();
                try {
                    responseCode = r02.getResponseCode();
                    numValueOf = Integer.valueOf(responseCode);
                    if (responseCode == 200) {
                        try {
                            synchronized (r13) {
                                r13.f14626c = 8;
                            }
                            r13.f14636o.e(0, yb.j.f);
                            r13.k(r02).c();
                        } catch (IOException e11) {
                            e = e11;
                            Log.d("FirebaseRemoteConfig", "Exception connecting to real-time RC backend. Retrying the connection...", e);
                            yb.m.b(r02);
                            r13.i(false);
                            boolean z2 = numValueOf == null || yb.m.d(numValueOf.intValue());
                            if (z2) {
                                r13.f14635n.getClass();
                                r13.l(new Date(System.currentTimeMillis()));
                            }
                            if (!z2 && numValueOf.intValue() != 200) {
                                String strF = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", numValueOf);
                                if (numValueOf.intValue() == 403) {
                                    strF = yb.m.f(r02.getErrorStream());
                                }
                                new xb.f(numValueOf.intValue(), 0, strF);
                            }
                            r13.h();
                            return t1.k(null);
                        }
                    }
                    yb.m.b(r02);
                    r13.i(false);
                    zD = yb.m.d(responseCode);
                    if (zD) {
                        r13.f14635n.getClass();
                        r13.l(new Date(System.currentTimeMillis()));
                    }
                } catch (IOException e12) {
                    e = e12;
                    numValueOf = null;
                } catch (Throwable th4) {
                    num = null;
                    th = th4;
                    yb.m.b(r02);
                    r13.i(false);
                    boolean z10 = num == null || yb.m.d(num.intValue());
                    if (z10) {
                        r13.f14635n.getClass();
                        r13.l(new Date(System.currentTimeMillis()));
                    }
                    if (z10 || num.intValue() == 200) {
                        r13.h();
                    } else {
                        String strF2 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                        if (num.intValue() == 403) {
                            strF2 = yb.m.f(r02.getErrorStream());
                        }
                        new xb.f(num.intValue(), 0, strF2);
                        r13.g();
                    }
                    throw th;
                }
                if (!zD && responseCode != 200) {
                    String strF3 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", numValueOf);
                    if (responseCode == 403) {
                        strF3 = yb.m.f(r02.getErrorStream());
                    }
                    new xb.f(responseCode, 0, strF3);
                    r13.g();
                    return t1.k(null);
                }
                r13.h();
                return t1.k(null);
        }
    }

    @Override // nb.a
    public void c(nb.b bVar) {
        nb.a aVar = (nb.a) this.f1728v;
        nb.a aVar2 = (nb.a) this.f1729w;
        aVar.c(bVar);
        aVar2.c(bVar);
    }

    @Override // g4.l0
    public void d(s sVar) {
        switch (this.f1727u) {
            case 3:
                m0 m0Var = (m0) this.f1728v;
                Bundle bundle = (Bundle) this.f1729w;
                b0 b0Var = m0Var.f5115g;
                if (bundle == null) {
                    Bundle bundle2 = Bundle.EMPTY;
                }
                b0Var.n(sVar);
                break;
            default:
                m0 m0Var2 = (m0) this.f1728v;
                h4.n nVar = (h4.n) this.f1729w;
                m0Var2.getClass();
                String str = nVar.f5829u;
                if (TextUtils.isEmpty(str)) {
                    s1.b.p("MediaSessionLegacyStub", "onRemoveQueueItem(): Media ID shouldn't be null");
                } else {
                    j1 j1Var = m0Var2.f5115g.f4973t;
                    if (j1Var.e0(17)) {
                        f1 f1VarW0 = j1Var.w0();
                        p1.e1 e1Var = new p1.e1();
                        for (int i = 0; i < f1VarW0.o(); i++) {
                            if (TextUtils.equals(f1VarW0.m(i, e1Var, 0L).f9715c.f9756a, str)) {
                                j1Var.A0(i);
                            }
                        }
                    } else {
                        s1.b.p("MediaSessionLegacyStub", "Can't remove item by ID without COMMAND_GET_TIMELINE being available");
                    }
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    @Override // na.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(zc.c r5) {
        /*
            r4 = this;
            int r0 = r4.f1727u
            switch(r0) {
                case 2: goto L99;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r4.f1728v
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r4.f1729w
            g4.s0 r1 = (g4.s0) r1
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            java.lang.Object r5 = r5.b(r2)
            android.content.Context r5 = (android.content.Context) r5
            int r1 = r1.f5204u
            switch(r1) {
                case 22: goto L87;
                case 23: goto L72;
                case 24: goto L30;
                default: goto L1a;
            }
        L1a:
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            java.lang.String r5 = r5.getPackageName()
            java.lang.String r5 = r1.getInstallerPackageName(r5)
            if (r5 == 0) goto L2d
            java.lang.String r5 = com.google.firebase.FirebaseCommonRegistrar.a(r5)
            goto L93
        L2d:
            java.lang.String r5 = ""
            goto L93
        L30:
            int r1 = android.os.Build.VERSION.SDK_INT
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            java.lang.String r3 = "android.hardware.type.television"
            boolean r2 = r2.hasSystemFeature(r3)
            if (r2 == 0) goto L41
            java.lang.String r5 = "tv"
            goto L93
        L41:
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            java.lang.String r3 = "android.hardware.type.watch"
            boolean r2 = r2.hasSystemFeature(r3)
            if (r2 == 0) goto L50
            java.lang.String r5 = "watch"
            goto L93
        L50:
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            java.lang.String r3 = "android.hardware.type.automotive"
            boolean r2 = r2.hasSystemFeature(r3)
            if (r2 == 0) goto L5f
            java.lang.String r5 = "auto"
            goto L93
        L5f:
            r2 = 26
            if (r1 < r2) goto L2d
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            java.lang.String r1 = "android.hardware.type.embedded"
            boolean r5 = r5.hasSystemFeature(r1)
            if (r5 == 0) goto L2d
            java.lang.String r5 = "embedded"
            goto L93
        L72:
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()
            if (r5 == 0) goto L2d
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L2d
            int r5 = aa.c0.a(r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto L93
        L87:
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()
            if (r5 == 0) goto L2d
            int r5 = r5.targetSdkVersion
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L93:
            wb.a r1 = new wb.a
            r1.<init>(r0, r5)
            return r1
        L99:
            java.lang.Object r0 = r4.f1728v
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r4.f1729w
            na.b r1 = (na.b) r1
            android.os.Trace.beginSection(r0)     // Catch: java.lang.Throwable -> Lae
            na.e r0 = r1.f     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r5 = r0.e(r5)     // Catch: java.lang.Throwable -> Lae
            android.os.Trace.endSection()
            return r5
        Lae:
            r5 = move-exception
            android.os.Trace.endSection()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.b.e(zc.c):java.lang.Object");
    }

    @Override // pc.l
    public void f(String str, boolean z2) {
        g gVar;
        String str2;
        int i = this.f1727u;
        int i10 = 8;
        Object obj = this.f1729w;
        Object obj2 = this.f1728v;
        switch (i) {
            case 9:
                LandscapeActivity landscapeActivity = (LandscapeActivity) obj2;
                w0 w0Var = (w) obj;
                if (landscapeActivity.W != null && (gVar = landscapeActivity.Z) != null) {
                    LinearLayout linearLayout = (LinearLayout) gVar.f1738c;
                    if (z2) {
                        linearLayout.setVisibility(8);
                        break;
                    } else {
                        linearLayout.setVisibility(0);
                        if (w0Var != null && !landscapeActivity.W.f12483w) {
                            ((c3.e) w0Var).f();
                            break;
                        }
                    }
                }
                break;
            case 11:
                SplashActivity splashActivity = (SplashActivity) obj2;
                String str3 = (String) obj;
                int i11 = SplashActivity.f3647g0;
                if (z2) {
                    try {
                        JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
                        splashActivity.f3651d0 = uc.b.p(splashActivity, splashActivity.V, jSONObject);
                        splashActivity.V.getClass();
                        splashActivity.f3652e0 = jSONObject.optString("app_versions", "3");
                        splashActivity.B();
                    } catch (IndexOutOfBoundsException | JSONException unused) {
                        splashActivity.A(str3);
                        return;
                    }
                } else if (!"cHJvX2lzX3Bybw==".equals(str)) {
                    splashActivity.A(str3);
                } else {
                    splashActivity.Z = false;
                    ((LinearLayout) splashActivity.W.f).setVisibility(0);
                }
                break;
            case 18:
                String str4 = (String) obj2;
                pc.i iVar = (pc.i) obj;
                try {
                    JSONObject jSONObject2 = new JSONObject(com.bumptech.glide.d.h(str));
                    String string = jSONObject2.getString("link");
                    HashMap map = new HashMap();
                    if (string.contains("|")) {
                        String[] strArrSplit = string.split("\\|");
                        str2 = strArrSplit[0];
                        map = com.bumptech.glide.d.q(strArrSplit[1]);
                    } else {
                        str2 = string;
                    }
                    String string2 = jSONObject2.getString("type");
                    ue.m mVarR = com.bumptech.glide.d.r(map);
                    ga.b.D(null, str2, false, null, mVarR, new pc.c(str2, string2, str4, mVarR, iVar, 1));
                } catch (JSONException unused2) {
                    iVar.l("error", null);
                    return;
                }
                break;
            default:
                String str5 = (String) obj2;
                pc.l lVar = (pc.l) obj;
                if (!z2) {
                    lVar.f("https://error.m3u8", false);
                } else {
                    new Thread(new a2.g1(str, str5, lVar, i10)).start();
                }
                break;
        }
    }

    @Override // g4.e1
    public Object g(b0 b0Var, s sVar, int i) {
        switch (this.f1727u) {
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return b0Var.j() ? b8.h.r(new g4.q1(-100)) : s1.b0.a0((y) ((e1) this.f1728v).g(b0Var, sVar, i), new dd.e(b0Var, sVar, (s0) this.f1729w, 2));
            default:
                return b0Var.j() ? b8.h.r(new g4.q1(-100)) : s1.b0.a0((y) ((e1) this.f1728v).g(b0Var, sVar, i), new dd.e(b0Var, sVar, (d1) this.f1729w, 3));
        }
    }

    @Override // k7.b
    public Object h() {
        switch (this.f1727u) {
            case 12:
                b7.s sVar = (b7.s) this.f1728v;
                Iterable iterable = (Iterable) this.f1729w;
                j7.g gVar = (j7.g) ((j7.d) sVar.f1900c);
                gVar.getClass();
                if (iterable.iterator().hasNext()) {
                    gVar.a().compileStatement("DELETE FROM events WHERE _id in " + j7.g.H(iterable)).execute();
                    break;
                }
                break;
            default:
                b7.s sVar2 = (b7.s) this.f1728v;
                for (Map.Entry entry : ((HashMap) this.f1729w).entrySet()) {
                    ((j7.g) ((j7.c) sVar2.i)).F(((Integer) entry.getValue()).intValue(), f7.c.A, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0588 A[PHI: r11
      0x0588: PHI (r11v18 int) = (r11v16 int), (r11v17 int), (r11v17 int), (r11v17 int) binds: [B:329:0x0586, B:337:0x0597, B:338:0x0599, B:339:0x059b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [aa.l0] */
    /* JADX WARN: Type inference failed for: r2v47, types: [p1.n1] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r4v1, types: [b2.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v61 */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v63 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v67 */
    /* JADX WARN: Type inference failed for: r5v68 */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r5v70, types: [int] */
    /* JADX WARN: Type inference failed for: r5v77 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23, types: [int] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29, types: [int] */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v36, types: [int] */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v39, types: [int] */
    /* JADX WARN: Type inference failed for: r9v40 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r9v42, types: [int] */
    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r9v44 */
    /* JADX WARN: Type inference failed for: r9v45, types: [int] */
    /* JADX WARN: Type inference failed for: r9v46 */
    @Override // s1.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(java.lang.Object r24, p1.o r25) {
        /*
            Method dump skipped, instruction units count: 1604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.b.i(java.lang.Object, p1.o):void");
    }

    @Override // w2.r
    public w2.o[] j(Uri uri, Map map) {
        o2.q qVar = (o2.q) this.f1728v;
        q qVar2 = (q) this.f1729w;
        return new w2.o[]{qVar.f9194c.d(qVar2) ? new t3.h(qVar.f9194c.f(qVar2), null) : new e3.a(qVar2)};
    }

    @Override // o8.g
    public o8.o r(Object obj) {
        yb.c cVar = (yb.c) this.f1728v;
        yb.e eVar = (yb.e) this.f1729w;
        synchronized (cVar) {
            cVar.f14584c = t1.k(eVar);
        }
        return t1.k(eVar);
    }

    public /* synthetic */ b(Object obj, int i, Object obj2) {
        this.f1727u = i;
        this.f1728v = obj;
        this.f1729w = obj2;
    }
}
