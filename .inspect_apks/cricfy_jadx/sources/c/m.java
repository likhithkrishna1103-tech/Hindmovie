package c;

import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ImmLeaksCleaner;
import androidx.fragment.app.j0;
import androidx.lifecycle.i0;
import androidx.lifecycle.m;
import androidx.lifecycle.p0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import c.i;
import h.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends h0.e implements u0, androidx.lifecycle.i, b5.f {
    public static final /* synthetic */ int P = 0;
    public final j A;
    public final rd.j B;
    public final AtomicInteger C;
    public final l D;
    public final CopyOnWriteArrayList E;
    public final CopyOnWriteArrayList F;
    public final CopyOnWriteArrayList G;
    public final CopyOnWriteArrayList H;
    public final CopyOnWriteArrayList I;
    public final CopyOnWriteArrayList J;
    public boolean K;
    public boolean L;
    public final rd.j M;
    public final rd.j N;
    public final rd.j O;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l8.i f1975w = new l8.i();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l7.a f1976x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bumptech.glide.manager.u f1977y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public t0 f1978z;

    public m() {
        final h.j jVar = (h.j) this;
        int i = 1;
        this.f1976x = new l7.a(new e(jVar, i));
        com.bumptech.glide.manager.u uVar = new com.bumptech.glide.manager.u((b5.f) this);
        this.f1977y = uVar;
        this.A = new j(jVar);
        this.B = new rd.j(new f(jVar, i));
        this.C = new AtomicInteger();
        this.D = new l(jVar);
        this.E = new CopyOnWriteArrayList();
        this.F = new CopyOnWriteArrayList();
        this.G = new CopyOnWriteArrayList();
        this.H = new CopyOnWriteArrayList();
        this.I = new CopyOnWriteArrayList();
        this.J = new CopyOnWriteArrayList();
        this.M = new rd.j(new f(jVar, 2));
        androidx.lifecycle.u uVar2 = this.f5437v;
        if (uVar2 == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        uVar2.a(new h(0, jVar));
        this.f5437v.a(new h(1, jVar));
        this.f5437v.a(new androidx.lifecycle.q() { // from class: androidx.activity.ComponentActivity$4
            @Override // androidx.lifecycle.q
            public final void a(s sVar, m mVar) {
                int i10 = c.m.P;
                j jVar2 = jVar;
                if (jVar2.f1978z == null) {
                    i iVar = (i) jVar2.getLastNonConfigurationInstance();
                    if (iVar != null) {
                        jVar2.f1978z = iVar.f1959a;
                    }
                    if (jVar2.f1978z == null) {
                        jVar2.f1978z = new t0();
                    }
                }
                jVar2.f5437v.f(this);
            }
        });
        uVar.d();
        i0.d(this);
        if (Build.VERSION.SDK_INT == 23) {
            this.f5437v.a(new ImmLeaksCleaner(jVar));
        }
        ((b5.e) uVar.f2291x).f("android:support:activity-result", new androidx.fragment.app.z(jVar, 1));
        i(new androidx.fragment.app.b0(jVar, 1));
        this.N = new rd.j(new f(jVar, 3));
        this.O = new rd.j(new f(jVar, 4));
    }

    public static void g(h.j jVar) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e9) {
            if (!ge.i.a(e9.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e9;
            }
        } catch (NullPointerException e10) {
            if (!ge.i.a(e10.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e10;
            }
        }
    }

    @Override // b5.f
    public final b5.e a() {
        return (b5.e) this.f1977y.f2291x;
    }

    @Override // androidx.lifecycle.i
    public final r0 c() {
        return (r0) this.N.getValue();
    }

    @Override // androidx.lifecycle.i
    public final a7.a d() {
        t1.c cVar = new t1.c(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f307w;
        if (getApplication() != null) {
            linkedHashMap.put(p0.f1190a, getApplication());
        }
        linkedHashMap.put(i0.f1163a, this);
        linkedHashMap.put(i0.f1164b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(i0.f1165c, extras);
        }
        return cVar;
    }

    @Override // androidx.lifecycle.u0
    public final t0 e() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f1978z == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.f1978z = iVar.f1959a;
            }
            if (this.f1978z == null) {
                this.f1978z = new t0();
            }
        }
        t0 t0Var = this.f1978z;
        ge.i.b(t0Var);
        return t0Var;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        return this.f5437v;
    }

    public final void h(s0.a aVar) {
        ge.i.e(aVar, "listener");
        this.E.add(aVar);
    }

    public final void i(d.a aVar) {
        l8.i iVar = this.f1975w;
        iVar.getClass();
        m mVar = (m) iVar.f7898w;
        if (mVar != null) {
            aVar.a(mVar);
        }
        ((CopyOnWriteArraySet) iVar.f7897v).add(aVar);
    }

    public final f0 j() {
        return (f0) this.O.getValue();
    }

    public final void k() {
        View decorView = getWindow().getDecorView();
        ge.i.d(decorView, "getDecorView(...)");
        decorView.setTag(s1.a.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        ge.i.d(decorView2, "getDecorView(...)");
        decorView2.setTag(t1.d.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        ge.i.d(decorView3, "getDecorView(...)");
        decorView3.setTag(b5.a.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        ge.i.d(decorView4, "getDecorView(...)");
        decorView4.setTag(g0.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        ge.i.d(decorView5, "getDecorView(...)");
        decorView5.setTag(g0.report_drawn, this);
        View decorView6 = getWindow().getDecorView();
        ge.i.d(decorView6, "getDecorView(...)");
        decorView6.setTag(o4.j.view_tree_navigation_event_dispatcher_owner, this);
    }

    public final e.g l(e.b bVar, t1 t1Var) {
        l lVar = this.D;
        ge.i.e(lVar, "registry");
        return lVar.c("activity_rq#" + this.C.getAndIncrement(), this, t1Var, bVar);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i10, Intent intent) {
        if (this.D.a(i, i10, intent)) {
            return;
        }
        super.onActivityResult(i, i10, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        ((o4.a) this.M.getValue()).a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        ge.i.e(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator it = this.E.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((s0.a) it.next()).accept(configuration);
        }
    }

    @Override // h0.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f1977y.e(bundle);
        l8.i iVar = this.f1975w;
        iVar.getClass();
        iVar.f7898w = this;
        Iterator it = ((CopyOnWriteArraySet) iVar.f7897v).iterator();
        while (it.hasNext()) {
            ((d.a) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = androidx.lifecycle.g0.f1156w;
        androidx.lifecycle.d0.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        ge.i.e(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f1976x.f7867x).iterator();
        while (it.hasNext()) {
            ((j0) it.next()).f1007a.k();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        ge.i.e(menuItem, "item");
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            Iterator it = ((CopyOnWriteArrayList) this.f1976x.f7867x).iterator();
            while (it.hasNext()) {
                if (((j0) it.next()).f1007a.p()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z10) {
        if (this.K) {
            return;
        }
        Iterator it = this.H.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((s0.a) it.next()).accept(new h0.f(z10));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        ge.i.e(intent, "intent");
        super.onNewIntent(intent);
        Iterator it = this.G.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((s0.a) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        ge.i.e(menu, "menu");
        Iterator it = ((CopyOnWriteArrayList) this.f1976x.f7867x).iterator();
        while (it.hasNext()) {
            ((j0) it.next()).f1007a.q();
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z10) {
        if (this.L) {
            return;
        }
        Iterator it = this.I.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((s0.a) it.next()).accept(new h0.s(z10));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        ge.i.e(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f1976x.f7867x).iterator();
        while (it.hasNext()) {
            ((j0) it.next()).f1007a.t();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        ge.i.e(strArr, "permissions");
        ge.i.e(iArr, "grantResults");
        if (this.D.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        t0 t0Var = this.f1978z;
        if (t0Var == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            t0Var = iVar.f1959a;
        }
        if (t0Var == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f1959a = t0Var;
        return iVar2;
    }

    @Override // h0.e, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        ge.i.e(bundle, "outState");
        androidx.lifecycle.u uVar = this.f5437v;
        if (uVar != null) {
            ge.i.c(uVar, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            uVar.g(androidx.lifecycle.n.f1181x);
        }
        super.onSaveInstanceState(bundle);
        this.f1977y.f(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.F.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((s0.a) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.J.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (com.bumptech.glide.c.y()) {
                com.bumptech.glide.c.b("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            w wVar = (w) this.B.getValue();
            synchronized (wVar.f1988a) {
                try {
                    wVar.f1989b = true;
                    ArrayList arrayList = wVar.f1990c;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((fe.a) obj).b();
                    }
                    wVar.f1990c.clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        k();
        View decorView = getWindow().getDecorView();
        ge.i.d(decorView, "getDecorView(...)");
        j jVar = this.A;
        jVar.getClass();
        if (!jVar.f1962x) {
            jVar.f1962x = true;
            decorView.getViewTreeObserver().addOnDrawListener(jVar);
        }
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i) {
        ge.i.e(intent, "intent");
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i10, int i11, int i12) throws IntentSender.SendIntentException {
        ge.i.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i10, i11, i12);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        ge.i.e(intent, "intent");
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i10, int i11, int i12, Bundle bundle) throws IntentSender.SendIntentException {
        ge.i.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i10, i11, i12, bundle);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        ge.i.e(configuration, "newConfig");
        this.K = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.K = false;
            Iterator it = this.H.iterator();
            ge.i.d(it, "iterator(...)");
            while (it.hasNext()) {
                ((s0.a) it.next()).accept(new h0.f(z10));
            }
        } catch (Throwable th) {
            this.K = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        ge.i.e(configuration, "newConfig");
        this.L = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.L = false;
            Iterator it = this.I.iterator();
            ge.i.d(it, "iterator(...)");
            while (it.hasNext()) {
                ((s0.a) it.next()).accept(new h0.s(z10));
            }
        } catch (Throwable th) {
            this.L = false;
            throw th;
        }
    }
}
