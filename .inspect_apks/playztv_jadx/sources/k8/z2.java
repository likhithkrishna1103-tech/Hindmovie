package k8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.internal.measurement.d7;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z2 extends y0 {
    public final a3 A;
    public final af.a B;
    public final ArrayList C;
    public final a3 D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g3 f7572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h0 f7573y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile Boolean f7574z;

    public z2(k1 k1Var) {
        super(k1Var);
        this.C = new ArrayList();
        this.B = new af.a(k1Var.H);
        this.f7572x = new g3(this);
        this.A = new a3(this, k1Var, 0);
        this.D = new a3(this, k1Var, 1);
    }

    public final void A1(boolean z2) {
        p1();
        t1();
        d7.a();
        k1 k1Var = (k1) this.f2454v;
        if (!k1Var.A.A1(null, w.X0) && z2) {
            k1Var.n().y1();
        }
        if (E1()) {
            w1(new d3(this, I1(false), 4));
        }
    }

    public final void B1() {
        p1();
        t1();
        if (D1()) {
            return;
        }
        if (!F1()) {
            if (((k1) this.f2454v).A.D1()) {
                return;
            }
            List<ResolveInfo> listQueryIntentServices = ((k1) this.f2454v).f7282u.getPackageManager().queryIntentServices(new Intent().setClassName(((k1) this.f2454v).f7282u, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                g().A.d("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                return;
            }
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(((k1) this.f2454v).f7282u, "com.google.android.gms.measurement.AppMeasurementService"));
            this.f7572x.a(intent);
            return;
        }
        g3 g3Var = this.f7572x;
        g3Var.f7217w.p1();
        Context context = ((k1) g3Var.f7217w.f2454v).f7282u;
        synchronized (g3Var) {
            try {
                if (g3Var.f7215u) {
                    g3Var.f7217w.g().I.d("Connection attempt already in progress");
                    return;
                }
                if (g3Var.f7216v != null && (g3Var.f7216v.h() || g3Var.f7216v.b())) {
                    g3Var.f7217w.g().I.d("Already awaiting connection attempt");
                    return;
                }
                g3Var.f7216v = new m0(context, Looper.getMainLooper(), t7.e0.a(context), q7.f.f11040b, 93, g3Var, g3Var, null);
                g3Var.f7217w.g().I.d("Connecting to remote service");
                g3Var.f7215u = true;
                t7.v.h(g3Var.f7216v);
                g3Var.f7216v.o();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void C1() {
        p1();
        t1();
        g3 g3Var = this.f7572x;
        if (g3Var.f7216v != null && (g3Var.f7216v.b() || g3Var.f7216v.h())) {
            g3Var.f7216v.l();
        }
        g3Var.f7216v = null;
        try {
            w7.a.b().c(((k1) this.f2454v).f7282u, this.f7572x);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f7573y = null;
    }

    public final boolean D1() {
        p1();
        t1();
        return this.f7573y != null;
    }

    public final boolean E1() {
        p1();
        t1();
        return !F1() || o1().t2() >= ((Integer) w.f7510t0.a(null)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean F1() {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.z2.F1():boolean");
    }

    public final void G1() {
        p1();
        r0 r0Var = g().I;
        ArrayList arrayList = this.C;
        r0Var.c(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                ((Runnable) obj).run();
            } catch (RuntimeException e10) {
                g().A.c(e10, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.D.a();
    }

    public final void H1() {
        p1();
        af.a aVar = this.B;
        ((x7.a) aVar.f797w).getClass();
        aVar.f796v = SystemClock.elapsedRealtime();
        this.A.b(((Long) w.M.a(null)).longValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.a4 I1(boolean r46) {
        /*
            Method dump skipped, instruction units count: 996
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.z2.I1(boolean):k8.a4");
    }

    @Override // k8.y0
    public final boolean v1() {
        return false;
    }

    public final void w1(Runnable runnable) {
        p1();
        if (D1()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.C;
        if (arrayList.size() >= 1000) {
            g().A.d("Discarding data. Max runnable queue size reached");
            return;
        }
        arrayList.add(runnable);
        this.D.b(60000L);
        B1();
    }

    public final void x1(AtomicReference atomicReference) {
        p1();
        t1();
        w1(new ab.c(this, atomicReference, I1(false), 6));
    }

    public final void y1(d dVar) {
        boolean zX1;
        p1();
        t1();
        j0 j0VarN = ((k1) this.f2454v).n();
        j0VarN.o1();
        byte[] bArrF2 = h4.f2(dVar);
        if (bArrF2.length > 131072) {
            j0VarN.g().B.d("Conditional user property too long for local database. Sending directly to service");
            zX1 = false;
        } else {
            zX1 = j0VarN.x1(2, bArrF2);
        }
        boolean z2 = zX1;
        w1(new c3(this, I1(true), z2, new d(dVar), dVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:177:0x02b4 A[Catch: all -> 0x011a, TRY_ENTER, TryCatch #50 {all -> 0x011a, blocks: (B:63:0x0111, B:65:0x0116, B:177:0x02b4, B:179:0x02ba, B:180:0x02bd, B:83:0x014a, B:84:0x014d, B:82:0x0146, B:94:0x0167, B:96:0x017b, B:103:0x0192, B:104:0x0196, B:105:0x0199, B:101:0x018c, B:107:0x019c, B:111:0x01b0, B:123:0x01ce, B:124:0x01d2, B:125:0x01d5, B:121:0x01c8, B:130:0x01de, B:131:0x01ea, B:145:0x0226, B:147:0x0242, B:148:0x024d), top: B:307:0x0111 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0347 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0313 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z1(k8.h0 r33, u7.a r34, k8.a4 r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1115
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.z2.z1(k8.h0, u7.a, k8.a4):void");
    }
}
