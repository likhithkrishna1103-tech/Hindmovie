package ea;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.RemoteException;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k0;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import k8.b1;
import k8.g2;
import k8.g3;
import k8.h0;
import k8.k1;
import k8.w2;
import k8.x3;
import k8.y2;
import k8.z0;
import k8.z1;
import k8.z2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4630u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f4631v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f4632w;

    public /* synthetic */ t(int i) {
        this.f4630u = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f4631v
            com.google.android.gms.internal.measurement.w0 r0 = (com.google.android.gms.internal.measurement.w0) r0
            java.lang.Object r1 = r9.f4632w
            k8.g2 r1 = (k8.g2) r1
            k8.k3 r2 = r1.s1()
            java.lang.Object r1 = r1.f2454v
            k8.k1 r1 = (k8.k1) r1
            k8.z0 r3 = r2.n1()
            k8.z1 r3 = r3.z1()
            k8.y1 r4 = k8.y1.f7555w
            boolean r3 = r3.i(r4)
            r4 = 0
            if (r3 != 0) goto L2e
            k8.p0 r2 = r2.g()
            k8.r0 r2 = r2.F
            java.lang.String r3 = "Analytics storage consent denied; will not get session id"
            r2.d(r3)
        L2c:
            r2 = r4
            goto L64
        L2e:
            k8.z0 r3 = r2.n1()
            java.lang.Object r5 = r2.f2454v
            k8.k1 r5 = (k8.k1) r5
            x7.a r5 = r5.H
            r5.getClass()
            long r5 = java.lang.System.currentTimeMillis()
            boolean r3 = r3.u1(r5)
            if (r3 != 0) goto L2c
            k8.z0 r3 = r2.n1()
            a2.e2 r3 = r3.M
            long r5 = r3.c()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L56
            goto L2c
        L56:
            k8.z0 r2 = r2.n1()
            a2.e2 r2 = r2.M
            long r2 = r2.c()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
        L64:
            if (r2 == 0) goto L73
            k8.h4 r1 = r1.F
            k8.k1.d(r1)
            long r2 = r2.longValue()
            r1.K1(r0, r2)
            return
        L73:
            r0.h(r4)     // Catch: android.os.RemoteException -> L77
            return
        L77:
            r0 = move-exception
            k8.p0 r1 = r1.C
            k8.k1.f(r1)
            k8.r0 r1 = r1.A
            java.lang.String r2 = "getSessionId failed with exception"
            r1.c(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.t.a():void");
    }

    private final void b() {
        g2 g2Var = (g2) this.f4632w;
        k1 k1Var = (k1) g2Var.f2454v;
        z0 z0VarN1 = g2Var.n1();
        k8.o oVar = (k8.o) this.f4631v;
        z0VarN1.p1();
        z0VarN1.p1();
        k8.o oVarC = k8.o.c(z0VarN1.x1().getString("dma_consent_settings", null));
        int i = oVar.f7337a;
        if (!z1.h(i, oVarC.f7337a)) {
            g2Var.g().G.c(Integer.valueOf(i), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = z0VarN1.x1().edit();
        editorEdit.putString("dma_consent_settings", oVar.f7338b);
        editorEdit.apply();
        g2Var.g().I.c(oVar, "Setting DMA consent(FE)");
        z2 z2VarP = k1Var.p();
        z2VarP.p1();
        z2VarP.t1();
        if (z2VarP.F1() && z2VarP.o1().t2() < 241200) {
            k1Var.p().A1(false);
            return;
        }
        z2 z2VarP2 = k1Var.p();
        z2VarP2.p1();
        z2VarP2.t1();
        y2 y2Var = new y2(1);
        y2Var.f7561v = z2VarP2;
        z2VarP2.w1(y2Var);
    }

    private final void c() {
        g2 g2Var = ((AppMeasurementDynamiteService) this.f4632w).f3299d.J;
        k1.e(g2Var);
        h4.z zVar = (h4.z) this.f4631v;
        g2Var.p1();
        g2Var.t1();
        h4.z zVar2 = g2Var.f7213y;
        if (zVar != zVar2) {
            t7.v.j("EventInterceptor already set.", zVar2 == null);
        }
        g2Var.f7213y = zVar;
    }

    private final void d() {
        z2 z2Var = (z2) this.f4632w;
        h0 h0Var = z2Var.f7573y;
        if (h0Var == null) {
            z2Var.g().A.d("Failed to send current screen to service");
            return;
        }
        try {
            w2 w2Var = (w2) this.f4631v;
            if (w2Var == null) {
                h0Var.C(0L, null, null, ((k1) z2Var.f2454v).f7282u.getPackageName());
            } else {
                h0Var.C(w2Var.f7528c, w2Var.f7526a, w2Var.f7527b, ((k1) z2Var.f2454v).f7282u.getPackageName());
            }
            z2Var.H1();
        } catch (RemoteException e10) {
            z2Var.g().A.c(e10, "Failed to send current screen to the service");
        }
    }

    private final void e() {
        z2 z2Var = ((g3) this.f4632w).f7217w;
        ComponentName componentName = (ComponentName) this.f4631v;
        z2Var.p1();
        if (z2Var.f7573y != null) {
            z2Var.f7573y = null;
            z2Var.g().I.c(componentName, "Disconnected from device MeasurementService");
            z2Var.p1();
            z2Var.B1();
        }
    }

    private final void f() {
        x3 x3Var = (x3) this.f4631v;
        x3Var.d0();
        Runnable runnable = (Runnable) this.f4632w;
        x3Var.x().p1();
        if (x3Var.J == null) {
            x3Var.J = new ArrayList();
        }
        x3Var.J.add(runnable);
        x3Var.f0();
    }

    private final void g() {
        wb.c cVar = (wb.c) this.f4631v;
        Typeface typeface = (Typeface) this.f4632w;
        h0.b bVar = (h0.b) cVar.f14088v;
        if (bVar != null) {
            bVar.i(typeface);
        }
    }

    private final void h() {
        if (((o8.o) this.f4631v).f9442d) {
            ((o8.l) this.f4632w).f9434x.n();
            return;
        }
        try {
            ((o8.l) this.f4632w).f9434x.m(((o8.l) this.f4632w).f9433w.b((o8.o) this.f4631v));
        } catch (o8.f e10) {
            if (e10.getCause() instanceof Exception) {
                ((o8.l) this.f4632w).f9434x.l((Exception) e10.getCause());
            } else {
                ((o8.l) this.f4632w).f9434x.l(e10);
            }
        } catch (Exception e11) {
            ((o8.l) this.f4632w).f9434x.l(e11);
        }
    }

    private final void i() {
        o8.l lVar = (o8.l) this.f4632w;
        o8.o oVar = lVar.f9434x;
        try {
            o8.o oVar2 = (o8.o) lVar.f9433w.b((o8.o) this.f4631v);
            if (oVar2 == null) {
                lVar.t(new NullPointerException("Continuation returned null"));
                return;
            }
            h.p pVar = o8.i.f9423b;
            oVar2.d(pVar, lVar);
            oVar2.c(pVar, lVar);
            oVar2.a(pVar, lVar);
        } catch (o8.f e10) {
            if (e10.getCause() instanceof Exception) {
                oVar.l((Exception) e10.getCause());
            } else {
                oVar.l(e10);
            }
        } catch (Exception e11) {
            oVar.l(e11);
        }
    }

    private final void j() {
        synchronized (((o8.m) this.f4632w).f9437w) {
            ((o8.c) ((o8.m) this.f4632w).f9438x).A((o8.o) this.f4631v);
        }
    }

    private final void k() {
        synchronized (((o8.m) this.f4632w).f9437w) {
            o8.d dVar = (o8.d) ((o8.m) this.f4632w).f9438x;
            Exception excG = ((o8.o) this.f4631v).g();
            t7.v.h(excG);
            dVar.t(excG);
        }
    }

    private final void l() {
        synchronized (((o8.m) this.f4632w).f9437w) {
            ((o8.e) ((o8.m) this.f4632w).f9438x).c(((o8.o) this.f4631v).h());
        }
    }

    private final void m() {
        o8.m mVar = (o8.m) this.f4632w;
        try {
            o8.o oVarR = ((o8.g) mVar.f9437w).r(((o8.o) this.f4631v).h());
            if (oVarR == null) {
                mVar.t(new NullPointerException("Continuation returned null"));
                return;
            }
            h.p pVar = o8.i.f9423b;
            oVarR.d(pVar, mVar);
            oVarR.c(pVar, mVar);
            oVarR.a(pVar, mVar);
        } catch (CancellationException unused) {
            mVar.h();
        } catch (o8.f e10) {
            if (e10.getCause() instanceof Exception) {
                mVar.t((Exception) e10.getCause());
            } else {
                mVar.t(e10);
            }
        } catch (Exception e11) {
            mVar.t(e11);
        }
    }

    private final void n() {
        o8.o oVar = (o8.o) this.f4631v;
        try {
            oVar.m(((Callable) this.f4632w).call());
        } catch (Exception e10) {
            oVar.l(e10);
        } catch (Throwable th) {
            oVar.l(new RuntimeException(th));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        ((java.lang.Runnable) r10.f4631v).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        oa.i.f9471z.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f4631v), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        r10.f4631v = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.f4632w     // Catch: java.lang.Throwable -> L58
            oa.i r2 = (oa.i) r2     // Catch: java.lang.Throwable -> L58
            java.util.ArrayDeque r2 = r2.f9473v     // Catch: java.lang.Throwable -> L58
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L58
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.f4632w     // Catch: java.lang.Throwable -> L20
            oa.i r0 = (oa.i) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.f9474w     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
        L18:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L46
        L20:
            r0 = move-exception
            goto L7d
        L22:
            long r6 = r0.f9475x     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.f9475x = r6     // Catch: java.lang.Throwable -> L20
            r0.f9474w = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.f4632w     // Catch: java.lang.Throwable -> L20
            oa.i r4 = (oa.i) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.f9473v     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            r10.f4631v = r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L47
            java.lang.Object r0 = r10.f4632w     // Catch: java.lang.Throwable -> L20
            oa.i r0 = (oa.i) r0     // Catch: java.lang.Throwable -> L20
            r0.f9474w = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
            goto L18
        L46:
            return
        L47:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L58
            r1 = r1 | r2
            r2 = 0
            java.lang.Object r3 = r10.f4631v     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
        L55:
            r10.f4631v = r2     // Catch: java.lang.Throwable -> L58
            goto L2
        L58:
            r0 = move-exception
            goto L7f
        L5a:
            r0 = move-exception
            goto L7a
        L5c:
            r3 = move-exception
            java.util.logging.Logger r4 = oa.i.f9471z     // Catch: java.lang.Throwable -> L5a
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r6.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = "Exception while executing runnable "
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r7 = r10.f4631v     // Catch: java.lang.Throwable -> L5a
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L5a
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5a
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
            goto L55
        L7a:
            r10.f4631v = r2     // Catch: java.lang.Throwable -> L58
            throw r0     // Catch: java.lang.Throwable -> L58
        L7d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r0     // Catch: java.lang.Throwable -> L58
        L7f:
            if (r1 == 0) goto L88
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L88:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.t.o():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03d4 A[Catch: IllegalStateException -> 0x03f4, TryCatch #4 {IllegalStateException -> 0x03f4, blocks: (B:149:0x03a5, B:153:0x03b8, B:157:0x03c4, B:161:0x03cc, B:163:0x03d4, B:167:0x03e5, B:171:0x03f1, B:170:0x03ed, B:166:0x03e1, B:175:0x03f8, B:177:0x040a, B:179:0x040f, B:178:0x040d, B:156:0x03c0, B:152:0x03b4), top: B:501:0x03a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03f8 A[Catch: IllegalStateException -> 0x03f4, TryCatch #4 {IllegalStateException -> 0x03f4, blocks: (B:149:0x03a5, B:153:0x03b8, B:157:0x03c4, B:161:0x03cc, B:163:0x03d4, B:167:0x03e5, B:171:0x03f1, B:170:0x03ed, B:166:0x03e1, B:175:0x03f8, B:177:0x040a, B:179:0x040f, B:178:0x040d, B:156:0x03c0, B:152:0x03b4), top: B:501:0x03a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x074a  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x07a4  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x07f7  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x080b  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x08a0  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x08c6  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0a06  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0a7a  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0c76  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0456 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0759 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a3 A[PHI: r4
      0x01a3: PHI (r4v10 long) = (r4v9 long), (r4v71 long) binds: [B:81:0x018b, B:83:0x0193] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 3304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.t.run():void");
    }

    public String toString() {
        switch (this.f4630u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                kc.b bVar = new kc.b(t.class.getSimpleName());
                s sVar = (s) this.f4632w;
                p2.c cVar = new p2.c(26, false);
                ((p2.c) bVar.f7622x).f10131w = cVar;
                bVar.f7622x = cVar;
                cVar.f10130v = sVar;
                return bVar.toString();
            case 29:
                Runnable runnable = (Runnable) this.f4631v;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb2 = new StringBuilder("SequentialExecutorWorker{state=");
                int i = ((oa.i) this.f4632w).f9474w;
                sb2.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb2.append("}");
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ t(int i, Object obj, Object obj2, boolean z2) {
        this.f4630u = i;
        this.f4632w = obj;
        this.f4631v = obj2;
    }

    public /* synthetic */ t(Object obj, int i, Object obj2) {
        this.f4630u = i;
        this.f4631v = obj;
        this.f4632w = obj2;
    }

    public t(b1 b1Var, k0 k0Var, b1 b1Var2) {
        this.f4630u = 8;
        this.f4631v = k0Var;
        this.f4632w = b1Var;
    }

    public t(androidx.fragment.app.j jVar, ArrayList arrayList, androidx.fragment.app.z0 z0Var) {
        this.f4630u = 1;
        this.f4631v = arrayList;
        this.f4632w = z0Var;
    }

    public t(oa.i iVar) {
        this.f4630u = 29;
        this.f4632w = iVar;
    }
}
