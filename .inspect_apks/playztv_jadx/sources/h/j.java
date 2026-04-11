package h;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.w0;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import n.r3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends c.l implements k {
    public boolean R;
    public boolean S;
    public b0 U;
    public final wb.c P = new wb.c(2, new androidx.fragment.app.z(this));
    public final androidx.lifecycle.u Q = new androidx.lifecycle.u(this);
    public boolean T = true;

    public j() {
        ((n.s) this.f2184x.f2861v).f("android:support:lifecycle", new androidx.fragment.app.w(this, 0));
        final int i = 0;
        h(new p0.a(this) { // from class: androidx.fragment.app.x

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h.j f1414b;

            {
                this.f1414b = this;
            }

            @Override // p0.a
            public final void accept(Object obj) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f1414b.P.i();
                        break;
                    default:
                        this.f1414b.P.i();
                        break;
                }
            }
        });
        final int i10 = 1;
        this.F.add(new p0.a(this) { // from class: androidx.fragment.app.x

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h.j f1414b;

            {
                this.f1414b = this;
            }

            @Override // p0.a
            public final void accept(Object obj) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f1414b.P.i();
                        break;
                    default:
                        this.f1414b.P.i();
                        break;
                }
            }
        });
        i(new androidx.fragment.app.y(this, 0));
        ((n.s) this.f2184x.f2861v).f("androidx:appcompat", new h(this));
        i(new i(this));
    }

    public static boolean p(androidx.fragment.app.n0 n0Var) {
        boolean zP = false;
        for (androidx.fragment.app.v vVar : n0Var.f1312c.y()) {
            if (vVar != null) {
                androidx.fragment.app.z zVar = vVar.N;
                if ((zVar == null ? null : zVar.f1426y) != null) {
                    zP |= p(vVar.i());
                }
                w0 w0Var = vVar.f1387j0;
                androidx.lifecycle.n nVar = androidx.lifecycle.n.f1485x;
                if (w0Var != null) {
                    w0Var.g();
                    if (w0Var.f1411x.f1504c.compareTo(nVar) >= 0) {
                        vVar.f1387j0.f1411x.g();
                        zP = true;
                    }
                }
                if (vVar.f1386i0.f1504c.compareTo(nVar) >= 0) {
                    vVar.f1386i0.g();
                    zP = true;
                }
            }
        }
        return zP;
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        b0 b0Var = (b0) m();
        b0Var.x();
        ((ViewGroup) b0Var.V.findViewById(R.id.content)).addView(view, layoutParams);
        b0Var.G.a(b0Var.F.getCallback());
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
        com.bumptech.glide.d dVarN = n();
        if (getWindow().hasFeature(0)) {
            if (dVarN == null || !dVarN.f()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // e0.e, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        com.bumptech.glide.d dVarN = n();
        if (keyCode == 82 && dVarN != null && dVarN.A(keyEvent)) {
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
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.j.dump(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // android.app.Activity
    public final View findViewById(int i) {
        b0 b0Var = (b0) m();
        b0Var.x();
        return b0Var.F.findViewById(i);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        b0 b0Var = (b0) m();
        if (b0Var.J == null) {
            b0Var.D();
            com.bumptech.glide.d dVar = b0Var.I;
            b0Var.J = new l.h(dVar != null ? dVar.u() : b0Var.E);
        }
        return b0Var.J;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = r3.f8521a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        m().b();
    }

    public final q m() {
        if (this.U == null) {
            o oVar = q.f5550u;
            this.U = new b0(this, null, this, this);
        }
        return this.U;
    }

    public final com.bumptech.glide.d n() {
        b0 b0Var = (b0) m();
        b0Var.D();
        return b0Var.I;
    }

    public final androidx.fragment.app.n0 o() {
        return ((androidx.fragment.app.z) this.P.f14088v).f1425x;
    }

    @Override // c.l, android.app.Activity
    public final void onActivityResult(int i, int i10, Intent intent) {
        this.P.i();
        super.onActivityResult(i, i10, intent);
    }

    @Override // c.l, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) throws IllegalAccessException {
        super.onConfigurationChanged(configuration);
        b0 b0Var = (b0) m();
        if (b0Var.f5415a0 && b0Var.U) {
            b0Var.D();
            com.bumptech.glide.d dVar = b0Var.I;
            if (dVar != null) {
                dVar.x();
            }
        }
        n.t tVarA = n.t.a();
        Context context = b0Var.E;
        synchronized (tVarA) {
            tVarA.f8534a.l(context);
        }
        b0Var.f5426m0 = new Configuration(b0Var.E.getResources().getConfiguration());
        b0Var.n(false, false);
    }

    @Override // c.l, e0.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Q.d(androidx.lifecycle.m.ON_CREATE);
        androidx.fragment.app.n0 n0Var = ((androidx.fragment.app.z) this.P.f14088v).f1425x;
        n0Var.E = false;
        n0Var.F = false;
        n0Var.L.i = false;
        n0Var.t(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((androidx.fragment.app.z) this.P.f14088v).f1425x.f.onCreateView(view, str, context, attributeSet);
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

    @Override // c.l, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent intentA;
        if (!r(i, menuItem)) {
            com.bumptech.glide.d dVarN = n();
            if (menuItem.getItemId() != 16908332 || dVarN == null || (dVarN.o() & 4) == 0 || (intentA = e0.c.a(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(intentA)) {
                navigateUpTo(intentA);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent intentA2 = e0.c.a(this);
            if (intentA2 == null) {
                intentA2 = e0.c.a(this);
            }
            if (intentA2 != null) {
                ComponentName component = intentA2.getComponent();
                if (component == null) {
                    component = intentA2.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent intentB = e0.c.b(this, component);
                    while (intentB != null) {
                        arrayList.add(size, intentB);
                        intentB = e0.c.b(this, intentB.getComponent());
                    }
                    arrayList.add(intentA2);
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e10);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            startActivities(intentArr, null);
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
        this.S = false;
        ((androidx.fragment.app.z) this.P.f14088v).f1425x.t(5);
        this.Q.d(androidx.lifecycle.m.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((b0) m()).x();
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        s();
        b0 b0Var = (b0) m();
        b0Var.D();
        com.bumptech.glide.d dVar = b0Var.I;
        if (dVar != null) {
            dVar.O(true);
        }
    }

    @Override // c.l, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.P.i();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        wb.c cVar = this.P;
        cVar.i();
        super.onResume();
        this.S = true;
        ((androidx.fragment.app.z) cVar.f14088v).f1425x.x(true);
    }

    @Override // android.app.Activity
    public final void onStart() throws IllegalAccessException {
        t();
        ((b0) m()).n(true, false);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.P.i();
    }

    @Override // android.app.Activity
    public final void onStop() {
        u();
        b0 b0Var = (b0) m();
        b0Var.D();
        com.bumptech.glide.d dVar = b0Var.I;
        if (dVar != null) {
            dVar.O(false);
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m().m(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        com.bumptech.glide.d dVarN = n();
        if (getWindow().hasFeature(0)) {
            if (dVarN == null || !dVarN.B()) {
                super.openOptionsMenu();
            }
        }
    }

    public final void q() {
        super.onDestroy();
        ((androidx.fragment.app.z) this.P.f14088v).f1425x.k();
        this.Q.d(androidx.lifecycle.m.ON_DESTROY);
    }

    public final boolean r(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return ((androidx.fragment.app.z) this.P.f14088v).f1425x.i();
        }
        return false;
    }

    public final void s() {
        super.onPostResume();
        this.Q.d(androidx.lifecycle.m.ON_RESUME);
        androidx.fragment.app.n0 n0Var = ((androidx.fragment.app.z) this.P.f14088v).f1425x;
        n0Var.E = false;
        n0Var.F = false;
        n0Var.L.i = false;
        n0Var.t(7);
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        k();
        m().i(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
        ((b0) m()).f5428o0 = i;
    }

    public final void t() {
        wb.c cVar = this.P;
        cVar.i();
        androidx.fragment.app.z zVar = (androidx.fragment.app.z) cVar.f14088v;
        super.onStart();
        this.T = false;
        if (!this.R) {
            this.R = true;
            androidx.fragment.app.n0 n0Var = zVar.f1425x;
            n0Var.E = false;
            n0Var.F = false;
            n0Var.L.i = false;
            n0Var.t(4);
        }
        zVar.f1425x.x(true);
        this.Q.d(androidx.lifecycle.m.ON_START);
        androidx.fragment.app.n0 n0Var2 = zVar.f1425x;
        n0Var2.E = false;
        n0Var2.F = false;
        n0Var2.L.i = false;
        n0Var2.t(5);
    }

    public final void u() {
        super.onStop();
        this.T = true;
        while (p(o())) {
        }
        androidx.fragment.app.n0 n0Var = ((androidx.fragment.app.z) this.P.f14088v).f1425x;
        n0Var.F = true;
        n0Var.L.i = true;
        n0Var.t(4);
        this.Q.d(androidx.lifecycle.m.ON_STOP);
    }

    public final void v(Toolbar toolbar) {
        b0 b0Var = (b0) m();
        if (b0Var.D instanceof Activity) {
            b0Var.D();
            com.bumptech.glide.d dVar = b0Var.I;
            if (dVar instanceof n0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            b0Var.J = null;
            if (dVar != null) {
                dVar.y();
            }
            b0Var.I = null;
            Object obj = b0Var.D;
            i0 i0Var = new i0(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : b0Var.K, b0Var.G);
            b0Var.I = i0Var;
            b0Var.G.f5563v = i0Var.f5504e;
            toolbar.setBackInvokedCallbackEnabled(true);
            b0Var.b();
        }
    }

    @Override // c.l, android.app.Activity
    public void setContentView(View view) {
        k();
        m().j(view);
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        m().k(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((androidx.fragment.app.z) this.P.f14088v).f1425x.f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
