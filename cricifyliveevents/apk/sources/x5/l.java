package x5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import app.cricfy.tv.CustomLayoutManager;
import app.cricfy.tv.app.ProApplication;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class l extends c {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public w f14362u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public s5.e f14363v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ArrayList f14364w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ProApplication f14365x0;

    @Override // x5.c, androidx.fragment.app.y
    public final void G(View view) {
        ((TextView) this.f14362u0.f9016w).setText("No Favourites Found");
        this.f14336s0 = true;
        this.f14365x0 = ProApplication.K;
        Executors.newSingleThreadExecutor().execute(new pa.c(12, this));
    }

    @Override // x5.c
    public final void S(int i) {
        RecyclerView recyclerView = (RecyclerView) this.f14362u0.f9017x;
        K();
        recyclerView.setLayoutManager(new CustomLayoutManager(i));
        this.f14365x0.a((RecyclerView) this.f14362u0.f9017x);
    }

    @Override // x5.c
    public final void U(String str) {
        if (this.f14364w0 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f14364w0;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            y5.c cVar = (y5.c) obj;
            String str2 = cVar.f14913a;
            if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) this.f14362u0.f9017x).setVisibility(8);
            ((TextView) this.f14362u0.f9016w).setVisibility(0);
        } else {
            ((RecyclerView) this.f14362u0.f9017x).setVisibility(0);
            ((TextView) this.f14362u0.f9016w).setVisibility(8);
            this.f14363v0.h(arrayList);
        }
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.fragment_favourites, (ViewGroup) null, false);
        int i = q5.k.not_available;
        TextView textView = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
        if (textView != null) {
            i = q5.k.recycler_view;
            RecyclerView recyclerView = (RecyclerView) android.support.v4.media.session.b.l(viewInflate, i);
            if (recyclerView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                this.f14362u0 = new w(relativeLayout, textView, recyclerView);
                return relativeLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
