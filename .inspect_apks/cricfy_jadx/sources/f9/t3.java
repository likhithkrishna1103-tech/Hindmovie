package f9;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t3 extends h0 {
    public volatile Boolean A;
    public final p3 B;
    public ScheduledExecutorService C;
    public final s0 D;
    public final ArrayList E;
    public final p3 F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s3 f4419y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public i0 f4420z;

    public t3(r1 r1Var) {
        super(r1Var);
        this.E = new ArrayList();
        this.D = new s0(r1Var.F);
        this.f4419y = new s3(this);
        this.B = new p3(this, r1Var, 0);
        this.F = new p3(this, r1Var, 1);
    }

    public final void A1(Runnable runnable) {
        m1();
        if (D1()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.E;
        long size = arrayList.size();
        r1 r1Var = (r1) this.f307w;
        r1Var.getClass();
        if (size >= 1000) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.a("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.F.b(60000L);
            s1();
        }
    }

    public final void B1() {
        m1();
        r1 r1Var = (r1) this.f307w;
        w0 w0Var = r1Var.A;
        r1.g(w0Var);
        u0 u0Var = w0Var.J;
        ArrayList arrayList = this.E;
        u0Var.b(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                ((Runnable) obj).run();
            } catch (RuntimeException e9) {
                w0 w0Var2 = r1Var.A;
                r1.g(w0Var2);
                w0Var2.B.b(e9, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.F.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.w4 C1(boolean r11) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.t3.C1(boolean):f9.w4");
    }

    public final boolean D1() {
        m1();
        n1();
        return this.f4420z != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:259:0x0444 A[Catch: all -> 0x0480, TRY_ENTER, TryCatch #58 {all -> 0x0480, blocks: (B:269:0x0470, B:259:0x0444, B:261:0x044a, B:262:0x044d, B:279:0x0491, B:208:0x037b, B:210:0x0385, B:215:0x0396), top: B:420:0x0470 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x047c A[PHI: r5 r6 r24 r25 r27 r37 r38
      0x047c: PHI (r5v15 android.database.sqlite.SQLiteDatabase) = 
      (r5v12 android.database.sqlite.SQLiteDatabase)
      (r5v13 android.database.sqlite.SQLiteDatabase)
      (r5v16 android.database.sqlite.SQLiteDatabase)
     binds: [B:265:0x045f, B:282:0x04a3, B:273:0x047a] A[DONT_GENERATE, DONT_INLINE]
      0x047c: PHI (r6v5 int) = (r6v3 int), (r6v3 int), (r6v6 int) binds: [B:265:0x045f, B:282:0x04a3, B:273:0x047a] A[DONT_GENERATE, DONT_INLINE]
      0x047c: PHI (r24v9 int) = (r24v6 int), (r24v7 int), (r24v10 int) binds: [B:265:0x045f, B:282:0x04a3, B:273:0x047a] A[DONT_GENERATE, DONT_INLINE]
      0x047c: PHI (r25v9 java.lang.String) = (r25v6 java.lang.String), (r25v7 java.lang.String), (r25v10 java.lang.String) binds: [B:265:0x045f, B:282:0x04a3, B:273:0x047a] A[DONT_GENERATE, DONT_INLINE]
      0x047c: PHI (r27v9 java.lang.String) = (r27v6 java.lang.String), (r27v7 java.lang.String), (r27v10 java.lang.String) binds: [B:265:0x045f, B:282:0x04a3, B:273:0x047a] A[DONT_GENERATE, DONT_INLINE]
      0x047c: PHI (r37v9 int) = (r37v6 int), (r37v7 int), (r37v10 int) binds: [B:265:0x045f, B:282:0x04a3, B:273:0x047a] A[DONT_GENERATE, DONT_INLINE]
      0x047c: PHI (r38v9 java.lang.String) = (r38v6 java.lang.String), (r38v7 java.lang.String), (r38v10 java.lang.String) binds: [B:265:0x045f, B:282:0x04a3, B:273:0x047a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x04a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x04a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:478:0x04a6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E1(f9.i0 r67, p8.a r68, f9.w4 r69) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.t3.E1(f9.i0, p8.a, f9.w4):void");
    }

    public final void F1(e eVar) {
        boolean zT1;
        m1();
        n1();
        r1 r1Var = (r1) this.f307w;
        r1Var.getClass();
        p0 p0VarI = r1Var.i();
        r1 r1Var2 = (r1) p0VarI.f307w;
        r1.e(r1Var2.D);
        byte[] bArrR1 = u4.R1(eVar);
        if (bArrR1.length > 131072) {
            w0 w0Var = r1Var2.A;
            r1.g(w0Var);
            w0Var.C.a("Conditional user property too long for local database. Sending directly to service");
            zT1 = false;
        } else {
            zT1 = p0VarI.t1(2, bArrR1);
        }
        A1(new n3(this, C1(true), zT1, new e(eVar)));
    }

    @Override // f9.h0
    public final boolean p1() {
        return false;
    }

    public final void q1(AtomicReference atomicReference) {
        m1();
        n1();
        A1(new v1(this, atomicReference, C1(false)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r1(android.os.Bundle r8) {
        /*
            r7 = this;
            r7.m1()
            r7.n1()
            f9.u r4 = new f9.u
            r4.<init>(r8)
            r7.y1()
            java.lang.Object r0 = r7.f307w
            f9.r1 r0 = (f9.r1) r0
            f9.g r1 = r0.f4366y
            r2 = 0
            f9.e0 r3 = f9.f0.c1
            boolean r1 = r1.w1(r2, r3)
            r2 = 0
            if (r1 == 0) goto L59
            f9.p0 r0 = r0.i()
            java.lang.Object r1 = r0.f307w
            f9.r1 r1 = (f9.r1) r1
            f9.u4 r3 = r1.D
            f9.w0 r1 = r1.A
            f9.r1.e(r3)
            byte[] r3 = f9.u4.R1(r4)
            if (r3 != 0) goto L3f
            f9.r1.g(r1)
            f9.u0 r0 = r1.C
            java.lang.String r1 = "Null default event parameters; not writing to database"
            r0.a(r1)
        L3d:
            r0 = r2
            goto L54
        L3f:
            int r5 = r3.length
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r5 <= r6) goto L4f
            f9.r1.g(r1)
            f9.u0 r0 = r1.C
            java.lang.String r1 = "Default event parameters too long for local database. Sending directly to service"
            r0.a(r1)
            goto L3d
        L4f:
            r1 = 4
            boolean r0 = r0.t1(r1, r3)
        L54:
            if (r0 == 0) goto L59
            r0 = 1
            r3 = r0
            goto L5a
        L59:
            r3 = r2
        L5a:
            f9.w4 r2 = r7.C1(r2)
            f9.n2 r0 = new f9.n2
            r1 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r7.A1(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.t3.r1(android.os.Bundle):void");
    }

    public final void s1() {
        m1();
        n1();
        if (D1()) {
            return;
        }
        if (t1()) {
            this.f4419y.a();
            return;
        }
        r1 r1Var = (r1) this.f307w;
        if (r1Var.f4366y.p1()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = r1Var.f4363v.getPackageManager().queryIntentServices(new Intent().setClassName(r1Var.f4363v, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(r1Var.f4363v, "com.google.android.gms.measurement.AppMeasurementService"));
        s3 s3Var = this.f4419y;
        t3 t3Var = s3Var.f4402x;
        t3Var.m1();
        Context context = ((r1) t3Var.f307w).f4363v;
        r8.a aVarB = r8.a.b();
        synchronized (s3Var) {
            try {
                if (s3Var.f4400v) {
                    w0 w0Var2 = ((r1) s3Var.f4402x.f307w).A;
                    r1.g(w0Var2);
                    w0Var2.J.a("Connection attempt already in progress");
                } else {
                    t3 t3Var2 = s3Var.f4402x;
                    w0 w0Var3 = ((r1) t3Var2.f307w).A;
                    r1.g(w0Var3);
                    w0Var3.J.a("Using local app measurement service");
                    s3Var.f4400v = true;
                    aVarB.a(context, intent, t3Var2.f4419y, 129);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t1() {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.t3.t1():boolean");
    }

    public final void u1() {
        m1();
        n1();
        s3 s3Var = this.f4419y;
        if (s3Var.f4401w != null && (s3Var.f4401w.a() || s3Var.f4401w.e())) {
            s3Var.f4401w.i();
        }
        s3Var.f4401w = null;
        try {
            r8.a.b().c(((r1) this.f307w).f4363v, s3Var);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f4420z = null;
    }

    public final boolean v1() {
        m1();
        n1();
        if (!t1()) {
            return true;
        }
        u4 u4Var = ((r1) this.f307w).D;
        r1.e(u4Var);
        return u4Var.T1() >= ((Integer) f0.K0.a(null)).intValue();
    }

    public final boolean w1() {
        m1();
        n1();
        if (!t1()) {
            return true;
        }
        u4 u4Var = ((r1) this.f307w).D;
        r1.e(u4Var);
        return u4Var.T1() >= 241200;
    }

    public final void x1(ComponentName componentName) {
        m1();
        if (this.f4420z != null) {
            this.f4420z = null;
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.J.b(componentName, "Disconnected from device MeasurementService");
            m1();
            s1();
        }
    }

    public final void y1() {
        ((r1) this.f307w).getClass();
    }

    public final void z1() {
        m1();
        s0 s0Var = this.D;
        ((s8.a) s0Var.f4391x).getClass();
        s0Var.f4390w = SystemClock.elapsedRealtime();
        ((r1) this.f307w).getClass();
        this.B.b(((Long) f0.Z.a(null)).longValue());
    }
}
