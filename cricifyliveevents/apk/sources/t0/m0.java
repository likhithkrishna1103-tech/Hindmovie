package t0;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.PathInterpolator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap f11777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f11778b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f11779c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f11780d = {g0.c.accessibility_custom_action_0, g0.c.accessibility_custom_action_1, g0.c.accessibility_custom_action_2, g0.c.accessibility_custom_action_3, g0.c.accessibility_custom_action_4, g0.c.accessibility_custom_action_5, g0.c.accessibility_custom_action_6, g0.c.accessibility_custom_action_7, g0.c.accessibility_custom_action_8, g0.c.accessibility_custom_action_9, g0.c.accessibility_custom_action_10, g0.c.accessibility_custom_action_11, g0.c.accessibility_custom_action_12, g0.c.accessibility_custom_action_13, g0.c.accessibility_custom_action_14, g0.c.accessibility_custom_action_15, g0.c.accessibility_custom_action_16, g0.c.accessibility_custom_action_17, g0.c.accessibility_custom_action_18, g0.c.accessibility_custom_action_19, g0.c.accessibility_custom_action_20, g0.c.accessibility_custom_action_21, g0.c.accessibility_custom_action_22, g0.c.accessibility_custom_action_23, g0.c.accessibility_custom_action_24, g0.c.accessibility_custom_action_25, g0.c.accessibility_custom_action_26, g0.c.accessibility_custom_action_27, g0.c.accessibility_custom_action_28, g0.c.accessibility_custom_action_29, g0.c.accessibility_custom_action_30, g0.c.accessibility_custom_action_31};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f11781e = new y();
    public static final a0 f = new a0();

    public static q0 a(View view) {
        if (f11777a == null) {
            f11777a = new WeakHashMap();
        }
        q0 q0Var = (q0) f11777a.get(view);
        if (q0Var != null) {
            return q0Var;
        }
        q0 q0Var2 = new q0(view);
        f11777a.put(view, q0Var2);
        return q0Var2;
    }

    public static p1 b(View view, p1 p1Var) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets windowInsetsG = p1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsA = i >= 30 ? j0.a(view, windowInsetsG) : b0.a(view, windowInsetsG);
            if (!windowInsetsA.equals(windowInsetsG)) {
                return p1.h(view, windowInsetsA);
            }
        }
        return p1Var;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = l0.f11772d;
        l0 l0Var = (l0) view.getTag(g0.c.tag_unhandled_key_event_manager);
        if (l0Var == null) {
            l0Var = new l0();
            l0Var.f11773a = null;
            l0Var.f11774b = null;
            l0Var.f11775c = null;
            view.setTag(g0.c.tag_unhandled_key_event_manager, l0Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = l0Var.f11773a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = l0.f11772d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (l0Var.f11773a == null) {
                            l0Var.f11773a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = l0.f11772d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                l0Var.f11773a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    l0Var.f11773a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View viewA = l0Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (l0Var.f11774b == null) {
                    l0Var.f11774b = new SparseArray();
                }
                l0Var.f11774b.put(keyCode, new WeakReference(viewA));
            }
        }
        return viewA != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return i0.a(view);
        }
        if (f11779c) {
            return null;
        }
        if (f11778b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f11778b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f11779c = true;
                return null;
            }
        }
        try {
            Object obj = f11778b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f11779c = true;
            return null;
        }
    }

    public static CharSequence e(View view) {
        Object tag;
        int i = g0.c.tag_accessibility_pane_title;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = h0.a(view);
        } else {
            tag = view.getTag(i);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList f(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(g0.c.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(g0.c.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] g(o.t tVar) {
        return Build.VERSION.SDK_INT >= 31 ? k0.a(tVar) : (String[]) tVar.getTag(g0.c.tag_on_receive_content_mime_types);
    }

    public static void h(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = e(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z10) {
                    accessibilityEventObtain.getText().add(e(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e9) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e9);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(e(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static p1 i(View view, p1 p1Var) {
        WindowInsets windowInsetsG = p1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsB = b0.b(view, windowInsetsG);
            if (!windowInsetsB.equals(windowInsetsG)) {
                return p1.h(view, windowInsetsB);
            }
        }
        return p1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f j(View view, f fVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + fVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return k0.b(view, fVar);
        }
        x0.i iVar = (x0.i) view.getTag(g0.c.tag_on_receive_content_listener);
        p pVar = f11781e;
        if (iVar == null) {
            if (view instanceof p) {
                pVar = (p) view;
            }
            return pVar.a(fVar);
        }
        f fVarA = x0.i.a(view, fVar);
        if (fVarA == null) {
            return null;
        }
        if (view instanceof p) {
            pVar = (p) view;
        }
        return pVar.a(fVarA);
    }

    public static void k(View view, int i) {
        ArrayList arrayListF = f(view);
        for (int i10 = 0; i10 < arrayListF.size(); i10++) {
            if (((u0.c) arrayListF.get(i10)).a() == i) {
                arrayListF.remove(i10);
                return;
            }
        }
    }

    public static void l(View view, u0.c cVar, u0.o oVar) {
        if (oVar == null) {
            k(view, cVar.a());
            h(view, 0);
            return;
        }
        u0.c cVar2 = new u0.c(null, cVar.f12057b, null, oVar, cVar.f12058c);
        View.AccessibilityDelegate accessibilityDelegateD = d(view);
        b bVar = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof a ? ((a) accessibilityDelegateD).f11723a : new b(accessibilityDelegateD);
        if (bVar == null) {
            bVar = new b();
        }
        n(view, bVar);
        k(view, cVar2.a());
        f(view).add(cVar2);
        h(view, 0);
    }

    public static void m(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            i0.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void n(View view, b bVar) {
        if (bVar == null && (d(view) instanceof a)) {
            bVar = new b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(bVar == null ? null : bVar.f11732b);
    }

    public static void o(View view, CharSequence charSequence) {
        new z(g0.c.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).f(view, charSequence);
        a0 a0Var = f;
        if (charSequence == null) {
            a0Var.f11724v.remove(view);
            view.removeOnAttachStateChangeListener(a0Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(a0Var);
        } else {
            a0Var.f11724v.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(a0Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(a0Var);
            }
        }
    }

    public static void p(View view, a7.a aVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new w0(aVar));
            return;
        }
        PathInterpolator pathInterpolator = u0.f11811e;
        View.OnApplyWindowInsetsListener t0Var = new t0(view, aVar);
        view.setTag(g0.c.tag_window_insets_animation_callback, t0Var);
        if (view.getTag(g0.c.tag_compat_insets_dispatch) == null && view.getTag(g0.c.tag_on_apply_window_listener) == null) {
            view.setOnApplyWindowInsetsListener(t0Var);
        }
    }
}
