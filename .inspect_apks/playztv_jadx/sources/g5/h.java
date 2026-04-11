package g5;

import a2.b2;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends p {
    public static final String[] V = {"android:visibility:visibility", "android:visibility:parent"};
    public final int U;

    public h(int i) {
        this();
        this.U = i;
    }

    public static void I(x xVar) {
        View view = xVar.f5315b;
        int visibility = view.getVisibility();
        HashMap map = xVar.f5314a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float K(x xVar, float f) {
        Float f4;
        return (xVar == null || (f4 = (Float) xVar.f5314a.get("android:fade:transitionAlpha")) == null) ? f : f4.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a2.b2 L(g5.x r8, g5.x r9) {
        /*
            a2.b2 r0 = new a2.b2
            r0.<init>()
            r1 = 0
            r0.f167a = r1
            r0.f168b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f5314a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f169c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f171e = r6
            goto L33
        L2f:
            r0.f169c = r3
            r0.f171e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f5314a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f170d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L56
        L52:
            r0.f170d = r3
            r0.f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L92
            if (r9 == 0) goto L92
            int r8 = r0.f169c
            int r9 = r0.f170d
            if (r8 != r9) goto L6c
            java.lang.Object r3 = r0.f171e
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            java.lang.Object r4 = r0.f
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            if (r3 != r4) goto L6c
            goto La7
        L6c:
            if (r8 == r9) goto L7c
            if (r8 != 0) goto L75
            r0.f168b = r1
            r0.f167a = r2
            return r0
        L75:
            if (r9 != 0) goto La7
            r0.f168b = r2
            r0.f167a = r2
            return r0
        L7c:
            java.lang.Object r8 = r0.f
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            if (r8 != 0) goto L87
            r0.f168b = r1
            r0.f167a = r2
            return r0
        L87:
            java.lang.Object r8 = r0.f171e
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            if (r8 != 0) goto La7
            r0.f168b = r2
            r0.f167a = r2
            return r0
        L92:
            if (r8 != 0) goto L9d
            int r8 = r0.f170d
            if (r8 != 0) goto L9d
            r0.f168b = r2
            r0.f167a = r2
            return r0
        L9d:
            if (r9 != 0) goto La7
            int r8 = r0.f169c
            if (r8 != 0) goto La7
            r0.f168b = r1
            r0.f167a = r2
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.h.L(g5.x, g5.x):a2.b2");
    }

    public final ObjectAnimator J(View view, float f, float f4) {
        if (f == f4) {
            return null;
        }
        z.f5317a.x(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, z.f5318b, f4);
        g gVar = new g(view);
        objectAnimatorOfFloat.addListener(gVar);
        o().a(gVar);
        return objectAnimatorOfFloat;
    }

    @Override // g5.p
    public final void d(x xVar) {
        I(xVar);
    }

    @Override // g5.p
    public final void g(x xVar) {
        I(xVar);
        View view = xVar.f5315b;
        Float fValueOf = (Float) view.getTag(j.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = view.getVisibility() == 0 ? Float.valueOf(z.f5317a.q(view)) : Float.valueOf(0.0f);
        }
        xVar.f5314a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (L(n(r3, false), r(r3, false)).f167a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0219  */
    @Override // g5.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r24, g5.x r25, g5.x r26) {
        /*
            Method dump skipped, instruction units count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.h.k(android.view.ViewGroup, g5.x, g5.x):android.animation.Animator");
    }

    @Override // g5.p
    public final String[] q() {
        return V;
    }

    @Override // g5.p
    public final boolean s(x xVar, x xVar2) {
        if (xVar == null && xVar2 == null) {
            return false;
        }
        if (xVar != null && xVar2 != null && xVar2.f5314a.containsKey("android:visibility:visibility") != xVar.f5314a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b2 b2VarL = L(xVar, xVar2);
        if (b2VarL.f167a) {
            return b2VarL.f169c == 0 || b2VarL.f170d == 0;
        }
        return false;
    }

    public h() {
        this.U = 3;
    }
}
