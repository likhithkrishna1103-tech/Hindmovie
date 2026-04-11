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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l4.c0 f1127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nc.p f1128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f1129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1130d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1131e = -1;

    public z0(l4.c0 c0Var, nc.p pVar, y yVar) {
        this.f1127a = c0Var;
        this.f1128b = pVar;
        this.f1129c = yVar;
    }

    public final void a() {
        boolean zJ = r0.J(3);
        y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + yVar);
        }
        Bundle bundle = yVar.f1119w;
        if (bundle != null) {
            bundle.getBundle("savedInstanceState");
        }
        yVar.P.Q();
        yVar.f1118v = 3;
        yVar.Z = false;
        yVar.s();
        if (!yVar.Z) {
            throw new h1("Fragment " + yVar + " did not call through to super.onActivityCreated()");
        }
        if (r0.J(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + yVar);
        }
        if (yVar.f1103b0 != null) {
            Bundle bundle2 = yVar.f1119w;
            Bundle bundle3 = bundle2 != null ? bundle2.getBundle("savedInstanceState") : null;
            SparseArray<Parcelable> sparseArray = yVar.f1120x;
            if (sparseArray != null) {
                yVar.f1103b0.restoreHierarchyState(sparseArray);
                yVar.f1120x = null;
            }
            yVar.Z = false;
            yVar.H(bundle3);
            if (!yVar.Z) {
                throw new h1("Fragment " + yVar + " did not call through to super.onViewStateRestored()");
            }
            if (yVar.f1103b0 != null) {
                yVar.f1112k0.b(androidx.lifecycle.m.ON_CREATE);
            }
        }
        yVar.f1119w = null;
        r0 r0Var = yVar.P;
        r0Var.F = false;
        r0Var.G = false;
        r0Var.M.i = false;
        r0Var.u(4);
        this.f1127a.u(false);
    }

    public final void b() {
        y yVar;
        View view;
        View view2;
        y yVar2 = this.f1129c;
        View view3 = yVar2.f1102a0;
        while (true) {
            yVar = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(o1.b.fragment_container_view_tag);
            y yVar3 = tag instanceof y ? (y) tag : null;
            if (yVar3 != null) {
                yVar = yVar3;
                break;
            } else {
                Object parent = view3.getParent();
                view3 = parent instanceof View ? (View) parent : null;
            }
        }
        y yVar4 = yVar2.Q;
        if (yVar != null && !yVar.equals(yVar4)) {
            int i = yVar2.S;
            p1.b bVar = p1.c.f9883a;
            StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
            sb.append(yVar2);
            sb.append(" within the view of parent fragment ");
            sb.append(yVar);
            sb.append(" via container with ID ");
            p1.c.b(new p1.a(yVar2, q4.a.o(sb, i, " without using parent's childFragmentManager")));
            p1.c.a(yVar2).getClass();
        }
        ArrayList arrayList = (ArrayList) this.f1128b.f9069a;
        ViewGroup viewGroup = yVar2.f1102a0;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(yVar2);
            int i10 = iIndexOf - 1;
            while (true) {
                if (i10 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        y yVar5 = (y) arrayList.get(iIndexOf);
                        if (yVar5.f1102a0 == viewGroup && (view = yVar5.f1103b0) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    y yVar6 = (y) arrayList.get(i10);
                    if (yVar6.f1102a0 == viewGroup && (view2 = yVar6.f1103b0) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i10--;
                }
            }
        }
        yVar2.f1102a0.addView(yVar2.f1103b0, iIndexOfChild);
    }

    public final void c() {
        boolean zJ = r0.J(3);
        y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "moveto ATTACHED: " + yVar);
        }
        y yVar2 = yVar.C;
        z0 z0Var = null;
        nc.p pVar = this.f1128b;
        if (yVar2 != null) {
            z0 z0Var2 = (z0) ((HashMap) pVar.f9070b).get(yVar2.A);
            if (z0Var2 == null) {
                throw new IllegalStateException("Fragment " + yVar + " declared target fragment " + yVar.C + " that does not belong to this FragmentManager!");
            }
            yVar.D = yVar.C.A;
            yVar.C = null;
            z0Var = z0Var2;
        } else {
            String str = yVar.D;
            if (str != null && (z0Var = (z0) ((HashMap) pVar.f9070b).get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(yVar);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(q4.a.q(sb, yVar.D, " that does not belong to this FragmentManager!"));
            }
        }
        if (z0Var != null) {
            z0Var.k();
        }
        r0 r0Var = yVar.N;
        yVar.O = r0Var.f1062u;
        yVar.Q = r0Var.f1064w;
        l4.c0 c0Var = this.f1127a;
        c0Var.A(false);
        ArrayList arrayList = yVar.f1116p0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((x) obj).a();
        }
        arrayList.clear();
        yVar.P.b(yVar.O, yVar.b(), yVar);
        yVar.f1118v = 0;
        yVar.Z = false;
        yVar.u(yVar.O.f952x);
        if (!yVar.Z) {
            throw new h1("Fragment " + yVar + " did not call through to super.onAttach()");
        }
        Iterator it = yVar.N.f1055n.iterator();
        while (it.hasNext()) {
            ((v0) it.next()).b(yVar);
        }
        r0 r0Var2 = yVar.P;
        r0Var2.F = false;
        r0Var2.G = false;
        r0Var2.M.i = false;
        r0Var2.u(0);
        c0Var.v(false);
    }

    public final int d() {
        int i;
        Object obj;
        y yVar = this.f1129c;
        if (yVar.N == null) {
            return yVar.f1118v;
        }
        int iMin = this.f1131e;
        int iOrdinal = yVar.f1110i0.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (yVar.I) {
            if (yVar.J) {
                iMin = Math.max(this.f1131e, 2);
                View view = yVar.f1103b0;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f1131e < 4 ? Math.min(iMin, yVar.f1118v) : Math.min(iMin, 1);
            }
        }
        if (!yVar.G) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = yVar.f1102a0;
        if (viewGroup != null) {
            l lVarF = l.f(viewGroup, yVar.l());
            e1 e1VarD = lVarF.d(yVar);
            int i10 = e1VarD != null ? e1VarD.f974b : 0;
            ArrayList arrayList = lVarF.f1016c;
            int size = arrayList.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i11);
                i11++;
                e1 e1Var = (e1) obj;
                if (ge.i.a(e1Var.f975c, yVar) && !e1Var.f) {
                    break;
                }
            }
            e1 e1Var2 = (e1) obj;
            i = e1Var2 != null ? e1Var2.f974b : 0;
            int i12 = i10 == 0 ? -1 : g1.f992a[y.e.c(i10)];
            if (i12 != -1 && i12 != 1) {
                i = i10;
            }
        } else {
            i = 0;
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (yVar.H) {
            iMin = yVar.r() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (yVar.f1104c0 && yVar.f1118v < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (r0.J(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + yVar);
        }
        return iMin;
    }

    public final void e() {
        Bundle bundle;
        boolean zJ = r0.J(3);
        final y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "moveto CREATED: " + yVar);
        }
        Bundle bundle2 = yVar.f1119w;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle("savedInstanceState") : null;
        if (yVar.f1108g0) {
            yVar.f1118v = 1;
            Bundle bundle4 = yVar.f1119w;
            if (bundle4 == null || (bundle = bundle4.getBundle("childFragmentManager")) == null) {
                return;
            }
            yVar.P.W(bundle);
            yVar.P.j();
            return;
        }
        l4.c0 c0Var = this.f1127a;
        c0Var.B(false);
        yVar.P.Q();
        yVar.f1118v = 1;
        yVar.Z = false;
        yVar.f1111j0.a(new androidx.lifecycle.q() { // from class: androidx.fragment.app.Fragment$6
            @Override // androidx.lifecycle.q
            public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.m mVar) {
                View view;
                if (mVar != androidx.lifecycle.m.ON_STOP || (view = yVar.f1103b0) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        yVar.w(bundle3);
        yVar.f1108g0 = true;
        if (yVar.Z) {
            yVar.f1111j0.d(androidx.lifecycle.m.ON_CREATE);
            c0Var.w(false);
        } else {
            throw new h1("Fragment " + yVar + " did not call through to super.onCreate()");
        }
    }

    public final void f() {
        String resourceName;
        y yVar = this.f1129c;
        if (yVar.I) {
            return;
        }
        if (r0.J(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + yVar);
        }
        Bundle bundle = yVar.f1119w;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterA = yVar.A(bundle2);
        ViewGroup viewGroup2 = yVar.f1102a0;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = yVar.S;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + yVar + " for a container view with no id");
                }
                viewGroup = (ViewGroup) yVar.N.f1063v.p(i);
                if (viewGroup == null) {
                    if (!yVar.K) {
                        try {
                            resourceName = yVar.m().getResourceName(yVar.S);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(yVar.S) + " (" + resourceName + ") for fragment " + yVar);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    p1.b bVar = p1.c.f9883a;
                    p1.c.b(new p1.a(yVar, "Attempting to add fragment " + yVar + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    p1.c.a(yVar).getClass();
                }
            }
        }
        yVar.f1102a0 = viewGroup;
        yVar.I(layoutInflaterA, viewGroup, bundle2);
        if (yVar.f1103b0 != null) {
            if (r0.J(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + yVar);
            }
            int i10 = 0;
            yVar.f1103b0.setSaveFromParentEnabled(false);
            yVar.f1103b0.setTag(o1.b.fragment_container_view_tag, yVar);
            if (viewGroup != null) {
                b();
            }
            if (yVar.U) {
                yVar.f1103b0.setVisibility(8);
            }
            View view = yVar.f1103b0;
            WeakHashMap weakHashMap = t0.m0.f11777a;
            if (view.isAttachedToWindow()) {
                t0.b0.c(yVar.f1103b0);
            } else {
                View view2 = yVar.f1103b0;
                view2.addOnAttachStateChangeListener(new y0(i10, view2));
            }
            Bundle bundle3 = yVar.f1119w;
            if (bundle3 != null) {
                bundle3.getBundle("savedInstanceState");
            }
            yVar.G(yVar.f1103b0);
            yVar.P.u(2);
            this.f1127a.I(false);
            int visibility = yVar.f1103b0.getVisibility();
            yVar.g().f1094j = yVar.f1103b0.getAlpha();
            if (yVar.f1102a0 != null && visibility == 0) {
                View viewFindFocus = yVar.f1103b0.findFocus();
                if (viewFindFocus != null) {
                    yVar.g().f1095k = viewFindFocus;
                    if (r0.J(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + yVar);
                    }
                }
                yVar.f1103b0.setAlpha(0.0f);
            }
        }
        yVar.f1118v = 2;
    }

    public final void g() {
        y yVarI;
        boolean zJ = r0.J(3);
        y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "movefrom CREATED: " + yVar);
        }
        boolean zIsChangingConfigurations = true;
        int i = 0;
        boolean z10 = yVar.H && !yVar.r();
        nc.p pVar = this.f1128b;
        if (z10) {
            pVar.B(yVar.A, null);
        }
        if (!z10) {
            u0 u0Var = (u0) pVar.f9072d;
            if (!((u0Var.f1078d.containsKey(yVar.A) && u0Var.f1080g) ? u0Var.f1081h : true)) {
                String str = yVar.D;
                if (str != null && (yVarI = pVar.i(str)) != null && yVarI.W) {
                    yVar.C = yVarI;
                }
                yVar.f1118v = 0;
                return;
            }
        }
        c0 c0Var = yVar.O;
        if (c0Var != null) {
            zIsChangingConfigurations = ((u0) pVar.f9072d).f1081h;
        } else {
            h.j jVar = c0Var.f952x;
            if (q4.a.v(jVar)) {
                zIsChangingConfigurations = true ^ jVar.isChangingConfigurations();
            }
        }
        if (z10 || zIsChangingConfigurations) {
            ((u0) pVar.f9072d).d(yVar);
        }
        yVar.P.l();
        yVar.f1111j0.d(androidx.lifecycle.m.ON_DESTROY);
        yVar.f1118v = 0;
        yVar.Z = false;
        yVar.f1108g0 = false;
        yVar.Z = true;
        if (!yVar.Z) {
            throw new h1("Fragment " + yVar + " did not call through to super.onDestroy()");
        }
        this.f1127a.x(false);
        ArrayList arrayListM = pVar.m();
        int size = arrayListM.size();
        while (i < size) {
            Object obj = arrayListM.get(i);
            i++;
            z0 z0Var = (z0) obj;
            if (z0Var != null) {
                y yVar2 = z0Var.f1129c;
                if (yVar.A.equals(yVar2.D)) {
                    yVar2.C = yVar;
                    yVar2.D = null;
                }
            }
        }
        String str2 = yVar.D;
        if (str2 != null) {
            yVar.C = pVar.i(str2);
        }
        pVar.u(this);
    }

    public final void h() {
        View view;
        boolean zJ = r0.J(3);
        y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + yVar);
        }
        ViewGroup viewGroup = yVar.f1102a0;
        if (viewGroup != null && (view = yVar.f1103b0) != null) {
            viewGroup.removeView(view);
        }
        yVar.P.u(1);
        if (yVar.f1103b0 != null) {
            b1 b1Var = yVar.f1112k0;
            b1Var.g();
            if (b1Var.f948z.f1200c.compareTo(androidx.lifecycle.n.f1181x) >= 0) {
                yVar.f1112k0.b(androidx.lifecycle.m.ON_DESTROY);
            }
        }
        yVar.f1118v = 1;
        yVar.Z = false;
        yVar.y();
        if (!yVar.Z) {
            throw new h1("Fragment " + yVar + " did not call through to super.onDestroyView()");
        }
        v.l lVar = ((u1.a) new androidx.emoji2.text.v(yVar.e(), u1.a.f12065e).r(u1.a.class)).f12066d;
        if (lVar.e() > 0) {
            lVar.f(0).getClass();
            throw new ClassCastException();
        }
        yVar.L = false;
        this.f1127a.J(false);
        yVar.f1102a0 = null;
        yVar.f1103b0 = null;
        yVar.f1112k0 = null;
        yVar.f1113l0.e(null);
        yVar.J = false;
    }

    public final void i() {
        boolean zJ = r0.J(3);
        y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + yVar);
        }
        yVar.f1118v = -1;
        yVar.Z = false;
        yVar.z();
        if (!yVar.Z) {
            throw new h1("Fragment " + yVar + " did not call through to super.onDetach()");
        }
        r0 r0Var = yVar.P;
        if (!r0Var.H) {
            r0Var.l();
            yVar.P = new r0();
        }
        this.f1127a.y(false);
        yVar.f1118v = -1;
        yVar.O = null;
        yVar.Q = null;
        yVar.N = null;
        if (!yVar.H || yVar.r()) {
            u0 u0Var = (u0) this.f1128b.f9072d;
            if (!((u0Var.f1078d.containsKey(yVar.A) && u0Var.f1080g) ? u0Var.f1081h : true)) {
                return;
            }
        }
        if (r0.J(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + yVar);
        }
        yVar.o();
    }

    public final void j() {
        y yVar = this.f1129c;
        if (yVar.I && yVar.J && !yVar.L) {
            if (r0.J(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + yVar);
            }
            Bundle bundle = yVar.f1119w;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            yVar.I(yVar.A(bundle2), null, bundle2);
            View view = yVar.f1103b0;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                yVar.f1103b0.setTag(o1.b.fragment_container_view_tag, yVar);
                if (yVar.U) {
                    yVar.f1103b0.setVisibility(8);
                }
                Bundle bundle3 = yVar.f1119w;
                if (bundle3 != null) {
                    bundle3.getBundle("savedInstanceState");
                }
                yVar.G(yVar.f1103b0);
                yVar.P.u(2);
                this.f1127a.I(false);
                yVar.f1118v = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        nc.p pVar = this.f1128b;
        boolean z10 = this.f1130d;
        y yVar = this.f1129c;
        if (z10) {
            if (r0.J(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + yVar);
                return;
            }
            return;
        }
        try {
            this.f1130d = true;
            boolean z11 = false;
            while (true) {
                int iD = d();
                int i = yVar.f1118v;
                int i10 = 3;
                if (iD == i) {
                    if (!z11 && i == -1 && yVar.H && !yVar.r()) {
                        if (r0.J(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + yVar);
                        }
                        ((u0) pVar.f9072d).d(yVar);
                        pVar.u(this);
                        if (r0.J(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + yVar);
                        }
                        yVar.o();
                    }
                    if (yVar.f1107f0) {
                        if (yVar.f1103b0 != null && (viewGroup = yVar.f1102a0) != null) {
                            l lVarF = l.f(viewGroup, yVar.l());
                            if (yVar.U) {
                                if (r0.J(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + yVar);
                                }
                                lVarF.a(3, 1, this);
                            } else {
                                if (r0.J(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + yVar);
                                }
                                lVarF.a(2, 1, this);
                            }
                        }
                        r0 r0Var = yVar.N;
                        if (r0Var != null && yVar.G && r0.K(yVar)) {
                            r0Var.E = true;
                        }
                        yVar.f1107f0 = false;
                        yVar.P.o();
                    }
                    this.f1130d = false;
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
                            yVar.f1118v = 1;
                            break;
                        case 2:
                            yVar.J = false;
                            yVar.f1118v = 2;
                            break;
                        case 3:
                            if (r0.J(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + yVar);
                            }
                            if (yVar.f1103b0 != null && yVar.f1120x == null) {
                                o();
                            }
                            if (yVar.f1103b0 != null && (viewGroup2 = yVar.f1102a0) != null) {
                                l lVarF2 = l.f(viewGroup2, yVar.l());
                                if (r0.J(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + yVar);
                                }
                                lVarF2.a(1, 3, this);
                            }
                            yVar.f1118v = 3;
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            q();
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            yVar.f1118v = 5;
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
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
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            if (yVar.f1103b0 != null && (viewGroup3 = yVar.f1102a0) != null) {
                                l lVarF3 = l.f(viewGroup3, yVar.l());
                                int visibility = yVar.f1103b0.getVisibility();
                                if (visibility == 0) {
                                    i10 = 2;
                                } else if (visibility == 4) {
                                    i10 = 4;
                                } else if (visibility != 8) {
                                    throw new IllegalArgumentException("Unknown visibility " + visibility);
                                }
                                q4.a.s(i10, "finalState");
                                if (r0.J(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + yVar);
                                }
                                lVarF3.a(i10, 2, this);
                            }
                            yVar.f1118v = 4;
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            p();
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            yVar.f1118v = 6;
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            n();
                            break;
                    }
                }
                z11 = true;
            }
        } catch (Throwable th) {
            this.f1130d = false;
            throw th;
        }
    }

    public final void l() {
        boolean zJ = r0.J(3);
        y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "movefrom RESUMED: " + yVar);
        }
        yVar.P.u(5);
        if (yVar.f1103b0 != null) {
            yVar.f1112k0.b(androidx.lifecycle.m.ON_PAUSE);
        }
        yVar.f1111j0.d(androidx.lifecycle.m.ON_PAUSE);
        yVar.f1118v = 6;
        yVar.Z = true;
        this.f1127a.z(false);
    }

    public final void m(ClassLoader classLoader) {
        y yVar = this.f1129c;
        Bundle bundle = yVar.f1119w;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (yVar.f1119w.getBundle("savedInstanceState") == null) {
            yVar.f1119w.putBundle("savedInstanceState", new Bundle());
        }
        yVar.f1120x = yVar.f1119w.getSparseParcelableArray("viewState");
        yVar.f1121y = yVar.f1119w.getBundle("viewRegistryState");
        x0 x0Var = (x0) yVar.f1119w.getParcelable("state");
        if (x0Var != null) {
            yVar.D = x0Var.G;
            yVar.E = x0Var.H;
            Boolean bool = yVar.f1122z;
            if (bool != null) {
                yVar.f1105d0 = bool.booleanValue();
                yVar.f1122z = null;
            } else {
                yVar.f1105d0 = x0Var.I;
            }
        }
        if (yVar.f1105d0) {
            return;
        }
        yVar.f1104c0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.z0.n():void");
    }

    public final void o() {
        y yVar = this.f1129c;
        if (yVar.f1103b0 == null) {
            return;
        }
        if (r0.J(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + yVar + " with view " + yVar.f1103b0);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        yVar.f1103b0.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            yVar.f1120x = sparseArray;
        }
        Bundle bundle = new Bundle();
        yVar.f1112k0.A.f(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        yVar.f1121y = bundle;
    }

    public final void p() {
        boolean zJ = r0.J(3);
        y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "moveto STARTED: " + yVar);
        }
        yVar.P.Q();
        yVar.P.A(true);
        yVar.f1118v = 5;
        yVar.Z = false;
        yVar.E();
        if (!yVar.Z) {
            throw new h1("Fragment " + yVar + " did not call through to super.onStart()");
        }
        androidx.lifecycle.u uVar = yVar.f1111j0;
        androidx.lifecycle.m mVar = androidx.lifecycle.m.ON_START;
        uVar.d(mVar);
        if (yVar.f1103b0 != null) {
            yVar.f1112k0.f948z.d(mVar);
        }
        r0 r0Var = yVar.P;
        r0Var.F = false;
        r0Var.G = false;
        r0Var.M.i = false;
        r0Var.u(5);
        this.f1127a.G(false);
    }

    public final void q() {
        boolean zJ = r0.J(3);
        y yVar = this.f1129c;
        if (zJ) {
            Log.d("FragmentManager", "movefrom STARTED: " + yVar);
        }
        r0 r0Var = yVar.P;
        r0Var.G = true;
        r0Var.M.i = true;
        r0Var.u(4);
        if (yVar.f1103b0 != null) {
            yVar.f1112k0.b(androidx.lifecycle.m.ON_STOP);
        }
        yVar.f1111j0.d(androidx.lifecycle.m.ON_STOP);
        yVar.f1118v = 4;
        yVar.Z = false;
        yVar.F();
        if (yVar.Z) {
            this.f1127a.H(false);
            return;
        }
        throw new h1("Fragment " + yVar + " did not call through to super.onStop()");
    }

    public z0(l4.c0 c0Var, nc.p pVar, ClassLoader classLoader, k0 k0Var, Bundle bundle) {
        this.f1127a = c0Var;
        this.f1128b = pVar;
        x0 x0Var = (x0) bundle.getParcelable("state");
        y yVarA = k0Var.a(x0Var.f1096v);
        yVarA.A = x0Var.f1097w;
        yVarA.I = x0Var.f1098x;
        yVarA.K = true;
        yVarA.R = x0Var.f1099y;
        yVarA.S = x0Var.f1100z;
        yVarA.T = x0Var.A;
        yVarA.W = x0Var.B;
        yVarA.H = x0Var.C;
        yVarA.V = x0Var.D;
        yVarA.U = x0Var.E;
        yVarA.f1110i0 = androidx.lifecycle.n.values()[x0Var.F];
        yVarA.D = x0Var.G;
        yVarA.E = x0Var.H;
        yVarA.f1105d0 = x0Var.I;
        this.f1129c = yVarA;
        yVarA.f1119w = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        yVarA.N(bundle2);
        if (r0.J(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + yVarA);
        }
    }

    public z0(l4.c0 c0Var, nc.p pVar, y yVar, Bundle bundle) {
        this.f1127a = c0Var;
        this.f1128b = pVar;
        this.f1129c = yVar;
        yVar.f1120x = null;
        yVar.f1121y = null;
        yVar.M = 0;
        yVar.J = false;
        yVar.G = false;
        y yVar2 = yVar.C;
        yVar.D = yVar2 != null ? yVar2.A : null;
        yVar.C = null;
        yVar.f1119w = bundle;
        yVar.B = bundle.getBundle("arguments");
    }
}
