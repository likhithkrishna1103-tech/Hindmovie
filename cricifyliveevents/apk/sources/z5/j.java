package z5;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import z6.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements o7.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ kb.d f15220v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Activity f15221w;

    public j(kb.d dVar, Activity activity) {
        this.f15220v = dVar;
        this.f15221w = activity;
    }

    @Override // o7.f
    /* JADX INFO: renamed from: a */
    public final boolean mo0a(Object obj) {
        this.f15221w.runOnUiThread(new nc.i(22, this.f15220v, (Drawable) obj));
        return true;
    }

    @Override // o7.f
    public final void i(x xVar) {
        this.f15220v.i(null, false);
    }
}
