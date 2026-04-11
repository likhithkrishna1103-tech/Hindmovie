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
import java.util.List;
import java.util.WeakHashMap;
import q0.o0;
import q0.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x implements Window.Callback {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Window.Callback f5562u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public wb.c f5563v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f5564w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f5565x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f5566y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ b0 f5567z;

    public x(b0 b0Var, Window.Callback callback) {
        this.f5567z = b0Var;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f5562u = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f5564w = true;
            callback.onContentChanged();
        } finally {
            this.f5564w = false;
        }
    }

    public final boolean b(int i, Menu menu) {
        return this.f5562u.onMenuOpened(i, menu);
    }

    public final void c(int i, Menu menu) {
        this.f5562u.onPanelClosed(i, menu);
    }

    public final void d(List list, Menu menu, int i) {
        l.l.a(this.f5562u, list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f5562u.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z2 = this.f5565x;
        Window.Callback callback = this.f5562u;
        return z2 ? callback.dispatchKeyEvent(keyEvent) : this.f5567z.v(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (!this.f5562u.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            b0 b0Var = this.f5567z;
            b0Var.D();
            com.bumptech.glide.d dVar = b0Var.I;
            if (dVar == null || !dVar.z(keyCode, keyEvent)) {
                a0 a0Var = b0Var.f5422h0;
                if (a0Var == null || !b0Var.I(a0Var, keyEvent.getKeyCode(), keyEvent)) {
                    if (b0Var.f5422h0 == null) {
                        a0 a0VarC = b0Var.C(0);
                        b0Var.J(a0VarC, keyEvent);
                        boolean zI = b0Var.I(a0VarC, keyEvent.getKeyCode(), keyEvent);
                        a0VarC.f5407k = false;
                        if (zI) {
                        }
                    }
                    return false;
                }
                a0 a0Var2 = b0Var.f5422h0;
                if (a0Var2 != null) {
                    a0Var2.f5408l = true;
                    return true;
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f5562u.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f5562u.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f5562u.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f5562u.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f5562u.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f5562u.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f5564w) {
            this.f5562u.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof m.k)) {
            return this.f5562u.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        wb.c cVar = this.f5563v;
        if (cVar != null) {
            View view = i == 0 ? new View(((i0) cVar.f14088v).f5502c.f8443a.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.f5562u.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f5562u.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f5562u.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        b(i, menu);
        b0 b0Var = this.f5567z;
        if (i == 108) {
            b0Var.D();
            com.bumptech.glide.d dVar = b0Var.I;
            if (dVar != null) {
                dVar.i(true);
            }
        } else {
            b0Var.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.f5566y) {
            this.f5562u.onPanelClosed(i, menu);
            return;
        }
        c(i, menu);
        b0 b0Var = this.f5567z;
        if (i == 108) {
            b0Var.D();
            com.bumptech.glide.d dVar = b0Var.I;
            if (dVar != null) {
                dVar.i(false);
                return;
            }
            return;
        }
        if (i == 0) {
            a0 a0VarC = b0Var.C(i);
            if (a0VarC.f5409m) {
                b0Var.t(a0VarC, false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z2) {
        l.m.a(this.f5562u, z2);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        m.k kVar = menu instanceof m.k ? (m.k) menu : null;
        if (i == 0 && kVar == null) {
            return false;
        }
        if (kVar != null) {
            kVar.f8226x = true;
        }
        wb.c cVar = this.f5563v;
        if (cVar != null && i == 0) {
            i0 i0Var = (i0) cVar.f14088v;
            if (!i0Var.f) {
                i0Var.f5502c.f8452l = true;
                i0Var.f = true;
            }
        }
        boolean zOnPreparePanel = this.f5562u.onPreparePanel(i, view, menu);
        if (kVar != null) {
            kVar.f8226x = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        m.k kVar = this.f5567z.C(0).f5405h;
        if (kVar != null) {
            d(list, kVar, i);
        } else {
            d(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return l.k.a(this.f5562u, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f5562u.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z2) {
        this.f5562u.onWindowFocusChanged(z2);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ViewGroup viewGroup;
        b0 b0Var = this.f5567z;
        if (!b0Var.T || i != 0) {
            return l.k.b(this.f5562u, callback, i);
        }
        Context context = b0Var.E;
        ub.o oVar = new ub.o(context, callback);
        l.a aVar = b0Var.O;
        if (aVar != null) {
            aVar.a();
        }
        h4.z zVar = new h4.z(17, b0Var, oVar, false);
        b0Var.D();
        com.bumptech.glide.d dVar = b0Var.I;
        if (dVar != null) {
            b0Var.O = dVar.U(zVar);
        }
        if (b0Var.O == null) {
            t0 t0Var = b0Var.S;
            if (t0Var != null) {
                t0Var.b();
            }
            l.a aVar2 = b0Var.O;
            if (aVar2 != null) {
                aVar2.a();
            }
            int i10 = 1;
            if (b0Var.P == null) {
                if (b0Var.f5418d0) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(g.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        l.c cVar = new l.c(context, 0);
                        cVar.getTheme().setTo(themeNewTheme);
                        context = cVar;
                    }
                    b0Var.P = new ActionBarContextView(context, null);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, g.a.actionModePopupWindowStyle);
                    b0Var.Q = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    b0Var.Q.setContentView(b0Var.P);
                    b0Var.Q.setWidth(-1);
                    context.getTheme().resolveAttribute(g.a.actionBarSize, typedValue, true);
                    b0Var.P.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    b0Var.Q.setHeight(-2);
                    b0Var.R = new r(b0Var, i10);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) b0Var.V.findViewById(g.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(b0Var.z()));
                        b0Var.P = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (b0Var.P != null) {
                t0 t0Var2 = b0Var.S;
                if (t0Var2 != null) {
                    t0Var2.b();
                }
                b0Var.P.e();
                Context context2 = b0Var.P.getContext();
                ActionBarContextView actionBarContextView = b0Var.P;
                l.d dVar2 = new l.d();
                dVar2.f7758w = context2;
                dVar2.f7759x = actionBarContextView;
                dVar2.f7760y = zVar;
                m.k kVar = new m.k(actionBarContextView.getContext());
                kVar.f8214l = 1;
                dVar2.B = kVar;
                kVar.f8209e = dVar2;
                if (oVar.M(dVar2, kVar)) {
                    dVar2.h();
                    b0Var.P.c(dVar2);
                    b0Var.O = dVar2;
                    if (b0Var.U && (viewGroup = b0Var.V) != null && viewGroup.isLaidOut()) {
                        b0Var.P.setAlpha(0.0f);
                        t0 t0VarA = o0.a(b0Var.P);
                        t0VarA.a(1.0f);
                        b0Var.S = t0VarA;
                        t0VarA.d(new s(i10, b0Var));
                    } else {
                        b0Var.P.setAlpha(1.0f);
                        b0Var.P.setVisibility(0);
                        if (b0Var.P.getParent() instanceof View) {
                            View view = (View) b0Var.P.getParent();
                            WeakHashMap weakHashMap = o0.f10475a;
                            q0.d0.c(view);
                        }
                    }
                    if (b0Var.Q != null) {
                        b0Var.F.getDecorView().post(b0Var.R);
                    }
                } else {
                    b0Var.O = null;
                }
            }
            b0Var.L();
            b0Var.O = b0Var.O;
        }
        b0Var.L();
        l.a aVar3 = b0Var.O;
        if (aVar3 != null) {
            return oVar.s(aVar3);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f5562u.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
