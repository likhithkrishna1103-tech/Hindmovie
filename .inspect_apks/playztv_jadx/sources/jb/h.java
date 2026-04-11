package jb;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements gb.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6935a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6936b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gb.c f6937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f6938d;

    public h(f fVar) {
        this.f6938d = fVar;
    }

    @Override // gb.g
    public final gb.g e(String str) {
        if (this.f6935a) {
            throw new gb.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f6935a = true;
        this.f6938d.h(this.f6937c, str, this.f6936b);
        return this;
    }

    @Override // gb.g
    public final gb.g f(boolean z2) {
        if (this.f6935a) {
            throw new gb.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f6935a = true;
        this.f6938d.f(this.f6937c, z2 ? 1 : 0, this.f6936b);
        return this;
    }
}
