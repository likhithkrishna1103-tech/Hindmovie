package i2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6041c;

    public /* synthetic */ g(boolean z10, boolean z11, boolean z12) {
        this.f6039a = z10;
        this.f6040b = z11;
        this.f6041c = z12;
    }

    public h a() {
        if (this.f6039a || !(this.f6040b || this.f6041c)) {
            return new h(this);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }

    public boolean b() {
        return (this.f6041c || this.f6040b) && this.f6039a;
    }
}
