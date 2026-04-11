package f9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d4 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d4 f4080v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d4 f4081w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ d4[] f4082x;

    static {
        d4 d4Var = new d4("CONSENT", 0);
        f4080v = d4Var;
        d4 d4Var2 = new d4("LEGITIMATE_INTEREST", 1);
        d4 d4Var3 = new d4("FLEXIBLE_CONSENT", 2);
        d4 d4Var4 = new d4("FLEXIBLE_LEGITIMATE_INTEREST", 3);
        f4081w = d4Var4;
        f4082x = new d4[]{d4Var, d4Var2, d4Var3, d4Var4};
    }

    public static d4[] values() {
        return (d4[]) f4082x.clone();
    }
}
