package b7;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final k0 f1879u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ k0[] f1880v;

    static {
        k0 k0Var = new k0("DEFAULT", 0);
        f1879u = k0Var;
        k0 k0Var2 = new k0("UNMETERED_ONLY", 1);
        k0 k0Var3 = new k0("UNMETERED_OR_DAILY", 2);
        k0 k0Var4 = new k0("FAST_IF_RADIO_AWAKE", 3);
        k0 k0Var5 = new k0("NEVER", 4);
        k0 k0Var6 = new k0("UNRECOGNIZED", 5);
        f1880v = new k0[]{k0Var, k0Var2, k0Var3, k0Var4, k0Var5, k0Var6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, k0Var);
        sparseArray.put(1, k0Var2);
        sparseArray.put(2, k0Var3);
        sparseArray.put(3, k0Var4);
        sparseArray.put(4, k0Var5);
        sparseArray.put(-1, k0Var6);
    }

    public static k0 valueOf(String str) {
        return (k0) Enum.valueOf(k0.class, str);
    }

    public static k0[] values() {
        return (k0[]) f1880v.clone();
    }
}
