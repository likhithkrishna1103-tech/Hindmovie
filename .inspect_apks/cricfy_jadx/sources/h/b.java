package h;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f f5287v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ c f5288w;

    public b(c cVar, f fVar) {
        this.f5288w = cVar;
        this.f5287v = fVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j4) {
        c cVar = this.f5288w;
        DialogInterface.OnClickListener onClickListener = cVar.f5304q;
        f fVar = this.f5287v;
        onClickListener.onClick(fVar.f5323b, i);
        if (cVar.f5306s) {
            return;
        }
        fVar.f5323b.dismiss();
    }
}
