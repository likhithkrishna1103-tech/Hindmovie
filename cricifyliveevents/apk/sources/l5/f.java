package l5;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends n {
    public static final String[] V = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final b W = new b(PointF.class, "topLeft", 0);
    public static final b X = new b(PointF.class, "bottomRight", 1);
    public static final b Y = new b(PointF.class, "bottomRight", 2);
    public static final b Z = new b(PointF.class, "topLeft", 3);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final b f7796a0 = new b(PointF.class, "position", 4);

    public static void I(v vVar) {
        View view = vVar.f7830b;
        HashMap map = vVar.f7829a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", view.getParent());
    }

    @Override // l5.n
    public final void d(v vVar) {
        I(vVar);
    }

    @Override // l5.n
    public final void g(v vVar) {
        I(vVar);
    }

    @Override // l5.n
    public final Animator k(ViewGroup viewGroup, v vVar, v vVar2) {
        int i;
        f fVar;
        Animator animatorA;
        if (vVar != null) {
            HashMap map = vVar.f7829a;
            if (vVar2 != null) {
                HashMap map2 = vVar2.f7829a;
                ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view = vVar2.f7830b;
                    Rect rect = (Rect) map.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
                    int i10 = rect.left;
                    int i11 = rect2.left;
                    int i12 = rect.top;
                    int i13 = rect2.top;
                    int i14 = rect.right;
                    int i15 = rect2.right;
                    int i16 = rect.bottom;
                    int i17 = rect2.bottom;
                    int i18 = i14 - i10;
                    int i19 = i16 - i12;
                    int i20 = i15 - i11;
                    int i21 = i17 - i13;
                    Rect rect3 = (Rect) map.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
                    if ((i18 == 0 || i19 == 0) && (i20 == 0 || i21 == 0)) {
                        i = 0;
                    } else {
                        i = (i10 == i11 && i12 == i13) ? 0 : 1;
                        if (i14 != i15 || i16 != i17) {
                            i++;
                        }
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i++;
                    }
                    int i22 = i;
                    if (i22 > 0) {
                        x.a(view, i10, i12, i14, i16);
                        if (i22 != 2) {
                            fVar = this;
                            if (i10 == i11 && i12 == i13) {
                                fVar.Q.getClass();
                                animatorA = i.a(view, Y, f9.z.q(i14, i16, i15, i17));
                            } else {
                                fVar.Q.getClass();
                                animatorA = i.a(view, Z, f9.z.q(i10, i12, i11, i13));
                            }
                        } else if (i18 == i20 && i19 == i21) {
                            fVar = this;
                            fVar.Q.getClass();
                            animatorA = i.a(view, f7796a0, f9.z.q(i10, i12, i11, i13));
                        } else {
                            fVar = this;
                            e eVar = new e(view);
                            fVar.Q.getClass();
                            ObjectAnimator objectAnimatorA = i.a(eVar, W, f9.z.q(i10, i12, i11, i13));
                            fVar.Q.getClass();
                            ObjectAnimator objectAnimatorA2 = i.a(eVar, X, f9.z.q(i14, i16, i15, i17));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
                            animatorSet.addListener(new c(eVar));
                            animatorA = animatorSet;
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            ab.b.E(viewGroup4, true);
                            fVar.o().a(new d(viewGroup4));
                        }
                        return animatorA;
                    }
                }
            }
        }
        return null;
    }

    @Override // l5.n
    public final String[] q() {
        return V;
    }
}
