package h;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import t0.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Window.Callback {
    public final /* synthetic */ a0 A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Window.Callback f5403v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public pc.c f5404w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f5405x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f5406y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5407z;

    public w(a0 a0Var, Window.Callback callback) {
        this.A = a0Var;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f5403v = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f5405x = true;
            callback.onContentChanged();
        } finally {
            this.f5405x = false;
        }
    }

    public final boolean b(int i, Menu menu) {
        return this.f5403v.onMenuOpened(i, menu);
    }

    public final void c(int i, Menu menu) {
        this.f5403v.onPanelClosed(i, menu);
    }

    public final void d(List list, Menu menu, int i) {
        m.l.a(this.f5403v, list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f5403v.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z10 = this.f5406y;
        Window.Callback callback = this.f5403v;
        return z10 ? callback.dispatchKeyEvent(keyEvent) : this.A.t(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (!this.f5403v.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            a0 a0Var = this.A;
            a0Var.D();
            vf.g gVar = a0Var.J;
            if (gVar == null || !gVar.L(keyCode, keyEvent)) {
                z zVar = a0Var.f5269h0;
                if (zVar == null || !a0Var.I(zVar, keyEvent.getKeyCode(), keyEvent)) {
                    if (a0Var.f5269h0 == null) {
                        z zVarC = a0Var.C(0);
                        a0Var.J(zVarC, keyEvent);
                        boolean zI = a0Var.I(zVarC, keyEvent.getKeyCode(), keyEvent);
                        zVarC.f5419k = false;
                        if (zI) {
                        }
                    }
                    return false;
                }
                z zVar2 = a0Var.f5269h0;
                if (zVar2 != null) {
                    zVar2.f5420l = true;
                    return true;
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f5403v.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f5403v.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f5403v.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f5403v.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f5403v.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f5403v.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f5405x) {
            this.f5403v.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof n.k)) {
            return this.f5403v.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        pc.c cVar = this.f5404w;
        if (cVar != null) {
            View view = i == 0 ? new View(((h0) cVar.f10180v).f5349e.f9308a.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.f5403v.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f5403v.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f5403v.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        b(i, menu);
        a0 a0Var = this.A;
        if (i == 108) {
            a0Var.D();
            vf.g gVar = a0Var.J;
            if (gVar != null) {
                gVar.w(true);
            }
        } else {
            a0Var.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.f5407z) {
            this.f5403v.onPanelClosed(i, menu);
            return;
        }
        c(i, menu);
        a0 a0Var = this.A;
        if (i == 108) {
            a0Var.D();
            vf.g gVar = a0Var.J;
            if (gVar != null) {
                gVar.w(false);
                return;
            }
            return;
        }
        if (i == 0) {
            z zVarC = a0Var.C(i);
            if (zVarC.f5421m) {
                a0Var.r(zVarC, false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z10) {
        m.m.a(this.f5403v, z10);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        n.k kVar = menu instanceof n.k ? (n.k) menu : null;
        if (i == 0 && kVar == null) {
            return false;
        }
        if (kVar != null) {
            kVar.f8540x = true;
        }
        pc.c cVar = this.f5404w;
        if (cVar != null && i == 0) {
            h0 h0Var = (h0) cVar.f10180v;
            if (!h0Var.f5351h) {
                h0Var.f5349e.f9317l = true;
                h0Var.f5351h = true;
            }
        }
        boolean zOnPreparePanel = this.f5403v.onPreparePanel(i, view, menu);
        if (kVar != null) {
            kVar.f8540x = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        n.k kVar = this.A.C(0).f5417h;
        if (kVar != null) {
            d(list, kVar, i);
        } else {
            d(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return m.k.a(this.f5403v, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f5403v.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z10) {
        this.f5403v.onWindowFocusChanged(z10);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ViewGroup viewGroup;
        if (i != 0) {
            return m.k.b(this.f5403v, callback, i);
        }
        a0 a0Var = this.A;
        Context context = a0Var.F;
        nc.p pVar = new nc.p();
        pVar.f9070b = context;
        pVar.f9069a = callback;
        pVar.f9071c = new ArrayList();
        boolean z10 = false;
        pVar.f9072d = new v.k(0);
        m.a aVar = a0Var.P;
        if (aVar != null) {
            aVar.a();
        }
        l4.c0 c0Var = new l4.c0(27, a0Var, pVar, z10);
        a0Var.D();
        vf.g gVar = a0Var.J;
        if (gVar != null) {
            a0Var.P = gVar.Z(c0Var);
        }
        if (a0Var.P == null) {
            q0 q0Var = a0Var.T;
            if (q0Var != null) {
                q0Var.b();
            }
            m.a aVar2 = a0Var.P;
            if (aVar2 != null) {
                aVar2.a();
            }
            int i10 = 1;
            if (a0Var.Q == null) {
                if (a0Var.f5265d0) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(g.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        m.c cVar = new m.c(context, 0);
                        cVar.getTheme().setTo(themeNewTheme);
                        context = cVar;
                    }
                    a0Var.Q = new ActionBarContextView(context, null);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, g.a.actionModePopupWindowStyle);
                    a0Var.R = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    a0Var.R.setContentView(a0Var.Q);
                    a0Var.R.setWidth(-1);
                    context.getTheme().resolveAttribute(g.a.actionBarSize, typedValue, true);
                    a0Var.Q.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    a0Var.R.setHeight(-2);
                    a0Var.S = new q(a0Var, i10);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) a0Var.V.findViewById(g.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(a0Var.z()));
                        a0Var.Q = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (a0Var.Q != null) {
                q0 q0Var2 = a0Var.T;
                if (q0Var2 != null) {
                    q0Var2.b();
                }
                a0Var.Q.e();
                Context context2 = a0Var.Q.getContext();
                ActionBarContextView actionBarContextView = a0Var.Q;
                m.d dVar = new m.d();
                dVar.f7973x = context2;
                dVar.f7974y = actionBarContextView;
                dVar.f7975z = c0Var;
                n.k kVar = new n.k(actionBarContextView.getContext());
                kVar.f8528l = 1;
                dVar.C = kVar;
                kVar.f8523e = dVar;
                if (pVar.w(dVar, kVar)) {
                    dVar.g();
                    a0Var.Q.c(dVar);
                    a0Var.P = dVar;
                    if (a0Var.U && (viewGroup = a0Var.V) != null && viewGroup.isLaidOut()) {
                        a0Var.Q.setAlpha(0.0f);
                        q0 q0VarA = t0.m0.a(a0Var.Q);
                        q0VarA.a(1.0f);
                        a0Var.T = q0VarA;
                        q0VarA.d(new s(i10, a0Var));
                    } else {
                        a0Var.Q.setAlpha(1.0f);
                        a0Var.Q.setVisibility(0);
                        if (a0Var.Q.getParent() instanceof View) {
                            View view = (View) a0Var.Q.getParent();
                            WeakHashMap weakHashMap = t0.m0.f11777a;
                            t0.b0.c(view);
                        }
                    }
                    if (a0Var.R != null) {
                        a0Var.G.getDecorView().post(a0Var.S);
                    }
                } else {
                    a0Var.P = null;
                }
            }
            a0Var.L();
            a0Var.P = a0Var.P;
        }
        a0Var.L();
        m.a aVar3 = a0Var.P;
        if (aVar3 != null) {
            return pVar.l(aVar3);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f5403v.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
