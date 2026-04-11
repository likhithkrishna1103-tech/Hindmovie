package nc;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.playz.tv.app.ProApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class u extends androidx.fragment.app.v {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public zc.c f8971r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public ic.u f8972s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ArrayList f8973t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public m f8974u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ProApplication f8975v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final androidx.fragment.app.o f8976w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final a1 f8977x0;

    public u() {
        j0 j0Var = new j0(3);
        t tVar = new t(this);
        androidx.fragment.app.r rVar = new androidx.fragment.app.r(this);
        if (this.f1393u > 1) {
            throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        }
        AtomicReference atomicReference = new AtomicReference();
        androidx.fragment.app.s sVar = new androidx.fragment.app.s(this, rVar, atomicReference, j0Var, tVar);
        if (this.f1393u >= 0) {
            sVar.a();
        } else {
            this.f1391o0.add(sVar);
        }
        this.f8976w0 = new androidx.fragment.app.o(atomicReference);
        this.f8977x0 = new a1(this);
    }

    @Override // androidx.fragment.app.v
    public final void D() {
        ((SwipeRefreshLayout) this.f8971r0.f14948x).setRefreshing(true);
        this.f8975v0 = (ProApplication) h().getApplication();
        S();
        ((CoordinatorLayout) this.f8971r0.f14945u).setOnClickListener(new hc.b(2));
        ((FloatingActionButton) this.f8971r0.f14946v).setOnClickListener(new com.google.android.material.datepicker.n(11, this));
        ((SwipeRefreshLayout) this.f8971r0.f14948x).setOnRefreshListener(new t(this));
    }

    public final boolean P() {
        if (((FragmentContainerView) this.f8971r0.f14947w).getVisibility() != 0) {
            return false;
        }
        this.f8975v0.f3680x.a("Playlists/IPTV");
        ((FloatingActionButton) this.f8971r0.f14946v).setVisibility(0);
        ((SwipeRefreshLayout) this.f8971r0.f14948x).setVisibility(0);
        ((FragmentContainerView) this.f8971r0.f14947w).setVisibility(8);
        return true;
    }

    public final void Q(String str, String str2) throws IOException {
        File file = new File(h().getExternalFilesDir(null), str);
        int i = 1;
        while (file.exists()) {
            file = new File(h().getExternalFilesDir(null), i + "_" + str);
            i++;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(str2.getBytes());
        fileOutputStream.close();
        String absolutePath = file.getAbsolutePath();
        uc.b.a(j(), str, absolutePath, "", "");
        this.f8977x0.l(str, absolutePath, "", "");
    }

    public final void R(String str) {
        if (str == null) {
            return;
        }
        if (((FragmentContainerView) this.f8971r0.f14947w).getVisibility() == 0) {
            this.f8974u0.S(str);
            return;
        }
        if (this.f8973t0 != null) {
            if (TextUtils.isEmpty(str)) {
                ic.u uVar = this.f8972s0;
                ArrayList arrayList = this.f8973t0;
                uVar.getClass();
                uVar.f = new ArrayList(arrayList);
                uVar.f10982a.b();
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = this.f8973t0;
            int size = arrayList3.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList3.get(i);
                i++;
                oc.h hVar = (oc.h) obj;
                String str2 = hVar.f9554a;
                if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                    arrayList2.add(hVar);
                }
            }
            ic.u uVar2 = this.f8972s0;
            uVar2.getClass();
            uVar2.f = new ArrayList(arrayList2);
            uVar2.f10982a.b();
        }
    }

    public final void S() {
        boolean z2;
        String str;
        String str2;
        Context contextJ = j();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = uc.b.f(contextJ).getStringSet("list", new HashSet()).iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split("\\*");
            if (strArrSplit.length > 2) {
                z2 = true;
                str = strArrSplit[2];
                str2 = strArrSplit[3];
            } else {
                z2 = false;
                str = "";
                str2 = str;
            }
            arrayList.add(new oc.h(strArrSplit[0], strArrSplit[1], str, str2, z2));
        }
        this.f8973t0 = arrayList;
        ic.u uVar = this.f8972s0;
        if (uVar == null) {
            ic.u uVar2 = new ic.u(j(), this.f8973t0, new androidx.fragment.app.r(this));
            this.f8972s0 = uVar2;
            ((RecyclerView) this.f8971r0.f14949y).setAdapter(uVar2);
            ((RecyclerView) this.f8971r0.f14949y).setLayoutManager(new LinearLayoutManager(1));
        } else {
            uVar.f = new ArrayList(arrayList);
            uVar.f10982a.b();
            ((RecyclerView) this.f8971r0.f14949y).j0(0);
        }
        ((SwipeRefreshLayout) this.f8971r0.f14948x).setRefreshing(false);
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.fragment_playlist, (ViewGroup) null, false);
        int i = gc.j.add_playlist;
        FloatingActionButton floatingActionButton = (FloatingActionButton) z7.a.k(viewInflate, i);
        if (floatingActionButton != null) {
            i = gc.j.fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) z7.a.k(viewInflate, i);
            if (fragmentContainerView != null) {
                i = gc.j.playlist_refresh_layout;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) z7.a.k(viewInflate, i);
                if (swipeRefreshLayout != null) {
                    i = gc.j.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) z7.a.k(viewInflate, i);
                    if (recyclerView != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                        this.f8971r0 = new zc.c(coordinatorLayout, floatingActionButton, fragmentContainerView, swipeRefreshLayout, recyclerView);
                        return coordinatorLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
