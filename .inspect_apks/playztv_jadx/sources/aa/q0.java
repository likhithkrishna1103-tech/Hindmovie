package aa;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q0 implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final q0 f730u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ q0[] f731v;

    static {
        q0 q0Var = new q0("INSTANCE", 0);
        f730u = q0Var;
        f731v = new q0[]{q0Var};
    }

    public static q0 valueOf(String str) {
        return (q0) Enum.valueOf(q0.class, str);
    }

    public static q0[] values() {
        return (q0[]) f731v.clone();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        q1.c.m("no calls to next() since the last call to remove()", false);
    }
}
