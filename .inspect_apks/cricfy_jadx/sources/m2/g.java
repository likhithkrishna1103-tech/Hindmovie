package m2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends t2.b {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f8051y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f8052z;

    public g(long j4, List list) {
        super(0L, list.size() - 1);
        this.f8052z = j4;
        this.f8051y = list;
    }

    @Override // t2.l
    public final long d() {
        a();
        n2.j jVar = (n2.j) this.f8051y.get((int) this.f11837x);
        return this.f8052z + jVar.f8683z + jVar.f8681x;
    }

    @Override // t2.l
    public final long j() {
        a();
        return this.f8052z + ((n2.j) this.f8051y.get((int) this.f11837x)).f8683z;
    }
}
