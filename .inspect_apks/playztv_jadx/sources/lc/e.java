package lc;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import hc.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class e extends androidx.fragment.app.n {
    public k4 H0;
    public final List I0;
    public final nc.i J0;
    public final int K0;
    public int L0;
    public int M0;

    public e() {
        this.I0 = null;
        this.J0 = null;
        this.K0 = 0;
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.v
    public final void B() {
        Dialog dialog;
        super.B();
        if (m().getConfiguration().orientation != 1 || (dialog = this.C0) == null || dialog.getWindow() == null) {
            return;
        }
        int i = (int) (m().getDisplayMetrics().density * 32.0f);
        this.C0.getWindow().setLayout(m().getDisplayMetrics().widthPixels - i, m().getDisplayMetrics().heightPixels - ((int) (m().getDisplayMetrics().density * 200.0f)));
    }

    @Override // androidx.fragment.app.v
    public final void D() {
        if (this.I0 == null || this.J0 == null) {
            P(false, false);
            return;
        }
        this.L0 = H().getColor(gc.h.light_white);
        this.M0 = H().getColor(gc.h.app_color);
        d dVar = new d(this, H(), gc.k.item_choose_tab, gc.j.choose_txt, this.I0);
        ((ListView) this.H0.f3070u).setAdapter((ListAdapter) dVar);
        ((ListView) this.H0.f3070u).setOnItemClickListener(new c(this, 0));
        ((TextInputEditText) this.H0.f3071v).addTextChangedListener(new v(1, dVar));
    }

    @Override // androidx.fragment.app.n
    public final Dialog Q(Bundle bundle) {
        Dialog dialogQ = super.Q(bundle);
        Window window = dialogQ.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        dialogQ.setCancelable(true);
        dialogQ.setCanceledOnTouchOutside(true);
        return dialogQ;
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.dialog_choose, (ViewGroup) null, false);
        int i = gc.j.listView;
        ListView listView = (ListView) z7.a.k(viewInflate, i);
        if (listView != null) {
            i = gc.j.searchEditText;
            TextInputEditText textInputEditText = (TextInputEditText) z7.a.k(viewInflate, i);
            if (textInputEditText != null) {
                i = gc.j.search_input_layout;
                if (((TextInputLayout) z7.a.k(viewInflate, i)) != null) {
                    MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                    k4 k4Var = new k4();
                    k4Var.f3070u = listView;
                    k4Var.f3071v = textInputEditText;
                    this.H0 = k4Var;
                    return materialCardView;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public e(ArrayList arrayList, int i, nc.i iVar) {
        this.I0 = arrayList;
        this.K0 = i;
        this.J0 = iVar;
    }
}
