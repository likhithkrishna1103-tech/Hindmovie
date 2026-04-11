package l5;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends Drawable implements Drawable.Callback, Animatable {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f7906k0;
    public static final List l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final ThreadPoolExecutor f7907m0;
    public p5.a A;
    public String B;
    public zc.c C;
    public Map D;
    public String E;
    public boolean F;
    public boolean G;
    public boolean H;
    public t5.c I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public g0 O;
    public boolean P;
    public final Matrix Q;
    public Bitmap R;
    public Canvas S;
    public Rect T;
    public RectF U;
    public m5.a V;
    public Rect W;
    public Rect X;
    public RectF Y;
    public RectF Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Matrix f7908a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Matrix f7909b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f7910c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public a f7911d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Semaphore f7912e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public Handler f7913f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public t f7914g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final t f7915h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f7916i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f7917j0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j f7918u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final x5.d f7919v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7920w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7921x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7922y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f7923z;

    static {
        f7906k0 = Build.VERSION.SDK_INT <= 25;
        l0 = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        f7907m0 = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new x5.c());
    }

    public w() {
        x5.d dVar = new x5.d();
        this.f7919v = dVar;
        this.f7920w = true;
        this.f7921x = false;
        this.f7922y = false;
        this.f7917j0 = 1;
        this.f7923z = new ArrayList();
        this.G = false;
        this.H = true;
        this.J = 255;
        this.N = false;
        this.O = g0.f7845u;
        this.P = false;
        this.Q = new Matrix();
        this.f7910c0 = false;
        i4.d dVar2 = new i4.d(1, this);
        this.f7912e0 = new Semaphore(1);
        this.f7915h0 = new t(this, 1);
        this.f7916i0 = -3.4028235E38f;
        dVar.addUpdateListener(dVar2);
    }

    public static void f(Rect rect, RectF rectF) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final void a(final q5.e eVar, final Object obj, final p2.c cVar) {
        t5.c cVar2 = this.I;
        if (cVar2 == null) {
            this.f7923z.add(new v() { // from class: l5.q
                @Override // l5.v
                public final void run() {
                    this.f7892a.a(eVar, obj, cVar);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (eVar == q5.e.f11010c) {
            cVar2.h(obj, cVar);
        } else {
            q5.f fVar = eVar.f11012b;
            if (fVar != null) {
                fVar.h(obj, cVar);
            } else {
                ArrayList arrayList = new ArrayList();
                this.I.g(eVar, 0, arrayList, new q5.e(new String[0]));
                for (int i = 0; i < arrayList.size(); i++) {
                    ((q5.e) arrayList.get(i)).f11012b.h(obj, cVar);
                }
                zIsEmpty = true ^ arrayList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (obj == z.f7952z) {
                s(this.f7919v.a());
            }
        }
    }

    public final boolean b() {
        return this.f7920w || this.f7921x;
    }

    public final void c() {
        j jVar = this.f7918u;
        if (jVar == null) {
            return;
        }
        pb.c cVar = v5.q.f13305a;
        Rect rect = jVar.f7865k;
        List list = Collections.EMPTY_LIST;
        t5.c cVar2 = new t5.c(this, new t5.e(list, jVar, "__container", -1L, 1, -1L, null, list, new r5.d(), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, list, 1, null, false, null, null, 1), jVar.f7864j, jVar);
        this.I = cVar2;
        if (this.L) {
            cVar2.r(true);
        }
        this.I.I = this.H;
    }

    public final void d() {
        x5.d dVar = this.f7919v;
        if (dVar.G) {
            dVar.cancel();
            if (!isVisible()) {
                this.f7917j0 = 1;
            }
        }
        this.f7918u = null;
        this.I = null;
        this.A = null;
        this.f7916i0 = -3.4028235E38f;
        dVar.F = null;
        dVar.D = -2.1474836E9f;
        dVar.E = 2.1474836E9f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        j jVar;
        t5.c cVar = this.I;
        if (cVar == null) {
            return;
        }
        a aVar = this.f7911d0;
        if (aVar == null) {
            aVar = a.f7820u;
        }
        boolean z2 = aVar == a.f7821v;
        t tVar = this.f7915h0;
        ThreadPoolExecutor threadPoolExecutor = f7907m0;
        Semaphore semaphore = this.f7912e0;
        x5.d dVar = this.f7919v;
        if (z2) {
            try {
                semaphore.acquire();
            } catch (InterruptedException unused) {
                if (!z2) {
                    return;
                }
                semaphore.release();
                if (cVar.H == dVar.a()) {
                    return;
                }
            } catch (Throwable th) {
                if (z2) {
                    semaphore.release();
                    if (cVar.H != dVar.a()) {
                        threadPoolExecutor.execute(tVar);
                    }
                }
                throw th;
            }
        }
        if (z2 && (jVar = this.f7918u) != null) {
            float f = this.f7916i0;
            float fA = dVar.a();
            this.f7916i0 = fA;
            if (Math.abs(fA - f) * jVar.b() >= 50.0f) {
                s(dVar.a());
            }
        }
        if (this.f7922y) {
            try {
                if (this.P) {
                    k(canvas, cVar);
                } else {
                    g(canvas);
                }
            } catch (Throwable unused2) {
                x5.b.f14254a.getClass();
            }
        } else if (this.P) {
            k(canvas, cVar);
        } else {
            g(canvas);
        }
        this.f7910c0 = false;
        if (z2) {
            semaphore.release();
            if (cVar.H == dVar.a()) {
                return;
            }
            threadPoolExecutor.execute(tVar);
        }
    }

    public final void e() {
        j jVar = this.f7918u;
        if (jVar == null) {
            return;
        }
        g0 g0Var = this.O;
        int i = Build.VERSION.SDK_INT;
        boolean z2 = jVar.f7869o;
        int i10 = jVar.f7870p;
        int iOrdinal = g0Var.ordinal();
        boolean z10 = false;
        if (iOrdinal != 1 && (iOrdinal == 2 || ((z2 && i < 28) || i10 > 4 || i <= 25))) {
            z10 = true;
        }
        this.P = z10;
    }

    public final void g(Canvas canvas) {
        t5.c cVar = this.I;
        j jVar = this.f7918u;
        if (cVar == null || jVar == null) {
            return;
        }
        Matrix matrix = this.Q;
        matrix.reset();
        if (!getBounds().isEmpty()) {
            matrix.preScale(r3.width() / jVar.f7865k.width(), r3.height() / jVar.f7865k.height());
            matrix.preTranslate(r3.left, r3.top);
        }
        cVar.e(canvas, matrix, this.J);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.J;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        j jVar = this.f7918u;
        if (jVar == null) {
            return -1;
        }
        return jVar.f7865k.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        j jVar = this.f7918u;
        if (jVar == null) {
            return -1;
        }
        return jVar.f7865k.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final zc.c h() {
        if (getCallback() == null) {
            return null;
        }
        if (this.C == null) {
            Drawable.Callback callback = getCallback();
            zc.c cVar = new zc.c();
            cVar.f14945u = new e2.u();
            cVar.f14946v = new HashMap();
            cVar.f14947w = new HashMap();
            cVar.f14949y = ".ttf";
            if (callback instanceof View) {
                cVar.f14948x = ((View) callback).getContext().getAssets();
            } else {
                x5.b.b("LottieDrawable must be inside of a view for images to work.");
                cVar.f14948x = null;
            }
            this.C = cVar;
            String str = this.E;
            if (str != null) {
                cVar.f14949y = str;
            }
        }
        return this.C;
    }

    public final void i() {
        this.f7923z.clear();
        x5.d dVar = this.f7919v;
        dVar.g(true);
        Iterator it = dVar.f14261w.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorPauseListener) it.next()).onAnimationPause(dVar);
        }
        if (isVisible()) {
            return;
        }
        this.f7917j0 = 1;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable.Callback callback;
        if (this.f7910c0) {
            return;
        }
        this.f7910c0 = true;
        if ((!f7906k0 || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        x5.d dVar = this.f7919v;
        if (dVar == null) {
            return false;
        }
        return dVar.G;
    }

    public final void j() {
        if (this.I == null) {
            this.f7923z.add(new u(this, 1));
            return;
        }
        e();
        boolean zB = b();
        x5.d dVar = this.f7919v;
        if (zB || dVar.getRepeatCount() == 0) {
            if (isVisible()) {
                dVar.G = true;
                boolean zD = dVar.d();
                for (Animator.AnimatorListener animatorListener : dVar.f14260v) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        animatorListener.onAnimationStart(dVar, zD);
                    } else {
                        animatorListener.onAnimationStart(dVar);
                    }
                }
                dVar.h((int) (dVar.d() ? dVar.b() : dVar.c()));
                dVar.f14264z = 0L;
                dVar.C = 0;
                if (dVar.G) {
                    dVar.g(false);
                    Choreographer.getInstance().postFrameCallback(dVar);
                }
                this.f7917j0 = 1;
            } else {
                this.f7917j0 = 2;
            }
        }
        if (b()) {
            return;
        }
        Iterator it = l0.iterator();
        q5.h hVarD = null;
        while (it.hasNext()) {
            hVarD = this.f7918u.d((String) it.next());
            if (hVarD != null) {
                break;
            }
        }
        if (hVarD != null) {
            m((int) hVarD.f11016b);
        } else {
            m((int) (dVar.f14262x < 0.0f ? dVar.c() : dVar.b()));
        }
        dVar.g(true);
        dVar.e(dVar.d());
        if (isVisible()) {
            return;
        }
        this.f7917j0 = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.graphics.Canvas r10, t5.c r11) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.w.k(android.graphics.Canvas, t5.c):void");
    }

    public final void l() {
        if (this.I == null) {
            this.f7923z.add(new u(this, 0));
            return;
        }
        e();
        boolean zB = b();
        x5.d dVar = this.f7919v;
        if (zB || dVar.getRepeatCount() == 0) {
            if (isVisible()) {
                dVar.G = true;
                dVar.g(false);
                Choreographer.getInstance().postFrameCallback(dVar);
                dVar.f14264z = 0L;
                if (dVar.d() && dVar.B == dVar.c()) {
                    dVar.h(dVar.b());
                } else if (!dVar.d() && dVar.B == dVar.b()) {
                    dVar.h(dVar.c());
                }
                Iterator it = dVar.f14261w.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorPauseListener) it.next()).onAnimationResume(dVar);
                }
                this.f7917j0 = 1;
            } else {
                this.f7917j0 = 3;
            }
        }
        if (b()) {
            return;
        }
        m((int) (dVar.f14262x < 0.0f ? dVar.c() : dVar.b()));
        dVar.g(true);
        dVar.e(dVar.d());
        if (isVisible()) {
            return;
        }
        this.f7917j0 = 1;
    }

    public final void m(int i) {
        if (this.f7918u != null) {
            this.f7919v.h(i);
        } else {
            this.f7923z.add(new p(this, i, 2));
        }
    }

    public final void n(int i) {
        if (this.f7918u == null) {
            this.f7923z.add(new p(this, i, 0));
        } else {
            x5.d dVar = this.f7919v;
            dVar.i(dVar.D, i + 0.99f);
        }
    }

    public final void o(String str) {
        j jVar = this.f7918u;
        if (jVar == null) {
            this.f7923z.add(new o(this, str, 1));
        } else {
            q5.h hVarD = jVar.d(str);
            if (hVarD == null) {
                throw new IllegalArgumentException(e6.j.n("Cannot find marker with name ", str, "."));
            }
            n((int) (hVarD.f11016b + hVarD.f11017c));
        }
    }

    public final void p(String str) {
        j jVar = this.f7918u;
        ArrayList arrayList = this.f7923z;
        if (jVar == null) {
            arrayList.add(new o(this, str, 0));
            return;
        }
        q5.h hVarD = jVar.d(str);
        if (hVarD == null) {
            throw new IllegalArgumentException(e6.j.n("Cannot find marker with name ", str, "."));
        }
        int i = (int) hVarD.f11016b;
        int i10 = ((int) hVarD.f11017c) + i;
        if (this.f7918u == null) {
            arrayList.add(new s(this, i, i10));
        } else {
            this.f7919v.i(i, i10 + 0.99f);
        }
    }

    public final void q(int i) {
        if (this.f7918u == null) {
            this.f7923z.add(new p(this, i, 1));
        } else {
            this.f7919v.i(i, (int) r0.E);
        }
    }

    public final void r(String str) {
        j jVar = this.f7918u;
        if (jVar == null) {
            this.f7923z.add(new o(this, str, 2));
        } else {
            q5.h hVarD = jVar.d(str);
            if (hVarD == null) {
                throw new IllegalArgumentException(e6.j.n("Cannot find marker with name ", str, "."));
            }
            q((int) hVarD.f11016b);
        }
    }

    public final void s(float f) {
        j jVar = this.f7918u;
        if (jVar == null) {
            this.f7923z.add(new r(this, f, 2));
        } else {
            this.f7919v.h(x5.f.e(jVar.f7866l, jVar.f7867m, f));
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.J = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        x5.b.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z10) {
        boolean zIsVisible = isVisible();
        boolean visible = super.setVisible(z2, z10);
        if (z2) {
            int i = this.f7917j0;
            if (i == 2) {
                j();
                return visible;
            }
            if (i == 3) {
                l();
                return visible;
            }
        } else {
            if (this.f7919v.G) {
                i();
                this.f7917j0 = 3;
                return visible;
            }
            if (zIsVisible) {
                this.f7917j0 = 1;
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        j();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f7923z.clear();
        x5.d dVar = this.f7919v;
        dVar.g(true);
        dVar.e(dVar.d());
        if (isVisible()) {
            return;
        }
        this.f7917j0 = 1;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }
}
