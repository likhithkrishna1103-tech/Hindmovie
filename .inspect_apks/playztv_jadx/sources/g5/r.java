package g5;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s.e f5304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f5305b;

    public r(s sVar, s.e eVar) {
        this.f5305b = sVar;
        this.f5304a = eVar;
    }

    @Override // g5.n
    public final void e(p pVar) {
        ((ArrayList) this.f5304a.get(this.f5305b.f5307v)).remove(pVar);
        pVar.x(this);
    }
}
