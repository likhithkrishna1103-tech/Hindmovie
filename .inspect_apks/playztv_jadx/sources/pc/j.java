package pc;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import e6.x;
import o2.i0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements t6.f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ k f10332u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Activity f10333v;

    public j(k kVar, Activity activity) {
        this.f10332u = kVar;
        this.f10333v = activity;
    }

    @Override // t6.f
    /* JADX INFO: renamed from: a */
    public final boolean mo3a(Object obj) {
        k kVar = this.f10332u;
        this.f10333v.runOnUiThread(new i0(kVar, 4, (Drawable) obj));
        return true;
    }

    @Override // t6.f
    public final void i(x xVar) {
        this.f10332u.d(null, false);
    }
}
