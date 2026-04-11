package r4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final r f11488u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final r f11489v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final r f11490w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ r[] f11491x;

    static {
        r rVar = new r("AUTOMATIC", 0);
        f11488u = rVar;
        r rVar2 = new r("TRUNCATE", 1);
        f11489v = rVar2;
        r rVar3 = new r("WRITE_AHEAD_LOGGING", 2);
        f11490w = rVar3;
        f11491x = new r[]{rVar, rVar2, rVar3};
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f11491x.clone();
    }
}
