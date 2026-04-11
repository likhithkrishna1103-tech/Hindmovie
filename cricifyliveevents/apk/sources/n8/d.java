package n8;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import nb.w;
import o8.f0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Handler.Callback {
    public static final Status J = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status K = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object L = new Object();
    public static d M;
    public final l8.e A;
    public final w B;
    public final AtomicInteger C;
    public final AtomicInteger D;
    public final ConcurrentHashMap E;
    public final v.f F;
    public final v.f G;
    public final a9.k H;
    public volatile boolean I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f8867v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8868w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public o8.l f8869x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q8.c f8870y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Context f8871z;

    public d(Context context, Looper looper) {
        l8.e eVar = l8.e.f7888d;
        this.f8867v = 10000L;
        this.f8868w = false;
        this.C = new AtomicInteger(1);
        this.D = new AtomicInteger(0);
        this.E = new ConcurrentHashMap(5, 0.75f, 1);
        this.F = new v.f(0);
        this.G = new v.f(0);
        this.I = true;
        this.f8871z = context;
        a9.k kVar = new a9.k(looper, this);
        Looper.getMainLooper();
        this.H = kVar;
        this.A = eVar;
        this.B = new w(3);
        PackageManager packageManager = context.getPackageManager();
        if (s8.b.f == null) {
            s8.b.f = Boolean.valueOf(s8.b.d() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (s8.b.f.booleanValue()) {
            this.I = false;
        }
        kVar.sendMessage(kVar.obtainMessage(6));
    }

    public static Status b(a aVar, l8.b bVar) {
        return new Status(17, "API: " + ((String) aVar.f8859b.f6086w) + " is not available on this device. Connection failed with: " + String.valueOf(bVar), bVar.f7879x, bVar);
    }

    public static d e(Context context) {
        d dVar;
        synchronized (L) {
            try {
                if (M == null) {
                    Looper looper = f0.b().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = l8.e.f7887c;
                    M = new d(applicationContext, looper);
                }
                dVar = M;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public final boolean a(l8.b bVar, int i) {
        l8.e eVar = this.A;
        eVar.getClass();
        Context context = this.f8871z;
        if (!u8.a.v(context)) {
            int i10 = bVar.f7878w;
            PendingIntent activity = bVar.f7879x;
            if (!((i10 == 0 || activity == null) ? false : true)) {
                activity = null;
                Intent intentA = eVar.a(i10, context, null);
                if (intentA != null) {
                    activity = PendingIntent.getActivity(context, 0, intentA, 201326592);
                }
            }
            if (activity != null) {
                int i11 = GoogleApiActivity.f2302w;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                eVar.f(context, i10, PendingIntent.getActivity(context, 0, intent, y8.c.f14976a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final i c(q8.c cVar) {
        a aVar = cVar.f10452e;
        ConcurrentHashMap concurrentHashMap = this.E;
        i iVar = (i) concurrentHashMap.get(aVar);
        if (iVar == null) {
            iVar = new i(this, cVar);
            concurrentHashMap.put(aVar, iVar);
        }
        if (iVar.f8874e.j()) {
            this.G.add(aVar);
        }
        iVar.m();
        return iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r6 = this;
            o8.l r0 = r6.f8869x
            if (r0 == 0) goto L55
            int r1 = r0.f9679v
            if (r1 > 0) goto L3a
            boolean r1 = r6.f8868w
            if (r1 == 0) goto Ld
            goto L52
        Ld:
            java.lang.Class<o8.j> r1 = o8.j.class
            monitor-enter(r1)
            o8.j r2 = o8.j.f9669w     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto L1f
            o8.j r2 = new o8.j     // Catch: java.lang.Throwable -> L1d
            r3 = 0
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1d
            o8.j.f9669w = r2     // Catch: java.lang.Throwable -> L1d
            goto L1f
        L1d:
            r0 = move-exception
            goto L38
        L1f:
            o8.j r2 = o8.j.f9669w     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r1)
            r2.getClass()
            nb.w r1 = r6.B
            java.lang.Object r1 = r1.f9016w
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
            q8.c r1 = r6.f8870y
            if (r1 != 0) goto L4d
            android.content.Context r1 = r6.f8871z
            o8.m r2 = o8.m.f9681b
            q8.c r3 = new q8.c
            i2.k r4 = q8.c.i
            m8.b r5 = m8.b.f8387b
            r3.<init>(r1, r4, r2, r5)
            r6.f8870y = r3
        L4d:
            q8.c r1 = r6.f8870y
            r1.a(r0)
        L52:
            r0 = 0
            r6.f8869x = r0
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.d.d():void");
    }

    public final void f(l8.b bVar, int i) {
        if (a(bVar, i)) {
            return;
        }
        a9.k kVar = this.H;
        kVar.sendMessage(kVar.obtainMessage(5, i, 0, bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r13) {
        /*
            Method dump skipped, instruction units count: 1114
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.d.handleMessage(android.os.Message):boolean");
    }
}
