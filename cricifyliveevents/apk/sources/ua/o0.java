package ua;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final o0 f12371v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ o0[] f12372w;

    static {
        o0 o0Var = new o0("INSTANCE", 0);
        f12371v = o0Var;
        f12372w = new o0[]{o0Var};
    }

    public static o0 valueOf(String str) {
        return (o0) Enum.valueOf(o0.class, str);
    }

    public static o0[] values() {
        return (o0[]) f12372w.clone();
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
        com.bumptech.glide.d.k("no calls to next() since the last call to remove()", false);
    }
}
