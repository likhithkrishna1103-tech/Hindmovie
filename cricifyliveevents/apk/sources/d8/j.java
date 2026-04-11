package d8;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.emoji2.text.v;
import androidx.fragment.app.f1;
import androidx.media3.decoder.DecoderInputBuffer;
import f9.a0;
import hd.l;
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
import w7.g0;
import w7.h0;
import w7.j0;
import w7.m;
import w7.o;
import w7.p;
import w7.q;
import w7.r;
import w7.s;
import w7.t;
import w7.z;
import x7.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f3555e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f3556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f3557h;
    public Object i;

    public j(v vVar, id.a aVar, Handler handler) {
        ge.i.e(handler, "uiHandler");
        this.f3551a = vVar;
        this.f3552b = handler;
        this.f3553c = new Object();
        this.f3554d = new LinkedHashMap();
        this.f3555e = new LinkedHashMap();
        this.f = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("FetchNotificationsIO");
        handlerThread.start();
        this.f3556g = new Handler(handlerThread.getLooper());
        this.f3557h = new LinkedHashMap();
        this.i = new l(this);
    }

    public static void f(JSONObject jSONObject, String str) {
        StringBuilder sbB = y.e.b(str);
        sbB.append(jSONObject.toString());
        String string = sbB.toString();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", string, null);
        }
    }

    public void a(int i, z5.b bVar) {
        synchronized (this.f3553c) {
            try {
                Set linkedHashSet = (Set) ((LinkedHashMap) this.f3554d).get(Integer.valueOf(i));
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(new WeakReference(bVar));
                ((LinkedHashMap) this.f3554d).put(Integer.valueOf(i), linkedHashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f3553c) {
            ((LinkedHashMap) this.f3554d).clear();
            ((LinkedHashMap) this.f3555e).clear();
            ((ArrayList) this.f).clear();
            ((LinkedHashMap) this.f3557h).clear();
        }
    }

    public vb.a c(int i) {
        vb.a aVar = null;
        try {
            if (!y.e.a(2, i)) {
                JSONObject jSONObjectD = ((l4.a) this.f3555e).D();
                if (jSONObjectD != null) {
                    vb.a aVarJ = ((kf.i) this.f3553c).J(jSONObjectD);
                    f(jSONObjectD, "Loaded cached settings: ");
                    ((a0) this.f3554d).getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (y.e.a(3, i) || aVarJ.f13547c >= jCurrentTimeMillis) {
                        try {
                            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                                Log.v("FirebaseCrashlytics", "Returning cached settings.", null);
                            }
                            return aVarJ;
                        } catch (Exception e9) {
                            e = e9;
                            aVar = aVarJ;
                            Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            return aVar;
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
        } catch (Exception e10) {
            e = e10;
        }
    }

    public vb.a d() {
        return (vb.a) ((AtomicReference) this.f3557h).get();
    }

    public void e(x7.i iVar, int i) {
        byte[] bArr;
        long j4;
        y7.a aVar;
        String str;
        y7.a aVar2;
        int i10;
        o2.f fVarG;
        String str2;
        Integer numValueOf;
        j jVar;
        byte[] bArr2;
        final j jVar2 = this;
        final x7.i iVar2 = iVar;
        byte[] bArr3 = iVar2.f14435b;
        f8.c cVar = (f8.c) jVar2.f;
        y7.e eVarA = ((y7.d) jVar2.f3552b).a(iVar2.f14434a);
        long jMax = 0;
        while (true) {
            final int i11 = 0;
            e8.i iVar3 = (e8.i) cVar;
            if (!((Boolean) iVar3.A(new f8.b(jVar2) { // from class: d8.g

                /* JADX INFO: renamed from: w, reason: collision with root package name */
                public final /* synthetic */ j f3541w;

                {
                    this.f3541w = jVar2;
                }

                @Override // f8.b
                public final Object g() {
                    Boolean bool;
                    switch (i11) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            x7.i iVar4 = iVar2;
                            e8.i iVar5 = (e8.i) ((e8.d) this.f3541w.f3553c);
                            SQLiteDatabase sQLiteDatabaseA = iVar5.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                Long lG = e8.i.g(sQLiteDatabaseA, iVar4);
                                if (lG == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = iVar5.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lG.toString()});
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
                            e8.i iVar6 = (e8.i) ((e8.d) this.f3541w.f3553c);
                            iVar6.getClass();
                            return (Iterable) iVar6.q(new androidx.fragment.app.e(4, iVar6, iVar2));
                    }
                }
            })).booleanValue()) {
                iVar3.A(new i(jVar2, iVar2, jMax));
                return;
            }
            final int i12 = 1;
            Iterable iterable = (Iterable) iVar3.A(new f8.b(jVar2) { // from class: d8.g

                /* JADX INFO: renamed from: w, reason: collision with root package name */
                public final /* synthetic */ j f3541w;

                {
                    this.f3541w = jVar2;
                }

                @Override // f8.b
                public final Object g() {
                    Boolean bool;
                    switch (i12) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            x7.i iVar4 = iVar2;
                            e8.i iVar5 = (e8.i) ((e8.d) this.f3541w.f3553c);
                            SQLiteDatabase sQLiteDatabaseA = iVar5.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                Long lG = e8.i.g(sQLiteDatabaseA, iVar4);
                                if (lG == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = iVar5.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lG.toString()});
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
                            e8.i iVar6 = (e8.i) ((e8.d) this.f3541w.f3553c);
                            iVar6.getClass();
                            return (Iterable) iVar6.q(new androidx.fragment.app.e(4, iVar6, iVar2));
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return;
            }
            int i13 = 3;
            if (eVarA == null) {
                vf.g.t("Uploader", "Unknown backend for %s, deleting event batch for it...", iVar2);
                aVar2 = new y7.a(3, -1L);
                bArr = bArr3;
                j4 = jMax;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((e8.b) it.next()).f3834c);
                }
                if (bArr3 != null) {
                    e8.c cVar2 = (e8.c) jVar2.i;
                    Objects.requireNonNull(cVar2);
                    a8.a aVar3 = (a8.a) iVar3.A(new f1(i13, cVar2));
                    u5.a aVar4 = new u5.a();
                    aVar4.f = new HashMap();
                    aVar4.f12216e = Long.valueOf(((g8.a) jVar2.f3556g).l());
                    aVar4.f12212a = Long.valueOf(((g8.a) jVar2.f3557h).l());
                    aVar4.f12213b = "GDT_CLIENT_METRICS";
                    u7.c cVar3 = new u7.c("proto");
                    aVar3.getClass();
                    v vVar = n.f14445a;
                    vVar.getClass();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        vVar.q(aVar3, byteArrayOutputStream);
                    } catch (IOException unused) {
                    }
                    aVar4.f12215d = new x7.l(cVar3, byteArrayOutputStream.toByteArray());
                    arrayList.add(((v7.b) eVarA).a(aVar4.b()));
                }
                v7.b bVar = (v7.b) eVarA;
                HashMap map = new HashMap();
                int size = arrayList.size();
                int i14 = 0;
                while (i14 < size) {
                    Object obj = arrayList.get(i14);
                    i14++;
                    x7.h hVar = (x7.h) obj;
                    String str3 = hVar.f14426a;
                    if (map.containsKey(str3)) {
                        bArr2 = bArr3;
                        ((List) map.get(str3)).add(hVar);
                    } else {
                        bArr2 = bArr3;
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(hVar);
                        map.put(str3, arrayList2);
                    }
                    bArr3 = bArr2;
                }
                bArr = bArr3;
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    x7.h hVar2 = (x7.h) ((List) entry.getValue()).get(0);
                    j0 j0Var = j0.f14071v;
                    long jL = bVar.f.l();
                    long jL2 = bVar.f13505e.l();
                    w7.n nVar = new w7.n(new w7.l(Integer.valueOf(hVar2.b("sdk-version")), hVar2.a("model"), hVar2.a("hardware"), hVar2.a("device"), hVar2.a("product"), hVar2.a("os-uild"), hVar2.a("manufacturer"), hVar2.a("fingerprint"), hVar2.a("locale"), hVar2.a("country"), hVar2.a("mcc_mnc"), hVar2.a("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused2) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (x7.h hVar3 : (List) entry.getValue()) {
                        Iterator it3 = it2;
                        x7.l lVar = hVar3.f14428c;
                        byte[] bArr4 = hVar3.f14433j;
                        u7.c cVar4 = lVar.f14442a;
                        byte[] bArr5 = lVar.f14443b;
                        long j7 = jMax;
                        if (cVar4.equals(new u7.c("proto"))) {
                            jVar = new j();
                            jVar.f3555e = bArr5;
                        } else if (cVar4.equals(new u7.c("json"))) {
                            String str4 = new String(bArr5, Charset.forName("UTF-8"));
                            j jVar3 = new j();
                            jVar3.f = str4;
                            jVar = jVar3;
                        } else {
                            String strG = vf.g.G("CctTransportBackend");
                            if (Log.isLoggable(strG, 5)) {
                                Log.w(strG, "Received event of unsupported encoding " + cVar4 + ". Skipping...");
                            }
                            it2 = it3;
                            jMax = j7;
                        }
                        jVar.f3551a = Long.valueOf(hVar3.f14429d);
                        jVar.f3554d = Long.valueOf(hVar3.f14430e);
                        String str5 = (String) hVar3.f.get("tz-offset");
                        jVar.f3556g = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        jVar.f3557h = new w7.v((h0) h0.f14054v.get(hVar3.b("net-type")), (g0) g0.f14050v.get(hVar3.b("mobile-subtype")));
                        Integer num = hVar3.f14427b;
                        if (num != null) {
                            jVar.f3552b = num;
                        }
                        Integer num2 = hVar3.f14431g;
                        if (num2 != null) {
                            r rVar = new r(new q(num2));
                            z zVar = z.f14110v;
                            jVar.f3553c = new o(rVar);
                        }
                        byte[] bArr6 = hVar3.i;
                        if (bArr6 != null || bArr4 != null) {
                            if (bArr6 == null) {
                                bArr6 = null;
                            }
                            jVar.i = new p(bArr6, bArr4 != null ? bArr4 : null);
                        }
                        String strJ = ((Long) jVar.f3551a) == null ? " eventTimeMs" : "";
                        if (((Long) jVar.f3554d) == null) {
                            strJ = strJ.concat(" eventUptimeMs");
                        }
                        if (((Long) jVar.f3556g) == null) {
                            strJ = l0.e.j(strJ, " timezoneOffsetSeconds");
                        }
                        if (!strJ.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(strJ));
                        }
                        arrayList4.add(new s(((Long) jVar.f3551a).longValue(), (Integer) jVar.f3552b, (o) jVar.f3553c, ((Long) jVar.f3554d).longValue(), (byte[]) jVar.f3555e, (String) jVar.f, ((Long) jVar.f3556g).longValue(), (w7.v) jVar.f3557h, (p) jVar.i));
                        it2 = it3;
                        jMax = j7;
                    }
                    arrayList3.add(new t(jL, jL2, nVar, numValueOf, str2, arrayList4));
                    it2 = it2;
                }
                j4 = jMax;
                m mVar = new m(arrayList3);
                URL urlB = bVar.f13504d;
                if (bArr != null) {
                    try {
                        v7.a aVarA = v7.a.a(bArr);
                        str = aVarA.f13500b;
                        if (str == null) {
                            str = null;
                        }
                        String str6 = aVarA.f13499a;
                        if (str6 != null) {
                            urlB = v7.b.b(str6);
                        }
                    } catch (IllegalArgumentException unused3) {
                        aVar = new y7.a(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    int i15 = 21;
                    l7.a aVar5 = new l7.a(urlB, mVar, str, i15);
                    kb.d dVar = new kb.d(17, bVar);
                    int i16 = 5;
                    do {
                        fVarG = dVar.g(aVar5);
                        URL url = (URL) fVarG.f9433c;
                        if (url != null) {
                            vf.g.t("CctTransportBackend", "Following redirect to: %s", url);
                            aVar5 = new l7.a(url, (m) aVar5.f7867x, (String) aVar5.f7868y, i15);
                        } else {
                            aVar5 = null;
                        }
                        if (aVar5 == null) {
                            break;
                        } else {
                            i16--;
                        }
                    } while (i16 >= 1);
                    int i17 = fVarG.f9431a;
                    if (i17 == 200) {
                        aVar2 = new y7.a(1, fVarG.f9432b);
                    } else {
                        if (i17 >= 500 || i17 == 404) {
                            aVar = new y7.a(2, -1L);
                        } else if (i17 == 400) {
                            try {
                                aVar = new y7.a(4, -1L);
                            } catch (IOException e9) {
                                e = e9;
                                vf.g.x("CctTransportBackend", "Could not make request to the backend", e);
                                i10 = 2;
                                aVar2 = new y7.a(2, -1L);
                            }
                        } else {
                            aVar = new y7.a(3, -1L);
                        }
                        aVar2 = aVar;
                    }
                } catch (IOException e10) {
                    e = e10;
                }
            }
            i10 = 2;
            int i18 = aVar2.f14964a;
            if (i18 == i10) {
                iVar3.A(new h(this, iterable, iVar, j4));
                ((v) this.f3554d).C(iVar, i + 1, true);
                return;
            }
            jVar2 = this;
            iVar2 = iVar;
            jMax = j4;
            iVar3.A(new androidx.fragment.app.e(1, jVar2, iterable));
            if (i18 == 1) {
                jMax = Math.max(jMax, aVar2.f14965b);
                if (bArr != null) {
                    iVar3.A(new f1(5, jVar2));
                }
            } else if (i18 == 4) {
                HashMap map2 = new HashMap();
                Iterator it4 = iterable.iterator();
                while (it4.hasNext()) {
                    String str7 = ((e8.b) it4.next()).f3834c.f14426a;
                    if (map2.containsKey(str7)) {
                        map2.put(str7, Integer.valueOf(((Integer) map2.get(str7)).intValue() + 1));
                    } else {
                        map2.put(str7, 1);
                    }
                }
                iVar3.A(new androidx.fragment.app.e(2, jVar2, map2));
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
    public void g(int r3, cd.e r4) {
        /*
            r2 = this;
            java.lang.String r0 = "fetchListener"
            ge.i.e(r4, r0)
            java.lang.Object r0 = r2.f3553c
            monitor-enter(r0)
            java.lang.Object r1 = r2.f3554d     // Catch: java.lang.Throwable -> L1d
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
            boolean r1 = ge.i.a(r1, r4)     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L22
            r3.remove()     // Catch: java.lang.Throwable -> L1d
        L3b:
            monitor-exit(r0)
            return
        L3d:
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.j.g(int, cd.e):void");
    }
}
