package h;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.b1;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import o.u3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends c.m implements k {
    public boolean S;
    public boolean T;
    public a0 V;
    public final pc.c Q = new pc.c(new androidx.fragment.app.c0(this));
    public final androidx.lifecycle.u R = new androidx.lifecycle.u(this);
    public boolean U = true;

    public j() {
        ((b5.e) this.f1977y.f2291x).f("android:support:lifecycle", new androidx.fragment.app.z(this, 0));
        final int i = 0;
        h(new s0.a(this) { // from class: androidx.fragment.app.a0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h.j f929b;

            {
                this.f929b = this;
            }

            @Override // s0.a
            public final void accept(Object obj) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f929b.Q.I();
                        break;
                    default:
                        this.f929b.Q.I();
                        break;
                }
            }
        });
        final int i10 = 1;
        this.G.add(new s0.a(this) { // from class: androidx.fragment.app.a0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h.j f929b;

            {
                this.f929b = this;
            }

            @Override // s0.a
            public final void accept(Object obj) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f929b.Q.I();
                        break;
                    default:
                        this.f929b.Q.I();
                        break;
                }
            }
        });
        i(new androidx.fragment.app.b0(this, 0));
        ((b5.e) this.f1977y.f2291x).f("androidx:appcompat", new b5.b(this));
        i(new i(this));
    }

    public static boolean p(r0 r0Var) {
        boolean zP = false;
        for (androidx.fragment.app.y yVar : r0Var.f1046c.o()) {
            if (yVar != null) {
                androidx.fragment.app.c0 c0Var = yVar.O;
                if ((c0Var == null ? null : c0Var.A) != null) {
                    zP |= p(yVar.i());
                }
                b1 b1Var = yVar.f1112k0;
                androidx.lifecycle.n nVar = androidx.lifecycle.n.f1181x;
                androidx.lifecycle.n nVar2 = androidx.lifecycle.n.f1182y;
                if (b1Var != null && b1Var.f().f1200c.compareTo(nVar2) >= 0) {
                    yVar.f1112k0.f948z.g(nVar);
                    zP = true;
                }
                if (yVar.f1111j0.f1200c.compareTo(nVar2) >= 0) {
                    yVar.f1111j0.g(nVar);
                    zP = true;
                }
            }
        }
        return zP;
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        a0 a0Var = (a0) m();
        a0Var.v();
        ((ViewGroup) a0Var.V.findViewById(R.id.content)).addView(view, layoutParams);
        a0Var.H.a(a0Var.G.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a7  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void attachBaseContext(android.content.Context r10) {
        /*
            Method dump skipped, instruction units count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.j.attachBaseContext(android.content.Context):void");
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        vf.g gVarN = n();
        if (getWindow().hasFeature(0)) {
            if (gVarN == null || !gVarN.l()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // h0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        vf.g gVarN = n();
        if (keyCode == 82 && gVarN != null && gVarN.M(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.lang.String r6, java.io.FileDescriptor r7, java.io.PrintWriter r8, java.lang.String[] r9) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.j.dump(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // android.app.Activity
    public final View findViewById(int i) {
        a0 a0Var = (a0) m();
        a0Var.v();
        return a0Var.G.findViewById(i);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        a0 a0Var = (a0) m();
        if (a0Var.K == null) {
            a0Var.D();
            vf.g gVar = a0Var.J;
            a0Var.K = new m.h(gVar != null ? gVar.H() : a0Var.F);
        }
        return a0Var.K;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = u3.f9375a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        m().b();
    }

    public final p m() {
        if (this.V == null) {
            o oVar = p.f5394v;
            this.V = new a0(this, null, this, this);
        }
        return this.V;
    }

    public final vf.g n() {
        a0 a0Var = (a0) m();
        a0Var.D();
        return a0Var.J;
    }

    public final r0 o() {
        return ((androidx.fragment.app.c0) this.Q.f10180v).f954z;
    }

    @Override // c.m, android.app.Activity
    public final void onActivityResult(int i, int i10, Intent intent) {
        this.Q.I();
        super.onActivityResult(i, i10, intent);
    }

    @Override // c.m, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) throws IllegalAccessException {
        super.onConfigurationChanged(configuration);
        a0 a0Var = (a0) m();
        if (a0Var.f5262a0 && a0Var.U) {
            a0Var.D();
            vf.g gVar = a0Var.J;
            if (gVar != null) {
                gVar.J();
            }
        }
        o.r rVarA = o.r.a();
        Context context = a0Var.F;
        synchronized (rVarA) {
            rVarA.f9337a.l(context);
        }
        a0Var.f5274m0 = new Configuration(a0Var.F.getResources().getConfiguration());
        a0Var.m(false, false);
    }

    @Override // c.m, h0.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.R.d(androidx.lifecycle.m.ON_CREATE);
        ((androidx.fragment.app.c0) this.Q.f10180v).f954z.j();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((androidx.fragment.app.c0) this.Q.f10180v).f954z.f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        q();
        m().e();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // c.m, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent intentB;
        if (!r(i, menuItem)) {
            vf.g gVarN = n();
            if (menuItem.getItemId() != 16908332 || gVarN == null || (gVarN.F() & 4) == 0 || (intentB = h0.c.b(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(intentB)) {
                navigateUpTo(intentB);
                return true;
            }
            h0.t tVar = new h0.t(this);
            Intent intentB2 = h0.c.b(this);
            if (intentB2 == null) {
                intentB2 = h0.c.b(this);
            }
            if (intentB2 != null) {
                ComponentName component = intentB2.getComponent();
                if (component == null) {
                    component = intentB2.resolveActivity(((Context) tVar.f5471x).getPackageManager());
                }
                tVar.a(component);
                tVar.f5470w.add(intentB2);
            }
            tVar.b();
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.T = false;
        ((androidx.fragment.app.c0) this.Q.f10180v).f954z.u(5);
        this.R.d(androidx.lifecycle.m.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((a0) m()).v();
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        s();
        a0 a0Var = (a0) m();
        a0Var.D();
        vf.g gVar = a0Var.J;
        if (gVar != null) {
            gVar.V(true);
        }
    }

    @Override // c.m, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.Q.I();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        pc.c cVar = this.Q;
        cVar.I();
        super.onResume();
        this.T = true;
        ((androidx.fragment.app.c0) cVar.f10180v).f954z.A(true);
    }

    @Override // android.app.Activity
    public final void onStart() throws IllegalAccessException {
        t();
        ((a0) m()).m(true, false);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.Q.I();
    }

    @Override // android.app.Activity
    public final void onStop() {
        u();
        a0 a0Var = (a0) m();
        a0Var.D();
        vf.g gVar = a0Var.J;
        if (gVar != null) {
            gVar.V(false);
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m().l(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        vf.g gVarN = n();
        if (getWindow().hasFeature(0)) {
            if (gVarN == null || !gVarN.N()) {
                super.openOptionsMenu();
            }
        }
    }

    public final void q() {
        super.onDestroy();
        ((androidx.fragment.app.c0) this.Q.f10180v).f954z.l();
        this.R.d(androidx.lifecycle.m.ON_DESTROY);
    }

    public final boolean r(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return ((androidx.fragment.app.c0) this.Q.f10180v).f954z.i();
        }
        return false;
    }

    public final void s() {
        super.onPostResume();
        this.R.d(androidx.lifecycle.m.ON_RESUME);
        r0 r0Var = ((androidx.fragment.app.c0) this.Q.f10180v).f954z;
        r0Var.F = false;
        r0Var.G = false;
        r0Var.M.i = false;
        r0Var.u(7);
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        k();
        m().h(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
        ((a0) m()).o0 = i;
    }

    public final void t() {
        pc.c cVar = this.Q;
        cVar.I();
        androidx.fragment.app.c0 c0Var = (androidx.fragment.app.c0) cVar.f10180v;
        super.onStart();
        this.U = false;
        if (!this.S) {
            this.S = true;
            r0 r0Var = c0Var.f954z;
            r0Var.F = false;
            r0Var.G = false;
            r0Var.M.i = false;
            r0Var.u(4);
        }
        c0Var.f954z.A(true);
        this.R.d(androidx.lifecycle.m.ON_START);
        r0 r0Var2 = c0Var.f954z;
        r0Var2.F = false;
        r0Var2.G = false;
        r0Var2.M.i = false;
        r0Var2.u(5);
    }

    public final void u() {
        super.onStop();
        this.U = true;
        while (p(o())) {
        }
        r0 r0Var = ((androidx.fragment.app.c0) this.Q.f10180v).f954z;
        r0Var.G = true;
        r0Var.M.i = true;
        r0Var.u(4);
        this.R.d(androidx.lifecycle.m.ON_STOP);
    }

    public final void v(Toolbar toolbar) {
        a0 a0Var = (a0) m();
        if (a0Var.E instanceof Activity) {
            a0Var.D();
            vf.g gVar = a0Var.J;
            if (gVar instanceof m0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            a0Var.K = null;
            if (gVar != null) {
                gVar.K();
            }
            a0Var.J = null;
            Object obj = a0Var.E;
            h0 h0Var = new h0(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : a0Var.L, a0Var.H);
            a0Var.J = h0Var;
            a0Var.H.f5404w = h0Var.f5350g;
            toolbar.setBackInvokedCallbackEnabled(true);
            a0Var.b();
        }
    }

    @Override // c.m, android.app.Activity
    public void setContentView(View view) {
        k();
        m().i(view);
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        m().j(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((androidx.fragment.app.c0) this.Q.f10180v).f954z.f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
