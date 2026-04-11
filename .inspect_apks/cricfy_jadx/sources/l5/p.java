package l5;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v.e f7819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f7820b;

    public p(q qVar, v.e eVar) {
        this.f7820b = qVar;
        this.f7819a = eVar;
    }

    @Override // l5.l
    public final void b(n nVar) {
        ((ArrayList) this.f7819a.get(this.f7820b.f7822w)).remove(nVar);
        nVar.x(this);
    }
}
