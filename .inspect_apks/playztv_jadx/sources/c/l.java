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
import androidx.lifecycle.g0;
import androidx.lifecycle.i0;
import androidx.lifecycle.m;
import androidx.lifecycle.p0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import c.i;
import c.l;
import h.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends e0.e implements u0, androidx.lifecycle.i, x4.d {
    public static final /* synthetic */ int O = 0;
    public final nd.i A;
    public final AtomicInteger B;
    public final k C;
    public final CopyOnWriteArrayList D;
    public final CopyOnWriteArrayList E;
    public final CopyOnWriteArrayList F;
    public final CopyOnWriteArrayList G;
    public final CopyOnWriteArrayList H;
    public final CopyOnWriteArrayList I;
    public boolean J;
    public boolean K;
    public final nd.i L;
    public final nd.i M;
    public final nd.i N;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q7.h f2182v = new q7.h();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final kc.b f2183w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bumptech.glide.manager.s f2184x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public t0 f2185y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j f2186z;

    public l() {
        final h.j jVar = (h.j) this;
        int i = 1;
        this.f2183w = new kc.b(new e(jVar, i));
        com.bumptech.glide.manager.s sVar = new com.bumptech.glide.manager.s((x4.d) this);
        this.f2184x = sVar;
        this.f2186z = new j(jVar);
        this.A = new nd.i(new f(jVar, i));
        this.B = new AtomicInteger();
        this.C = new k(jVar);
        this.D = new CopyOnWriteArrayList();
        this.E = new CopyOnWriteArrayList();
        this.F = new CopyOnWriteArrayList();
        this.G = new CopyOnWriteArrayList();
        this.H = new CopyOnWriteArrayList();
        this.I = new CopyOnWriteArrayList();
        this.L = new nd.i(new f(jVar, 2));
        androidx.lifecycle.u uVar = this.f4244u;
        if (uVar == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        uVar.a(new h(0, jVar));
        this.f4244u.a(new h(1, jVar));
        this.f4244u.a(new androidx.lifecycle.q() { // from class: androidx.activity.ComponentActivity$4
            @Override // androidx.lifecycle.q
            public final void a(s sVar2, m mVar) {
                int i10 = l.O;
                j jVar2 = jVar;
                if (jVar2.f2185y == null) {
                    i iVar = (i) jVar2.getLastNonConfigurationInstance();
                    if (iVar != null) {
                        jVar2.f2185y = iVar.f2170a;
                    }
                    if (jVar2.f2185y == null) {
                        jVar2.f2185y = new t0();
                    }
                }
                jVar2.f4244u.f(this);
            }
        });
        sVar.f();
        i0.d(this);
        if (Build.VERSION.SDK_INT == 23) {
            this.f4244u.a(new ImmLeaksCleaner(jVar));
        }
        ((n.s) sVar.f2861v).f("android:support:activity-result", new androidx.fragment.app.w(jVar, 1));
        i(new androidx.fragment.app.y(jVar, 1));
        this.M = new nd.i(new f(jVar, 3));
        this.N = new nd.i(new f(jVar, 4));
    }

    public static void g(h.j jVar) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e10) {
            if (!be.h.a(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e10;
            }
        } catch (NullPointerException e11) {
            if (!be.h.a(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e11;
            }
        }
    }

    @Override // x4.d
    public final n.s a() {
        return (n.s) this.f2184x.f2861v;
    }

    @Override // androidx.lifecycle.i
    public final r0 c() {
        return (r0) this.M.getValue();
    }

    @Override // androidx.lifecycle.i
    public final n1.c d() {
        n1.c cVar = new n1.c(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f2454v;
        if (getApplication() != null) {
            linkedHashMap.put(p0.f1494a, getApplication());
        }
        linkedHashMap.put(i0.f1466a, this);
        linkedHashMap.put(i0.f1467b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(i0.f1468c, extras);
        }
        return cVar;
    }

    @Override // androidx.lifecycle.u0
    public final t0 e() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f2185y == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.f2185y = iVar.f2170a;
            }
            if (this.f2185y == null) {
                this.f2185y = new t0();
            }
        }
        t0 t0Var = this.f2185y;
        be.h.b(t0Var);
        return t0Var;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        return this.f4244u;
    }

    public final void h(p0.a aVar) {
        be.h.e(aVar, "listener");
        this.D.add(aVar);
    }

    public final void i(d.a aVar) {
        q7.h hVar = this.f2182v;
        hVar.getClass();
        l lVar = (l) hVar.f11048v;
        if (lVar != null) {
            aVar.a(lVar);
        }
        ((CopyOnWriteArraySet) hVar.f11047u).add(aVar);
    }

    public final c0 j() {
        return (c0) this.N.getValue();
    }

    public final void k() {
        View decorView = getWindow().getDecorView();
        be.h.d(decorView, "getDecorView(...)");
        decorView.setTag(m1.a.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        be.h.d(decorView2, "getDecorView(...)");
        decorView2.setTag(n1.d.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        be.h.d(decorView3, "getDecorView(...)");
        decorView3.setTag(x4.a.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        be.h.d(decorView4, "getDecorView(...)");
        decorView4.setTag(d0.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        be.h.d(decorView5, "getDecorView(...)");
        decorView5.setTag(d0.report_drawn, this);
        View decorView6 = getWindow().getDecorView();
        be.h.d(decorView6, "getDecorView(...)");
        decorView6.setTag(j4.j.view_tree_navigation_event_dispatcher_owner, this);
    }

    public final e.g l(cf.d dVar, e.b bVar) {
        k kVar = this.C;
        be.h.e(kVar, "registry");
        return kVar.c("activity_rq#" + this.B.getAndIncrement(), this, dVar, bVar);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i10, Intent intent) {
        if (this.C.a(i, i10, intent)) {
            return;
        }
        super.onActivityResult(i, i10, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        ((j4.a) this.L.getValue()).a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        be.h.e(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator it = this.D.iterator();
        be.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((p0.a) it.next()).accept(configuration);
        }
    }

    @Override // e0.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f2184x.g(bundle);
        q7.h hVar = this.f2182v;
        hVar.getClass();
        hVar.f11048v = this;
        Iterator it = ((CopyOnWriteArraySet) hVar.f11047u).iterator();
        while (it.hasNext()) {
            ((d.a) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = g0.f1459v;
        androidx.lifecycle.d0.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        be.h.e(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f2183w.f7621w).iterator();
        while (it.hasNext()) {
            ((androidx.fragment.app.g0) it.next()).f1281a.j();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        be.h.e(menuItem, "item");
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            Iterator it = ((CopyOnWriteArrayList) this.f2183w.f7621w).iterator();
            while (it.hasNext()) {
                if (((androidx.fragment.app.g0) it.next()).f1281a.o()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z2) {
        if (this.J) {
            return;
        }
        Iterator it = this.G.iterator();
        be.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((p0.a) it.next()).accept(new e0.f(z2));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        be.h.e(intent, "intent");
        super.onNewIntent(intent);
        Iterator it = this.F.iterator();
        be.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((p0.a) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        be.h.e(menu, "menu");
        Iterator it = ((CopyOnWriteArrayList) this.f2183w.f7621w).iterator();
        while (it.hasNext()) {
            ((androidx.fragment.app.g0) it.next()).f1281a.p();
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z2) {
        if (this.K) {
            return;
        }
        Iterator it = this.H.iterator();
        be.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((p0.a) it.next()).accept(new e0.s(z2));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        be.h.e(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f2183w.f7621w).iterator();
        while (it.hasNext()) {
            ((androidx.fragment.app.g0) it.next()).f1281a.s();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        be.h.e(strArr, "permissions");
        be.h.e(iArr, "grantResults");
        if (this.C.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        t0 t0Var = this.f2185y;
        if (t0Var == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            t0Var = iVar.f2170a;
        }
        if (t0Var == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f2170a = t0Var;
        return iVar2;
    }

    @Override // e0.e, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        be.h.e(bundle, "outState");
        androidx.lifecycle.u uVar = this.f4244u;
        if (uVar != null) {
            be.h.c(uVar, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            uVar.g();
        }
        super.onSaveInstanceState(bundle);
        this.f2184x.h(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.E.iterator();
        be.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((p0.a) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.I.iterator();
        be.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (com.bumptech.glide.d.w()) {
                com.bumptech.glide.d.e("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            v vVar = (v) this.A.getValue();
            synchronized (vVar.f2196a) {
                try {
                    vVar.f2197b = true;
                    ArrayList arrayList = vVar.f2198c;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((ae.a) obj).b();
                    }
                    vVar.f2198c.clear();
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
        be.h.d(decorView, "getDecorView(...)");
        j jVar = this.f2186z;
        jVar.getClass();
        if (!jVar.f2173w) {
            jVar.f2173w = true;
            decorView.getViewTreeObserver().addOnDrawListener(jVar);
        }
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i) {
        be.h.e(intent, "intent");
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i10, int i11, int i12) throws IntentSender.SendIntentException {
        be.h.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i10, i11, i12);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        be.h.e(intent, "intent");
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i10, int i11, int i12, Bundle bundle) throws IntentSender.SendIntentException {
        be.h.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i10, i11, i12, bundle);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z2, Configuration configuration) {
        be.h.e(configuration, "newConfig");
        this.J = true;
        try {
            super.onMultiWindowModeChanged(z2, configuration);
            this.J = false;
            Iterator it = this.G.iterator();
            be.h.d(it, "iterator(...)");
            while (it.hasNext()) {
                ((p0.a) it.next()).accept(new e0.f(z2));
            }
        } catch (Throwable th) {
            this.J = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        be.h.e(configuration, "newConfig");
        this.K = true;
        try {
            super.onPictureInPictureModeChanged(z2, configuration);
            this.K = false;
            Iterator it = this.H.iterator();
            be.h.d(it, "iterator(...)");
            while (it.hasNext()) {
                ((p0.a) it.next()).accept(new e0.s(z2));
            }
        } catch (Throwable th) {
            this.K = false;
            throw th;
        }
    }
}
