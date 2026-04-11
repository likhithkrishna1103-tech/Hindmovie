package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.emoji2.text.v;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.i0;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;
import androidx.lifecycle.r;
import androidx.lifecycle.t0;
import androidx.navigation.a0;
import androidx.navigation.b0;
import androidx.navigation.c0;
import androidx.navigation.d0;
import androidx.navigation.h;
import androidx.navigation.p;
import c.f0;
import com.google.android.gms.internal.measurement.j4;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class e extends y {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public p f1344s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public Boolean f1345t0 = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public View f1346u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f1347v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f1348w0;

    @Override // androidx.fragment.app.y
    public final void B(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.B(context, attributeSet, bundle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d0.NavHost);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(d0.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.f1347v0 = resourceId;
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.NavHostFragment);
        if (typedArrayObtainStyledAttributes2.getBoolean(g.NavHostFragment_defaultNavHost, false)) {
            this.f1348w0 = true;
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.y
    public final void C(boolean z10) {
        p pVar = this.f1344s0;
        if (pVar == null) {
            this.f1345t0 = Boolean.valueOf(z10);
        } else {
            pVar.f1390o = z10;
            pVar.h();
        }
    }

    @Override // androidx.fragment.app.y
    public final void D(Bundle bundle) {
        Bundle bundle2;
        p pVar = this.f1344s0;
        ArrayDeque arrayDeque = pVar.f1384h;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle3 = new Bundle();
        for (Map.Entry entry : pVar.f1386k.f1324a.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleD = ((a0) entry.getValue()).d();
            if (bundleD != null) {
                arrayList.add(str);
                bundle3.putBundle(str, bundleD);
            }
        }
        if (arrayList.isEmpty()) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle();
            bundle3.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle2.putBundle("android-support-nav:controller:navigatorState", bundle3);
        }
        if (!arrayDeque.isEmpty()) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[arrayDeque.size()];
            Iterator it = arrayDeque.iterator();
            int i = 0;
            while (it.hasNext()) {
                parcelableArr[i] = new androidx.navigation.g((androidx.navigation.f) it.next());
                i++;
            }
            bundle2.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (pVar.f1383g) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android-support-nav:controller:deepLinkHandled", pVar.f1383g);
        }
        if (bundle2 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", bundle2);
        }
        if (this.f1348w0) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i10 = this.f1347v0;
        if (i10 != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i10);
        }
    }

    @Override // androidx.fragment.app.y
    public final void G(View view) {
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
        }
        view.setTag(c0.nav_controller_view_tag, this.f1344s0);
        if (view.getParent() != null) {
            View view2 = (View) view.getParent();
            this.f1346u0 = view2;
            if (view2.getId() == this.R) {
                this.f1346u0.setTag(c0.nav_controller_view_tag, this.f1344s0);
            }
        }
    }

    @Override // androidx.fragment.app.y
    public final void u(Context context) {
        super.u(context);
        if (this.f1348w0) {
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(l());
            aVar.j(this);
            aVar.e(false);
        }
    }

    @Override // androidx.fragment.app.y
    public final void v(y yVar) {
        b0 b0Var = this.f1344s0.f1386k;
        b0Var.getClass();
        b bVar = (b) b0Var.c(b0.b(b.class));
        if (bVar.f1338d.remove(yVar.T)) {
            yVar.f1111j0.a(bVar.f1339e);
        }
    }

    @Override // androidx.fragment.app.y
    public final void w(Bundle bundle) throws Exception {
        Bundle bundle2;
        p pVar = new p(K());
        this.f1344s0 = pVar;
        if (this != pVar.i) {
            pVar.i = this;
            this.f1111j0.a(pVar.f1388m);
        }
        p pVar2 = this.f1344s0;
        f0 f0VarJ = J().j();
        r rVar = pVar2.f1388m;
        i0 i0Var = pVar2.f1389n;
        if (pVar2.i == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        i0Var.b();
        f0VarJ.a(i0Var, pVar2.i);
        pVar2.i.f1111j0.f(rVar);
        pVar2.i.f1111j0.a(rVar);
        p pVar3 = this.f1344s0;
        Boolean bool = this.f1345t0;
        pVar3.f1390o = bool != null && bool.booleanValue();
        pVar3.h();
        this.f1345t0 = null;
        p pVar4 = this.f1344s0;
        t0 t0VarE = e();
        h hVar = pVar4.f1385j;
        androidx.fragment.app.t0 t0Var = h.f1353e;
        if (hVar != ((h) new v(t0VarE, t0Var).r(h.class))) {
            if (!pVar4.f1384h.isEmpty()) {
                throw new IllegalStateException("ViewModelStore should be set before setGraph call");
            }
            pVar4.f1385j = (h) new v(t0VarE, t0Var).r(h.class);
        }
        p pVar5 = this.f1344s0;
        pVar5.f1386k.a(new b(K(), i()));
        b0 b0Var = pVar5.f1386k;
        Context contextK = K();
        r0 r0VarI = i();
        int i = this.R;
        if (i == 0 || i == -1) {
            i = f.nav_host_fragment_container;
        }
        b0Var.a(new d(contextK, r0VarI, i));
        if (bundle != null) {
            bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.f1348w0 = true;
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(l());
                aVar.j(this);
                aVar.e(false);
            }
            this.f1347v0 = bundle.getInt("android-support-nav:fragment:graphId");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            p pVar6 = this.f1344s0;
            bundle2.setClassLoader(pVar6.f1378a.getClassLoader());
            pVar6.f1382e = bundle2.getBundle("android-support-nav:controller:navigatorState");
            pVar6.f = bundle2.getParcelableArray("android-support-nav:controller:backStack");
            pVar6.f1383g = bundle2.getBoolean("android-support-nav:controller:deepLinkHandled");
        }
        int i10 = this.f1347v0;
        if (i10 != 0) {
            this.f1344s0.g(i10, null);
        } else {
            Bundle bundle3 = this.B;
            int i11 = bundle3 != null ? bundle3.getInt("android-support-nav:fragment:graphId") : 0;
            Bundle bundle4 = bundle3 != null ? bundle3.getBundle("android-support-nav:fragment:startDestinationArgs") : null;
            if (i11 != 0) {
                this.f1344s0.g(i11, bundle4);
            }
        }
        super.w(bundle);
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        int i = this.R;
        if (i == 0 || i == -1) {
            i = f.nav_host_fragment_container;
        }
        fragmentContainerView.setId(i);
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.y
    public final void y() {
        this.Z = true;
        View view = this.f1346u0;
        if (view != null && j4.g(view) == this.f1344s0) {
            this.f1346u0.setTag(c0.nav_controller_view_tag, null);
        }
        this.f1346u0 = null;
    }
}
