package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseBooleanArray;
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class o4 implements n.v, pb.j {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2560v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f2561w;

    public o4(Uri uri, boolean z10, boolean z11) {
        this.f2561w = uri;
        this.f2560v = z10;
    }

    @Override // pb.j
    public void a(pb.i iVar, int i) {
        StringBuilder sb = (StringBuilder) this.f2561w;
        if (this.f2560v) {
            this.f2560v = false;
        } else {
            sb.append(", ");
        }
        sb.append(i);
    }

    public void b(int i) {
        y1.d.g(!this.f2560v);
        ((SparseBooleanArray) this.f2561w).append(i, true);
    }

    @Override // n.v
    public void c(n.k kVar, boolean z10) {
        o.k kVar2;
        h.h0 h0Var = (h.h0) this.f2561w;
        if (this.f2560v) {
            return;
        }
        this.f2560v = true;
        ActionMenuView actionMenuView = h0Var.f5349e.f9308a.f619v;
        if (actionMenuView != null && (kVar2 = actionMenuView.O) != null) {
            kVar2.d();
            o.f fVar = kVar2.P;
            if (fVar != null && fVar.b()) {
                fVar.i.dismiss();
            }
        }
        h0Var.f.onPanelClosed(108, kVar);
        this.f2560v = false;
    }

    public void d(v1.n nVar) {
        for (int i = 0; i < nVar.f12877a.size(); i++) {
            b(nVar.b(i));
        }
    }

    public v1.n e() {
        y1.d.g(!this.f2560v);
        this.f2560v = true;
        return new v1.n((SparseBooleanArray) this.f2561w);
    }

    public boolean f() {
        return this.f2560v;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(java.lang.CharSequence r7, int r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L48
            if (r8 < 0) goto L48
            int r0 = r7.length()
            int r0 = r0 - r8
            if (r0 < 0) goto L48
            java.lang.Object r0 = r6.f2561w
            r0.e r0 = (r0.e) r0
            if (r0 != 0) goto L16
            boolean r7 = r6.f()
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
            com.google.android.gms.internal.measurement.o4 r5 = r0.f.f10843a
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
            boolean r7 = r6.f()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o4.g(java.lang.CharSequence, int):boolean");
    }

    public void h() {
        this.f2560v = false;
    }

    public void i(char c9) {
        ag.o oVar = (ag.o) this.f2561w;
        oVar.f(oVar.f454w, 1);
        char[] cArr = (char[]) oVar.f455x;
        int i = oVar.f454w;
        oVar.f454w = i + 1;
        cArr[i] = c9;
    }

    public synchronized void j(z6.b0 b0Var, boolean z10) {
        try {
            if (this.f2560v || z10) {
                ((Handler) this.f2561w).obtainMessage(1, b0Var).sendToTarget();
            } else {
                this.f2560v = true;
                b0Var.e();
                this.f2560v = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public n4 m(String str, long j4) {
        Long lValueOf = Long.valueOf(j4);
        Object obj = n4.f2543g;
        return new n4(this, str, lValueOf, 0);
    }

    @Override // n.v
    public boolean n(n.k kVar) {
        ((h.h0) this.f2561w).f.onMenuOpened(108, kVar);
        return true;
    }

    public n4 o(String str, boolean z10) {
        Boolean boolValueOf = Boolean.valueOf(z10);
        Object obj = n4.f2543g;
        return new n4(this, str, boolValueOf, 1);
    }

    public n4 p(String str, String str2) {
        Object obj = n4.f2543g;
        return new n4(this, str, str2, 3);
    }

    public /* synthetic */ o4(Object obj) {
        this.f2561w = obj;
        this.f2560v = true;
    }

    public /* synthetic */ o4(Object obj, boolean z10) {
        this.f2561w = obj;
    }

    public o4(int i) {
        switch (i) {
            case 9:
                this.f2561w = new Handler(Looper.getMainLooper(), new ma.a(1));
                break;
            default:
                this.f2561w = new SparseBooleanArray();
                break;
        }
    }

    public o4(r0.e eVar, boolean z10) {
        this((Object) eVar, false);
        this.f2560v = z10;
    }

    public void k() {
    }

    public void l() {
    }
}
