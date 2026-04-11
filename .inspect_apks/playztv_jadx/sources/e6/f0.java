package e6;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseBooleanArray;
import androidx.appcompat.widget.ActionMenuView;
import j9.i0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements m.v, va.k, i0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4498u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f4499v;

    public /* synthetic */ f0(Object obj) {
        this.f4499v = obj;
    }

    @Override // va.k
    public void a(va.j jVar, int i) {
        StringBuilder sb2 = (StringBuilder) this.f4499v;
        if (this.f4498u) {
            this.f4498u = false;
        } else {
            sb2.append(", ");
        }
        sb2.append(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    @Override // j9.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q0.r1 b(android.view.View r12, q0.r1 r13, j9.j0 r14) {
        /*
            r11 = this;
            q0.o1 r0 = r13.f10492a
            r1 = 519(0x207, float:7.27E-43)
            i0.d r1 = r0.f(r1)
            r2 = 32
            i0.d r0 = r0.f(r2)
            java.lang.Object r2 = r11.f4499v
            com.google.android.material.bottomsheet.BottomSheetBehavior r2 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r2
            int r3 = r1.f6162b
            int r4 = r1.f6163c
            int r5 = r1.f6161a
            r2.Q = r3
            boolean r3 = j9.f0.d(r12)
            int r6 = r12.getPaddingBottom()
            int r7 = r12.getPaddingLeft()
            int r8 = r12.getPaddingRight()
            boolean r9 = r2.I
            if (r9 == 0) goto L37
            int r6 = r13.a()
            r2.P = r6
            int r10 = r14.f6890d
            int r6 = r6 + r10
        L37:
            boolean r10 = r2.J
            if (r10 == 0) goto L43
            if (r3 == 0) goto L40
            int r7 = r14.f6889c
            goto L42
        L40:
            int r7 = r14.f6887a
        L42:
            int r7 = r7 + r5
        L43:
            boolean r10 = r2.K
            if (r10 == 0) goto L50
            if (r3 == 0) goto L4c
            int r14 = r14.f6887a
            goto L4e
        L4c:
            int r14 = r14.f6889c
        L4e:
            int r8 = r14 + r4
        L50:
            android.view.ViewGroup$LayoutParams r14 = r12.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r14 = (android.view.ViewGroup.MarginLayoutParams) r14
            boolean r3 = r2.M
            r10 = 1
            if (r3 == 0) goto L63
            int r3 = r14.leftMargin
            if (r3 == r5) goto L63
            r14.leftMargin = r5
            r3 = r10
            goto L64
        L63:
            r3 = 0
        L64:
            boolean r5 = r2.N
            if (r5 == 0) goto L6f
            int r5 = r14.rightMargin
            if (r5 == r4) goto L6f
            r14.rightMargin = r4
            r3 = r10
        L6f:
            boolean r4 = r2.O
            if (r4 == 0) goto L7c
            int r4 = r14.topMargin
            int r1 = r1.f6162b
            if (r4 == r1) goto L7c
            r14.topMargin = r1
            goto L7d
        L7c:
            r10 = r3
        L7d:
            if (r10 == 0) goto L82
            r12.setLayoutParams(r14)
        L82:
            int r14 = r12.getPaddingTop()
            r12.setPadding(r7, r14, r8, r6)
            boolean r12 = r11.f4498u
            if (r12 == 0) goto L91
            int r14 = r0.f6164d
            r2.G = r14
        L91:
            if (r9 != 0) goto L97
            if (r12 == 0) goto L96
            goto L97
        L96:
            return r13
        L97:
            r2.N()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.f0.b(android.view.View, q0.r1, j9.j0):q0.r1");
    }

    @Override // m.v
    public void c(m.k kVar, boolean z2) {
        n.k kVar2;
        h.i0 i0Var = (h.i0) this.f4499v;
        if (this.f4498u) {
            return;
        }
        this.f4498u = true;
        ActionMenuView actionMenuView = i0Var.f5502c.f8443a.f942u;
        if (actionMenuView != null && (kVar2 = actionMenuView.N) != null) {
            kVar2.d();
            n.f fVar = kVar2.O;
            if (fVar != null && fVar.b()) {
                fVar.i.dismiss();
            }
        }
        i0Var.f5503d.onPanelClosed(108, kVar);
        this.f4498u = false;
    }

    public void d(int i) {
        s1.d.g(!this.f4498u);
        ((SparseBooleanArray) this.f4499v).append(i, true);
    }

    public void e(p1.o oVar) {
        for (int i = 0; i < oVar.f9953a.size(); i++) {
            d(oVar.b(i));
        }
    }

    public p1.o f() {
        s1.d.g(!this.f4498u);
        this.f4498u = true;
        return new p1.o((SparseBooleanArray) this.f4499v);
    }

    public boolean g() {
        return this.f4498u;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean h(java.lang.CharSequence r7, int r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L48
            if (r8 < 0) goto L48
            int r0 = r7.length()
            int r0 = r0 - r8
            if (r0 < 0) goto L48
            java.lang.Object r0 = r6.f4499v
            o0.f r0 = (o0.f) r0
            if (r0 != 0) goto L16
            boolean r7 = r6.g()
            return r7
        L16:
            r0.getClass()
            r0 = 0
            r1 = 2
            r2 = r0
            r3 = r1
        L1d:
            r4 = 1
            if (r2 >= r8) goto L3d
            if (r3 != r1) goto L3d
            char r3 = r7.charAt(r2)
            byte r3 = java.lang.Character.getDirectionality(r3)
            e6.f0 r5 = o0.g.f9045a
            if (r3 == 0) goto L39
            if (r3 == r4) goto L37
            if (r3 == r1) goto L37
            switch(r3) {
                case 14: goto L39;
                case 15: goto L39;
                case 16: goto L37;
                case 17: goto L37;
                default: goto L35;
            }
        L35:
            r3 = r1
            goto L3a
        L37:
            r3 = r0
            goto L3a
        L39:
            r3 = r4
        L3a:
            int r2 = r2 + 1
            goto L1d
        L3d:
            if (r3 == 0) goto L47
            if (r3 == r4) goto L46
            boolean r7 = r6.g()
            return r7
        L46:
            return r0
        L47:
            return r4
        L48:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.f0.h(java.lang.CharSequence, int):boolean");
    }

    public synchronized void i(b0 b0Var, boolean z2) {
        try {
            if (this.f4498u || z2) {
                ((Handler) this.f4499v).obtainMessage(1, b0Var).sendToTarget();
            } else {
                this.f4498u = true;
                b0Var.d();
                this.f4498u = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // m.v
    public boolean x(m.k kVar) {
        ((h.i0) this.f4499v).f5503d.onMenuOpened(108, kVar);
        return true;
    }

    public f0(int i) {
        switch (i) {
            case 3:
                this.f4499v = new SparseBooleanArray();
                break;
            default:
                this.f4499v = new Handler(Looper.getMainLooper(), new e0(0));
                break;
        }
    }

    public f0(o0.f fVar, boolean z2) {
        this(fVar);
        this.f4498u = z2;
    }
}
