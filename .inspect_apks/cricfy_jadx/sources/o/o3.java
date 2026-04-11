package o;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o3 implements View.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final n.a f9298v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ p3 f9299w;

    public o3(p3 p3Var) {
        this.f9299w = p3Var;
        Context context = p3Var.f9308a.getContext();
        CharSequence charSequence = p3Var.f9314h;
        n.a aVar = new n.a();
        aVar.f8484e = 4096;
        aVar.f8485g = 4096;
        aVar.f8489l = null;
        aVar.f8490m = null;
        aVar.f8491n = false;
        aVar.f8492o = false;
        aVar.f8493p = 16;
        aVar.i = context;
        aVar.f8480a = charSequence;
        this.f9298v = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p3 p3Var = this.f9299w;
        Window.Callback callback = p3Var.f9316k;
        if (callback == null || !p3Var.f9317l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f9298v);
    }
}
