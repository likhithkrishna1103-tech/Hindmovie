package yb;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n.q3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f14622p = {2, 4, 8, 16, 32, 64, 128, 256};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f14623q = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f14624a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14626c;
    public final ScheduledExecutorService f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f14629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ga.g f14630h;
    public final ob.d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f14631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f14632k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j f14636o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14625b = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Random f14634m = new Random();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x7.a f14635n = x7.a.f14294a;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f14633l = "firebase";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14627d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14628e = false;

    public m(ga.g gVar, ob.d dVar, g gVar2, c cVar, Context context, LinkedHashSet linkedHashSet, j jVar, ScheduledExecutorService scheduledExecutorService) {
        this.f14624a = linkedHashSet;
        this.f = scheduledExecutorService;
        this.f14626c = Math.max(8 - jVar.b().f14612a, 1);
        this.f14630h = gVar;
        this.f14629g = gVar2;
        this.i = dVar;
        this.f14631j = cVar;
        this.f14632k = context;
        this.f14636o = jVar;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
            } catch (IOException unused) {
            }
        }
    }

    public static boolean d(int i) {
        return i == 408 || i == 429 || i == 502 || i == 503 || i == 504;
    }

    public static String f(InputStream inputStream) {
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb2.append(line);
            }
        } catch (IOException unused) {
            if (sb2.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean a() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.LinkedHashSet r0 = r1.f14624a     // Catch: java.lang.Throwable -> L17
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f14625b     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f14627d     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f14628e     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            r0 = 1
            goto L1a
        L17:
            r0 = move-exception
            goto L1c
        L19:
            r0 = 0
        L1a:
            monitor-exit(r1)
            return r0
        L1c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.m.a():boolean");
    }

    public final String c(String str) {
        ga.g gVar = this.f14630h;
        gVar.a();
        Matcher matcher = f14623q.matcher(gVar.f5348c.f5360b);
        return "https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/" + (matcher.matches() ? matcher.group(1) : null) + "/namespaces/" + str + ":streamFetchInvalidations";
    }

    public final synchronized void e(long j5) {
        try {
            if (a()) {
                int i = this.f14626c;
                if (i > 0) {
                    this.f14626c = i - 1;
                    this.f.schedule(new k(0, this), j5, TimeUnit.MILLISECONDS);
                } else if (!this.f14628e) {
                    new xb.c("Unable to connect to the server. Check your connection and try again.");
                    g();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void g() {
        Iterator it = this.f14624a.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
    }

    public final synchronized void h() {
        this.f14635n.getClass();
        e(Math.max(0L, this.f14636o.b().f14613b.getTime() - new Date(System.currentTimeMillis()).getTime()));
    }

    public final synchronized void i(boolean z2) {
        this.f14625b = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(java.net.HttpURLConnection r7, java.lang.String r8, java.lang.String r9) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.m.j(java.net.HttpURLConnection, java.lang.String, java.lang.String):void");
    }

    public final synchronized q3 k(HttpURLConnection httpURLConnection) {
        return new q3(httpURLConnection, this.f14629g, this.f14631j, this.f14624a, new l(this), this.f);
    }

    public final void l(Date date) {
        j jVar = this.f14636o;
        int i = jVar.b().f14612a + 1;
        long millis = TimeUnit.MINUTES.toMillis(f14622p[(i < 8 ? i : 8) - 1]);
        jVar.e(i, new Date(date.getTime() + (millis / 2) + ((long) this.f14634m.nextInt((int) millis))));
    }
}
