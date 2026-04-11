package s7;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.r0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import t7.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Handler.Callback {
    public static final Status I = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status J = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object K = new Object();
    public static d L;
    public final p2.c A;
    public final AtomicInteger B;
    public final AtomicInteger C;
    public final ConcurrentHashMap D;
    public final s.f E;
    public final s.f F;
    public final r0 G;
    public volatile boolean H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f11883u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f11884v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public t7.l f11885w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public v7.c f11886x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Context f11887y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final q7.e f11888z;

    public d(Context context, Looper looper) {
        q7.e eVar = q7.e.f11038d;
        this.f11883u = 10000L;
        this.f11884v = false;
        this.B = new AtomicInteger(1);
        this.C = new AtomicInteger(0);
        this.D = new ConcurrentHashMap(5, 0.75f, 1);
        this.E = new s.f(0);
        this.F = new s.f(0);
        this.H = true;
        this.f11887y = context;
        r0 r0Var = new r0(looper, this);
        Looper.getMainLooper();
        this.G = r0Var;
        this.f11888z = eVar;
        this.A = new p2.c(16);
        PackageManager packageManager = context.getPackageManager();
        if (x7.b.f == null) {
            x7.b.f = Boolean.valueOf(x7.b.d() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (x7.b.f.booleanValue()) {
            this.H = false;
        }
        r0Var.sendMessage(r0Var.obtainMessage(6));
    }

    public static Status b(a aVar, q7.b bVar) {
        return new Status(17, "API: " + ((String) aVar.f11875b.f10311w) + " is not available on this device. Connection failed with: " + String.valueOf(bVar), bVar.f11029w, bVar);
    }

    public static d e(Context context) {
        d dVar;
        synchronized (K) {
            try {
                if (L == null) {
                    Looper looper = e0.b().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = q7.e.f11037c;
                    L = new d(applicationContext, looper);
                }
                dVar = L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public final boolean a(q7.b bVar, int i) {
        q7.e eVar = this.f11888z;
        eVar.getClass();
        Context context = this.f11887y;
        if (!z7.a.q(context)) {
            int i10 = bVar.f11028v;
            PendingIntent activity = bVar.f11029w;
            if (!((i10 == 0 || activity == null) ? false : true)) {
                activity = null;
                Intent intentA = eVar.a(i10, context, null);
                if (intentA != null) {
                    activity = PendingIntent.getActivity(context, 0, intentA, 201326592);
                }
            }
            if (activity != null) {
                int i11 = GoogleApiActivity.f2867v;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                eVar.f(context, i10, PendingIntent.getActivity(context, 0, intent, d8.e.f4102a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final j c(v7.c cVar) {
        a aVar = cVar.f13328e;
        ConcurrentHashMap concurrentHashMap = this.D;
        j jVar = (j) concurrentHashMap.get(aVar);
        if (jVar == null) {
            jVar = new j(this, cVar);
            concurrentHashMap.put(aVar, jVar);
        }
        if (jVar.f11891e.m()) {
            this.F.add(aVar);
        }
        jVar.m();
        return jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r6 = this;
            t7.l r0 = r6.f11885w
            if (r0 == 0) goto L55
            int r1 = r0.f12319u
            if (r1 > 0) goto L3a
            boolean r1 = r6.f11884v
            if (r1 == 0) goto Ld
            goto L52
        Ld:
            java.lang.Class<t7.j> r1 = t7.j.class
            monitor-enter(r1)
            t7.j r2 = t7.j.f12312v     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto L1f
            t7.j r2 = new t7.j     // Catch: java.lang.Throwable -> L1d
            r3 = 0
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1d
            t7.j.f12312v = r2     // Catch: java.lang.Throwable -> L1d
            goto L1f
        L1d:
            r0 = move-exception
            goto L38
        L1f:
            t7.j r2 = t7.j.f12312v     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r1)
            r2.getClass()
            p2.c r1 = r6.A
            java.lang.Object r1 = r1.f10130v
            android.util.SparseIntArray r1 = (android.util.SparseIntArray) r1
            r2 = 203400000(0xc1fa340, float:1.2298041E-31)
            r3 = -1
            int r1 = r1.get(r2, r3)
            if (r1 == r3) goto L3a
            if (r1 != 0) goto L52
            goto L3a
        L38:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1d
            throw r0
        L3a:
            v7.c r1 = r6.f11886x
            if (r1 != 0) goto L4d
            android.content.Context r1 = r6.f11887y
            t7.m r2 = t7.m.f12321b
            v7.c r3 = new v7.c
            pb.c r4 = v7.c.i
            r7.b r5 = r7.b.f11529b
            r3.<init>(r1, r4, r2, r5)
            r6.f11886x = r3
        L4d:
            v7.c r1 = r6.f11886x
            r1.a(r0)
        L52:
            r0 = 0
            r6.f11885w = r0
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.d.d():void");
    }

    public final void f(q7.b bVar, int i) {
        if (a(bVar, i)) {
            return;
        }
        r0 r0Var = this.G;
        r0Var.sendMessage(r0Var.obtainMessage(5, i, 0, bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r13) {
        /*
            Method dump skipped, instruction units count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.d.handleMessage(android.os.Message):boolean");
    }
}
