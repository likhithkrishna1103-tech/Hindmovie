package s7;

import com.google.android.gms.internal.measurement.r0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f11889a;

    public i(d dVar) {
        this.f11889a = dVar;
    }

    @Override // s7.b
    public final void a(boolean z2) {
        r0 r0Var = this.f11889a.G;
        r0Var.sendMessage(r0Var.obtainMessage(1, Boolean.valueOf(z2)));
    }
}
