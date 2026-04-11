package ic;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import f9.c0;
import hb.n;
import i2.k;
import j9.p;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import o8.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f6419m = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ab.g f6420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.c f6421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f6422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f6423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f6424e;
    public final h f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f6425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExecutorService f6426h;
    public final ib.j i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashSet f6428k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f6429l;

    static {
        new AtomicInteger(1);
    }

    public c(ab.g gVar, hc.b bVar, ExecutorService executorService, ib.j jVar) {
        gVar.a();
        kc.c cVar = new kc.c(gVar.f390a, bVar);
        k kVar = new k(gVar);
        if (c0.H == null) {
            c0.H = new c0(16);
        }
        c0 c0Var = c0.H;
        if (j.f6437d == null) {
            j.f6437d = new j(c0Var);
        }
        j jVar2 = j.f6437d;
        n nVar = new n(new hb.d(2, gVar));
        h hVar = new h();
        this.f6425g = new Object();
        this.f6428k = new HashSet();
        this.f6429l = new ArrayList();
        this.f6420a = gVar;
        this.f6421b = cVar;
        this.f6422c = kVar;
        this.f6423d = jVar2;
        this.f6424e = nVar;
        this.f = hVar;
        this.f6426h = executorService;
        this.i = jVar;
    }

    public final void a(i iVar) {
        synchronized (this.f6425g) {
            this.f6429l.add(iVar);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void b() {
        jc.b bVarU;
        synchronized (f6419m) {
            try {
                ab.g gVar = this.f6420a;
                gVar.a();
                k kVarA = k.a(gVar.f390a);
                try {
                    bVarU = this.f6422c.u();
                    int i = bVarU.f6737b;
                    boolean z10 = true;
                    if (i != 2 && i != 1) {
                        z10 = false;
                    }
                    if (z10) {
                        String strH = h(bVarU);
                        k kVar = this.f6422c;
                        jc.a aVarA = bVarU.a();
                        aVarA.f6728a = strH;
                        aVarA.f6729b = 3;
                        bVarU = aVarA.a();
                        kVar.n(bVarU);
                    }
                    if (kVarA != null) {
                        kVarA.v();
                    }
                } catch (Throwable th) {
                    if (kVarA != null) {
                        kVarA.v();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        k(bVarU);
        this.i.execute(new b(this, 2));
    }

    public final jc.b c(jc.b bVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        int responseCode;
        String str;
        kc.b bVarF;
        ab.g gVar = this.f6420a;
        gVar.a();
        String str2 = gVar.f392c.f403a;
        String str3 = bVar.f6736a;
        gVar.a();
        String str4 = gVar.f392c.f408g;
        String str5 = bVar.f6739d;
        kc.c cVar = this.f6421b;
        kc.d dVar = cVar.f7412c;
        if (!dVar.b()) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = kc.c.a("projects/" + str4 + "/installations/" + str3 + "/authTokens:generate");
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionC = cVar.c(urlA, str2);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str5);
                    httpURLConnectionC.setDoOutput(true);
                    kc.c.h(httpURLConnectionC);
                    responseCode = httpURLConnectionC.getResponseCode();
                    dVar.d(responseCode);
                } catch (IOException | AssertionError unused) {
                    httpURLConnection = httpURLConnectionC;
                }
                if (responseCode >= 200 && responseCode < 300) {
                    bVarF = kc.c.f(httpURLConnectionC);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    str = null;
                } else {
                    kc.c.b(httpURLConnectionC, null, str2, str4);
                    httpURLConnection = httpURLConnectionC;
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            throw th;
                        }
                    } catch (IOException | AssertionError unused2) {
                    }
                    if (responseCode == 401 || responseCode == 404) {
                        if (((byte) (0 | 1)) != 1) {
                            throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                        }
                        str = null;
                        kc.b bVar2 = new kc.b(3, 0L, null);
                        httpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        bVarF = bVar2;
                    } else {
                        if (responseCode == 429) {
                            throw new e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                        }
                        if (responseCode < 500 || responseCode >= 600) {
                            Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                            if (((byte) (0 | 1)) != 1) {
                                throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                            }
                            kc.b bVar3 = new kc.b(2, 0L, null);
                            httpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            bVarF = bVar3;
                            str = null;
                        }
                        httpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                }
                int iC = y.e.c(bVarF.f7407c);
                if (iC != 0) {
                    if (iC == 1) {
                        jc.a aVarA = bVar.a();
                        aVarA.f6733g = "BAD CONFIG";
                        aVarA.f6729b = 5;
                        return aVarA.a();
                    }
                    if (iC != 2) {
                        throw new e("Firebase Installations Service is unavailable. Please try again later.");
                    }
                    l(str);
                    jc.a aVarA2 = bVar.a();
                    aVarA2.f6729b = 2;
                    return aVarA2.a();
                }
                String str6 = bVarF.f7405a;
                long j4 = bVarF.f7406b;
                j jVar = this.f6423d;
                jVar.getClass();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jVar.f6438a.getClass();
                long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                jc.a aVarA3 = bVar.a();
                aVarA3.f6730c = str6;
                aVarA3.f6732e = j4;
                byte b8 = (byte) (aVarA3.f6734h | 1);
                aVarA3.f = seconds;
                aVarA3.f6734h = (byte) (b8 | 2);
                return aVarA3.a();
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnectionC;
            }
        }
        throw new e("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final p d() {
        String str;
        g();
        synchronized (this) {
            str = this.f6427j;
        }
        if (str != null) {
            return vf.g.A(str);
        }
        j9.i iVar = new j9.i();
        a(new g(iVar));
        p pVar = iVar.f6688a;
        this.f6426h.execute(new b(this, 0));
        return pVar;
    }

    public final p e() {
        g();
        j9.i iVar = new j9.i();
        a(new f(this.f6423d, iVar));
        this.f6426h.execute(new b(this, 1));
        return iVar.f6688a;
    }

    /* JADX WARN: Finally extract failed */
    public final void f(jc.b bVar) {
        synchronized (f6419m) {
            try {
                ab.g gVar = this.f6420a;
                gVar.a();
                k kVarA = k.a(gVar.f390a);
                try {
                    this.f6422c.n(bVar);
                    if (kVarA != null) {
                        kVarA.v();
                    }
                } catch (Throwable th) {
                    if (kVarA != null) {
                        kVarA.v();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g() {
        ab.g gVar = this.f6420a;
        gVar.a();
        u.e(gVar.f392c.f404b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        u.e(gVar.f392c.f408g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        u.e(gVar.f392c.f403a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        String str = gVar.f392c.f404b;
        Pattern pattern = j.f6436c;
        u.a("Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.", str.contains(":"));
        gVar.a();
        u.a("Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.", j.f6436c.matcher(gVar.f392c.f403a).matches());
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h(jc.b r3) {
        /*
            r2 = this;
            ab.g r0 = r2.f6420a
            r0.a()
            java.lang.String r0 = r0.f391b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            ab.g r0 = r2.f6420a
            java.lang.String r1 = "[DEFAULT]"
            r0.a()
            java.lang.String r0 = r0.f391b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L50
        L1e:
            int r3 = r3.f6737b
            r0 = 1
            if (r3 != r0) goto L50
            hb.n r3 = r2.f6424e
            java.lang.Object r3 = r3.get()
            jc.c r3 = (jc.c) r3
            android.content.SharedPreferences r0 = r3.f6743a
            monitor-enter(r0)
            java.lang.String r1 = r3.a()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L38
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            goto L3d
        L36:
            r3 = move-exception
            goto L4e
        L38:
            java.lang.String r1 = r3.b()     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L4d
            ic.h r3 = r2.f
            r3.getClass()
            java.lang.String r3 = ic.h.a()
            return r3
        L4d:
            return r1
        L4e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r3
        L50:
            ic.h r3 = r2.f
            r3.getClass()
            java.lang.String r3 = ic.h.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ic.c.h(jc.b):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [kc.c] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [kc.a] */
    public final jc.b i(jc.b bVar) throws e {
        int responseCode;
        String str = bVar.f6736a;
        String string = null;
        if (str != null && str.length() == 11) {
            jc.c cVar = (jc.c) this.f6424e.get();
            synchronized (cVar.f6743a) {
                try {
                    String[] strArr = jc.c.f6742c;
                    int i = 0;
                    while (true) {
                        if (i < 4) {
                            String str2 = strArr[i];
                            String string2 = cVar.f6743a.getString("|T|" + cVar.f6744b + "|" + str2, null);
                            if (string2 == null || string2.isEmpty()) {
                                i++;
                            } else if (string2.startsWith("{")) {
                                try {
                                    string = new JSONObject(string2).getString("token");
                                } catch (JSONException unused) {
                                }
                            } else {
                                string = string2;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        kc.c cVar2 = this.f6421b;
        ab.g gVar = this.f6420a;
        gVar.a();
        String str3 = gVar.f392c.f403a;
        String str4 = bVar.f6736a;
        ab.g gVar2 = this.f6420a;
        gVar2.a();
        String str5 = gVar2.f392c.f408g;
        ab.g gVar3 = this.f6420a;
        gVar3.a();
        String str6 = gVar3.f392c.f404b;
        kc.d dVar = cVar2.f7412c;
        if (!dVar.b()) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = kc.c.a("projects/" + str5 + "/installations");
        int i10 = 0;
        kc.a aVar = cVar2;
        while (i10 <= 1) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionC = aVar.c(urlA, str3);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    kc.c.g(httpURLConnectionC, str4, str6);
                    responseCode = httpURLConnectionC.getResponseCode();
                    dVar.d(responseCode);
                } catch (IOException | AssertionError unused2) {
                }
                if (responseCode >= 200 && responseCode < 300) {
                    kc.a aVarE = kc.c.e(httpURLConnectionC);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    aVar = aVarE;
                } else {
                    try {
                        kc.c.b(httpURLConnectionC, str6, str3, str5);
                    } catch (IOException | AssertionError unused3) {
                        httpURLConnectionC.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                    if (responseCode == 429) {
                        throw new e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        kc.a aVar2 = new kc.a(null, null, null, null, 2);
                        httpURLConnectionC.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        aVar = aVar2;
                    } else {
                        httpURLConnectionC.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        i10++;
                        aVar = aVar;
                    }
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i10++;
                    aVar = aVar;
                }
                int iC = y.e.c(aVar.f7404e);
                if (iC != 0) {
                    if (iC != 1) {
                        throw new e("Firebase Installations Service is unavailable. Please try again later.");
                    }
                    jc.a aVarA = bVar.a();
                    aVarA.f6733g = "BAD CONFIG";
                    aVarA.f6729b = 5;
                    return aVarA.a();
                }
                String str7 = aVar.f7401b;
                String str8 = aVar.f7402c;
                j jVar = this.f6423d;
                jVar.getClass();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jVar.f6438a.getClass();
                long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                kc.b bVar2 = aVar.f7403d;
                String str9 = bVar2.f7405a;
                long j4 = bVar2.f7406b;
                jc.a aVarA2 = bVar.a();
                aVarA2.f6728a = str7;
                aVarA2.f6729b = 4;
                aVarA2.f6730c = str9;
                aVarA2.f6731d = str8;
                aVarA2.f6732e = j4;
                byte b8 = (byte) (aVarA2.f6734h | 1);
                aVarA2.f = seconds;
                aVarA2.f6734h = (byte) (b8 | 2);
                return aVarA2.a();
            } finally {
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
        }
        throw new e("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void j(Exception exc) {
        synchronized (this.f6425g) {
            try {
                Iterator it = this.f6429l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).b(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(jc.b bVar) {
        synchronized (this.f6425g) {
            try {
                Iterator it = this.f6429l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).a(bVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void l(String str) {
        this.f6427j = str;
    }

    public final synchronized void m(jc.b bVar, jc.b bVar2) {
        try {
            if (this.f6428k.size() != 0 && !TextUtils.equals(bVar.f6736a, bVar2.f6736a)) {
                Iterator it = this.f6428k.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
        } finally {
        }
    }
}
