package ya;

import android.app.Application;
import android.app.Service;
import android.app.job.JobParameters;
import android.os.RemoteException;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.l0;
import f9.f0;
import f9.f3;
import f9.g1;
import f9.i0;
import f9.q4;
import f9.r1;
import f9.s3;
import f9.t3;
import f9.w0;
import f9.w3;
import f9.x2;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f15011v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f15012w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f15013x;

    public /* synthetic */ s(int i, Object obj, Object obj2) {
        this.f15011v = i;
        this.f15012w = obj;
        this.f15013x = obj2;
    }

    private final void a() {
        t3 t3Var = (t3) this.f15013x;
        i0 i0Var = t3Var.f4420z;
        r1 r1Var = (r1) t3Var.f307w;
        if (i0Var == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.a("Failed to send current screen to service");
            return;
        }
        try {
            f3 f3Var = (f3) this.f15012w;
            if (f3Var == null) {
                i0Var.w(0L, null, null, r1Var.f4363v.getPackageName());
            } else {
                i0Var.w(f3Var.f4177c, f3Var.f4175a, f3Var.f4176b, r1Var.f4363v.getPackageName());
            }
            t3Var.z1();
        } catch (RemoteException e9) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.b(e9, "Failed to send current screen to the service");
        }
    }

    private final void b() {
        t3 t3Var = ((s3) this.f15013x).f4402x;
        t3Var.f4420z = null;
        if (((l8.b) this.f15012w).f7878w != 7777) {
            t3Var.B1();
            return;
        }
        if (t3Var.C == null) {
            t3Var.C = Executors.newScheduledThreadPool(1);
        }
        t3Var.C.schedule(new androidx.fragment.app.m(7, this), ((Long) f0.f4109a0.a(null)).longValue(), TimeUnit.MILLISECONDS);
    }

    private final /* synthetic */ void c() {
        pc.c cVar = (pc.c) this.f15012w;
        JobParameters jobParameters = (JobParameters) this.f15013x;
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((w3) ((Service) cVar.f10180v)).c(jobParameters);
    }

    private final void d() {
        ((Application) this.f15012w).unregisterActivityLifecycleCallbacks((h0.a) this.f15013x);
    }

    private final void e() {
        Object obj = this.f15012w;
        try {
            Method method = h0.b.f5433d;
            Object obj2 = this.f15013x;
            if (method != null) {
                method.invoke(obj, obj2, Boolean.FALSE, "AppCompat recreation");
            } else {
                h0.b.f5434e.invoke(obj, obj2, Boolean.FALSE);
            }
        } catch (RuntimeException e9) {
            if (e9.getClass() == RuntimeException.class && e9.getMessage() != null && e9.getMessage().startsWith("Unable to stop")) {
                throw e9;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }

    private final void f() {
        try {
            n();
        } catch (Error e9) {
            synchronized (((ib.j) this.f15013x).f6407w) {
                ((ib.j) this.f15013x).f6408x = 1;
                throw e9;
            }
        }
    }

    private final void g() {
        j9.p pVar = (j9.p) this.f15012w;
        if (pVar.f6709d) {
            ((j9.m) this.f15013x).f6701y.o();
            return;
        }
        try {
            ((j9.m) this.f15013x).f6701y.l(((j9.m) this.f15013x).f6700x.c(pVar));
        } catch (j9.g e9) {
            if (!(e9.getCause() instanceof Exception)) {
                ((j9.m) this.f15013x).f6701y.n(e9);
                return;
            }
            j9.m mVar = (j9.m) this.f15013x;
            mVar.f6701y.n((Exception) e9.getCause());
        } catch (Exception e10) {
            ((j9.m) this.f15013x).f6701y.n(e10);
        }
    }

    private final void h() {
        j9.m mVar = (j9.m) this.f15013x;
        try {
            j9.p pVar = (j9.p) mVar.f6700x.c((j9.p) this.f15012w);
            if (pVar == null) {
                mVar.y(new NullPointerException("Continuation returned null"));
                return;
            }
            eb.d dVar = j9.j.f6690b;
            pVar.d(dVar, mVar);
            pVar.c(dVar, mVar);
            pVar.a(dVar, mVar);
        } catch (j9.g e9) {
            if (!(e9.getCause() instanceof Exception)) {
                mVar.f6701y.n(e9);
            } else {
                mVar.f6701y.n((Exception) e9.getCause());
            }
        } catch (Exception e10) {
            mVar.f6701y.n(e10);
        }
    }

    private final void i() {
        j9.n nVar = (j9.n) this.f15013x;
        synchronized (nVar.f6704x) {
            ((j9.d) nVar.f6705y).A((j9.p) this.f15012w);
        }
    }

    private final void j() {
        j9.n nVar = (j9.n) this.f15013x;
        synchronized (nVar.f6704x) {
            try {
                j9.e eVar = (j9.e) nVar.f6705y;
                if (eVar != null) {
                    Exception excG = ((j9.p) this.f15012w).g();
                    o8.u.g(excG);
                    eVar.y(excG);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void k() {
        j9.n nVar = (j9.n) this.f15013x;
        synchronized (nVar.f6704x) {
            try {
                j9.f fVar = (j9.f) nVar.f6705y;
                if (fVar != null) {
                    fVar.a(((j9.p) this.f15012w).h());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void l() {
        j9.n nVar = (j9.n) this.f15013x;
        try {
            j9.p pVarB = ((j9.h) nVar.f6704x).B(((j9.p) this.f15012w).h());
            if (pVarB == null) {
                nVar.y(new NullPointerException("Continuation returned null"));
                return;
            }
            eb.d dVar = j9.j.f6690b;
            pVarB.d(dVar, nVar);
            pVarB.c(dVar, nVar);
            pVarB.a(dVar, nVar);
        } catch (j9.g e9) {
            if (e9.getCause() instanceof Exception) {
                nVar.y((Exception) e9.getCause());
            } else {
                nVar.y(e9);
            }
        } catch (CancellationException unused) {
            nVar.b();
        } catch (Exception e10) {
            nVar.y(e10);
        }
    }

    private final void m() {
        j9.p pVar = (j9.p) this.f15012w;
        try {
            pVar.l(((Callable) this.f15013x).call());
        } catch (Exception e9) {
            pVar.n(e9);
        } catch (Throwable th) {
            pVar.n(new RuntimeException(th));
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
    
        ((java.lang.Runnable) r10.f15012w).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        ib.j.A.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f15012w), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        r10.f15012w = null;
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
    public void n() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.f15013x     // Catch: java.lang.Throwable -> L58
            ib.j r2 = (ib.j) r2     // Catch: java.lang.Throwable -> L58
            java.util.ArrayDeque r2 = r2.f6407w     // Catch: java.lang.Throwable -> L58
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L58
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.f15013x     // Catch: java.lang.Throwable -> L20
            ib.j r0 = (ib.j) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.f6408x     // Catch: java.lang.Throwable -> L20
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
            long r6 = r0.f6409y     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.f6409y = r6     // Catch: java.lang.Throwable -> L20
            r0.f6408x = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.f15013x     // Catch: java.lang.Throwable -> L20
            ib.j r4 = (ib.j) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.f6407w     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            r10.f15012w = r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L47
            java.lang.Object r0 = r10.f15013x     // Catch: java.lang.Throwable -> L20
            ib.j r0 = (ib.j) r0     // Catch: java.lang.Throwable -> L20
            r0.f6408x = r3     // Catch: java.lang.Throwable -> L20
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
            java.lang.Object r3 = r10.f15012w     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
        L55:
            r10.f15012w = r2     // Catch: java.lang.Throwable -> L58
            goto L2
        L58:
            r0 = move-exception
            goto L7f
        L5a:
            r0 = move-exception
            goto L7a
        L5c:
            r3 = move-exception
            java.util.logging.Logger r4 = ib.j.A     // Catch: java.lang.Throwable -> L5a
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r6.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = "Exception while executing runnable "
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r7 = r10.f15012w     // Catch: java.lang.Throwable -> L5a
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L5a
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5a
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
            goto L55
        L7a:
            r10.f15012w = r2     // Catch: java.lang.Throwable -> L58
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
        throw new UnsupportedOperationException("Method not decompiled: ya.s.n():void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:148|(1:150)(9:153|480|154|155|(1:158)(5:160|(1:162)|492|163|(23:165|(1:167)(1:169)|490|170|497|171|172|176|(2:178|(2:180|(2:182|(2:184|(2:186|(2:188|(1:190)(1:191))(1:192))(1:193))(1:194))(1:195))(1:196))(1:197)|198|486|199|(1:201)(1:202)|203|(1:205)|209|(1:211)(7:213|(0)(1:216)|(3:488|218|(1:220)(1:221))|(2:227|(1:229)(4:230|(3:233|(1:515)(1:516)|231)|514|236))(1:236)|(1:238)(1:239)|240|(30:242|(1:244)(1:245)|246|(1:248)|249|(1:251)(1:252)|253|(2:255|(4:260|(1:262)(2:263|(1:265)(1:266))|267|(1:269))(1:(5:259|260|(0)(0)|267|(0))(1:270)))(0)|271|(21:274|276|(1:278)|279|(1:295)(1:296)|297|(1:299)|300|(2:305|(2:311|(2:318|(2:319|(1:511)(2:321|(2:512|323)(1:513)))))(1:310))(1:304)|324|(3:328|(1:330)|331)|332|(1:334)|335|(1:339)|340|(3:342|(7:344|(1:346)(1:347)|348|(1:350)|351|(4:355|(1:357)|358|(1:360))|361)(1:363)|362)(10:364|(2:366|(2:379|380)(3:369|(5:371|(1:373)(1:374)|375|(1:377)|378)(0)|380))(1:381)|382|(1:384)|385|501|386|387|391|(5:393|(1:395)(1:396)|(1:400)|(1:402)|403))|404|(3:406|(1:408)(1:409)|(5:411|(1:413)|414|(1:416)|417))|418|419)(1:275)|280|(1:(1:291)(19:290|279|(0)(0)|297|(0)|300|(3:302|305|(3:308|311|(4:314|316|318|(3:319|(0)(0)|513)))(0))(0)|324|(4:326|328|(0)|331)(0)|332|(0)|335|(2:337|339)|340|(0)(0)|404|(0)|418|419))(1:293)|292|(0)(0)|297|(0)|300|(0)(0)|324|(0)(0)|332|(0)|335|(0)|340|(0)(0)|404|(0)|418|419)(2:420|421))|212|(0)|(0)(0)|(0)(0)|240|(0)(0)))|159|492|163|(0))|151|152|176|(0)(0)|198|486|199|(0)(0)|203|(0)|209|(0)(0)|212|(0)|(0)(0)|(0)(0)|240|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:153|480|154|155|(1:158)(5:160|(1:162)|492|163|(23:165|(1:167)(1:169)|490|170|497|171|172|176|(2:178|(2:180|(2:182|(2:184|(2:186|(2:188|(1:190)(1:191))(1:192))(1:193))(1:194))(1:195))(1:196))(1:197)|198|486|199|(1:201)(1:202)|203|(1:205)|209|(1:211)(7:213|(0)(1:216)|(3:488|218|(1:220)(1:221))|(2:227|(1:229)(4:230|(3:233|(1:515)(1:516)|231)|514|236))(1:236)|(1:238)(1:239)|240|(30:242|(1:244)(1:245)|246|(1:248)|249|(1:251)(1:252)|253|(2:255|(4:260|(1:262)(2:263|(1:265)(1:266))|267|(1:269))(1:(5:259|260|(0)(0)|267|(0))(1:270)))(0)|271|(21:274|276|(1:278)|279|(1:295)(1:296)|297|(1:299)|300|(2:305|(2:311|(2:318|(2:319|(1:511)(2:321|(2:512|323)(1:513)))))(1:310))(1:304)|324|(3:328|(1:330)|331)|332|(1:334)|335|(1:339)|340|(3:342|(7:344|(1:346)(1:347)|348|(1:350)|351|(4:355|(1:357)|358|(1:360))|361)(1:363)|362)(10:364|(2:366|(2:379|380)(3:369|(5:371|(1:373)(1:374)|375|(1:377)|378)(0)|380))(1:381)|382|(1:384)|385|501|386|387|391|(5:393|(1:395)(1:396)|(1:400)|(1:402)|403))|404|(3:406|(1:408)(1:409)|(5:411|(1:413)|414|(1:416)|417))|418|419)(1:275)|280|(1:(1:291)(19:290|279|(0)(0)|297|(0)|300|(3:302|305|(3:308|311|(4:314|316|318|(3:319|(0)(0)|513)))(0))(0)|324|(4:326|328|(0)|331)(0)|332|(0)|335|(2:337|339)|340|(0)(0)|404|(0)|418|419))(1:293)|292|(0)(0)|297|(0)|300|(0)(0)|324|(0)(0)|332|(0)|335|(0)|340|(0)(0)|404|(0)|418|419)(2:420|421))|212|(0)|(0)(0)|(0)(0)|240|(0)(0)))|159|492|163|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0480, code lost:
    
        r9 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0543, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0544, code lost:
    
        f9.r1.g(r10);
        r10.B.c(f9.w0.u1(r2), r0, "Fetching Google App Id failed with exception. appId");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x045b A[Catch: NameNotFoundException -> 0x0480, TryCatch #9 {NameNotFoundException -> 0x0480, blocks: (B:163:0x0450, B:165:0x045b, B:167:0x0467), top: B:492:0x0450 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0534 A[Catch: IllegalStateException -> 0x0543, TRY_LEAVE, TryCatch #5 {IllegalStateException -> 0x0543, blocks: (B:199:0x0522, B:203:0x0530, B:205:0x0534), top: B:486:0x0522 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0719  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x07fd  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x081c  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0872  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0889  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x088f  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x08ad  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x08da  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x097d  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0a25  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0a97  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0aeb  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0b56  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0c9b  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x026c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0585 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0881 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v94, types: [f9.w2] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 3318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.s.run():void");
    }

    public String toString() {
        switch (this.f15011v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l7.a aVar = new l7.a(s.class.getSimpleName());
                r rVar = (r) this.f15013x;
                nb.w wVar = new nb.w(22, false);
                ((nb.w) aVar.f7868y).f9017x = wVar;
                aVar.f7868y = wVar;
                wVar.f9016w = rVar;
                return aVar.toString();
            case 21:
                Runnable runnable = (Runnable) this.f15012w;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i = ((ib.j) this.f15013x).f6408x;
                sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ s(int i, Object obj, Object obj2, boolean z10) {
        this.f15011v = i;
        this.f15013x = obj;
        this.f15012w = obj2;
    }

    public s(g1 g1Var, com.google.android.gms.internal.measurement.b0 b0Var, g1 g1Var2) {
        this.f15011v = 4;
        this.f15012w = b0Var;
        this.f15013x = g1Var;
    }

    public s(x2 x2Var, l0 l0Var) {
        this.f15011v = 7;
        this.f15012w = l0Var;
        Objects.requireNonNull(x2Var);
        this.f15013x = x2Var;
    }

    public s(t3 t3Var, f3 f3Var) {
        this.f15011v = 13;
        this.f15012w = f3Var;
        Objects.requireNonNull(t3Var);
        this.f15013x = t3Var;
    }

    public s(pc.c cVar, q4 q4Var, Runnable runnable) {
        this.f15011v = 16;
        this.f15012w = q4Var;
        this.f15013x = runnable;
    }

    public s(ib.j jVar) {
        this.f15011v = 21;
        this.f15013x = jVar;
    }
}
