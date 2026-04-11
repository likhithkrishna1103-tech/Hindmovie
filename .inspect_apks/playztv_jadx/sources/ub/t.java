package ub;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {
    public static final long i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f12889j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0.d f12891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b2.g f12892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f12893d;
    public final ScheduledThreadPoolExecutor f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r f12896h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s.e f12894e = new s.e(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12895g = false;

    public t(FirebaseMessaging firebaseMessaging, q0.d dVar, r rVar, b2.g gVar, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f12893d = firebaseMessaging;
        this.f12891b = dVar;
        this.f12896h = rVar;
        this.f12892c = gVar;
        this.f12890a = context;
        this.f = scheduledThreadPoolExecutor;
    }

    public static void b(o8.o oVar) throws IOException {
        try {
            t1.e(oVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e10) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e10);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e11);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static boolean e() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    public final void a(q qVar, o8.h hVar) {
        ArrayDeque arrayDeque;
        synchronized (this.f12894e) {
            try {
                String str = qVar.f12879c;
                if (this.f12894e.containsKey(str)) {
                    arrayDeque = (ArrayDeque) this.f12894e.get(str);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f12894e.put(str, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str) throws IOException {
        String strA = this.f12893d.a();
        b2.g gVar = this.f12892c;
        gVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        b(gVar.i(gVar.x(strA, "/topics/" + str, bundle)));
    }

    public final void d(String str) throws IOException {
        String strA = this.f12893d.a();
        b2.g gVar = this.f12892c;
        gVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        b(gVar.i(gVar.x(strA, "/topics/" + str, bundle)));
    }

    public final void f(q qVar) {
        synchronized (this.f12894e) {
            try {
                String str = qVar.f12879c;
                if (this.f12894e.containsKey(str)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f12894e.get(str);
                    o8.h hVar = (o8.h) arrayDeque.poll();
                    if (hVar != null) {
                        hVar.a(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f12894e.remove(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void g(boolean z2) {
        this.f12895g = z2;
    }

    public final void h() {
        boolean z2;
        if (this.f12896h.a() != null) {
            synchronized (this) {
                z2 = this.f12895g;
            }
            if (z2) {
                return;
            }
            j(0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083 A[Catch: IOException -> 0x005d, TryCatch #1 {IOException -> 0x005d, blocks: (B:15:0x0028, B:32:0x0083, B:34:0x0089, B:20:0x0039, B:22:0x0041, B:24:0x004a, B:27:0x005f, B:29:0x0067, B:31:0x0070), top: B:54:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.t.i():boolean");
    }

    public final void j(long j5) {
        this.f.schedule(new v(this, this.f12890a, this.f12891b, Math.min(Math.max(30L, 2 * j5), i)), j5, TimeUnit.SECONDS);
        g(true);
    }
}
