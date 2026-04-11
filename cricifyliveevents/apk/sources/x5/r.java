package x5;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.m0;
import androidx.fragment.app.v;
import androidx.fragment.app.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.cricfy.tv.app.ProApplication;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class r extends y {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public dd.c f14375s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public s5.p f14376t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ArrayList f14377u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public i f14378v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ProApplication f14379w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final androidx.fragment.app.r f14380x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final androidx.fragment.app.u f14381y0;

    public r() {
        m0 m0Var = new m0(3);
        q qVar = new q(this);
        androidx.fragment.app.u uVar = new androidx.fragment.app.u(this);
        if (this.f1118v > 1) {
            throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        }
        AtomicReference atomicReference = new AtomicReference();
        v vVar = new v(this, uVar, atomicReference, m0Var, qVar);
        if (this.f1118v >= 0) {
            vVar.a();
        } else {
            this.f1116p0.add(vVar);
        }
        this.f14380x0 = new androidx.fragment.app.r(atomicReference);
        this.f14381y0 = new androidx.fragment.app.u(this);
    }

    @Override // androidx.fragment.app.y
    public final void G(View view) {
        ((SwipeRefreshLayout) this.f14375s0.f3675z).setRefreshing(true);
        this.f14379w0 = (ProApplication) h().getApplication();
        U();
        ((CoordinatorLayout) this.f14375s0.f3672w).setOnClickListener(new o());
        ((FloatingActionButton) this.f14375s0.f3673x).setOnClickListener(new com.google.android.material.datepicker.n(17, this));
        ((SwipeRefreshLayout) this.f14375s0.f3675z).setOnRefreshListener(new q(this));
    }

    public final boolean R() {
        if (((FragmentContainerView) this.f14375s0.f3674y).getVisibility() != 0) {
            return false;
        }
        this.f14379w0.f1571y.a("Playlists/IPTV");
        ((FloatingActionButton) this.f14375s0.f3673x).setVisibility(0);
        ((SwipeRefreshLayout) this.f14375s0.f3675z).setVisibility(0);
        ((FragmentContainerView) this.f14375s0.f3674y).setVisibility(8);
        return true;
    }

    public final void S(String str, String str2) throws IOException {
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
        com.bumptech.glide.d.b(j(), str, absolutePath, "", "");
        this.f14381y0.a(str, absolutePath, "", "");
    }

    public final void T(String str) {
        if (str == null) {
            return;
        }
        if (((FragmentContainerView) this.f14375s0.f3674y).getVisibility() == 0) {
            this.f14378v0.U(str);
            return;
        }
        if (this.f14377u0 != null) {
            if (TextUtils.isEmpty(str)) {
                s5.p pVar = this.f14376t0;
                ArrayList arrayList = this.f14377u0;
                pVar.getClass();
                pVar.f11522g = new ArrayList(arrayList);
                pVar.d();
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = this.f14377u0;
            int size = arrayList3.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList3.get(i);
                i++;
                y5.i iVar = (y5.i) obj;
                String str2 = iVar.f14951a;
                if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                    arrayList2.add(iVar);
                }
            }
            s5.p pVar2 = this.f14376t0;
            pVar2.getClass();
            pVar2.f11522g = new ArrayList(arrayList2);
            pVar2.d();
        }
    }

    public final void U() {
        boolean z10;
        String str;
        String str2;
        Context contextJ = j();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = com.bumptech.glide.d.t(contextJ).getStringSet("list", new HashSet()).iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split("\\*");
            if (strArrSplit.length > 2) {
                z10 = true;
                str = strArrSplit[2];
                str2 = strArrSplit[3];
            } else {
                z10 = false;
                str = "";
                str2 = str;
            }
            arrayList.add(new y5.i(strArrSplit[0], strArrSplit[1], str, str2, z10));
        }
        this.f14377u0 = arrayList;
        s5.p pVar = this.f14376t0;
        if (pVar == null) {
            s5.p pVar2 = new s5.p(j(), this.f14377u0, new kf.i(27, this));
            this.f14376t0 = pVar2;
            ((RecyclerView) this.f14375s0.A).setAdapter(pVar2);
            ((RecyclerView) this.f14375s0.A).setLayoutManager(new LinearLayoutManager(1));
        } else {
            pVar.f11522g = new ArrayList(arrayList);
            pVar.d();
            ((RecyclerView) this.f14375s0.A).j0(0);
        }
        ((SwipeRefreshLayout) this.f14375s0.f3675z).setRefreshing(false);
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.fragment_playlist, (ViewGroup) null, false);
        int i = q5.k.add_playlist;
        FloatingActionButton floatingActionButton = (FloatingActionButton) android.support.v4.media.session.b.l(viewInflate, i);
        if (floatingActionButton != null) {
            i = q5.k.fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) android.support.v4.media.session.b.l(viewInflate, i);
            if (fragmentContainerView != null) {
                i = q5.k.playlist_refresh_layout;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) android.support.v4.media.session.b.l(viewInflate, i);
                if (swipeRefreshLayout != null) {
                    i = q5.k.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) android.support.v4.media.session.b.l(viewInflate, i);
                    if (recyclerView != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                        this.f14375s0 = new dd.c(coordinatorLayout, floatingActionButton, fragmentContainerView, swipeRefreshLayout, recyclerView, 14);
                        return coordinatorLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
