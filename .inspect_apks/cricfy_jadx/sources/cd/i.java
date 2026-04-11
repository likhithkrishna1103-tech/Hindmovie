package cd;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final i f2177v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final i f2178w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ i[] f2179x;

    static {
        i iVar = new i("ASC", 0);
        f2177v = iVar;
        i iVar2 = new i("DESC", 1);
        f2178w = iVar2;
        f2179x = new i[]{iVar, iVar2};
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f2179x.clone();
    }
}
