package v4;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f13212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f13213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13216e;
    public long f;

    public static void b(x0 x0Var) {
        RecyclerView recyclerView;
        int i = x0Var.f13394j;
        if (x0Var.f() || (i & 4) != 0 || (recyclerView = x0Var.f13402r) == null) {
            return;
        }
        recyclerView.J(x0Var);
    }

    public abstract boolean a(x0 x0Var, x0 x0Var2, d4.e eVar, d4.e eVar2);

    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(v4.x0 r11) {
        /*
            r10 = this;
            v4.y r0 = r10.f13212a
            if (r0 == 0) goto Lb7
            androidx.recyclerview.widget.RecyclerView r0 = r0.f13404v
            r1 = 1
            r11.n(r1)
            android.view.View r2 = r11.f13387a
            v4.x0 r3 = r11.f13393h
            r4 = 0
            if (r3 == 0) goto L17
            v4.x0 r3 = r11.i
            if (r3 != 0) goto L17
            r11.f13393h = r4
        L17:
            r11.i = r4
            int r3 = r11.f13394j
            r3 = r3 & 16
            if (r3 == 0) goto L21
            goto Lb7
        L21:
            v4.n0 r3 = r0.f1451x
            r0.k0()
            ff.m r4 = r0.A
            java.lang.Object r5 = r4.f4601y
            f9.s0 r5 = (f9.s0) r5
            java.lang.Object r6 = r4.f4600x
            kf.i r6 = (kf.i) r6
            int r7 = r4.f4599w
            r8 = 0
            if (r7 != r1) goto L45
            java.lang.Object r1 = r4.A
            android.view.View r1 = (android.view.View) r1
            if (r1 != r2) goto L3d
        L3b:
            r1 = r8
            goto L70
        L3d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeView(At) for a different view"
            r11.<init>(r0)
            throw r11
        L45:
            r9 = 2
            if (r7 == r9) goto Laf
            r4.f4599w = r9     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r7 = r6.f7483w     // Catch: java.lang.Throwable -> L5b
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7     // Catch: java.lang.Throwable -> L5b
            int r7 = r7.indexOfChild(r2)     // Catch: java.lang.Throwable -> L5b
            r9 = -1
            if (r7 != r9) goto L5d
            r4.E(r2)     // Catch: java.lang.Throwable -> L5b
        L58:
            r4.f4599w = r8
            goto L70
        L5b:
            r11 = move-exception
            goto Lac
        L5d:
            boolean r9 = r5.G(r7)     // Catch: java.lang.Throwable -> L5b
            if (r9 == 0) goto L6d
            r5.J(r7)     // Catch: java.lang.Throwable -> L5b
            r4.E(r2)     // Catch: java.lang.Throwable -> L5b
            r6.L(r7)     // Catch: java.lang.Throwable -> L5b
            goto L58
        L6d:
            r4.f4599w = r8
            goto L3b
        L70:
            if (r1 == 0) goto L9b
            v4.x0 r4 = androidx.recyclerview.widget.RecyclerView.M(r2)
            r3.m(r4)
            r3.j(r4)
            boolean r3 = androidx.recyclerview.widget.RecyclerView.X0
            if (r3 == 0) goto L9b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "after removing animated view: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r4 = ", "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "RecyclerView"
            android.util.Log.d(r4, r3)
        L9b:
            r3 = r1 ^ 1
            r0.m0(r3)
            if (r1 != 0) goto Lb7
            boolean r11 = r11.j()
            if (r11 == 0) goto Lb7
            r0.removeDetachedView(r2, r8)
            return
        Lac:
            r4.f4599w = r8
            throw r11
        Laf:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeViewIfHidden"
            r11.<init>(r0)
            throw r11
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.e0.c(v4.x0):void");
    }

    public abstract void d(x0 x0Var);

    public abstract void e();

    public abstract boolean f();
}
