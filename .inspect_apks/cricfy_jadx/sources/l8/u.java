package l8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f7921d = new u(true, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f7924c;

    public u(boolean z10, String str, Exception exc) {
        this.f7922a = z10;
        this.f7923b = str;
        this.f7924c = exc;
    }

    public static u b(String str) {
        return new u(false, str, null);
    }

    public static u c(String str, Exception exc) {
        return new u(false, str, exc);
    }

    public String a() {
        return this.f7923b;
    }
}
