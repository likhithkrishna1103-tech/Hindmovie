package n9;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends h0.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ android.support.v4.media.session.b f8856h;
    public final /* synthetic */ d i;

    public b(d dVar, android.support.v4.media.session.b bVar) {
        this.i = dVar;
        this.f8856h = bVar;
    }

    @Override // h0.b
    public final void h(int i) {
        this.i.f8871m = true;
        this.f8856h.I(i);
    }

    @Override // h0.b
    public final void i(Typeface typeface) {
        d dVar = this.i;
        dVar.f8872n = Typeface.create(typeface, dVar.f8863c);
        dVar.f8871m = true;
        this.f8856h.J(dVar.f8872n, false);
    }
}
