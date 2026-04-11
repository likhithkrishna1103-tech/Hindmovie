package androidx.fragment.app;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.measurement.z3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.s, androidx.lifecycle.u0, androidx.lifecycle.i, b5.f {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final Object f1101r0 = new Object();
    public Bundle B;
    public y C;
    public int E;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public r0 N;
    public c0 O;
    public y Q;
    public int R;
    public int S;
    public String T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public ViewGroup f1102a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public View f1103b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f1104c0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public w f1106e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f1107f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f1108g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public String f1109h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public androidx.lifecycle.n f1110i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public androidx.lifecycle.u f1111j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public b1 f1112k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final androidx.lifecycle.y f1113l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public androidx.lifecycle.m0 f1114m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public com.bumptech.glide.manager.u f1115n0;
    public final AtomicInteger o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final ArrayList f1116p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final s f1117q0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bundle f1119w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SparseArray f1120x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Bundle f1121y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Boolean f1122z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1118v = -1;
    public String A = UUID.randomUUID().toString();
    public String D = null;
    public Boolean F = null;
    public r0 P = new r0();
    public boolean Y = true;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f1105d0 = true;

    public y() {
        new m(1, this);
        this.f1110i0 = androidx.lifecycle.n.f1183z;
        this.f1113l0 = new androidx.lifecycle.y();
        this.o0 = new AtomicInteger();
        this.f1116p0 = new ArrayList();
        this.f1117q0 = new s(this);
        n();
    }

    public LayoutInflater A(Bundle bundle) {
        c0 c0Var = this.O;
        if (c0Var == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        h.j jVar = c0Var.A;
        LayoutInflater layoutInflaterCloneInContext = jVar.getLayoutInflater().cloneInContext(jVar);
        layoutInflaterCloneInContext.setFactory2(this.P.f);
        return layoutInflaterCloneInContext;
    }

    public void B(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.Z = true;
        c0 c0Var = this.O;
        if ((c0Var == null ? null : c0Var.f951w) != null) {
            this.Z = true;
        }
    }

    public void E() {
        this.Z = true;
    }

    public void F() {
        this.Z = true;
    }

    public void H(Bundle bundle) {
        this.Z = true;
    }

    public void I(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.P.Q();
        this.L = true;
        this.f1112k0 = new b1(this, e(), new androidx.emoji2.text.w(1, this));
        View viewX = x(layoutInflater, viewGroup);
        this.f1103b0 = viewX;
        if (viewX == null) {
            if (this.f1112k0.f948z != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f1112k0 = null;
            return;
        }
        this.f1112k0.g();
        if (r0.J(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.f1103b0 + " for Fragment " + this);
        }
        View view = this.f1103b0;
        b1 b1Var = this.f1112k0;
        ge.i.e(view, "<this>");
        view.setTag(s1.a.view_tree_lifecycle_owner, b1Var);
        View view2 = this.f1103b0;
        b1 b1Var2 = this.f1112k0;
        ge.i.e(view2, "<this>");
        view2.setTag(t1.d.view_tree_view_model_store_owner, b1Var2);
        View view3 = this.f1103b0;
        b1 b1Var3 = this.f1112k0;
        ge.i.e(view3, "<this>");
        view3.setTag(b5.a.view_tree_saved_state_registry_owner, b1Var3);
        this.f1113l0.e(this.f1112k0);
    }

    public final h.j J() {
        h.j jVarH = h();
        if (jVarH != null) {
            return jVarH;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Context K() {
        Context contextJ = j();
        if (contextJ != null) {
            return contextJ;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View L() {
        View view = this.f1103b0;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final void M(int i, int i10, int i11, int i12) {
        if (this.f1106e0 == null && i == 0 && i10 == 0 && i11 == 0 && i12 == 0) {
            return;
        }
        g().f1088b = i;
        g().f1089c = i10;
        g().f1090d = i11;
        g().f1091e = i12;
    }

    public final void N(Bundle bundle) {
        r0 r0Var = this.N;
        if (r0Var != null) {
            if (r0Var == null ? false : r0Var.O()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.B = bundle;
    }

    public final void O() {
        p1.b bVar = p1.c.f9883a;
        p1.c.b(new p1.a(this, "Attempting to set retain instance for fragment " + this));
        p1.c.a(this).getClass();
        this.W = true;
        r0 r0Var = this.N;
        if (r0Var != null) {
            r0Var.M.c(this);
        } else {
            this.X = true;
        }
    }

    public final void P(boolean z10) {
        p1.b bVar = p1.c.f9883a;
        p1.c.b(new p1.a(this, "Attempting to set user visible hint to " + z10 + " for fragment " + this));
        p1.c.a(this).getClass();
        boolean z11 = false;
        if (!this.f1105d0 && z10 && this.f1118v < 5 && this.N != null && p() && this.f1108g0) {
            r0 r0Var = this.N;
            z0 z0VarF = r0Var.f(this);
            y yVar = z0VarF.f1129c;
            if (yVar.f1104c0) {
                if (r0Var.f1045b) {
                    r0Var.I = true;
                } else {
                    yVar.f1104c0 = false;
                    z0VarF.k();
                }
            }
        }
        this.f1105d0 = z10;
        if (this.f1118v < 5 && !z10) {
            z11 = true;
        }
        this.f1104c0 = z11;
        if (this.f1119w != null) {
            this.f1122z = Boolean.valueOf(z10);
        }
    }

    public final void Q(Intent intent) {
        c0 c0Var = this.O;
        if (c0Var != null) {
            c0Var.f952x.startActivity(intent, null);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Override // b5.f
    public final b5.e a() {
        return (b5.e) this.f1115n0.f2291x;
    }

    public z3 b() {
        return new t(this);
    }

    @Override // androidx.lifecycle.i
    public final androidx.lifecycle.r0 c() {
        Application application;
        if (this.N == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.f1114m0 == null) {
            Context applicationContext = K().getApplicationContext();
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
            if (application == null && r0.J(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + K().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.f1114m0 = new androidx.lifecycle.m0(application, this, this.B);
        }
        return this.f1114m0;
    }

    @Override // androidx.lifecycle.i
    public final a7.a d() {
        Application application;
        Context applicationContext = K().getApplicationContext();
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
        if (application == null && r0.J(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + K().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        t1.c cVar = new t1.c(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f307w;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.p0.f1190a, application);
        }
        linkedHashMap.put(androidx.lifecycle.i0.f1163a, this);
        linkedHashMap.put(androidx.lifecycle.i0.f1164b, this);
        Bundle bundle = this.B;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.i0.f1165c, bundle);
        }
        return cVar;
    }

    @Override // androidx.lifecycle.u0
    public final androidx.lifecycle.t0 e() {
        if (this.N == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (k() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.N.M.f;
        androidx.lifecycle.t0 t0Var = (androidx.lifecycle.t0) map.get(this.A);
        if (t0Var != null) {
            return t0Var;
        }
        androidx.lifecycle.t0 t0Var2 = new androidx.lifecycle.t0();
        map.put(this.A, t0Var2);
        return t0Var2;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        return this.f1111j0;
    }

    public final w g() {
        if (this.f1106e0 == null) {
            w wVar = new w();
            Object obj = f1101r0;
            wVar.f1092g = obj;
            wVar.f1093h = obj;
            wVar.i = obj;
            wVar.f1094j = 1.0f;
            wVar.f1095k = null;
            this.f1106e0 = wVar;
        }
        return this.f1106e0;
    }

    public final h.j h() {
        c0 c0Var = this.O;
        if (c0Var == null) {
            return null;
        }
        return c0Var.f951w;
    }

    public final r0 i() {
        if (this.O != null) {
            return this.P;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final Context j() {
        c0 c0Var = this.O;
        if (c0Var == null) {
            return null;
        }
        return c0Var.f952x;
    }

    public final int k() {
        androidx.lifecycle.n nVar = this.f1110i0;
        return (nVar == androidx.lifecycle.n.f1180w || this.Q == null) ? nVar.ordinal() : Math.min(nVar.ordinal(), this.Q.k());
    }

    public final r0 l() {
        r0 r0Var = this.N;
        if (r0Var != null) {
            return r0Var;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Resources m() {
        return K().getResources();
    }

    public final void n() {
        this.f1111j0 = new androidx.lifecycle.u(this);
        this.f1115n0 = new com.bumptech.glide.manager.u(this);
        this.f1114m0 = null;
        ArrayList arrayList = this.f1116p0;
        s sVar = this.f1117q0;
        if (arrayList.contains(sVar)) {
            return;
        }
        if (this.f1118v >= 0) {
            sVar.a();
        } else {
            arrayList.add(sVar);
        }
    }

    public final void o() {
        n();
        this.f1109h0 = this.A;
        this.A = UUID.randomUUID().toString();
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.M = 0;
        this.N = null;
        this.P = new r0();
        this.O = null;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = false;
        this.V = false;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.Z = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        J().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.Z = true;
    }

    public final boolean p() {
        return this.O != null && this.G;
    }

    public final boolean q() {
        if (this.U) {
            return true;
        }
        r0 r0Var = this.N;
        if (r0Var != null) {
            y yVar = this.Q;
            r0Var.getClass();
            if (yVar == null ? false : yVar.q()) {
                return true;
            }
        }
        return false;
    }

    public final boolean r() {
        return this.M > 0;
    }

    public void s() {
        this.Z = true;
    }

    public void t(int i, int i10, Intent intent) {
        if (r0.J(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i10 + " data: " + intent);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.A);
        if (this.R != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.R));
        }
        if (this.T != null) {
            sb.append(" tag=");
            sb.append(this.T);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u(Context context) {
        this.Z = true;
        c0 c0Var = this.O;
        if ((c0Var == null ? null : c0Var.f951w) != null) {
            this.Z = true;
        }
    }

    public void w(Bundle bundle) {
        Bundle bundle2;
        this.Z = true;
        Bundle bundle3 = this.f1119w;
        if (bundle3 != null && (bundle2 = bundle3.getBundle("childFragmentManager")) != null) {
            this.P.W(bundle2);
            this.P.j();
        }
        r0 r0Var = this.P;
        if (r0Var.f1061t >= 1) {
            return;
        }
        r0Var.j();
    }

    public View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void y() {
        this.Z = true;
    }

    public void z() {
        this.Z = true;
    }

    public void C(boolean z10) {
    }

    public void D(Bundle bundle) {
    }

    public void G(View view) {
    }

    public void v(y yVar) {
    }
}
