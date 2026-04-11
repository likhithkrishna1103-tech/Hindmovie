package n9;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends android.support.v4.media.session.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f8853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u5.d f8854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8855c;

    public a(u5.d dVar, Typeface typeface) {
        this.f8853a = typeface;
        this.f8854b = dVar;
    }

    @Override // android.support.v4.media.session.b
    public final void I(int i) {
        if (this.f8855c) {
            return;
        }
        j9.c cVar = (j9.c) this.f8854b.f12784v;
        if (cVar.j(this.f8853a)) {
            cVar.h(false);
        }
    }

    @Override // android.support.v4.media.session.b
    public final void J(Typeface typeface, boolean z2) {
        if (this.f8855c) {
            return;
        }
        j9.c cVar = (j9.c) this.f8854b.f12784v;
        if (cVar.j(typeface)) {
            cVar.h(false);
        }
    }
}
