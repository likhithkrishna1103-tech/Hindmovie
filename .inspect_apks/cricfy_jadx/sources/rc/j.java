package rc;

import android.content.Context;
import android.os.Build;
import android.util.Log;
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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f10962s = {2, 4, 8, 16, 32, 64, 128, 256};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f10963t = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f10964a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10966c;
    public HttpURLConnection f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i2.f f10969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f10970h;
    public final g i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ab.g f10971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ic.d f10972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f10973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f10974m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final l f10978q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10965b = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Random f10976o = new Random();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final s8.a f10977p = s8.a.f11610a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f10975n = "firebase";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10967d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10968e = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Object f10979r = new Object();

    public j(ab.g gVar, ic.d dVar, g gVar2, c cVar, Context context, LinkedHashSet linkedHashSet, l lVar, ScheduledExecutorService scheduledExecutorService) {
        this.f10964a = linkedHashSet;
        this.f10970h = scheduledExecutorService;
        this.f10966c = Math.max(8 - lVar.c().f10980a, 1);
        this.f10971j = gVar;
        this.i = gVar2;
        this.f10972k = dVar;
        this.f10973l = cVar;
        this.f10974m = context;
        this.f10978q = lVar;
    }

    public static boolean d(int i) {
        return i == 408 || i == 429 || i == 502 || i == 503 || i == 504;
    }

    public static String f(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
        } catch (IOException unused) {
            if (sb.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb.toString();
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
            java.util.LinkedHashSet r0 = r1.f10964a     // Catch: java.lang.Throwable -> L17
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f10965b     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f10967d     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f10968e     // Catch: java.lang.Throwable -> L17
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
        throw new UnsupportedOperationException("Method not decompiled: rc.j.a():boolean");
    }

    public final void b(InputStream inputStream, InputStream inputStream2) {
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null && !this.f10968e) {
            httpURLConnection.disconnect();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e9) {
                Log.d("FirebaseRemoteConfig", "Error closing connection stream.", e9);
            }
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e10) {
                Log.d("FirebaseRemoteConfig", "Error closing connection stream.", e10);
            }
        }
    }

    public final String c(String str) {
        ab.g gVar = this.f10971j;
        gVar.a();
        Matcher matcher = f10963t.matcher(gVar.f392c.f404b);
        return "https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/" + (matcher.matches() ? matcher.group(1) : null) + "/namespaces/" + str + ":streamFetchInvalidations";
    }

    public final synchronized void e(long j4) {
        try {
            if (a()) {
                int i = this.f10966c;
                if (i > 0) {
                    this.f10966c = i - 1;
                    this.f10970h.schedule(new androidx.fragment.app.m(27, this), j4, TimeUnit.MILLISECONDS);
                } else if (!this.f10968e) {
                    new qc.c("Unable to connect to the server. Check your connection and try again.");
                    g();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void g() {
        Iterator it = this.f10964a.iterator();
        while (it.hasNext()) {
            ((i) it.next()).a();
        }
    }

    public final synchronized void h() {
        this.f10966c = 8;
    }

    public final synchronized void i() {
        this.f10977p.getClass();
        e(Math.max(0L, this.f10978q.c().f10981b.getTime() - new Date(System.currentTimeMillis()).getTime()));
    }

    public final synchronized void j(boolean z10) {
        this.f10965b = z10;
    }

    public final void k(boolean z10) {
        HttpURLConnection httpURLConnection;
        synchronized (this.f10979r) {
            try {
                this.f10968e = z10;
                i2.f fVar = this.f10969g;
                if (fVar != null) {
                    fVar.f5992a = z10;
                }
                if (Build.VERSION.SDK_INT >= 26 && z10 && (httpURLConnection = this.f) != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(java.net.HttpURLConnection r7, java.lang.String r8, java.lang.String r9) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.j.l(java.net.HttpURLConnection, java.lang.String, java.lang.String):void");
    }

    public final synchronized i2.f m(HttpURLConnection httpURLConnection) {
        return new i2.f(httpURLConnection, this.i, this.f10973l, this.f10964a, new i(this), this.f10970h, this.f10978q);
    }

    public final void n(Date date) {
        l lVar = this.f10978q;
        int i = lVar.c().f10980a + 1;
        long millis = TimeUnit.MINUTES.toMillis(f10962s[(i < 8 ? i : 8) - 1]);
        lVar.g(i, new Date(date.getTime() + (millis / 2) + ((long) this.f10976o.nextInt((int) millis))));
    }
}
