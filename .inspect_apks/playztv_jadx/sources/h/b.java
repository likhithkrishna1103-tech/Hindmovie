package h;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ e f5413u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c f5414v;

    public b(c cVar, e eVar) {
        this.f5414v = cVar;
        this.f5413u = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        c cVar = this.f5414v;
        DialogInterface.OnClickListener onClickListener = cVar.f5454q;
        e eVar = this.f5413u;
        onClickListener.onClick(eVar.f5462b, i);
        if (cVar.f5456s) {
            return;
        }
        eVar.f5462b.dismiss();
    }
}
