package bf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends xe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f2085e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ hf.f f2086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f2087h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, p pVar, int i, hf.f fVar, int i10, boolean z2) {
        super(str, true);
        this.f2085e = pVar;
        this.f = i;
        this.f2086g = fVar;
        this.f2087h = i10;
    }

    @Override // xe.a
    public final long a() {
        try {
            a0 a0Var = this.f2085e.E;
            hf.f fVar = this.f2086g;
            int i = this.f2087h;
            a0Var.getClass();
            fVar.skip(i);
            this.f2085e.Q.H(this.f, 9);
            synchronized (this.f2085e) {
                this.f2085e.S.remove(Integer.valueOf(this.f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
