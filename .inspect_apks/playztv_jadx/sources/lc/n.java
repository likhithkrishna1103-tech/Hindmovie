package lc;

import a2.f0;
import a2.o0;
import aa.c1;
import aa.h0;
import aa.j0;
import aa.m0;
import aa.q;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.v;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.TrackSelectionView;
import com.google.android.material.tabs.TabLayout;
import gc.o;
import gc.p;
import h.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p1.h1;
import p1.k1;
import p1.l1;
import p1.m1;
import p1.n1;
import p1.w0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends androidx.fragment.app.n {
    public static final c1 M0;
    public final SparseArray H0 = new SparseArray();
    public final ArrayList I0 = new ArrayList();
    public int J0;
    public l K0;
    public DialogInterface.OnDismissListener L0;

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static final class a extends v {

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public ArrayList f8113r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public boolean f8114s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public boolean f8115t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public boolean f8116u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public Map f8117v0;

        public a() {
            M();
        }

        @Override // androidx.fragment.app.v
        public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            View viewInflate = layoutInflater.inflate(gc.k.exo_track_selection_dialog, viewGroup, false);
            TrackSelectionView trackSelectionView = (TrackSelectionView) viewInflate.findViewById(gc.j.exo_track_selection_view);
            trackSelectionView.setShowDisableOption(true);
            trackSelectionView.setAllowMultipleOverrides(this.f8115t0);
            trackSelectionView.setAllowAdaptiveSelections(this.f8114s0);
            ArrayList arrayList = this.f8113r0;
            boolean z2 = this.f8116u0;
            Map map = this.f8117v0;
            HashMap map2 = trackSelectionView.A;
            ArrayList arrayList2 = trackSelectionView.f1628z;
            trackSelectionView.F = z2;
            trackSelectionView.G = this;
            arrayList2.clear();
            arrayList2.addAll(arrayList);
            map2.clear();
            map2.putAll(TrackSelectionView.a(map, arrayList, trackSelectionView.C));
            trackSelectionView.c();
            return viewInflate;
        }
    }

    static {
        h0 h0Var = j0.f690v;
        Object[] objArr = {2, 1, 3};
        q.b(3, objArr);
        M0 = j0.l(3, objArr);
    }

    public n() {
        M();
    }

    public static void S(l1 l1Var, n nVar, f0 f0Var) {
        SparseArray sparseArray = nVar.H0;
        k1 k1VarA = l1Var.a();
        int i = 0;
        while (true) {
            c1 c1Var = M0;
            if (i >= c1Var.f652x) {
                ((w0) f0Var.f220v).b0(k1VarA.b());
                return;
            }
            int iIntValue = ((Integer) c1Var.get(i)).intValue();
            a aVar = (a) sparseArray.get(iIntValue);
            k1VarA.i(iIntValue, aVar != null && aVar.f8116u0);
            k1VarA.d(iIntValue);
            a aVar2 = (a) sparseArray.get(iIntValue);
            Iterator it = (aVar2 == null ? Collections.EMPTY_MAP : aVar2.f8117v0).values().iterator();
            while (it.hasNext()) {
                k1VarA.a((h1) it.next());
            }
            i++;
        }
    }

    public static n T(o0 o0Var, DialogInterface.OnDismissListener onDismissListener) {
        int i = o.track_selection_title;
        n1 n1VarL = o0Var.L();
        l1 l1VarE0 = o0Var.E0();
        f0 f0Var = new f0(29, o0Var);
        n nVar = new n();
        l lVar = new l(l1VarE0, nVar, f0Var);
        nVar.J0 = i;
        nVar.K0 = lVar;
        nVar.L0 = onDismissListener;
        int i10 = 0;
        while (true) {
            c1 c1Var = M0;
            if (i10 >= c1Var.f652x) {
                return nVar;
            }
            Integer num = (Integer) c1Var.get(i10);
            int iIntValue = num.intValue();
            ArrayList arrayList = new ArrayList();
            h0 h0VarListIterator = n1VarL.f9952a.listIterator(0);
            while (h0VarListIterator.hasNext()) {
                m1 m1Var = (m1) h0VarListIterator.next();
                if (m1Var.f9944b.f9764c == iIntValue) {
                    arrayList.add(m1Var);
                }
            }
            if (!arrayList.isEmpty()) {
                a aVar = new a();
                boolean zContains = l1VarE0.E.contains(num);
                m0 m0Var = l1VarE0.D;
                aVar.f8113r0 = arrayList;
                aVar.f8116u0 = zContains;
                aVar.f8114s0 = true;
                aVar.f8115t0 = true;
                aVar.f8117v0 = new HashMap(TrackSelectionView.a(m0Var, arrayList, true));
                nVar.H0.put(iIntValue, aVar);
                nVar.I0.add(num);
            }
            i10++;
        }
    }

    @Override // androidx.fragment.app.n
    public final Dialog Q(Bundle bundle) {
        d0 d0Var = new d0(h(), p.TrackSelectionDialogThemeOverlay);
        d0Var.setTitle(this.J0);
        return d0Var;
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.L0;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.track_selection_dialog, viewGroup, false);
        TabLayout tabLayout = (TabLayout) viewInflate.findViewById(gc.j.track_selection_dialog_tab_layout);
        k5.i iVar = (k5.i) viewInflate.findViewById(gc.j.track_selection_dialog_view_pager);
        Button button = (Button) viewInflate.findViewById(gc.j.track_selection_dialog_cancel_button);
        Button button2 = (Button) viewInflate.findViewById(gc.j.track_selection_dialog_ok_button);
        iVar.setAdapter(new m(this, i()));
        tabLayout.setupWithViewPager(iVar);
        tabLayout.setVisibility(this.H0.size() <= 1 ? 8 : 0);
        final int i = 0;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: lc.k

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ n f8104v;

            {
                this.f8104v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i10 = i;
                n nVar = this.f8104v;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        c1 c1Var = n.M0;
                        nVar.P(false, false);
                        break;
                    default:
                        nVar.K0.onClick(nVar.C0, -1);
                        nVar.P(false, false);
                        break;
                }
            }
        });
        final int i10 = 1;
        button2.setOnClickListener(new View.OnClickListener(this) { // from class: lc.k

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ n f8104v;

            {
                this.f8104v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i10;
                n nVar = this.f8104v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        c1 c1Var = n.M0;
                        nVar.P(false, false);
                        break;
                    default:
                        nVar.K0.onClick(nVar.C0, -1);
                        nVar.P(false, false);
                        break;
                }
            }
        });
        return viewInflate;
    }
}
