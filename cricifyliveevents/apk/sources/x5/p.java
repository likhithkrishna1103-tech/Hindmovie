package x5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.cricfy.tv.room.db.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class p extends c {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public dd.c f14370u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public AppDatabase f14371v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public s5.p f14372w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public List f14373x0;

    @Override // x5.c, androidx.fragment.app.y
    public final void G(View view) {
        ((SwipeRefreshLayout) this.f14370u0.A).setRefreshing(true);
        ((SwipeRefreshLayout) this.f14370u0.A).setOnRefreshListener(new kb.d(23, this));
        ((CoordinatorLayout) this.f14370u0.f3672w).setOnClickListener(new o());
        this.f14371v0 = AppDatabase.r(j());
        new Thread(new n(this, 0)).start();
        ((FloatingActionButton) this.f14370u0.f3673x).setOnClickListener(new com.google.android.material.datepicker.n(16, this));
    }

    @Override // x5.c
    public final void T() {
        ((SwipeRefreshLayout) this.f14370u0.A).setRefreshing(true);
        new Thread(new n(this, 0)).start();
    }

    @Override // x5.c
    public final void U(String str) {
        List list = this.f14373x0;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (str.isEmpty()) {
            s5.p pVar = this.f14372w0;
            pVar.f11522g = this.f14373x0;
            pVar.d();
            ((RecyclerView) this.f14370u0.f3675z).setVisibility(0);
            ((TextView) this.f14370u0.f3674y).setVisibility(8);
            return;
        }
        String lowerCase = str.toLowerCase();
        ArrayList arrayList = new ArrayList();
        for (b6.h hVar : this.f14373x0) {
            if (hVar.f1810b.toLowerCase().contains(lowerCase) || hVar.f1811c.toLowerCase().contains(lowerCase)) {
                arrayList.add(hVar);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) this.f14370u0.f3675z).setVisibility(8);
            return;
        }
        ((RecyclerView) this.f14370u0.f3675z).setVisibility(0);
        s5.p pVar2 = this.f14372w0;
        pVar2.f11522g = arrayList;
        pVar2.d();
    }

    public final void V() {
        if (this.f14373x0.isEmpty()) {
            ((RecyclerView) this.f14370u0.f3675z).setVisibility(8);
            ((TextView) this.f14370u0.f3674y).setVisibility(0);
            ((SwipeRefreshLayout) this.f14370u0.A).setRefreshing(false);
            return;
        }
        s5.p pVar = this.f14372w0;
        if (pVar == null) {
            s5.p pVar2 = new s5.p(j(), this.f14373x0);
            this.f14372w0 = pVar2;
            ((RecyclerView) this.f14370u0.f3675z).setAdapter(pVar2);
            ((RecyclerView) this.f14370u0.f3675z).setLayoutManager(new LinearLayoutManager(1));
        } else {
            pVar.f11522g = this.f14373x0;
            pVar.d();
        }
        ((FloatingActionButton) this.f14370u0.f3673x).setVisibility(0);
        ((TextView) this.f14370u0.f3674y).setVisibility(8);
        ((RecyclerView) this.f14370u0.f3675z).setVisibility(0);
        ((SwipeRefreshLayout) this.f14370u0.A).setRefreshing(false);
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.fragment_notification, (ViewGroup) null, false);
        int i = q5.k.delete_all_noti;
        FloatingActionButton floatingActionButton = (FloatingActionButton) android.support.v4.media.session.b.l(viewInflate, i);
        if (floatingActionButton != null) {
            i = q5.k.not_available;
            TextView textView = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
            if (textView != null) {
                i = q5.k.recycler_view;
                RecyclerView recyclerView = (RecyclerView) android.support.v4.media.session.b.l(viewInflate, i);
                if (recyclerView != null) {
                    i = q5.k.refresh_layout;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) android.support.v4.media.session.b.l(viewInflate, i);
                    if (swipeRefreshLayout != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                        this.f14370u0 = new dd.c(coordinatorLayout, floatingActionButton, textView, recyclerView, swipeRefreshLayout, 13);
                        return coordinatorLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
