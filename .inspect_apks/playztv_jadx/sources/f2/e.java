package f2;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements m {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f4723u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h f4724v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4725w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ f f4726x;

    public e(f fVar, k kVar) {
        this.f4726x = fVar;
        this.f4723u = kVar;
    }

    @Override // f2.m
    public final void release() {
        Handler handler = this.f4726x.N;
        handler.getClass();
        s1.b0.S(handler, new a2.a(13, this));
    }
}
