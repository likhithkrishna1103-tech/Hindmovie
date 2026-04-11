package of;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f9851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f9852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f9853c;

    public /* synthetic */ r(s sVar, Throwable th, int i) {
        this(sVar, (d) null, (i & 4) != 0 ? null : th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return ge.i.a(this.f9851a, rVar.f9851a) && ge.i.a(this.f9852b, rVar.f9852b) && ge.i.a(this.f9853c, rVar.f9853c);
    }

    public final int hashCode() {
        int iHashCode = this.f9851a.hashCode() * 31;
        s sVar = this.f9852b;
        int iHashCode2 = (iHashCode + (sVar == null ? 0 : sVar.hashCode())) * 31;
        Throwable th = this.f9853c;
        return iHashCode2 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "ConnectResult(plan=" + this.f9851a + ", nextPlan=" + this.f9852b + ", throwable=" + this.f9853c + ')';
    }

    public r(s sVar, d dVar, Throwable th) {
        this.f9851a = sVar;
        this.f9852b = dVar;
        this.f9853c = th;
    }
}
