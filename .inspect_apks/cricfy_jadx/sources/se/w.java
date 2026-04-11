package se;

import pe.v0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends xd.c {
    public z A;
    public v0 B;
    public Object C;
    public /* synthetic */ Object D;
    public final /* synthetic */ x E;
    public int F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public x f11716y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f11717z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar, xd.c cVar) {
        super(cVar);
        this.E = xVar;
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        this.D = obj;
        this.F |= Integer.MIN_VALUE;
        this.E.z(null, this);
        return wd.a.f14143v;
    }
}
