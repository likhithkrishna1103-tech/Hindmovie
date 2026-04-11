package q0;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.PathInterpolator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap f10475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f10476b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f10477c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f10478d = {d0.c.accessibility_custom_action_0, d0.c.accessibility_custom_action_1, d0.c.accessibility_custom_action_2, d0.c.accessibility_custom_action_3, d0.c.accessibility_custom_action_4, d0.c.accessibility_custom_action_5, d0.c.accessibility_custom_action_6, d0.c.accessibility_custom_action_7, d0.c.accessibility_custom_action_8, d0.c.accessibility_custom_action_9, d0.c.accessibility_custom_action_10, d0.c.accessibility_custom_action_11, d0.c.accessibility_custom_action_12, d0.c.accessibility_custom_action_13, d0.c.accessibility_custom_action_14, d0.c.accessibility_custom_action_15, d0.c.accessibility_custom_action_16, d0.c.accessibility_custom_action_17, d0.c.accessibility_custom_action_18, d0.c.accessibility_custom_action_19, d0.c.accessibility_custom_action_20, d0.c.accessibility_custom_action_21, d0.c.accessibility_custom_action_22, d0.c.accessibility_custom_action_23, d0.c.accessibility_custom_action_24, d0.c.accessibility_custom_action_25, d0.c.accessibility_custom_action_26, d0.c.accessibility_custom_action_27, d0.c.accessibility_custom_action_28, d0.c.accessibility_custom_action_29, d0.c.accessibility_custom_action_30, d0.c.accessibility_custom_action_31};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a0 f10479e = new a0();
    public static final c0 f = new c0();

    public static t0 a(View view) {
        if (f10475a == null) {
            f10475a = new WeakHashMap();
        }
        t0 t0Var = (t0) f10475a.get(view);
        if (t0Var != null) {
            return t0Var;
        }
        t0 t0Var2 = new t0(view);
        f10475a.put(view, t0Var2);
        return t0Var2;
    }

    public static r1 b(View view, r1 r1Var) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets windowInsetsG = r1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsA = i >= 30 ? l0.a(view, windowInsetsG) : d0.a(view, windowInsetsG);
            if (!windowInsetsA.equals(windowInsetsG)) {
                return r1.h(view, windowInsetsA);
            }
        }
        return r1Var;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = n0.f10470d;
        n0 n0Var = (n0) view.getTag(d0.c.tag_unhandled_key_event_manager);
        if (n0Var == null) {
            n0Var = new n0();
            n0Var.f10471a = null;
            n0Var.f10472b = null;
            n0Var.f10473c = null;
            view.setTag(d0.c.tag_unhandled_key_event_manager, n0Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = n0Var.f10471a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = n0.f10470d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (n0Var.f10471a == null) {
                            n0Var.f10471a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = n0.f10470d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                n0Var.f10471a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    n0Var.f10471a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View viewA = n0Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (n0Var.f10472b == null) {
                    n0Var.f10472b = new SparseArray();
                }
                n0Var.f10472b.put(keyCode, new WeakReference(viewA));
            }
        }
        return viewA != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return k0.a(view);
        }
        if (f10477c) {
            return null;
        }
        if (f10476b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f10476b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f10477c = true;
                return null;
            }
        }
        try {
            Object obj = f10476b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f10477c = true;
            return null;
        }
    }

    public static CharSequence e(View view) {
        Object tag;
        int i = d0.c.tag_accessibility_pane_title;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = j0.a(view);
        } else {
            tag = view.getTag(i);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList f(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(d0.c.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(d0.c.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] g(n.v vVar) {
        return Build.VERSION.SDK_INT >= 31 ? m0.a(vVar) : (String[]) vVar.getTag(d0.c.tag_on_receive_content_mime_types);
    }

    public static void h(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = e(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z2) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z2) {
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
                    } catch (AbstractMethodError e10) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e10);
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

    public static r1 i(View view, r1 r1Var) {
        WindowInsets windowInsetsG = r1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsB = d0.b(view, windowInsetsG);
            if (!windowInsetsB.equals(windowInsetsG)) {
                return r1.h(view, windowInsetsB);
            }
        }
        return r1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static g j(View view, g gVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + gVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return m0.b(view, gVar);
        }
        u0.i iVar = (u0.i) view.getTag(d0.c.tag_on_receive_content_listener);
        q qVar = f10479e;
        if (iVar == null) {
            if (view instanceof q) {
                qVar = (q) view;
            }
            return qVar.a(gVar);
        }
        g gVarA = u0.i.a(view, gVar);
        if (gVarA == null) {
            return null;
        }
        if (view instanceof q) {
            qVar = (q) view;
        }
        return qVar.a(gVarA);
    }

    public static void k(View view, int i) {
        ArrayList arrayListF = f(view);
        for (int i10 = 0; i10 < arrayListF.size(); i10++) {
            if (((r0.d) arrayListF.get(i10)).a() == i) {
                arrayListF.remove(i10);
                return;
            }
        }
    }

    public static void l(View view, r0.d dVar, r0.o oVar) {
        if (oVar == null) {
            k(view, dVar.a());
            h(view, 0);
            return;
        }
        r0.d dVar2 = new r0.d(null, dVar.f11222b, null, oVar, dVar.f11223c);
        View.AccessibilityDelegate accessibilityDelegateD = d(view);
        b bVar = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof a ? ((a) accessibilityDelegateD).f10412a : new b(accessibilityDelegateD);
        if (bVar == null) {
            bVar = new b();
        }
        n(view, bVar);
        k(view, dVar2.a());
        f(view).add(dVar2);
        h(view, 0);
    }

    public static void m(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            k0.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void n(View view, b bVar) {
        if (bVar == null && (d(view) instanceof a)) {
            bVar = new b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(bVar == null ? null : bVar.f10419b);
    }

    public static void o(View view, CharSequence charSequence) {
        new b0(d0.c.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).f(view, charSequence);
        c0 c0Var = f;
        if (charSequence == null) {
            c0Var.f10422u.remove(view);
            view.removeOnAttachStateChangeListener(c0Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(c0Var);
        } else {
            c0Var.f10422u.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(c0Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(c0Var);
            }
        }
    }

    public static void p(ViewGroup viewGroup, u5.d dVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            h0.a(viewGroup, j2.e.h(dVar != null ? (PointerIcon) dVar.f12784v : null));
        }
    }

    public static void q(View view, c3.e eVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new y0(eVar));
            return;
        }
        PathInterpolator pathInterpolator = x0.f10512e;
        View.OnApplyWindowInsetsListener w0Var = new w0(view, eVar);
        view.setTag(d0.c.tag_window_insets_animation_callback, w0Var);
        if (view.getTag(d0.c.tag_compat_insets_dispatch) == null && view.getTag(d0.c.tag_on_apply_window_listener) == null) {
            view.setOnApplyWindowInsetsListener(w0Var);
        }
    }
}
