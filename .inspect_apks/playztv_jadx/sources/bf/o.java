package bf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends xe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f2091e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f2092g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String str, p pVar, int i, long j5) {
        super(str, true);
        this.f2091e = pVar;
        this.f = i;
        this.f2092g = j5;
    }

    @Override // xe.a
    public final long a() {
        p pVar = this.f2091e;
        try {
            pVar.Q.K(this.f, this.f2092g);
            return -1L;
        } catch (IOException e10) {
            pVar.a(2, 2, e10);
            return -1L;
        }
    }
}
