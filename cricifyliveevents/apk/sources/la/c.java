package la;

import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import w8.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0.b f7946b;

    public /* synthetic */ c(f0.b bVar, int i) {
        this.f7945a = i;
        this.f7946b = bVar;
    }

    @Override // n5.a
    public final void B(int i) {
        switch (this.f7945a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f7946b;
                    if (sideSheetBehavior.B) {
                        sideSheetBehavior.x(1);
                    }
                }
                break;
            default:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f7946b;
                    if (bottomSheetBehavior.f2794f0) {
                        bottomSheetBehavior.H(1);
                    }
                }
                break;
        }
    }

    @Override // n5.a
    public final void C(View view, int i, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f7945a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f7946b;
                WeakReference weakReference = sideSheetBehavior.L;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f2930v.K(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.Q;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f2930v.c(i);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw q4.a.l(it);
                }
                return;
            default:
                ((BottomSheetBehavior) this.f7946b).z(i10);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // n5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: la.c.D(android.view.View, float, float):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
    @Override // n5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean N(android.view.View r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.f7945a
            switch(r0) {
                case 0: goto L41;
                default: goto L5;
            }
        L5:
            f0.b r0 = r4.f7946b
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r0
            int r1 = r0.f2797i0
            r2 = 1
            if (r1 != r2) goto Lf
            goto L3f
        Lf:
            boolean r3 = r0.f2816y0
            if (r3 == 0) goto L14
            goto L3f
        L14:
            r3 = 3
            if (r1 != r3) goto L31
            int r1 = r0.f2812w0
            if (r1 != r6) goto L31
            java.lang.ref.WeakReference r6 = r0.f2806s0
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
            android.os.SystemClock.uptimeMillis()
            java.lang.ref.WeakReference r6 = r0.f2805r0
            if (r6 == 0) goto L3f
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L3f
            goto L40
        L3f:
            r2 = 0
        L40:
            return r2
        L41:
            f0.b r6 = r4.f7946b
            com.google.android.material.sidesheet.SideSheetBehavior r6 = (com.google.android.material.sidesheet.SideSheetBehavior) r6
            int r0 = r6.C
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L4c
            goto L57
        L4c:
            java.lang.ref.WeakReference r6 = r6.K
            if (r6 == 0) goto L57
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L57
            r1 = r2
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: la.c.N(android.view.View, int):boolean");
    }

    @Override // n5.a
    public final int d(View view, int i) {
        switch (this.f7945a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f7946b;
                return e.d(i, sideSheetBehavior.f2930v.t(), sideSheetBehavior.f2930v.s());
            default:
                return view.getLeft();
        }
    }

    @Override // n5.a
    public final int e(View view, int i) {
        switch (this.f7945a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return view.getTop();
            default:
                return e.d(i, ((BottomSheetBehavior) this.f7946b).C(), s());
        }
    }

    @Override // n5.a
    public int r(View view) {
        switch (this.f7945a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f7946b;
                return sideSheetBehavior.G + sideSheetBehavior.J;
            default:
                return super.r(view);
        }
    }

    @Override // n5.a
    public int s() {
        switch (this.f7945a) {
            case 1:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f7946b;
                int i = BottomSheetBehavior.C0;
                return bottomSheetBehavior.f2792d0 ? bottomSheetBehavior.f2804q0 : bottomSheetBehavior.f2790b0;
            default:
                return super.s();
        }
    }
}
