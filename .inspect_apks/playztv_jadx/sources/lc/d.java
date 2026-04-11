package lc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends ArrayAdapter {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ e f8087u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, Context context, int i, int i10, List list) {
        super(context, i, i10, list);
        this.f8087u = eVar;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        TextView textView = (TextView) view2.findViewById(gc.j.choose_txt);
        e eVar = this.f8087u;
        if (i == eVar.K0) {
            textView.setTextColor(eVar.M0);
            return view2;
        }
        textView.setTextColor(eVar.L0);
        return view2;
    }
}
