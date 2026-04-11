package r9;

import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0.b f11558b;

    public /* synthetic */ c(c0.b bVar, int i) {
        this.f11557a = i;
        this.f11558b = bVar;
    }

    @Override // a.a
    public final void G(int i) {
        switch (this.f11557a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f11558b;
                    if (sideSheetBehavior.A) {
                        sideSheetBehavior.x(1);
                    }
                }
                break;
            default:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f11558b;
                    if (bottomSheetBehavior.f3340e0) {
                        bottomSheetBehavior.H(1);
                    }
                }
                break;
        }
    }

    @Override // a.a
    public final void H(View view, int i, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f11557a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f11558b;
                WeakReference weakReference = sideSheetBehavior.K;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f3466u.S(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.P;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f3466u.d(i);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw l4.a.k(it);
                }
                return;
            default:
                ((BottomSheetBehavior) this.f11558b).z(i10);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.c.I(android.view.View, float, float):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
    @Override // a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean P(android.view.View r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.f11557a
            switch(r0) {
                case 0: goto L41;
                default: goto L5;
            }
        L5:
            c0.b r0 = r4.f11558b
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r0
            int r1 = r0.f3341f0
            r2 = 1
            if (r1 != r2) goto Lf
            goto L3f
        Lf:
            boolean r3 = r0.f3358v0
            if (r3 == 0) goto L14
            goto L3f
        L14:
            r3 = 3
            if (r1 != r3) goto L31
            int r1 = r0.f3354t0
            if (r1 != r6) goto L31
            java.lang.ref.WeakReference r6 = r0.f3350p0
            if (r6 == 0) goto L26
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L27
        L26:
            r6 = 0
        L27:
            if (r6 == 0) goto L31
            r1 = -1
            boolean r6 = r6.canScrollVertically(r1)
            if (r6 == 0) goto L31
            goto L3f
        L31:
            java.lang.System.currentTimeMillis()
            java.lang.ref.WeakReference r6 = r0.f3349o0
            if (r6 == 0) goto L3f
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L3f
            goto L40
        L3f:
            r2 = 0
        L40:
            return r2
        L41:
            c0.b r6 = r4.f11558b
            com.google.android.material.sidesheet.SideSheetBehavior r6 = (com.google.android.material.sidesheet.SideSheetBehavior) r6
            int r0 = r6.B
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L4c
            goto L57
        L4c:
            java.lang.ref.WeakReference r6 = r6.J
            if (r6 == 0) goto L57
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L57
            r1 = r2
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.c.P(android.view.View, int):boolean");
    }

    @Override // a.a
    public final int a(View view, int i) {
        switch (this.f11557a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f11558b;
                return cf.d.f(i, sideSheetBehavior.f3466u.w(), sideSheetBehavior.f3466u.v());
            default:
                return view.getLeft();
        }
    }

    @Override // a.a
    public final int b(View view, int i) {
        switch (this.f11557a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return view.getTop();
            default:
                return cf.d.f(i, ((BottomSheetBehavior) this.f11558b).C(), u());
        }
    }

    @Override // a.a
    public int t(View view) {
        switch (this.f11557a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f11558b;
                return sideSheetBehavior.F + sideSheetBehavior.I;
            default:
                return super.t(view);
        }
    }

    @Override // a.a
    public int u() {
        switch (this.f11557a) {
            case 1:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f11558b;
                int i = BottomSheetBehavior.f3335z0;
                return bottomSheetBehavior.f3338c0 ? bottomSheetBehavior.f3348n0 : bottomSheetBehavior.f3336a0;
            default:
                return super.u();
        }
    }
}
