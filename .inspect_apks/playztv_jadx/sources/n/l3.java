package n;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l3 implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final m.a f8433u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ m3 f8434v;

    public l3(m3 m3Var) {
        this.f8434v = m3Var;
        Context context = m3Var.f8443a.getContext();
        CharSequence charSequence = m3Var.f8449h;
        m.a aVar = new m.a();
        aVar.f8166e = 4096;
        aVar.f8167g = 4096;
        aVar.f8171l = null;
        aVar.f8172m = null;
        aVar.f8173n = false;
        aVar.f8174o = false;
        aVar.f8175p = 16;
        aVar.i = context;
        aVar.f8162a = charSequence;
        this.f8433u = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m3 m3Var = this.f8434v;
        Window.Callback callback = m3Var.f8451k;
        if (callback == null || !m3Var.f8452l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f8433u);
    }
}
