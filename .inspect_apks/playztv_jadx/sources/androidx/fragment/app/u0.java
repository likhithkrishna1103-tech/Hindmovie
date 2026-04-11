package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h4.z f1372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ub.o f1373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f1374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1375d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1376e = -1;

    public u0(h4.z zVar, ub.o oVar, v vVar) {
        this.f1372a = zVar;
        this.f1373b = oVar;
        this.f1374c = vVar;
    }

    public final void a() {
        boolean zG = n0.G(3);
        v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + vVar);
        }
        Bundle bundle = vVar.f1394v;
        vVar.O.N();
        vVar.f1393u = 3;
        vVar.Y = false;
        vVar.s();
        if (!vVar.Y) {
            throw new a1("Fragment " + vVar + " did not call through to super.onActivityCreated()");
        }
        if (n0.G(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + vVar);
        }
        View view = vVar.f1378a0;
        if (view != null) {
            Bundle bundle2 = vVar.f1394v;
            SparseArray<Parcelable> sparseArray = vVar.f1395w;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                vVar.f1395w = null;
            }
            if (vVar.f1378a0 != null) {
                vVar.f1387j0.f1412y.g(vVar.f1396x);
                vVar.f1396x = null;
            }
            vVar.Y = false;
            vVar.E(bundle2);
            if (!vVar.Y) {
                throw new a1("Fragment " + vVar + " did not call through to super.onViewStateRestored()");
            }
            if (vVar.f1378a0 != null) {
                vVar.f1387j0.b(androidx.lifecycle.m.ON_CREATE);
            }
        }
        vVar.f1394v = null;
        n0 n0Var = vVar.O;
        n0Var.E = false;
        n0Var.F = false;
        n0Var.L.i = false;
        n0Var.t(4);
        this.f1372a.L(false);
    }

    public final void b() {
        View view;
        View view2;
        ArrayList arrayList = (ArrayList) this.f1373b.f12868v;
        v vVar = this.f1374c;
        ViewGroup viewGroup = vVar.Z;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(vVar);
            int i = iIndexOf - 1;
            while (true) {
                if (i < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        v vVar2 = (v) arrayList.get(iIndexOf);
                        if (vVar2.Z == viewGroup && (view = vVar2.f1378a0) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    v vVar3 = (v) arrayList.get(i);
                    if (vVar3.Z == viewGroup && (view2 = vVar3.f1378a0) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i--;
                }
            }
        }
        vVar.Z.addView(vVar.f1378a0, iIndexOfChild);
    }

    public final void c() {
        boolean zG = n0.G(3);
        v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "moveto ATTACHED: " + vVar);
        }
        v vVar2 = vVar.B;
        u0 u0Var = null;
        ub.o oVar = this.f1373b;
        if (vVar2 != null) {
            u0 u0Var2 = (u0) ((HashMap) oVar.f12869w).get(vVar2.f1398z);
            if (u0Var2 == null) {
                throw new IllegalStateException("Fragment " + vVar + " declared target fragment " + vVar.B + " that does not belong to this FragmentManager!");
            }
            vVar.C = vVar.B.f1398z;
            vVar.B = null;
            u0Var = u0Var2;
        } else {
            String str = vVar.C;
            if (str != null && (u0Var = (u0) ((HashMap) oVar.f12869w).get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(vVar);
                sb2.append(" declared target fragment ");
                throw new IllegalStateException(l4.a.o(sb2, vVar.C, " that does not belong to this FragmentManager!"));
            }
        }
        if (u0Var != null) {
            u0Var.k();
        }
        n0 n0Var = vVar.M;
        vVar.N = n0Var.f1327t;
        vVar.P = n0Var.f1329v;
        h4.z zVar = this.f1372a;
        zVar.R(false);
        ArrayList arrayList = vVar.f1391o0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((u) obj).a();
        }
        arrayList.clear();
        vVar.O.b(vVar.N, vVar.b(), vVar);
        vVar.f1393u = 0;
        vVar.Y = false;
        vVar.u(vVar.N.f1423v);
        if (!vVar.Y) {
            throw new a1("Fragment " + vVar + " did not call through to super.onAttach()");
        }
        Iterator it = vVar.M.f1320m.iterator();
        while (it.hasNext()) {
            ((r0) it.next()).b();
        }
        n0 n0Var2 = vVar.O;
        n0Var2.E = false;
        n0Var2.F = false;
        n0Var2.L.i = false;
        n0Var2.t(0);
        zVar.M(false);
    }

    public final int d() {
        z0 z0Var;
        v vVar = this.f1374c;
        if (vVar.M == null) {
            return vVar.f1393u;
        }
        int iMin = this.f1376e;
        int iOrdinal = vVar.f1385h0.ordinal();
        int i = 0;
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (vVar.H) {
            if (vVar.I) {
                iMin = Math.max(this.f1376e, 2);
                View view = vVar.f1378a0;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f1376e < 4 ? Math.min(iMin, vVar.f1393u) : Math.min(iMin, 1);
            }
        }
        if (!vVar.F) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = vVar.Z;
        if (viewGroup != null) {
            j jVarF = j.f(viewGroup, vVar.l().E());
            z0 z0VarD = jVarF.d(vVar);
            int i10 = z0VarD != null ? z0VarD.f1428b : 0;
            ArrayList arrayList = jVarF.f1289c;
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    z0Var = null;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                z0Var = (z0) obj;
                if (z0Var.f1429c.equals(vVar) && !z0Var.f) {
                    break;
                }
            }
            i = (z0Var == null || !(i10 == 0 || i10 == 1)) ? i10 : z0Var.f1428b;
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (vVar.G) {
            iMin = vVar.r() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (vVar.f1379b0 && vVar.f1393u < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (n0.G(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + vVar);
        }
        return iMin;
    }

    public final void e() {
        boolean zG = n0.G(3);
        final v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "moveto CREATED: " + vVar);
        }
        if (vVar.f1383f0) {
            vVar.J(vVar.f1394v);
            vVar.f1393u = 1;
            return;
        }
        h4.z zVar = this.f1372a;
        zVar.S(false);
        Bundle bundle = vVar.f1394v;
        vVar.O.N();
        vVar.f1393u = 1;
        vVar.Y = false;
        vVar.f1386i0.a(new androidx.lifecycle.q() { // from class: androidx.fragment.app.Fragment$6
            @Override // androidx.lifecycle.q
            public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.m mVar) {
                View view;
                if (mVar != androidx.lifecycle.m.ON_STOP || (view = vVar.f1378a0) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        vVar.f1389m0.g(bundle);
        vVar.v(bundle);
        vVar.f1383f0 = true;
        if (vVar.Y) {
            vVar.f1386i0.d(androidx.lifecycle.m.ON_CREATE);
            zVar.N(false);
        } else {
            throw new a1("Fragment " + vVar + " did not call through to super.onCreate()");
        }
    }

    public final void f() {
        String resourceName;
        v vVar = this.f1374c;
        if (vVar.H) {
            return;
        }
        if (n0.G(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + vVar);
        }
        LayoutInflater layoutInflaterZ = vVar.z(vVar.f1394v);
        ViewGroup viewGroup = vVar.Z;
        if (viewGroup == null) {
            int i = vVar.R;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + vVar + " for a container view with no id");
                }
                viewGroup = (ViewGroup) vVar.M.f1328u.v(i);
                if (viewGroup == null) {
                    if (!vVar.J) {
                        try {
                            resourceName = vVar.m().getResourceName(vVar.R);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(vVar.R) + " (" + resourceName + ") for fragment " + vVar);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    j1.b bVar = j1.c.f6667a;
                    j1.c.b(new j1.a(vVar, "Attempting to add fragment " + vVar + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    j1.c.a(vVar).getClass();
                }
            }
        }
        vVar.Z = viewGroup;
        vVar.F(layoutInflaterZ, viewGroup, vVar.f1394v);
        View view = vVar.f1378a0;
        if (view != null) {
            int i10 = 0;
            view.setSaveFromParentEnabled(false);
            vVar.f1378a0.setTag(i1.b.fragment_container_view_tag, vVar);
            if (viewGroup != null) {
                b();
            }
            if (vVar.T) {
                vVar.f1378a0.setVisibility(8);
            }
            View view2 = vVar.f1378a0;
            WeakHashMap weakHashMap = q0.o0.f10475a;
            if (view2.isAttachedToWindow()) {
                q0.d0.c(vVar.f1378a0);
            } else {
                View view3 = vVar.f1378a0;
                view3.addOnAttachStateChangeListener(new t0(i10, view3));
            }
            vVar.D();
            vVar.O.t(2);
            this.f1372a.X(false);
            int visibility = vVar.f1378a0.getVisibility();
            vVar.g().f1368j = vVar.f1378a0.getAlpha();
            if (vVar.Z != null && visibility == 0) {
                View viewFindFocus = vVar.f1378a0.findFocus();
                if (viewFindFocus != null) {
                    vVar.g().f1369k = viewFindFocus;
                    if (n0.G(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + vVar);
                    }
                }
                vVar.f1378a0.setAlpha(0.0f);
            }
        }
        vVar.f1393u = 2;
    }

    public final void g() {
        v vVarL;
        boolean zG = n0.G(3);
        v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "movefrom CREATED: " + vVar);
        }
        boolean zIsChangingConfigurations = true;
        int i = 0;
        boolean z2 = vVar.G && !vVar.r();
        ub.o oVar = this.f1373b;
        if (z2) {
        }
        if (!z2) {
            q0 q0Var = (q0) oVar.f12871y;
            if (!((q0Var.f1345d.containsKey(vVar.f1398z) && q0Var.f1347g) ? q0Var.f1348h : true)) {
                String str = vVar.C;
                if (str != null && (vVarL = oVar.l(str)) != null && vVarL.V) {
                    vVar.B = vVarL;
                }
                vVar.f1393u = 0;
                return;
            }
        }
        z zVar = vVar.N;
        if (zVar != null) {
            zIsChangingConfigurations = ((q0) oVar.f12871y).f1348h;
        } else {
            h.j jVar = zVar.f1423v;
            if (l4.a.v(jVar)) {
                zIsChangingConfigurations = true ^ jVar.isChangingConfigurations();
            }
        }
        if (z2 || zIsChangingConfigurations) {
            ((q0) oVar.f12871y).d(vVar);
        }
        vVar.O.k();
        vVar.f1386i0.d(androidx.lifecycle.m.ON_DESTROY);
        vVar.f1393u = 0;
        vVar.Y = false;
        vVar.f1383f0 = false;
        vVar.Y = true;
        if (!vVar.Y) {
            throw new a1("Fragment " + vVar + " did not call through to super.onDestroy()");
        }
        this.f1372a.O(false);
        ArrayList arrayListT = oVar.t();
        int size = arrayListT.size();
        while (i < size) {
            Object obj = arrayListT.get(i);
            i++;
            u0 u0Var = (u0) obj;
            if (u0Var != null) {
                v vVar2 = u0Var.f1374c;
                if (vVar.f1398z.equals(vVar2.C)) {
                    vVar2.B = vVar;
                    vVar2.C = null;
                }
            }
        }
        String str2 = vVar.C;
        if (str2 != null) {
            vVar.B = oVar.l(str2);
        }
        oVar.K(this);
    }

    public final void h() {
        View view;
        boolean zG = n0.G(3);
        v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + vVar);
        }
        ViewGroup viewGroup = vVar.Z;
        if (viewGroup != null && (view = vVar.f1378a0) != null) {
            viewGroup.removeView(view);
        }
        vVar.O.t(1);
        if (vVar.f1378a0 != null) {
            w0 w0Var = vVar.f1387j0;
            w0Var.g();
            if (w0Var.f1411x.f1504c.compareTo(androidx.lifecycle.n.f1484w) >= 0) {
                vVar.f1387j0.b(androidx.lifecycle.m.ON_DESTROY);
            }
        }
        vVar.f1393u = 1;
        vVar.Y = false;
        vVar.x();
        if (!vVar.Y) {
            throw new a1("Fragment " + vVar + " did not call through to super.onDestroyView()");
        }
        s.j jVar = ((o1.a) new a7.b(vVar.e(), o1.a.f9049e).s(o1.a.class)).f9050d;
        if (jVar.f11638w > 0) {
            jVar.f11637v[0].getClass();
            throw new ClassCastException();
        }
        vVar.K = false;
        this.f1372a.Y(false);
        vVar.Z = null;
        vVar.f1378a0 = null;
        vVar.f1387j0 = null;
        vVar.f1388k0.e(null);
        vVar.I = false;
    }

    public final void i() {
        boolean zG = n0.G(3);
        v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + vVar);
        }
        vVar.f1393u = -1;
        vVar.Y = false;
        vVar.y();
        if (!vVar.Y) {
            throw new a1("Fragment " + vVar + " did not call through to super.onDetach()");
        }
        n0 n0Var = vVar.O;
        if (!n0Var.G) {
            n0Var.k();
            vVar.O = new n0();
        }
        this.f1372a.P(false);
        vVar.f1393u = -1;
        vVar.N = null;
        vVar.P = null;
        vVar.M = null;
        if (!vVar.G || vVar.r()) {
            q0 q0Var = (q0) this.f1373b.f12871y;
            if (!((q0Var.f1345d.containsKey(vVar.f1398z) && q0Var.f1347g) ? q0Var.f1348h : true)) {
                return;
            }
        }
        if (n0.G(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + vVar);
        }
        vVar.o();
    }

    public final void j() {
        v vVar = this.f1374c;
        if (vVar.H && vVar.I && !vVar.K) {
            if (n0.G(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + vVar);
            }
            vVar.F(vVar.z(vVar.f1394v), null, vVar.f1394v);
            View view = vVar.f1378a0;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                vVar.f1378a0.setTag(i1.b.fragment_container_view_tag, vVar);
                if (vVar.T) {
                    vVar.f1378a0.setVisibility(8);
                }
                vVar.D();
                vVar.O.t(2);
                this.f1372a.X(false);
                vVar.f1393u = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        ub.o oVar = this.f1373b;
        boolean z2 = this.f1375d;
        v vVar = this.f1374c;
        if (z2) {
            if (n0.G(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + vVar);
                return;
            }
            return;
        }
        try {
            this.f1375d = true;
            boolean z10 = false;
            while (true) {
                int iD = d();
                int i = vVar.f1393u;
                if (iD == i) {
                    if (!z10 && i == -1 && vVar.G && !vVar.r()) {
                        if (n0.G(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + vVar);
                        }
                        ((q0) oVar.f12871y).d(vVar);
                        oVar.K(this);
                        if (n0.G(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + vVar);
                        }
                        vVar.o();
                    }
                    if (vVar.f1382e0) {
                        if (vVar.f1378a0 != null && (viewGroup = vVar.Z) != null) {
                            j jVarF = j.f(viewGroup, vVar.l().E());
                            if (vVar.T) {
                                if (n0.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + vVar);
                                }
                                jVarF.a(3, 1, this);
                            } else {
                                if (n0.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + vVar);
                                }
                                jVarF.a(2, 1, this);
                            }
                        }
                        n0 n0Var = vVar.M;
                        if (n0Var != null && vVar.F && n0.H(vVar)) {
                            n0Var.D = true;
                        }
                        vVar.f1382e0 = false;
                        vVar.O.n();
                    }
                    this.f1375d = false;
                    return;
                }
                if (iD <= i) {
                    switch (i - 1) {
                        case -1:
                            i();
                            break;
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            g();
                            break;
                        case 1:
                            h();
                            vVar.f1393u = 1;
                            break;
                        case 2:
                            vVar.I = false;
                            vVar.f1393u = 2;
                            break;
                        case 3:
                            if (n0.G(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + vVar);
                            }
                            if (vVar.f1378a0 != null && vVar.f1395w == null) {
                                o();
                            }
                            if (vVar.f1378a0 != null && (viewGroup2 = vVar.Z) != null) {
                                j jVarF2 = j.f(viewGroup2, vVar.l().E());
                                if (n0.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + vVar);
                                }
                                jVarF2.a(1, 3, this);
                            }
                            vVar.f1393u = 3;
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            q();
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            vVar.f1393u = 5;
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            l();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            if (vVar.f1378a0 != null && (viewGroup3 = vVar.Z) != null) {
                                j jVarF3 = j.f(viewGroup3, vVar.l().E());
                                int iB = l4.a.b(vVar.f1378a0.getVisibility());
                                if (n0.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + vVar);
                                }
                                jVarF3.a(iB, 2, this);
                            }
                            vVar.f1393u = 4;
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            p();
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            vVar.f1393u = 6;
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            n();
                            break;
                    }
                }
                z10 = true;
            }
        } catch (Throwable th) {
            this.f1375d = false;
            throw th;
        }
    }

    public final void l() {
        boolean zG = n0.G(3);
        v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "movefrom RESUMED: " + vVar);
        }
        vVar.O.t(5);
        if (vVar.f1378a0 != null) {
            vVar.f1387j0.b(androidx.lifecycle.m.ON_PAUSE);
        }
        vVar.f1386i0.d(androidx.lifecycle.m.ON_PAUSE);
        vVar.f1393u = 6;
        vVar.Y = true;
        this.f1372a.Q(false);
    }

    public final void m(ClassLoader classLoader) {
        v vVar = this.f1374c;
        Bundle bundle = vVar.f1394v;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        vVar.f1395w = vVar.f1394v.getSparseParcelableArray("android:view_state");
        vVar.f1396x = vVar.f1394v.getBundle("android:view_registry_state");
        vVar.C = vVar.f1394v.getString("android:target_state");
        if (vVar.C != null) {
            vVar.D = vVar.f1394v.getInt("android:target_req_state", 0);
        }
        Boolean bool = vVar.f1397y;
        if (bool != null) {
            vVar.f1380c0 = bool.booleanValue();
            vVar.f1397y = null;
        } else {
            vVar.f1380c0 = vVar.f1394v.getBoolean("android:user_visible_hint", true);
        }
        if (vVar.f1380c0) {
            return;
        }
        vVar.f1379b0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.u0.n():void");
    }

    public final void o() {
        v vVar = this.f1374c;
        if (vVar.f1378a0 == null) {
            return;
        }
        if (n0.G(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + vVar + " with view " + vVar.f1378a0);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        vVar.f1378a0.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            vVar.f1395w = sparseArray;
        }
        Bundle bundle = new Bundle();
        vVar.f1387j0.f1412y.h(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        vVar.f1396x = bundle;
    }

    public final void p() {
        boolean zG = n0.G(3);
        v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "moveto STARTED: " + vVar);
        }
        vVar.O.N();
        vVar.O.x(true);
        vVar.f1393u = 5;
        vVar.Y = false;
        vVar.B();
        if (!vVar.Y) {
            throw new a1("Fragment " + vVar + " did not call through to super.onStart()");
        }
        androidx.lifecycle.u uVar = vVar.f1386i0;
        androidx.lifecycle.m mVar = androidx.lifecycle.m.ON_START;
        uVar.d(mVar);
        if (vVar.f1378a0 != null) {
            vVar.f1387j0.f1411x.d(mVar);
        }
        n0 n0Var = vVar.O;
        n0Var.E = false;
        n0Var.F = false;
        n0Var.L.i = false;
        n0Var.t(5);
        this.f1372a.V(false);
    }

    public final void q() {
        boolean zG = n0.G(3);
        v vVar = this.f1374c;
        if (zG) {
            Log.d("FragmentManager", "movefrom STARTED: " + vVar);
        }
        n0 n0Var = vVar.O;
        n0Var.F = true;
        n0Var.L.i = true;
        n0Var.t(4);
        if (vVar.f1378a0 != null) {
            vVar.f1387j0.b(androidx.lifecycle.m.ON_STOP);
        }
        vVar.f1386i0.d(androidx.lifecycle.m.ON_STOP);
        vVar.f1393u = 4;
        vVar.Y = false;
        vVar.C();
        if (vVar.Y) {
            this.f1372a.W(false);
            return;
        }
        throw new a1("Fragment " + vVar + " did not call through to super.onStop()");
    }

    public u0(h4.z zVar, ub.o oVar, ClassLoader classLoader, h0 h0Var, s0 s0Var) {
        this.f1372a = zVar;
        this.f1373b = oVar;
        v vVarA = h0Var.a(s0Var.f1355u);
        Bundle bundle = s0Var.D;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        vVarA.L(bundle);
        vVarA.f1398z = s0Var.f1356v;
        vVarA.H = s0Var.f1357w;
        vVarA.J = true;
        vVarA.Q = s0Var.f1358x;
        vVarA.R = s0Var.f1359y;
        vVarA.S = s0Var.f1360z;
        vVarA.V = s0Var.A;
        vVarA.G = s0Var.B;
        vVarA.U = s0Var.C;
        vVarA.T = s0Var.E;
        vVarA.f1385h0 = androidx.lifecycle.n.values()[s0Var.F];
        Bundle bundle2 = s0Var.G;
        if (bundle2 != null) {
            vVarA.f1394v = bundle2;
        } else {
            vVarA.f1394v = new Bundle();
        }
        this.f1374c = vVarA;
        if (n0.G(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + vVarA);
        }
    }

    public u0(h4.z zVar, ub.o oVar, v vVar, s0 s0Var) {
        this.f1372a = zVar;
        this.f1373b = oVar;
        this.f1374c = vVar;
        vVar.f1395w = null;
        vVar.f1396x = null;
        vVar.L = 0;
        vVar.I = false;
        vVar.F = false;
        v vVar2 = vVar.B;
        vVar.C = vVar2 != null ? vVar2.f1398z : null;
        vVar.B = null;
        Bundle bundle = s0Var.G;
        if (bundle != null) {
            vVar.f1394v = bundle;
        } else {
            vVar.f1394v = new Bundle();
        }
    }
}
