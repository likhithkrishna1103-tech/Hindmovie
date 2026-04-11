package r4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j f11462u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final j f11463v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f11464w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ j[] f11465x;

    static {
        j jVar = new j("NO_OP", 0);
        f11462u = jVar;
        j jVar2 = new j("ADD", 1);
        f11463v = jVar2;
        j jVar3 = new j("REMOVE", 2);
        f11464w = jVar3;
        f11465x = new j[]{jVar, jVar2, jVar3};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f11465x.clone();
    }
}
