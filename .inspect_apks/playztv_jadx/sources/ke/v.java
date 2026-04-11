package ke;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final v f7736u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final v f7737v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ v[] f7738w;

    static {
        v vVar = new v("DEFAULT", 0);
        f7736u = vVar;
        v vVar2 = new v("LAZY", 1);
        v vVar3 = new v("ATOMIC", 2);
        v vVar4 = new v("UNDISPATCHED", 3);
        f7737v = vVar4;
        f7738w = new v[]{vVar, vVar2, vVar3, vVar4};
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f7738w.clone();
    }
}
