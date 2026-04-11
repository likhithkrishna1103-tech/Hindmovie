package v5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.TrackSelectionView;
import com.google.android.material.tabs.TabLayout;
import g2.g0;
import h.c0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ua.i0;
import ua.k0;
import ua.z0;
import v1.h1;
import v1.k1;
import v1.l1;
import v1.m1;
import v1.n1;
import v1.w0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends androidx.fragment.app.q {
    public static final z0 N0 = i0.p(2, 1);
    public final SparseArray I0 = new SparseArray();
    public final ArrayList J0 = new ArrayList();
    public int K0;
    public q L0;
    public DialogInterface.OnDismissListener M0;

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static final class a extends y {

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public ArrayList f13451s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public boolean f13452t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public boolean f13453u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public boolean f13454v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public Map f13455w0;

        public a() {
            O();
        }

        @Override // androidx.fragment.app.y
        public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            View viewInflate = layoutInflater.inflate(q5.l.exo_track_selection_dialog, viewGroup, false);
            TrackSelectionView trackSelectionView = (TrackSelectionView) viewInflate.findViewById(q5.k.exo_track_selection_view);
            trackSelectionView.setShowDisableOption(true);
            trackSelectionView.setAllowMultipleOverrides(this.f13453u0);
            trackSelectionView.setAllowAdaptiveSelections(this.f13452t0);
            ArrayList arrayList = this.f13451s0;
            boolean z10 = this.f13454v0;
            Map map = this.f13455w0;
            HashMap map2 = trackSelectionView.B;
            ArrayList arrayList2 = trackSelectionView.A;
            trackSelectionView.G = z10;
            trackSelectionView.H = this;
            arrayList2.clear();
            arrayList2.addAll(arrayList);
            map2.clear();
            map2.putAll(TrackSelectionView.a(map, arrayList, trackSelectionView.D));
            trackSelectionView.c();
            return viewInflate;
        }
    }

    public s() {
        O();
    }

    public static void V(l1 l1Var, s sVar, kb.d dVar) {
        SparseArray sparseArray = sVar.I0;
        k1 k1VarA = l1Var.a();
        int i = 0;
        while (true) {
            z0 z0Var = N0;
            if (i >= z0Var.f12415y) {
                ((w0) dVar.f7399w).e0(k1VarA.b());
                return;
            }
            int iIntValue = ((Integer) z0Var.get(i)).intValue();
            a aVar = (a) sparseArray.get(iIntValue);
            k1VarA.i(iIntValue, aVar != null && aVar.f13454v0);
            k1VarA.d(iIntValue);
            a aVar2 = (a) sparseArray.get(iIntValue);
            Iterator it = (aVar2 == null ? Collections.EMPTY_MAP : aVar2.f13455w0).values().iterator();
            while (it.hasNext()) {
                k1VarA.a((h1) it.next());
            }
            i++;
        }
    }

    public static s W(g0 g0Var, DialogInterface.OnDismissListener onDismissListener) {
        int i = q5.o.track_selection_title;
        n1 n1VarG = g0Var.G();
        l1 l1VarE0 = g0Var.E0();
        kb.d dVar = new kb.d(16, g0Var);
        s sVar = new s();
        q qVar = new q(l1VarE0, sVar, dVar);
        sVar.K0 = i;
        sVar.L0 = qVar;
        sVar.M0 = onDismissListener;
        int i10 = 0;
        while (true) {
            z0 z0Var = N0;
            if (i10 >= z0Var.f12415y) {
                return sVar;
            }
            Integer num = (Integer) z0Var.get(i10);
            int iIntValue = num.intValue();
            ArrayList arrayList = new ArrayList();
            ua.g0 g0VarListIterator = n1VarG.f12882a.listIterator(0);
            while (g0VarListIterator.hasNext()) {
                m1 m1Var = (m1) g0VarListIterator.next();
                if (m1Var.f12873b.f12704c == iIntValue) {
                    arrayList.add(m1Var);
                }
            }
            if (!arrayList.isEmpty()) {
                a aVar = new a();
                boolean zContains = l1VarE0.E.contains(num);
                k0 k0Var = l1VarE0.D;
                aVar.f13451s0 = arrayList;
                aVar.f13454v0 = zContains;
                aVar.f13452t0 = true;
                aVar.f13453u0 = true;
                aVar.f13455w0 = new HashMap(TrackSelectionView.a(k0Var, arrayList, true));
                sVar.I0.put(iIntValue, aVar);
                sVar.J0.add(num);
            }
            i10++;
        }
    }

    @Override // androidx.fragment.app.q
    public final Dialog S(Bundle bundle) {
        c0 c0Var = new c0(h(), q5.p.TrackSelectionDialogThemeOverlay);
        c0Var.setTitle(this.K0);
        return c0Var;
    }

    @Override // androidx.fragment.app.q, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.M0;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.track_selection_dialog, viewGroup, false);
        TabLayout tabLayout = (TabLayout) viewInflate.findViewById(q5.k.track_selection_dialog_tab_layout);
        p5.g gVar = (p5.g) viewInflate.findViewById(q5.k.track_selection_dialog_view_pager);
        Button button = (Button) viewInflate.findViewById(q5.k.track_selection_dialog_cancel_button);
        Button button2 = (Button) viewInflate.findViewById(q5.k.track_selection_dialog_ok_button);
        gVar.setAdapter(new r(this, i()));
        tabLayout.setupWithViewPager(gVar);
        tabLayout.setVisibility(this.I0.size() <= 1 ? 8 : 0);
        final int i = 0;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: v5.p

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ s f13442w;

            {
                this.f13442w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i10 = i;
                s sVar = this.f13442w;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        z0 z0Var = s.N0;
                        sVar.R(false, false);
                        break;
                    default:
                        sVar.L0.onClick(sVar.D0, -1);
                        sVar.R(false, false);
                        break;
                }
            }
        });
        final int i10 = 1;
        button2.setOnClickListener(new View.OnClickListener(this) { // from class: v5.p

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ s f13442w;

            {
                this.f13442w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i10;
                s sVar = this.f13442w;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        z0 z0Var = s.N0;
                        sVar.R(false, false);
                        break;
                    default:
                        sVar.L0.onClick(sVar.D0, -1);
                        sVar.R(false, false);
                        break;
                }
            }
        });
        return viewInflate;
    }
}
