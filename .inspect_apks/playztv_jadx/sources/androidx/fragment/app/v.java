package androidx.fragment.app;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class v implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.s, androidx.lifecycle.u0, androidx.lifecycle.i, x4.d {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final Object f1377q0 = new Object();
    public Bundle A;
    public v B;
    public int D;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public n0 M;
    public z N;
    public v P;
    public int Q;
    public int R;
    public String S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean Y;
    public ViewGroup Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public View f1378a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1379b0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public t f1381d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f1382e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f1383f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public String f1384g0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public androidx.lifecycle.u f1386i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public w0 f1387j0;
    public androidx.lifecycle.m0 l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public com.bumptech.glide.manager.s f1389m0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Bundle f1394v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SparseArray f1395w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bundle f1396x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Boolean f1397y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1393u = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f1398z = UUID.randomUUID().toString();
    public String C = null;
    public Boolean E = null;
    public n0 O = new n0();
    public boolean X = true;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f1380c0 = true;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public androidx.lifecycle.n f1385h0 = androidx.lifecycle.n.f1486y;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final androidx.lifecycle.y f1388k0 = new androidx.lifecycle.y();

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final AtomicInteger f1390n0 = new AtomicInteger();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final ArrayList f1391o0 = new ArrayList();

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final p f1392p0 = new p(this);

    public v() {
        n();
    }

    public void B() {
        this.Y = true;
    }

    public void C() {
        this.Y = true;
    }

    public void E(Bundle bundle) {
        this.Y = true;
    }

    public void F(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.O.N();
        this.K = true;
        this.f1387j0 = new w0(this, e());
        View viewW = w(layoutInflater, viewGroup);
        this.f1378a0 = viewW;
        if (viewW == null) {
            if (this.f1387j0.f1411x != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f1387j0 = null;
            return;
        }
        this.f1387j0.g();
        View view = this.f1378a0;
        w0 w0Var = this.f1387j0;
        be.h.e(view, "<this>");
        view.setTag(m1.a.view_tree_lifecycle_owner, w0Var);
        View view2 = this.f1378a0;
        w0 w0Var2 = this.f1387j0;
        be.h.e(view2, "<this>");
        view2.setTag(n1.d.view_tree_view_model_store_owner, w0Var2);
        View view3 = this.f1378a0;
        w0 w0Var3 = this.f1387j0;
        be.h.e(view3, "<this>");
        view3.setTag(x4.a.view_tree_saved_state_registry_owner, w0Var3);
        this.f1388k0.e(this.f1387j0);
    }

    public final h.j G() {
        h.j jVarH = h();
        if (jVarH != null) {
            return jVarH;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Context H() {
        Context contextJ = j();
        if (contextJ != null) {
            return contextJ;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View I() {
        View view = this.f1378a0;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final void J(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.O.T(parcelable);
        n0 n0Var = this.O;
        n0Var.E = false;
        n0Var.F = false;
        n0Var.L.i = false;
        n0Var.t(1);
    }

    public final void K(int i, int i10, int i11, int i12) {
        if (this.f1381d0 == null && i == 0 && i10 == 0 && i11 == 0 && i12 == 0) {
            return;
        }
        g().f1362b = i;
        g().f1363c = i10;
        g().f1364d = i11;
        g().f1365e = i12;
    }

    public final void L(Bundle bundle) {
        n0 n0Var = this.M;
        if (n0Var != null) {
            if (n0Var == null ? false : n0Var.L()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.A = bundle;
    }

    public final void M() {
        j1.b bVar = j1.c.f6667a;
        j1.c.b(new j1.a(this, "Attempting to set retain instance for fragment " + this));
        j1.c.a(this).getClass();
        this.V = true;
        n0 n0Var = this.M;
        if (n0Var != null) {
            n0Var.L.c(this);
        } else {
            this.W = true;
        }
    }

    public final void N(boolean z2) {
        j1.b bVar = j1.c.f6667a;
        j1.c.b(new j1.a(this, "Attempting to set user visible hint to " + z2 + " for fragment " + this));
        j1.c.a(this).getClass();
        boolean z10 = false;
        if (!this.f1380c0 && z2 && this.f1393u < 5 && this.M != null && p() && this.f1383f0) {
            n0 n0Var = this.M;
            u0 u0VarF = n0Var.f(this);
            v vVar = u0VarF.f1374c;
            if (vVar.f1379b0) {
                if (n0Var.f1311b) {
                    n0Var.H = true;
                } else {
                    vVar.f1379b0 = false;
                    u0VarF.k();
                }
            }
        }
        this.f1380c0 = z2;
        if (this.f1393u < 5 && !z2) {
            z10 = true;
        }
        this.f1379b0 = z10;
        if (this.f1394v != null) {
            this.f1397y = Boolean.valueOf(z2);
        }
    }

    public final void O(Intent intent) {
        z zVar = this.N;
        if (zVar != null) {
            zVar.f1423v.startActivity(intent, null);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Override // x4.d
    public final n.s a() {
        return (n.s) this.f1389m0.f2861v;
    }

    public ga.b b() {
        return new q(this);
    }

    @Override // androidx.lifecycle.i
    public final androidx.lifecycle.r0 c() {
        Application application;
        if (this.M == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.l0 == null) {
            Context applicationContext = H().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && n0.G(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + H().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.l0 = new androidx.lifecycle.m0(application, this, this.A);
        }
        return this.l0;
    }

    @Override // androidx.lifecycle.i
    public final n1.c d() {
        Application application;
        Context applicationContext = H().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && n0.G(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + H().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        n1.c cVar = new n1.c(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f2454v;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.p0.f1494a, application);
        }
        linkedHashMap.put(androidx.lifecycle.i0.f1466a, this);
        linkedHashMap.put(androidx.lifecycle.i0.f1467b, this);
        Bundle bundle = this.A;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.i0.f1468c, bundle);
        }
        return cVar;
    }

    @Override // androidx.lifecycle.u0
    public final androidx.lifecycle.t0 e() {
        if (this.M == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (k() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.M.L.f;
        androidx.lifecycle.t0 t0Var = (androidx.lifecycle.t0) map.get(this.f1398z);
        if (t0Var != null) {
            return t0Var;
        }
        androidx.lifecycle.t0 t0Var2 = new androidx.lifecycle.t0();
        map.put(this.f1398z, t0Var2);
        return t0Var2;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        return this.f1386i0;
    }

    public final t g() {
        if (this.f1381d0 == null) {
            t tVar = new t();
            Object obj = f1377q0;
            tVar.f1366g = obj;
            tVar.f1367h = obj;
            tVar.i = obj;
            tVar.f1368j = 1.0f;
            tVar.f1369k = null;
            this.f1381d0 = tVar;
        }
        return this.f1381d0;
    }

    public final h.j h() {
        z zVar = this.N;
        if (zVar == null) {
            return null;
        }
        return zVar.f1422u;
    }

    public final n0 i() {
        if (this.N != null) {
            return this.O;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final Context j() {
        z zVar = this.N;
        if (zVar == null) {
            return null;
        }
        return zVar.f1423v;
    }

    public final int k() {
        androidx.lifecycle.n nVar = this.f1385h0;
        return (nVar == androidx.lifecycle.n.f1483v || this.P == null) ? nVar.ordinal() : Math.min(nVar.ordinal(), this.P.k());
    }

    public final n0 l() {
        n0 n0Var = this.M;
        if (n0Var != null) {
            return n0Var;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Resources m() {
        return H().getResources();
    }

    public final void n() {
        this.f1386i0 = new androidx.lifecycle.u(this);
        this.f1389m0 = new com.bumptech.glide.manager.s(this);
        this.l0 = null;
        ArrayList arrayList = this.f1391o0;
        p pVar = this.f1392p0;
        if (arrayList.contains(pVar)) {
            return;
        }
        if (this.f1393u >= 0) {
            pVar.a();
        } else {
            arrayList.add(pVar);
        }
    }

    public final void o() {
        n();
        this.f1384g0 = this.f1398z;
        this.f1398z = UUID.randomUUID().toString();
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.L = 0;
        this.M = null;
        this.O = new n0();
        this.N = null;
        this.Q = 0;
        this.R = 0;
        this.S = null;
        this.T = false;
        this.U = false;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.Y = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        G().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.Y = true;
    }

    public final boolean p() {
        return this.N != null && this.F;
    }

    public final boolean q() {
        if (this.T) {
            return true;
        }
        n0 n0Var = this.M;
        if (n0Var != null) {
            v vVar = this.P;
            n0Var.getClass();
            if (vVar == null ? false : vVar.q()) {
                return true;
            }
        }
        return false;
    }

    public final boolean r() {
        return this.L > 0;
    }

    public void s() {
        this.Y = true;
    }

    public void t(int i, int i10, Intent intent) {
        if (n0.G(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i10 + " data: " + intent);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} (");
        sb2.append(this.f1398z);
        if (this.Q != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.Q));
        }
        if (this.S != null) {
            sb2.append(" tag=");
            sb2.append(this.S);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void u(Context context) {
        this.Y = true;
        z zVar = this.N;
        if ((zVar == null ? null : zVar.f1422u) != null) {
            this.Y = true;
        }
    }

    public void v(Bundle bundle) {
        this.Y = true;
        J(bundle);
        n0 n0Var = this.O;
        if (n0Var.f1326s >= 1) {
            return;
        }
        n0Var.E = false;
        n0Var.F = false;
        n0Var.L.i = false;
        n0Var.t(1);
    }

    public View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void x() {
        this.Y = true;
    }

    public void y() {
        this.Y = true;
    }

    public LayoutInflater z(Bundle bundle) {
        z zVar = this.N;
        if (zVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        h.j jVar = zVar.f1426y;
        LayoutInflater layoutInflaterCloneInContext = jVar.getLayoutInflater().cloneInContext(jVar);
        layoutInflaterCloneInContext.setFactory2(this.O.f);
        return layoutInflaterCloneInContext;
    }

    public void D() {
    }

    public void A(Bundle bundle) {
    }
}
