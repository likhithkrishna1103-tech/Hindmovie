package g6;

import android.animation.Animator;
import android.content.Context;
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
import android.provider.Settings;
import android.view.Choreographer;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends Drawable implements Drawable.Callback, Animatable {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final boolean f5137n0;
    public static final List o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final ThreadPoolExecutor f5138p0;
    public final ArrayList A;
    public k6.a B;
    public String C;
    public dd.c D;
    public Map E;
    public String F;
    public final p6.c G;
    public boolean H;
    public boolean I;
    public o6.b J;
    public int K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public h0 Q;
    public boolean R;
    public final Matrix S;
    public Bitmap T;
    public Canvas U;
    public Rect V;
    public RectF W;
    public h6.a X;
    public Rect Y;
    public Rect Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public RectF f5139a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public RectF f5140b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Matrix f5141c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final float[] f5142d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Matrix f5143e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f5144f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public a f5145g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Semaphore f5146h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Handler f5147i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public t f5148j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final t f5149k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f5150l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f5151m0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public i f5152v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s6.e f5153w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f5154x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f5155y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5156z;

    static {
        f5137n0 = Build.VERSION.SDK_INT <= 25;
        o0 = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        f5138p0 = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new s6.d());
    }

    public w() {
        s6.e eVar = new s6.e();
        this.f5153w = eVar;
        this.f5154x = true;
        this.f5155y = false;
        this.f5156z = false;
        this.f5151m0 = 1;
        this.A = new ArrayList();
        this.G = new p6.c(17);
        this.H = false;
        this.I = true;
        this.K = 255;
        this.P = false;
        this.Q = h0.f5082v;
        this.R = false;
        this.S = new Matrix();
        this.f5142d0 = new float[9];
        this.f5144f0 = false;
        fa.a aVar = new fa.a(1, this);
        this.f5146h0 = new Semaphore(1);
        this.f5149k0 = new t(this, 1);
        this.f5150l0 = -3.4028235E38f;
        eVar.addUpdateListener(aVar);
    }

    public static void f(Rect rect, RectF rectF) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public static boolean j(float f) {
        return (Float.isNaN(f) || Float.isInfinite(f)) ? false : true;
    }

    public final void a(final l6.e eVar, final Object obj, final nb.w wVar) {
        o6.b bVar = this.J;
        if (bVar == null) {
            this.A.add(new v() { // from class: g6.q
                @Override // g6.v
                public final void run() {
                    this.f5123a.a(eVar, obj, wVar);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (eVar == l6.e.f7857c) {
            bVar.h(obj, wVar);
        } else {
            l6.f fVar = eVar.f7859b;
            if (fVar != null) {
                fVar.h(obj, wVar);
            } else {
                ArrayList arrayList = new ArrayList();
                this.J.g(eVar, 0, arrayList, new l6.e(new String[0]));
                for (int i = 0; i < arrayList.size(); i++) {
                    ((l6.e) arrayList.get(i)).f7859b.h(obj, wVar);
                }
                zIsEmpty = true ^ arrayList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (obj == a0.C) {
                u(this.f5153w.a());
            }
        }
    }

    public final boolean b(Context context) {
        if (this.f5155y) {
            return true;
        }
        if (!this.f5154x) {
            return false;
        }
        if (context == null) {
            return true;
        }
        Matrix matrix = s6.i.f11583a;
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f;
    }

    public final void c() {
        i iVar = this.f5152v;
        if (iVar == null) {
            return;
        }
        nb.w wVar = q6.r.f10430a;
        Rect rect = iVar.f5094k;
        List list = Collections.EMPTY_LIST;
        o6.b bVar = new o6.b(this, new o6.d(list, iVar, "__container", -1L, 1, -1L, null, list, new m6.e(), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, list, 1, null, false, null, null, 1), iVar.f5093j, iVar);
        this.J = bVar;
        if (this.M) {
            bVar.q(true);
        }
        this.J.L = this.I;
    }

    public final void d() {
        s6.e eVar = this.f5153w;
        if (eVar.H) {
            eVar.cancel();
            if (!isVisible()) {
                this.f5151m0 = 1;
            }
        }
        this.f5152v = null;
        this.J = null;
        this.B = null;
        this.f5150l0 = -3.4028235E38f;
        eVar.G = null;
        eVar.E = -2.1474836E9f;
        eVar.F = 2.1474836E9f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        i iVar;
        o6.b bVar = this.J;
        if (bVar == null) {
            return;
        }
        a aVar = this.f5145g0;
        if (aVar == null) {
            aVar = a.f5030v;
        }
        boolean z10 = aVar == a.f5031w;
        t tVar = this.f5149k0;
        ThreadPoolExecutor threadPoolExecutor = f5138p0;
        Semaphore semaphore = this.f5146h0;
        s6.e eVar = this.f5153w;
        if (z10) {
            try {
                semaphore.acquire();
            } catch (InterruptedException unused) {
                if (!z10) {
                    return;
                }
                semaphore.release();
                if (bVar.K == eVar.a()) {
                    return;
                }
            } catch (Throwable th) {
                if (z10) {
                    semaphore.release();
                    if (bVar.K != eVar.a()) {
                        threadPoolExecutor.execute(tVar);
                    }
                }
                throw th;
            }
        }
        if (z10 && (iVar = this.f5152v) != null) {
            float f = this.f5150l0;
            float fA = eVar.a();
            this.f5150l0 = fA;
            if (Math.abs(fA - f) * iVar.b() >= 50.0f) {
                u(eVar.a());
            }
        }
        if (this.f5156z) {
            try {
                if (this.R) {
                    m(canvas, bVar);
                } else {
                    g(canvas);
                }
            } catch (Throwable unused2) {
                s6.c.f11547a.getClass();
            }
        } else if (this.R) {
            m(canvas, bVar);
        } else {
            g(canvas);
        }
        this.f5144f0 = false;
        if (z10) {
            semaphore.release();
            if (bVar.K == eVar.a()) {
                return;
            }
            threadPoolExecutor.execute(tVar);
        }
    }

    public final void e() {
        i iVar = this.f5152v;
        if (iVar == null) {
            return;
        }
        h0 h0Var = this.Q;
        int i = Build.VERSION.SDK_INT;
        boolean z10 = iVar.f5098o;
        int i10 = iVar.f5099p;
        int iOrdinal = h0Var.ordinal();
        boolean z11 = false;
        if (iOrdinal != 1 && (iOrdinal == 2 || ((z10 && i < 28) || i10 > 4 || i <= 25))) {
            z11 = true;
        }
        this.R = z11;
    }

    public final void g(Canvas canvas) {
        o6.b bVar = this.J;
        i iVar = this.f5152v;
        if (bVar == null || iVar == null) {
            return;
        }
        Matrix matrix = this.S;
        matrix.reset();
        if (!getBounds().isEmpty()) {
            matrix.preTranslate(r3.left, r3.top);
            matrix.preScale(r3.width() / iVar.f5094k.width(), r3.height() / iVar.f5094k.height());
        }
        bVar.e(canvas, matrix, this.K, null);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.K;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        i iVar = this.f5152v;
        if (iVar == null) {
            return -1;
        }
        return iVar.f5094k.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        i iVar = this.f5152v;
        if (iVar == null) {
            return -1;
        }
        return iVar.f5094k.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final Context h() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public final dd.c i() {
        if (getCallback() == null) {
            return null;
        }
        if (this.D == null) {
            dd.c cVar = new dd.c(getCallback());
            this.D = cVar;
            String str = this.F;
            if (str != null) {
                cVar.A = str;
            }
        }
        return this.D;
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
        if (this.f5144f0) {
            return;
        }
        this.f5144f0 = true;
        if ((!f5137n0 || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        s6.e eVar = this.f5153w;
        if (eVar == null) {
            return false;
        }
        return eVar.H;
    }

    public final void k() {
        this.A.clear();
        s6.e eVar = this.f5153w;
        eVar.g(true);
        Iterator it = eVar.f11554x.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorPauseListener) it.next()).onAnimationPause(eVar);
        }
        if (isVisible()) {
            return;
        }
        this.f5151m0 = 1;
    }

    public final void l() {
        if (this.J == null) {
            this.A.add(new u(this, 1));
            return;
        }
        e();
        boolean zB = b(h());
        s6.e eVar = this.f5153w;
        if (zB || eVar.getRepeatCount() == 0) {
            if (isVisible()) {
                eVar.H = true;
                boolean zD = eVar.d();
                for (Animator.AnimatorListener animatorListener : eVar.f11553w) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        animatorListener.onAnimationStart(eVar, zD);
                    } else {
                        animatorListener.onAnimationStart(eVar);
                    }
                }
                eVar.h((int) (eVar.d() ? eVar.b() : eVar.c()));
                eVar.A = 0L;
                eVar.D = 0;
                if (eVar.H) {
                    eVar.g(false);
                    Choreographer.getInstance().postFrameCallback(eVar);
                }
                this.f5151m0 = 1;
            } else {
                this.f5151m0 = 2;
            }
        }
        if (b(h())) {
            return;
        }
        Iterator it = o0.iterator();
        l6.h hVarD = null;
        while (it.hasNext()) {
            hVarD = this.f5152v.d((String) it.next());
            if (hVarD != null) {
                break;
            }
        }
        if (hVarD != null) {
            o((int) hVarD.f7863b);
        } else {
            o((int) (eVar.f11555y < 0.0f ? eVar.c() : eVar.b()));
        }
        eVar.g(true);
        eVar.e(eVar.d());
        if (isVisible()) {
            return;
        }
        this.f5151m0 = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(android.graphics.Canvas r12, o6.b r13) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.w.m(android.graphics.Canvas, o6.b):void");
    }

    public final void n() {
        if (this.J == null) {
            this.A.add(new u(this, 0));
            return;
        }
        e();
        boolean zB = b(h());
        s6.e eVar = this.f5153w;
        if (zB || eVar.getRepeatCount() == 0) {
            if (isVisible()) {
                eVar.H = true;
                eVar.g(false);
                Choreographer.getInstance().postFrameCallback(eVar);
                eVar.A = 0L;
                if (eVar.d() && eVar.C == eVar.c()) {
                    eVar.h(eVar.b());
                } else if (!eVar.d() && eVar.C == eVar.b()) {
                    eVar.h(eVar.c());
                }
                Iterator it = eVar.f11554x.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorPauseListener) it.next()).onAnimationResume(eVar);
                }
                this.f5151m0 = 1;
            } else {
                this.f5151m0 = 3;
            }
        }
        if (b(h())) {
            return;
        }
        o((int) (eVar.f11555y < 0.0f ? eVar.c() : eVar.b()));
        eVar.g(true);
        eVar.e(eVar.d());
        if (isVisible()) {
            return;
        }
        this.f5151m0 = 1;
    }

    public final void o(int i) {
        if (this.f5152v != null) {
            this.f5153w.h(i);
        } else {
            this.A.add(new p(this, i, 2));
        }
    }

    public final void p(int i) {
        if (this.f5152v == null) {
            this.A.add(new p(this, i, 0));
        } else {
            s6.e eVar = this.f5153w;
            eVar.i(eVar.E, i + 0.99f);
        }
    }

    public final void q(String str) {
        i iVar = this.f5152v;
        if (iVar == null) {
            this.A.add(new o(this, str, 1));
        } else {
            l6.h hVarD = iVar.d(str);
            if (hVarD == null) {
                throw new IllegalArgumentException(l0.e.k("Cannot find marker with name ", str, "."));
            }
            p((int) (hVarD.f7863b + hVarD.f7864c));
        }
    }

    public final void r(String str) {
        i iVar = this.f5152v;
        ArrayList arrayList = this.A;
        if (iVar == null) {
            arrayList.add(new o(this, str, 0));
            return;
        }
        l6.h hVarD = iVar.d(str);
        if (hVarD == null) {
            throw new IllegalArgumentException(l0.e.k("Cannot find marker with name ", str, "."));
        }
        int i = (int) hVarD.f7863b;
        int i10 = ((int) hVarD.f7864c) + i;
        if (this.f5152v == null) {
            arrayList.add(new s(this, i, i10));
        } else {
            this.f5153w.i(i, i10 + 0.99f);
        }
    }

    public final void s(int i) {
        if (this.f5152v == null) {
            this.A.add(new p(this, i, 1));
        } else {
            this.f5153w.i(i, (int) r0.F);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.K = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        s6.c.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        boolean zIsVisible = isVisible();
        boolean visible = super.setVisible(z10, z11);
        if (z10) {
            int i = this.f5151m0;
            if (i == 2) {
                l();
                return visible;
            }
            if (i == 3) {
                n();
                return visible;
            }
        } else {
            if (this.f5153w.H) {
                k();
                this.f5151m0 = 3;
                return visible;
            }
            if (zIsVisible) {
                this.f5151m0 = 1;
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
        l();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.A.clear();
        s6.e eVar = this.f5153w;
        eVar.g(true);
        eVar.e(eVar.d());
        if (isVisible()) {
            return;
        }
        this.f5151m0 = 1;
    }

    public final void t(String str) {
        i iVar = this.f5152v;
        if (iVar == null) {
            this.A.add(new o(this, str, 2));
        } else {
            l6.h hVarD = iVar.d(str);
            if (hVarD == null) {
                throw new IllegalArgumentException(l0.e.k("Cannot find marker with name ", str, "."));
            }
            s((int) hVarD.f7863b);
        }
    }

    public final void u(float f) {
        i iVar = this.f5152v;
        if (iVar == null) {
            this.A.add(new r(this, f, 2));
        } else {
            this.f5153w.h(s6.g.f(iVar.f5095l, iVar.f5096m, f));
        }
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
