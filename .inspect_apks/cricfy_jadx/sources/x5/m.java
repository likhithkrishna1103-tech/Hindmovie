package x5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.y;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.cricfy.tv.app.ProApplication;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class m extends y {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public l7.a f14366s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ProApplication f14367t0;

    public static HashSet R(int i, int i10) {
        Random random = new Random();
        HashSet hashSet = new HashSet();
        while (hashSet.size() < Math.min(i, i10)) {
            hashSet.add(Integer.valueOf(random.nextInt(i)));
        }
        return hashSet;
    }

    @Override // androidx.fragment.app.y
    public final void G(View view) {
        this.f14367t0 = ProApplication.K;
        S();
    }

    public final void S() {
        ((TextView) this.f14366s0.f7866w).setVisibility(8);
        ((RecyclerView) this.f14366s0.f7868y).setVisibility(8);
        ((ProgressBar) this.f14366s0.f7867x).setVisibility(0);
        if (h() == null) {
            return;
        }
        ProApplication proApplication = this.f14367t0;
        if (proApplication.B != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f14367t0.B;
            HashSet hashSetR = R(arrayList2.size(), 20);
            String str = this.f14367t0.D;
            Iterator it = hashSetR.iterator();
            while (it.hasNext()) {
                y5.c cVar = (y5.c) arrayList2.get(((Integer) it.next()).intValue());
                if (!cVar.f14915c.equals(str)) {
                    arrayList.add(cVar);
                }
            }
            if (arrayList.isEmpty()) {
                ((RecyclerView) this.f14366s0.f7868y).setVisibility(8);
                ((TextView) this.f14366s0.f7866w).setVisibility(0);
            } else {
                ((RecyclerView) this.f14366s0.f7868y).setAdapter(new s5.e(J(), arrayList));
                ((RecyclerView) this.f14366s0.f7868y).setLayoutManager(new GridLayoutManager(4));
                ((RecyclerView) this.f14366s0.f7868y).setVisibility(0);
                ((TextView) this.f14366s0.f7866w).setVisibility(8);
            }
            ProApplication proApplication2 = this.f14367t0;
            proApplication2.f1572z = null;
            proApplication2.B = null;
        } else {
            if (proApplication.f1572z == null) {
                ((TextView) this.f14366s0.f7866w).setVisibility(0);
                ((ProgressBar) this.f14366s0.f7867x).setVisibility(8);
                return;
            }
            ArrayList arrayList3 = new ArrayList();
            List list = this.f14367t0.f1572z;
            HashSet hashSetR2 = R(list.size(), 6);
            String str2 = this.f14367t0.D;
            Iterator it2 = hashSetR2.iterator();
            while (it2.hasNext()) {
                y5.e eVar = (y5.e) list.get(((Integer) it2.next()).intValue());
                if (!eVar.f14929h.equals(str2)) {
                    arrayList3.add(eVar);
                }
            }
            if (arrayList3.isEmpty()) {
                ((RecyclerView) this.f14366s0.f7868y).setVisibility(8);
                ((TextView) this.f14366s0.f7866w).setVisibility(0);
            } else {
                ((RecyclerView) this.f14366s0.f7868y).setAdapter(new s5.i(J(), arrayList3, null, null));
                ((RecyclerView) this.f14366s0.f7868y).setLayoutManager(new LinearLayoutManager(1));
                ((RecyclerView) this.f14366s0.f7868y).setVisibility(0);
                ((TextView) this.f14366s0.f7866w).setVisibility(8);
            }
            ProApplication proApplication3 = this.f14367t0;
            proApplication3.f1572z = null;
            proApplication3.B = null;
        }
        ((RecyclerView) this.f14366s0.f7868y).setVisibility(0);
        ((ProgressBar) this.f14366s0.f7867x).setVisibility(8);
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.fragment_more, (ViewGroup) null, false);
        int i = q5.k.not_available;
        TextView textView = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
        if (textView != null) {
            i = q5.k.progress;
            ProgressBar progressBar = (ProgressBar) android.support.v4.media.session.b.l(viewInflate, i);
            if (progressBar != null) {
                i = q5.k.recycler_view;
                RecyclerView recyclerView = (RecyclerView) android.support.v4.media.session.b.l(viewInflate, i);
                if (recyclerView != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    this.f14366s0 = new l7.a(linearLayout, textView, progressBar, recyclerView);
                    return linearLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
