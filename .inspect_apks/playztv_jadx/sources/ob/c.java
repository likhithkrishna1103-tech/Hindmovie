package ob;

import aa.l0;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.k4;
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
import k8.a0;
import na.n;
import o8.o;
import org.json.JSONException;
import org.json.JSONObject;
import t7.v;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f9485m = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ga.g f9486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qb.c f9487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pb.c f9488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f9489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f9490e;
    public final h f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f9491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExecutorService f9492h;
    public final oa.i i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashSet f9494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f9495l;

    static {
        new AtomicInteger(1);
    }

    public c(ga.g gVar, nb.b bVar, ExecutorService executorService, oa.i iVar) {
        gVar.a();
        qb.c cVar = new qb.c(gVar.f5346a, bVar);
        pb.c cVar2 = new pb.c(gVar);
        if (a0.f7067v == null) {
            a0.f7067v = new a0(24);
        }
        a0 a0Var = a0.f7067v;
        if (j.f9503d == null) {
            j.f9503d = new j(a0Var);
        }
        j jVar = j.f9503d;
        n nVar = new n(new na.d(2, gVar));
        h hVar = new h();
        this.f9491g = new Object();
        this.f9494k = new HashSet();
        this.f9495l = new ArrayList();
        this.f9486a = gVar;
        this.f9487b = cVar;
        this.f9488c = cVar2;
        this.f9489d = jVar;
        this.f9490e = nVar;
        this.f = hVar;
        this.f9492h = executorService;
        this.i = iVar;
    }

    public final void a(i iVar) {
        synchronized (this.f9491g) {
            this.f9495l.add(iVar);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void b() {
        pb.a aVarM;
        synchronized (f9485m) {
            try {
                ga.g gVar = this.f9486a;
                gVar.a();
                k4 k4VarL = k4.l(gVar.f5346a);
                try {
                    aVarM = this.f9488c.m();
                    int i = aVarM.f10301b;
                    boolean z2 = true;
                    if (i != 2 && i != 1) {
                        z2 = false;
                    }
                    if (z2) {
                        String strH = h(aVarM);
                        pb.c cVar = this.f9488c;
                        af.h hVarA = aVarM.a();
                        hVarA.f814b = strH;
                        hVarA.f813a = 3;
                        aVarM = hVarA.i();
                        cVar.i(aVarM);
                    }
                    if (k4VarL != null) {
                        k4VarL.A();
                    }
                } catch (Throwable th) {
                    if (k4VarL != null) {
                        k4VarL.A();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        k(aVarM);
        this.i.execute(new b(this, 2));
    }

    public final pb.a c(pb.a aVar) throws e {
        int responseCode;
        qb.b bVarF;
        ga.g gVar = this.f9486a;
        gVar.a();
        String str = gVar.f5348c.f5359a;
        String str2 = aVar.f10300a;
        gVar.a();
        String str3 = gVar.f5348c.f5364g;
        String str4 = aVar.f10303d;
        qb.c cVar = this.f9487b;
        qb.d dVar = cVar.f11181c;
        if (!dVar.b()) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = qb.c.a("projects/" + str3 + "/installations/" + str2 + "/authTokens:generate");
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionC = cVar.c(urlA, str);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    httpURLConnectionC.setDoOutput(true);
                    qb.c.h(httpURLConnectionC);
                    responseCode = httpURLConnectionC.getResponseCode();
                    dVar.d(responseCode);
                } finally {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IOException | AssertionError unused) {
            }
            if (responseCode >= 200 && responseCode < 300) {
                bVarF = qb.c.f(httpURLConnectionC);
            } else {
                qb.c.b(httpURLConnectionC, null, str, str3);
                if (responseCode == 401 || responseCode == 404) {
                    l0 l0VarA = qb.b.a();
                    l0VarA.f705v = 3;
                    bVarF = l0VarA.b();
                } else {
                    if (responseCode == 429) {
                        throw new e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        l0 l0VarA2 = qb.b.a();
                        l0VarA2.f705v = 2;
                        bVarF = l0VarA2.b();
                    }
                }
            }
            int iC = v.e.c(bVarF.f11176c);
            if (iC != 0) {
                if (iC == 1) {
                    af.h hVarA = aVar.a();
                    hVarA.f818g = "BAD CONFIG";
                    hVarA.f813a = 5;
                    return hVarA.i();
                }
                if (iC != 2) {
                    throw new e("Firebase Installations Service is unavailable. Please try again later.");
                }
                l(null);
                af.h hVarA2 = aVar.a();
                hVarA2.f813a = 2;
                return hVarA2.i();
            }
            String str5 = bVarF.f11174a;
            long j5 = bVarF.f11175b;
            j jVar = this.f9489d;
            jVar.getClass();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            jVar.f9504a.getClass();
            long seconds = timeUnit.toSeconds(System.currentTimeMillis());
            af.h hVarA3 = aVar.a();
            hVarA3.f815c = str5;
            hVarA3.f817e = Long.valueOf(j5);
            hVarA3.f = Long.valueOf(seconds);
            return hVarA3.i();
        }
        throw new e("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final o d() {
        String str;
        g();
        synchronized (this) {
            str = this.f9493j;
        }
        if (str != null) {
            return t1.k(str);
        }
        o8.h hVar = new o8.h();
        a(new g(hVar));
        o oVar = hVar.f9421a;
        this.f9492h.execute(new b(this, 0));
        return oVar;
    }

    public final o e() {
        g();
        o8.h hVar = new o8.h();
        a(new f(this.f9489d, hVar));
        this.f9492h.execute(new b(this, 1));
        return hVar.f9421a;
    }

    /* JADX WARN: Finally extract failed */
    public final void f(pb.a aVar) {
        synchronized (f9485m) {
            try {
                ga.g gVar = this.f9486a;
                gVar.a();
                k4 k4VarL = k4.l(gVar.f5346a);
                try {
                    this.f9488c.i(aVar);
                    if (k4VarL != null) {
                        k4VarL.A();
                    }
                } catch (Throwable th) {
                    if (k4VarL != null) {
                        k4VarL.A();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g() {
        ga.g gVar = this.f9486a;
        gVar.a();
        v.e(gVar.f5348c.f5360b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        v.e(gVar.f5348c.f5364g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        v.e(gVar.f5348c.f5359a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        String str = gVar.f5348c.f5360b;
        Pattern pattern = j.f9502c;
        if (!str.contains(":")) {
            throw new IllegalArgumentException("Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        }
        gVar.a();
        if (!j.f9502c.matcher(gVar.f5348c.f5359a).matches()) {
            throw new IllegalArgumentException("Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h(pb.a r3) {
        /*
            r2 = this;
            ga.g r0 = r2.f9486a
            r0.a()
            java.lang.String r0 = r0.f5347b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            ga.g r0 = r2.f9486a
            java.lang.String r1 = "[DEFAULT]"
            r0.a()
            java.lang.String r0 = r0.f5347b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L50
        L1e:
            int r3 = r3.f10301b
            r0 = 1
            if (r3 != r0) goto L50
            na.n r3 = r2.f9490e
            java.lang.Object r3 = r3.get()
            pb.b r3 = (pb.b) r3
            android.content.SharedPreferences r0 = r3.f10307a
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
            ob.h r3 = r2.f
            r3.getClass()
            java.lang.String r3 = ob.h.a()
            return r3
        L4d:
            return r1
        L4e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r3
        L50:
            ob.h r3 = r2.f
            r3.getClass()
            java.lang.String r3 = ob.h.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.c.h(pb.a):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [qb.c] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [qb.a] */
    public final pb.a i(pb.a aVar) throws e {
        int responseCode;
        String str = aVar.f10300a;
        String string = null;
        if (str != null && str.length() == 11) {
            pb.b bVar = (pb.b) this.f9490e.get();
            synchronized (bVar.f10307a) {
                try {
                    String[] strArr = pb.b.f10306c;
                    int i = 0;
                    while (true) {
                        if (i < 4) {
                            String str2 = strArr[i];
                            String string2 = bVar.f10307a.getString("|T|" + bVar.f10308b + "|" + str2, null);
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
        qb.c cVar = this.f9487b;
        ga.g gVar = this.f9486a;
        gVar.a();
        String str3 = gVar.f5348c.f5359a;
        String str4 = aVar.f10300a;
        ga.g gVar2 = this.f9486a;
        gVar2.a();
        String str5 = gVar2.f5348c.f5364g;
        ga.g gVar3 = this.f9486a;
        gVar3.a();
        String str6 = gVar3.f5348c.f5360b;
        qb.d dVar = cVar.f11181c;
        if (!dVar.b()) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = qb.c.a("projects/" + str5 + "/installations");
        int i10 = 0;
        qb.a aVar2 = cVar;
        while (i10 <= 1) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionC = aVar2.c(urlA, str3);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    qb.c.g(httpURLConnectionC, str4, str6);
                    responseCode = httpURLConnectionC.getResponseCode();
                    dVar.d(responseCode);
                } catch (IOException | AssertionError unused2) {
                }
                if (responseCode >= 200 && responseCode < 300) {
                    qb.a aVarE = qb.c.e(httpURLConnectionC);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    aVar2 = aVarE;
                } else {
                    try {
                        qb.c.b(httpURLConnectionC, str6, str3, str5);
                    } catch (IOException | AssertionError unused3) {
                        httpURLConnectionC.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                    if (responseCode == 429) {
                        throw new e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        qb.a aVar3 = new qb.a(null, null, null, null, 2);
                        httpURLConnectionC.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        aVar2 = aVar3;
                    } else {
                        httpURLConnectionC.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        i10++;
                        aVar2 = aVar2;
                    }
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i10++;
                    aVar2 = aVar2;
                }
                int iC = v.e.c(aVar2.f11173e);
                if (iC != 0) {
                    if (iC != 1) {
                        throw new e("Firebase Installations Service is unavailable. Please try again later.");
                    }
                    af.h hVarA = aVar.a();
                    hVarA.f818g = "BAD CONFIG";
                    hVarA.f813a = 5;
                    return hVarA.i();
                }
                String str7 = aVar2.f11170b;
                String str8 = aVar2.f11171c;
                j jVar = this.f9489d;
                jVar.getClass();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jVar.f9504a.getClass();
                long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                qb.b bVar2 = aVar2.f11172d;
                String str9 = bVar2.f11174a;
                long j5 = bVar2.f11175b;
                af.h hVarA2 = aVar.a();
                hVarA2.f814b = str7;
                hVarA2.f813a = 4;
                hVarA2.f815c = str9;
                hVarA2.f816d = str8;
                hVarA2.f817e = Long.valueOf(j5);
                hVarA2.f = Long.valueOf(seconds);
                return hVarA2.i();
            } finally {
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
        }
        throw new e("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void j(Exception exc) {
        synchronized (this.f9491g) {
            try {
                Iterator it = this.f9495l.iterator();
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

    public final void k(pb.a aVar) {
        synchronized (this.f9491g) {
            try {
                Iterator it = this.f9495l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).a(aVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void l(String str) {
        this.f9493j = str;
    }

    public final synchronized void m(pb.a aVar, pb.a aVar2) {
        try {
            if (this.f9494k.size() != 0 && !TextUtils.equals(aVar.f10300a, aVar2.f10300a)) {
                Iterator it = this.f9494k.iterator();
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
