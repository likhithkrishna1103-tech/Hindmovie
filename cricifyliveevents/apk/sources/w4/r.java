package w4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final r f13986v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final r f13987w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final r f13988x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ r[] f13989y;

    static {
        r rVar = new r("AUTOMATIC", 0);
        f13986v = rVar;
        r rVar2 = new r("TRUNCATE", 1);
        f13987w = rVar2;
        r rVar3 = new r("WRITE_AHEAD_LOGGING", 2);
        f13988x = rVar3;
        f13989y = new r[]{rVar, rVar2, rVar3};
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f13989y.clone();
    }
}
