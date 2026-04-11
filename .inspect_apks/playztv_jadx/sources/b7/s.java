package b7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import b7.s;
import c7.j;
import j7.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f1902e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f1903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f1904h;
    public Object i;

    public s(a7.b bVar, ed.a aVar, Handler handler) {
        be.h.e(handler, "uiHandler");
        this.f1898a = bVar;
        this.f1899b = handler;
        this.f1900c = new Object();
        this.f1901d = new LinkedHashMap();
        this.f1902e = new LinkedHashMap();
        this.f = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("FetchNotificationsIO");
        handlerThread.start();
        this.f1903g = new Handler(handlerThread.getLooper());
        this.f1904h = new LinkedHashMap();
        this.i = new dd.p(this);
    }

    public static void f(JSONObject jSONObject, String str) {
        StringBuilder sbB = v.e.b(str);
        sbB.append(jSONObject.toString());
        String string = sbB.toString();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", string, null);
        }
    }

    public void a(int i, dd.p pVar) {
        synchronized (this.f1900c) {
            try {
                Set linkedHashSet = (Set) ((LinkedHashMap) this.f1901d).get(Integer.valueOf(i));
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(new WeakReference(pVar));
                ((LinkedHashMap) this.f1901d).put(Integer.valueOf(i), linkedHashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f1900c) {
            ((LinkedHashMap) this.f1901d).clear();
            ((LinkedHashMap) this.f1902e).clear();
            ((ArrayList) this.f).clear();
            ((LinkedHashMap) this.f1904h).clear();
        }
    }

    public bb.c c(int i) {
        bb.c cVar = null;
        try {
            if (!v.e.a(2, i)) {
                JSONObject jSONObjectI = ((rc.b) this.f1902e).I();
                if (jSONObjectI != null) {
                    bb.c cVarQ = ((u5.d) this.f1900c).Q(jSONObjectI);
                    f(jSONObjectI, "Loaded cached settings: ");
                    ((k8.c0) this.f1901d).getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (v.e.a(3, i) || cVarQ.f1982c >= jCurrentTimeMillis) {
                        try {
                            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                                Log.v("FirebaseCrashlytics", "Returning cached settings.", null);
                            }
                            return cVarQ;
                        } catch (Exception e10) {
                            e = e10;
                            cVar = cVarQ;
                            Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            return cVar;
                        }
                    }
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Cached settings have expired.", null);
                        return null;
                    }
                } else if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "No cached settings data found.", null);
                }
            }
            return null;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public bb.c d() {
        return (bb.c) ((AtomicReference) this.f1904h).get();
    }

    public void e(c7.j jVar, int i) {
        byte[] bArr;
        long j5;
        d7.a aVar;
        String str;
        d7.a aVar2;
        int i10;
        a7.c cVarK;
        String str2;
        Integer numValueOf;
        s sVar;
        byte[] bArr2;
        final s sVar2 = this;
        final c7.j jVar2 = jVar;
        byte[] bArr3 = jVar2.f2561b;
        k7.c cVar = (k7.c) sVar2.f;
        d7.e eVarA = ((d7.d) sVar2.f1899b).a(jVar2.f2560a);
        long jMax = 0;
        while (true) {
            final int i11 = 0;
            j7.g gVar = (j7.g) cVar;
            if (!((Boolean) gVar.G(new k7.b(sVar2) { // from class: i7.d

                /* JADX INFO: renamed from: v, reason: collision with root package name */
                public final /* synthetic */ s f6454v;

                {
                    this.f6454v = sVar2;
                }

                @Override // k7.b
                public final Object h() {
                    Boolean bool;
                    switch (i11) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            j jVar3 = jVar2;
                            g gVar2 = (g) ((j7.d) this.f6454v.f1900c);
                            SQLiteDatabase sQLiteDatabaseA = gVar2.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                Long lD = g.d(sQLiteDatabaseA, jVar3);
                                if (lD == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = gVar2.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lD.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                sQLiteDatabaseA.setTransactionSuccessful();
                                return bool;
                            } finally {
                                sQLiteDatabaseA.endTransaction();
                            }
                        default:
                            g gVar3 = (g) ((j7.d) this.f6454v.f1900c);
                            gVar3.getClass();
                            return (Iterable) gVar3.v(new b2.b(gVar3, 14, jVar2));
                    }
                }
            })).booleanValue()) {
                gVar.G(new i7.f(sVar2, jVar2, jMax));
                return;
            }
            final int i12 = 1;
            Iterable iterable = (Iterable) gVar.G(new k7.b(sVar2) { // from class: i7.d

                /* JADX INFO: renamed from: v, reason: collision with root package name */
                public final /* synthetic */ s f6454v;

                {
                    this.f6454v = sVar2;
                }

                @Override // k7.b
                public final Object h() {
                    Boolean bool;
                    switch (i12) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            j jVar3 = jVar2;
                            g gVar2 = (g) ((j7.d) this.f6454v.f1900c);
                            SQLiteDatabase sQLiteDatabaseA = gVar2.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                Long lD = g.d(sQLiteDatabaseA, jVar3);
                                if (lD == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = gVar2.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lD.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                sQLiteDatabaseA.setTransactionSuccessful();
                                return bool;
                            } finally {
                                sQLiteDatabaseA.endTransaction();
                            }
                        default:
                            g gVar3 = (g) ((j7.d) this.f6454v.f1900c);
                            gVar3.getClass();
                            return (Iterable) gVar3.v(new b2.b(gVar3, 14, jVar2));
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return;
            }
            if (eVarA == null) {
                cf.l.l("Uploader", "Unknown backend for %s, deleting event batch for it...", jVar2);
                aVar2 = new d7.a(3, -1L);
                bArr = bArr3;
                j5 = jMax;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((j7.b) it.next()).f6816c);
                }
                if (bArr3 != null) {
                    j7.c cVar2 = (j7.c) sVar2.i;
                    Objects.requireNonNull(cVar2);
                    f7.a aVar3 = (f7.a) gVar.G(new a2.f0(22, cVar2));
                    c7.h hVar = new c7.h();
                    hVar.f2550h = new HashMap();
                    hVar.f = Long.valueOf(((l7.a) sVar2.f1903g).g());
                    hVar.f2549g = Long.valueOf(((l7.a) sVar2.f1904h).g());
                    hVar.f2544a = "GDT_CLIENT_METRICS";
                    z6.c cVar3 = new z6.c("proto");
                    aVar3.getClass();
                    a7.b bVar = c7.p.f2573a;
                    bVar.getClass();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bVar.r(aVar3, byteArrayOutputStream);
                    } catch (IOException unused) {
                    }
                    hVar.f2548e = new c7.n(cVar3, byteArrayOutputStream.toByteArray());
                    arrayList.add(((a7.d) eVarA).a(hVar.c()));
                }
                a7.d dVar = (a7.d) eVarA;
                HashMap map = new HashMap();
                int size = arrayList.size();
                int i13 = 0;
                while (i13 < size) {
                    Object obj = arrayList.get(i13);
                    i13++;
                    c7.i iVar = (c7.i) obj;
                    String str3 = iVar.f2552a;
                    if (map.containsKey(str3)) {
                        bArr2 = bArr3;
                        ((List) map.get(str3)).add(iVar);
                    } else {
                        bArr2 = bArr3;
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(iVar);
                        map.put(str3, arrayList2);
                    }
                    bArr3 = bArr2;
                }
                bArr = bArr3;
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    c7.i iVar2 = (c7.i) ((List) entry.getValue()).get(0);
                    k0 k0Var = k0.f1879u;
                    long jG = dVar.f.g();
                    long jG2 = dVar.f628e.g();
                    n nVar = new n(new l(Integer.valueOf(iVar2.b("sdk-version")), iVar2.a("model"), iVar2.a("hardware"), iVar2.a("device"), iVar2.a("product"), iVar2.a("os-uild"), iVar2.a("manufacturer"), iVar2.a("fingerprint"), iVar2.a("locale"), iVar2.a("country"), iVar2.a("mcc_mnc"), iVar2.a("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused2) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (c7.i iVar3 : (List) entry.getValue()) {
                        Iterator it3 = it2;
                        c7.n nVar2 = iVar3.f2554c;
                        byte[] bArr4 = iVar3.f2559j;
                        z6.c cVar4 = nVar2.f2570a;
                        byte[] bArr5 = nVar2.f2571b;
                        long j8 = jMax;
                        if (cVar4.equals(new z6.c("proto"))) {
                            sVar = new s();
                            sVar.f = bArr5;
                        } else if (cVar4.equals(new z6.c("json"))) {
                            String str4 = new String(bArr5, Charset.forName("UTF-8"));
                            s sVar3 = new s();
                            sVar3.f1903g = str4;
                            sVar = sVar3;
                        } else {
                            String strT = cf.l.t("CctTransportBackend");
                            if (Log.isLoggable(strT, 5)) {
                                Log.w(strT, "Received event of unsupported encoding " + cVar4 + ". Skipping...");
                            }
                            it2 = it3;
                            jMax = j8;
                        }
                        sVar.f1898a = Long.valueOf(iVar3.f2555d);
                        sVar.f1899b = Long.valueOf(iVar3.f2556e);
                        String str5 = (String) iVar3.f.get("tz-offset");
                        sVar.f1900c = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        sVar.f1904h = new w((i0) i0.f1867u.get(iVar3.b("net-type")), (h0) h0.f1857u.get(iVar3.b("mobile-subtype")));
                        Integer num = iVar3.f2553b;
                        if (num != null) {
                            sVar.f1901d = num;
                        }
                        Integer num2 = iVar3.f2557g;
                        if (num2 != null) {
                            r rVar = new r(new q(num2));
                            a0 a0Var = a0.f1829u;
                            sVar.f1902e = new o(rVar);
                        }
                        byte[] bArr6 = iVar3.i;
                        if (bArr6 != null || bArr4 != null) {
                            if (bArr6 == null) {
                                bArr6 = null;
                            }
                            sVar.i = new p(bArr6, bArr4 != null ? bArr4 : null);
                        }
                        String strM = ((Long) sVar.f1898a) == null ? " eventTimeMs" : "";
                        if (((Long) sVar.f1899b) == null) {
                            strM = strM.concat(" eventUptimeMs");
                        }
                        if (((Long) sVar.f1900c) == null) {
                            strM = e6.j.m(strM, " timezoneOffsetSeconds");
                        }
                        if (!strM.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(strM));
                        }
                        arrayList4.add(new t(((Long) sVar.f1898a).longValue(), (Integer) sVar.f1901d, (o) sVar.f1902e, ((Long) sVar.f1899b).longValue(), (byte[]) sVar.f, (String) sVar.f1903g, ((Long) sVar.f1900c).longValue(), (w) sVar.f1904h, (p) sVar.i));
                        it2 = it3;
                        jMax = j8;
                    }
                    arrayList3.add(new u(jG, jG2, nVar, numValueOf, str2, arrayList4));
                    it2 = it2;
                }
                j5 = jMax;
                m mVar = new m(arrayList3);
                URL urlB = dVar.f627d;
                if (bArr != null) {
                    try {
                        a7.a aVarA = a7.a.a(bArr);
                        str = aVarA.f615b;
                        if (str == null) {
                            str = null;
                        }
                        String str6 = aVarA.f614a;
                        if (str6 != null) {
                            urlB = a7.d.b(str6);
                        }
                    } catch (IllegalArgumentException unused3) {
                        aVar = new d7.a(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    a7.b bVar2 = new a7.b(urlB, mVar, str, 0);
                    a2.f0 f0Var = new a2.f0(6, dVar);
                    int i14 = 5;
                    do {
                        cVarK = f0Var.k(bVar2);
                        URL url = (URL) cVarK.f623c;
                        if (url != null) {
                            cf.l.l("CctTransportBackend", "Following redirect to: %s", url);
                            bVar2 = new a7.b(url, (m) bVar2.f619w, (String) bVar2.f620x, 0);
                        } else {
                            bVar2 = null;
                        }
                        if (bVar2 == null) {
                            break;
                        } else {
                            i14--;
                        }
                    } while (i14 >= 1);
                    int i15 = cVarK.f621a;
                    if (i15 == 200) {
                        aVar2 = new d7.a(1, cVarK.f622b);
                    } else {
                        if (i15 >= 500 || i15 == 404) {
                            aVar = new d7.a(2, -1L);
                        } else if (i15 == 400) {
                            try {
                                aVar = new d7.a(4, -1L);
                            } catch (IOException e10) {
                                e = e10;
                                cf.l.o("CctTransportBackend", "Could not make request to the backend", e);
                                i10 = 2;
                                aVar2 = new d7.a(2, -1L);
                            }
                        } else {
                            aVar = new d7.a(3, -1L);
                        }
                        aVar2 = aVar;
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            }
            i10 = 2;
            int i16 = aVar2.f4089a;
            if (i16 == i10) {
                gVar.G(new i7.e(this, iterable, jVar, j5));
                ((a7.b) this.f1901d).C(jVar, i + 1, true);
                return;
            }
            sVar2 = this;
            jVar2 = jVar;
            jMax = j5;
            gVar.G(new b2.b(sVar2, 12, iterable));
            if (i16 == 1) {
                jMax = Math.max(jMax, aVar2.f4090b);
                if (bArr != null) {
                    gVar.G(new a2.f0(24, sVar2));
                }
            } else if (i16 == 4) {
                HashMap map2 = new HashMap();
                Iterator it4 = iterable.iterator();
                while (it4.hasNext()) {
                    String str7 = ((j7.b) it4.next()).f6816c.f2552a;
                    if (map2.containsKey(str7)) {
                        map2.put(str7, Integer.valueOf(((Integer) map2.get(str7)).intValue() + 1));
                    } else {
                        map2.put(str7, 1);
                    }
                }
                gVar.G(new b2.b(sVar2, 13, map2));
            }
            bArr3 = bArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        r3.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r3, dd.p r4) {
        /*
            r2 = this;
            java.lang.String r0 = "fetchListener"
            be.h.e(r4, r0)
            java.lang.Object r0 = r2.f1900c
            monitor-enter(r0)
            java.lang.Object r1 = r2.f1901d     // Catch: java.lang.Throwable -> L1d
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L1d
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Throwable -> L1d
            java.util.Set r3 = (java.util.Set) r3     // Catch: java.lang.Throwable -> L1d
            if (r3 == 0) goto L1f
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L1d
            goto L20
        L1d:
            r3 = move-exception
            goto L3d
        L1f:
            r3 = 0
        L20:
            if (r3 == 0) goto L3b
        L22:
            boolean r1 = r3.hasNext()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L3b
            java.lang.Object r1 = r3.next()     // Catch: java.lang.Throwable -> L1d
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch: java.lang.Throwable -> L1d
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L1d
            boolean r1 = be.h.a(r1, r4)     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L22
            r3.remove()     // Catch: java.lang.Throwable -> L1d
        L3b:
            monitor-exit(r0)
            return
        L3d:
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.s.g(int, dd.p):void");
    }
}
