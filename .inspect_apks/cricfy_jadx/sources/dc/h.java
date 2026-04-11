package dc;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements ac.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3665a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3666b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ac.c f3667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f3668d;

    public h(f fVar) {
        this.f3668d = fVar;
    }

    @Override // ac.g
    public final ac.g e(String str) throws IOException {
        if (this.f3665a) {
            throw new ac.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f3665a = true;
        this.f3668d.h(this.f3667c, str, this.f3666b);
        return this;
    }

    @Override // ac.g
    public final ac.g f(boolean z10) throws IOException {
        if (this.f3665a) {
            throw new ac.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f3665a = true;
        this.f3668d.f(this.f3667c, z10 ? 1 : 0, this.f3666b);
        return this;
    }
}
