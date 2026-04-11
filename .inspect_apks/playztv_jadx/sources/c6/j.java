package c6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j f2522u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ j[] f2523v;

    /* JADX INFO: Fake field, exist only in values array */
    j EF0;

    static {
        j jVar = new j("SRGB", 0);
        j jVar2 = new j("DISPLAY_P3", 1);
        f2522u = jVar2;
        f2523v = new j[]{jVar, jVar2};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f2523v.clone();
    }
}
