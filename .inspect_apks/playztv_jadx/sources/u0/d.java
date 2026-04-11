package u0;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import n.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements View.OnTouchListener {
    public static final int L = ViewConfiguration.getTapTimeout();
    public final int A;
    public final int B;
    public final float[] C;
    public final float[] D;
    public final float[] E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public final t1 K;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f12531u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AccelerateInterpolator f12532v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t1 f12533w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public androidx.fragment.app.e f12534x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float[] f12535y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float[] f12536z;

    public d(t1 t1Var) {
        a aVar = new a();
        aVar.f12528e = Long.MIN_VALUE;
        aVar.f12529g = -1L;
        aVar.f = 0L;
        this.f12531u = aVar;
        this.f12532v = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f12535y = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f12536z = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.C = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.D = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.E = fArr5;
        this.f12533w = t1Var;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f4 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f4;
        fArr5[1] = f4;
        float f10 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f10;
        fArr4[1] = f10;
        this.A = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.B = L;
        aVar.f12524a = 500;
        aVar.f12525b = 500;
        this.K = t1Var;
    }

    public static float b(float f, float f4, float f10) {
        return f > f10 ? f10 : f < f4 ? f4 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f12535y
            r0 = r0[r4]
            float[] r1 = r3.f12536z
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f12532v
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.C
            r0 = r0[r4]
            float[] r1 = r3.D
            r1 = r1[r4]
            float[] r2 = r3.E
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L51:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.d.a(int, float, float, float):float");
    }

    public final float c(float f, float f4) {
        if (f4 != 0.0f) {
            int i = this.A;
            if (i == 0 || i == 1) {
                if (f < f4) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f4);
                    }
                    if (this.I && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f4);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.G) {
            this.I = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        a aVar = this.f12531u;
        int i10 = (int) (jCurrentAnimationTimeMillis - aVar.f12528e);
        int i11 = aVar.f12525b;
        if (i10 > i11) {
            i = i11;
        } else if (i10 >= 0) {
            i = i10;
        }
        aVar.i = i;
        aVar.f12530h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.f12529g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        t1 t1Var;
        int count;
        a aVar = this.f12531u;
        float f = aVar.f12527d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(aVar.f12526c);
        if (iAbs != 0 && (count = (t1Var = this.K).getCount()) != 0) {
            int childCount = t1Var.getChildCount();
            int firstVisiblePosition = t1Var.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && t1Var.getChildAt(0).getTop() >= 0)) : !(i >= count && t1Var.getChildAt(childCount - 1).getBottom() <= t1Var.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.J
            r1 = 0
            if (r0 != 0) goto L7
            goto L7e
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7e
        L17:
            r7.d()
            return r1
        L1b:
            r7.H = r2
            r7.F = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            n.t1 r4 = r7.f12533w
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            u0.a r9 = r7.f12531u
            r9.f12526c = r0
            r9.f12527d = r8
            boolean r8 = r7.I
            if (r8 != 0) goto L7e
            boolean r8 = r7.e()
            if (r8 == 0) goto L7e
            androidx.fragment.app.e r8 = r7.f12534x
            if (r8 != 0) goto L62
            androidx.fragment.app.e r8 = new androidx.fragment.app.e
            r9 = 25
            r8.<init>(r9, r7)
            r7.f12534x = r8
        L62:
            r7.I = r2
            r7.G = r2
            boolean r8 = r7.F
            if (r8 != 0) goto L77
            int r8 = r7.B
            if (r8 <= 0) goto L77
            androidx.fragment.app.e r9 = r7.f12534x
            long r5 = (long) r8
            java.util.WeakHashMap r8 = q0.o0.f10475a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7c
        L77:
            androidx.fragment.app.e r8 = r7.f12534x
            r8.run()
        L7c:
            r7.F = r2
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
