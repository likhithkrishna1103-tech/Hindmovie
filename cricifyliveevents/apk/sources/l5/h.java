package l5;

import android.animation.ObjectAnimator;
import android.view.View;
import g2.p1;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends n {
    public static final String[] W = {"android:visibility:visibility", "android:visibility:parent"};
    public final int V;

    public h(int i) {
        this();
        this.V = i;
    }

    public static void I(v vVar) {
        View view = vVar.f7830b;
        int visibility = view.getVisibility();
        HashMap map = vVar.f7829a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float K(v vVar, float f) {
        Float f10;
        return (vVar == null || (f10 = (Float) vVar.f7829a.get("android:fade:transitionAlpha")) == null) ? f : f10.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static g2.p1 L(l5.v r8, l5.v r9) {
        /*
            g2.p1 r0 = new g2.p1
            r0.<init>()
            r1 = 0
            r0.f4880a = r1
            r0.f4881b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f7829a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f4882c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f4884e = r6
            goto L33
        L2f:
            r0.f4882c = r3
            r0.f4884e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f7829a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f4883d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L56
        L52:
            r0.f4883d = r3
            r0.f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L92
            if (r9 == 0) goto L92
            int r8 = r0.f4882c
            int r9 = r0.f4883d
            if (r8 != r9) goto L6c
            java.lang.Object r3 = r0.f4884e
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            java.lang.Object r4 = r0.f
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            if (r3 != r4) goto L6c
            goto La7
        L6c:
            if (r8 == r9) goto L7c
            if (r8 != 0) goto L75
            r0.f4881b = r1
            r0.f4880a = r2
            return r0
        L75:
            if (r9 != 0) goto La7
            r0.f4881b = r2
            r0.f4880a = r2
            return r0
        L7c:
            java.lang.Object r8 = r0.f
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            if (r8 != 0) goto L87
            r0.f4881b = r1
            r0.f4880a = r2
            return r0
        L87:
            java.lang.Object r8 = r0.f4884e
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            if (r8 != 0) goto La7
            r0.f4881b = r2
            r0.f4880a = r2
            return r0
        L92:
            if (r8 != 0) goto L9d
            int r8 = r0.f4883d
            if (r8 != 0) goto L9d
            r0.f4881b = r2
            r0.f4880a = r2
            return r0
        L9d:
            if (r9 != 0) goto La7
            int r8 = r0.f4882c
            if (r8 != 0) goto La7
            r0.f4881b = r1
            r0.f4880a = r2
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.h.L(l5.v, l5.v):g2.p1");
    }

    public final ObjectAnimator J(View view, float f, float f10) {
        if (f == f10) {
            return null;
        }
        x.f7832a.L(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, x.f7833b, f10);
        g gVar = new g(view);
        objectAnimatorOfFloat.addListener(gVar);
        o().a(gVar);
        return objectAnimatorOfFloat;
    }

    @Override // l5.n
    public final void d(v vVar) {
        I(vVar);
    }

    @Override // l5.n
    public final void g(v vVar) {
        I(vVar);
        View view = vVar.f7830b;
        Float fValueOf = (Float) view.getTag(j.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = view.getVisibility() == 0 ? Float.valueOf(x.f7832a.z(view)) : Float.valueOf(0.0f);
        }
        vVar.f7829a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (L(n(r3, false), r(r3, false)).f4880a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0219  */
    @Override // l5.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r24, l5.v r25, l5.v r26) {
        /*
            Method dump skipped, instruction units count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.h.k(android.view.ViewGroup, l5.v, l5.v):android.animation.Animator");
    }

    @Override // l5.n
    public final String[] q() {
        return W;
    }

    @Override // l5.n
    public final boolean s(v vVar, v vVar2) {
        if (vVar == null && vVar2 == null) {
            return false;
        }
        if (vVar != null && vVar2 != null && vVar2.f7829a.containsKey("android:visibility:visibility") != vVar.f7829a.containsKey("android:visibility:visibility")) {
            return false;
        }
        p1 p1VarL = L(vVar, vVar2);
        if (p1VarL.f4880a) {
            return p1VarL.f4882c == 0 || p1VarL.f4883d == 0;
        }
        return false;
    }

    public h() {
        this.V = 3;
    }
}
