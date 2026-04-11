package androidx.fragment.app;

import a2.e2;
import android.animation.ValueAnimator;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import g4.l1;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.WeakHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import k8.d1;
import k8.d3;
import k8.g2;
import k8.h4;
import k8.i4;
import k8.j3;
import k8.k1;
import k8.k3;
import k8.n1;
import k8.n3;
import k8.o3;
import k8.p3;
import k8.s3;
import k8.x3;
import k8.z2;
import n.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1265u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f1266v;

    public /* synthetic */ e(int i) {
        this.f1265u = i;
    }

    private final void a() {
        n8.a aVar = (n8.a) this.f1266v;
        synchronized (aVar.f8841a) {
            try {
                if (aVar.b()) {
                    Log.e("WakeLock", String.valueOf(aVar.f8848j).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    aVar.d();
                    if (aVar.b()) {
                        aVar.f8843c = 1;
                        aVar.e();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        synchronized (((o8.m) this.f1266v).f9437w) {
            ((o8.b) ((o8.m) this.f1266v).f9438x).h();
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
        View viewF;
        int width;
        xe.a aVarC;
        long jNanoTime;
        int i = 2;
        int i10 = 1;
        switch (this.f1265u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f fVar = (f) this.f1266v;
                fVar.f1270b.endViewTransition(fVar.f1271c);
                fVar.f1272d.d();
                return;
            case 1:
                n nVar = (n) this.f1266v;
                nVar.f1304u0.onDismiss(nVar.C0);
                return;
            case 2:
                ((n0) this.f1266v).x(true);
                return;
            case 3:
                com.bumptech.glide.m mVar = (com.bumptech.glide.m) this.f1266v;
                mVar.f2826w.b(mVar);
                return;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                e1.f fVar2 = (e1.f) this.f1266v;
                DrawerLayout drawerLayout = fVar2.f4289d;
                int i11 = fVar2.f4287b.f14449o;
                int i12 = fVar2.f4286a;
                boolean z2 = i12 == 3;
                if (z2) {
                    viewF = drawerLayout.f(3);
                    width = (viewF != null ? -viewF.getWidth() : 0) + i11;
                } else {
                    viewF = drawerLayout.f(5);
                    width = drawerLayout.getWidth() - i11;
                }
                if (viewF != null) {
                    if (((!z2 || viewF.getLeft() >= width) && (z2 || viewF.getLeft() <= width)) || drawerLayout.i(viewF) != 0) {
                        return;
                    }
                    e1.d dVar = (e1.d) viewF.getLayoutParams();
                    fVar2.f4287b.s(viewF, width, viewF.getTop());
                    dVar.f4280c = true;
                    drawerLayout.invalidate();
                    View viewF2 = drawerLayout.f(i12 == 3 ? 5 : 3);
                    if (viewF2 != null) {
                        drawerLayout.c(viewF2, true);
                    }
                    if (drawerLayout.L) {
                        return;
                    }
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i13 = 0; i13 < childCount; i13++) {
                        drawerLayout.getChildAt(i13).dispatchTouchEvent(motionEventObtain);
                    }
                    motionEventObtain.recycle();
                    drawerLayout.L = true;
                    return;
                }
                return;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                a7.b bVar = (a7.b) this.f1266v;
                bVar.getClass();
                while (true) {
                    try {
                        bVar.n((e6.b) ((ReferenceQueue) bVar.f619w).remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                h.i0 i0Var = (h.i0) this.f1266v;
                Window.Callback callback = i0Var.f5503d;
                Menu menuB0 = i0Var.b0();
                m.k kVar = menuB0 instanceof m.k ? (m.k) menuB0 : null;
                if (kVar != null) {
                    kVar.y();
                }
                try {
                    menuB0.clear();
                    if (!callback.onCreatePanelMenu(0, menuB0) || !callback.onPreparePanel(0, null, menuB0)) {
                        menuB0.clear();
                        break;
                    }
                    if (kVar != null) {
                        kVar.x();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (kVar != null) {
                        kVar.x();
                    }
                    throw th;
                }
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                j.e eVar = (j.e) this.f1266v;
                eVar.a(true);
                eVar.invalidateSelf();
                return;
            case 8:
                k5.i iVar = (k5.i) this.f1266v;
                iVar.setScrollState(0);
                iVar.p();
                return;
            case 9:
                ((k8.w0) this.f1266v).f7523a.G();
                return;
            case 10:
                n3 n3Var = (n3) this.f1266v;
                k4 k4Var = n3Var.f7336w;
                long j5 = n3Var.f7334u;
                long j8 = n3Var.f7335v;
                ((k3) k4Var.f3071v).p1();
                k3 k3Var = (k3) k4Var.f3071v;
                o3 o3Var = k3Var.A;
                k3Var.g().H.d("Application going to the background");
                k3Var.n1().O.a(true);
                k3Var.p1();
                k3Var.f7290y = true;
                k1 k1Var = (k1) k3Var.f2454v;
                if (!k1Var.A.C1()) {
                    if (k1Var.A.A1(null, k8.w.P0)) {
                        o3Var.a(j8, false, false);
                        ((p3) o3Var.f7358w).a();
                    } else {
                        ((p3) o3Var.f7358w).a();
                        o3Var.a(j8, false, false);
                    }
                }
                k3Var.g().G.c(Long.valueOf(j5), "Application backgrounded at: timestamp_millis");
                k8.e eVar2 = k1Var.A;
                k8.f0 f0Var = k8.w.f7473d1;
                if (eVar2.A1(null, f0Var)) {
                    g2 g2VarQ1 = k3Var.q1();
                    g2VarQ1.p1();
                    g2VarQ1.t1();
                    k1 k1Var2 = (k1) g2VarQ1.f2454v;
                    if (k1Var2.A.A1(null, f0Var)) {
                        z2 z2VarP = k1Var2.p();
                        z2VarP.p1();
                        z2VarP.t1();
                        if (z2VarP.F1() && z2VarP.o1().t2() < 242600) {
                            return;
                        }
                        z2 z2VarP2 = k1Var2.p();
                        z2VarP2.p1();
                        z2VarP2.t1();
                        z2VarP2.w1(new d3(z2VarP2, z2VarP2.I1(true), i));
                        return;
                    }
                    return;
                }
                return;
            case 11:
                x3 x3Var = (x3) this.f1266v;
                x3Var.x().p1();
                x3Var.E = new k8.a1(x3Var);
                k8.i iVar2 = new k8.i(x3Var);
                iVar2.u1();
                x3Var.f7546w = iVar2;
                k8.e eVarS = x3Var.S();
                d1 d1Var = x3Var.f7544u;
                t7.v.h(d1Var);
                eVarS.f7146y = d1Var;
                j3 j3Var = new j3(x3Var);
                j3Var.u1();
                x3Var.C = j3Var;
                i4 i4Var = new i4(x3Var);
                i4Var.u1();
                x3Var.f7549z = i4Var;
                k8.s0 s0Var = new k8.s0(x3Var, i10);
                s0Var.u1();
                x3Var.B = s0Var;
                s3 s3Var = new s3(x3Var);
                s3Var.u1();
                x3Var.f7548y = s3Var;
                x3Var.f7547x = new k8.w0(x3Var);
                if (x3Var.L != x3Var.M) {
                    x3Var.g().A.b(Integer.valueOf(x3Var.L), Integer.valueOf(x3Var.M), "Not all upload components initialized");
                }
                x3Var.G = true;
                x3Var.x().p1();
                k8.i iVar3 = x3Var.f7546w;
                x3.y(iVar3);
                iVar3.B2();
                k8.i iVar4 = x3Var.f7546w;
                x3.y(iVar4);
                iVar4.p1();
                iVar4.t1();
                if (iVar4.b2()) {
                    k8.f0 f0Var2 = k8.w.f7485i0;
                    if (((Long) f0Var2.a(null)).longValue() != 0) {
                        SQLiteDatabase sQLiteDatabaseW1 = iVar4.w1();
                        ((k1) iVar4.f2454v).H.getClass();
                        int iDelete = sQLiteDatabaseW1.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(f0Var2.a(null))});
                        if (iDelete > 0) {
                            iVar4.g().I.c(Integer.valueOf(iDelete), "Deleted stale trigger uris. rowsDeleted");
                        }
                    }
                }
                if (x3Var.C.C.c() == 0) {
                    e2 e2Var = x3Var.C.C;
                    x3Var.y0().getClass();
                    e2Var.d(System.currentTimeMillis());
                }
                x3Var.G();
                return;
            case 12:
                k1 k1Var3 = (k1) this.f1266v;
                h4 h4Var = k1Var3.F;
                k1.d(h4Var);
                h4Var.p1();
                if (h4Var.y2() != 1) {
                    k8.p0 p0Var = k1Var3.C;
                    k1.f(p0Var);
                    p0Var.D.d("registerTrigger called but app not eligible");
                    return;
                } else {
                    g2 g2Var = k1Var3.J;
                    k1.e(g2Var);
                    n1 n1Var = new n1(i);
                    n1Var.f7330v = g2Var;
                    new Thread(n1Var).start();
                    return;
                }
            case 13:
                t1 t1Var = (t1) this.f1266v;
                t1Var.F = null;
                t1Var.drawableStateChanged();
                return;
            case 14:
                ((Toolbar) this.f1266v).v();
                return;
            case 15:
                a();
                return;
            case 16:
                nc.e eVar3 = (nc.e) this.f1266v;
                int i14 = eVar3.f8928x0;
                if (i14 <= 0) {
                    ((AppCompatButton) eVar3.f8922r0.f12870x).setText("X");
                    ((AppCompatButton) eVar3.f8922r0.f12870x).setEnabled(true);
                    return;
                } else {
                    ((AppCompatButton) eVar3.f8922r0.f12870x).setText(String.valueOf(i14));
                    eVar3.f8928x0--;
                    eVar3.f8927w0.postDelayed(this, 1000L);
                    return;
                }
            case 17:
                b();
                return;
            case 18:
                if (((o8.h) this.f1266v).b(new IOException("TIMEOUT"))) {
                    Log.w("Rpc", "No response");
                    return;
                }
                return;
            case 19:
                q4.j jVar = (q4.j) this.f1266v;
                ValueAnimator valueAnimator = jVar.f10858z;
                int i15 = jVar.A;
                if (i15 == 1) {
                    valueAnimator.cancel();
                } else if (i15 != 2) {
                    return;
                }
                jVar.A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            case 20:
                ((StaggeredGridLayoutManager) this.f1266v).E0();
                return;
            case 21:
                ((s2.k) this.f1266v).f();
                return;
            case 22:
                ((s7.j) this.f1266v).h();
                return;
            case 23:
                r7.a aVar = ((s7.j) ((n.a1) this.f1266v).f8343u).f11891e;
                aVar.d(aVar.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 24:
                throw null;
            case 25:
                u0.d dVar2 = (u0.d) this.f1266v;
                t1 t1Var2 = dVar2.f12533w;
                u0.a aVar2 = dVar2.f12531u;
                if (dVar2.I) {
                    if (dVar2.G) {
                        dVar2.G = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar2.f12528e = jCurrentAnimationTimeMillis;
                        aVar2.f12529g = -1L;
                        aVar2.f = jCurrentAnimationTimeMillis;
                        aVar2.f12530h = 0.5f;
                    }
                    if ((aVar2.f12529g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar2.f12529g + ((long) aVar2.i)) || !dVar2.e()) {
                        dVar2.I = false;
                        return;
                    }
                    if (dVar2.H) {
                        dVar2.H = false;
                        long jUptimeMillis2 = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
                        t1Var2.onTouchEvent(motionEventObtain2);
                        motionEventObtain2.recycle();
                    }
                    if (aVar2.f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = aVar2.a(jCurrentAnimationTimeMillis2);
                    long j10 = jCurrentAnimationTimeMillis2 - aVar2.f;
                    aVar2.f = jCurrentAnimationTimeMillis2;
                    dVar2.K.scrollListBy((int) (j10 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * aVar2.f12527d));
                    WeakHashMap weakHashMap = q0.o0.f10475a;
                    t1Var2.postOnAnimation(this);
                    return;
                }
                return;
            case 26:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f1266v).f3523w.A;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 27:
                l1 l1Var = (l1) this.f1266v;
                l1Var.f5105c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) l1Var.f5107e;
                y0.d dVar3 = bottomSheetBehavior.f3342g0;
                if (dVar3 != null && dVar3.g()) {
                    l1Var.a(l1Var.f5104b);
                    return;
                } else {
                    if (bottomSheetBehavior.f3341f0 == 2) {
                        bottomSheetBehavior.H(l1Var.f5104b);
                        return;
                    }
                    return;
                }
        }
        while (true) {
            xe.c cVar = (xe.c) this.f1266v;
            synchronized (cVar) {
                aVarC = cVar.c();
            }
            if (aVarC == null) {
                return;
            }
            xe.b bVar2 = aVarC.f14358c;
            be.h.b(bVar2);
            xe.c cVar2 = (xe.c) this.f1266v;
            boolean zIsLoggable = xe.c.f14366j.isLoggable(Level.FINE);
            if (zIsLoggable) {
                jNanoTime = System.nanoTime();
                wa.t1.c(aVarC, bVar2, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                xe.c.a(cVar2, aVarC);
                if (zIsLoggable) {
                    wa.t1.c(aVarC, bVar2, "finished run in ".concat(wa.t1.l(System.nanoTime() - jNanoTime)));
                }
            } catch (Throwable th2) {
                try {
                    ((ThreadPoolExecutor) cVar2.f14367a.f8343u).execute(this);
                    throw th2;
                } catch (Throwable th3) {
                    if (zIsLoggable) {
                        wa.t1.c(aVarC, bVar2, "failed a run in ".concat(wa.t1.l(System.nanoTime() - jNanoTime)));
                    }
                    throw th3;
                }
            }
        }
    }

    public /* synthetic */ e(int i, Object obj) {
        this.f1265u = i;
        this.f1266v = obj;
    }

    public e(s7.h hVar, e6.i iVar) {
        this.f1265u = 24;
        this.f1266v = iVar;
    }

    public e(k8.w0 w0Var, boolean z2) {
        this.f1265u = 9;
        this.f1266v = w0Var;
    }

    public e(x3 x3Var, u5.c cVar) {
        this.f1265u = 11;
        this.f1266v = x3Var;
    }
}
