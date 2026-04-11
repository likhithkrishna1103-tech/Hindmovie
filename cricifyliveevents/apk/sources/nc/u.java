package nc;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    public static final long i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f9090j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0.d f9092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c2.o f9093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f9094d;
    public final ScheduledThreadPoolExecutor f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s f9097h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v.e f9095e = new v.e(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9096g = false;

    public u(FirebaseMessaging firebaseMessaging, t0.d dVar, s sVar, c2.o oVar, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f9094d = firebaseMessaging;
        this.f9092b = dVar;
        this.f9097h = sVar;
        this.f9093c = oVar;
        this.f9091a = context;
        this.f = scheduledThreadPoolExecutor;
    }

    public static void b(j9.p pVar) throws IOException {
        try {
            vf.g.c(pVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e9) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e9);
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e10);
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

    public final void a(r rVar, j9.i iVar) {
        ArrayDeque arrayDeque;
        synchronized (this.f9095e) {
            try {
                String str = rVar.f9080c;
                if (this.f9095e.containsKey(str)) {
                    arrayDeque = (ArrayDeque) this.f9095e.get(str);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f9095e.put(str, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(iVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str) throws IOException {
        String strA = this.f9094d.a();
        c2.o oVar = this.f9093c;
        oVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        b(oVar.j(oVar.z(strA, "/topics/" + str, bundle)));
    }

    public final void d(String str) throws IOException {
        String strA = this.f9094d.a();
        c2.o oVar = this.f9093c;
        oVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        b(oVar.j(oVar.z(strA, "/topics/" + str, bundle)));
    }

    public final void f(r rVar) {
        synchronized (this.f9095e) {
            try {
                String str = rVar.f9080c;
                if (this.f9095e.containsKey(str)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f9095e.get(str);
                    j9.i iVar = (j9.i) arrayDeque.poll();
                    if (iVar != null) {
                        iVar.a(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f9095e.remove(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void g(boolean z10) {
        this.f9096g = z10;
    }

    public final void h() {
        boolean z10;
        if (this.f9097h.a() != null) {
            synchronized (this) {
                z10 = this.f9096g;
            }
            if (z10) {
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
        throw new UnsupportedOperationException("Method not decompiled: nc.u.i():boolean");
    }

    public final void j(long j4) {
        this.f.schedule(new w(this, this.f9091a, this.f9092b, Math.min(Math.max(30L, 2 * j4), i)), j4, TimeUnit.SECONDS);
        g(true);
    }
}
