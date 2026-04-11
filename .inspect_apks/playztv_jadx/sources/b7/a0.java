package b7;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a0 f1829u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ a0[] f1830v;

    /* JADX INFO: Fake field, exist only in values array */
    a0 EF0;

    static {
        a0 a0Var = new a0("NOT_SET", 0);
        a0 a0Var2 = new a0("EVENT_OVERRIDE", 1);
        f1829u = a0Var2;
        f1830v = new a0[]{a0Var, a0Var2};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, a0Var);
        sparseArray.put(5, a0Var2);
    }

    public static a0 valueOf(String str) {
        return (a0) Enum.valueOf(a0.class, str);
    }

    public static a0[] values() {
        return (a0[]) f1830v.clone();
    }
}
