package o5;

import l5.h0;
import q9.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends p2.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ p2.c f9382x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(p2.c cVar) {
        super(24);
        this.f9382x = cVar;
    }

    @Override // p2.c
    public final Object m(t tVar) {
        Float f = (Float) ((h0) this.f9382x.f10131w);
        if (f == null) {
            return null;
        }
        return Float.valueOf(f.floatValue() * 2.55f);
    }
}
