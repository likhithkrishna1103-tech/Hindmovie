package w4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final j f13949v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f13950w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final j f13951x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ j[] f13952y;

    static {
        j jVar = new j("NO_OP", 0);
        f13949v = jVar;
        j jVar2 = new j("ADD", 1);
        f13950w = jVar2;
        j jVar3 = new j("REMOVE", 2);
        f13951x = jVar3;
        f13952y = new j[]{jVar, jVar2, jVar3};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f13952y.clone();
    }
}
